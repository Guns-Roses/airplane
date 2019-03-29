#毕业设计-飞机订票系统

---

>##1.开发环境
-
    ####开发环境详细说明

        
        *   操作系统：win10
        
        *   数据库：mysql——5.6.7
        
        *   开发语言：java(jdk8)
        
        *   开发工具：IDEA
        
        *   代码管理工具：GitHub

>##2.技术实现
-
    ####技术实现详细说明

    
        *   后台：  springboot+mybatis+maven+swagger2+logging 
        
        *   前端：  html5+javaScripts+ajax+jQuery+BootStrap  
        
        *  数据库： mysql 

>## 3.数据库
-
    ####数据库建表以及具体字段
        
        
        *   flight:       flight_id,start_time,start_city,end_city,people_number,left_ticket,ticket_price
        
        *   order_form:   order_form_id,user_id,ticket_number,total_price,order_time
        
        *   ticket:      ticket_id,filght_id,order_form_id,price,discount,passenger_name
        
        *   user:        user_id,is_manager,user_name,user_password,is_VIP

>## 4.项目结构说明
- com.ticketsystem.controller 机票api出口，包含所有业务的api
    
    ### 控制层，处理外部请求，调用service层
    
    
        *   FlightController
        
        *   loginController
        
        *   OrderFormController
        
        *   TicketController
        
- com.ticketsystem.dao 数据访问层类库   
    
    ### 数据库操作对于某个表、某个实体的增删改查，实现数据的持久化
        
        
        *   FlightProvider
        
        *   FlightSqlProvider
        
        *   OrderFormProvider
        
        *   OrderFormSqlProvider
        
        *   TicketProvider
            
        *   TicketSqlProvider
        
        *   UserProvider
        
        *   UserSqlProvider
       
        
- com.ticketsystem.model 模型类库

    ### 数据库表的实体类和资助定义的包装类
    
    
        *   Flight
           
        *   FlightExample
            
        *   OrderForm
           
        *   OrderFormExample
            
        *   Ticket
            
        *   TicketExample
            
        *   User
            
        *   UserExample
        
        
- com.ticketsystem.service 服务类库   

    ### 封装类库，实现“高内聚，低耦合”， 引用对应的Dao数据库操作的具体实现，并且对应到controller层
    
    
        *   CheckService
        
        *   FlightService
        
        *   FormService
        
        *   TicketService