package org.etiya;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Main {
    public static void main(String[] args) throws InterruptedException {

        WebDriver webDriver = new ChromeDriver();

        /*Kullanıcının bir websitesinde kullanıcı girişi yaparak gezinmesi adımları üzerinden selenium fonksiyonlarının incelenmesi*/

        // 1- navigate().to Kullanıcıyı tarayıcıya girilen URL'e yönlendirmek için kullanılır.
        webDriver.navigate().to("https://www.saucedemo.com/v1/");

        // 2- findElement() web sayfası üzerindeki bir webElement'i bulmak için kullanılır. Çeşitli locator türleri sunar.
        // Element özelindeki işleme bağlı olarak uygun locator ile çalıştırılır. Burada elemetin id değeri bilindiği için, By.id() locator'ı kullanılmıştır.
        WebElement usernameInput = webDriver.findElement(By.id("user-name"));

        // 3- sendKeys() bir webElement'e input girişi yapmak için kullanılır.
        usernameInput.sendKeys("problem_user");

        // 4- Thread.sleep() programın iş parçacığını (thread) belirtilen süre kadar bekletir ve sonra çalışmasını devam ettirir.
        Thread.sleep(1000);

        // 5- clear() bir webElement'teki input değerini temizlemekte kullanılır.
        WebElement usernameInput1 = webDriver.findElement(By.id("user-name"));
        usernameInput1.clear();
        Thread.sleep(1000);
        WebElement usernameInput2 = webDriver.findElement(By.id("user-name"));
        usernameInput2.sendKeys("standard_user");
        Thread.sleep(1000);
        WebElement passwordInput = webDriver.findElement(By.id("password"));
        passwordInput.sendKeys("secret_sauce");
        Thread.sleep(1000);

        // 6- sendKeys(Keys.) bir webElement'e klavyeden bir tuş ile işlem yaptırmak için kullanılır.
        WebElement loginBtn = webDriver.findElement(By.id("login-button"));
        loginBtn.sendKeys(Keys.ENTER);
        Thread.sleep(1000);

        // 7- scrollIntoView()  bir webElement'in görünür olacağı şekilde sayfayı kaydırmakta kullanılır.
        //JavascriptExecutor ve executeScript() tarayıcıda JavaScript kodlarını çalıştırmakta kullanılır.
        // Burada id'si bilinmeyen bir element locate edilmiş, bu nedenle By.xpath() locator'ı kullanılmıştır.
        WebElement element1 = webDriver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[5]"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", element1);
        Thread.sleep(2000);

        // 8- click() webElement'e "click"leme işlemi için kullanılır.
        WebElement addToCart = webDriver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[6]/div[3]/button"));
        addToCart.click();
        Thread.sleep(2000);

        // 9- navigate().refresh() sayfayı yenilemek için kullanılır.
        webDriver.navigate().refresh();

        // 10- keyDown(Keys.).sendKeys(Keys.).perform() atanmış tuşlar ile işlem yapmak için kullanılır.
        // keyDown(Keys.) klavye tuşlarını basılı tutmayı, sendKeys(Keys.) tuşa basmayı,
        // perform() ise önceki adımlarda tanımlanan işlemleri gerçekleştirmek için kullanılır.
        // Burada 'Control' tuşuna basılı tutularak 'Home' ile sayfa en üste kaydırılmıştır.
        Actions actions = new Actions(webDriver);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
        Thread.sleep(2000);


        // !!!!HATA: Burada sepete git dendiğinde, yeni sekmede boş sepet açıyor. Çözüm?
        WebElement basket = webDriver.findElement(By.id("shopping_cart_container"));
        basket.click();
        Thread.sleep(6000);

        WebElement uccizgi = webDriver.findElement(By.xpath("//*[@id=\"menu_button_container\"]/div/div[3]/div/button"));
        uccizgi.click();
        Thread.sleep(2000);
        WebElement carpi = webDriver.findElement(By.xpath("//*[@id=\"menu_button_container\"]/div/div[2]/div[2]/div/button"));
        carpi.click();
        Thread.sleep(2000);

        // 11- navigate().back() bir önceki sayfaya dönmek için kullanılır.
        webDriver.navigate().back();
        Thread.sleep(1000);

        // 12- navigate().forward() bir önceki sayfaya dönmek için kullanılır.
        webDriver.navigate().forward();
        Thread.sleep(1000);

        // 13- isDisplayed() bir webElement'in varlığını/görünürlüğünü kontrol etmek için kullanılır.
        WebElement maskotGorsel = webDriver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[1]"));
        boolean maskotGorunuyorMu = maskotGorsel.isDisplayed();

        if(maskotGorunuyorMu) {
            System.out.println("Maskot görünüyor!");
        }
        else {
            System.out.println("Maskot görünmüyor!");
        }

        // 14- manage().window().fullscreen() Sayfayı tam ekran yapmak için kullanılır.
        webDriver.manage().window().fullscreen();
        Thread.sleep(2000);

        // 15- quit() oturumu sonlandırarak tarayıcıyı kapatmak için kullanılır.
        webDriver.quit();


    }
}
