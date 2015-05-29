package com.adaptavant.windowExplorerSpringmvc;

import java.math.BigInteger;


import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class File 
{
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key fileKey;
	@Persistent
	public String fileName;
	@Persistent
	public String fileType;
	@Persistent
	public String fileLocation1;
	@Persistent
	public String fileLocation2;
	@Persistent
	public String fileLocation3;
	@Persistent
	public BigInteger fileSize;
	@Persistent
	 private long DateAndTime=System.currentTimeMillis();
	@Persistent
	public String belongsToFolder;
	@Persistent
	public String belongsToDrive;
	
	public String getFileName()
	{
		return fileName;
	}
	public void setFileName(String fileName)
	{
		this.fileName=fileName;	
	}
	public String getFileType()
	{
		return fileType;
	}
	public void setFileType(String fileType)
	{
		this.fileType=fileType;	
	}
	public String getFileLocation()
	{
		return fileLocation1+fileLocation2+fileLocation3;
	}
	public void setFileLocation(String fileLocation1,String fileLocation2,String fileLocation3)
	{
		this.fileLocation1=fileLocation1;
		this.fileLocation2=fileLocation2;
		this.fileLocation3=fileLocation3;
	}
	public BigInteger getFileSize()
	{
		//System.out.println(fileSize+"kb");
		return fileSize;
	}
	public void setFileSize()
	{
		this.fileSize=new BigInteger("1");	
	}
	public long getDate() {
		return DateAndTime;
	}

	public void setDate(long date) {
		this.DateAndTime = date;
	}
	
	public Key getKey() {
		return fileKey;
	}

	public void setKey(Key filekey) {
		this.fileKey = filekey;
	}
//	public File() {
//		super();
//	}
	public String getBelongsToFolder() {
		return belongsToFolder;
	}
	public void setBelongsToFolder(String belongsToFolder) {
		this.belongsToFolder = belongsToFolder;
	}
	public String getBelongsToDrive() {
		return belongsToDrive;
	}
	public void setBelongsToDrive(String belongsToDrive) {
		this.belongsToDrive = belongsToDrive;
	}
}
