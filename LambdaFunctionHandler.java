package com.amazonaws.lambda.demo;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import redis.clients.jedis.Jedis;

public class LambdaFunctionHandler implements RequestHandler<Object, String> {

    @Override
    public String handleRequest(Object input, Context context) {
        context.getLogger().log("This is test");
        Jedis jedis = new Jedis("myelasticrediscache.7zalm7.ng.0001.use1.cache.amazonaws.com", 6379);
        jedis.set("test-me", "value-me");
        jedis.set("test-me-one", "value-me-one");
        jedis.set("test-me-two", "value-me-two");
        jedis.set("test-me-three", "value-me-three");
        return "Hello from Lambda!";
    }

}
