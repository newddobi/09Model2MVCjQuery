package com.model2.mvc.service.product.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Review;
import com.model2.mvc.service.product.ProductDao;
import com.model2.mvc.service.product.ProductService;

@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService{

	@Autowired
	@Qualifier("productDaoImpl")
	private ProductDao productDao;
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	public ProductServiceImpl() {
		System.out.println(this.getClass());
	}

	@Override
	public void addProduct(Product product) throws Exception {
		productDao.addProduct(product);
	}

	@Override
	public Product getProduct(int prodNo) throws Exception {
		return productDao.getProduct(prodNo);
	}

	@Override
	public void updateProduct(Product product) throws Exception {
		productDao.updateProduct(product);
	}

	@Override
	public Map<String, Object> getProductList(Search search) throws Exception {
		List<Product> list = productDao.getProductList(search);
		int totalCount = productDao.getTotalCount(search);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("totalCount", new Integer(totalCount));
		
		return map;
	}

	@Override
	public void increaseViewCount(int prodNo) throws Exception {
		productDao.increaseViewCount(prodNo);
	}

	@Override
	public void addZzim(Map map) throws Exception {
		productDao.addZzim(map);
	}

	@Override
	public void minusAmount(Product product) throws Exception {
		productDao.minusAmount(product);
	}

	@Override
	public Map<String, Object> getZzimList(Map<String, Object> map) throws Exception {
		List<Product> list = productDao.getZzimList(map);
		int totalCount = productDao.getTotalCount2((Search)map.get("search"));

		map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("totalCount", new Integer(totalCount));
		
		return map;
	}
	@Override
	public void addReview(Review review) throws Exception {
		productDao.addReview(review);
	}

	@Override
	public Map<String, Object> getReviewList(Map<String, Object> map) throws Exception {
		return null;
	}

}
