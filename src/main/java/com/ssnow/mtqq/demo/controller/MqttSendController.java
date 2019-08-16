package com.ssnow.mtqq.demo.controller;

import com.ssnow.mtqq.demo.mqttGateway.MqttGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className MqttSendController
 * @Description TODO
 * @Author zhaoteng
 * @Date 2019/8/16 15:50
 * @Version 1.0
 **/
@RestController
@RequestMapping("test")
public class MqttSendController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MqttSendController.class);

    @Autowired
    MqttGateway mqttGateway;

    @RequestMapping("sendMqtt")
    public String sendMqtt(@RequestParam("sendData") String sendData) {
        try {
            mqttGateway.sendToMqtt(sendData, "hello");
        } catch (Exception e) {
            LOGGER.error("【MQTT消息发送】出现异常！异常信息：{}", e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return "OK";
    }

}
