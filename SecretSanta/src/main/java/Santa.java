
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Santa {

    WebDriver driver;
    @Test

    public void open(){
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\klee0\\IdeaProjects\\microsoftRewards\\src\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.get("https://mail.umn.edu");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void login(){
        try {
            driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("USERNAME_HERE"); // login for email
            driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("PASSWORD_HERE"); // pass for email
            driver.findElement(By.xpath("/html/body/main/div/div/div[1]/form/div[3]/button")).click();
            Thread.sleep(3000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void email(String gifter, String receiver){
        try {
            driver.findElement(By.xpath("//*[@id=\":gg\"]/div/div")).click();
            driver.findElement(By.xpath("//*[@id=\":lm\"]")).sendKeys(gifter);
            driver.findElement(By.xpath("//*[@id=\":l4\"]")).sendKeys("Your Secret Santa is...");
            driver.findElement(By.xpath("//*[@id=\":m7\"]")).sendKeys("You are gifting: " + receiver);
            driver.findElement(By.xpath("//*[@id=\":ku\"]")).click();
            Thread.sleep(3000);
            driver.navigate().to(driver.getCurrentUrl());
            Thread.sleep(3000);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String args[]){

        Santa test = new Santa();
        test.open();
        test.login();


        String[] person = {"Demogorgon@yahoo.com",
                "Mike@hotmail.com",
                "Will@gmail.com",
                "Chief_Hopper@gmail.com",
                "Eleven@gmail.com"};

        int size = person.length;
        System.out.println("Amount of people : " + size);

        String[] people = new String[size];





        for(int i=0; i< size; i++){
            people[i] = person[i];
        }

        List<String> toList = Arrays.asList(people);            //array to list
        Collections.shuffle(toList);                           //in order to use collections.shuffle must turn array into list
        people = toList.toArray(new String[toList.size()]);    //turn list back to array



        for(int i=0; i < size; i++) {
            if(person[i] == people[i]){
                String temp = people[i];
                people[i] = people[i+1];
                people[i+1] = temp;
            }

            String receiver;
            if (people[i] == "Demogorgon@yahoo.com"){
                receiver = "Demogorgon";
            }
            else if (people[i] == "Mike@hotmail.com"){
                receiver = "Mike";
            }
            else if (people[i] == "Will@gmail.com"){
                receiver = "Will";
            }
            else if (people[i] == "Chief_Hopper@gmail.com"){
                receiver = "Chief Hopper";
            }
            else if (people[i] == "Eleven@gmail.com"){
                receiver = "Eleven";
            }
            else{
                receiver = "No one, ERROR.";
            }
            test.email(person[i], receiver);
            System.out.println(person[i] + " is gifting: " + receiver);
        }
    }

}
