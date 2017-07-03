package com.mkyong;

import java.util.Date;
import java.util.Random;

import org.hibernate.Session;

import com.mkyong.stock.Stock1;
import com.mkyong.stock.StockDailyRecord1;
import com.mkyong.util.HibernateUtil;


//test cascade save-update
public class App1 {
	
	
	
	public static void main(String[] args) {
		
		System.out.println("Hibernate one to many (Annotation)");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		 Random randomGenerator = new Random();

		Stock1 stock = new Stock1();
		stock.setStockCode("7052"+randomGenerator.nextInt(100000));
        stock.setStockName("PADINI"+randomGenerator.nextInt(1000000));
//        session.save(stock);
        
        StockDailyRecord1 stockDailyRecords = new StockDailyRecord1();
        stockDailyRecords.setPriceOpen(new Float("1.2"));
        stockDailyRecords.setPriceClose(new Float("1.1"));
        stockDailyRecords.setPriceChange(new Float("10.0"));
        stockDailyRecords.setVolume(3000000L);
        stockDailyRecords.setDate(new Date());
        stockDailyRecords.setStock(stock);      
        
        
        StockDailyRecord1 stockDailyRecords1 = new StockDailyRecord1();
        stockDailyRecords1.setPriceOpen(new Float("1.2"));
        stockDailyRecords1.setPriceClose(new Float("1.1"));
        stockDailyRecords1.setPriceChange(new Float("10.0"));
        stockDailyRecords1.setVolume(3000000L);
        stockDailyRecords1.setDate(new Date());
        stockDailyRecords1.setStock(stock);  
        
        stock.getStockDailyRecords().add(stockDailyRecords);
        stock.getStockDailyRecords().add(stockDailyRecords1);

        
        /*
         * only one save
         */
        session.save(stock);

		session.getTransaction().commit();
		System.out.println("Done");
	}
}
