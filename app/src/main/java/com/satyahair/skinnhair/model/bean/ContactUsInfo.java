package com.satyahair.skinnhair.model.bean;

/**
 * Created by Sandeep on 18/02/2017.
 */

public class ContactUsInfo {
    private String name;
    private String phoneno;
    private String email;
    private String message;
    private BitmapMap leftpic;
    private BitmapMap rightpic;
    private BitmapMap toppic;
    private BitmapMap frontpic;
    private BitmapMap backpic;
    private String type;
    private String dr_name;
    private String clinic_name;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDr_name() {
        return dr_name;
    }

    public void setDr_name(String dr_name) {
        this.dr_name = dr_name;
    }

    public String getClinic_name() {
        return clinic_name;
    }

    public void setClinic_name(String clinic_name) {
        this.clinic_name = clinic_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public BitmapMap getBackpic() {
        return backpic;
    }

    public void setBackpic(BitmapMap backpic) {
        this.backpic = backpic;
    }

    public BitmapMap getFrontpic() {
        return frontpic;
    }

    public void setFrontpic(BitmapMap frontpic) {
        this.frontpic = frontpic;
    }

    public BitmapMap getLeftpic() {
        return leftpic;
    }

    public void setLeftpic(BitmapMap leftpic) {
        this.leftpic = leftpic;
    }

    public BitmapMap getRightpic() {
        return rightpic;
    }

    public void setRightpic(BitmapMap rightpic) {
        this.rightpic = rightpic;
    }

    public BitmapMap getToppic() {
        return toppic;
    }

    public void setToppic(BitmapMap toppic) {
        this.toppic = toppic;
    }
}
