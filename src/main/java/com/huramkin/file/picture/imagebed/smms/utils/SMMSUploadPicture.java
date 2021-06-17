package com.huramkin.file.picture.imagebed.smms.utils;

import com.google.gson.Gson;
import com.huramkin.file.picture.imagebed.smms.domain.SMMSResponseBody;
import okhttp3.*;

import java.io.*;

public class SMMSUploadPicture {
    private String token;

    private static SMMSUploadPicture instance = new SMMSUploadPicture();

    private SMMSUploadPicture(){}
    public static SMMSUploadPicture getInstance(String token){
        if (null==token || "".equals(token)){
            System.err.println("MUST INPUT SMMS TOKEN");
            return instance;
        }
        return instance.setToken(token);
    }

    private SMMSUploadPicture setToken(String token) {
        this.token = token;
        return this;
    }



    public String simpleUploadPicture (InputStream inputStream, String filename) throws IOException {
        SMMSResponseBody smmsResponseBody = uploadPicture(inputStream,filename);
        if (null == smmsResponseBody.getData()){
            String message = smmsResponseBody.getMessage();
            String[] resultWords = message.split(" ");
            String resultDuplicateWord = resultWords[resultWords.length - 1];
            //System.out.println("Duplicate pictures uploaded");
            return resultDuplicateWord;
        }
        return smmsResponseBody.getData().getUrl();
    }

    public String simpleUploadPicture (File file) throws IOException {
        SMMSResponseBody smmsResponseBody = uploadPicture(file);
        if (null == smmsResponseBody.getData()){
            String message = smmsResponseBody.getMessage();
            String[] resultWords = message.split(" ");
            String resultDuplicateWord = resultWords[resultWords.length - 1];
            //System.out.println("Duplicate pictures uploaded");
            return resultDuplicateWord;
        }
        return smmsResponseBody.getData().getUrl();
    }

    public SMMSResponseBody uploadPicture(InputStream inputStream,String filename) throws IOException {
        File file = new File(filename);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        Integer read = null;
        byte[] bytes = new byte[1024];
        while ((read = inputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes, 0, read);
        }
        SMMSResponseBody smmsResponseBody = uploadPicture(file);
        fileOutputStream.close();
        inputStream.close();
        file.delete();
        return smmsResponseBody;
    }

    public SMMSResponseBody uploadPicture(File file) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("smfile", file.getName(),
                 RequestBody.create(file,MediaType.parse("application/octet-stream")))
                .addFormDataPart("format", "json")
                .build();
        Request request = new Request.Builder()
                .url("https://sm.ms/api/v2/upload")
                .method("POST", body)
                .addHeader("Authorization", token)
                .addHeader("User-Agent", "Mozilla/5.0 (compatible; U; ABrowse 0.6; Syllable) AppleWebKit/420+ (KHTML, like Gecko)")
                .build();
        Response response = client.newCall(request).execute();
        String respBody = response.body().string();
        SMMSResponseBody smmsResponseBody = new Gson().fromJson(respBody, SMMSResponseBody.class);
        return smmsResponseBody;
    }
}
