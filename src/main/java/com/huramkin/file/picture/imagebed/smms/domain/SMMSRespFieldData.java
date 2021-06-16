package com.huramkin.file.picture.imagebed.smms.domain;

public class SMMSRespFieldData {
    private Integer file_id;
    private Integer width;
    private Integer height;
    private String filename;
    private String storename;
    private Long size;
    private String path;
    private String hash;
    private String url;
    private String delete;
    private String page;

    public SMMSRespFieldData() {
    }

    public SMMSRespFieldData(Integer file_id, Integer width, Integer height, String filename, String storename, Long size, String path, String hash, String url, String delete, String page) {
        this.file_id = file_id;
        this.width = width;
        this.height = height;
        this.filename = filename;
        this.storename = storename;
        this.size = size;
        this.path = path;
        this.hash = hash;
        this.url = url;
        this.delete = delete;
        this.page = page;
    }

    public Integer getFile_id() {
        return file_id;
    }

    public void setFile_id(Integer file_id) {
        this.file_id = file_id;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDelete() {
        return delete;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "SMMSRespFieldData{" +
                "file_id=" + file_id +
                ", width=" + width +
                ", height=" + height +
                ", filename='" + filename + '\'' +
                ", storename='" + storename + '\'' +
                ", size=" + size +
                ", path='" + path + '\'' +
                ", hash='" + hash + '\'' +
                ", url='" + url + '\'' +
                ", delete='" + delete + '\'' +
                ", page='" + page + '\'' +
                '}';
    }
}
