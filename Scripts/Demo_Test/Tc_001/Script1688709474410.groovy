      import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

System.setProperty('webdriver.chrome.driver', 'C:\\Users\\naveensivamani\\Katalon Studio\\Practice\\Include\\config\\chromedriver.exe')

WebDriver driver = new ChromeDriver()

DriverFactory.changeWebDriver(driver)

WebUI.navigateToUrl(GlobalVariable.URL)            

WebUI.maximizeWindow()

WebUI.click(findTestObject('Repo (tc 1,2)/Product'))

WebUI.scrollToElement(findTestObject('Repo (tc 1,2)/page_no-6'), 0)

WebUI.click(findTestObject('Repo (tc 1,2)/page_no-6'))

for (def x : (1..10)) {
    WebElement productSelect = driver.findElement(By.xpath(('(//h3//a)[' + x) + ']'))

    productSelect.click()

    WebUI.delay(3)

    String text = driver.findElement(By.xpath('//div[@class=\'product_related_info mt-5\']')).getText().substring(3)

    System.out.println(text)

    //    String toastermessage = text.replaceAll('[^A-Za-z]', '')
    //    System.out.println(Productavailability)
    if (text == ') items available in stock') {
        WebUI.delay(2)

        WebUI.click(findTestObject('Object Repository/Repo (tc 1,2)/Colour_Selection'))

        //	WebUI.scrollToElement(findTestObject('Object Repository/Repo (tc 1,2)/Add_to_cart'), 0)
        WebUI.click(findTestObject('Object Repository/Repo (tc 1,2)/Add_to_cart'))

        //	WebUI.verifyTextPresent("item added to cart", false)
        WebUI.delay(2)

        WebUI.back()
    } else if (text == 'em is not available in stock)') {
        WebUI.delay(2)

        WebUI.back()
    }
}

WebUI.closeBrowser()