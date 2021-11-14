package com.teamb.orders.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamb.orders.service.IOrdersService;

@RestController
@RequestMapping("/orders")
public class OrdersController implements IOrdersController {
	
	@Autowired
	private IOrdersService ordersService;
	private static final Logger log = LoggerFactory.getLogger(OrdersController.class);

	@Override
	@PostMapping("/process-order/{username}")
	public ResponseEntity<Object> processOrder(@PathVariable String username, @RequestHeader("Authorization") String auth) {
		log.info("inside processOrder - controller");
		return ordersService.processOrder(username, auth);
	}

	//show-return-books
	@Override
	@GetMapping("/get-all-books-ordered/{username}")
	public ResponseEntity<Object> getAllBooksOrdered(@PathVariable String username, @RequestHeader("Authorization") String auth) {
		log.info("inside getAllBooksOrdered - controller");
		return ordersService.getAllBooksOrdered(username, auth);
	}
	
	@Override
	@DeleteMapping("/return-book/{username}/{bookname}/{orderid}")
	public ResponseEntity<Object> returnBook(@PathVariable String username, @PathVariable String bookname, @PathVariable int orderid, @RequestHeader("Authorization") String auth) {		
		log.info("inside returnBook - controller");
		return ordersService.returnBook(username, bookname, orderid, auth);
	}
	
	/*------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@Override
	@GetMapping("/get-order-details/{username}")
	public ResponseEntity<Object> getOrderDetails(@PathVariable String username, @RequestHeader("Authorization") String auth)
	{
		log.info("inside getOrderDetails - controller");
		try {
		if(authClient.validateToken(auth.substring(7)).getStatusCodeValue()==200) {
		return new ResponseEntity<>(ordersService.getOrderDetails(username) ,HttpStatus.CREATED);
	}
		} catch(FeignException e) {
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}
		return null;
	}
	
	@Override
	@GetMapping("/get-all-orders/{username}")
	public ResponseEntity<Object> getAllOrders(@PathVariable String username, @RequestHeader("Authorization") String auth)
	{	
		log.info("inside getAllOrders - controller");
		try {
		if(authClient.validateToken(auth.substring(7)).getStatusCodeValue()==200) {
		return new ResponseEntity<>(ordersService.getAllOrders(username), HttpStatus.OK);
	} }
	catch(FeignException e) {
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}
		return null;
	}
	
	*/

}
