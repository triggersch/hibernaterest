package carto.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public Long id;
	public String das;
	public String name;
	
	
	public User(Long id, String das, String name) {
		this.id = id;
		this.das = das;
		this.name = name;
	}
	public User( String das, String name) {
		this.das = das;
		this.name = name;
	}
	
	public User(){
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDas() {
		return das;
	}
	public void setDas(String das) {
		this.das = das;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
