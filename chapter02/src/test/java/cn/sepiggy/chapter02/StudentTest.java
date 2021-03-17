package cn.sepiggy.chapter02;

import cn.sepiggy.chapter02.dao.StudentRepository;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class StudentTest {

    @Resource
    private StudentRepository studentRepository;

    @Test
    void testFindAll() {
        val studentList = studentRepository.findAll();
        studentList.forEach(System.out::println);
    }

}
