package com.iswhl;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitMqApplicationTests {

    // 注入AmqpTemplate模板
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void testSend() throws InterruptedException {
        String msg = "hello, Spring boot amqp";
        // 通过AmqpTemplate模板发送消息
        // 参数1：交换机
        // 参数2：a.b是否符合监听组件(消息消费者)中定义的消息接收的路由表达式
        // 参数3：消息内容
        this.amqpTemplate.convertAndSend("spring.test.exchange","a.b", msg);
        // 等待10秒后再结束
        Thread.sleep(10000);
    }


}
