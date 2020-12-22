package com.zy.test_redis_cluster.Contstant;

public interface TestMinioController_Constant {

    interface addBucketName_Code{
        String minioClientInit_Code = "minio_init_error";
        String bucketMake_Code = "bucket_make_error";
    }

    interface addBucketName_Msg{
        String minioClientInit_Msg = "minio客户端初始化失败";
        String bucketMake_Msg = "桶创建异常";
    }
}
