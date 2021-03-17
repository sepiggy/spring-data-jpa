package cn.sepiggy.chapter01.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity // 标记该类是一个持久化类（与数据库的表进行关联）
@Table(name = "t_user") // 指定表名，当类名与表名一致时，可省略不写
public class User {
    @Id // 标记该属性是一个主键字段
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 指定主键生成策略
    private Integer id;
    private String userName;
    private Integer age;
    private String address;
    @Transient // 标明该属性不会自动匹配到数据库表中
    private String gender;
}
