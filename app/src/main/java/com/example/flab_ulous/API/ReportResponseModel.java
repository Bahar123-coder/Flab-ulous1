package com.example.flab_ulous.API;

import com.google.gson.annotations.SerializedName;

public class ReportResponseModel {
    @SerializedName("status")
    private String status;
    @SerializedName("code")
    private String code;
    @SerializedName("message")
    private String message;
    @SerializedName("details")
    private Detail details;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Detail getDetails() {
        return details;
    }

    public void setDetails(Detail details) {
        this.details = details;
    }

    public class Detail {
        @SerializedName("weight")
        private Double weight;
        @SerializedName("bmi")
        private Double bmi;
        @SerializedName("Bodyfat")
        private Double Bodyfat;
        @SerializedName("chestsize")
        private Double chestsize;
        @SerializedName("armsize")
        private Double armsize;
        @SerializedName("waist")
        private Double waist;
        @SerializedName("hip")
        private Double hip;
        @SerializedName("totalcholesterol")
        private Double totalcholesterol;
        @SerializedName("hdl")
        private Double hdl;
        @SerializedName("ldl")
        private Double ldl;
        @SerializedName("vldl")
        private Double vldl;
        @SerializedName("triglycerides")
        private Double triglycerides;
        @SerializedName("patientId")
        private Long patientId;


        public Double getWeight() {
            return weight;
        }

        public void setWeight(Double weight) {
            this.weight = weight;
        }

        public Double getBodyfat() {
            return Bodyfat;
        }

        public void setBodyfat(Double bodyfat) {
            Bodyfat = bodyfat;
        }

        public Double getChestsize() {
            return chestsize;
        }

        public void setChestsize(Double chestsize) {
            this.chestsize = chestsize;
        }

        public Double getArmsize() {
            return armsize;
        }

        public void setArmsize(Double armsize) {
            this.armsize = armsize;
        }

        public Double getWaist() {
            return waist;
        }

        public void setWaist(Double waist) {
            this.waist = waist;
        }

        public Double getHip() {
            return hip;
        }

        public void setHip(Double hip) {
            this.hip = hip;
        }

        public Double getTotalcholesterol() {
            return totalcholesterol;
        }

        public void setTotalcholesterol(Double totalcholesterol) {
            this.totalcholesterol = totalcholesterol;
        }

        public Double getHdl() {
            return hdl;
        }

        public void setHdl(Double hdl) {
            this.hdl = hdl;
        }

        public Double getLdl() {
            return ldl;
        }

        public void setLdl(Double ldl) {
            this.ldl = ldl;
        }

        public Double getVldl() {
            return vldl;
        }

        public void setVldl(Double vldl) {
            this.vldl = vldl;
        }

        public Double getTriglycerides() {
            return triglycerides;
        }

        public void setTriglycerides(Double triglycerides) {
            this.triglycerides = triglycerides;
        }

        public Long getPatientId() {
            return patientId;
        }

        public void setPatientId(Long patientId) {
            this.patientId = patientId;
        }

        public Double getBmi() {
            return bmi;
        }

        public void setBmi(Double bmi) {
            this.bmi = bmi;
        }
    }
}
