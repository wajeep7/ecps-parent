package generate;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * EB_V_ITEMPRICEVIEW
 * @author 
 */
@Data
public class EbVItempriceview implements Serializable {
    private Long itemId;

    private BigDecimal minskuprice;

    private BigDecimal maxskuprice;

    private BigDecimal minmarketprice;

    private BigDecimal maxmarketprice;

    private static final long serialVersionUID = 1L;
}