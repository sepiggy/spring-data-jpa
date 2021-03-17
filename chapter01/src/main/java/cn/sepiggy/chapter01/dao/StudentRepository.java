package cn.sepiggy.chapter01.dao;

import cn.sepiggy.chapter01.entity.Student;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * PagingAndSortingRepository接口: 主要用于分页和排序操作
 * 该接口继承的是CrudRepository接口
 */
public interface StudentRepository extends PagingAndSortingRepository<Student, Integer> {
}
