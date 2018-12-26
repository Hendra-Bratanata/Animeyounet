package com.example.balar.animeyounet;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class AnimeItem implements Serializable {
    private String judul, gambar, tanggal, genre, video, video1, video2;

    public AnimeItem(String judul, String gambar, String tanggal, String genre, String video ,String  video1, String video2){
        this.judul = judul;
        this.gambar = gambar;
        this.tanggal = tanggal;
        this.genre = genre;
        this.video = video;
        this.video1 = video1;
        this.video2 = video2;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getVideo1() {
        return video1;
    }

    public void setVideo1(String video1) {
        this.video1 = video1;
    }

    public String getVideo2() {
        return video2;
    }

    public void setVideo2(String video2) {
        this.video2 = video2;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


}
