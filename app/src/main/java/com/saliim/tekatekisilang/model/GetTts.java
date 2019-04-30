package com.saliim.tekatekisilang.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetTts {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("no_soal")
    @Expose
    private String noSoal;
    @SerializedName("jenis")
    @Expose
    private String jenis;
    @SerializedName("tanya")
    @Expose
    private String tanya;
    @SerializedName("jawab")
    @Expose
    private String jawab;
    @SerializedName("kolom")
    @Expose
    private int kolom;
    @SerializedName("baris")
    @Expose
    private int baris;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNoSoal() {
        return noSoal;
    }

    public void setNoSoal(String noSoal) {
        this.noSoal = noSoal;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getTanya() {
        return tanya;
    }

    public void setTanya(String tanya) {
        this.tanya = tanya;
    }

    public String getJawab() {
        return jawab;
    }

    public void setJawab(String jawab) {
        this.jawab = jawab;
    }

    public int getKolom() {
        return kolom;
    }

    public void setKolom(int kolom) {
        this.kolom = kolom;
    }

    public int getBaris() {
        return baris;
    }

    public void setBaris(int baris) {
        this.baris = baris;
    }

}
