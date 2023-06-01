package com.balu.jpa.springbootjpa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.balu.jpa.springbootjpa.entity.Product;
import com.balu.jpa.springbootjpa.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/product")
@Api(tags="product")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@PostMapping(value = "/addProduct")
	@ApiOperation(value = "${ProductController.addProduct}")
	@ApiResponses(value = {
			@ApiResponse(code=400,message="Something went wrong"),
			@ApiResponse(code=403,message="Access denied"),
			@ApiResponse(code=500,message="Something went wrong") })
	public Product addProduct(HttpServletRequest req, @ApiParam("Add Product") @RequestBody Product product) {
		return productService.saveProduct(product);
	}
	
	@PostMapping("/addProducts")
	@ApiResponses(value= {@ApiResponse(code=400,message="Something went wrong"),
            @ApiResponse(code=403,message="Access denied"),
            @ApiResponse(code=500,message="Something went wrong")})
	public List<Product> addProducts(HttpServletRequest req, @ApiParam("Add Products") @RequestBody List<Product> products){
		return productService.saveProducts(products);
	}
	
	@GetMapping("/products")
	@ApiResponses(value= {@ApiResponse(code=400,message="Something went wrong"),
            @ApiResponse(code=403,message="Access denied"),
            @ApiResponse(code=500,message="Something went wrong")})
	public List<Product> findAllProducts(HttpServletRequest req){
		return productService.getProducts();
	}
	
	@GetMapping("/productById/{id}")
	@ApiResponses(value= {@ApiResponse(code=400,message="Something went wrong"),
            @ApiResponse(code=403,message="Access denied"),
            @ApiResponse(code=500,message="Something went wrong")})
	public Product findProductById(HttpServletRequest req,@ApiParam("id") @PathVariable Integer id) {
		return productService.getProductById(id);
	}
	
	@GetMapping("/productByName/{name}")
	@ApiResponses(value= {@ApiResponse(code=400,message="Something went wrong"),
            @ApiResponse(code=403,message="Access denied"),
            @ApiResponse(code=500,message="Something went wrong")})
	public Product findProductByName(HttpServletRequest req, @ApiParam("name") @PathVariable String name) {
		return productService.getProductByName(name);
	}
	
	@PutMapping("/updateProduct")
	@ApiResponses(value= {@ApiResponse(code=400,message="Something went wrong"),
            @ApiResponse(code=403,message="Access denied"),
            @ApiResponse(code=500,message="Something went wrong")})
	public Product updateProduct(HttpServletRequest req, @ApiParam("update product") @RequestBody Product product) {
		return productService.updateProduct(product);
	}
	
	@DeleteMapping("/delete/{id}")
	@ApiResponses(value= {@ApiResponse(code=400,message="Something went wrong"),
            @ApiResponse(code=403,message="Access denied"),
            @ApiResponse(code=500,message="Something went wrong")})
	public String deleteProduct(HttpServletRequest req, @ApiParam("id") @PathVariable Integer id) {
		return productService.deleteProduct(id);
	}
}
