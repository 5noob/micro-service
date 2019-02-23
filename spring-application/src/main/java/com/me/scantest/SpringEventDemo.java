package com.me.scantest;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.event.SimpleApplicationEventMulticaster;

/**
 * @author OuyangJie
 * @Date 2019/2/18 9:18
 * @Description:
 */
public class SpringEventDemo {
    public static void main(String[] args) {
        //事件生产者
        SimpleApplicationEventMulticaster multicaster = new SimpleApplicationEventMulticaster();
        //事件消费者
        ApplicationListener listener = event -> {
            if (event instanceof MyPayloadApplicationEvent) {
                System.out.println("接收到payload事件：" + event + PayloadApplicationEvent.class.cast(event).getPayload());
            } else {
                System.out.println("接收到事件：" + event);
            }
        };

        multicaster.addApplicationListener(listener);

        multicaster.multicastEvent(new MyApplicationEvent<Object>("Hello World"));
        multicaster.multicastEvent(new MyPayloadApplicationEvent<Object>("1", "payload"));
    }

    private static class MyApplicationEvent<Object> extends ApplicationEvent {

        public MyApplicationEvent(Object source) {
            super(source);
        }
    }

    private static class MyPayloadApplicationEvent<Object> extends PayloadApplicationEvent {

        /**
         * Create a new PayloadApplicationEvent.
         *
         * @param source  the object on which the event initially occurred (never {@code null})
         * @param payload the payload object (never {@code null})
         */
        public MyPayloadApplicationEvent(Object source, Object payload) {
            super(source, payload);
        }
    }
}
