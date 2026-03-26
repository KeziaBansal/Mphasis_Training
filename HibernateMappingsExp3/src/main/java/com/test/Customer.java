package com.test;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="customers")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String c_name;
	
	@ManyToMany(targetEntity = Order.class, cascade=CascadeType.ALL)
	@JoinTable(name="cst_order",
			joinColumns={@JoinColumn(name ="c_id")},
					inverseJoinColumns = {@JoinColumn(name ="o_id")}
			)

	private List<Order> order;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public List<Order> getOrder() {
		return order;
	}
	public void setOrder(List<Order> order) {
		this.order = order;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", c_name=" + c_name + "]";
	}
	
	
}
