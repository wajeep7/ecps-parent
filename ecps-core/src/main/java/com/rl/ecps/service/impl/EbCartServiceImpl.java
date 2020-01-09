package com.rl.ecps.service.impl;

import com.rl.ecps.model.EbCart;
import com.rl.ecps.model.EbItem;
import com.rl.ecps.model.EbSku;
import com.rl.ecps.model.EbSpecValue;
import com.rl.ecps.service.EbCartService;
import com.rl.ecps.service.EbSkuService;
import com.rl.ecps.utils.EcpsUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Service
public class EbCartServiceImpl implements EbCartService {
    @Autowired
    private EbSkuService skuService;


    @Override
    public void addCart(HttpServletRequest request, HttpServletResponse response, Long skuId, Integer quantity) {
        /*JSONArray cartList= new JSONArray(); IDEA推荐*/


        List<EbCart> cartList = new ArrayList<EbCart>();

        //jc 调用 使用当前类   排除那些键
        JsonConfig jc = new JsonConfig();
        //root 设置选择 EBcart 这个类
        jc.setRootClass(EbCart.class);
        //excludes 排除这个键 接收参数为数组
        jc.setExcludes(new String[]{"sku"});

        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            //有cookies
            for (Cookie cookie : cookies) {
                //拿到当前浏览器的cookie name
                String cookieName = cookie.getName();
                if (StringUtils.equals(cookieName, EcpsUtils.getPropByKey("cookie_name"))) {
                    //当cookieName比较成功的时候 这名我在这个对象中可以取值 才可以取值 进行  设置 排除 转换为JSON
                    String value = cookie.getValue();
                    // cookie 值需要解码。。 解码成String
                    value = URLDecoder.decode(value);
                    //把解码后的值转换为JSON

                    @SuppressWarnings("AccessStaticViaInstance")
                    JSONArray jaValue = new JSONArray().fromObject(value);
                    //调用序列化JSON 将 json转换为集合

                    cartList = (List<EbCart>) JSONSerializer.toJava(jaValue, jc);

                    //标识
                    boolean isExist = false;

                    for (EbCart cart : cartList) {
                        //如果cookie 中便利出来的对象 的SKUID 和 我的前台传入的 是一样的  那么我开始计算 小计累加
                        if (cart.getSkuId().longValue() == skuId.longValue()) {
                            cart.setQuantity(cart.getQuantity() + quantity);
                            isExist = true;
                            break;
                        }
                    }
                    //cookie 是不存在的
                    if (!isExist) {
                        EbCart cart = new EbCart();
                        cart.setSkuId(skuId);
                        cart.setQuantity(quantity);
                        cartList.add(cart);
                    }
                } else {
                    EbCart cart = new EbCart();
                    cart.setSkuId(skuId);
                    cart.setQuantity(quantity);
                    cartList.add(cart);
                }
            }
        }

        //如果COOKIE 是空的把他赋值 并相应回去  合并操作
        @SuppressWarnings("AccessStaticViaInstance")
        JSONArray jaValue = new JSONArray().fromObject(cartList, jc);
        String cookieStr = jaValue.toString();
        //编码
        String cookie = URLEncoder.encode(cookieStr);
        //设置新的cook 键值对
        Cookie cook = new Cookie(EcpsUtils.getPropByKey("cookie_name"), cookie);
        cook.setMaxAge(Integer.MAX_VALUE);
        cook.setPath("/");
        response.addCookie(cook);

    }

    @Override
    public List<EbCart> selectCart(HttpServletRequest request, HttpServletResponse response) {
        List<EbCart> cartList = new ArrayList<EbCart>();
        //jc 调用 使用当前类   排除那些键
        JsonConfig jc = new JsonConfig();
        //root 设置选择 EBcart 这个类
        jc.setRootClass(EbCart.class);
        //excludes 排除这个键 接收参数为数组
        jc.setExcludes(new String[]{"sku"});
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            //有cookies
            for (Cookie cookie : cookies) {
                //拿到当前浏览器的cookie name
                String cookieName = cookie.getName();
                if (StringUtils.equals(cookieName, EcpsUtils.getPropByKey("cookie_name"))) {
                    //当cookieName比较成功的时候 这名我在这个对象中可以取值 才可以取值 进行  设置 排除 转换为JSON
                    String value = cookie.getValue();
                    // cookie 值需要解码。。 解码成String
                    value = URLDecoder.decode(value);
                    //把解码后的值转换为JSON
                    @SuppressWarnings("AccessStaticViaInstance")
                    JSONArray jaValue = new JSONArray().fromObject(value);
                    //调用序列化JSON 将 json转换为集合
                    cartList = (List<EbCart>) JSONSerializer.toJava(jaValue, jc);
                    for (EbCart cart : cartList) {
                        EbSku sku = skuService.selectSkuWithRedisDetail(cart.getSkuId());
                        cart.setSku(sku);

                    }

                }
            }
        }
        return cartList;
    }

    @Override
    public void delectCart(HttpServletRequest request, HttpServletResponse response, Long skuId) {
        List<EbCart> cartList = new ArrayList<EbCart>();
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setRootClass(EbCart.class);
        jsonConfig.setExcludes(new String[]{"sku"});
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                String cookieName = cookie.getName();
                if (StringUtils.equals(cookieName, EcpsUtils.getPropByKey("cookie_name"))) {
                    String cookieValue = cookie.getValue();
                    cookieValue = URLDecoder.decode(cookieValue);
                    JSONArray jsValue = new JSONArray().fromObject(cookieValue);
                    cartList = (List<EbCart>) JSONSerializer.toJava(jsValue, jsonConfig);
                    for (int i = 0; i < cartList.size(); i++) {
                        if (cartList.get(i).getSkuId().longValue() == skuId.longValue()) {
                            EbCart cart = cartList.get(i);
                            cartList.remove(cart);
                            break;
                        }
                    }
                }
            }
        }

        JSONArray jaValue = new JSONArray().fromObject(cartList, jsonConfig);
        String cookieStr = jaValue.toString();
        //编码
        String cookie = URLEncoder.encode(cookieStr);
        //设置新的cook 键值对
        Cookie cook = new Cookie(EcpsUtils.getPropByKey("cookie_name"), cookie);
        cook.setMaxAge(Integer.MAX_VALUE);
        cook.setPath("/");
        response.addCookie(cook);

    }

    @Override
    public void ModifyCart(HttpServletRequest request, HttpServletResponse response, Long skuId, Integer mdQuantity) {
        List<EbCart> cartList = new ArrayList<EbCart>();
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setRootClass(EbCart.class);
        jsonConfig.setExcludes(new String[]{"sku"});
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                String cookieName = cookie.getName();
                if (StringUtils.equals(cookieName, EcpsUtils.getPropByKey("cookie_name"))) {
                    String cookieValue = cookie.getValue();
                    cookieValue = URLDecoder.decode(cookieValue);
                    JSONArray jsonValue = JSONArray.fromObject(cookieValue);
                    cartList = (List<EbCart>) JSONSerializer.toJava(jsonValue, jsonConfig);
                    if (cartList != null) {
                        for (int i = 0; i < cartList.size(); i++) {
                            EbCart ebCart = cartList.get(i);
                            if (ebCart.getSkuId().longValue() == skuId.longValue()) {
                                ebCart.setQuantity(mdQuantity);
                                break;
                            }
                        }
                    }

                }
            }
        }

        JSONArray jaValue = new JSONArray().fromObject(cartList, jsonConfig);
        String cookieStr = jaValue.toString();
        //编码
        String cookie = URLEncoder.encode(cookieStr);
        //设置新的cook 键值对
        Cookie cook = new Cookie(EcpsUtils.getPropByKey("cookie_name"), cookie);
        cook.setMaxAge(Integer.MAX_VALUE);
        cook.setPath("/");
        response.addCookie(cook);


    }


    @Override
    public void cleatCart(HttpServletRequest request, HttpServletResponse response) {
        List<EbCart> cartList = new ArrayList<EbCart>();
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setRootClass(EbCart.class);
        jsonConfig.setExcludes(new String[]{"sku"});
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                String cookieName = cookie.getName();
                if (StringUtils.equals(cookieName, EcpsUtils.getPropByKey("cookie_name"))) {
                    String cookieValue = cookie.getValue();
                    cookieValue = URLDecoder.decode(cookieValue);
                    JSONArray jsValue = JSONArray.fromObject(cookieValue);
                    //通过request 拿到 cookies 把cookies 转换成字符串 在用json 将字符串转换成js 数据。 最后根据排除序列化给集合赋值
                    cartList = (List<EbCart>) JSONSerializer.toJava(jsValue, jsonConfig);
                    cartList.clear();

                }
            }
        }

        JSONArray jsonValue = JSONArray.fromObject(cartList, jsonConfig);
        String jsStr = jsonValue.toString();
        String cookiesUrl = URLEncoder.encode(jsStr);
        //设置新的cookie
        Cookie cookie = new Cookie(EcpsUtils.getPropByKey("cookie_name"), cookiesUrl);
        cookie.setMaxAge(Integer.MAX_VALUE);
        cookie.setPath("/");
        response.addCookie(cookie);


    }

    @Override
    public String validCartStock(HttpServletRequest request, HttpServletResponse response) {

        String result = "success";
        List<EbCart> cartList = new ArrayList<EbCart>();
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setRootClass(EbCart.class);
        jsonConfig.setExcludes(new String[]{"sku"});
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            String cookieName = cookie.getName();
            if (StringUtils.equals(cookieName, EcpsUtils.getPropByKey("cookie_name"))) {
                String cookieValue = cookie.getValue();
                String strCookieValue = URLDecoder.decode(cookieValue);
                JSONArray jsonValue = JSONArray.fromObject(strCookieValue);
                cartList = (List<EbCart>) JSONSerializer.toJava(jsonValue, jsonConfig);
                for (EbCart cart : cartList) {
                    EbSku sku = skuService.selectSkuBySkuId(cart.getSkuId());
                    if (sku.getStockInventory() < cart.getQuantity()) {
                        EbItem item = sku.getItem();
                        result = item.getItemName();
                        for (EbSpecValue spec : sku.getSpecList()) {
                            result = result + spec.getSpecValue();
                        }
                        result = result + "库存不足" + cart.getQuantity() + "个," + "实际库存" + sku.getStockInventory() + "个";
                    }

                }
            }
        }


        return result;
    }


}
