package test;

import com.cybertek.pages.GasMileageCalculatorPage;
import com.cybertek.utilities.Driver;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.time.LocalDateTime;

public class GasMileageTest {


    XSSFWorkbook workbook;
    XSSFSheet sheet;
    FileInputStream fileInputStream;
    FileOutputStream fileOutputStream;

    GasMileageCalculatorPage gasMileageCalculatorPage = new GasMileageCalculatorPage();

    @Test
    public void gasMileageCalculatorTest() throws Exception{
        Driver.getDriver().get("https://www.calculator.net/gas-mileage-calculator.html");
        String path = "/Users/anastasiiarymorieva/Documents/cybertek/cybertek18-cucumber-junit/src/test/resources/testdata/gasMileageTestData.xlsx";
        fileInputStream = new FileInputStream(path);
        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheet("page");
        for(int rowNum = 1;rowNum<=sheet.getLastRowNum();rowNum++) {
            XSSFRow currentRow = sheet.getRow(rowNum);


            double current = currentRow.getCell(1).getNumericCellValue();
            gasMileageCalculatorPage.currentOdo.clear();
            gasMileageCalculatorPage.currentOdo.sendKeys(String.valueOf(current));
            double previous = currentRow.getCell(2).getNumericCellValue();
            gasMileageCalculatorPage.previousOdo.clear();
            gasMileageCalculatorPage.previousOdo.sendKeys(String.valueOf(previous));

            double gas = currentRow.getCell(3).getNumericCellValue();
            gasMileageCalculatorPage.gasInput.clear();
            gasMileageCalculatorPage.gasInput.sendKeys(String.valueOf(gas));

            gasMileageCalculatorPage.calculateButton.click();

            DecimalFormat decimalFormat = new DecimalFormat("#0.00");

            double result = (current - previous) / gas;
            String expectedResult = String.valueOf(decimalFormat.format(result));
            String[] actualResult = gasMileageCalculatorPage.resultInGas.getText().split(" ");

            //create a cell if the current cell is empty
            //sending the expected value from our formula
            if (currentRow.getCell(4) == null) {
                currentRow.createCell(4);
            }

            currentRow.getCell(4).setCellValue(expectedResult);

            if (currentRow.getCell(5) == null) {
                currentRow.createCell(5);
            }

            currentRow.getCell(5).setCellValue(actualResult[0]);


            if (expectedResult.equals(actualResult[0])) {
                if (currentRow.getCell(6) == null) {
                    currentRow.createCell(6);
                }
                currentRow.getCell(6).setCellValue("Pass!");
                System.out.println("Pass!");
            } else {
                currentRow.getCell(6).setCellValue("Fail!");
                System.out.println("Fail!");
            }
            if (currentRow.getCell(7) == null) {
                currentRow.createCell(7);
            }
            currentRow.getCell(7).setCellValue(LocalDateTime.now().toString());

        }
            fileOutputStream = new FileOutputStream(path);
            workbook.write(fileOutputStream);
            fileOutputStream.close();
            fileInputStream.close();
            workbook.close();

       // System.out.println(expectedResult);


       // System.out.println(actualResult[0]);










    }
}
