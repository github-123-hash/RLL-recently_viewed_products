package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import stepDefintion.SharedSteps;

public class ScreenshotUtilities{

	ReadDataProperties readDataProperties; 
	
	public String takeScreenshot() throws IOException {
		readDataProperties=new ReadDataProperties();
		//convert web driver object to takes-creenshot
		TakesScreenshot ts=(TakesScreenshot)SharedSteps.driver;
		//call getScreenshotsAs method to create image file
		File source=ts.getScreenshotAs(OutputType.FILE);
		//copy file at destination
		String path=readDataProperties.getData("screenshot.path")+System.currentTimeMillis()+".png";
		File target=new File(path);
		FileUtils.copyFile(source, target);
		String targetPath=target.getAbsolutePath();
		
		return targetPath;
		
		
		
	}
}