package com.JK;

public class Esteem {
	private String brand = null;
	private int size = 0;           // Default value for int
	private String type = null;
	private int no_of_shoes = 0;   // Default value for int
	private String id = null;
	private String o_name = null;
	private String o_brand = null;
	private int o_size = 0;        // Default value for int
	private int o_no_of_shoes = 0; // Default value for int
	private String o_type = null;
	private int amt = 0;           // Default value for int

	public Esteem(String brand, int size, String type, int no_of_shoes, String id, String o_name, String o_brand,
			int o_size, int o_no_of_shoes, String o_type) {
		this.brand = brand;
		this.size = size;
		this.type = type;
		this.no_of_shoes = no_of_shoes;
		this.id = id;
		this.o_name = o_name;
		this.o_brand = o_brand;
		this.o_size = o_size;
		this.o_no_of_shoes = o_no_of_shoes;
		this.o_type = o_type;
	}
	
	public int getAmt() {
		return amt;
	}

	public void setAmt(int amt) {
		this.amt = amt;
	}

	public String getO_name() {
		return o_name;
	}

	public void setO_name(String o_name) {
		this.o_name = o_name;
	}

	public String getO_brand() {
		return o_brand;
	}

	public void setO_brand(String o_brand) {
		this.o_brand = o_brand;
	}

	public int getO_size() {
		return o_size;
	}

	public void setO_size(int o_size) {
		this.o_size = o_size;
	}

	public int getO_no_of_shoes() {
		return o_no_of_shoes;
	}

	public void setO_no_of_shoes(int o_no_of_shoes) {
		this.o_no_of_shoes = o_no_of_shoes;
	}

	public String getO_type() {
		return o_type;
	}

	public void setO_type(String o_type) {
		this.o_type = o_type;
	}

	public Esteem() {
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getNo_of_shoes() {
		return no_of_shoes;
	}
	public void setNo_of_shoes(int no_of_shoes) {
		this.no_of_shoes = no_of_shoes;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Esteem [Client_Name=" + o_name + "\nBrand=" + o_brand + "\nSize=" + o_size + "\nNo_of_shoes="
				+ o_no_of_shoes + "\nType=" + o_type + "]";
	}
	
	
	
	
}
