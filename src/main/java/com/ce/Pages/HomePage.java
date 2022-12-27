package com.ce.Pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public String CourseTxt  = "web development";
	public String Course1    = "Meta Front-End Developer Professional Certificate | Coursera";
	public String Course2    = "IBM Full Stack Software Developer Professional Certificate | Coursera";
	public String rating1    = "4.7/5";
	public String rating2    = "4.5/5";
	public String Months1    = "7 Months";
	public String Months2    = "14 Months";
	public String Leveltxt   = "Beginner";
	public String LngTxt     = "English";

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//SearchBox on Homepage
	@FindBy(xpath = "(//input[@type='text'])[1]") private WebElement SearchBox;
	public WebElement getSearchBox() {
		return SearchBox;	
	}

	//Number of results
	@FindBy(xpath = "//div[@data-e2e='NumberOfResultsSection']") WebElement results;
	public WebElement getresults() {
		return results;	
	}

	@FindBy(how=How.XPATH, using="//div[@class='css-ilhc4l']/div[2]/p") List<WebElement> begtext;
	public List<WebElement> getBegineerText() {
		return begtext;
	}

	//Click on second page
	@FindBy(xpath = "//button[@id='pagination_number_box_2']/span") WebElement secondPage;
	public WebElement getSecondPage() {
		return secondPage;	
	}


	//Checkbox of Beginner in Level section
	@FindBy(xpath = "//span[text()='Beginner']") WebElement Level;
	public WebElement getLevel() {
		return Level;
	}

	//Click on First page
	@FindBy(xpath = "//button[@id='pagination_number_box_1']") WebElement FirstPage;
	public WebElement getFirstPage() {
		return FirstPage;	
	}

	//Number of results
	@FindBy(xpath = "//div[@data-testid='active-filter-items']") WebElement LevelTxt;
	public WebElement getLevelTxt() {
		return LevelTxt;	
	}

	//Show More of Language Section
	@FindBy(xpath = "//button[@aria-label='Show more Language options']") WebElement Language;
	public WebElement getLanguage() {
		return Language;
	}

	//Select English language
	@FindBy(xpath = "//span[text()='English']") WebElement SelectLanguage;
	public WebElement getSelectEnglish() {
		return SelectLanguage;
	}

	//Select Apply Button
	@FindBy(xpath = "//span[text()='Apply']") WebElement ApplyButton;
	public WebElement getSelectApplyButton() {
		return ApplyButton;
	}

	//Select Apply Button
	@FindBy(xpath = "//div[@data-testid='active-filter-items']") WebElement LanguageText;
	public WebElement getLanguageText() {
		return LanguageText;
	}

	//First Course 
	@FindBy(xpath = "(//div[@class='css-1pa69gt'])[1]") WebElement FirstCourse;
	public WebElement getFirstCourse() {
		return FirstCourse;
	}

	public void UserWindowHandle(WebDriver driver)
	{
		String parentHandle = driver.getWindowHandle();
		Set<String> allhandles = driver.getWindowHandles();
		for(String handle:allhandles) {
			if (!parentHandle.equals(handle)) 
			{
				driver.switchTo().window(handle);
			}
		}
	}

	//Course Name
	@FindBy(xpath = "//h1[@class='cds-33 css-1shw822 cds-35']") WebElement CourseName;
	public WebElement getCourseName() {
		return CourseName;
	}

	//Course rating
	@FindBy(xpath = "//p[@class='cds-33 css-bku0rr cds-35']") WebElement FirstCourseRating;
	public WebElement getCourseRating() {
		return FirstCourseRating;
	}

	//Course Months
	@FindBy(xpath = "(//p[@class='cds-33 css-bku0rr cds-35'])[2]") WebElement Months;
	public WebElement getCourseMonths() {
		return Months;
	}

	//Course Hourse per week
	@FindBy(xpath = "(//p[@class='cds-33 css-14d8ngk cds-35'])[2]") WebElement HoursePerWeek;
	public WebElement getCourseHoursePerWeek() {
		return HoursePerWeek;
	}

	public void parentWindowHandle(WebDriver driver)
	{
		String seconhandle = driver.getWindowHandle();
		Set<String> allhandles = driver.getWindowHandles();
		for(String handle:allhandles) {
			if (!seconhandle.equals(handle)) 
			{
				driver.switchTo().window(handle);
			}
		}

	}
	//Second Course 
	@FindBy(xpath = "(//div[@class='css-1pa69gt'])[2]") WebElement SecondCourse;
	public WebElement getSecondCourse() {
		return SecondCourse;
	}

}

