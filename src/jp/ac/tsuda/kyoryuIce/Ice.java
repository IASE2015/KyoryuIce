package jp.ac.tsuda.kyoryuIce;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Ice implements Serializable{
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
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
