﻿
spring-ibatis-0 SqlMapClientTemplate
spring-ibatis-1 SqlMapClient

SqlMapClientTemplate是org.springframework.orm.ibatis下的
而SqlMapClient是ibatis的
SqlMapClientTemplate是SqlMapClient的封装类. 
SqlMapClient中包含着session的管理. 
SqlMapClientTemplate用于session的封装,以及异常的捕捉. 
所以按照以上的推断来说.应该尽量使用SqlMapClientTemplate. 
保证session以及Exception的正常以及统一.


typeAlias 在xml中的使用