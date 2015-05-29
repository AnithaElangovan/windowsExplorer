package com.adaptavant.windowExplorerSpringmvc;

import java.util.Date;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Folder 
{
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key folderKey;
	@Persistent
	public String folderName;
	@Persistent
	public String folderType;
	@Persistent
	public String folderLocation1;
	@Persistent
	public String folderLocation2;
	@Persistent
	public int folderContains=0;
	@Persistent
	 private long folderTime=System.currentTimeMillis();;
	@Persistent
	public String belongsToDrive;
	
	
	@Persistent
	public List<File> fileInsideFolder;
	public List<File> getFile1()
	{
		return fileInsideFolder;
	}
	public void setFile1(List<File> file1)
	{
		this.fileInsideFolder=file1;
	}
	public void addFile(File file)
	{
		this.fileInsideFolder.add(file);
	}

	public String getFolderName()
	{
		return folderName;
	}
	public void setFolderName(String folderName)
	{
		this.folderName=folderName;	
	}
	public String getFolderType()
	{
		return folderType;
	}
	public void setFolderType(String folderType)
	{
		this.folderType=folderType;	
	}
	public String getFolderLocation()
	{
		return folderLocation2+folderLocation2;
	}
	public void setFolderLocation(String folderLocation1,String folderLocation2)
	{
		this.folderLocation1=folderLocation1;
		this.folderLocation2=folderLocation2;
	}
	public int getFolderContains()
	{
		System.out.println(folderContains+"items");
		return folderContains;
	}
	public void setFolderContains()
	{
		this.folderContains=fileInsideFolder.size();	
	}
	public long getDateAndTime() {
		return folderTime;
	}

	public void setDate(long date) {
		this.folderTime = new Date().getTime();
	}
	public String getBelongsToDrive() {
		return belongsToDrive;
	}
	public void setBelongsToDrive(String belongsToDrive) {
		this.belongsToDrive = belongsToDrive;
	}
	public Key getKey() {
		return folderKey;
	}

	public void setKey(Key folderkey) {
		this.folderKey = folderkey;
	}
//	public Folder() {
//		super();
//	}
//	
}
