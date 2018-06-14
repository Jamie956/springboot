package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.mapper.CategoryMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryDaoTest {
	
	@Autowired
	private CategoryMapper categoryMapper;
	
	@Test
	public void simpleList() {
		List<Category> cs =  categoryMapper.listCategory0();
		for(Category c:cs) {
			System.out.println(c);
		}
	}
	
	@Test
	public void simpleInsert() {
		Category c = new Category();
		c.setName("new Category");
		categoryMapper.addCategory(c);
	}
	
	@Test
	public void simpleDelete() {
		Category c = new Category();
		c.setId(2);
		categoryMapper.deleteCategory(c);
	}
	
	@Test
	public void simpleFindById() {
		Category rs = categoryMapper.getCategory(1);
		System.out.println(rs);
	}
	
	@Test
	public void simpleUpdate() {
		Category c = categoryMapper.getCategory(4);
		c.setName("update category");
		categoryMapper.updateCategory(c);
	}
	
	@Test
	public void simpleListByName() {
		List<Category> cs = categoryMapper.listCategoryByName("cat");
		for(Category c : cs){
			System.out.println(c);
		}
	}
	
	@Test
	public void simpleListIdByName() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", 1);
		params.put("name", "cat");
		List<Category> cs = categoryMapper.listCategoryByIdAndName(params);
		for(Category c : cs){
			System.out.println(c);
		}
	}
	
	@Test
	public void listOneToMany() {
		List<Category> cs = categoryMapper.listCategory2();
		for(Category c : cs){
			System.out.println(c);
			List<Product> ps = c.getProducts();
			for (Product p : ps) {
				System.out.println("\t" + p);
			}
		}
	}
	
}
