package com.wang.config.itemreader.file;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FlatFieldWriter implements ItemWriter<Custom> {

    @Override
    public void write(List<? extends Custom> list) throws Exception {
        for (Custom custom :list){
            System.out.println(custom);
        }
    }
}
