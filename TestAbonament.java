package Tests;

import static org.junit.Assert.*;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import proiectCTS.Abonament;
import proiectCTS.AbonamentBuilder;
import proiectCTS.Card;
import proiectCTS.Client;



public class TestAbonament {
  Abonament A = new Abonament(); 
  Abonament B= new AbonamentBuilder().setIdAbon(1234).setIdClient(23).setStart("3 Martie 2015")
			.setEnd("2 Aprilie 2015").setCNP("1880930100213").build();
  Abonament C = new AbonamentBuilder().setCNP("2940308212745").setIdAbon(1236).build();
 public FileReader reader;
 public BufferedReader bf;
   
  //Verificam daca pretul abonamentului unui student este corect
	@Test
	public void test_pretStudent_corect() {
		double pretStudent=A.pretStudent(120, 2);
		Assert.assertEquals(60.0,pretStudent);
		double pretStudent2=A.pretStudent(140, 2);
		Assert.assertEquals(70.0,pretStudent2);
		
	}
	
	//Verificam daca se arunca exceptie cand procentul este 0. 
	@Test
	public void test_pretStudent_FAIL()
	{
		double pretStudent=0;
		try		
		{
			pretStudent=A.pretStudent(120, 0);
			System.out.println(pretStudent);
			fail("Incorect!! Cand procentul e 0 trebuia sa se arunce exceptie");
		}catch(Exception epr){
			System.out.println(pretStudent);
		}
	}
	
	
	//Citire din fisier pentru builder
	
	//@Before
//	public void setUp() throws Exception
//	{
//		reader=new FileReader("builder.txt");
//		bf=new BufferedReader(reader);
//	}
	
	//Verificam daca abonamentul este construit corect prin metoda build()
    @Test
    public void test_builder()
    {
    	Assert.assertTrue(B.CNP=="1880930100213");
    	Assert.assertTrue(B.dataStart=="3 Martie 2015");
    	Assert.assertTrue(B.idAbonament==1234);
    	Assert.assertTrue(B.nrTelefon==null);
    }
    
//    @After
//    public void tearDown() throws Exception
//    {
//    	bf.close();
//    	reader.close();
//    	
//    }
    //Verificam daca se acorda discount clientilor vechi
    
    @Test
    public void test_discount()
    {
    	boolean discount=A.discount(13);
    	Assert.assertTrue(discount);
    	boolean discountNu=A.discount(10);
    	Assert.assertFalse(discountNu);
    }
    

  //Metoda care citeste din fisier
//    @Test
//    public void citireFisierBuilder()
//    {
//    	String linie=null;
//    	String CNP= null;
//    	int idAbon= 0;
//    	//List<String>lista=new ArrayList<>();
//    	try{
//    		
//    		while((linie=bf.readLine()) != null && linie.length() !=0 )
//    		{
//    			linie=bf.readLine();
//    			CNP=linie.split(" ")[0];
//    			idAbon=Integer.parseInt(linie.split(" ")[1]);
//    			System.out.println("Citire din fisier a abonamentului");
//    			Assert.assertTrue(A.CNP==CNP);
//    			Assert.assertTrue(A.idAbonament==idAbon);
//    			
//    		}
//    	}
//    	catch(IOException ex)
//    	{
//    		ex.printStackTrace();
//    	}
//    }
}
