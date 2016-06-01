package com.achp.spring.mongodb.util;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
public class MongoTemplateUtil {
    private static MongoTemplate mongoTemplate;
    private MongoTemplateUtil() {
    }
    public static MongoTemplate getMongoTemplate() {
        if (null == mongoTemplate) {
        	ApplicationContext ctx = new GenericXmlApplicationContext("SpringConfig.xml");
        	System.out.println("ctx"+ctx);
        	mongoTemplate = (MongoTemplate)ctx.getBean("mongoTemplate");
        }
        return mongoTemplate;
    }
}
