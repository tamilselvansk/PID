package com.ivymobility.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GRN_Page {

	public static WebDriver driver;
	public Logger APP_LOGS = Logger.getLogger("devpinoyLogger");
	@FindBy(xpath = "//a[@title='GRN Management']")
	WebElement GRNManagement;
	@FindBy(xpath = "//a[@title='GRN Create']")
	WebElement GRNCreate;
	@FindBy(id = "iContent")
	WebElement frame;
	@FindBy(id = "GH_POH_No")
	WebElement PONumber;
	@FindBy(xpath = "//div[@id='grnHeader']/div/div/div[5]/div/a")
	WebElement WarehouseDropdown;
	@FindBy(xpath = "//div[@id='grnHeader']/div/div/div[5]/div/ul/li")
	List<WebElement> WarehouseSelection;
	@FindBy(id = "SKUSearch")
	WebElement SKUSearch;
	@FindBy(xpath = "//ul[@id='ui-id-1']/li/a/span")
	WebElement SKUSelection;
	@FindBy(xpath = "//span[contains(text(),'Case : ')]/following::input[1][@class='grid-input text-right']")
	WebElement GRNCase;
	@FindBy(xpath = "//span[contains(text(),'Piece : ')]/following::input[1][@class='grid-input text-right']")
	WebElement GRNPiece;
	@FindBy(id = "SubmitGRN")
	WebElement SubmitGRN;

	public GRN_Page(WebDriver driver) {

		this.driver = driver;

	}

	public void GRN_Creation_Page(String PO, String Warehouse, String SKU, String CaseQty, String PieceQty)
			throws InterruptedException {

		Thread.sleep(1000);
		GRNManagement.click();
		APP_LOGS.info("GRNManagement clicked successfully");
		GRNCreate.click();
		APP_LOGS.info("GRNCreate clicked successfully");
		driver.switchTo().frame(frame);
		APP_LOGS.info("Switched frame successfully");
		PONumber.sendKeys(PO);
		APP_LOGS.info("PO number entered successfully");
		Thread.sleep(1000);
		WarehouseDropdown.click();

		APP_LOGS.info("Warehouse Clicked successfully");
		Thread.sleep(1000);
		for (WebElement wh : WarehouseSelection) {
			if (wh.getText().equals(Warehouse)) {
				wh.click();
				APP_LOGS.info(Warehouse + " selected successfully");

				Thread.sleep(1000);
				SKUSearch.click();
				Thread.sleep(1000);
				SKUSearch.sendKeys(SKU);
				SKUSelection.click();
				Thread.sleep(1000);
				GRNCase.click();
				GRNCase.sendKeys(CaseQty);
				Thread.sleep(1000);
				GRNCase.sendKeys(Keys.TAB);
				GRNPiece.click();
				GRNPiece.sendKeys(PieceQty);
				GRNPiece.sendKeys(Keys.TAB);
				SubmitGRN.click();

			}

		}
	}
}
