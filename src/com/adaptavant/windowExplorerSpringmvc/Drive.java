package com.adaptavant.windowExplorerSpringmvc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;


@PersistenceCapable
public class Drive 
{
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key drivekey;
	@Persistent
	public String driveName;
	@Persistent
	public String driveType;
	@Persistent
	public String driveFileSystem;
	@Persistent
	public int usedSpace=0;
	@Persistent
	public int freeSpace=0;
	@Persistent
	public int capacity=50;
	@Persistent
    private long Date=System.currentTimeMillis();
	
	@Persistent
	public List<Folder> folder;      //FOLDER OBJECT
	
	public List<Folder> getFolder()
	{
		return folder;
	}
	public void setFolder(List<Folder> folder)
	{
		this.folder=folder;
	}
	public void addFolder(Folder folder)
	{
		this.folder.add(folder);
	}
	
	@Persistent
	public List<File> fileInsideDrive;         //FILE OBJECT
	
	public List<File> getFile()
	{
		return fileInsideDrive;
	}
	public void setFile(List<File> file)
	{
		this.fileInsideDrive=file;
	}
	public void addfile(File file)
	{
		this.fileInsideDrive.add(file);
	}

	public String getDriveName()
	{
		return driveName;
	}
	public void setDriveName(String driveName)
	{
		this.driveName=driveName;	
	}
	public String getDriveType()
	{
		return driveType;
	}
	public void setDriveType(String driveType)
	{
		this.driveType=driveType;	
	}
	public String getDriveFileSystem()
	{
		return driveFileSystem;
	}
	public void setDriveFileSystem(String driveFileSystem)
	{
		this.driveFileSystem=driveFileSystem;	
	}
	public int getDriveUsedSpace()
	{
		return usedSpace;
	}
	public void setDriveUsedSpace(int usedSpace)
	{
		this.usedSpace= ((Folder) folder).getFolderContains();	
	}
	public int getDriveFreeSpace()
	{
		return freeSpace;
	}
	public void setDriveFreeSpace(int freeSpace)
	{
		freeSpace=capacity-usedSpace;
		this.freeSpace=freeSpace;	
	}
	public int getDriveCapacity()
	{
		return capacity;
	}
	public void setDriveCapacity(int capacity)
	{
		this.capacity=capacity;	
	}
	public long getDate() {
		return Date;
	}

	public void setDate(long date) {
		this.Date = date;
	}
//	public Key getKey() {
//		return drivekey;
//	}
//
//	public void setKey(Key key, Key drivekey) {
//		this.drivekey = drivekey;
//	}
//	public Drive() {
//	super();
//}

}

