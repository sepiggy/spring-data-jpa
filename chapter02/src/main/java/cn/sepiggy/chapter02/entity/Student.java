package cn.sepiggy.chapter02.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_stu")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer age;
    private String address;
    @Transient
    private String gender;
}
