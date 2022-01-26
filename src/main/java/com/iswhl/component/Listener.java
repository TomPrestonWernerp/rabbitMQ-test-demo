package com.iswhl.component;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * RabbitMQ 监听器组件：相当于消费者
 */
@Component
public class Listener {

    @RabbitListener(bindings = @QueueBinding(
            // value = "spring.test.queue" 队列名称
            // durable = "true" 队列消息持久化
            value = @Queue(value = "spring.test.queue", durable = "true"),
            // value = "spring.test.exchange" 交换机名称
            // durable = "true" 交换机消息持久化
            // ignoreDeclarationExceptions = "true" 忽略声明异常
            // type = ExchangeTypes.TOPIC 交换机类型：TOPIC
            exchange = @Exchange(
                    value = "spring.test.exchange",
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.TOPIC
//                    durable = "true"
            ),
            // 消息接收的路由表达式
            key = {"#.#"}))

    public void listen(String msg) {
        System.out.println("接收到消息：" + msg);
    }
}
