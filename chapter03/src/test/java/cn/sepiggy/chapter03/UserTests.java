package cn.sepiggy.chapter03;

import cn.sepiggy.chapter03.dao.UserRepository;
import cn.sepiggy.chapter03.entity.User;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class UserTests {

    @Resource
    private UserRepository userRepository;

    @Test
    void test1() {
        val userList = userRepository.findByUserNameLike("%李%");
        userList.forEach(System.out::println);
    }

    @Test
    void test2() {
        val userList = userRepository.findByAgeGreaterThanEqual(20);
        userList.forEach(System.out::println);
    }

    @Test
    void test3() {
        val userList = userRepository.findByUserNameLikeAndAgeGreaterThan("%李%", 18);
        userList.forEach(System.out::println);
    }

}
