package com.pdsu.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MessageExample() {
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
     * 消息表
     * 
     * @author wcyong
     * 
     * @date 2019-04-14
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

        public Criteria andMIdIsNull() {
            addCriterion("m_id is null");
            return (Criteria) this;
        }

        public Criteria andMIdIsNotNull() {
            addCriterion("m_id is not null");
            return (Criteria) this;
        }

        public Criteria andMIdEqualTo(String value) {
            addCriterion("m_id =", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdNotEqualTo(String value) {
            addCriterion("m_id <>", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdGreaterThan(String value) {
            addCriterion("m_id >", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdGreaterThanOrEqualTo(String value) {
            addCriterion("m_id >=", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdLessThan(String value) {
            addCriterion("m_id <", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdLessThanOrEqualTo(String value) {
            addCriterion("m_id <=", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdLike(String value) {
            addCriterion("m_id like", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdNotLike(String value) {
            addCriterion("m_id not like", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdIn(List<String> values) {
            addCriterion("m_id in", values, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdNotIn(List<String> values) {
            addCriterion("m_id not in", values, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdBetween(String value1, String value2) {
            addCriterion("m_id between", value1, value2, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdNotBetween(String value1, String value2) {
            addCriterion("m_id not between", value1, value2, "mId");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNull() {
            addCriterion("created is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(Date value) {
            addCriterion("created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Date value) {
            addCriterion("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Date value) {
            addCriterion("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Date value) {
            addCriterion("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Date value) {
            addCriterion("created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Date> values) {
            addCriterion("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Date> values) {
            addCriterion("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Date value1, Date value2) {
            addCriterion("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Date value1, Date value2) {
            addCriterion("created not between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andFromIdIsNull() {
            addCriterion("from_id is null");
            return (Criteria) this;
        }

        public Criteria andFromIdIsNotNull() {
            addCriterion("from_id is not null");
            return (Criteria) this;
        }

        public Criteria andFromIdEqualTo(String value) {
            addCriterion("from_id =", value, "fromId");
            return (Criteria) this;
        }

        public Criteria andFromIdNotEqualTo(String value) {
            addCriterion("from_id <>", value, "fromId");
            return (Criteria) this;
        }

        public Criteria andFromIdGreaterThan(String value) {
            addCriterion("from_id >", value, "fromId");
            return (Criteria) this;
        }

        public Criteria andFromIdGreaterThanOrEqualTo(String value) {
            addCriterion("from_id >=", value, "fromId");
            return (Criteria) this;
        }

        public Criteria andFromIdLessThan(String value) {
            addCriterion("from_id <", value, "fromId");
            return (Criteria) this;
        }

        public Criteria andFromIdLessThanOrEqualTo(String value) {
            addCriterion("from_id <=", value, "fromId");
            return (Criteria) this;
        }

        public Criteria andFromIdLike(String value) {
            addCriterion("from_id like", value, "fromId");
            return (Criteria) this;
        }

        public Criteria andFromIdNotLike(String value) {
            addCriterion("from_id not like", value, "fromId");
            return (Criteria) this;
        }

        public Criteria andFromIdIn(List<String> values) {
            addCriterion("from_id in", values, "fromId");
            return (Criteria) this;
        }

        public Criteria andFromIdNotIn(List<String> values) {
            addCriterion("from_id not in", values, "fromId");
            return (Criteria) this;
        }

        public Criteria andFromIdBetween(String value1, String value2) {
            addCriterion("from_id between", value1, value2, "fromId");
            return (Criteria) this;
        }

        public Criteria andFromIdNotBetween(String value1, String value2) {
            addCriterion("from_id not between", value1, value2, "fromId");
            return (Criteria) this;
        }

        public Criteria andOwnIdIsNull() {
            addCriterion("own_id is null");
            return (Criteria) this;
        }

        public Criteria andOwnIdIsNotNull() {
            addCriterion("own_id is not null");
            return (Criteria) this;
        }

        public Criteria andOwnIdEqualTo(String value) {
            addCriterion("own_id =", value, "ownId");
            return (Criteria) this;
        }

        public Criteria andOwnIdNotEqualTo(String value) {
            addCriterion("own_id <>", value, "ownId");
            return (Criteria) this;
        }

        public Criteria andOwnIdGreaterThan(String value) {
            addCriterion("own_id >", value, "ownId");
            return (Criteria) this;
        }

        public Criteria andOwnIdGreaterThanOrEqualTo(String value) {
            addCriterion("own_id >=", value, "ownId");
            return (Criteria) this;
        }

        public Criteria andOwnIdLessThan(String value) {
            addCriterion("own_id <", value, "ownId");
            return (Criteria) this;
        }

        public Criteria andOwnIdLessThanOrEqualTo(String value) {
            addCriterion("own_id <=", value, "ownId");
            return (Criteria) this;
        }

        public Criteria andOwnIdLike(String value) {
            addCriterion("own_id like", value, "ownId");
            return (Criteria) this;
        }

        public Criteria andOwnIdNotLike(String value) {
            addCriterion("own_id not like", value, "ownId");
            return (Criteria) this;
        }

        public Criteria andOwnIdIn(List<String> values) {
            addCriterion("own_id in", values, "ownId");
            return (Criteria) this;
        }

        public Criteria andOwnIdNotIn(List<String> values) {
            addCriterion("own_id not in", values, "ownId");
            return (Criteria) this;
        }

        public Criteria andOwnIdBetween(String value1, String value2) {
            addCriterion("own_id between", value1, value2, "ownId");
            return (Criteria) this;
        }

        public Criteria andOwnIdNotBetween(String value1, String value2) {
            addCriterion("own_id not between", value1, value2, "ownId");
            return (Criteria) this;
        }

        public Criteria andLIdIsNull() {
            addCriterion("l_id is null");
            return (Criteria) this;
        }

        public Criteria andLIdIsNotNull() {
            addCriterion("l_id is not null");
            return (Criteria) this;
        }

        public Criteria andLIdEqualTo(String value) {
            addCriterion("l_id =", value, "lId");
            return (Criteria) this;
        }

        public Criteria andLIdNotEqualTo(String value) {
            addCriterion("l_id <>", value, "lId");
            return (Criteria) this;
        }

        public Criteria andLIdGreaterThan(String value) {
            addCriterion("l_id >", value, "lId");
            return (Criteria) this;
        }

        public Criteria andLIdGreaterThanOrEqualTo(String value) {
            addCriterion("l_id >=", value, "lId");
            return (Criteria) this;
        }

        public Criteria andLIdLessThan(String value) {
            addCriterion("l_id <", value, "lId");
            return (Criteria) this;
        }

        public Criteria andLIdLessThanOrEqualTo(String value) {
            addCriterion("l_id <=", value, "lId");
            return (Criteria) this;
        }

        public Criteria andLIdLike(String value) {
            addCriterion("l_id like", value, "lId");
            return (Criteria) this;
        }

        public Criteria andLIdNotLike(String value) {
            addCriterion("l_id not like", value, "lId");
            return (Criteria) this;
        }

        public Criteria andLIdIn(List<String> values) {
            addCriterion("l_id in", values, "lId");
            return (Criteria) this;
        }

        public Criteria andLIdNotIn(List<String> values) {
            addCriterion("l_id not in", values, "lId");
            return (Criteria) this;
        }

        public Criteria andLIdBetween(String value1, String value2) {
            addCriterion("l_id between", value1, value2, "lId");
            return (Criteria) this;
        }

        public Criteria andLIdNotBetween(String value1, String value2) {
            addCriterion("l_id not between", value1, value2, "lId");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 消息表
     * 
     * @author wcyong
     * 
     * @date 2019-04-14
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