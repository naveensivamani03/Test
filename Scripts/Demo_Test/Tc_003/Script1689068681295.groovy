import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword as WebUIAbstractKeyword
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('')

//System.setProperty('webdriver.chrome.driver', 'C:\\Users\\naveensivamani\\Katalon Studio\\Practice\\Include\\config\\chromedriver.exe')
//
//WebDriver driver =new ChromeDriver()
//
//DriverFactory.changeWebDriver(driver)
WebUI.navigateToUrl(GlobalVariable.URL)
WebUI.maximizeWindow()

WebUI.click(findTestObject('Repo (tc 1,2)/Product'))

// test to redirect to home page
//WebUI.mouseOver(findTestObject('Object Repository/Repo Tc(3)/Home redirect'))
//WebUI.delay(20)
//WebUI.rightClick(findTestObject('Object Repository/Repo Tc(3)/Home redirect'))
//
//Robot robot = new Robot();
//robot.keyPress(KeyEvent.VK_DOWN)
//robot.keyRelease(KeyEvent.VK_DOWN)
//robot.keyPress(KeyEvent.VK_ENTER)
//WebUI.delay(20)
WebUI.click(findTestObject('Object Repository/Repo (tc 1,2)/page_no-6'))

String productname = WebUI.getText(findTestObject('Object Repository/Repo Tc(3)/Product name tc_3')).substring(0, 20)

String productRename = productname.toUpperCase()

print(productRename)

WebUI.click(findTestObject('Object Repository/Repo Tc(3)/Product name tc_3'))

WebUI.click(findTestObject('Object Repository/Repo Tc(3)/Product colour'))

WebUI.mouseOver(findTestObject('Object Repository/Repo Tc(3)/Wishlist'))

WebUI.click(findTestObject('Object Repository/Repo Tc(3)/Wishlist'))

WebUI.click(findTestObject('Object Repository/Repo Tc(3)/Wishlist icon'))

String productnameWishlist = WebUI.getText(findTestObject('Object Repository/Repo Tc(3)/Product name verify in wishlist')).substring(0, 20)

print(productnameWishlist)

WebUI.verifyMatch(productRename, productnameWishlist, true)

WebUI.closeBrowser()