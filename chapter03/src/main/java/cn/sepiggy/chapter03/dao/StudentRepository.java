package cn.sepiggy.chapter03.dao;

import cn.sepiggy.chapter03.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    // 默认使用JPQL作为查询语句，JPQL查询语句与HQL查询语句一致，查询的类名和属性名严格区分大小写
    @Query("from Student where name like %?1%")
    List<Student> findStudentsByName(String studentName);

    // 根据学生的姓名和地址模糊查询
    // 通过问号占位符绑定
    @Query("from Student where name like %?1% and address like %?2%")
    List<Student> findStudentsByNameAndAddress(String studentName, String address);

    // findStudentsByNameAndAddress的原生SQL版本
    // 原生SQL查询，需要将nativeQuery属性设置为true
    // 通过问号占位符绑定
    @Query(value = "select * from t_stu where name like %?1% and address like %?2%", nativeQuery = true)
    List<Student> findStudentsByNameAndAddressSQL(String studentName, String address);

    // 通过命名参数绑定
    @Query("from Student where name like %:name% and address like %:address%")
    List<Student> findStudentsParam(@Param("name") String studentName, @Param("address") String address);

    // @Modifying注解标记该方法是一个修改方法
    @Modifying
    @Query("update Student set name = :name where id = :id")
    int updateStudent(@Param("name") String studentName, @Param("id") Integer id);

    // 删除
    @Modifying
    @Query("delete from Student where id = :id")
    int deleteStudent(@Param("id") Integer id);
}
