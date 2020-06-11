# spring_study      spring的学习

官方文档：
https://docs.spring.io/spring/docs/5.2.7.RELEASE/spring-framework-reference/core.html#spring-core

bean的自动装配很方便，通过autowire="byName"或byType实现，但是各有利弊
通过注解实现自动装配，都常用
    @Autowired   通过byType实现
    private String name;
    @Resource    通过byName实现，找不到，就通过byType
    private Jack adrees;

spring最核心的是注解(多看看),但是大多数还是会用xml文件配置，注解只用在注入上

Java-based Container Configuration  1.12.1  废弃xml，用纯Java类来配置
（javaconfig是spring的子项目，也是个核心功能）


