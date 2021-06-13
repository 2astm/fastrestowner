package com.example.fastrestowner.controllers.entities;

import com.google.android.gms.maps.model.LatLng;

public class Restaurant {

    private int id;

    private LatLng[] locations;

    private String title;

    private String phoneNumber;

    private String backgroundPicture;
    private String markerPicture;
    private String companyIcon;
    private boolean changing;

    public Restaurant() {}

    public Restaurant(String title, String companyIcon) {
        this.title = title;
        this.companyIcon = companyIcon;
    }

    public boolean isChanging() {
        return changing;
    }

    public void setChanging(boolean changing) {
        this.changing = changing;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LatLng[] getLocations() {
        return locations;
    }

    public void setLocations(LatLng[] locations) {
        this.locations = locations;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBackgroundPicture() {
        return backgroundPicture;
    }

    public void setBackgroundPicture(String backgroundPicture) {
        this.backgroundPicture = backgroundPicture;
    }

    public String getMarkerPicture() {
        return markerPicture;
    }

    public void setMarkerPicture(String markerPicture) {
        this.markerPicture = markerPicture;
    }

    public String getCompanyIcon() {
        return companyIcon;
    }

    public void setCompanyIcon(String companyIcon) {
        this.companyIcon = companyIcon;
    }
}
