package com.example.flab_ulous.API;

import com.google.gson.annotations.SerializedName;

public class DietDto {
    @SerializedName("id")
    private Long id;
    @SerializedName("breakfast")
    private String breakfast;
    @SerializedName("lunch")
    private String lunch;
    @SerializedName("snacks")
    private String snacks;
    @SerializedName("dinner")
    private String dinner;
    @SerializedName("patientName")
    private String patientName;
    @SerializedName("patientId")
    private Long patientId;
    @SerializedName("breakfasttime")
    private String breakfasttime;
    @SerializedName("lunchtime")
    private String lunchtime;
    @SerializedName("snackstime")
    private String snackstime;
    @SerializedName("dinnertime")
    private String dinnertime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public String getSnacks() {
        return snacks;
    }

    public void setSnacks(String snacks) {
        this.snacks = snacks;
    }

    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getBreakfasttime() {
        return breakfasttime;
    }

    public void setBreakfasttime(String breakfasttime) {
        this.breakfasttime = breakfasttime;
    }

    public String getLunchtime() {
        return lunchtime;
    }

    public void setLunchtime(String lunchtime) {
        this.lunchtime = lunchtime;
    }

    public String getSnackstime() {
        return snackstime;
    }

    public void setSnackstime(String snackstime) {
        this.snackstime = snackstime;
    }

    public String getDinnertime() {
        return dinnertime;
    }

    public void setDinnertime(String dinnertime) {
        this.dinnertime = dinnertime;
    }
}
