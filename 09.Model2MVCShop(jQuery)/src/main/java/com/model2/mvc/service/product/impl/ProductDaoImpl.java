package com.model2.mvc.service.product.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Review;
import com.model2.mvc.service.product.ProductDao;

@Repository("productDaoImpl")
public class ProductDaoImpl implements ProductDao{

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//������
	public ProductDaoImpl() {
		System.out.println(this.getClass());
	}

	@Override
	public void addProduct(Product product) throws Exception {
		sqlSession.insert("ProductMapper.addProduct", product);
	}

	@Override
	public Product getProduct(int prodNo) throws Exception {
		return sqlSession.selectOne("ProductMapper.getProduct", prodNo);
	}

	@Override
	public void updateProduct(Product product) throws Exception {
		sqlSession.update("ProductMapper.updateProduct", product);
	}

	@Override
	public List<Product> getProductList(Search search) throws Exception {
		return sqlSession.selectList("ProductMapper.getProductList", search);
	}

	@Override
	public int getTotalCount(Search search) throws Exception {
		return sqlSession.selectOne("ProductMapper.getTotalCount", search);
	}

	@Override
	public void increaseViewCount(int prodNo) throws Exception {
		sqlSession.update("ProductMapper.increaseViewCount", prodNo);
	}

	@Override
	public void addZzim(Map map) throws Exception {
		sqlSession.update("ProductMapper.addZzim", map);
	}

	@Override
	public void minusAmount(Product product) throws Exception {
		sqlSession.update("ProductMapper.minusAmount", product);
		
	}

	@Override
	public List<Product> getZzimList(Map map) throws Exception {
		return sqlSession.selectList("ProductMapper.getZzimList", map);
	}

	@Override
	public int getTotalCount2(Search search) throws Exception {
		return sqlSession.selectOne("ProductMapper.getTotalCount2", search);
	}

	@Override
	public void addReview(Review review) throws Exception {
		sqlSession.insert("ReviewMapper.addReview", review);
	}

	@Override
	public List<Product> getReviewList(Map map) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalCount3(Search search) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
}
