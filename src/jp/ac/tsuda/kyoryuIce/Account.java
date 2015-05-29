package jp.ac.tsuda.kyoryuIce;

import java.io.Serializable;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;

import java.net.URL;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Account implements Serializable{
    private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String pass;
	
	public Account(int id,String name,String pass){
		this.id = id;
		this.name = name;
		this.pass = pass;
	}
	public int getId(){ return id; }
	public String getName(){ return name; }
	public String getPass(){ return pass; }

}
