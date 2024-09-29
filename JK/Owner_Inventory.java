package com.JK;

import java.util.*;

public class Owner_Inventory {
	Scanner sc = new Scanner(System.in);
	List<Esteem> list = new ArrayList<>(); 
	public void add(Esteem e1) {
		list.add(e1);
	}
	public String generate_id(Esteem e) {
		return e.getBrand()+e.getO_name().substring(e.getO_name().length()-2);
	}
	
	public void show() {
		for(Esteem e1:list) {
			System.out.println(e1);
		}
	}
	public Esteem search(String id) {
		for(int i = 0;i<list.size();i++) {
			if(id.equals(list.get(i).getId())) {
				return list.get(i);
			}
		}
		return null;
	}
	public void update() {
		System.out.println("Updation performed Success");
	}
	public void delete(String id) {
		for(int i = 0;i<list.size();i++) {
			if(id.equals(list.get(i).getId())) {
				list.remove(i);
			}
		}
	}
}
