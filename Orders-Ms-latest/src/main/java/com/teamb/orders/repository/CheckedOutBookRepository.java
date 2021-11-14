package com.teamb.orders.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamb.orders.models.CheckedOutBook;

public interface CheckedOutBookRepository extends JpaRepository<CheckedOutBook, Integer> {

	
	List<CheckedOutBook> findByNameAndOrderid(String name,int orderid);

	List<CheckedOutBook> findByOrderidAndName(int orderid, String name);
	
	List<CheckedOutBook> findByOrderid(int orderid);
	
}
