package utils;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import base.BaseTest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class TestListener extends BaseTest implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        try  {
            File src = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);

            // Define screenshot folder
            Path destDir = Paths.get("test-output", "screenshots");
            if (!Files.exists(destDir)) {
                Files.createDirectories(destDir); // create folder if not exists
            }

            // Define file path
            Path destPath = destDir.resolve(result.getName() + ".png");

            // Copy screenshot
            Files.copy(src.toPath(), destPath, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Screenshot saved at: " + destPath.toAbsolutePath());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test passed: " + result.getName());
    }
}
