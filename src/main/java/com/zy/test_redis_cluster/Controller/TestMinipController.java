package com.zy.test_redis_cluster.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("TestMinipController.v1")
@RequestMapping("/minio")
public class TestMinipController {

    private static final Logger log = LoggerFactory.getLogger(TestMinipController.class);

}
