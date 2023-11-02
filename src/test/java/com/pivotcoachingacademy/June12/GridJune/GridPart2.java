package com.pivotcoachingacademy.June12.GridJune;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GridPart2 {

	public ThreadLocal<WebDriver> wd = new ThreadLocal<>();

	@BeforeMethod
	public void setUp() throws MalformedURLException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		options.setHeadless(true);
		wd.set(new RemoteWebDriver(new URL("http://192.168.99.1:5050/"), options));
		
	}

	@Test
	public void chromeTest() throws MalformedURLException {
		System.out.println("Chrome :"+wd.get().toString());
		wd.get().get("https://www.selenium.dev/documentation/grid/getting_started/");
		System.out.println("Chrome title: " + wd.get().getTitle());
		sleep();

	}

	@Test
	public void edgeTest() throws MalformedURLException {
		System.out.println("Edge :"+wd.get().toString());
		wd.get().get("https://app.pluralsight.com/id");
		System.out.println("Edge title: " + wd.get().getTitle());
		sleep();

	}

	@Test
	public void fireFoxTest() throws MalformedURLException {
		System.out.println("Firefox :"+wd.get().toString());
		wd.get().get("https://www.udemy.com/");
		System.out.println("Firefox title: " + wd.get().getTitle());
		sleep();

	}

	@AfterMethod
	public void tearDown() {
		System.out.println("Quitting Web driver for " + wd.get().toString());
		wd.get().quit();
	}

	public void sleep() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
