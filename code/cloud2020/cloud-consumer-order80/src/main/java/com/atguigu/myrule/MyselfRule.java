package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ns
 * @date 2021/2/26
 */
@Configuration
public class MyselfRule {

    @Bean
    public IRule myRandomRule() {

        return new RandomRule();
    }
}
