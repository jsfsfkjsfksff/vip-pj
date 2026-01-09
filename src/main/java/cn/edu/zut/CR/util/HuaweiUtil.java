package cn.edu.zut.CR.util;

import com.obs.services.ObsClient;
import com.obs.services.exception.ObsException;

import java.io.IOException;
import java.io.InputStream;

public class HuaweiUtil {
    private static final String ak = "HPUA4O4FOPY59ZGFHIA1";
    private static final String sk = "9QyY3sc1L9NvbBgkXn6TWRwXYqcoXgzPINp5cpWN";
    private static final String endPoint = "obs.cn-east-5.myhuaweicloud.com";
    private static final String bucket = "car-rent-pj-5580";

    /**
     * 上传文件到云存储
     */
    public static void upload(InputStream inputStream, String key) throws ObsException {
        // 创建Obs客户端实例
        try (ObsClient obsClient = new ObsClient(ak, sk, endPoint)) {
            obsClient.putObject(bucket, key, inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 删除云存储上的文件
     */
    public static void delete(String key) throws ObsException {
        // 创建Obs客户端实例
        try (ObsClient obsClient = new ObsClient(ak, sk, endPoint)) {
            obsClient.deleteObject(bucket, key);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}