package com.pdsu.pojo;

import java.util.ArrayList;
import java.util.List;

public class CenterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CenterExample() {
        oredCriteria = new ArrayList<Criteria>();
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

    /**
     * 首页信息表
     * 
     * @author wcyong
     * 
     * @date 2019-03-16
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
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

        public Criteria andCenterIdIsNull() {
            addCriterion("center_id is null");
            return (Criteria) this;
        }

        public Criteria andCenterIdIsNotNull() {
            addCriterion("center_id is not null");
            return (Criteria) this;
        }

        public Criteria andCenterIdEqualTo(String value) {
            addCriterion("center_id =", value, "centerId");
            return (Criteria) this;
        }

        public Criteria andCenterIdNotEqualTo(String value) {
            addCriterion("center_id <>", value, "centerId");
            return (Criteria) this;
        }

        public Criteria andCenterIdGreaterThan(String value) {
            addCriterion("center_id >", value, "centerId");
            return (Criteria) this;
        }

        public Criteria andCenterIdGreaterThanOrEqualTo(String value) {
            addCriterion("center_id >=", value, "centerId");
            return (Criteria) this;
        }

        public Criteria andCenterIdLessThan(String value) {
            addCriterion("center_id <", value, "centerId");
            return (Criteria) this;
        }

        public Criteria andCenterIdLessThanOrEqualTo(String value) {
            addCriterion("center_id <=", value, "centerId");
            return (Criteria) this;
        }

        public Criteria andCenterIdLike(String value) {
            addCriterion("center_id like", value, "centerId");
            return (Criteria) this;
        }

        public Criteria andCenterIdNotLike(String value) {
            addCriterion("center_id not like", value, "centerId");
            return (Criteria) this;
        }

        public Criteria andCenterIdIn(List<String> values) {
            addCriterion("center_id in", values, "centerId");
            return (Criteria) this;
        }

        public Criteria andCenterIdNotIn(List<String> values) {
            addCriterion("center_id not in", values, "centerId");
            return (Criteria) this;
        }

        public Criteria andCenterIdBetween(String value1, String value2) {
            addCriterion("center_id between", value1, value2, "centerId");
            return (Criteria) this;
        }

        public Criteria andCenterIdNotBetween(String value1, String value2) {
            addCriterion("center_id not between", value1, value2, "centerId");
            return (Criteria) this;
        }

        public Criteria andMsg1IsNull() {
            addCriterion("msg1 is null");
            return (Criteria) this;
        }

        public Criteria andMsg1IsNotNull() {
            addCriterion("msg1 is not null");
            return (Criteria) this;
        }

        public Criteria andMsg1EqualTo(String value) {
            addCriterion("msg1 =", value, "msg1");
            return (Criteria) this;
        }

        public Criteria andMsg1NotEqualTo(String value) {
            addCriterion("msg1 <>", value, "msg1");
            return (Criteria) this;
        }

        public Criteria andMsg1GreaterThan(String value) {
            addCriterion("msg1 >", value, "msg1");
            return (Criteria) this;
        }

        public Criteria andMsg1GreaterThanOrEqualTo(String value) {
            addCriterion("msg1 >=", value, "msg1");
            return (Criteria) this;
        }

        public Criteria andMsg1LessThan(String value) {
            addCriterion("msg1 <", value, "msg1");
            return (Criteria) this;
        }

        public Criteria andMsg1LessThanOrEqualTo(String value) {
            addCriterion("msg1 <=", value, "msg1");
            return (Criteria) this;
        }

        public Criteria andMsg1Like(String value) {
            addCriterion("msg1 like", value, "msg1");
            return (Criteria) this;
        }

        public Criteria andMsg1NotLike(String value) {
            addCriterion("msg1 not like", value, "msg1");
            return (Criteria) this;
        }

        public Criteria andMsg1In(List<String> values) {
            addCriterion("msg1 in", values, "msg1");
            return (Criteria) this;
        }

        public Criteria andMsg1NotIn(List<String> values) {
            addCriterion("msg1 not in", values, "msg1");
            return (Criteria) this;
        }

        public Criteria andMsg1Between(String value1, String value2) {
            addCriterion("msg1 between", value1, value2, "msg1");
            return (Criteria) this;
        }

        public Criteria andMsg1NotBetween(String value1, String value2) {
            addCriterion("msg1 not between", value1, value2, "msg1");
            return (Criteria) this;
        }

        public Criteria andMsg2IsNull() {
            addCriterion("msg2 is null");
            return (Criteria) this;
        }

        public Criteria andMsg2IsNotNull() {
            addCriterion("msg2 is not null");
            return (Criteria) this;
        }

        public Criteria andMsg2EqualTo(String value) {
            addCriterion("msg2 =", value, "msg2");
            return (Criteria) this;
        }

        public Criteria andMsg2NotEqualTo(String value) {
            addCriterion("msg2 <>", value, "msg2");
            return (Criteria) this;
        }

        public Criteria andMsg2GreaterThan(String value) {
            addCriterion("msg2 >", value, "msg2");
            return (Criteria) this;
        }

        public Criteria andMsg2GreaterThanOrEqualTo(String value) {
            addCriterion("msg2 >=", value, "msg2");
            return (Criteria) this;
        }

        public Criteria andMsg2LessThan(String value) {
            addCriterion("msg2 <", value, "msg2");
            return (Criteria) this;
        }

        public Criteria andMsg2LessThanOrEqualTo(String value) {
            addCriterion("msg2 <=", value, "msg2");
            return (Criteria) this;
        }

        public Criteria andMsg2Like(String value) {
            addCriterion("msg2 like", value, "msg2");
            return (Criteria) this;
        }

        public Criteria andMsg2NotLike(String value) {
            addCriterion("msg2 not like", value, "msg2");
            return (Criteria) this;
        }

        public Criteria andMsg2In(List<String> values) {
            addCriterion("msg2 in", values, "msg2");
            return (Criteria) this;
        }

        public Criteria andMsg2NotIn(List<String> values) {
            addCriterion("msg2 not in", values, "msg2");
            return (Criteria) this;
        }

        public Criteria andMsg2Between(String value1, String value2) {
            addCriterion("msg2 between", value1, value2, "msg2");
            return (Criteria) this;
        }

        public Criteria andMsg2NotBetween(String value1, String value2) {
            addCriterion("msg2 not between", value1, value2, "msg2");
            return (Criteria) this;
        }

        public Criteria andMsg3IsNull() {
            addCriterion("msg3 is null");
            return (Criteria) this;
        }

        public Criteria andMsg3IsNotNull() {
            addCriterion("msg3 is not null");
            return (Criteria) this;
        }

        public Criteria andMsg3EqualTo(String value) {
            addCriterion("msg3 =", value, "msg3");
            return (Criteria) this;
        }

        public Criteria andMsg3NotEqualTo(String value) {
            addCriterion("msg3 <>", value, "msg3");
            return (Criteria) this;
        }

        public Criteria andMsg3GreaterThan(String value) {
            addCriterion("msg3 >", value, "msg3");
            return (Criteria) this;
        }

        public Criteria andMsg3GreaterThanOrEqualTo(String value) {
            addCriterion("msg3 >=", value, "msg3");
            return (Criteria) this;
        }

        public Criteria andMsg3LessThan(String value) {
            addCriterion("msg3 <", value, "msg3");
            return (Criteria) this;
        }

        public Criteria andMsg3LessThanOrEqualTo(String value) {
            addCriterion("msg3 <=", value, "msg3");
            return (Criteria) this;
        }

        public Criteria andMsg3Like(String value) {
            addCriterion("msg3 like", value, "msg3");
            return (Criteria) this;
        }

        public Criteria andMsg3NotLike(String value) {
            addCriterion("msg3 not like", value, "msg3");
            return (Criteria) this;
        }

        public Criteria andMsg3In(List<String> values) {
            addCriterion("msg3 in", values, "msg3");
            return (Criteria) this;
        }

        public Criteria andMsg3NotIn(List<String> values) {
            addCriterion("msg3 not in", values, "msg3");
            return (Criteria) this;
        }

        public Criteria andMsg3Between(String value1, String value2) {
            addCriterion("msg3 between", value1, value2, "msg3");
            return (Criteria) this;
        }

        public Criteria andMsg3NotBetween(String value1, String value2) {
            addCriterion("msg3 not between", value1, value2, "msg3");
            return (Criteria) this;
        }

        public Criteria andMsg4IsNull() {
            addCriterion("msg4 is null");
            return (Criteria) this;
        }

        public Criteria andMsg4IsNotNull() {
            addCriterion("msg4 is not null");
            return (Criteria) this;
        }

        public Criteria andMsg4EqualTo(String value) {
            addCriterion("msg4 =", value, "msg4");
            return (Criteria) this;
        }

        public Criteria andMsg4NotEqualTo(String value) {
            addCriterion("msg4 <>", value, "msg4");
            return (Criteria) this;
        }

        public Criteria andMsg4GreaterThan(String value) {
            addCriterion("msg4 >", value, "msg4");
            return (Criteria) this;
        }

        public Criteria andMsg4GreaterThanOrEqualTo(String value) {
            addCriterion("msg4 >=", value, "msg4");
            return (Criteria) this;
        }

        public Criteria andMsg4LessThan(String value) {
            addCriterion("msg4 <", value, "msg4");
            return (Criteria) this;
        }

        public Criteria andMsg4LessThanOrEqualTo(String value) {
            addCriterion("msg4 <=", value, "msg4");
            return (Criteria) this;
        }

        public Criteria andMsg4Like(String value) {
            addCriterion("msg4 like", value, "msg4");
            return (Criteria) this;
        }

        public Criteria andMsg4NotLike(String value) {
            addCriterion("msg4 not like", value, "msg4");
            return (Criteria) this;
        }

        public Criteria andMsg4In(List<String> values) {
            addCriterion("msg4 in", values, "msg4");
            return (Criteria) this;
        }

        public Criteria andMsg4NotIn(List<String> values) {
            addCriterion("msg4 not in", values, "msg4");
            return (Criteria) this;
        }

        public Criteria andMsg4Between(String value1, String value2) {
            addCriterion("msg4 between", value1, value2, "msg4");
            return (Criteria) this;
        }

        public Criteria andMsg4NotBetween(String value1, String value2) {
            addCriterion("msg4 not between", value1, value2, "msg4");
            return (Criteria) this;
        }

        public Criteria andMsg5IsNull() {
            addCriterion("msg5 is null");
            return (Criteria) this;
        }

        public Criteria andMsg5IsNotNull() {
            addCriterion("msg5 is not null");
            return (Criteria) this;
        }

        public Criteria andMsg5EqualTo(String value) {
            addCriterion("msg5 =", value, "msg5");
            return (Criteria) this;
        }

        public Criteria andMsg5NotEqualTo(String value) {
            addCriterion("msg5 <>", value, "msg5");
            return (Criteria) this;
        }

        public Criteria andMsg5GreaterThan(String value) {
            addCriterion("msg5 >", value, "msg5");
            return (Criteria) this;
        }

        public Criteria andMsg5GreaterThanOrEqualTo(String value) {
            addCriterion("msg5 >=", value, "msg5");
            return (Criteria) this;
        }

        public Criteria andMsg5LessThan(String value) {
            addCriterion("msg5 <", value, "msg5");
            return (Criteria) this;
        }

        public Criteria andMsg5LessThanOrEqualTo(String value) {
            addCriterion("msg5 <=", value, "msg5");
            return (Criteria) this;
        }

        public Criteria andMsg5Like(String value) {
            addCriterion("msg5 like", value, "msg5");
            return (Criteria) this;
        }

        public Criteria andMsg5NotLike(String value) {
            addCriterion("msg5 not like", value, "msg5");
            return (Criteria) this;
        }

        public Criteria andMsg5In(List<String> values) {
            addCriterion("msg5 in", values, "msg5");
            return (Criteria) this;
        }

        public Criteria andMsg5NotIn(List<String> values) {
            addCriterion("msg5 not in", values, "msg5");
            return (Criteria) this;
        }

        public Criteria andMsg5Between(String value1, String value2) {
            addCriterion("msg5 between", value1, value2, "msg5");
            return (Criteria) this;
        }

        public Criteria andMsg5NotBetween(String value1, String value2) {
            addCriterion("msg5 not between", value1, value2, "msg5");
            return (Criteria) this;
        }

        public Criteria andBigPicIsNull() {
            addCriterion("big_pic is null");
            return (Criteria) this;
        }

        public Criteria andBigPicIsNotNull() {
            addCriterion("big_pic is not null");
            return (Criteria) this;
        }

        public Criteria andBigPicEqualTo(String value) {
            addCriterion("big_pic =", value, "bigPic");
            return (Criteria) this;
        }

        public Criteria andBigPicNotEqualTo(String value) {
            addCriterion("big_pic <>", value, "bigPic");
            return (Criteria) this;
        }

        public Criteria andBigPicGreaterThan(String value) {
            addCriterion("big_pic >", value, "bigPic");
            return (Criteria) this;
        }

        public Criteria andBigPicGreaterThanOrEqualTo(String value) {
            addCriterion("big_pic >=", value, "bigPic");
            return (Criteria) this;
        }

        public Criteria andBigPicLessThan(String value) {
            addCriterion("big_pic <", value, "bigPic");
            return (Criteria) this;
        }

        public Criteria andBigPicLessThanOrEqualTo(String value) {
            addCriterion("big_pic <=", value, "bigPic");
            return (Criteria) this;
        }

        public Criteria andBigPicLike(String value) {
            addCriterion("big_pic like", value, "bigPic");
            return (Criteria) this;
        }

        public Criteria andBigPicNotLike(String value) {
            addCriterion("big_pic not like", value, "bigPic");
            return (Criteria) this;
        }

        public Criteria andBigPicIn(List<String> values) {
            addCriterion("big_pic in", values, "bigPic");
            return (Criteria) this;
        }

        public Criteria andBigPicNotIn(List<String> values) {
            addCriterion("big_pic not in", values, "bigPic");
            return (Criteria) this;
        }

        public Criteria andBigPicBetween(String value1, String value2) {
            addCriterion("big_pic between", value1, value2, "bigPic");
            return (Criteria) this;
        }

        public Criteria andBigPicNotBetween(String value1, String value2) {
            addCriterion("big_pic not between", value1, value2, "bigPic");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 首页信息表
     * 
     * @author wcyong
     * 
     * @date 2019-03-16
     */
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