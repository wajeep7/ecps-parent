package com.rl.ecps.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class EbItem {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EB_ITEM.ITEM_ID
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    private Long itemId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EB_ITEM.ITEM_NAME
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    private String itemName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EB_ITEM.ITEM_NO
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    private String itemNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EB_ITEM.BRAND_ID
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    private Long brandId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EB_ITEM.CAT_ID
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    private Long catId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EB_ITEM.TAG_IMG_ID
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    private Long tagImgId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EB_ITEM.TAG_IMG
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    private Short tagImg;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EB_ITEM.IS_NEW
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    private Short isNew;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EB_ITEM.IS_GOOD
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    private Short isGood;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EB_ITEM.IS_HOT
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    private Short isHot;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EB_ITEM.PROMOTION
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    private String promotion;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EB_ITEM.AUDIT_STATUS
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    private Short auditStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EB_ITEM.SHOW_STATUS
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    private Short showStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EB_ITEM.IMGS
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    private String imgs;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EB_ITEM.KEYWORDS
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    private String keywords;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EB_ITEM.PAGE_DESC
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    private String pageDesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EB_ITEM.ITEM_RECYCLE
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    private Short itemRecycle;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EB_ITEM.ON_SALE_TIME
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    private Date onSaleTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EB_ITEM.CHECK_TIME
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    private Date checkTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EB_ITEM.UPDATE_TIME
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EB_ITEM.UPDATE_USER_ID
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    private Long updateUserId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EB_ITEM.CREATE_TIME
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EB_ITEM.CHECKER_USER_ID
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    private Long checkerUserId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EB_ITEM.FULL_PATH_DEPLOY
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    private String fullPathDeploy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EB_ITEM.FULL_PATH_DEPLOY_OFFER
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    private String fullPathDeployOffer;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EB_ITEM.ORIGINAL_ITEM_ID
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    private Long originalItemId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EB_ITEM.LAST_STATUS
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    private Short lastStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EB_ITEM.MERCHANT_ID
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    private Long merchantId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EB_ITEM.ITEM_SORT
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    private Long itemSort;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EB_ITEM.SALES
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    private Long sales;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EB_ITEM.CREATE_USER_ID
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    private Long createUserId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EB_ITEM.SIM_LEVEL
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    private Short simLevel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EB_ITEM.GIFT_DESC
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    private String giftDesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EB_ITEM.GIFT_IMG
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    private String giftImg;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EB_ITEM.GIFT_SHOW_TYPE
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    private String giftShowType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EB_ITEM.IMG_SIZE1
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    private String imgSize1;


    /**
     * 表与表之间关系构建 开始
     *
     *
     *
     */

    private EbItemClob ebItemClob;

    //普通属性
    private List<EbParaValue>paraList;

    private List<EbSku>skuList;

    private BigDecimal skuprice;

    public BigDecimal getSkuprice() {
        return skuprice;
    }

    public void setSkuprice(BigDecimal skuprice) {
        this.skuprice = skuprice;
    }

//关系配置结束

    public List<EbSku> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<EbSku> skuList) {
        this.skuList = skuList;
    }

    public EbItemClob getEbItemClob() {
        return ebItemClob;
    }

    public void setEbItemClob(EbItemClob ebItemClob) {
        this.ebItemClob = ebItemClob;
    }

    public List<EbParaValue> getParaList() {
        return paraList;
    }

    public void setParaList(List<EbParaValue> paraList) {
        this.paraList = paraList;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EB_ITEM.ITEM_ID
     *
     * @return the value of EB_ITEM.ITEM_ID
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public Long getItemId() {
        return itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EB_ITEM.ITEM_ID
     *
     * @param itemId the value for EB_ITEM.ITEM_ID
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EB_ITEM.ITEM_NAME
     *
     * @return the value of EB_ITEM.ITEM_NAME
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EB_ITEM.ITEM_NAME
     *
     * @param itemName the value for EB_ITEM.ITEM_NAME
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EB_ITEM.ITEM_NO
     *
     * @return the value of EB_ITEM.ITEM_NO
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public String getItemNo() {
        return itemNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EB_ITEM.ITEM_NO
     *
     * @param itemNo the value for EB_ITEM.ITEM_NO
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EB_ITEM.BRAND_ID
     *
     * @return the value of EB_ITEM.BRAND_ID
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public Long getBrandId() {
        return brandId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EB_ITEM.BRAND_ID
     *
     * @param brandId the value for EB_ITEM.BRAND_ID
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EB_ITEM.CAT_ID
     *
     * @return the value of EB_ITEM.CAT_ID
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public Long getCatId() {
        return catId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EB_ITEM.CAT_ID
     *
     * @param catId the value for EB_ITEM.CAT_ID
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public void setCatId(Long catId) {
        this.catId = catId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EB_ITEM.TAG_IMG_ID
     *
     * @return the value of EB_ITEM.TAG_IMG_ID
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public Long getTagImgId() {
        return tagImgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EB_ITEM.TAG_IMG_ID
     *
     * @param tagImgId the value for EB_ITEM.TAG_IMG_ID
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public void setTagImgId(Long tagImgId) {
        this.tagImgId = tagImgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EB_ITEM.TAG_IMG
     *
     * @return the value of EB_ITEM.TAG_IMG
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public Short getTagImg() {
        return tagImg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EB_ITEM.TAG_IMG
     *
     * @param tagImg the value for EB_ITEM.TAG_IMG
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public void setTagImg(Short tagImg) {
        this.tagImg = tagImg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EB_ITEM.IS_NEW
     *
     * @return the value of EB_ITEM.IS_NEW
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public Short getIsNew() {
        return isNew;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EB_ITEM.IS_NEW
     *
     * @param isNew the value for EB_ITEM.IS_NEW
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public void setIsNew(Short isNew) {
        this.isNew = isNew;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EB_ITEM.IS_GOOD
     *
     * @return the value of EB_ITEM.IS_GOOD
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public Short getIsGood() {
        return isGood;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EB_ITEM.IS_GOOD
     *
     * @param isGood the value for EB_ITEM.IS_GOOD
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public void setIsGood(Short isGood) {
        this.isGood = isGood;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EB_ITEM.IS_HOT
     *
     * @return the value of EB_ITEM.IS_HOT
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public Short getIsHot() {
        return isHot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EB_ITEM.IS_HOT
     *
     * @param isHot the value for EB_ITEM.IS_HOT
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public void setIsHot(Short isHot) {
        this.isHot = isHot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EB_ITEM.PROMOTION
     *
     * @return the value of EB_ITEM.PROMOTION
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public String getPromotion() {
        return promotion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EB_ITEM.PROMOTION
     *
     * @param promotion the value for EB_ITEM.PROMOTION
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EB_ITEM.AUDIT_STATUS
     *
     * @return the value of EB_ITEM.AUDIT_STATUS
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public Short getAuditStatus() {
        return auditStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EB_ITEM.AUDIT_STATUS
     *
     * @param auditStatus the value for EB_ITEM.AUDIT_STATUS
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public void setAuditStatus(Short auditStatus) {
        this.auditStatus = auditStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EB_ITEM.SHOW_STATUS
     *
     * @return the value of EB_ITEM.SHOW_STATUS
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public Short getShowStatus() {
        return showStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EB_ITEM.SHOW_STATUS
     *
     * @param showStatus the value for EB_ITEM.SHOW_STATUS
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public void setShowStatus(Short showStatus) {
        this.showStatus = showStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EB_ITEM.IMGS
     *
     * @return the value of EB_ITEM.IMGS
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public String getImgs() {
        return imgs;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EB_ITEM.IMGS
     *
     * @param imgs the value for EB_ITEM.IMGS
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EB_ITEM.KEYWORDS
     *
     * @return the value of EB_ITEM.KEYWORDS
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EB_ITEM.KEYWORDS
     *
     * @param keywords the value for EB_ITEM.KEYWORDS
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EB_ITEM.PAGE_DESC
     *
     * @return the value of EB_ITEM.PAGE_DESC
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public String getPageDesc() {
        return pageDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EB_ITEM.PAGE_DESC
     *
     * @param pageDesc the value for EB_ITEM.PAGE_DESC
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public void setPageDesc(String pageDesc) {
        this.pageDesc = pageDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EB_ITEM.ITEM_RECYCLE
     *
     * @return the value of EB_ITEM.ITEM_RECYCLE
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public Short getItemRecycle() {
        return itemRecycle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EB_ITEM.ITEM_RECYCLE
     *
     * @param itemRecycle the value for EB_ITEM.ITEM_RECYCLE
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public void setItemRecycle(Short itemRecycle) {
        this.itemRecycle = itemRecycle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EB_ITEM.ON_SALE_TIME
     *
     * @return the value of EB_ITEM.ON_SALE_TIME
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public Date getOnSaleTime() {
        return onSaleTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EB_ITEM.ON_SALE_TIME
     *
     * @param onSaleTime the value for EB_ITEM.ON_SALE_TIME
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public void setOnSaleTime(Date onSaleTime) {
        this.onSaleTime = onSaleTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EB_ITEM.CHECK_TIME
     *
     * @return the value of EB_ITEM.CHECK_TIME
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public Date getCheckTime() {
        return checkTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EB_ITEM.CHECK_TIME
     *
     * @param checkTime the value for EB_ITEM.CHECK_TIME
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EB_ITEM.UPDATE_TIME
     *
     * @return the value of EB_ITEM.UPDATE_TIME
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EB_ITEM.UPDATE_TIME
     *
     * @param updateTime the value for EB_ITEM.UPDATE_TIME
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EB_ITEM.UPDATE_USER_ID
     *
     * @return the value of EB_ITEM.UPDATE_USER_ID
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public Long getUpdateUserId() {
        return updateUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EB_ITEM.UPDATE_USER_ID
     *
     * @param updateUserId the value for EB_ITEM.UPDATE_USER_ID
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EB_ITEM.CREATE_TIME
     *
     * @return the value of EB_ITEM.CREATE_TIME
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EB_ITEM.CREATE_TIME
     *
     * @param createTime the value for EB_ITEM.CREATE_TIME
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EB_ITEM.CHECKER_USER_ID
     *
     * @return the value of EB_ITEM.CHECKER_USER_ID
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public Long getCheckerUserId() {
        return checkerUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EB_ITEM.CHECKER_USER_ID
     *
     * @param checkerUserId the value for EB_ITEM.CHECKER_USER_ID
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public void setCheckerUserId(Long checkerUserId) {
        this.checkerUserId = checkerUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EB_ITEM.FULL_PATH_DEPLOY
     *
     * @return the value of EB_ITEM.FULL_PATH_DEPLOY
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public String getFullPathDeploy() {
        return fullPathDeploy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EB_ITEM.FULL_PATH_DEPLOY
     *
     * @param fullPathDeploy the value for EB_ITEM.FULL_PATH_DEPLOY
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public void setFullPathDeploy(String fullPathDeploy) {
        this.fullPathDeploy = fullPathDeploy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EB_ITEM.FULL_PATH_DEPLOY_OFFER
     *
     * @return the value of EB_ITEM.FULL_PATH_DEPLOY_OFFER
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public String getFullPathDeployOffer() {
        return fullPathDeployOffer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EB_ITEM.FULL_PATH_DEPLOY_OFFER
     *
     * @param fullPathDeployOffer the value for EB_ITEM.FULL_PATH_DEPLOY_OFFER
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public void setFullPathDeployOffer(String fullPathDeployOffer) {
        this.fullPathDeployOffer = fullPathDeployOffer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EB_ITEM.ORIGINAL_ITEM_ID
     *
     * @return the value of EB_ITEM.ORIGINAL_ITEM_ID
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public Long getOriginalItemId() {
        return originalItemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EB_ITEM.ORIGINAL_ITEM_ID
     *
     * @param originalItemId the value for EB_ITEM.ORIGINAL_ITEM_ID
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public void setOriginalItemId(Long originalItemId) {
        this.originalItemId = originalItemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EB_ITEM.LAST_STATUS
     *
     * @return the value of EB_ITEM.LAST_STATUS
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public Short getLastStatus() {
        return lastStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EB_ITEM.LAST_STATUS
     *
     * @param lastStatus the value for EB_ITEM.LAST_STATUS
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public void setLastStatus(Short lastStatus) {
        this.lastStatus = lastStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EB_ITEM.MERCHANT_ID
     *
     * @return the value of EB_ITEM.MERCHANT_ID
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public Long getMerchantId() {
        return merchantId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EB_ITEM.MERCHANT_ID
     *
     * @param merchantId the value for EB_ITEM.MERCHANT_ID
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EB_ITEM.ITEM_SORT
     *
     * @return the value of EB_ITEM.ITEM_SORT
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public Long getItemSort() {
        return itemSort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EB_ITEM.ITEM_SORT
     *
     * @param itemSort the value for EB_ITEM.ITEM_SORT
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public void setItemSort(Long itemSort) {
        this.itemSort = itemSort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EB_ITEM.SALES
     *
     * @return the value of EB_ITEM.SALES
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public Long getSales() {
        return sales;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EB_ITEM.SALES
     *
     * @param sales the value for EB_ITEM.SALES
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public void setSales(Long sales) {
        this.sales = sales;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EB_ITEM.CREATE_USER_ID
     *
     * @return the value of EB_ITEM.CREATE_USER_ID
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public Long getCreateUserId() {
        return createUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EB_ITEM.CREATE_USER_ID
     *
     * @param createUserId the value for EB_ITEM.CREATE_USER_ID
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EB_ITEM.SIM_LEVEL
     *
     * @return the value of EB_ITEM.SIM_LEVEL
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public Short getSimLevel() {
        return simLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EB_ITEM.SIM_LEVEL
     *
     * @param simLevel the value for EB_ITEM.SIM_LEVEL
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public void setSimLevel(Short simLevel) {
        this.simLevel = simLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EB_ITEM.GIFT_DESC
     *
     * @return the value of EB_ITEM.GIFT_DESC
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public String getGiftDesc() {
        return giftDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EB_ITEM.GIFT_DESC
     *
     * @param giftDesc the value for EB_ITEM.GIFT_DESC
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public void setGiftDesc(String giftDesc) {
        this.giftDesc = giftDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EB_ITEM.GIFT_IMG
     *
     * @return the value of EB_ITEM.GIFT_IMG
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public String getGiftImg() {
        return giftImg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EB_ITEM.GIFT_IMG
     *
     * @param giftImg the value for EB_ITEM.GIFT_IMG
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public void setGiftImg(String giftImg) {
        this.giftImg = giftImg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EB_ITEM.GIFT_SHOW_TYPE
     *
     * @return the value of EB_ITEM.GIFT_SHOW_TYPE
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public String getGiftShowType() {
        return giftShowType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EB_ITEM.GIFT_SHOW_TYPE
     *
     * @param giftShowType the value for EB_ITEM.GIFT_SHOW_TYPE
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public void setGiftShowType(String giftShowType) {
        this.giftShowType = giftShowType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EB_ITEM.IMG_SIZE1
     *
     * @return the value of EB_ITEM.IMG_SIZE1
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public String getImgSize1() {
        return imgSize1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EB_ITEM.IMG_SIZE1
     *
     * @param imgSize1 the value for EB_ITEM.IMG_SIZE1
     *
     * @mbggenerated Wed Oct 16 04:07:38 CST 2019
     */
    public void setImgSize1(String imgSize1) {
        this.imgSize1 = imgSize1;
    }
}