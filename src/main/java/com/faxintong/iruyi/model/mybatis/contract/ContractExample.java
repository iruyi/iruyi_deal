package com.faxintong.iruyi.model.mybatis.contract;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContractExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ContractExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andRejectLayerIdIsNull() {
            addCriterion("reject_layer_id is null");
            return (Criteria) this;
        }

        public Criteria andRejectLayerIdIsNotNull() {
            addCriterion("reject_layer_id is not null");
            return (Criteria) this;
        }

        public Criteria andRejectLayerIdEqualTo(Long value) {
            addCriterion("reject_layer_id =", value, "rejectLayerId");
            return (Criteria) this;
        }

        public Criteria andRejectLayerIdNotEqualTo(Long value) {
            addCriterion("reject_layer_id <>", value, "rejectLayerId");
            return (Criteria) this;
        }

        public Criteria andRejectLayerIdGreaterThan(Long value) {
            addCriterion("reject_layer_id >", value, "rejectLayerId");
            return (Criteria) this;
        }

        public Criteria andRejectLayerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("reject_layer_id >=", value, "rejectLayerId");
            return (Criteria) this;
        }

        public Criteria andRejectLayerIdLessThan(Long value) {
            addCriterion("reject_layer_id <", value, "rejectLayerId");
            return (Criteria) this;
        }

        public Criteria andRejectLayerIdLessThanOrEqualTo(Long value) {
            addCriterion("reject_layer_id <=", value, "rejectLayerId");
            return (Criteria) this;
        }

        public Criteria andRejectLayerIdIn(List<Long> values) {
            addCriterion("reject_layer_id in", values, "rejectLayerId");
            return (Criteria) this;
        }

        public Criteria andRejectLayerIdNotIn(List<Long> values) {
            addCriterion("reject_layer_id not in", values, "rejectLayerId");
            return (Criteria) this;
        }

        public Criteria andRejectLayerIdBetween(Long value1, Long value2) {
            addCriterion("reject_layer_id between", value1, value2, "rejectLayerId");
            return (Criteria) this;
        }

        public Criteria andRejectLayerIdNotBetween(Long value1, Long value2) {
            addCriterion("reject_layer_id not between", value1, value2, "rejectLayerId");
            return (Criteria) this;
        }

        public Criteria andReceiveLayerIdIsNull() {
            addCriterion("receive_layer_id is null");
            return (Criteria) this;
        }

        public Criteria andReceiveLayerIdIsNotNull() {
            addCriterion("receive_layer_id is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveLayerIdEqualTo(Long value) {
            addCriterion("receive_layer_id =", value, "receiveLayerId");
            return (Criteria) this;
        }

        public Criteria andReceiveLayerIdNotEqualTo(Long value) {
            addCriterion("receive_layer_id <>", value, "receiveLayerId");
            return (Criteria) this;
        }

        public Criteria andReceiveLayerIdGreaterThan(Long value) {
            addCriterion("receive_layer_id >", value, "receiveLayerId");
            return (Criteria) this;
        }

        public Criteria andReceiveLayerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("receive_layer_id >=", value, "receiveLayerId");
            return (Criteria) this;
        }

        public Criteria andReceiveLayerIdLessThan(Long value) {
            addCriterion("receive_layer_id <", value, "receiveLayerId");
            return (Criteria) this;
        }

        public Criteria andReceiveLayerIdLessThanOrEqualTo(Long value) {
            addCriterion("receive_layer_id <=", value, "receiveLayerId");
            return (Criteria) this;
        }

        public Criteria andReceiveLayerIdIn(List<Long> values) {
            addCriterion("receive_layer_id in", values, "receiveLayerId");
            return (Criteria) this;
        }

        public Criteria andReceiveLayerIdNotIn(List<Long> values) {
            addCriterion("receive_layer_id not in", values, "receiveLayerId");
            return (Criteria) this;
        }

        public Criteria andReceiveLayerIdBetween(Long value1, Long value2) {
            addCriterion("receive_layer_id between", value1, value2, "receiveLayerId");
            return (Criteria) this;
        }

        public Criteria andReceiveLayerIdNotBetween(Long value1, Long value2) {
            addCriterion("receive_layer_id not between", value1, value2, "receiveLayerId");
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

        public Criteria andContractTypeIsNull() {
            addCriterion("contract_type is null");
            return (Criteria) this;
        }

        public Criteria andContractTypeIsNotNull() {
            addCriterion("contract_type is not null");
            return (Criteria) this;
        }

        public Criteria andContractTypeEqualTo(Integer value) {
            addCriterion("contract_type =", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeNotEqualTo(Integer value) {
            addCriterion("contract_type <>", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeGreaterThan(Integer value) {
            addCriterion("contract_type >", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("contract_type >=", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeLessThan(Integer value) {
            addCriterion("contract_type <", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeLessThanOrEqualTo(Integer value) {
            addCriterion("contract_type <=", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeIn(List<Integer> values) {
            addCriterion("contract_type in", values, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeNotIn(List<Integer> values) {
            addCriterion("contract_type not in", values, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeBetween(Integer value1, Integer value2) {
            addCriterion("contract_type between", value1, value2, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("contract_type not between", value1, value2, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractFigureIsNull() {
            addCriterion("contract_figure is null");
            return (Criteria) this;
        }

        public Criteria andContractFigureIsNotNull() {
            addCriterion("contract_figure is not null");
            return (Criteria) this;
        }

        public Criteria andContractFigureEqualTo(Float value) {
            addCriterion("contract_figure =", value, "contractFigure");
            return (Criteria) this;
        }

        public Criteria andContractFigureNotEqualTo(Float value) {
            addCriterion("contract_figure <>", value, "contractFigure");
            return (Criteria) this;
        }

        public Criteria andContractFigureGreaterThan(Float value) {
            addCriterion("contract_figure >", value, "contractFigure");
            return (Criteria) this;
        }

        public Criteria andContractFigureGreaterThanOrEqualTo(Float value) {
            addCriterion("contract_figure >=", value, "contractFigure");
            return (Criteria) this;
        }

        public Criteria andContractFigureLessThan(Float value) {
            addCriterion("contract_figure <", value, "contractFigure");
            return (Criteria) this;
        }

        public Criteria andContractFigureLessThanOrEqualTo(Float value) {
            addCriterion("contract_figure <=", value, "contractFigure");
            return (Criteria) this;
        }

        public Criteria andContractFigureIn(List<Float> values) {
            addCriterion("contract_figure in", values, "contractFigure");
            return (Criteria) this;
        }

        public Criteria andContractFigureNotIn(List<Float> values) {
            addCriterion("contract_figure not in", values, "contractFigure");
            return (Criteria) this;
        }

        public Criteria andContractFigureBetween(Float value1, Float value2) {
            addCriterion("contract_figure between", value1, value2, "contractFigure");
            return (Criteria) this;
        }

        public Criteria andContractFigureNotBetween(Float value1, Float value2) {
            addCriterion("contract_figure not between", value1, value2, "contractFigure");
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

        public Criteria andContractUrlIsNull() {
            addCriterion("contract_url is null");
            return (Criteria) this;
        }

        public Criteria andContractUrlIsNotNull() {
            addCriterion("contract_url is not null");
            return (Criteria) this;
        }

        public Criteria andContractUrlEqualTo(String value) {
            addCriterion("contract_url =", value, "contractUrl");
            return (Criteria) this;
        }

        public Criteria andContractUrlNotEqualTo(String value) {
            addCriterion("contract_url <>", value, "contractUrl");
            return (Criteria) this;
        }

        public Criteria andContractUrlGreaterThan(String value) {
            addCriterion("contract_url >", value, "contractUrl");
            return (Criteria) this;
        }

        public Criteria andContractUrlGreaterThanOrEqualTo(String value) {
            addCriterion("contract_url >=", value, "contractUrl");
            return (Criteria) this;
        }

        public Criteria andContractUrlLessThan(String value) {
            addCriterion("contract_url <", value, "contractUrl");
            return (Criteria) this;
        }

        public Criteria andContractUrlLessThanOrEqualTo(String value) {
            addCriterion("contract_url <=", value, "contractUrl");
            return (Criteria) this;
        }

        public Criteria andContractUrlLike(String value) {
            addCriterion("contract_url like", value, "contractUrl");
            return (Criteria) this;
        }

        public Criteria andContractUrlNotLike(String value) {
            addCriterion("contract_url not like", value, "contractUrl");
            return (Criteria) this;
        }

        public Criteria andContractUrlIn(List<String> values) {
            addCriterion("contract_url in", values, "contractUrl");
            return (Criteria) this;
        }

        public Criteria andContractUrlNotIn(List<String> values) {
            addCriterion("contract_url not in", values, "contractUrl");
            return (Criteria) this;
        }

        public Criteria andContractUrlBetween(String value1, String value2) {
            addCriterion("contract_url between", value1, value2, "contractUrl");
            return (Criteria) this;
        }

        public Criteria andContractUrlNotBetween(String value1, String value2) {
            addCriterion("contract_url not between", value1, value2, "contractUrl");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
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