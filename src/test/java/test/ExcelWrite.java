package test;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelWrite {
    public static void main(String[] args) throws Exception{
        XSSFWorkbook workbook;
        XSSFSheet sheet;
        XSSFRow raw;
        XSSFCell cell;

        String path = "src/SampleData.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);

        workbook = new XSSFWorkbook(fileInputStream);

        sheet = workbook.getSheet("Employees");

        raw = sheet.getRow(1);

        cell = raw.getCell(1);
        System.out.println("Before "+cell);

        cell.setCellValue("Rymorieva");

        //create a FileOutputStream to spesify which file we are writing to
        System.out.println("After "+cell);


        //TODO: Change Adam's Name to Tom

        for (int rowNum=0; rowNum<sheet.getPhysicalNumberOfRows();rowNum++){
            if (sheet.getRow(rowNum).getCell(0).toString().equals("Maria")){
                sheet.getRow(rowNum).getCell(2).setCellValue("Developer");
            }

        }

        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);
        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();
    }
}
