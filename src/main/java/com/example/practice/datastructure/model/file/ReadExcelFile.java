package com.example.practice.datastructure.model.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ReadExcelFile {

    //Q #20) Write a Java Program to read an excel.
    public static void readExcelFile() throws FileNotFoundException {
        // Import excel sheet from a webdriver directory which is inside c drive.
        //DataSource is the name of the excel
        File src = new File("C:\\webdriver\\DataSource.xls");

        //This step is for loading the file. We have used FileInputStream as
        //we are reading the excel. In case you want to write into the file,
        //you need to use FileOutputStream. The path of the file is passed as an argument to FileInputStream
        FileInputStream finput = new FileInputStream(src);

        //This step is to load the workbook of the excel which is done by global HSSFWorkbook in which we have
        //passed finput as an argument.
        /*Workbook = new HSSFWorkbook(finput);

        //This step is to load the sheet in which data is stored.
        Sheet sheet= workbook.getSheetAt(0);

        for(int i=1; i<=sheet.getLastRowNum(); i++)
        {
            // Import data for Email.
            cell = sheet.getRow(i).getCell(1);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            driver.findElement(By.id("email")).sendKeys(cell.getStringCellValue());

            // Import data for the password.
            cell = sheet.getRow(i).getCell(2);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            driver.findElement(By.id("password")).sendKeys(cell.getStringCellValue());
        }*/
    }
}
