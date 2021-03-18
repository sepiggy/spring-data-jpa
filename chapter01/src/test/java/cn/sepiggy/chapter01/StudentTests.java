package cn.sepiggy.chapter01;

import cn.sepiggy.chapter01.dao.StudentRepository;
import cn.sepiggy.chapter01.entity.Student;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.annotation.Resource;

@SpringBootTest
public class StudentTests {

    @Resource
    private StudentRepository studentRepository;

    @Test
    public void makeData() {
        for (int i = 0; i < 10; i++) {
            val stu = new Student();
            stu.setName("张三" + i);
            stu.setAddress("哈尔滨");
            stu.setAge(20 + i);
            studentRepository.save(stu);
        }

        for (int i = 0; i < 10; i++) {
            val stu = new Student();
            stu.setName("李四" + i);
            stu.setAddress("大连");
            stu.setAge(21 + i);
            studentRepository.save(stu);
        }

        for (int i = 0; i < 10; i++) {
            val stu = new Student();
            stu.setName("王五" + i);
            stu.setAddress("北京");
            stu.setAge(22 + i);
            studentRepository.save(stu);
        }
    }

    @Test
    public void testSort() {
        // 创建排序对象
        // 根据id属性降序
        // 先根据id排序，再根据age排序
        val sort = Sort.by(Sort.Direction.DESC, "id", "age");
        // 调用排序查询的方法
        val studentIterable = studentRepository.findAll(sort);
        // 获取迭代器对象
        val iterator = studentIterable.iterator();
        // 循环
        while (iterator.hasNext()) {
            val student = iterator.next();
            System.out.println(student);
        }
    }

    @Test
    public void testPage() {
        // 当前页码
        val pageNo = 1;
        // 每页显示数量
        val pageSize = 3;
        // 设置分页信息
        // 当前页码从0开始 (0是第1页)
        // val pageRequest = PageRequest.of(pageNo - 1, pageSize);
        val pageRequest = PageRequest.of(pageNo - 1, pageSize, Sort.Direction.DESC, "age");

        // 调用分页查询方法
        val studentPage = studentRepository.findAll(pageRequest);
        System.out.println("当前页码: " + (studentPage.getNumber()+1));
        System.out.println("每页显示数量: " + studentPage.getSize());
        System.out.println("总数量: " + studentPage.getTotalElements());
        System.out.println("总页数: " + studentPage.getTotalPages());
        val studentList = studentPage.getContent();
        // 获取数据列表
        studentList.forEach(System.out::println);

    }
}
