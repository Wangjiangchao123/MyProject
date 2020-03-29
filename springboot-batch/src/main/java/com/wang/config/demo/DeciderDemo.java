//package com.wang.config.demo;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.StepContribution;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.job.flow.JobExecutionDecider;
//import org.springframework.batch.core.scope.context.ChunkContext;
//import org.springframework.batch.core.step.tasklet.Tasklet;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * 决策器的使用
// */
//@Configuration
//@EnableBatchProcessing
//public class DeciderDemo {
//
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//
//    @Bean
//    public Step deciderDemoStep1(){
//        return stepBuilderFactory.get("deciderDemoStep1")
//                .tasklet(new Tasklet() {
//                    @Override
//                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
//                        System.out.println("deciderDemoStep1");
//                        return RepeatStatus.FINISHED;
//                    }
//                }).build();
//    }
//
//    @Bean
//    public Step deciderDemoStep2(){
//        return stepBuilderFactory.get("deciderDemoStep2")
//                .tasklet(new Tasklet() {
//                    @Override
//                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
//                        System.out.println("deciderDemoStep2");
//                        return RepeatStatus.FINISHED;
//                    }
//                }).build();
//    }
//
//    @Bean
//    public Step deciderDemoStep3(){
//        return stepBuilderFactory.get("deciderDemoStep3")
//                .tasklet(new Tasklet() {
//                    @Override
//                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
//                        System.out.println("deciderDemoStep3");
//                        return RepeatStatus.FINISHED;
//                    }
//                }).build();
//    }
//
//    /**
//     * 创建决策器
//     * @return
//     */
//    @Bean
//    public JobExecutionDecider myDecider(){
//        return new MyDecider();
//    }
//
//    /**
//     * 创建任务
//     * @return
//     */
//    @Bean
//    public Job deciderDemoJob(){
//        return jobBuilderFactory.get("deciderDemoJob")
//                .start(deciderDemoStep1())
//                .next(myDecider())
//                .from(myDecider()).on("even").to(deciderDemoStep2())
//                .from(myDecider()).on("odd").to(deciderDemoStep3())
//                //执行完step3  无论返回什么  执行mydecider
//                .from(deciderDemoStep3()).on("*")
//                .to(myDecider())
//                .end().build();
//    }
//
//}
