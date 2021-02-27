package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author ns
 * @date 2021/2/27
 */
public interface LoadBalancer {

    public ServiceInstance instances(List<ServiceInstance> serviceInstanceList);
}
