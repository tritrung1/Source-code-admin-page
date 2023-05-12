package com.training.utils;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import org.apache.commons.io.FileUtils;

import java.io.File;

public class S3Utils {
    private static final String endpointUrl = ".s3.ap-southeast-1.amazonaws.com";

    public static AmazonS3 getAmazonS3(String accessKey, String secretKey) {
        return getAmazonS3(accessKey, secretKey, Regions.AP_SOUTHEAST_1.getName());
    }

    public static AmazonS3 getAmazonS3(String accessKey, String secretKey, String region) {
        AWSCredentials credentials = new BasicAWSCredentials(
                accessKey,
                secretKey
        );
        return  AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(region)
                .build();
    }

    public static void uploadFileTos3bucket(String accessKey, String secretKey,
                                            String bucketName, String fileName, File file) {
        AmazonS3 amazonS3Client = getAmazonS3(accessKey, secretKey);
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.length());
        try {
            amazonS3Client.putObject(bucketName, fileName, FileUtils.openInputStream(file), metadata);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String accessKey = "AKIA2OF4S3RX2ATER4PL";
        String secretKey = "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";
        String bucketName = "java-mock-project-2023";
        File file = new File("E:\\research\\anh-thien-nhien-full-hd-2k-4k.jpg");
        String fileName = String.valueOf(System.currentTimeMillis()) + "_" + file.getName();
        String fileUrl = "https://" + bucketName + endpointUrl + "/" + fileName;
        System.out.println("File is:" + fileUrl);
        System.out.println("Done!!!!!!!!!");
        try {
            uploadFileTos3bucket(accessKey, secretKey, bucketName, fileName, file);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}