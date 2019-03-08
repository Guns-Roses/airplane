package com.ticketsystem.dao;

import com.ticketsystem.model.Flight;
import com.ticketsystem.model.FlightExample.Criteria;
import com.ticketsystem.model.FlightExample.Criterion;
import com.ticketsystem.model.FlightExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class FlightSqlProvider {

    public String countByExample(FlightExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("flight");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(FlightExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("flight");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Flight record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("flight");
        
        if (record.getFlightId() != null) {
            sql.VALUES("flight_id", "#{flightId,jdbcType=INTEGER}");
        }
        
        if (record.getStartTime() != null) {
            sql.VALUES("start_time", "#{startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStartCity() != null) {
            sql.VALUES("start_city", "#{startCity,jdbcType=CHAR}");
        }
        
        if (record.getEndCity() != null) {
            sql.VALUES("end_city", "#{endCity,jdbcType=CHAR}");
        }
        
        if (record.getPeopleNumber() != null) {
            sql.VALUES("people_number", "#{peopleNumber,jdbcType=DECIMAL}");
        }
        
        if (record.getLeftTicket() != null) {
            sql.VALUES("left_ticket", "#{leftTicket,jdbcType=DECIMAL}");
        }
        
        if (record.getTicketPrice() != null) {
            sql.VALUES("ticket_price", "#{ticketPrice,jdbcType=REAL}");
        }
        
        return sql.toString();
    }

    public String selectByExample(FlightExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("flight_id");
        } else {
            sql.SELECT("flight_id");
        }
        sql.SELECT("start_time");
        sql.SELECT("start_city");
        sql.SELECT("end_city");
        sql.SELECT("people_number");
        sql.SELECT("left_ticket");
        sql.SELECT("ticket_price");
        sql.FROM("flight");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Flight record = (Flight) parameter.get("record");
        FlightExample example = (FlightExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("flight");
        
        if (record.getFlightId() != null) {
            sql.SET("flight_id = #{record.flightId,jdbcType=INTEGER}");
        }
        
        if (record.getStartTime() != null) {
            sql.SET("start_time = #{record.startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStartCity() != null) {
            sql.SET("start_city = #{record.startCity,jdbcType=CHAR}");
        }
        
        if (record.getEndCity() != null) {
            sql.SET("end_city = #{record.endCity,jdbcType=CHAR}");
        }
        
        if (record.getPeopleNumber() != null) {
            sql.SET("people_number = #{record.peopleNumber,jdbcType=DECIMAL}");
        }
        
        if (record.getLeftTicket() != null) {
            sql.SET("left_ticket = #{record.leftTicket,jdbcType=DECIMAL}");
        }
        
        if (record.getTicketPrice() != null) {
            sql.SET("ticket_price = #{record.ticketPrice,jdbcType=REAL}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("flight");
        
        sql.SET("flight_id = #{record.flightId,jdbcType=INTEGER}");
        sql.SET("start_time = #{record.startTime,jdbcType=TIMESTAMP}");
        sql.SET("start_city = #{record.startCity,jdbcType=CHAR}");
        sql.SET("end_city = #{record.endCity,jdbcType=CHAR}");
        sql.SET("people_number = #{record.peopleNumber,jdbcType=DECIMAL}");
        sql.SET("left_ticket = #{record.leftTicket,jdbcType=DECIMAL}");
        sql.SET("ticket_price = #{record.ticketPrice,jdbcType=REAL}");
        
        FlightExample example = (FlightExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Flight record) {
        SQL sql = new SQL();
        sql.UPDATE("flight");
        
        if (record.getStartTime() != null) {
            sql.SET("start_time = #{startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStartCity() != null) {
            sql.SET("start_city = #{startCity,jdbcType=CHAR}");
        }
        
        if (record.getEndCity() != null) {
            sql.SET("end_city = #{endCity,jdbcType=CHAR}");
        }
        
        if (record.getPeopleNumber() != null) {
            sql.SET("people_number = #{peopleNumber,jdbcType=DECIMAL}");
        }
        
        if (record.getLeftTicket() != null) {
            sql.SET("left_ticket = #{leftTicket,jdbcType=DECIMAL}");
        }
        
        if (record.getTicketPrice() != null) {
            sql.SET("ticket_price = #{ticketPrice,jdbcType=REAL}");
        }
        
        sql.WHERE("flight_id = #{flightId,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, FlightExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}