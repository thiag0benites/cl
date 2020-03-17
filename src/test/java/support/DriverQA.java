package support;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverQA {

	private static WebDriver driver;
	private static Scenario cenario;

	public DriverQA(Scenario cenario) {
		DriverQA.cenario = cenario;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void start(String parBrowser) {
		String title = "";
		try {
			title = driver.getTitle();
		} catch (Exception e) {
			title = "ERROR";
		}
		if (title == "ERROR") {
			switch (parBrowser) {
			case "firefox":

				// WebDriverManager.firefoxdriver().setup();
				FirefoxOptions options = new FirefoxOptions();
				options.addPreference(FirefoxDriver.MARIONETTE, true);
//                    options.addArguments("--headless");
				driver = new FirefoxDriver(options);
//                    driver.manage().window().setPosition(new Point(-2000, 0));
				driver.manage().window().setPosition(new Point(0, 0));
				driver.manage().window().setSize(new Dimension(1366, 768));
//                    driver.manage().window().maximize();

				break;

			case "chrome":
				// System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
				// + "\\drivers\\chromedriver.exe");
				WebDriverManager.chromedriver().setup();
				ChromeOptions optionsC = new ChromeOptions();
				// hides the info message that says chrome is being controlled by automated test
				// software
				optionsC.addArguments(Arrays.asList("disable-infobars", "ignore-certificate-errors",
						"disable-popup-blocking", "disable-notifications", "no-sandbox"));
//                    "disable-infobars", "ignore-certificate-errors", "start-maximized","disable-popup-blocking","incognito","headless"));
				driver = new ChromeDriver(optionsC);
				driver.manage().window().maximize();
//                    driver.manage().window().setPosition(new Point(0, 0));
//                    driver.manage().window().setSize(new Dimension(1366, 768));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				break;
			default:
				break;

			}
		}
	}

	private String getAttributeType(String... parType) {
		String type;
		if (parType.length == 0) {
			type = "id";
		} else {
			type = parType[0];
		}
		return type;
	}

	private WebElement findElem(String parValue, String... parType) {
		String param2 = getAttributeType(parType);
		WebElement element = null;

		try {
			switch (param2) {
			case "id":
				element = driver.findElement(By.id(parValue));
				break;
			case "name":
				element = driver.findElement(By.name(parValue));
				break;
			case "css":
				element = driver.findElement(By.cssSelector(parValue));
				break;
			case "xpath":
				element = driver.findElement(By.xpath(parValue));
				break;
			case "link":
				element = driver.findElement(By.linkText(parValue));
				break;
			case "partialLink":
				element = driver.findElement(By.partialLinkText(parValue));
			case "class":
				element = driver.findElement(By.className(parValue));
			}
		} catch (NoSuchElementException e) {
			element = null;
		}
		return element;
	}

	private List<WebElement> findElements(String parValue, String... parType) {
		String param2 = getAttributeType(parType);
		List<WebElement> element = null;

		try {
			switch (param2) {
			case "id":
				element = driver.findElements(By.id(parValue));
				break;
			case "name":
				element = driver.findElements(By.name(parValue));
				break;
			case "css":
				element = driver.findElements(By.cssSelector(parValue));
				break;
			case "xpath":
				element = driver.findElements(By.xpath(parValue));
				break;
			case "link":
				element = driver.findElements(By.linkText(parValue));
				break;
			case "partialLink":
				element = driver.findElements(By.partialLinkText(parValue));
			case "class":
				element = driver.findElements(By.className(parValue));
			}
		} catch (NoSuchElementException e) {
			element = null;
		}
		return element;
	}

	public List<WebElement> encontrarListaElemento(String parValue, String... parType) {
		List<WebElement> element = findElements(parValue, parType);
		return element;
	}

	public void click(String parValue, String... parType) {
		try {
			WebElement element = findElem(parValue, parType);
			element.click();
		} catch (Exception e) {
			escreveRelatorio(cenario, false, "Não foi possível efetuar o click em " + parValue, true);
		}
	}

	public void enter(String parValue, String... parType) {
		try {
			WebElement element = findElem(parValue, parType);
			element.submit();
		} catch (Exception e) {
			escreveRelatorio(cenario, false, "Não foi possível enviar o enter em " + parValue, true);
		}
	}

	public boolean selectected(String parValue, String... parType) {
		try {
			WebElement element = findElem(parValue, parType);
			return element.isSelected();
		} catch (Exception e) {
			escreveRelatorio(cenario, false, "Não foi possível verificar seleção do elemento " + parValue, true);
			return false;
		}
	}

	public void clear(String parValue, String... parType) {
		try {
			WebElement element = findElem(parValue, parType);
			element.clear();
		} catch (Exception e) {
			escreveRelatorio(cenario, false, "Não foi possível limpar campo " + parValue, true);
		}
	}

	public void openURL(String parUrl) {
		try {
			driver.get(parUrl);
		} catch (Exception e) {
			escreveRelatorio(cenario, false, "Erro ao acessar a url " + parUrl, true);
		}
	}

	public void quit() {
		try {
			driver.quit();
		} catch (Exception e) {
			escreveRelatorio(cenario, false, "Erro ao finalizar o browser", false);
		}
	}

	public void close() {
		try {
			driver.close();			
		} catch (Exception e) {
			escreveRelatorio(cenario, false, "Erro ao fechar o browser", false);
		}
	}

	public void refresh() {
		try {
			driver.navigate().refresh();
		} catch (Exception e) {
			escreveRelatorio(cenario, false, "Erro ao atualizar o browser", false);
		}
	}

	public boolean isEnabled(String parValue, String... parType) {
		try {
			WebElement element = findElem(parValue, parType);
			return element.isEnabled();
		} catch (Exception e) {
			escreveRelatorio(cenario, false, "Não foi possível obter estado do elemento " + parValue, true);
			return false;
		}

	}

	public boolean isDisplayed(String parValue, String... parType) {
		try {
			WebElement element = findElem(parValue, parType);
			return element.isDisplayed();
		} catch (Exception e) {
			escreveRelatorio(cenario, false, "Não foi possível verificar a visibilidade do elemento " + parValue, true);
			return false;
		}
	}

	public void sendKeys(String parText, String parName, String... parType) {
		try {
			WebElement element = findElem(parName, parType);
			// element.clear();
			element.sendKeys(parText);
		} catch (Exception e) {
			escreveRelatorio(cenario, false, "Não foi possível preencher o campo " + parName + "\nValor: " + parText, true);
		}
	}

	public String getText(String parValue, String... parType) {

		try {
			WebElement element = findElem(parValue, parType);
			return element.getText();
		} catch (Exception e) {
			escreveRelatorio(cenario, false, "Não foi possível o texto do elemento " + parValue, true);
			return null;
		}
	}

	public String getValue(String parValue, String... parType) {
		try {
			WebElement element = findElem(parValue, parType);
			return element.getAttribute("value");
		} catch (Exception e) {
			escreveRelatorio(cenario, false, "Não foi possível obter o atributo value do elemento " + parValue, true);
			return null;
		}
	}

	public String getValueParam(String parValue, String campoDesejado, String... parType) {
		try {
			WebElement element = findElem(parValue, parType);
			return element.getAttribute(campoDesejado);
		} catch (Exception e) {
			escreveRelatorio(cenario, false, "Não foi possível obter o valor do parametro do elemento " + parValue,
					true);
			return null;
		}
	}

	public void selectByIndex(Integer parIndex, String parName, String... parType) {
		try {
			WebElement element = findElem(parName, parType);
			Select dropdown = new Select(element);
			dropdown.selectByIndex(parIndex);
		} catch (Exception e) {
			escreveRelatorio(cenario, false, "Não foi possível selecionar item " + parIndex + " no combobox " + parName,
					true);
		}
	}

	public void selectByText(String parText, String parName, String... parType) {
		try {
			WebElement element = findElem(parName, parType);
			Select dropdown = new Select(element);
			dropdown.selectByVisibleText(parText);
		} catch (Exception e) {
			escreveRelatorio(cenario, false, "Não foi possível selecionar item " + parText + " no combobox " + parName,
					true);
		}
	}

	public String getCurrentURL() {
		try {
			return driver.getCurrentUrl();
		} catch (Exception e) {
			escreveRelatorio(cenario, false, "Não foi possível obter url", true);
			return null;
		}
	}

	public String getTitle() {
		try {
			return driver.getTitle();
		} catch (Exception e) {
			escreveRelatorio(cenario, false, "Não foi possível obter título", true);
			return null;
		}
	}

	public void waitSeconds(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public void waitElementAll(String parName, String... parType) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		String param2 = getAttributeType(parType);
		try {
			switch (param2) {
			case "id":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(parName)));
				break;
			case "name":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(parName)));
				break;
			case "css":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(parName)));
				break;
			case "xpath":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(parName)));
				break;
			case "link":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(parName)));
				break;

			case "class":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(parName)));
				break;
			}
		} catch (NoSuchElementException e) {
			System.out.println("ERROR WAIT => " + e.toString());
			escreveRelatorio(cenario, false, "Erro ao aguardar o elemento " + parName, true);
		}
	}

	public void waitElement(String parId) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);

			if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(parId))) == null) {
				escreveRelatorio(cenario, false, "Falha ao aguardar o elemento " + parId, true);
			}
		} catch (Exception e) {
			escreveRelatorio(cenario, false, "Erro ao aguardar o elemento " + parId, true);
		}

	}

	public void waitElementMotherId(String parId) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			
			if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(parId))) == null) {
				escreveRelatorio(cenario, false, "waitElementMotherId falha ao aguardar o elemento " + parId, true);
			}
			
		} catch (Exception e) {
			escreveRelatorio(cenario, false, "waitElementMotherId erro ao aguardar o elemento " + parId, true);
		}
	}

	public void waitElementCSS(String parCss) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			
			if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(parCss))) == null) {
				escreveRelatorio(cenario, false, "waitElementMotherId falha ao aguardar o elemento " + parCss, true);
			}
			
			driver.getWindowHandles();
		} catch (Exception e) {
			escreveRelatorio(cenario, false, "waitElementMotherId erro ao aguardar o elemento " + parCss, true);
		}
	}

	public void waitElementXP(String parXp) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			
			if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(parXp))) == null) {
				escreveRelatorio(cenario, false, "waitElementXP falha ao aguardar o elemento " + parXp, true);
			}
		} catch (Exception e) {
			escreveRelatorio(cenario, false, "waitElementXP erro ao aguardar o elemento " + parXp, true);
		}
	}

	public void waitElementTobeClickable(String parId) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			
			if(wait.until(ExpectedConditions.elementToBeClickable(By.id(parId))) == null) {
				escreveRelatorio(cenario, false, "waitElementTobeClickable falha ao aguardar o elemento " + parId, true);
			}
		} catch (Exception e) {
			escreveRelatorio(cenario, false, "waitElementTobeClickable erro ao aguardar o elemento " + parId, true);
		}
	}

	public void waitElementCSSTobeClickable(String parCss) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			
			if(wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(parCss))) == null) {
				escreveRelatorio(cenario, false, "waitElementCSSTobeClickable falha ao aguardar o elemento " + parCss, true);
			}
		} catch (Exception e) {
			escreveRelatorio(cenario, false, "waitElementCSSTobeClickable erro ao aguardar o elemento " + parCss, true);
		}
	}

	public void waitElementXPTobeClickable(String parXp) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			
			if(wait.until(ExpectedConditions.elementToBeClickable(By.xpath(parXp))) == null) {
				escreveRelatorio(cenario, false, "waitElementXPTobeClickable falha ao aguardar o elemento " + parXp, true);
			}
		} catch (Exception e) {
			escreveRelatorio(cenario, false, "waitElementXPTobeClickable falha ao aguardar o elemento " + parXp, true);
		}
	}

	public void waitElementNotVisible(String parId) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
						
			if(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(parId))) == false) {
				escreveRelatorio(cenario, false, "Elemento " + parId + " visível", true);
			}
			
			driver.getWindowHandles();
		} catch (Exception e) {
			escreveRelatorio(cenario, false, "waitElementNotVisible erro na validação", true);
		}

	}

	public void waitElementNotVisibleCSS(String parCss) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			
			if(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(parCss))) == false) {
				escreveRelatorio(cenario, false, "Elemento " + parCss + " visível", true);
			}
			
			driver.getWindowHandles();
		} catch (Exception e) {
			escreveRelatorio(cenario, false, "waitElementNotVisibleCSS erro na validação", true);
		}
	}

	public void waitElementNotVisibleXP(String parXp) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			
			if(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(parXp))) == false) {
				escreveRelatorio(cenario, false, "Elemento " + parXp + " visível", true);
			}
		} catch (Exception e) {
			escreveRelatorio(cenario, false, "waitElementNotVisibleXP erro na validação", true);
		}
	}

	public void switchTo(String... parValue) {
		try {
			if (parValue.length == 0) {
				driver.switchTo().defaultContent();
			} else {
				driver.switchTo().window(String.valueOf(parValue));
			}
		} catch (Exception e) {
			escreveRelatorio(cenario, false, "Não foi possível mudar de janela", true);
		}
	}

	public void switchToFrameId(String parId) {
		try {
			driver.switchTo().frame(driver.findElement(By.id(parId)));
		} catch (Exception e) {
			escreveRelatorio(cenario, false, "Não foi possível mudar para o frame " + parId, true);
		}
	}

	public void switchToDefaultContent() {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			escreveRelatorio(cenario, false, "Não foi possível mudar para container principal", true);
		}
	}

	public void waitForJQuery() {
		(new WebDriverWait(driver, 7)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				JavascriptExecutor js = (JavascriptExecutor) d;
				return (Boolean) js.executeScript("return !!window.jQuery && window.jQuery.active == 0");
			}
		});
	}

//	public String captureScreen(String paths) {
//		String path;
//		try {
//			WebDriver augmentedDriver = new Augmenter().augment(driver);
//			File source = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
//			path = paths + source.getName();
//			FileUtils.copyFile(source, new File(path));
//		} catch (IOException e) {
//			path = "Failed to capture screenshot: " + e.getMessage();
//		}
//		return path;
//	}

	public void ChooseOkOnNextConfirmation() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (Exception e) {
			escreveRelatorio(cenario, false, "Não foi possível clicar em Ok", true);
		}
	}

	public void ChooseCancelOnNextConfirmation() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (Exception e) {
			escreveRelatorio(cenario, false, "Não foi possível clicar em cancelar", true);
		}
	}

	public void sendKeysTab(String texto, String parValue, String... parType) {
		try {
			WebElement element = findElem(parValue, parType);
			element.sendKeys(texto, Keys.TAB);
		} catch (Exception e) {
			escreveRelatorio(cenario, false, "Não foi possível enviar tecla TAB", true);
		}
	}

	public void mudarAba(String numeroAba) {
		try {
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(Integer.parseInt(numeroAba)));
		} catch (Exception e) {
			escreveRelatorio(cenario, false, "Não foi possível mudar aba do browser", true);
		}
	}

	public void escreveRelatorio(Scenario cenario, boolean status, String msg, boolean printScreen) {

		cenario.write(msg);

		if (printScreen) {
			cenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
		}

		if (status == false) {
			Assert.fail(msg);
		}

	}
}
