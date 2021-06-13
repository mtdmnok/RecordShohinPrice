//package com.example.demo.service;
//
//import java.util.List;
//
//import javax.management.Query;
//import javax.persistence.EntityManager;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.example.demo.entity.RecordEntity;
//import com.example.demo.repository.RecordRepository;
//
//public class RecordService {
//
//	@Autowired
//	RecordRepository repository;
//	EntityManager manager;
//
//	public List<RecordEntity> searchMaster(String shop_id, String category_id, String item_id){
//		List<RecordEntity> result;
//		
//		if ("".equals(shop_id) && "".equals(category_id) && "".equals(item_id)) {
//			result = repository.findAll();
//		} else {
//			StringBuilder sql = new StringBuilder();
//			sql.append("SELECT g From m_record g WHERE ");
//			boolean andFlg = false;
//			boolean shopIdFlg = false;
//			boolean categoryFlg = false;
//			boolean itemFlg = false;
//			
//			if (!"".equals(shop_id)) {
//				sql.append("g.shop_id = :shopId ");
//				shopIdFlg = true;
//				andFlg = true;
//			}
//			if (!"".equals(category_id)) {
//				if (andFlg) sql.append(" AND ");
//				sql.append("g.category_id = :categoryId ");
//				categoryFlg = true;
//				andFlg = true;
//			}
//			if (!"".equals(item_id)) {
//				if (andFlg) sql.append(" AND ");
//				sql.append("g.item_id = :itemId ");
//				itemFlg = true;
//			}
//			Query query = (Query) manager.createQuery(sql.toString());
//			if (shopIdFlg) ((javax.persistence.Query) query).setParameter("shopId", "%" + shop_id +"%");
//			if (categoryFlg) ((javax.persistence.Query) query).setParameter("shopId", "%" + category_id +"%");
//			if (itemFlg) ((javax.persistence.Query) query).setParameter("shopId", "%" + item_id +"%");
//			result = ((javax.persistence.Query) query).getResultList();
//		}
//		
//		return result;
//	}
//	
//}
