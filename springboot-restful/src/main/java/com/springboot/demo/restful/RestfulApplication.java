package com.springboot.demo.restful;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Jim
 */
@SpringBootApplication
@EnableSwagger2Doc
public class RestfulApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestfulApplication.class, args);
//        ApplicationContext context = SpringApplication.run(RestfulApplication.class, args);

//        Binder binder = Binder.get(context.getEnvironment());
//
//        // 绑定简单配置
//        FooProperties foo = binder.bind("com.didispace", Bindable.of(FooProperties.class)).get();
//        System.out.println(foo.getFoo());
//
//        // 绑定List配置
//        List<String> post = binder.bind("com.didispace.post", Bindable.listOf(String.class)).get();
//        System.out.println(post);
//
//        List<PostInfo> posts = binder.bind("com.didispace.posts", Bindable.listOf(PostInfo.class)).get();
//        System.out.println(posts);
    }
}
