package com.example.jesusalejandro.spaceapp;

class DisasterImage {
    private String thumbnailUrl;
    private String url;
    private int resource;

    public DisasterImage(String thumbnailUrl, String url, int resource) {
        this.thumbnailUrl = thumbnailUrl;
        this.url = url;
        this.resource = resource;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }
}
