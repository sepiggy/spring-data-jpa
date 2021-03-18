package cn.sepiggy.chapter03.dao;

import cn.sepiggy.chapter03.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    // 默认使用JPQL作为查询语句，JPQL查询语句与HQL查询语句一致，查询的类名和属性名严格区分大小写
    @Query("from Student where name like %?1%")
    List<Student> findStudentsByName(String studentName);

    // 根据学生的姓名和地址模糊查询
    @Query("from Student where name like %?1% and address like %?2%")
    List<Student> findStudentsByNameAndAddress(String studentName, String address);

    // findStudentsByNameAndAddress的原生SQL版本
    // 原生SQL查询，需要将nativeQuery属性设置为true
    @Query(value = "select * from t_stu where name like %?1% and address like %?2%", nativeQuery = true)
    List<Student> findStudentsByNameAndAddressSQL(String studentName, String address);
}
