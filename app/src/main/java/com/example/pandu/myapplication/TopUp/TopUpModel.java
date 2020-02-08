package com.example.pandu.myapplication.TopUp;

import com.google.firebase.database.IgnoreExtraProperties;


@IgnoreExtraProperties


public class TopUpModel {

    private String id;
    private String name;
    private String topup;
    private String code;
    private String idkartu;
    private String outlet;
    private String bank;

    public TopUpModel(String id, String name, String topup, String code, String idkartu, String outlet, String bank) {
        this.id = id;
        this.name = name;
        this.topup = topup;
        this.code = code;
        this.idkartu = idkartu;
        this.outlet = outlet;
        this.bank = bank;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopup() {
        return topup;
    }

    public void setTopup(String topup) {
        this.topup = topup;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIdkartu() {
        return idkartu;
    }

    public void setIdkartu(String idkartu) {
        this.idkartu = idkartu;
    }

    public String getOutlet(){
        return outlet;
    }

    public void setOutlet(String outlet){
        this.outlet = outlet;
    }

    public String getBank (){
        return bank;
    }

    public void setBank(String bank){
        this.bank  = bank;
    }

}

