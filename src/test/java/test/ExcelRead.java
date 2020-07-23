package test;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelRead {
    public static void main(String[] args) throws Exception{
        File file = new File("src/SampleData.xlsx");

       // System.out.println(file.exists());
        //Load the file into java into java memory using FileStream

        FileInputStream fileInputStream = new FileInputStream(file);

        //Load the excell workbook into the java class
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        //workbook>sheet>row>cell
        //getting the sheet from the workbook

        XSSFSheet sheet = workbook.getSheet("Employees");

        //How to get name from excel sheet?
       // System.out.println(sheet.getRow(1).getCell(1));

        int usedRows =sheet.getPhysicalNumberOfRows();
        //will count only used cells
        //if there are some cells that are not used, they will not be counted
        //starts counting from 1

        int lastUsedRaw = sheet.getLastRowNum();
        //will count from top to bottom
        //doesnt care if empty cell or used cell
        //this starts from 0

        //ToDO: 1- Create a logic that prints out Maria's Name Dynamically
        for(int i=0;i<usedRows;i++){
            if(sheet.getRow(i).getCell(0).toString().equals("Adam")){
                System.out.println(sheet.getRow(i).getCell(0));
            }
            }
        //ToDo: 2- Create a logic that prints out Maria's Last Name Dynamically

        for (int i=0;i<usedRows;i++){
            if(sheet.getRow(i).getCell(1).toString().equals("Kurgan")){
                System.out.println("Sdet Full name is: "+sheet.getRow(i).getCell(0)+" "+ sheet.getRow(i).getCell(1));
            }
        }
        }

    }

