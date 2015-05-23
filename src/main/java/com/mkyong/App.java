package com.mkyong;

import java.util.Date;
import java.util.Random;

import org.hibernate.Session;

import com.mkyong.stock.Stock;
import com.mkyong.stock.StockDailyRecord;
import com.mkyong.util.HibernateUtil;


//normal no cascade
/*
 * with no casacade we should insert every entity independently
 * and we should save stock first
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hibernate one to many (Annotation)");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
	    Random randomGenerator = new Random();

		Stock stock = new Stock();
        stock.setStockCode("7052"+randomGenerator.nextInt(100000));
        stock.setStockName("PADINI"+randomGenerator.nextInt(1000000));
        
      //first save
        session.save(stock);
        
        StockDailyRecord stockDailyRecords = new StockDailyRecord();
        stockDailyRecords.setPriceOpen(new Float("1.2"));
        stockDailyRecords.setPriceClose(new Float("1.1"));
        stockDailyRecords.setPriceChange(new Float("10.0"));
        stockDailyRecords.setVolume(3000000L);
        stockDailyRecords.setDate(new Date());
        
        stockDailyRecords.setStock(stock);        
        stock.getStockDailyRecords().add(stockDailyRecords);

        
        //second save
        session.save(stockDailyRecords);
        
        


		session.getTransaction().commit();
		System.out.println("Done");
	}
}
