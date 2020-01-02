package com.example.controller;

import com.example.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 王江超
 * @Date 2020/1/2 15:58
 * @Description:
 */
@RestController
public class ThreadController {


    @Autowired
    private AsyncService asyncService;

    @RequestMapping("sss")
    public ResponseEntity<?> getSSS(){
        asyncService.excuteAsync();
        return  ResponseEntity.status(200).body("OK");
    }


}
