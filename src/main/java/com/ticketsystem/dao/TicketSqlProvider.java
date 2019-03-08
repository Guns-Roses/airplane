package com.ticketsystem.dao;

import com.ticketsystem.model.Ticket;
import com.ticketsystem.model.TicketExample.Criteria;
import com.ticketsystem.model.TicketExample.Criterion;
import com.ticketsystem.model.TicketExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class TicketSqlProvider {

    public String countByExample(TicketExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("ticket");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(TicketExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("ticket");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Ticket record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("ticket");
        
        if (record.getTicketId() != null) {
            sql.VALUES("ticket_id", "#{ticketId,jdbcType=INTEGER}");
        }
        
        if (record.getFlightId() != null) {
            sql.VALUES("flight_id", "#{flightId,jdbcType=INTEGER}");
        }
        
        if (record.getOrderFormId() != null) {
            sql.VALUES("order_form_id", "#{orderFormId,jdbcType=INTEGER}");
        }
        
        if (record.getPrice() != null) {
            sql.VALUES("price", "#{price,jdbcType=REAL}");
        }
        
        if (record.getDiscount() != null) {
            sql.VALUES("discount", "#{discount,jdbcType=REAL}");
        }
        
        if (record.getPassengerName() != null) {
            sql.VALUES("passenger_name", "#{passengerName,jdbcType=CHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(TicketExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("ticket_id");
        } else {
            sql.SELECT("ticket_id");
        }
        sql.SELECT("flight_id");
        sql.SELECT("order_form_id");
        sql.SELECT("price");
        sql.SELECT("discount");
        sql.SELECT("passenger_name");
        sql.FROM("ticket");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Ticket record = (Ticket) parameter.get("record");
        TicketExample example = (TicketExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("ticket");
        
        if (record.getTicketId() != null) {
            sql.SET("ticket_id = #{record.ticketId,jdbcType=INTEGER}");
        }
        
        if (record.getFlightId() != null) {
            sql.SET("flight_id = #{record.flightId,jdbcType=INTEGER}");
        }
        
        if (record.getOrderFormId() != null) {
            sql.SET("order_form_id = #{record.orderFormId,jdbcType=INTEGER}");
        }
        
        if (record.getPrice() != null) {
            sql.SET("price = #{record.price,jdbcType=REAL}");
        }
        
        if (record.getDiscount() != null) {
            sql.SET("discount = #{record.discount,jdbcType=REAL}");
        }
        
        if (record.getPassengerName() != null) {
            sql.SET("passenger_name = #{record.passengerName,jdbcType=CHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("ticket");
        
        sql.SET("ticket_id = #{record.ticketId,jdbcType=INTEGER}");
        sql.SET("flight_id = #{record.flightId,jdbcType=INTEGER}");
        sql.SET("order_form_id = #{record.orderFormId,jdbcType=INTEGER}");
        sql.SET("price = #{record.price,jdbcType=REAL}");
        sql.SET("discount = #{record.discount,jdbcType=REAL}");
        sql.SET("passenger_name = #{record.passengerName,jdbcType=CHAR}");
        
        TicketExample example = (TicketExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Ticket record) {
        SQL sql = new SQL();
        sql.UPDATE("ticket");
        
        if (record.getFlightId() != null) {
            sql.SET("flight_id = #{flightId,jdbcType=INTEGER}");
        }
        
        if (record.getOrderFormId() != null) {
            sql.SET("order_form_id = #{orderFormId,jdbcType=INTEGER}");
        }
        
        if (record.getPrice() != null) {
            sql.SET("price = #{price,jdbcType=REAL}");
        }
        
        if (record.getDiscount() != null) {
            sql.SET("discount = #{discount,jdbcType=REAL}");
        }
        
        if (record.getPassengerName() != null) {
            sql.SET("passenger_name = #{passengerName,jdbcType=CHAR}");
        }
        
        sql.WHERE("ticket_id = #{ticketId,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, TicketExample example, boolean includeExamplePhrase) {
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