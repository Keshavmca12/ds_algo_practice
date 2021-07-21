package com.adp.practice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.Callable;

public class FtpFileHandler implements Callable<FileOutputData>{
	
	List<FileData> dataList;
	
	public FtpFileHandler() {
		super();
	}

	public FtpFileHandler(List<FileData> dataList) {
		super();
		this.dataList = dataList;
	}

	@Override
	public FileOutputData call() throws Exception {
		if(dataList == null || dataList.size() == 0) {
			return null;
		}
		FileOutputData outputData = new FileOutputData();
		for (FileData fileData : dataList) {
			outputData.setTax(outputData.getTax().add((fileData.getTax())));
			outputData.setTaxable(outputData.getTaxable().add(fileData.getTaxable()));
		}
		outputData.setNoOfSsn(Long.valueOf(dataList.size()));
		outputData.setFileName(LocalDateTime.now().toString());
		return  outputData;
	}

}
