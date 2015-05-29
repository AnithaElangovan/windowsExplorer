package com.adaptavant.windowExplorerSpringmvc;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;






@Controller
public class WindowsExplorerController 
{
	int num=0;
	
	static PersistenceManager pm;
	private int tempVariable=0;
	@RequestMapping(value="/")
	public ModelAndView frontpage(@ModelAttribute ("Explorer")Explorer explorer) 
	{
		if (tempVariable < 1) {
			tempVariable++;
			explorer.getPrimaryExplorer();
//			Drive desktop=new Drive();
//			explorer.addListOfDrives(desktop);
			explorer.getDrive();
		System.out.println("before try");
		pm = PersitenceManagerFactoryClass.get().getPersistenceManager();	
		
		try 
		{
			
			System.out.println("before persistence");
			pm.makePersistent(explorer);
			System.out.println("after persistence");
			
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
		}
		pm.close();
		
		
		
		//ModelAndView model = new ModelAndView("redirect:/"+(i++));
		ModelAndView model = new ModelAndView("redirect:/display{}"+(num++));
		return model;
	}
	

	//@RequestMapping(value = "/{driveNum}")
	@RequestMapping(value = "/display{num}")
	public ModelAndView getIndex(){

		pm = PersitenceManagerFactoryClass.get().getPersistenceManager();
		String driveListObject="[";
		String driveFolderObject = "[";
		String folderFileObject ="[";
         ModelAndView model = null;
			try
			{
				
				System.out.println("1");
				Explorer explorer = pm.getObjectById(Explorer.class,"primaryExplorer");
				if(explorer.getDrive().size()!=0)
				{
				//listing drives on left div
				System.out.println("2");
				List<Drive> driveList=explorer.getDrive();
				System.out.println(driveList);
				System.out.println("3");
				
				System.out.println("4");
				for(int i=0;i<driveList.size();i++)
				{
					System.out.println("5");
					driveListObject +="{driveName:\""+driveList.get(i).getDriveName()+"\",driveType:\""+driveList.get(i).getDriveType()+"\",capacity:\""+driveList.get(i).getDriveCapacity()+"\",Date:\""+driveList.get(i).getDate()+"\"},";
					System.out.println("6");
				}
				System.out.println(driveListObject);
				driveListObject=driveListObject.substring(0,driveListObject.length()-1)+"]";
				System.out.println("8");
				//list folder on right side
//				if(driveNum==0)
//				{
//				driveNum+=1;	
//				}
				
        		for(int i=0;i<driveList.size();i++)
				{
				Drive tempdrive=driveList.get(i);
				if(tempdrive.getFolder().size()!=0)
				{
				List<Folder> folderList=driveList.get(0).getFolder();
				System.out.println("9");
//				driveFolderObject="[";
				System.out.println("10");
				for(int j=0;j<driveList.size();j++)
				{System.out.println("11");
					driveFolderObject +="{folderName:\""+folderList.get(j).getFolderName()+"\",folderType:\""+folderList.get(j).getFolderType()+"\",belongsToDrive:\""+folderList.get(j).getBelongsToDrive()+"\",folderContains:\""+folderList.get(j).getFolderContains()+"\",Date:\""+folderList.get(j).getDateAndTime()+"\"},";
				}System.out.println(driveFolderObject);
				driveFolderObject=driveFolderObject.substring(0,driveFolderObject.length()-1)+"]";
				System.out.println("13");
				}
				}
        		//List file on right side
//				if(driveNum==1)
//				{
//				driveNum+=2;	
//				}
				List<Folder> folderList=driveList.get(0).getFolder();
				for(int k=0;k<folderList.size();k++)
				{
				Folder tempfolder=folderList.get(k);
				if(tempfolder.getFile1().size()!=0)
				{
				List<File> fileList=folderList.get(0).getFile1();
				System.out.println("14");
//				folderFileObject="[";
				System.out.println("15");
				for(int i=0;i<folderList.size();i++)
				{
					System.out.println("16");
					folderFileObject +="{fileName:\""+fileList.get(i).getFileName()+"\",fileType:\""+fileList.get(i).getFileType()+"\",belongsToFolder:\""+fileList.get(i).getBelongsToFolder()+"\",belongsToDrive:\""+fileList.get(i).getBelongsToDrive()+"\",fileSize:\""+fileList.get(i).getFileSize()+"\",Date:\""+fileList.get(i).getDate()+"\"},";
				}
				System.out.println("17");
				folderFileObject=folderFileObject.substring(0,folderFileObject.length()-1)+"]";
				}
				}
				System.out.println("18");
				model = new ModelAndView("frontpage.jsp");
				System.out.println("19");
				model.addObject("driveListObject",driveListObject);
				System.out.println("20");
				model.addObject("driveFolderObject",driveFolderObject);
				System.out.println("21");
				model.addObject("folderFileObject",folderFileObject);
				System.out.println("22");
				
				return model;
				
				}else{
					model=new ModelAndView("frontpage.jsp");
					model.addObject("errorMessage","Error");
					return model;
				}
			
				}
			catch(Exception e){
				model = new ModelAndView("frontpage.jsp");
				model.addObject("errorMessage","Error");
				return model;
			}
			finally{
				pm.close();
			}

			
		}
	
	
			
	@RequestMapping(value="/drivecreated",method=RequestMethod.POST)
	public ModelAndView driveCreated(@ModelAttribute Drive drive)
	{
		ModelAndView model = null;
		if("".equals(drive.getDriveName())){
			model = new ModelAndView("frontpage.jsp");
			model.addObject("errorMessage","Error: Drive Field Cannot Be Empty");
			return model;
		}
//		if(result.hasErrors())
//		{
//			System.out.println("drivecreated has error");
//		    model = new ModelAndView("CreateDrive.jsp");
//			System.out.println("error");
//			return model;
//		}
             System.out.println("before drive pm");
		pm = PersitenceManagerFactoryClass.get().getPersistenceManager();
		
		try 
		{
			
			Explorer explorer = pm.getObjectById(Explorer.class,"primaryExplorer");
			System.out.println("before d try");
			
			System.out.println("drive object");
		
			List<Drive> tempList = explorer.getDrive();
			
			List<String> driveNameList = new ArrayList<String>();
			if (tempList !=null)
			{
				for (int i = 0; i < tempList.size(); i++) 
				{
					System.out.println("enters for");
					driveNameList.add(tempList.get(i).getDriveName());
				}
				if (driveNameList.contains(drive.getDriveName())) 
				{
					System.out.println("enters if");
					model = new ModelAndView("CreateDrive.jsp");
					model.addObject("errorMessage","Error:Drive" + drive.getDriveName() + " Exists");
					return model;
				}
				else
				{
					System.out.println("enters 1st else");
					explorer.addListOfDrives(drive);
				}
			}
			else
			{
				System.out.println("enters 2nd else"+drive.getDriveName());
				explorer.addListOfDrives(drive);
			}
		}
		catch(Exception e)
		{
			
			System.out.println("error bhhghyh"+e);
			model = new ModelAndView("CreateDrive.jsp");
			model.addObject("errorMessage","Error: Drive Creation Failed");
			return model;
		}
		finally 
		{
			pm.close();
		}
		System.out.println("before redirect");
//		Explorer explorer = pm.getObjectById(Explorer.class,"primaryExplorer");
//		List<Drive> tempList = explorer.getDrive();
//		for (int i = 0; i < tempList.size(); i++) 
//		{
		
		model = new ModelAndView("redirect:/");
		System.out.println("after redirect");
		return model;
//		return model;
//		}
		
		
		
		
	}

		
		@RequestMapping(value="/foldercreated",method=RequestMethod.POST)
		public ModelAndView foldercreated(@ModelAttribute ("folder")Folder folder,@RequestParam ("folderName")String folderName,@RequestParam ("folderType")String folderType,BindingResult result,ModelMap model1){
			if(result.hasErrors()){
				ModelAndView model = new ModelAndView("CreatFolder.jsp");
				return model;
			}
			pm = PersitenceManagerFactoryClass.get().getPersistenceManager();
			
			try{
				Explorer explorer = pm.getObjectById(Explorer.class,"primaryExplorer");
				List<Drive> tempList = explorer.getDrive();
				for(int i=0;i<tempList.size();i++){
					Drive tempDrive = tempList.get(i);
					if(tempDrive.getDriveName().equals(folder.getBelongsToDrive())){
						tempDrive.addFolder(folder);
					}
				}
				folder.setFolderLocation(folder.belongsToDrive,folder.folderName);
				folder.getFolderLocation();
				folder.setFolderContains();
				folder.getFolderContains();

				Query q = pm.newQuery(Folder.class);
				System.out.println(q);
				q.setFilter("folderName == name");
				q.declareParameters("String name");
				q.setFilter("folderType == type");
				q.declareParameters("String type");
				@SuppressWarnings("unchecked")
				List<Folder> results = (List<Folder>) q.execute(folderName);
				System.out.println(folderName);
				if (results.isEmpty()) {
					model1.addAttribute("folderName", null);
				} else {
					model1.addAttribute("folderName",results );
					model1.addAttribute("folderType", results);

				}
			}catch(Exception e){
				ModelAndView model = new ModelAndView("frontpage.jsp");
				model.addObject("errorMessage","Error: "+folder.getBelongsToDrive()+" does not exists.");
				return model;
			}finally{
				pm.close();
			}
			ModelAndView model = new ModelAndView("redirect:/");
			return model;
		}
				
		@RequestMapping(value="/filecreated",method=RequestMethod.POST)
		public ModelAndView filecreated(@ModelAttribute ("file")File file,BindingResult result){
			if(result.hasErrors()){
				System.out.println("file has error");
				ModelAndView model = new ModelAndView("CreateFile.jsp");
				return model;
			}
			pm = PersitenceManagerFactoryClass.get().getPersistenceManager();
			try{
				System.out.println("file try");
				System.out.println("enters file try");
				Explorer explorer = pm.getObjectById(Explorer.class,"primaryExplorer");
						System.out.println("create drive obj");
				System.out.println("create tempList");
				List<Drive> tempList = explorer.getDrive();
				System.out.println("1"+tempList);

				for(int i=0;i<tempList.size();i++)
				{				System.out.println("2");

					System.out.println("enters for");
					Drive tempDrive=tempList.get(i);
					if(tempDrive.getDriveName().equals(file.getBelongsToDrive()))
					{
						System.out.println("enters if");
						List<Folder> tempList1= tempDrive.getFolder();
						for(int j=0;j<tempList1.size();j++)
						{
							Folder tempFolder=tempList1.get(j);
							if(tempFolder.getFolderName().equals(file.getBelongsToFolder()))
							{
								System.out.println("enters 2nd if");
								tempFolder.addFile(file);
							}
						}
					}
				}
				file.setFileLocation(file.belongsToDrive, file.belongsToFolder, file.fileName);
				file.getFileLocation();
				file.setFileSize();
				file.getFileSize();
			}catch(Exception e){
				ModelAndView model = new ModelAndView("CreateFile.jsp");
				model.addObject("errorMessage","Error: "+file.getBelongsToDrive()+" does not exists.");
				return model;
			}finally{
				pm.close();
			}
			ModelAndView model = new ModelAndView("redirect:/");
			return model;
		}	
		
		
		@RequestMapping(value = "/searchfolder", method = RequestMethod.GET)
		public String searchfolder(@RequestParam("folderName") String folderName,
				HttpServletRequest request, ModelMap model) {

			pm = PersitenceManagerFactoryClass.get().getPersistenceManager();

			Query q = pm.newQuery(Folder.class);
			System.out.println(q);
			q.setFilter("folderName == nameParameter");
			q.declareParameters("String nameParameter");
			
			System.out.println(folderName);
			try {
				@SuppressWarnings("unchecked")
				List<Folder> results = (List<Folder>) q.execute(folderName);

				if (results.isEmpty()) {
					model.addAttribute("folderName", null);
				} else {
					model.addAttribute("folderName", results);
				}
			} 
			catch(Exception e)
			{
				ModelAndView model1=new ModelAndView();
				model1.addObject("errorMessage","Folder or file doesnot found");

			}
			finally {
				q.closeAll();
				pm.close();
			}

			return "searchresult.jsp";
		
		}
		
		@RequestMapping(value = "/searchfile", method = RequestMethod.GET)
		public String searchfile(@RequestParam("fileName") String fileName,
				HttpServletRequest request, ModelMap model) {

			pm = PersitenceManagerFactoryClass.get().getPersistenceManager();

			Query q = pm.newQuery(File.class);
			System.out.println(q);
			q.setFilter("fileName == nameParameter");
			q.declareParameters("String nameParameter");
			System.out.println(fileName);
			try {
				@SuppressWarnings("unchecked")
				List<File> results = (List<File>) q.execute(fileName);

				if (results.isEmpty()) {
					model.addAttribute("fileName", null);
				} else {
					model.addAttribute("fileName", results);
				}
			} 
			catch(Exception e)
			{
				ModelAndView model1=new ModelAndView();
				model1.addObject("errorMessage","Folder or file doesnot found");

			}
			finally {
				q.closeAll();
				pm.close();
			}

			return "searchresult.jsp";
		
		}
		
		@RequestMapping(value = "/deletefolder", method = RequestMethod.GET)
		public String deletefolder(HttpServletResponse resp,
				@RequestParam("folderName") String name,ModelMap model) throws IOException {
			pm = PersitenceManagerFactoryClass.get().getPersistenceManager();
			Query q = pm.newQuery(Folder.class);
			System.out.println(q);
			q.setFilter("folderName == name");
			q.declareParameters("String name");
			q.deletePersistentAll(name);
			try {
				
				@SuppressWarnings("unchecked")
				List<Folder> results = (List<Folder>) q.execute(name);
				Explorer explorer = pm.getObjectById(Explorer.class,"primaryExplorer");
				List<Drive> drive = explorer.getDrive();
				for(int i=0;i<drive.size();i++)
				{				System.out.println("2");

					System.out.println("enters for");
					Drive tempDrive=drive.get(i);
					
						System.out.println("enters if");
						List<Folder> folder= tempDrive.getFolder();
						for(int j=0;j<folder.size();j++)
						{
							Folder tempFolder=folder.get(j);
					if(tempFolder.getFolderName().equals(name))
					{
						tempDrive.folder.remove(name);
						
					}
				if (results.isEmpty()) {
					model.addAttribute("folderName", null);
				} else {
					model.addAttribute("folderName", results);
				}
			} }
				
				}
			catch(Exception e)
			{
				ModelAndView model1=new ModelAndView();
				model1.addObject("errorMessage","Folder or file doesnot found");

			}
			finally {
				q.closeAll();
				pm.close();
			}

			return "deleteresult.jsp";
		
		
		}
		
		@RequestMapping(value = "/deletefile", method = RequestMethod.GET)
		public String deletefile(HttpServletResponse resp,
				@RequestParam("fileName") String name,ModelMap model) throws IOException {
			pm = PersitenceManagerFactoryClass.get().getPersistenceManager();
			Query q = pm.newQuery(File.class);
			System.out.println(q);
			q.setFilter("fileName == name");
			q.declareParameters("String name");
			
			try {
				q.deletePersistentAll(name);
				@SuppressWarnings("unchecked")
				List<File> results = (List<File>) q.execute(name);
				Explorer explorer = pm.getObjectById(Explorer.class,"primaryExplorer");
				List<Drive> drive = explorer.getDrive();
				for(int i=0;i<drive.size();i++)
				{				System.out.println("2");

					System.out.println("enters for");
					Drive tempDrive=drive.get(i);
					
						System.out.println("enters if");
						List<Folder> folder= tempDrive.getFolder();
						for(int j=0;j<folder.size();j++)
						{
							Folder tempFolder=folder.get(j);
							List<File> file=tempDrive.getFile();
							for(int k=0;k<file.size();k++)
							{
								File tempFile=file.get(k);
							
							if(tempFile.getFileName().equals(name))
							{
							System.out.println("remove");	
							tempFolder.fileInsideFolder.remove(name);
							
							}
				if (results.isEmpty()) {
					model.addAttribute("fileName", null);
				} else {
					model.addAttribute("fileName", results);
				}
			} 
				}}
				
			}
			catch(Exception e)
			{
				ModelAndView model1=new ModelAndView();
				model1.addObject("errorMessage","Folder or file doesnot found");

			}
			finally {
				q.closeAll();
				pm.close();
			}

			return "deleteresult.jsp";
		}

		@RequestMapping(value = "/deletedrive", method = RequestMethod.GET)
		public String deletedrive(HttpServletResponse resp,
				@RequestParam("driveName") String name,ModelMap model) throws IOException {
			pm = PersitenceManagerFactoryClass.get().getPersistenceManager();
			Query q = pm.newQuery(Drive.class);
			System.out.println(q);
			q.setFilter("driveName == name");
			q.declareParameters("String name");
			
			try {
				
				@SuppressWarnings("unchecked")
				List<Drive> results = (List<Drive>) q.execute(name);
				Explorer explorer = pm.getObjectById(Explorer.class,"primaryExplorer");
				List<Drive> drive = explorer.getDrive();
				for(int i=0;i<drive.size();i++)
				{				System.out.println("2");

					System.out.println("enters for");
					Drive tempDrive=drive.get(i);
					if(tempDrive.getDriveName().equals(name))
					{
						q.deletePersistentAll(name);
						explorer.driveList.remove(name);	
					}
				if (results.isEmpty()) {
					model.addAttribute("driveName", null);
				} else {
					model.addAttribute("driveName", results);
				}
			} }
			catch(Exception e)
			{
				ModelAndView model1=new ModelAndView();
				model1.addObject("errorMessage","drive doesnot found");

			}
			finally {
				q.closeAll();
				pm.close();
			}

			return "deleteresult.jsp";
		}
		
		@RequestMapping(value = "/copyfolder", method = RequestMethod.GET)
		public String copyfolder(HttpServletResponse resp,@RequestParam("folderName") String folderName,@RequestParam("driveName") String driveName,ModelMap model) throws IOException {
			
		
			pm = PersitenceManagerFactoryClass.get().getPersistenceManager();
			try{
				Explorer explorer = pm.getObjectById(Explorer.class,"primaryExplorer");
				List<Drive> drive = explorer.getDrive();
				for(int i=0;i<drive.size();i++)
				{				System.out.println("2");

					System.out.println("enters for");
					Drive tempDrive=drive.get(i);
					if(tempDrive.getDriveName().equals(driveName))
					{
						System.out.println("enters if");
						List<Folder> folder= tempDrive.getFolder();
						for(int j=0;j<folder.size();j++)
						{
							Folder tempFolder=folder.get(j);
					if(tempFolder.getFolderName().equals(folderName))
					{
						Folder fol=new Folder();
						fol.setFolderName(tempFolder.getFolderName());
						fol.setFolderType(tempFolder.getFolderType());
						fol.setFolderLocation(tempFolder.belongsToDrive,tempFolder.folderName);
						fol.folderContains=tempFolder.fileInsideFolder.size();
						fol.setDate(tempFolder.getDateAndTime());
						if(tempDrive.getDriveName().equals(driveName))
						{
							tempDrive.addFolder(fol);
						}
					}
					}
				}
			}}catch(Exception e)
			{
				ModelAndView model1=new ModelAndView();
				model1.addObject("errorMessage","drive doesnot found");

			}
			finally {
				
				pm.close();
			}

			return "copyresult.jsp";
		}
		
		@RequestMapping(value = "/copyfile", method = RequestMethod.GET)
		public String copyfile(HttpServletResponse resp,@RequestParam("fileName") String fileName,@RequestParam("folderName") String folderName,@RequestParam("driveName") String driveName,ModelMap model) throws IOException {
			
		
			pm = PersitenceManagerFactoryClass.get().getPersistenceManager();
			try{
				Explorer explorer = pm.getObjectById(Explorer.class,"primaryExplorer");
				List<Drive> drive = explorer.getDrive();
				for(int i=0;i<drive.size();i++)
				{				System.out.println("2");

					System.out.println("enters for");
					Drive tempDrive=drive.get(i);
					if(tempDrive.getDriveName().equals(driveName))
					{
						System.out.println("enters if");
						List<Folder> folder= tempDrive.getFolder();
						for(int j=0;j<folder.size();j++)
						{
							Folder tempFolder=folder.get(j);
							if(tempFolder.getFolderName().equals(folderName))
							{
							List<File> file=tempFolder.getFile1();
							for(int k=0;k<file.size();k++)
							{
								File tempFile=file.get(k);
							
					if(tempFile.getFileName().equals(fileName))
					{
						File fil=new File();
						fil.setFileName(tempFile.getFileName());
						fil.setFileType(tempFile.getFileType());
						fil.setFileLocation(tempFile.belongsToDrive,tempFile.belongsToFolder,tempFile.fileName);
						fil.fileSize=tempFile.fileSize;
						fil.setDate(tempFile.getDate());
						if(tempFolder.getFolderName().equals(folderName))
						{
							tempFolder.addFile(fil);
						}
					}
					}
				}}
			}}}catch(Exception e)
			{
				ModelAndView model1=new ModelAndView();
				model1.addObject("errorMessage","drive doesnot found");

			}
			finally {
				
				pm.close();
			}

			return "copyresult.jsp";
		}

	@RequestMapping(value = "/createdrive")
	public ModelAndView createdrive(){
		ModelAndView model = new ModelAndView("CreateDrive.jsp");
		return model;
	}
	@RequestMapping(value = "/createfolder")
	public ModelAndView createfolder(){
		ModelAndView model = new ModelAndView("CreateFolder.jsp");
		return model;
	}
	@RequestMapping(value = "/createfile")
	public ModelAndView createfile(){
		ModelAndView model = new ModelAndView("CreateFile.jsp");
		return model;
	}
	
	
	@RequestMapping(value = "/search")
	public ModelAndView search(){
		ModelAndView model = new ModelAndView("search.jsp");
		return model;
	}
	@RequestMapping(value = "/delete")
	public ModelAndView delete(){
		ModelAndView model = new ModelAndView("delete.jsp");
		return model;
	}
	@RequestMapping(value = "/copy")
	public ModelAndView copy(){
		ModelAndView model = new ModelAndView("copy.jsp");
		return model;
	}
				
		}
			