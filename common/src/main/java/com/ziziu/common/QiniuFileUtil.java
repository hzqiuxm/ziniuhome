package com.ziziu.common;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 七牛云对象存储工具类
 * Created by yeoman on 2017/10/30.
 */
public class QiniuFileUtil {
    private static final Logger log = LoggerFactory.getLogger(QiniuFileUtil.class);

    private static final String ACCESS_KEY = "Slv9yyHeZ-Jvn8BkD5Frk_k5XIL4EitV8QFaPsHu";
    private static final String SECRET_KEY = "turuVFxhmQdbFhJOf-7_3pQrwFCwpnnoEGZ-H37b";

    public static final String BUCKET_IMG_DEV = "img-dev";//这个华东区的不能用，报错看不懂。
    public static final String BUCKET_IMG_DEV_DOMAIN = "http://oymjrvmkk.bkt.clouddn.com/";//这个华东区的不能用，报错看不懂。

    public static final String BUCKET = "ziniu";
    public static final String DIR_DEV_IMG = "dev/img/";
    public static final String DIR_DEV_PPT = "dev/ppt/";
    public static final String DIR_DEV_AUDIO = "dev/audio/";
    public static final String DOMAIN = "http://oymo1n5h6.bkt.clouddn.com/";

    public static final String DIR_IMG = DIR_DEV_IMG;

    private static Configuration cfg;
    private static UploadManager uploadManager;
    private static Auth auth;
    private static BucketManager bucketManager;

    static {
        cfg = new Configuration(Zone.zone2());
        uploadManager = new UploadManager(cfg);
        try {
            auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        bucketManager = new BucketManager(auth, cfg);
    }

    public static FileInfo putImgRetInfo(String bucket, String fileKey, byte[] uploadBytes){
        try {
            String upToken = auth.uploadToken(bucket, fileKey);
            Response response = uploadManager.put(uploadBytes, fileKey, upToken);
            log.info(response.bodyString());

            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            return bucketManager.stat(bucket, putRet.key);
        } catch (QiniuException qe) {
            log.error(qe.response.toString());
            try {
                log.error(qe.response.bodyString());
            } catch (QiniuException qex) {
                qex.printStackTrace();
            }
        }
        return null;
    }

    public static boolean deleteImg(String bucket, String fileKey){
        try {
            Response response = bucketManager.delete(bucket, fileKey);
            log.info(response.toString());
            if (response.statusCode == Const.ReturnCode.OK) {
                return true;
            }
        } catch (QiniuException e) {
            log.error("错误码：" + e.code());
            log.error(e.response.toString());
        }
        return false;
    }
}
