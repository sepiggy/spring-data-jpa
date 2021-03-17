package cn.sepiggy.chapter01.dao;

import cn.sepiggy.chapter01.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * 自定义数据访问层的接口需要继承JPA提供的七大接口任意一个
 * CrudRepository<T,ID>是JPA提供的用于实现增删改查的接口
 * T是实体类型，ID是主键类型
 */
public interface UserRepository extends CrudRepository<User, Integer> {
}
