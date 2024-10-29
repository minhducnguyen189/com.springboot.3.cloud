package org.example.client;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RateLimiter(name = "openfeign-server")
@Retry(name = "openfeign-server")
@FeignClient(name = "openfeign-server", url = "http://localhost:7070")
public interface OpenFeignServerApi {

    @RequestMapping(method = RequestMethod.GET, value = "/v1/server/random-uuid", produces = MediaType.TEXT_PLAIN_VALUE)
    String getRandomUUID();

}
