package com.alins.JsonHandle;

import java.util.List;

public class SaveJson {

    private String error;
    private List<DataDTO> data;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<DataDTO> getData() {
        return data;
    }

    public void setData(List<DataDTO> data) {
        this.data = data;
    }

    public static class DataDTO {
        private int pid;
        private int p;
        private int uid;
        private String title;
        private String author;
        private boolean r18;
        private int width;
        private int height;
        private List<String> tags;
        private String ext;
        private long uploadDate;
        private UrlsDTO urls;

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public int getP() {
            return p;
        }

        public void setP(int p) {
            this.p = p;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public boolean isR18() {
            return r18;
        }

        public void setR18(boolean r18) {
            this.r18 = r18;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }

        public String getExt() {
            return ext;
        }

        public void setExt(String ext) {
            this.ext = ext;
        }

        public long getUploadDate() {
            return uploadDate;
        }

        public void setUploadDate(long uploadDate) {
            this.uploadDate = uploadDate;
        }

        public UrlsDTO getUrls() {
            return urls;
        }

        public void setUrls(UrlsDTO urls) {
            this.urls = urls;
        }

        public static class UrlsDTO {
            private String original;

            public String getOriginal() {
                return original;
            }

            public void setOriginal(String original) {
                this.original = original;
            }
        }
    }
}

