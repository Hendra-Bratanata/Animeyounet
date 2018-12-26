package com.example.balar.animeyounet;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Anime implements Parcelable {
    private String judul, gambar, tanggal, genre, video, video1, video2;

    public Anime(String judul, String gambar, String tanggal, String genre, String video ,String video1, String video2){
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.judul);
        dest.writeString(this.gambar);
        dest.writeString(this.tanggal);
        dest.writeString(this.genre);
        dest.writeString(this.video);
        dest.writeString(this.video1);
        dest.writeString(this.video2);
    }

    protected Anime(Parcel in) {
        this.judul = in.readString();
        this.gambar = in.readString();
        this.tanggal = in.readString();
        this.genre = in.readString();
        this.video = in.readString();
        this.video1 = in.readString();
        this.video2 = in.readString();
    }

    public static final Creator<Anime> CREATOR = new Creator<Anime>() {
        @Override
        public Anime createFromParcel(Parcel source) {
            return new Anime(source);
        }

        @Override
        public Anime[] newArray(int size) {
            return new Anime[size];
        }
    };
}
