package com.aristotle.admin.service;

import java.io.FileNotFoundException;
import java.io.InputStream;

public interface AwsFileManager {

    public abstract void uploadFileToS3(String awsKey, String awsSecret, String bucketName, String remoteFileNameAndPath, String localFilePathToUpload) throws FileNotFoundException;

    public abstract void uploadFileToS3(String awsKey, String awsSecret, String bucketName, String remoteFileNameAndPath, InputStream fileToUpload, String contentType) throws FileNotFoundException;

    public abstract void uploadFileToS3(String awsKey, String awsSecret, String bucketName, String remoteFileNameAndPath, InputStream fileToUpload) throws FileNotFoundException;

}