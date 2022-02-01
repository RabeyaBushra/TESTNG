package Utils;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    WebDriver driver;
    public Utils(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String email;
    public String password;

    public void setEmail(String email)
    {
        this.email=email;
    }

    public void setPassword(String password)
    {
        this.password=password;
    }

    public String getEmail()
    {

        return email;
    }


    public String getPassword()
    {

        return password;
    }


    public  void readJsonFile() throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader("./src/test/resources/users.json"));
        JSONObject jsonObject = (JSONObject) obj;
        setEmail ((String) jsonObject.get("email"));
        setPassword((String) jsonObject.get("password"));
    }

    public  void readJsonArray(int pos) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader("./src/test/resources/users.json"));
        JSONArray jsonArray = (JSONArray) obj;
        JSONObject jsonObject = (JSONObject) jsonArray.get(pos);
        setEmail ((String) jsonObject.get("email"));
        setPassword((String) jsonObject.get("password"));
    }

    public void takeScreenShot() throws IOException {
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String time = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss-aa").format(new Date());
        String fileWithPath = "./src/test/resources/screenshots/" + time + ".png";
        File DestFile = new File(fileWithPath);
        FileUtils.copyFile(screenshotFile, DestFile);
    }


}
