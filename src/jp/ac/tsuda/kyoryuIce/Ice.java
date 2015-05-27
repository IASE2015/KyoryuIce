package jp.ac.tsuda.kyoryuIce;

import java.io.Serializable;

public class Ice implements Serializable{
	private int id;
	private String name;
	private int price;
	
	public Ice(int id,String name,int price){
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public Ice(){}
	
	public int getId(){ return id; }
	public String getName(){ return name; }
	public int getPrice(){ return price; }
	
	
}
