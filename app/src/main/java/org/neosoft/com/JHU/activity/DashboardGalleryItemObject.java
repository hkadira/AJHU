package org.neosoft.com.JHU.activity;

/**
 * Created by Neyomal on 12/21/2016.
 */
public class DashboardGalleryItemObject {

    private String name;
    private int photo;

    public DashboardGalleryItemObject(String name, int photo) {
        this.name = name;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
