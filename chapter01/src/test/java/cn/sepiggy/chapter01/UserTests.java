package cn.sepiggy.chapter01;

import cn.sepiggy.chapter01.dao.UserRepository;
import cn.sepiggy.chapter01.entity.User;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class UserTests {

    @Resource
    private UserRepository userRepository;

    @Test
    void testSave() {
        // 创建对象
        val user = new User();
        user.setUserName("王五");
        user.setAddress("北京市朝阳区");
        user.setAge(20);
        // user.setId(20); // 一旦指定Id, isNew()方法则返回false
        // 调用保存的方法
        val flag = userRepository.save(user);
        if (flag != null) {
            System.out.println("添加或修改成功");
        } else {
            System.out.println("添加或修改失败");
        }
    }

    @Test
    void testFindById() {
        val optionalUser = userRepository.findById(1);
        System.out.println(optionalUser.get());
    }

    @Test
    void testFindAll() {
        // 调用查询所有数据的方法
        val userIterable = userRepository.findAll();
        // 获取迭代器对象
        val iterator = userIterable.iterator();
        // 循环遍历
        while (iterator.hasNext()) {
            // 循环获取到每一个用户对象
            val user = iterator.next();
            System.out.println(user);
        }
    }

    @Test
    void testCount() {
        val count = userRepository.count();
        System.out.println(count);
    }

    @Test
    void testDeleteById() {
        userRepository.deleteById(3);
    }

}
