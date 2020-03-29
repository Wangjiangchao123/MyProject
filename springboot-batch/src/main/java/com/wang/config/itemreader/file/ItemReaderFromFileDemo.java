package com.wang.config.itemreader.file;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.validation.BindException;

/**
 * 从普通文件中读取
 */
@Configuration
public class ItemReaderFromFileDemo {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    @Qualifier("flatFieldWriter")
    private ItemWriter<? super Custom> flatFieldWriter;


    @Bean
    public Job fileItemReaderDemoJob() {
        return jobBuilderFactory.get("fileItemReaderDemoJob")
                .start(fileItemReaderDemoStep())
                .build();
    }

    @Bean
    public Step fileItemReaderDemoStep() {
        return stepBuilderFactory.get("fileItemReaderDemoStep")
                .<Custom, Custom>chunk(100)
                .reader(flatFileReader())
                .writer(null)
                .build();
    }

    @Bean
    @StepScope
    public FlatFileItemReader<? extends Custom> flatFileReader() {
        FlatFileItemReader<Custom> reader = new FlatFileItemReader<Custom>();
        reader.setResource(new ClassPathResource("customer.txt"));
        reader.setLinesToSkip(1);//跳过第一行


        //解析数据
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setNames(new String[]{"id", "firstName", "lastName", "birthday"});
        //解析一行数据映射为Customer对象
        DefaultLineMapper<Custom> mapper = new DefaultLineMapper<>();
        mapper.setLineTokenizer(tokenizer);
        mapper.setFieldSetMapper(new FieldSetMapper<Custom>() {
            @Override
            public Custom mapFieldSet(FieldSet fieldSet) throws BindException {
                Custom custom = new Custom();
                custom.setId(fieldSet.readLong("id"));
                custom.setFirstName(fieldSet.readString("firstName"));
                custom.setLastName(fieldSet.readString("lastName"));
                custom.setBirthday(fieldSet.readString("birthday"));
                return custom;
            }
        });

        mapper.afterPropertiesSet();
        reader.setLineMapper(mapper);
        return reader;
    }


}
