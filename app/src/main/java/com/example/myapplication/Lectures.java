package com.example.myapplication;

public class Lectures {

    private String dersAdi;
    private String dersNotu;
    private String notOrt;
    private int ogrSayisi;



    public String getNotOrt() {
        return notOrt;
    }

    public void setNotOrt(String notOrt) {
        this.notOrt = notOrt;
    }

    public int getOgrSayisi() {
        return ogrSayisi;
    }

    public void setOgrSayisi(int ogrSayisi) {
        this.ogrSayisi = ogrSayisi;
    }


    public Lectures(String dersAdi, String dersNotu,String notOrt, int ogrSayisi) {
        this.dersAdi = dersAdi;
        this.dersNotu = dersNotu;
        this.notOrt = notOrt;
        this.ogrSayisi = ogrSayisi;
    }

    public String getDersAdi() {
        return dersAdi;
    }

    public void setDersAdi(String dersAdi) {
        this.dersAdi = dersAdi;
    }

    public String getDersNotu() {
        return dersNotu;
    }

    public void setDersNotu(String dersNotu) {
        this.dersNotu = dersNotu;
    }


}
