import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

//WebUI.openBrowser('')
System.setProperty('webdriver.chrome.driver', 'C:\\Users\\naveensivamani\\Katalon Studio\\Practice\\Include\\config\\chromedriver.exe')

WebDriver driver = new ChromeDriver()

//driver.get("www.softtronics.in")
DriverFactory.changeWebDriver(driver)

WebUI.navigateToUrl(GlobalVariable.URL)

WebUI.maximizeWindow()

WebUI.click(findTestObject('Repo (tc 1,2)/Product'))

List<WebElement> productsize = driver.findElements(By.xpath('//h3[@class=\'product-tit+le\']'))

print(productsize.size())

for (def x : (1..productsize.size())) {
    String productName = driver.findElement(By.xpath(('(//h3[@class=\'product-title\'])[' + x) + ']')).getText()

    System.out.println(productName)
}

WebUI.closeBrowser()