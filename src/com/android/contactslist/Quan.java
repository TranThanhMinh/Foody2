package com.android.contactslist;

import java.io.Serializable;

import android.text.format.Time;

public class Quan implements Serializable {

	private String idquan;
	private String tenquan;
	private String sdt;
	private String image;
	private String diachi;
	private String DatCho;
	public String getDatCho() {
		return DatCho;
	}
	public void setDatCho(String datCho) {
		DatCho = datCho;
	}
	private String timeopen;
	private String timeclose;
	private String tien;
	public Quan(){
		
	}
	public Quan(String idquan,String tenquan,String sdt,String im,String tien,String diachi,String datcho, String open,String close){
		this.idquan=idquan;
		this.tenquan=tenquan;
		this.sdt=sdt;
		this.image=im;
		this.tien=tien;
		this.diachi=diachi;
		this.DatCho=datcho;
		this.timeopen=open;
		this.timeclose=close;
	}
	public String getIdquan() {
		return idquan;
	}
	public void setIdquan(String idquan) {
		this.idquan = idquan;
	}
	public String getTenquan() {
		return tenquan;
	}
	public void setTenquan(String tenquan) {
		this.tenquan = tenquan;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getTimeopen() {
		return timeopen;
	}
	public void setTimeopen(String timeopen) {
		this.timeopen = timeopen;
	}
	public String getTimeclose() {
		return timeclose;
	}
	public void setTimeclose(String timeclose) {
		this.timeclose = timeclose;
	}
	public String getTien() {
		return tien;
	}
	public void setTien(String tien) {
		this.tien = tien;
	}
	
	

}
