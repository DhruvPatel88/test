package com.springhow.examples.springboot.pdfdemo.pojo;

public class BillData {
	
	private String name;
	private String billNo;
	private String dateNo;
	private String date;
	private String truckNo;
	private String from;
	private String to;
	private String bilty;
	private String numberName;
	private String pkg;
	private String weight;
	private String amount;
	private String total;
	
	public BillData() {
		super();
	}
	public BillData(String name, String billNo, String dateNo, String date, String truckNo, String from, String to,
			String bilty, String numberName, String pkg, String weight, String amount, String total) {
		super();
		this.name = name;
		this.billNo = billNo;
		this.dateNo = dateNo;
		this.date = date;
		this.truckNo = truckNo;
		this.from = from;
		this.to = to;
		this.bilty = bilty;
		this.numberName = numberName;
		this.pkg = pkg;
		this.weight = weight;
		this.amount = amount;
		this.total = total;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	public String getDateNo() {
		return dateNo;
	}
	public void setDateNO(String dateNo) {
		this.dateNo = dateNo;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTruckNo() {
		return truckNo;
	}
	public void setTruckNo(String truckNo) {
		this.truckNo = truckNo;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getBilty() {
		return bilty;
	}
	public void setBilty(String bilty) {
		this.bilty = bilty;
	}
	public String getNumberName() {
		return numberName;
	}
	public void setNumberName(String numberName) {
		this.numberName = numberName;
	}
	public String getPkg() {
		return pkg;
	}
	public void setPkg(String pkg) {
		this.pkg = pkg;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
}
