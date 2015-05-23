package com.mkyong;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import com.mkyong.stock.Stock2;
import com.mkyong.stock.StockDailyRecord2;
import com.mkyong.util.HibernateUtil;


//test cascade delete
public class App2 {
	public static void main(String[] args) {
		System.out.println("Hibernate one to many (Annotation)");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		
		
		Query query = session.createQuery("from Stock2 where stockId=50 " );
		
		Stock2 stock =(Stock2) query.uniqueResult();
		
		Set<StockDailyRecord2> stockDailyRecords = stock.getStockDailyRecords();
//		
		
		Iterator<StockDailyRecord2> iterator = stockDailyRecords.iterator();
		
		while(iterator.hasNext()){
			
			StockDailyRecord2 stockDailyRecord=(StockDailyRecord2)iterator.next();
			
			if(stockDailyRecord.getRecordId()==52){
				stockDailyRecords.remove(stockDailyRecord);
				System.out.println("find stockdetail");
				break;
			}
			
			
			
		}	
		
		
		stock.setStockDailyRecords(stockDailyRecords);
		
		session.saveOrUpdate(stock);
		
//		session.delete(stock);
		
//		for(Stock stock:list){
//			System.out.println(stock.getStockDailyRecords());
//		
//			Set<StockDailyRecord> stockDailyRecords = stock.getStockDailyRecords();
//			
//			
//			Iterator<StockDailyRecord> iterator = stockDailyRecords.iterator();
//			
//			while(iterator.hasNext()){
//				
//				StockDailyRecord stockDailyRecord=(StockDailyRecord)iterator.next();
//				
//				System.out.println(stockDailyRecord.getDate());
//				
//			}
//			
//		
//		}
		
		

//		Stock stock = new Stock();
//        stock.setStockCode("70521");
//        stock.setStockName("PADINI1");
////        session.save(stock);
//        
//        StockDailyRecord stockDailyRecords = new StockDailyRecord();
//        stockDailyRecords.setPriceOpen(new Float("1.2"));
//        stockDailyRecords.setPriceClose(new Float("1.1"));
//        stockDailyRecords.setPriceChange(new Float("10.0"));
//        stockDailyRecords.setVolume(3000000L);
//        stockDailyRecords.setDate(new Date());
//        stockDailyRecords.setStock(stock);      
//        
//        
//        StockDailyRecord stockDailyRecords1 = new StockDailyRecord();
//        stockDailyRecords1.setPriceOpen(new Float("1.2"));
//        stockDailyRecords1.setPriceClose(new Float("1.1"));
//        stockDailyRecords1.setPriceChange(new Float("10.0"));
//        stockDailyRecords1.setVolume(3000000L);
//        stockDailyRecords1.setDate(new Date());
//        stockDailyRecords1.setStock(stock);  
//        
//        stock.getStockDailyRecords().add(stockDailyRecords);
//        stock.getStockDailyRecords().add(stockDailyRecords1);
//
//        session.save(stock);
//
		session.getTransaction().commit();
		System.out.println("Done");
	}
}
