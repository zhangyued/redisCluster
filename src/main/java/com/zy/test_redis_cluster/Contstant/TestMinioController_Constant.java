package com.zy.test_redis_cluster.Contstant;

public interface TestMinioController_Constant {

    interface addBucketName_Code{
        String minioClientInit_Code = "minio_init_error";
        String bucketMake_Code = "bucket_make_error";
        String removeBucket_Code = "remove_bucket_error";
        String putObject_Code = "put_object_error";
    }

    interface addBucketName_Msg{
        String minioClientInit_Msg = "minio客户端初始化失败";
        String bucketMake_Msg = "桶创建异常";
        String removeBucket_Msg = "删除桶异常";
        String putObject_Msg = "上传文件异常";
    }
}
