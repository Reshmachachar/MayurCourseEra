package com.ce.TestCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ce.Pages.HomePage;
import com.ce.commosActions.BaseTest;

public class CourseEraTest extends BaseTest{
	WebDriver driver;
	String parentHandle;

	public CourseEraTest() throws IOException {
		driver = initiliseDriver();
	}

	@Test
	public void CourseEra() throws IOException, InterruptedException
	{

		driver.get(pro.getProperty("baseurl"));
		HomePage homepage = new HomePage(driver);

		//Search course name-web development
		homepage.getSearchBox().sendKeys(pro.getProperty("courseName"), Keys.ENTER);
		String actual = homepage.getresults().getText();
		assertTrue(actual.contains(homepage.CourseTxt));

		//Select Level- Beginner
		homepage.getLevel().click();
		List<WebElement> begTxt = homepage.getBegineerText();
		WebElement secondPage = homepage.getSecondPage();

		//assertion of Beginner text on first 2 pages:
		for(int j=0;j<=1;j++)
		{
			for(int i=0;i<begTxt.size();i++)
			{
				String txt = begTxt.get(i).getText();
				assertTrue(txt.contains("Beginner"));
				System.out.println(txt.contains("Beginner"));
				//Thread.sleep(5000);
				//secondPage.click();
			}
			try 
			{
				secondPage.click();	
			}
			catch (StaleElementReferenceException  e) 
			{
				System.out.println(e);
				break;
			}
		}
		homepage.getFirstPage().click();

		//Select Language-English
		homepage.getLanguage().click();
		homepage.getSelectEnglish().click();
		homepage.getSelectApplyButton().click();
		String LngText = homepage.getLanguageText().getText();
		assertTrue(LngText.contains(homepage.LngTxt));

		//Click on first course
		homepage.getFirstCourse().click();

		//Course window handling
		homepage.UserWindowHandle(driver);
		assertEquals(driver.getTitle(), homepage.Course1);

		//Get First Course information: 
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(homepage.getCourseName()));
		System.out.println("Title of first course is: "+homepage.getCourseName().getText());
		System.out.println("Rating: "+homepage.getCourseRating().getText());
		String ratingTxt1 = homepage.getCourseRating().getText();
		//assertTrue(ratingTxt1.contains(homepage.rating1));
		System.out.println("Time Duration: "+homepage.getCourseMonths().getText()+"("+homepage.getCourseHoursePerWeek().getText()+")");
		System.out.println("---------------------------------------------------------------------------------------");
		String MonthTxt1 = homepage.getCourseMonths().getText();
		//assertTrue(MonthTxt1.contains(homepage.Months1));

		//Switch back to parent window
//		homepage.parentWindowHandle(driver);
//
//		//Click on second course
//		homepage.getSecondCourse().click();	
//		homepage.UserWindowHandle(driver);
//		assertEquals(driver.getTitle(), homepage.Course2);
//
//		//Get Second Course information: 
//		System.out.println("Title of Second course is: "+homepage.getCourseName().getText());
//		System.out.println("Rating: "+homepage.getCourseRating().getText());
//		String ratingTxt2 = homepage.getCourseRating().getText();
//		assertTrue(ratingTxt2.contains(homepage.rating2));
//		System.out.println("Time Duration: "+homepage.getCourseMonths().getText()+"("+homepage.getCourseHoursePerWeek().getText()+")");
//		String MonthTxt2 = homepage.getCourseMonths().getText();
//		assertTrue(MonthTxt2.contains(homepage.Months2));
//		System.out.println("---------------------------------------------------------------------------------------");
		//driver.quit();
	}


}
