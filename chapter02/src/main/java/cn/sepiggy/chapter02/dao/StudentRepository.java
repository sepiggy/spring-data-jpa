package cn.sepiggy.chapter02.dao;

import cn.sepiggy.chapter02.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * JpaRepository接口: 用于执行增删改查操作，该接口是最常用的接口
 * JpaSpecificationExecutor接口: 用于实现动态条件查询
 */
public interface StudentRepository extends
        JpaRepository<Student, Integer>, JpaSpecificationExecutor<Student> {
}
