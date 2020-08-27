package org.zsh.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 不能放在springbootApplication所在的包及子包中
 * @author zhangsihai
 */
@Configuration
public class MyRibbonRule {

    @Bean
    public IRule myRobinRule(){
        return new RandomRule();
    }
}
