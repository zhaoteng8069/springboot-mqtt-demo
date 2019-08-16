package com.ssnow.mtqq.demo.mqttGateway;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;

/**
 * @className MqttGateway
 * @Description TODO
 * @Author zhaoteng
 * @Date 2019/8/16 15:46
 * @Version 1.0
 **/
@MessagingGateway(defaultRequestChannel = "mqttOutboundChannel")
public interface MqttGateway {

    void sendToMqtt(String data,@Header(MqttHeaders.TOPIC) String topic);

}
