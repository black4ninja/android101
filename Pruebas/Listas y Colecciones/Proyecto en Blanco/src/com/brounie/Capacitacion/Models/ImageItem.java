package com.brounie.Capacitacion.Models;

/**
 * Created by Toshiba on 1/01/14.
 */
public class ImageItem {
    private int image;
    private String title;

    public ImageItem(int image, String title) {
        super();
        this.image = image;
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}