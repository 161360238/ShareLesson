package com.pdsu.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LessonExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LessonExample() {
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
     * 课程基本信息表
     * 
     * @author wcyong
     * 
     * @date 2019-04-18
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

        public Criteria andTIdIsNull() {
            addCriterion("t_id is null");
            return (Criteria) this;
        }

        public Criteria andTIdIsNotNull() {
            addCriterion("t_id is not null");
            return (Criteria) this;
        }

        public Criteria andTIdEqualTo(String value) {
            addCriterion("t_id =", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdNotEqualTo(String value) {
            addCriterion("t_id <>", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdGreaterThan(String value) {
            addCriterion("t_id >", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdGreaterThanOrEqualTo(String value) {
            addCriterion("t_id >=", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdLessThan(String value) {
            addCriterion("t_id <", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdLessThanOrEqualTo(String value) {
            addCriterion("t_id <=", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdLike(String value) {
            addCriterion("t_id like", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdNotLike(String value) {
            addCriterion("t_id not like", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdIn(List<String> values) {
            addCriterion("t_id in", values, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdNotIn(List<String> values) {
            addCriterion("t_id not in", values, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdBetween(String value1, String value2) {
            addCriterion("t_id between", value1, value2, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdNotBetween(String value1, String value2) {
            addCriterion("t_id not between", value1, value2, "tId");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Integer value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Integer value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Integer value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Integer value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Integer value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Integer> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Integer> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Integer value1, Integer value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNull() {
            addCriterion("introduction is null");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNotNull() {
            addCriterion("introduction is not null");
            return (Criteria) this;
        }

        public Criteria andIntroductionEqualTo(String value) {
            addCriterion("introduction =", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotEqualTo(String value) {
            addCriterion("introduction <>", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThan(String value) {
            addCriterion("introduction >", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("introduction >=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThan(String value) {
            addCriterion("introduction <", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThanOrEqualTo(String value) {
            addCriterion("introduction <=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLike(String value) {
            addCriterion("introduction like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotLike(String value) {
            addCriterion("introduction not like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionIn(List<String> values) {
            addCriterion("introduction in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotIn(List<String> values) {
            addCriterion("introduction not in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionBetween(String value1, String value2) {
            addCriterion("introduction between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotBetween(String value1, String value2) {
            addCriterion("introduction not between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andLTimeIsNull() {
            addCriterion("l_time is null");
            return (Criteria) this;
        }

        public Criteria andLTimeIsNotNull() {
            addCriterion("l_time is not null");
            return (Criteria) this;
        }

        public Criteria andLTimeEqualTo(Integer value) {
            addCriterion("l_time =", value, "lTime");
            return (Criteria) this;
        }

        public Criteria andLTimeNotEqualTo(Integer value) {
            addCriterion("l_time <>", value, "lTime");
            return (Criteria) this;
        }

        public Criteria andLTimeGreaterThan(Integer value) {
            addCriterion("l_time >", value, "lTime");
            return (Criteria) this;
        }

        public Criteria andLTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("l_time >=", value, "lTime");
            return (Criteria) this;
        }

        public Criteria andLTimeLessThan(Integer value) {
            addCriterion("l_time <", value, "lTime");
            return (Criteria) this;
        }

        public Criteria andLTimeLessThanOrEqualTo(Integer value) {
            addCriterion("l_time <=", value, "lTime");
            return (Criteria) this;
        }

        public Criteria andLTimeIn(List<Integer> values) {
            addCriterion("l_time in", values, "lTime");
            return (Criteria) this;
        }

        public Criteria andLTimeNotIn(List<Integer> values) {
            addCriterion("l_time not in", values, "lTime");
            return (Criteria) this;
        }

        public Criteria andLTimeBetween(Integer value1, Integer value2) {
            addCriterion("l_time between", value1, value2, "lTime");
            return (Criteria) this;
        }

        public Criteria andLTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("l_time not between", value1, value2, "lTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNull() {
            addCriterion("begin_time is null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNotNull() {
            addCriterion("begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeEqualTo(Date value) {
            addCriterion("begin_time =", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotEqualTo(Date value) {
            addCriterion("begin_time <>", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThan(Date value) {
            addCriterion("begin_time >", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("begin_time >=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThan(Date value) {
            addCriterion("begin_time <", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThanOrEqualTo(Date value) {
            addCriterion("begin_time <=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIn(List<Date> values) {
            addCriterion("begin_time in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotIn(List<Date> values) {
            addCriterion("begin_time not in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeBetween(Date value1, Date value2) {
            addCriterion("begin_time between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotBetween(Date value1, Date value2) {
            addCriterion("begin_time not between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andMiniNumIsNull() {
            addCriterion("mini_num is null");
            return (Criteria) this;
        }

        public Criteria andMiniNumIsNotNull() {
            addCriterion("mini_num is not null");
            return (Criteria) this;
        }

        public Criteria andMiniNumEqualTo(Integer value) {
            addCriterion("mini_num =", value, "miniNum");
            return (Criteria) this;
        }

        public Criteria andMiniNumNotEqualTo(Integer value) {
            addCriterion("mini_num <>", value, "miniNum");
            return (Criteria) this;
        }

        public Criteria andMiniNumGreaterThan(Integer value) {
            addCriterion("mini_num >", value, "miniNum");
            return (Criteria) this;
        }

        public Criteria andMiniNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("mini_num >=", value, "miniNum");
            return (Criteria) this;
        }

        public Criteria andMiniNumLessThan(Integer value) {
            addCriterion("mini_num <", value, "miniNum");
            return (Criteria) this;
        }

        public Criteria andMiniNumLessThanOrEqualTo(Integer value) {
            addCriterion("mini_num <=", value, "miniNum");
            return (Criteria) this;
        }

        public Criteria andMiniNumIn(List<Integer> values) {
            addCriterion("mini_num in", values, "miniNum");
            return (Criteria) this;
        }

        public Criteria andMiniNumNotIn(List<Integer> values) {
            addCriterion("mini_num not in", values, "miniNum");
            return (Criteria) this;
        }

        public Criteria andMiniNumBetween(Integer value1, Integer value2) {
            addCriterion("mini_num between", value1, value2, "miniNum");
            return (Criteria) this;
        }

        public Criteria andMiniNumNotBetween(Integer value1, Integer value2) {
            addCriterion("mini_num not between", value1, value2, "miniNum");
            return (Criteria) this;
        }

        public Criteria andMaxNumIsNull() {
            addCriterion("max_num is null");
            return (Criteria) this;
        }

        public Criteria andMaxNumIsNotNull() {
            addCriterion("max_num is not null");
            return (Criteria) this;
        }

        public Criteria andMaxNumEqualTo(Integer value) {
            addCriterion("max_num =", value, "maxNum");
            return (Criteria) this;
        }

        public Criteria andMaxNumNotEqualTo(Integer value) {
            addCriterion("max_num <>", value, "maxNum");
            return (Criteria) this;
        }

        public Criteria andMaxNumGreaterThan(Integer value) {
            addCriterion("max_num >", value, "maxNum");
            return (Criteria) this;
        }

        public Criteria andMaxNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_num >=", value, "maxNum");
            return (Criteria) this;
        }

        public Criteria andMaxNumLessThan(Integer value) {
            addCriterion("max_num <", value, "maxNum");
            return (Criteria) this;
        }

        public Criteria andMaxNumLessThanOrEqualTo(Integer value) {
            addCriterion("max_num <=", value, "maxNum");
            return (Criteria) this;
        }

        public Criteria andMaxNumIn(List<Integer> values) {
            addCriterion("max_num in", values, "maxNum");
            return (Criteria) this;
        }

        public Criteria andMaxNumNotIn(List<Integer> values) {
            addCriterion("max_num not in", values, "maxNum");
            return (Criteria) this;
        }

        public Criteria andMaxNumBetween(Integer value1, Integer value2) {
            addCriterion("max_num between", value1, value2, "maxNum");
            return (Criteria) this;
        }

        public Criteria andMaxNumNotBetween(Integer value1, Integer value2) {
            addCriterion("max_num not between", value1, value2, "maxNum");
            return (Criteria) this;
        }

        public Criteria andPicIsNull() {
            addCriterion("pic is null");
            return (Criteria) this;
        }

        public Criteria andPicIsNotNull() {
            addCriterion("pic is not null");
            return (Criteria) this;
        }

        public Criteria andPicEqualTo(String value) {
            addCriterion("pic =", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotEqualTo(String value) {
            addCriterion("pic <>", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicGreaterThan(String value) {
            addCriterion("pic >", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicGreaterThanOrEqualTo(String value) {
            addCriterion("pic >=", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLessThan(String value) {
            addCriterion("pic <", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLessThanOrEqualTo(String value) {
            addCriterion("pic <=", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLike(String value) {
            addCriterion("pic like", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotLike(String value) {
            addCriterion("pic not like", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicIn(List<String> values) {
            addCriterion("pic in", values, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotIn(List<String> values) {
            addCriterion("pic not in", values, "pic");
            return (Criteria) this;
        }

        public Criteria andPicBetween(String value1, String value2) {
            addCriterion("pic between", value1, value2, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotBetween(String value1, String value2) {
            addCriterion("pic not between", value1, value2, "pic");
            return (Criteria) this;
        }

        public Criteria andLocationIsNull() {
            addCriterion("location is null");
            return (Criteria) this;
        }

        public Criteria andLocationIsNotNull() {
            addCriterion("location is not null");
            return (Criteria) this;
        }

        public Criteria andLocationEqualTo(String value) {
            addCriterion("location =", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotEqualTo(String value) {
            addCriterion("location <>", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThan(String value) {
            addCriterion("location >", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThanOrEqualTo(String value) {
            addCriterion("location >=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThan(String value) {
            addCriterion("location <", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThanOrEqualTo(String value) {
            addCriterion("location <=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLike(String value) {
            addCriterion("location like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotLike(String value) {
            addCriterion("location not like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationIn(List<String> values) {
            addCriterion("location in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotIn(List<String> values) {
            addCriterion("location not in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationBetween(String value1, String value2) {
            addCriterion("location between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotBetween(String value1, String value2) {
            addCriterion("location not between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andClassifyIdIsNull() {
            addCriterion("classify_id is null");
            return (Criteria) this;
        }

        public Criteria andClassifyIdIsNotNull() {
            addCriterion("classify_id is not null");
            return (Criteria) this;
        }

        public Criteria andClassifyIdEqualTo(String value) {
            addCriterion("classify_id =", value, "classifyId");
            return (Criteria) this;
        }

        public Criteria andClassifyIdNotEqualTo(String value) {
            addCriterion("classify_id <>", value, "classifyId");
            return (Criteria) this;
        }

        public Criteria andClassifyIdGreaterThan(String value) {
            addCriterion("classify_id >", value, "classifyId");
            return (Criteria) this;
        }

        public Criteria andClassifyIdGreaterThanOrEqualTo(String value) {
            addCriterion("classify_id >=", value, "classifyId");
            return (Criteria) this;
        }

        public Criteria andClassifyIdLessThan(String value) {
            addCriterion("classify_id <", value, "classifyId");
            return (Criteria) this;
        }

        public Criteria andClassifyIdLessThanOrEqualTo(String value) {
            addCriterion("classify_id <=", value, "classifyId");
            return (Criteria) this;
        }

        public Criteria andClassifyIdLike(String value) {
            addCriterion("classify_id like", value, "classifyId");
            return (Criteria) this;
        }

        public Criteria andClassifyIdNotLike(String value) {
            addCriterion("classify_id not like", value, "classifyId");
            return (Criteria) this;
        }

        public Criteria andClassifyIdIn(List<String> values) {
            addCriterion("classify_id in", values, "classifyId");
            return (Criteria) this;
        }

        public Criteria andClassifyIdNotIn(List<String> values) {
            addCriterion("classify_id not in", values, "classifyId");
            return (Criteria) this;
        }

        public Criteria andClassifyIdBetween(String value1, String value2) {
            addCriterion("classify_id between", value1, value2, "classifyId");
            return (Criteria) this;
        }

        public Criteria andClassifyIdNotBetween(String value1, String value2) {
            addCriterion("classify_id not between", value1, value2, "classifyId");
            return (Criteria) this;
        }

        public Criteria andExamIsNull() {
            addCriterion("exam is null");
            return (Criteria) this;
        }

        public Criteria andExamIsNotNull() {
            addCriterion("exam is not null");
            return (Criteria) this;
        }

        public Criteria andExamEqualTo(Integer value) {
            addCriterion("exam =", value, "exam");
            return (Criteria) this;
        }

        public Criteria andExamNotEqualTo(Integer value) {
            addCriterion("exam <>", value, "exam");
            return (Criteria) this;
        }

        public Criteria andExamGreaterThan(Integer value) {
            addCriterion("exam >", value, "exam");
            return (Criteria) this;
        }

        public Criteria andExamGreaterThanOrEqualTo(Integer value) {
            addCriterion("exam >=", value, "exam");
            return (Criteria) this;
        }

        public Criteria andExamLessThan(Integer value) {
            addCriterion("exam <", value, "exam");
            return (Criteria) this;
        }

        public Criteria andExamLessThanOrEqualTo(Integer value) {
            addCriterion("exam <=", value, "exam");
            return (Criteria) this;
        }

        public Criteria andExamIn(List<Integer> values) {
            addCriterion("exam in", values, "exam");
            return (Criteria) this;
        }

        public Criteria andExamNotIn(List<Integer> values) {
            addCriterion("exam not in", values, "exam");
            return (Criteria) this;
        }

        public Criteria andExamBetween(Integer value1, Integer value2) {
            addCriterion("exam between", value1, value2, "exam");
            return (Criteria) this;
        }

        public Criteria andExamNotBetween(Integer value1, Integer value2) {
            addCriterion("exam not between", value1, value2, "exam");
            return (Criteria) this;
        }

        public Criteria andPraiseIsNull() {
            addCriterion("praise is null");
            return (Criteria) this;
        }

        public Criteria andPraiseIsNotNull() {
            addCriterion("praise is not null");
            return (Criteria) this;
        }

        public Criteria andPraiseEqualTo(Integer value) {
            addCriterion("praise =", value, "praise");
            return (Criteria) this;
        }

        public Criteria andPraiseNotEqualTo(Integer value) {
            addCriterion("praise <>", value, "praise");
            return (Criteria) this;
        }

        public Criteria andPraiseGreaterThan(Integer value) {
            addCriterion("praise >", value, "praise");
            return (Criteria) this;
        }

        public Criteria andPraiseGreaterThanOrEqualTo(Integer value) {
            addCriterion("praise >=", value, "praise");
            return (Criteria) this;
        }

        public Criteria andPraiseLessThan(Integer value) {
            addCriterion("praise <", value, "praise");
            return (Criteria) this;
        }

        public Criteria andPraiseLessThanOrEqualTo(Integer value) {
            addCriterion("praise <=", value, "praise");
            return (Criteria) this;
        }

        public Criteria andPraiseIn(List<Integer> values) {
            addCriterion("praise in", values, "praise");
            return (Criteria) this;
        }

        public Criteria andPraiseNotIn(List<Integer> values) {
            addCriterion("praise not in", values, "praise");
            return (Criteria) this;
        }

        public Criteria andPraiseBetween(Integer value1, Integer value2) {
            addCriterion("praise between", value1, value2, "praise");
            return (Criteria) this;
        }

        public Criteria andPraiseNotBetween(Integer value1, Integer value2) {
            addCriterion("praise not between", value1, value2, "praise");
            return (Criteria) this;
        }

        public Criteria andIschargeIsNull() {
            addCriterion("ischarge is null");
            return (Criteria) this;
        }

        public Criteria andIschargeIsNotNull() {
            addCriterion("ischarge is not null");
            return (Criteria) this;
        }

        public Criteria andIschargeEqualTo(Integer value) {
            addCriterion("ischarge =", value, "ischarge");
            return (Criteria) this;
        }

        public Criteria andIschargeNotEqualTo(Integer value) {
            addCriterion("ischarge <>", value, "ischarge");
            return (Criteria) this;
        }

        public Criteria andIschargeGreaterThan(Integer value) {
            addCriterion("ischarge >", value, "ischarge");
            return (Criteria) this;
        }

        public Criteria andIschargeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ischarge >=", value, "ischarge");
            return (Criteria) this;
        }

        public Criteria andIschargeLessThan(Integer value) {
            addCriterion("ischarge <", value, "ischarge");
            return (Criteria) this;
        }

        public Criteria andIschargeLessThanOrEqualTo(Integer value) {
            addCriterion("ischarge <=", value, "ischarge");
            return (Criteria) this;
        }

        public Criteria andIschargeIn(List<Integer> values) {
            addCriterion("ischarge in", values, "ischarge");
            return (Criteria) this;
        }

        public Criteria andIschargeNotIn(List<Integer> values) {
            addCriterion("ischarge not in", values, "ischarge");
            return (Criteria) this;
        }

        public Criteria andIschargeBetween(Integer value1, Integer value2) {
            addCriterion("ischarge between", value1, value2, "ischarge");
            return (Criteria) this;
        }

        public Criteria andIschargeNotBetween(Integer value1, Integer value2) {
            addCriterion("ischarge not between", value1, value2, "ischarge");
            return (Criteria) this;
        }

        public Criteria andLNameIsNull() {
            addCriterion("l_name is null");
            return (Criteria) this;
        }

        public Criteria andLNameIsNotNull() {
            addCriterion("l_name is not null");
            return (Criteria) this;
        }

        public Criteria andLNameEqualTo(String value) {
            addCriterion("l_name =", value, "lName");
            return (Criteria) this;
        }

        public Criteria andLNameNotEqualTo(String value) {
            addCriterion("l_name <>", value, "lName");
            return (Criteria) this;
        }

        public Criteria andLNameGreaterThan(String value) {
            addCriterion("l_name >", value, "lName");
            return (Criteria) this;
        }

        public Criteria andLNameGreaterThanOrEqualTo(String value) {
            addCriterion("l_name >=", value, "lName");
            return (Criteria) this;
        }

        public Criteria andLNameLessThan(String value) {
            addCriterion("l_name <", value, "lName");
            return (Criteria) this;
        }

        public Criteria andLNameLessThanOrEqualTo(String value) {
            addCriterion("l_name <=", value, "lName");
            return (Criteria) this;
        }

        public Criteria andLNameLike(String value) {
            addCriterion("l_name like", value, "lName");
            return (Criteria) this;
        }

        public Criteria andLNameNotLike(String value) {
            addCriterion("l_name not like", value, "lName");
            return (Criteria) this;
        }

        public Criteria andLNameIn(List<String> values) {
            addCriterion("l_name in", values, "lName");
            return (Criteria) this;
        }

        public Criteria andLNameNotIn(List<String> values) {
            addCriterion("l_name not in", values, "lName");
            return (Criteria) this;
        }

        public Criteria andLNameBetween(String value1, String value2) {
            addCriterion("l_name between", value1, value2, "lName");
            return (Criteria) this;
        }

        public Criteria andLNameNotBetween(String value1, String value2) {
            addCriterion("l_name not between", value1, value2, "lName");
            return (Criteria) this;
        }

        public Criteria andCurrentNumIsNull() {
            addCriterion("current_num is null");
            return (Criteria) this;
        }

        public Criteria andCurrentNumIsNotNull() {
            addCriterion("current_num is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentNumEqualTo(Integer value) {
            addCriterion("current_num =", value, "currentNum");
            return (Criteria) this;
        }

        public Criteria andCurrentNumNotEqualTo(Integer value) {
            addCriterion("current_num <>", value, "currentNum");
            return (Criteria) this;
        }

        public Criteria andCurrentNumGreaterThan(Integer value) {
            addCriterion("current_num >", value, "currentNum");
            return (Criteria) this;
        }

        public Criteria andCurrentNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("current_num >=", value, "currentNum");
            return (Criteria) this;
        }

        public Criteria andCurrentNumLessThan(Integer value) {
            addCriterion("current_num <", value, "currentNum");
            return (Criteria) this;
        }

        public Criteria andCurrentNumLessThanOrEqualTo(Integer value) {
            addCriterion("current_num <=", value, "currentNum");
            return (Criteria) this;
        }

        public Criteria andCurrentNumIn(List<Integer> values) {
            addCriterion("current_num in", values, "currentNum");
            return (Criteria) this;
        }

        public Criteria andCurrentNumNotIn(List<Integer> values) {
            addCriterion("current_num not in", values, "currentNum");
            return (Criteria) this;
        }

        public Criteria andCurrentNumBetween(Integer value1, Integer value2) {
            addCriterion("current_num between", value1, value2, "currentNum");
            return (Criteria) this;
        }

        public Criteria andCurrentNumNotBetween(Integer value1, Integer value2) {
            addCriterion("current_num not between", value1, value2, "currentNum");
            return (Criteria) this;
        }

        public Criteria andRemindIsNull() {
            addCriterion("remind is null");
            return (Criteria) this;
        }

        public Criteria andRemindIsNotNull() {
            addCriterion("remind is not null");
            return (Criteria) this;
        }

        public Criteria andRemindEqualTo(Integer value) {
            addCriterion("remind =", value, "remind");
            return (Criteria) this;
        }

        public Criteria andRemindNotEqualTo(Integer value) {
            addCriterion("remind <>", value, "remind");
            return (Criteria) this;
        }

        public Criteria andRemindGreaterThan(Integer value) {
            addCriterion("remind >", value, "remind");
            return (Criteria) this;
        }

        public Criteria andRemindGreaterThanOrEqualTo(Integer value) {
            addCriterion("remind >=", value, "remind");
            return (Criteria) this;
        }

        public Criteria andRemindLessThan(Integer value) {
            addCriterion("remind <", value, "remind");
            return (Criteria) this;
        }

        public Criteria andRemindLessThanOrEqualTo(Integer value) {
            addCriterion("remind <=", value, "remind");
            return (Criteria) this;
        }

        public Criteria andRemindIn(List<Integer> values) {
            addCriterion("remind in", values, "remind");
            return (Criteria) this;
        }

        public Criteria andRemindNotIn(List<Integer> values) {
            addCriterion("remind not in", values, "remind");
            return (Criteria) this;
        }

        public Criteria andRemindBetween(Integer value1, Integer value2) {
            addCriterion("remind between", value1, value2, "remind");
            return (Criteria) this;
        }

        public Criteria andRemindNotBetween(Integer value1, Integer value2) {
            addCriterion("remind not between", value1, value2, "remind");
            return (Criteria) this;
        }

        public Criteria andKindIsNull() {
            addCriterion("kind is null");
            return (Criteria) this;
        }

        public Criteria andKindIsNotNull() {
            addCriterion("kind is not null");
            return (Criteria) this;
        }

        public Criteria andKindEqualTo(Integer value) {
            addCriterion("kind =", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindNotEqualTo(Integer value) {
            addCriterion("kind <>", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindGreaterThan(Integer value) {
            addCriterion("kind >", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindGreaterThanOrEqualTo(Integer value) {
            addCriterion("kind >=", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindLessThan(Integer value) {
            addCriterion("kind <", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindLessThanOrEqualTo(Integer value) {
            addCriterion("kind <=", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindIn(List<Integer> values) {
            addCriterion("kind in", values, "kind");
            return (Criteria) this;
        }

        public Criteria andKindNotIn(List<Integer> values) {
            addCriterion("kind not in", values, "kind");
            return (Criteria) this;
        }

        public Criteria andKindBetween(Integer value1, Integer value2) {
            addCriterion("kind between", value1, value2, "kind");
            return (Criteria) this;
        }

        public Criteria andKindNotBetween(Integer value1, Integer value2) {
            addCriterion("kind not between", value1, value2, "kind");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 课程基本信息表
     * 
     * @author wcyong
     * 
     * @date 2019-04-18
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