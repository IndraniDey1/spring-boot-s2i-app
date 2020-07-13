package com.example.controller;

import java.io.IOException;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import com.example.services.CatFactService;

@Controller
@RequestMapping("catfactservice")
public class CatFactController {

	@Autowired
	private CatFactService service;

	@GetMapping("facts")
	public ResponseEntity<String> getCategories() {

		String facts = null;
		try {
			facts = service.getCatFacts();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<String>(facts, HttpStatus.OK);
	}
	
	@GetMapping("randomfacts")
	public ResponseEntity<String> getRandomFacts() {

		String facts = null;
		try {
			facts = service.getRandomFacts();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<String>(facts, HttpStatus.OK);
	}
}