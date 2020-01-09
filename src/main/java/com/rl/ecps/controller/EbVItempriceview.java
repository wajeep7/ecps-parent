package com.rl.ecps.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * EB_V_ITEMPRICEVIEW
 * @author 
 */
@Table(name="EB_V_ITEMPRICEVIEW")
@Data
public class EbVItempriceview implements Serializable {
    @NotEmpty
    private Long ITEM_ID;

    private BigDecimal MINSKUPRICE;

    private BigDecimal MAXSKUPRICE;

    private BigDecimal MINMARKETPRICE;

    private BigDecimal MAXMARKETPRICE;

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        EbVItempriceview other = (EbVItempriceview) that;
        return (this.getITEM_ID() == null ? other.getITEM_ID() == null : this.getITEM_ID().equals(other.getITEM_ID()))
            && (this.getMINSKUPRICE() == null ? other.getMINSKUPRICE() == null : this.getMINSKUPRICE().equals(other.getMINSKUPRICE()))
            && (this.getMAXSKUPRICE() == null ? other.getMAXSKUPRICE() == null : this.getMAXSKUPRICE().equals(other.getMAXSKUPRICE()))
            && (this.getMINMARKETPRICE() == null ? other.getMINMARKETPRICE() == null : this.getMINMARKETPRICE().equals(other.getMINMARKETPRICE()))
            && (this.getMAXMARKETPRICE() == null ? other.getMAXMARKETPRICE() == null : this.getMAXMARKETPRICE().equals(other.getMAXMARKETPRICE()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getITEM_ID() == null) ? 0 : getITEM_ID().hashCode());
        result = prime * result + ((getMINSKUPRICE() == null) ? 0 : getMINSKUPRICE().hashCode());
        result = prime * result + ((getMAXSKUPRICE() == null) ? 0 : getMAXSKUPRICE().hashCode());
        result = prime * result + ((getMINMARKETPRICE() == null) ? 0 : getMINMARKETPRICE().hashCode());
        result = prime * result + ((getMAXMARKETPRICE() == null) ? 0 : getMAXMARKETPRICE().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ITEM_ID=").append(ITEM_ID);
        sb.append(", MINSKUPRICE=").append(MINSKUPRICE);
        sb.append(", MAXSKUPRICE=").append(MAXSKUPRICE);
        sb.append(", MINMARKETPRICE=").append(MINMARKETPRICE);
        sb.append(", MAXMARKETPRICE=").append(MAXMARKETPRICE);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}