package com.android.contactslist;

public class KhachHang {
	private String tenkh;
	private String taikhoan;
	private String email;
	public String getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	private String matkhau;
	private String gioitinh;
	private String sdt;
	private String diachi;
	public KhachHang(){
	
	}
	public KhachHang(String ten,String tk,String mk,String email,String gioitinh,String sdt,String diachi ){
		this.tenkh=ten;
		this.taikhoan=tk;
		this.matkhau=mk;
		this.email=email;
		this.gioitinh=gioitinh;
		this.sdt=sdt;
		this.diachi=diachi;
	}
	public String getTenkh() {
		return tenkh;
	}
	public void setTenkh(String tenkh) {
		this.tenkh = tenkh;
	}
	public String getTaikhoan() {
		return taikhoan;
	}
	public void setTaikhoan(String taikhoan) {
		this.taikhoan = taikhoan;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
