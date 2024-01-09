package org.example;

import org.openqa.selenium.*;

import org.openqa.selenium.chrome.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumL {
    private String pathScreenShoot="";
    private String loginVK="";
    private String passwordVK="";

    private String drivePath="";

    public void test() throws InterruptedException, IOException {


        System.setProperty("webdriver.chrome.driver", drivePath);

        WebDriver driver = new ChromeDriver();
        JavascriptExecutor jse = (JavascriptExecutor)driver;

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();



        driver.get("https://vk.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        //Авторизация
        WebElement login=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"index_email\"]")));
        login.sendKeys(loginVK);

        WebElement checkbox=driver.findElement(By.xpath("//*[@id=\"index_login\"]/div/form/div[2]/div[1]/label/span[3]"));
        checkbox.click();

        WebElement buttonEnter=driver.findElement(By.xpath("//*[@id=\"index_login\"]/div/form/button/span"));
        buttonEnter.click();

        WebElement password=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[1]/div/div/div/div/form/div[1]/div[3]/div/div/input")));
        password.sendKeys(passwordVK);

        WebElement buttonNext=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[1]/div/div/div/div/form/div[2]/button/span[1]/span")));
        buttonNext.click();


        //новости
        WebElement news=driver.findElement(By.xpath("//*[@id=\"l_nwsf\"]"));
        news.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"submit_post_box\"]/a/span[1]")));
        Thread.sleep(1000);
        //wait.until(webDriver -> ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete"));
        File scrFileNews = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFileNews, new File(pathScreenShoot+"\\news.jpg"));

        //моя страница
        WebElement myPage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"l_pr\"]/a")));
        myPage.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"profile_redesigned\"]/div/div/div/div[2]/div[1]/div")));
        Thread.sleep(1000);
        //wait.until(webDriver -> ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete"));
        File scrFileMyPage= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFileMyPage, new File(pathScreenShoot+"\\mypage.jpg"));


        //звонки
        WebElement calls=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"l_ca\"]")));
        calls.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wide_column\"]/div/div[2]/header/span[2]/a")));
        Thread.sleep(1000);
        //wait.until(webDriver -> ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete"));
        File scrFileCalls = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFileCalls, new File(pathScreenShoot+"\\calls.jpg"));


        //музыка
        WebElement music=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"l_aud\"]")));
        music.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/div/div[3]/div[2]/div[2]/div/div[1]/div[1]/div/a/div[1]")));
        Thread.sleep(1000);
        //wait.until(webDriver -> ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete"));
        File scrFileMusic = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFileMusic, new File(pathScreenShoot+"\\music.jpg"));



        //стикеры
        WebElement stickers=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"l_stickers\"]")));
        stickers.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tb_stickers_new\"]/a[1]/div[1]/img")));
        Thread.sleep(1000);
        //wait.until(webDriver -> ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete"));
        File scrFileStickers = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFileStickers, new File(pathScreenShoot+"\\stickers.jpg"));

        //Пост
        myPage.click();
        WebElement post=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"post_field\"]")));
        post.click();
        post.sendKeys("Я учусь в Учебном центре Netcracker Тольятти https://vk.com/infocom_tlt");
        WebElement postButton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"send_post\"]/span")));
        postButton.click();
        driver.navigate().refresh();
        WebElement checkPost=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[11]/div/div/div[2]/div[2]/div[3]/div/div[2]/div/div/div/div/div/div[4]/div/div[1]/div[3]/div[2]/div[2]/div[1]/div/div[2]/div/div[1]/div/div")));
        System.out.println(checkPost.getText());
        if(checkPost.getText().equals("Я учусь в Учебном центре Netcracker Тольятти https://vk.com/infocom_tlt")){
            System.out.println("Текст совпадает");
        }else {
            System.out.println("Текст не совпадает");
        }


        jse.executeScript("window.scrollBy(0,-250)");

        //WebElement myPage2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"l_pr\"]/a")));
        //myPage2.click();

        //Редактирование информации
        WebElement changeInfo=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"profile_redesigned\"]/div/div/div/div[2]/div[2]/div[2]/div/div[2]/div/div/div/div[1]/a/span/span")));
        changeInfo.click();
        WebElement changeURL=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pedit_cover\"]/div/div/div[4]/div/div[2]/button")));
        changeURL.click();
        WebElement inputUrl=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pedit_cover\"]/div/div/div[4]/div[1]/div[2]/div/div[2]/span/input")));
        inputUrl.clear();
        inputUrl.sendKeys("selenium1833");
        WebElement saveUrl=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pedit_cover\"]/div/div/div[4]/div[2]/div[3]/button/span/span")));
        saveUrl.click();
        WebElement aboutMe=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pedit_general_short_information\"]")));
        aboutMe.sendKeys("selenium test driver");
        WebElement city=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pedit_home_town\"]")));
        city.sendKeys("Тольятти");
        jse.executeScript("window.scrollBy(0,700)");
        WebElement saveInfoaboutMe=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[11]/div/div/div[2]/div[2]/div[3]/div/div/div[2]/div/div/div[2]/div[2]/div[17]/button/span/span")));
        saveInfoaboutMe.click();
        Thread.sleep(2000);
        driver.navigate().refresh();
        WebElement pageCheck=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"l_pr\"]/a")));
        pageCheck.click();
        WebElement check=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"profile_redesigned\"]/div/div/div/div[2]/div[2]/div[2]/div/div[1]/div/div[2]/div/div[1]/div[2]")));
        check.click();

        //Проверка
        WebElement checkUrl=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"box_layer\"]/div[2]/div/div[3]/div/div[2]/section[1]/div[2]/div[2]/a")));
        System.out.println(checkUrl.getText());
        if(checkUrl.getText().equals("selenium1833")){
            System.out.println("Совпадает");
        }else{
            System.out.println("Не совпадает");
        }
        WebElement checkAboutMe=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"box_layer\"]/div[2]/div/div[3]/div/div[2]/section[1]/div[1]/div[2]/div/div")));
        System.out.println( checkAboutMe.getText());
        if(checkAboutMe.getText().equals("selenium test driver")){
            System.out.println("Совпадает");
        }else{
            System.out.println("Не совпадает");
        }

        WebElement checkCity=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"box_layer\"]/div[2]/div/div[3]/div/div[2]/section[4]/div[2]/div/div[2]/span/span/a")));
        System.out.println(checkCity.getText());
        if(checkCity.getText().equals("Тольятти")){
            System.out.println("Совпадает");
        }else{
            System.out.println("Не совпадает");
        }




        driver.quit();

    }

}
