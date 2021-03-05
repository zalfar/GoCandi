package com.example.projekakhir.models;
import android.os.Parcel;
import android.os.Parcelable;
public class Hewan implements Parcelable {
    private String name, ordo, photo, description, kelas;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrdo() {
        return ordo;
    }

    public void setOrdo(String ordo) {
        this.ordo = ordo;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }
    public Hewan() {
    }

    protected Hewan(Parcel in) {
        name = in.readString();
        ordo = in.readString();
        photo = in.readString();
        description = in.readString();
        kelas = in.readString();
    }

    public static final Creator<Hewan> CREATOR = new Creator<Hewan>() {
        @Override
        public Hewan createFromParcel(Parcel in) {
            return new Hewan(in);
        }

        @Override
        public Hewan[] newArray(int size) {
            return new Hewan[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(ordo);
        parcel.writeString(photo);
        parcel.writeString(description);
        parcel.writeString(kelas);
    }
}
