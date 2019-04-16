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

        public Criteria andModelNameIsNull() {
            addCriterion("model_name is null");
            return (Criteria) this;
        }

        public Criteria andModelNameIsNotNull() {
            addCriterion("model_name is not null");
            return (Criteria) this;
        }

        public Criteria andModelNameEqualTo(String value) {
            addCriterion("model_name =", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotEqualTo(String value) {
            addCriterion("model_name <>", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameGreaterThan(String value) {
            addCriterion("model_name >", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameGreaterThanOrEqualTo(String value) {
            addCriterion("model_name >=", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLessThan(String value) {
            addCriterion("model_name <", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLessThanOrEqualTo(String value) {
            addCriterion("model_name <=", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLike(String value) {
            addCriterion("model_name like", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotLike(String value) {
            addCriterion("model_name not like", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameIn(List<String> values) {
            addCriterion("model_name in", values, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotIn(List<String> values) {
            addCriterion("model_name not in", values, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameBetween(String value1, String value2) {
            addCriterion("model_name between", value1, value2, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotBetween(String value1, String value2) {
            addCriterion("model_name not between", value1, value2, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelUrlIsNull() {
            addCriterion("model_url is null");
            return (Criteria) this;
        }

        public Criteria andModelUrlIsNotNull() {
            addCriterion("model_url is not null");
            return (Criteria) this;
        }

        public Criteria andModelUrlEqualTo(String value) {
            addCriterion("model_url =", value, "modelUrl");
            return (Criteria) this;
        }

        public Criteria andModelUrlNotEqualTo(String value) {
            addCriterion("model_url <>", value, "modelUrl");
            return (Criteria) this;
        }

        public Criteria andModelUrlGreaterThan(String value) {
            addCriterion("model_url >", value, "modelUrl");
            return (Criteria) this;
        }

        public Criteria andModelUrlGreaterThanOrEqualTo(String value) {
            addCriterion("model_url >=", value, "modelUrl");
            return (Criteria) this;
        }

        public Criteria andModelUrlLessThan(String value) {
            addCriterion("model_url <", value, "modelUrl");
            return (Criteria) this;
        }

        public Criteria andModelUrlLessThanOrEqualTo(String value) {
            addCriterion("model_url <=", value, "modelUrl");
            return (Criteria) this;
        }

        public Criteria andModelUrlLike(String value) {
            addCriterion("model_url like", value, "modelUrl");
            return (Criteria) this;
        }

        public Criteria andModelUrlNotLike(String value) {
            addCriterion("model_url not like", value, "modelUrl");
            return (Criteria) this;
        }

        public Criteria andModelUrlIn(List<String> values) {
            addCriterion("model_url in", values, "modelUrl");
            return (Criteria) this;
        }

        public Criteria andModelUrlNotIn(List<String> values) {
            addCriterion("model_url not in", values, "modelUrl");
            return (Criteria) this;
        }

        public Criteria andModelUrlBetween(String value1, String value2) {
            addCriterion("model_url between", value1, value2, "modelUrl");
            return (Criteria) this;
        }

        public Criteria andModelUrlNotBetween(String value1, String value2) {
            addCriterion("model_url not between", value1, value2, "modelUrl");
            return (Criteria) this;
        }

        public Criteria andModelTypeIsNull() {
            addCriterion("model_type is null");
            return (Criteria) this;
        }

        public Criteria andModelTypeIsNotNull() {
            addCriterion("model_type is not null");
            return (Criteria) this;
        }

        public Criteria andModelTypeEqualTo(Integer value) {
            addCriterion("model_type =", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeNotEqualTo(Integer value) {
            addCriterion("model_type <>", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeGreaterThan(Integer value) {
            addCriterion("model_type >", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("model_type >=", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeLessThan(Integer value) {
            addCriterion("model_type <", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeLessThanOrEqualTo(Integer value) {
            addCriterion("model_type <=", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeIn(List<Integer> values) {
            addCriterion("model_type in", values, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeNotIn(List<Integer> values) {
            addCriterion("model_type not in", values, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeBetween(Integer value1, Integer value2) {
            addCriterion("model_type between", value1, value2, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("model_type not between", value1, value2, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelSortIsNull() {
            addCriterion("model_sort is null");
            return (Criteria) this;
        }

        public Criteria andModelSortIsNotNull() {
            addCriterion("model_sort is not null");
            return (Criteria) this;
        }

        public Criteria andModelSortEqualTo(Integer value) {
            addCriterion("model_sort =", value, "modelSort");
            return (Criteria) this;
        }

        public Criteria andModelSortNotEqualTo(Integer value) {
            addCriterion("model_sort <>", value, "modelSort");
            return (Criteria) this;
        }

        public Criteria andModelSortGreaterThan(Integer value) {
            addCriterion("model_sort >", value, "modelSort");
            return (Criteria) this;
        }

        public Criteria andModelSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("model_sort >=", value, "modelSort");
            return (Criteria) this;
        }

        public Criteria andModelSortLessThan(Integer value) {
            addCriterion("model_sort <", value, "modelSort");
            return (Criteria) this;
        }

        public Criteria andModelSortLessThanOrEqualTo(Integer value) {
            addCriterion("model_sort <=", value, "modelSort");
            return (Criteria) this;
        }

        public Criteria andModelSortIn(List<Integer> values) {
            addCriterion("model_sort in", values, "modelSort");
            return (Criteria) this;
        }

        public Criteria andModelSortNotIn(List<Integer> values) {
            addCriterion("model_sort not in", values, "modelSort");
            return (Criteria) this;
        }

        public Criteria andModelSortBetween(Integer value1, Integer value2) {
            addCriterion("model_sort between", value1, value2, "modelSort");
            return (Criteria) this;
        }

        public Criteria andModelSortNotBetween(Integer value1, Integer value2) {
            addCriterion("model_sort not between", value1, value2, "modelSort");
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