package com.ticketsystem.dao;

import com.ticketsystem.model.OrderForm;
import com.ticketsystem.model.OrderFormExample.Criteria;
import com.ticketsystem.model.OrderFormExample.Criterion;
import com.ticketsystem.model.OrderFormExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OrderFormSqlProvider {

    public String countByExample(OrderFormExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("order_form");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OrderFormExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("order_form");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OrderForm record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("order_form");
        
        if (record.getOrderFormId() != null) {
            sql.VALUES("order_form_id", "#{orderFormId,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        
        if (record.getTicketNumber() != null) {
            sql.VALUES("ticket_number", "#{ticketNumber,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalPrice() != null) {
            sql.VALUES("total_price", "#{totalPrice,jdbcType=REAL}");
        }
        
        if (record.getOrderTime() != null) {
            sql.VALUES("order_time", "#{orderTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(OrderFormExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("order_form_id");
        } else {
            sql.SELECT("order_form_id");
        }
        sql.SELECT("user_id");
        sql.SELECT("ticket_number");
        sql.SELECT("total_price");
        sql.SELECT("order_time");
        sql.FROM("order_form");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OrderForm record = (OrderForm) parameter.get("record");
        OrderFormExample example = (OrderFormExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("order_form");
        
        if (record.getOrderFormId() != null) {
            sql.SET("order_form_id = #{record.orderFormId,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{record.userId,jdbcType=INTEGER}");
        }
        
        if (record.getTicketNumber() != null) {
            sql.SET("ticket_number = #{record.ticketNumber,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalPrice() != null) {
            sql.SET("total_price = #{record.totalPrice,jdbcType=REAL}");
        }
        
        if (record.getOrderTime() != null) {
            sql.SET("order_time = #{record.orderTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("order_form");
        
        sql.SET("order_form_id = #{record.orderFormId,jdbcType=INTEGER}");
        sql.SET("user_id = #{record.userId,jdbcType=INTEGER}");
        sql.SET("ticket_number = #{record.ticketNumber,jdbcType=DECIMAL}");
        sql.SET("total_price = #{record.totalPrice,jdbcType=REAL}");
        sql.SET("order_time = #{record.orderTime,jdbcType=TIMESTAMP}");
        
        OrderFormExample example = (OrderFormExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OrderForm record) {
        SQL sql = new SQL();
        sql.UPDATE("order_form");
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=INTEGER}");
        }
        
        if (record.getTicketNumber() != null) {
            sql.SET("ticket_number = #{ticketNumber,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalPrice() != null) {
            sql.SET("total_price = #{totalPrice,jdbcType=REAL}");
        }
        
        if (record.getOrderTime() != null) {
            sql.SET("order_time = #{orderTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("order_form_id = #{orderFormId,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OrderFormExample example, boolean includeExamplePhrase) {
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