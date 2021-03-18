package cn.sepiggy.chapter03.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="t_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userName;
    private Integer age;
    private String address;
    @Transient
    private String gender;
}
