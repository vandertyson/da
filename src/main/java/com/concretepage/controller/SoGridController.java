package com.concretepage.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.concretepage.entity.SoGrid;
import com.concretepage.iservice.ISoGridService;

@Controller
@RequestMapping("sogrid")
public class SoGridController {
	@Autowired
	private ISoGridService service;
	@GetMapping("grid/{id}")
	public ResponseEntity<SoGrid> getSoGridById(@PathVariable("id") Integer id) {
		SoGrid grid = service.getSoGridById(id);
		return new ResponseEntity<SoGrid>(grid, HttpStatus.OK);
	}
	@GetMapping("sogrids")
	public ResponseEntity<List<SoGrid>> getAllSoGrids() {
		List<SoGrid> list = service.getAllSoGrid();
		return new ResponseEntity<List<SoGrid>>(list, HttpStatus.OK);
	}
        
} 