package cn.sepiggy.chapter03;

import cn.sepiggy.chapter03.dao.StudentRepository;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@SpringBootTest
public class StudentTests {

    @Resource
    private StudentRepository studentRepository;

    @Test
    void test1() {
        // 调用根据学生姓名查询的方法
        val studentList = studentRepository.findStudentsByName("李");
        studentList.forEach(System.out::println);
    }

    @Test
    void test2() {
        // 调用根据学生姓名和地址查询的方法
        val studentList = studentRepository.findStudentsByNameAndAddress("李", "长春");
        studentList.forEach(System.out::println);
    }

    @Test
    void test3() {
        val studentList = studentRepository.findStudentsByNameAndAddress("李", "长春");
        studentList.forEach(System.out::println);
    }

    @Test
    void test4() {
        val studentList = studentRepository.findStudentsByNameAndAddress("李", "长春");
        studentList.forEach(System.out::println);
    }

    // 执行update / delete查询方法需要开启事务
    @Transactional
    // 禁止自动回滚事务
    // @Rollback(false)
    @Commit
    @Test
    void test5() {
        studentRepository.updateStudent("张大大", 2);
    }

    @Transactional
    @Commit
    @Test
    void test6() {
        studentRepository.deleteStudent(10);
    }
}
