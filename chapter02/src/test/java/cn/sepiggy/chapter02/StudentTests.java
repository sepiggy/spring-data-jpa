package cn.sepiggy.chapter02;

import cn.sepiggy.chapter02.dao.StudentRepository;
import cn.sepiggy.chapter02.entity.Student;
import cn.sepiggy.chapter02.vo.StudentVO;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@SpringBootTest
class StudentTests {

    @Resource
    private StudentRepository studentRepository;

    @Test
    void testFindAll() {
        val studentList = studentRepository.findAll();
        studentList.forEach(System.out::println);
    }

    @Test
    void testDynamicSelect() {
        // 创建查询条件对象
        val studentVO = new StudentVO();
//        studentVO.setName("四");
        studentVO.setAge(25);
        studentVO.setAddress("北京");

        // 调用动态查询方法
        val studentList = studentRepository.findAll((Specification<Student>) (root, query, builder) -> {
            // 获取条件对象
            val predicate = builder.conjunction();
            // 判断查询条件对象是否为空
            if (studentVO != null) {
                // 按姓名模糊查询
                if (!ObjectUtils.isEmpty(studentVO.getName())) {
                    // root.get("实体类的属性名称")
                    predicate.getExpressions().add(builder.like(root.get("name"), "%" + studentVO.getName() + "%"));
                }
                // 查询大于指定年龄
                if (!ObjectUtils.isEmpty(studentVO.getAge())) {
                    predicate.getExpressions().add(builder.ge(root.get("age"), studentVO.getAge()));
                }
                // 按地址模糊查询
                if (!ObjectUtils.isEmpty(studentVO.getAddress())) {
                    predicate.getExpressions().add(builder.like(root.get("address"), "%" + studentVO.getAddress() + "%"));
                }
            }
            return predicate;
        });

        // 循环遍历
        studentList.forEach(System.out::println);
    }

    @Test
    void testDynamicPagingSelect() {
        // 创建查询条件对象
        val studentVO = new StudentVO();
//        studentVO.setName("四");
        studentVO.setAge(25);
        studentVO.setAddress("北京");

        // 创建分页对象
        val pageRequest = PageRequest.of(0, 3, Sort.Direction.ASC, "id");

        // 分页动态查询
        val studentPage = studentRepository.findAll((Specification<Student>) (root, query, builder) -> {
            // 获取条件对象
            val predicate = builder.conjunction();
            // 判断查询条件对象是否为空
            if (studentVO != null) {
                // 按姓名模糊查询
                if (!ObjectUtils.isEmpty(studentVO.getName())) {
                    // root.get("实体类的属性名称")
                    predicate.getExpressions().add(builder.like(root.get("name"), "%" + studentVO.getName() + "%"));
                }
                // 查询大于指定年龄
                if (!ObjectUtils.isEmpty(studentVO.getAge())) {
                    predicate.getExpressions().add(builder.ge(root.get("age"), studentVO.getAge()));
                }
                // 按地址模糊查询
                if (!ObjectUtils.isEmpty(studentVO.getAddress())) {
                    predicate.getExpressions().add(builder.like(root.get("address"), "%" + studentVO.getAddress() + "%"));
                }
            }
            return predicate;
        }, pageRequest);

        studentPage.getContent().forEach(System.out::println);
    }

}
