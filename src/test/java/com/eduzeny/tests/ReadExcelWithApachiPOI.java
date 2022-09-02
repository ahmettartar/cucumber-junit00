package com.eduzeny.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcelWithApachiPOI {

    @Test
    public void read_from_excel_file() throws IOException {

        String path = "ExcelPractice.xlsx";
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);

        //workbook>sheet>row>cell
        //1-create a workbook xlsx YENI FORMAT
        //eski format xls HSSFWorkbook

        XSSFWorkbook wb = new XSSFWorkbook(fis);

        //2-we need a specific sheet from wb
        XSSFSheet sheet = wb.getSheet("kisiler");

        //3- select row and cell
        System.out.println(sheet.getRow(1).getCell(0));// Anna

        //Toplam kullanilan hucre sayisi(bos olanlar sayilmaz)
        int usedRows = sheet.getPhysicalNumberOfRows();
        System.out.println(usedRows); //6

        //Son degerin index numarasini bulalim, (Bosluklari da sayar, 0'dan baslar)
        int lastUsedIndex = sheet.getLastRowNum();
        System.out.println(lastUsedIndex);//5.indeces olarak verir

        //TODO: Create a logic to print out Linda's name

        for (int rowNum = 0; rowNum < usedRows; rowNum++) {
            if (sheet.getRow(rowNum).getCell(0).toString().equals("Linda")) {
                System.out.println(sheet.getRow(rowNum).getCell(0)); //Linda
            }
        }


        // TODO: Print out Venna's Job_id
        for (int rowNum = 0; rowNum < usedRows; rowNum++) {
            if (sheet.getRow(rowNum).getCell(0).toString().equals("Venna")) { //once Venna'yi bulur. sonra meslegini buluruz.
                System.out.println(sheet.getRow(rowNum).getCell(2)); //Sdet
            }
        }

        // TODO: Birden cok linda var, soyadlarindan ayrica sorgulariz.
        for (int rowNum = 0; rowNum < usedRows; rowNum++) {
            if (sheet.getRow(rowNum).getCell(0).toString().equals("Linda") //firstname yeri

                    &&

                    sheet.getRow(rowNum).getCell(1).toString().equals("Gomez")


            ) {
                System.out.println(sheet.getRow(rowNum).getCell(2)); //istenilen bilgi alinir.
            }
        }
    }

}
