package com.shamengxin.springboot;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @BootstrapWith(SpringBootTestContextBootstrapper.class)
 * @ExtendWith({SpringExtension.class})
 */
// @SpringBootTest
@DisplayName("Junit5功能测试类")
public class Junit5Test {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 测试前置条件
     */
    @DisplayName("前置条件")
    @Test
    void testAssumptions(){
        Assumptions.assumeTrue(false,"结果不是true");
        System.out.println("1111111");
    }

    @DisplayName("快速失败")
    @Test
    void testFail(){
        if(1==2) {
            fail("测试失败");
        }
    }

    @DisplayName("异常断言")
    @Test
    void testException(){
        assertThrows(ArithmeticException.class,()->{int i=10/0;},"业务逻辑居然正常运行");
    }

    @Test
    @DisplayName("组合断言")
    void all() {
        assertAll("test",
                () -> assertTrue(true && true,"结果不为true"),
                ()->assertEquals(1,1,"结果不是1"));
    }

    /**
     * 数组断言
     */
    @Test
    @DisplayName("array assertion")
    public void array() {
        assertArrayEquals(new int[]{2, 1}, new int[]{1, 2});
    }

    @DisplayName("测试简单断言")
    @Test
    void testSimpleAssertions() {
        int count = count(3, 2);
        assertEquals(5, count, "业务逻辑计算失败");
        Object obj1 = new Object();
        Object obj2 = new Object();
        assertSame(obj2, obj1, "两个对象不同");
    }

    int count(int i, int j) {
        return i + j;
    }

    @DisplayName("测试displayName注解")
    @Test
    void testDisplayName() {
        System.out.println(1);
        System.out.println(jdbcTemplate);
    }

    @RepeatedTest(5)
    @Test
    void test3() {
        System.out.println(3);
    }

    @Disabled
    @DisplayName("测试方法2")
    @Test
    void test2() {
        System.out.println(2);
    }

    /**
     * 规定方法的超时时间。超出时间测试出异常
     *
     * @throws InterruptedException
     */
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    @Test
    void testTimeOut() throws InterruptedException {
        Thread.sleep(600);
    }

    @BeforeEach
    void testBeforeEach() {
        System.out.println("测试就要开始了。。。。");
    }

    @AfterEach
    void testAfterEach() {
        System.out.println("测试结束了。。。。");
    }

    @BeforeAll
    static void testBeforeAll() {
        System.out.println("所有测试就要开始了。。。。。");
    }

    @AfterAll
    static void testAfterAll() {
        System.out.println("所有测试已经结束。。。。。");
    }


}
