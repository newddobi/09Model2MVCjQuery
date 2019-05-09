package com.model2.mvc.service.product;

import java.util.Map;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;

public interface ProductService {
	
	public void addProduct(Product product) throws Exception;
	
	public Product getProduct(int prodNo) throws Exception;
	
	public void updateProduct(Product product) throws Exception;
	
	public Map<String, Object> getProductList(Search search) throws Exception;
	
	public void increaseViewCount(int prodNo) throws Exception;
	
	public void addZzim(Map map) throws Exception;
	
	public void minusAmount(Product product) throws Exception;
	
	public Map<String, Object> getZzimList(Map<String, Object> map) throws Exception;
	
}
