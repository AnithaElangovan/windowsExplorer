package com.adaptavant.windowExplorerSpringmvc;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;



@PersistenceCapable
public class Explorer 
{
	@PrimaryKey
	@Persistent
	private String primaryExplorer = "primaryExplorer";
	@Persistent
	public List<Drive> driveList;
	
	

	public List<Drive> getDrive()
	{
		return driveList;
	}
	public void setDrive(List<Drive> drive)
	{
		this.driveList=drive;
	}
	public void setDrive() 
	{
		this.driveList = new ArrayList<Drive>();
	}
	public void addListOfDrives(Drive drive)
	{
		this.driveList.add(drive);
	}
	public String getPrimaryExplorer()
	{
		return "primaryExplorer";
	}
	

}
	
