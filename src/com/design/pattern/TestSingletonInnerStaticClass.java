package com.design.pattern;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * @Autor : Keshav Kumar 
 * @Date : 03-Feb-2020
 */

public class TestSingletonInnerStaticClass {
	 public static void main(String[] args)  
	    { 
	        try
	        { 
	        	SingletonInnerClass instance1 = SingletonInnerClass.getInstance(); 
	            ObjectOutput out 
	                = new ObjectOutputStream(new FileOutputStream("file.text")); 
	            out.writeObject(instance1); 
	            out.close(); 
	      
	            // deserailize from file to object 
	            ObjectInput in  
	                = new ObjectInputStream(new FileInputStream("file.text")); 
	              
	            SingletonInnerClass instance2 = (SingletonInnerClass) in.readObject(); 
	            in.close(); 
	      
	            System.out.println("instance1 hashCode:- "
	                                                 + instance1.hashCode()); 
	            System.out.println("instance2 hashCode:- " 
	                                                 + instance2.hashCode()); 
	        }  
	          
	        catch (Exception e)  
	        { 
	            e.printStackTrace(); 
	        } 
	    } 
}


