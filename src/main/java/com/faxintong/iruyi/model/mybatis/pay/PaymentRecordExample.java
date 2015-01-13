package com.faxintong.iruyi.model.mybatis.pay;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PaymentRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PaymentRecordExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Long> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Long> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andPayLawyerIdIsNull() {
            addCriterion("pay_lawyer_id is null");
            return (Criteria) this;
        }

        public Criteria andPayLawyerIdIsNotNull() {
            addCriterion("pay_lawyer_id is not null");
            return (Criteria) this;
        }

        public Criteria andPayLawyerIdEqualTo(Long value) {
            addCriterion("pay_lawyer_id =", value, "payLawyerId");
            return (Criteria) this;
        }

        public Criteria andPayLawyerIdNotEqualTo(Long value) {
            addCriterion("pay_lawyer_id <>", value, "payLawyerId");
            return (Criteria) this;
        }

        public Criteria andPayLawyerIdGreaterThan(Long value) {
            addCriterion("pay_lawyer_id >", value, "payLawyerId");
            return (Criteria) this;
        }

        public Criteria andPayLawyerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pay_lawyer_id >=", value, "payLawyerId");
            return (Criteria) this;
        }

        public Criteria andPayLawyerIdLessThan(Long value) {
            addCriterion("pay_lawyer_id <", value, "payLawyerId");
            return (Criteria) this;
        }

        public Criteria andPayLawyerIdLessThanOrEqualTo(Long value) {
            addCriterion("pay_lawyer_id <=", value, "payLawyerId");
            return (Criteria) this;
        }

        public Criteria andPayLawyerIdIn(List<Long> values) {
            addCriterion("pay_lawyer_id in", values, "payLawyerId");
            return (Criteria) this;
        }

        public Criteria andPayLawyerIdNotIn(List<Long> values) {
            addCriterion("pay_lawyer_id not in", values, "payLawyerId");
            return (Criteria) this;
        }

        public Criteria andPayLawyerIdBetween(Long value1, Long value2) {
            addCriterion("pay_lawyer_id between", value1, value2, "payLawyerId");
            return (Criteria) this;
        }

        public Criteria andPayLawyerIdNotBetween(Long value1, Long value2) {
            addCriterion("pay_lawyer_id not between", value1, value2, "payLawyerId");
            return (Criteria) this;
        }

        public Criteria andReceiveLawyerIdIsNull() {
            addCriterion("receive_lawyer_id is null");
            return (Criteria) this;
        }

        public Criteria andReceiveLawyerIdIsNotNull() {
            addCriterion("receive_lawyer_id is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveLawyerIdEqualTo(Long value) {
            addCriterion("receive_lawyer_id =", value, "receiveLawyerId");
            return (Criteria) this;
        }

        public Criteria andReceiveLawyerIdNotEqualTo(Long value) {
            addCriterion("receive_lawyer_id <>", value, "receiveLawyerId");
            return (Criteria) this;
        }

        public Criteria andReceiveLawyerIdGreaterThan(Long value) {
            addCriterion("receive_lawyer_id >", value, "receiveLawyerId");
            return (Criteria) this;
        }

        public Criteria andReceiveLawyerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("receive_lawyer_id >=", value, "receiveLawyerId");
            return (Criteria) this;
        }

        public Criteria andReceiveLawyerIdLessThan(Long value) {
            addCriterion("receive_lawyer_id <", value, "receiveLawyerId");
            return (Criteria) this;
        }

        public Criteria andReceiveLawyerIdLessThanOrEqualTo(Long value) {
            addCriterion("receive_lawyer_id <=", value, "receiveLawyerId");
            return (Criteria) this;
        }

        public Criteria andReceiveLawyerIdIn(List<Long> values) {
            addCriterion("receive_lawyer_id in", values, "receiveLawyerId");
            return (Criteria) this;
        }

        public Criteria andReceiveLawyerIdNotIn(List<Long> values) {
            addCriterion("receive_lawyer_id not in", values, "receiveLawyerId");
            return (Criteria) this;
        }

        public Criteria andReceiveLawyerIdBetween(Long value1, Long value2) {
            addCriterion("receive_lawyer_id between", value1, value2, "receiveLawyerId");
            return (Criteria) this;
        }

        public Criteria andReceiveLawyerIdNotBetween(Long value1, Long value2) {
            addCriterion("receive_lawyer_id not between", value1, value2, "receiveLawyerId");
            return (Criteria) this;
        }

        public Criteria andFigureIsNull() {
            addCriterion("figure is null");
            return (Criteria) this;
        }

        public Criteria andFigureIsNotNull() {
            addCriterion("figure is not null");
            return (Criteria) this;
        }

        public Criteria andFigureEqualTo(Float value) {
            addCriterion("figure =", value, "figure");
            return (Criteria) this;
        }

        public Criteria andFigureNotEqualTo(Float value) {
            addCriterion("figure <>", value, "figure");
            return (Criteria) this;
        }

        public Criteria andFigureGreaterThan(Float value) {
            addCriterion("figure >", value, "figure");
            return (Criteria) this;
        }

        public Criteria andFigureGreaterThanOrEqualTo(Float value) {
            addCriterion("figure >=", value, "figure");
            return (Criteria) this;
        }

        public Criteria andFigureLessThan(Float value) {
            addCriterion("figure <", value, "figure");
            return (Criteria) this;
        }

        public Criteria andFigureLessThanOrEqualTo(Float value) {
            addCriterion("figure <=", value, "figure");
            return (Criteria) this;
        }

        public Criteria andFigureIn(List<Float> values) {
            addCriterion("figure in", values, "figure");
            return (Criteria) this;
        }

        public Criteria andFigureNotIn(List<Float> values) {
            addCriterion("figure not in", values, "figure");
            return (Criteria) this;
        }

        public Criteria andFigureBetween(Float value1, Float value2) {
            addCriterion("figure between", value1, value2, "figure");
            return (Criteria) this;
        }

        public Criteria andFigureNotBetween(Float value1, Float value2) {
            addCriterion("figure not between", value1, value2, "figure");
            return (Criteria) this;
        }

        public Criteria andPayDateIsNull() {
            addCriterion("pay_date is null");
            return (Criteria) this;
        }

        public Criteria andPayDateIsNotNull() {
            addCriterion("pay_date is not null");
            return (Criteria) this;
        }

        public Criteria andPayDateEqualTo(Date value) {
            addCriterion("pay_date =", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateNotEqualTo(Date value) {
            addCriterion("pay_date <>", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateGreaterThan(Date value) {
            addCriterion("pay_date >", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateGreaterThanOrEqualTo(Date value) {
            addCriterion("pay_date >=", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateLessThan(Date value) {
            addCriterion("pay_date <", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateLessThanOrEqualTo(Date value) {
            addCriterion("pay_date <=", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateIn(List<Date> values) {
            addCriterion("pay_date in", values, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateNotIn(List<Date> values) {
            addCriterion("pay_date not in", values, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateBetween(Date value1, Date value2) {
            addCriterion("pay_date between", value1, value2, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateNotBetween(Date value1, Date value2) {
            addCriterion("pay_date not between", value1, value2, "payDate");
            return (Criteria) this;
        }
    }

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