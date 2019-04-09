package com.concretepage.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.concretepage.entity.SqGrid;
import com.concretepage.iservice.ISqGridService;

@Controller
@RequestMapping("sqgrid")
public class SqGridController {
	@Autowired
	private ISqGridService service;
	@GetMapping("grid/{id}")
	public ResponseEntity<SqGrid> getSqGridById(@PathVariable("id") Integer id) {
		SqGrid grid = service.getSqGridById(id);
		return new ResponseEntity<SqGrid>(grid, HttpStatus.OK);
	}
	@GetMapping("sqgrids")
	public ResponseEntity<List<SqGrid>> getAllSqGrids() {
		List<SqGrid> list = service.getAllSqGrid();
		return new ResponseEntity<List<SqGrid>>(list, HttpStatus.OK);
	}	
} 