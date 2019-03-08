package com.ticketsystem.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlightExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FlightExample() {
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

        public Criteria andFlightIdIsNull() {
            addCriterion("flight_id is null");
            return (Criteria) this;
        }

        public Criteria andFlightIdIsNotNull() {
            addCriterion("flight_id is not null");
            return (Criteria) this;
        }

        public Criteria andFlightIdEqualTo(Integer value) {
            addCriterion("flight_id =", value, "flightId");
            return (Criteria) this;
        }

        public Criteria andFlightIdNotEqualTo(Integer value) {
            addCriterion("flight_id <>", value, "flightId");
            return (Criteria) this;
        }

        public Criteria andFlightIdGreaterThan(Integer value) {
            addCriterion("flight_id >", value, "flightId");
            return (Criteria) this;
        }

        public Criteria andFlightIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("flight_id >=", value, "flightId");
            return (Criteria) this;
        }

        public Criteria andFlightIdLessThan(Integer value) {
            addCriterion("flight_id <", value, "flightId");
            return (Criteria) this;
        }

        public Criteria andFlightIdLessThanOrEqualTo(Integer value) {
            addCriterion("flight_id <=", value, "flightId");
            return (Criteria) this;
        }

        public Criteria andFlightIdIn(List<Integer> values) {
            addCriterion("flight_id in", values, "flightId");
            return (Criteria) this;
        }

        public Criteria andFlightIdNotIn(List<Integer> values) {
            addCriterion("flight_id not in", values, "flightId");
            return (Criteria) this;
        }

        public Criteria andFlightIdBetween(Integer value1, Integer value2) {
            addCriterion("flight_id between", value1, value2, "flightId");
            return (Criteria) this;
        }

        public Criteria andFlightIdNotBetween(Integer value1, Integer value2) {
            addCriterion("flight_id not between", value1, value2, "flightId");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartCityIsNull() {
            addCriterion("start_city is null");
            return (Criteria) this;
        }

        public Criteria andStartCityIsNotNull() {
            addCriterion("start_city is not null");
            return (Criteria) this;
        }

        public Criteria andStartCityEqualTo(String value) {
            addCriterion("start_city =", value, "startCity");
            return (Criteria) this;
        }

        public Criteria andStartCityNotEqualTo(String value) {
            addCriterion("start_city <>", value, "startCity");
            return (Criteria) this;
        }

        public Criteria andStartCityGreaterThan(String value) {
            addCriterion("start_city >", value, "startCity");
            return (Criteria) this;
        }

        public Criteria andStartCityGreaterThanOrEqualTo(String value) {
            addCriterion("start_city >=", value, "startCity");
            return (Criteria) this;
        }

        public Criteria andStartCityLessThan(String value) {
            addCriterion("start_city <", value, "startCity");
            return (Criteria) this;
        }

        public Criteria andStartCityLessThanOrEqualTo(String value) {
            addCriterion("start_city <=", value, "startCity");
            return (Criteria) this;
        }

        public Criteria andStartCityLike(String value) {
            addCriterion("start_city like", value, "startCity");
            return (Criteria) this;
        }

        public Criteria andStartCityNotLike(String value) {
            addCriterion("start_city not like", value, "startCity");
            return (Criteria) this;
        }

        public Criteria andStartCityIn(List<String> values) {
            addCriterion("start_city in", values, "startCity");
            return (Criteria) this;
        }

        public Criteria andStartCityNotIn(List<String> values) {
            addCriterion("start_city not in", values, "startCity");
            return (Criteria) this;
        }

        public Criteria andStartCityBetween(String value1, String value2) {
            addCriterion("start_city between", value1, value2, "startCity");
            return (Criteria) this;
        }

        public Criteria andStartCityNotBetween(String value1, String value2) {
            addCriterion("start_city not between", value1, value2, "startCity");
            return (Criteria) this;
        }

        public Criteria andEndCityIsNull() {
            addCriterion("end_city is null");
            return (Criteria) this;
        }

        public Criteria andEndCityIsNotNull() {
            addCriterion("end_city is not null");
            return (Criteria) this;
        }

        public Criteria andEndCityEqualTo(String value) {
            addCriterion("end_city =", value, "endCity");
            return (Criteria) this;
        }

        public Criteria andEndCityNotEqualTo(String value) {
            addCriterion("end_city <>", value, "endCity");
            return (Criteria) this;
        }

        public Criteria andEndCityGreaterThan(String value) {
            addCriterion("end_city >", value, "endCity");
            return (Criteria) this;
        }

        public Criteria andEndCityGreaterThanOrEqualTo(String value) {
            addCriterion("end_city >=", value, "endCity");
            return (Criteria) this;
        }

        public Criteria andEndCityLessThan(String value) {
            addCriterion("end_city <", value, "endCity");
            return (Criteria) this;
        }

        public Criteria andEndCityLessThanOrEqualTo(String value) {
            addCriterion("end_city <=", value, "endCity");
            return (Criteria) this;
        }

        public Criteria andEndCityLike(String value) {
            addCriterion("end_city like", value, "endCity");
            return (Criteria) this;
        }

        public Criteria andEndCityNotLike(String value) {
            addCriterion("end_city not like", value, "endCity");
            return (Criteria) this;
        }

        public Criteria andEndCityIn(List<String> values) {
            addCriterion("end_city in", values, "endCity");
            return (Criteria) this;
        }

        public Criteria andEndCityNotIn(List<String> values) {
            addCriterion("end_city not in", values, "endCity");
            return (Criteria) this;
        }

        public Criteria andEndCityBetween(String value1, String value2) {
            addCriterion("end_city between", value1, value2, "endCity");
            return (Criteria) this;
        }

        public Criteria andEndCityNotBetween(String value1, String value2) {
            addCriterion("end_city not between", value1, value2, "endCity");
            return (Criteria) this;
        }

        public Criteria andPeopleNumberIsNull() {
            addCriterion("people_number is null");
            return (Criteria) this;
        }

        public Criteria andPeopleNumberIsNotNull() {
            addCriterion("people_number is not null");
            return (Criteria) this;
        }

        public Criteria andPeopleNumberEqualTo(Integer value) {
            addCriterion("people_number =", value, "peopleNumber");
            return (Criteria) this;
        }

        public Criteria andPeopleNumberNotEqualTo(Integer value) {
            addCriterion("people_number <>", value, "peopleNumber");
            return (Criteria) this;
        }

        public Criteria andPeopleNumberGreaterThan(Integer value) {
            addCriterion("people_number >", value, "peopleNumber");
            return (Criteria) this;
        }

        public Criteria andPeopleNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("people_number >=", value, "peopleNumber");
            return (Criteria) this;
        }

        public Criteria andPeopleNumberLessThan(Integer value) {
            addCriterion("people_number <", value, "peopleNumber");
            return (Criteria) this;
        }

        public Criteria andPeopleNumberLessThanOrEqualTo(Integer value) {
            addCriterion("people_number <=", value, "peopleNumber");
            return (Criteria) this;
        }

        public Criteria andPeopleNumberIn(List<Integer> values) {
            addCriterion("people_number in", values, "peopleNumber");
            return (Criteria) this;
        }

        public Criteria andPeopleNumberNotIn(List<Integer> values) {
            addCriterion("people_number not in", values, "peopleNumber");
            return (Criteria) this;
        }

        public Criteria andPeopleNumberBetween(Integer value1, Integer value2) {
            addCriterion("people_number between", value1, value2, "peopleNumber");
            return (Criteria) this;
        }

        public Criteria andPeopleNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("people_number not between", value1, value2, "peopleNumber");
            return (Criteria) this;
        }

        public Criteria andLeftTicketIsNull() {
            addCriterion("left_ticket is null");
            return (Criteria) this;
        }

        public Criteria andLeftTicketIsNotNull() {
            addCriterion("left_ticket is not null");
            return (Criteria) this;
        }

        public Criteria andLeftTicketEqualTo(Integer value) {
            addCriterion("left_ticket =", value, "leftTicket");
            return (Criteria) this;
        }

        public Criteria andLeftTicketNotEqualTo(Integer value) {
            addCriterion("left_ticket <>", value, "leftTicket");
            return (Criteria) this;
        }

        public Criteria andLeftTicketGreaterThan(Integer value) {
            addCriterion("left_ticket >", value, "leftTicket");
            return (Criteria) this;
        }

        public Criteria andLeftTicketGreaterThanOrEqualTo(Integer value) {
            addCriterion("left_ticket >=", value, "leftTicket");
            return (Criteria) this;
        }

        public Criteria andLeftTicketLessThan(Integer value) {
            addCriterion("left_ticket <", value, "leftTicket");
            return (Criteria) this;
        }

        public Criteria andLeftTicketLessThanOrEqualTo(Integer value) {
            addCriterion("left_ticket <=", value, "leftTicket");
            return (Criteria) this;
        }

        public Criteria andLeftTicketIn(List<Integer> values) {
            addCriterion("left_ticket in", values, "leftTicket");
            return (Criteria) this;
        }

        public Criteria andLeftTicketNotIn(List<Integer> values) {
            addCriterion("left_ticket not in", values, "leftTicket");
            return (Criteria) this;
        }

        public Criteria andLeftTicketBetween(Integer value1, Integer value2) {
            addCriterion("left_ticket between", value1, value2, "leftTicket");
            return (Criteria) this;
        }

        public Criteria andLeftTicketNotBetween(Integer value1, Integer value2) {
            addCriterion("left_ticket not between", value1, value2, "leftTicket");
            return (Criteria) this;
        }

        public Criteria andTicketPriceIsNull() {
            addCriterion("ticket_price is null");
            return (Criteria) this;
        }

        public Criteria andTicketPriceIsNotNull() {
            addCriterion("ticket_price is not null");
            return (Criteria) this;
        }

        public Criteria andTicketPriceEqualTo(Float value) {
            addCriterion("ticket_price =", value, "ticketPrice");
            return (Criteria) this;
        }

        public Criteria andTicketPriceNotEqualTo(Float value) {
            addCriterion("ticket_price <>", value, "ticketPrice");
            return (Criteria) this;
        }

        public Criteria andTicketPriceGreaterThan(Float value) {
            addCriterion("ticket_price >", value, "ticketPrice");
            return (Criteria) this;
        }

        public Criteria andTicketPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("ticket_price >=", value, "ticketPrice");
            return (Criteria) this;
        }

        public Criteria andTicketPriceLessThan(Float value) {
            addCriterion("ticket_price <", value, "ticketPrice");
            return (Criteria) this;
        }

        public Criteria andTicketPriceLessThanOrEqualTo(Float value) {
            addCriterion("ticket_price <=", value, "ticketPrice");
            return (Criteria) this;
        }

        public Criteria andTicketPriceIn(List<Float> values) {
            addCriterion("ticket_price in", values, "ticketPrice");
            return (Criteria) this;
        }

        public Criteria andTicketPriceNotIn(List<Float> values) {
            addCriterion("ticket_price not in", values, "ticketPrice");
            return (Criteria) this;
        }

        public Criteria andTicketPriceBetween(Float value1, Float value2) {
            addCriterion("ticket_price between", value1, value2, "ticketPrice");
            return (Criteria) this;
        }

        public Criteria andTicketPriceNotBetween(Float value1, Float value2) {
            addCriterion("ticket_price not between", value1, value2, "ticketPrice");
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