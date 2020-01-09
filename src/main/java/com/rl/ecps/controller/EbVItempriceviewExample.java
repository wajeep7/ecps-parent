package com.rl.ecps.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

public class EbVItempriceviewExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EbVItempriceviewExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andITEM_IDIsNull() {
            addCriterion("ITEM_ID is null");
            return (Criteria) this;
        }

        public Criteria andITEM_IDIsNotNull() {
            addCriterion("ITEM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andITEM_IDEqualTo(Long value) {
            addCriterion("ITEM_ID =", value, "ITEM_ID");
            return (Criteria) this;
        }

        public Criteria andITEM_IDNotEqualTo(Long value) {
            addCriterion("ITEM_ID <>", value, "ITEM_ID");
            return (Criteria) this;
        }

        public Criteria andITEM_IDGreaterThan(Long value) {
            addCriterion("ITEM_ID >", value, "ITEM_ID");
            return (Criteria) this;
        }

        public Criteria andITEM_IDGreaterThanOrEqualTo(Long value) {
            addCriterion("ITEM_ID >=", value, "ITEM_ID");
            return (Criteria) this;
        }

        public Criteria andITEM_IDLessThan(Long value) {
            addCriterion("ITEM_ID <", value, "ITEM_ID");
            return (Criteria) this;
        }

        public Criteria andITEM_IDLessThanOrEqualTo(Long value) {
            addCriterion("ITEM_ID <=", value, "ITEM_ID");
            return (Criteria) this;
        }

        public Criteria andITEM_IDIn(List<Long> values) {
            addCriterion("ITEM_ID in", values, "ITEM_ID");
            return (Criteria) this;
        }

        public Criteria andITEM_IDNotIn(List<Long> values) {
            addCriterion("ITEM_ID not in", values, "ITEM_ID");
            return (Criteria) this;
        }

        public Criteria andITEM_IDBetween(Long value1, Long value2) {
            addCriterion("ITEM_ID between", value1, value2, "ITEM_ID");
            return (Criteria) this;
        }

        public Criteria andITEM_IDNotBetween(Long value1, Long value2) {
            addCriterion("ITEM_ID not between", value1, value2, "ITEM_ID");
            return (Criteria) this;
        }

        public Criteria andMINSKUPRICEIsNull() {
            addCriterion("MINSKUPRICE is null");
            return (Criteria) this;
        }

        public Criteria andMINSKUPRICEIsNotNull() {
            addCriterion("MINSKUPRICE is not null");
            return (Criteria) this;
        }

        public Criteria andMINSKUPRICEEqualTo(BigDecimal value) {
            addCriterion("MINSKUPRICE =", value, "MINSKUPRICE");
            return (Criteria) this;
        }

        public Criteria andMINSKUPRICENotEqualTo(BigDecimal value) {
            addCriterion("MINSKUPRICE <>", value, "MINSKUPRICE");
            return (Criteria) this;
        }

        public Criteria andMINSKUPRICEGreaterThan(BigDecimal value) {
            addCriterion("MINSKUPRICE >", value, "MINSKUPRICE");
            return (Criteria) this;
        }

        public Criteria andMINSKUPRICEGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MINSKUPRICE >=", value, "MINSKUPRICE");
            return (Criteria) this;
        }

        public Criteria andMINSKUPRICELessThan(BigDecimal value) {
            addCriterion("MINSKUPRICE <", value, "MINSKUPRICE");
            return (Criteria) this;
        }

        public Criteria andMINSKUPRICELessThanOrEqualTo(BigDecimal value) {
            addCriterion("MINSKUPRICE <=", value, "MINSKUPRICE");
            return (Criteria) this;
        }

        public Criteria andMINSKUPRICEIn(List<BigDecimal> values) {
            addCriterion("MINSKUPRICE in", values, "MINSKUPRICE");
            return (Criteria) this;
        }

        public Criteria andMINSKUPRICENotIn(List<BigDecimal> values) {
            addCriterion("MINSKUPRICE not in", values, "MINSKUPRICE");
            return (Criteria) this;
        }

        public Criteria andMINSKUPRICEBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MINSKUPRICE between", value1, value2, "MINSKUPRICE");
            return (Criteria) this;
        }

        public Criteria andMINSKUPRICENotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MINSKUPRICE not between", value1, value2, "MINSKUPRICE");
            return (Criteria) this;
        }

        public Criteria andMAXSKUPRICEIsNull() {
            addCriterion("MAXSKUPRICE is null");
            return (Criteria) this;
        }

        public Criteria andMAXSKUPRICEIsNotNull() {
            addCriterion("MAXSKUPRICE is not null");
            return (Criteria) this;
        }

        public Criteria andMAXSKUPRICEEqualTo(BigDecimal value) {
            addCriterion("MAXSKUPRICE =", value, "MAXSKUPRICE");
            return (Criteria) this;
        }

        public Criteria andMAXSKUPRICENotEqualTo(BigDecimal value) {
            addCriterion("MAXSKUPRICE <>", value, "MAXSKUPRICE");
            return (Criteria) this;
        }

        public Criteria andMAXSKUPRICEGreaterThan(BigDecimal value) {
            addCriterion("MAXSKUPRICE >", value, "MAXSKUPRICE");
            return (Criteria) this;
        }

        public Criteria andMAXSKUPRICEGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MAXSKUPRICE >=", value, "MAXSKUPRICE");
            return (Criteria) this;
        }

        public Criteria andMAXSKUPRICELessThan(BigDecimal value) {
            addCriterion("MAXSKUPRICE <", value, "MAXSKUPRICE");
            return (Criteria) this;
        }

        public Criteria andMAXSKUPRICELessThanOrEqualTo(BigDecimal value) {
            addCriterion("MAXSKUPRICE <=", value, "MAXSKUPRICE");
            return (Criteria) this;
        }

        public Criteria andMAXSKUPRICEIn(List<BigDecimal> values) {
            addCriterion("MAXSKUPRICE in", values, "MAXSKUPRICE");
            return (Criteria) this;
        }

        public Criteria andMAXSKUPRICENotIn(List<BigDecimal> values) {
            addCriterion("MAXSKUPRICE not in", values, "MAXSKUPRICE");
            return (Criteria) this;
        }

        public Criteria andMAXSKUPRICEBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MAXSKUPRICE between", value1, value2, "MAXSKUPRICE");
            return (Criteria) this;
        }

        public Criteria andMAXSKUPRICENotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MAXSKUPRICE not between", value1, value2, "MAXSKUPRICE");
            return (Criteria) this;
        }

        public Criteria andMINMARKETPRICEIsNull() {
            addCriterion("MINMARKETPRICE is null");
            return (Criteria) this;
        }

        public Criteria andMINMARKETPRICEIsNotNull() {
            addCriterion("MINMARKETPRICE is not null");
            return (Criteria) this;
        }

        public Criteria andMINMARKETPRICEEqualTo(BigDecimal value) {
            addCriterion("MINMARKETPRICE =", value, "MINMARKETPRICE");
            return (Criteria) this;
        }

        public Criteria andMINMARKETPRICENotEqualTo(BigDecimal value) {
            addCriterion("MINMARKETPRICE <>", value, "MINMARKETPRICE");
            return (Criteria) this;
        }

        public Criteria andMINMARKETPRICEGreaterThan(BigDecimal value) {
            addCriterion("MINMARKETPRICE >", value, "MINMARKETPRICE");
            return (Criteria) this;
        }

        public Criteria andMINMARKETPRICEGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MINMARKETPRICE >=", value, "MINMARKETPRICE");
            return (Criteria) this;
        }

        public Criteria andMINMARKETPRICELessThan(BigDecimal value) {
            addCriterion("MINMARKETPRICE <", value, "MINMARKETPRICE");
            return (Criteria) this;
        }

        public Criteria andMINMARKETPRICELessThanOrEqualTo(BigDecimal value) {
            addCriterion("MINMARKETPRICE <=", value, "MINMARKETPRICE");
            return (Criteria) this;
        }

        public Criteria andMINMARKETPRICEIn(List<BigDecimal> values) {
            addCriterion("MINMARKETPRICE in", values, "MINMARKETPRICE");
            return (Criteria) this;
        }

        public Criteria andMINMARKETPRICENotIn(List<BigDecimal> values) {
            addCriterion("MINMARKETPRICE not in", values, "MINMARKETPRICE");
            return (Criteria) this;
        }

        public Criteria andMINMARKETPRICEBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MINMARKETPRICE between", value1, value2, "MINMARKETPRICE");
            return (Criteria) this;
        }

        public Criteria andMINMARKETPRICENotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MINMARKETPRICE not between", value1, value2, "MINMARKETPRICE");
            return (Criteria) this;
        }

        public Criteria andMAXMARKETPRICEIsNull() {
            addCriterion("MAXMARKETPRICE is null");
            return (Criteria) this;
        }

        public Criteria andMAXMARKETPRICEIsNotNull() {
            addCriterion("MAXMARKETPRICE is not null");
            return (Criteria) this;
        }

        public Criteria andMAXMARKETPRICEEqualTo(BigDecimal value) {
            addCriterion("MAXMARKETPRICE =", value, "MAXMARKETPRICE");
            return (Criteria) this;
        }

        public Criteria andMAXMARKETPRICENotEqualTo(BigDecimal value) {
            addCriterion("MAXMARKETPRICE <>", value, "MAXMARKETPRICE");
            return (Criteria) this;
        }

        public Criteria andMAXMARKETPRICEGreaterThan(BigDecimal value) {
            addCriterion("MAXMARKETPRICE >", value, "MAXMARKETPRICE");
            return (Criteria) this;
        }

        public Criteria andMAXMARKETPRICEGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MAXMARKETPRICE >=", value, "MAXMARKETPRICE");
            return (Criteria) this;
        }

        public Criteria andMAXMARKETPRICELessThan(BigDecimal value) {
            addCriterion("MAXMARKETPRICE <", value, "MAXMARKETPRICE");
            return (Criteria) this;
        }

        public Criteria andMAXMARKETPRICELessThanOrEqualTo(BigDecimal value) {
            addCriterion("MAXMARKETPRICE <=", value, "MAXMARKETPRICE");
            return (Criteria) this;
        }

        public Criteria andMAXMARKETPRICEIn(List<BigDecimal> values) {
            addCriterion("MAXMARKETPRICE in", values, "MAXMARKETPRICE");
            return (Criteria) this;
        }

        public Criteria andMAXMARKETPRICENotIn(List<BigDecimal> values) {
            addCriterion("MAXMARKETPRICE not in", values, "MAXMARKETPRICE");
            return (Criteria) this;
        }

        public Criteria andMAXMARKETPRICEBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MAXMARKETPRICE between", value1, value2, "MAXMARKETPRICE");
            return (Criteria) this;
        }

        public Criteria andMAXMARKETPRICENotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MAXMARKETPRICE not between", value1, value2, "MAXMARKETPRICE");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}