package com.adp.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Assume there is FTP Location, where we read files in concurrent (Each may have a size of 1GB) contains
 *  around 100k employee details in each file and those belongs to a single company.
 Please code for an optimum solution:
1.    Input is csv file (Attached)
2.    Write to single file below details, by handling concurrency so that at a time only one file-writer is active.:
3.    Requests to input file parsing are not sequential, so better handle them for parallel
file-name , total tax, total taxable, number of distinct SSNs
 * @author kesha
 *
 */

/**'
 * WorkerId    FirstName    LastName    SSN    Taxable    Tax
1    FirstName1    LastName1    SSN1    10000    100
2    FirstName1    LastName1    SSN1    10000    100
3    FirstName3    LastName3    SSN3    20000    200
4    FirstName4    LastName4    SSN4    20000    200
5    FirstName5    LastName5    SSN5    10000    100
6    FirstName6    LastName6    SSN6    20000    200
7    FirstName7    LastName7    SSN7    20000    200
8    FirstName8    LastName8    SSN8    20000    200
9    FirstName9    LastName9    SSN9    10000    100
10    FirstName10    LastName10    SSN10    30000    300

from Anantha Gadi (privately):    10:45 AM
***********output******
from Anantha Gadi (privately):    10:45 AM
fileName    TotalTaxable    TotalGross    NoOfSSns
worker-details-input    17000    1700    9
 * @author kesha
 *
 */
public class FileDataHandler {
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(8);
		List<List<FileData>> dataList = new ArrayList<>();
		List<Future<FileOutputData>> resultList = new ArrayList<>();
		for (List<FileData> data: dataList) {
			Callable<FileOutputData> task = new FtpFileHandler(data);
			Future<FileOutputData> future = executorService.submit(task);
			resultList.add(future);
		}
		
			
		for (Future<FileOutputData> future : resultList) {
			FileOutputData result = null;
			try {
				result = future.get();
				writeOutputFile(result);
			} catch (InterruptedException | ExecutionException e) {
				// ... Exception handling code ...
	        } 
	    }
		
		executorService.shutdown();
	}
	
	public static synchronized void writeOutputFile(FileOutputData data) {
		/**
		 * Writing to file logic here
		 */
	}
	
	

}
