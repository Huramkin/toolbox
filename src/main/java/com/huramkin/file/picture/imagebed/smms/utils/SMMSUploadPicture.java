package com.huramkin.file.picture.imagebed.smms.utils;

import com.google.gson.Gson;
import com.huramkin.file.picture.imagebed.smms.domain.SMMSResponseBody;
import okhttp3.*;

import java.io.*;

public class SMMSUploadPicture {
    public static String simpleUploadPicture (String token, InputStream inputStream,String filename) throws IOException {
        SMMSResponseBody smmsResponseBody = uploadPicture(token, inputStream,filename);
        return smmsResponseBody.getData().getUrl();
    }

    public static String simpleUploadPicture (String token, File file) throws IOException {
        SMMSResponseBody smmsResponseBody = uploadPicture(token, file);
        if (null == smmsResponseBody.getData()){
            return smmsResponseBody.getMessage();
        }
        return smmsResponseBody.getData().getUrl();
    }

    public static SMMSResponseBody uploadPicture(String token, InputStream inputStream,String filename) throws IOException {
        File file = new File(filename);
        FileOutputStream fileOutputStream = new FileOutputStream(filename);
        Integer read = null;
        byte[] bytes = new byte[1024];
        while ((read = inputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes, 0, read);
        }
        SMMSResponseBody smmsResponseBody = uploadPicture(token, file);
        file.delete();
        return smmsResponseBody;
    }

    public static SMMSResponseBody uploadPicture(String token, File file) throws IOException {
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
