package com.intentimplisit.retrofit;

import com.google.gson.annotations.SerializedName;

public class Kontak {
    @SerializedName("id")
    private String Id;

    @SerializedName("nama")
    private String name;

    private String email;

    @SerializedName("nohp")
    private String noHp;

    @SerializedName("alamat")
    private String addr;

    public String getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getNoHp() {
        return noHp;
    }

    public String getAddr() {
        return addr;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
