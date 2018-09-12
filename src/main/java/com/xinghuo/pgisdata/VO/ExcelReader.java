package com.xinghuo.pgisdata.VO;

import com.xinghuo.pgisdata.dao.FieldEntityDao;
import com.xinghuo.pgisdata.entity.FieldEntity;
import com.xinghuo.pgisdata.entity.TableEntity;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {



    public static List<FieldEntity> excelTransToFieldEntity(String path) throws Exception {
        List<FieldEntity> fieldEntities = new ArrayList<FieldEntity>();
        InputStream is = new FileInputStream(path);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
//        XSSFRow titleCell = xssfSheet.getRow(0);

        for (int i = 2; i <= xssfSheet.getLastRowNum(); i++) {

            XSSFRow xssfRow = xssfSheet.getRow(i);

            if(xssfRow.getCell(0).getStringCellValue().isEmpty()){
                return fieldEntities;
            }


            FieldEntity fieldEntity = new FieldEntity();
//            fieldEntity.setID(xssfRow.getCell(3).getStringCellValue());

            fieldEntity.setSsdl(xssfRow.getCell(0).getStringCellValue());
            fieldEntity.setSszl(xssfRow.getCell(1).getStringCellValue());
            fieldEntity.setSxmc(xssfRow.getCell(2).getStringCellValue());
            fieldEntity.setZdmc(xssfRow.getCell(3).getStringCellValue());
            fieldEntity.setZdlx(xssfRow.getCell(4).getStringCellValue());
            XSSFCell xssfCell = xssfRow.getCell(5);
            xssfCell.setCellType(CellType.STRING);
            fieldEntity.setZddx(xssfCell.getStringCellValue());
            fieldEntity.setSfbx(xssfRow.getCell(6).getStringCellValue());
            fieldEntities.add(fieldEntity);
        }
        return  fieldEntities;
    }


    public static List<TableEntity> excelTransToTableEntity() throws Exception {
        List<TableEntity> tableEntities = new ArrayList<TableEntity>();
        InputStream is1 = new FileInputStream("C:/Users/LiuXS/Desktop/数据信息/A-1图层.xlsx");

        XSSFWorkbook xssfWorkbook1 = new XSSFWorkbook(is1);
        XSSFSheet xssfSheet1 = xssfWorkbook1.getSheetAt(0);
//        XSSFRow titleCell = xssfSheet.getRow(0);

        for (int i = 1; i <= xssfSheet1.getLastRowNum(); i++) {

            XSSFRow xssfRow = xssfSheet1.getRow(i);

            if(xssfRow.getCell(0).getStringCellValue().isEmpty()){
                break;
            }

            TableEntity tableEntity = new TableEntity();
//            fieldEntity.setID(xssfRow.getCell(3).getStringCellValue());
            tableEntity.setCdm(xssfRow.getCell(0).getStringCellValue());
            tableEntity.setDl(xssfRow.getCell(1).getStringCellValue());
            tableEntity.setTcmc(xssfRow.getCell(2).getStringCellValue());
            tableEntity.setKjtp(xssfRow.getCell(3).getStringCellValue());
            tableEntity.setYsmc(xssfRow.getCell(4).getStringCellValue());
            tableEntity.setTcxx(xssfRow.getCell(5).getStringCellValue());

            tableEntities.add(tableEntity);
        }

        //A-2图层
        InputStream is2 = new FileInputStream("C:/Users/LiuXS/Desktop/数据信息/A-2图层.xlsx");

        XSSFWorkbook xssfWorkbook2 = new XSSFWorkbook(is2);
        XSSFSheet xssfSheet2 = xssfWorkbook2.getSheetAt(0);
//        XSSFRow titleCell = xssfSheet.getRow(0);

        for (int i = 1; i <= xssfSheet2.getLastRowNum(); i++) {

            XSSFRow xssfRow = xssfSheet2.getRow(i);

            if(xssfRow.getCell(0).getStringCellValue().isEmpty()){
                break;
            }

            TableEntity tableEntity = new TableEntity();
//            fieldEntity.setID(xssfRow.getCell(3).getStringCellValue());
            tableEntity.setCdm(xssfRow.getCell(0).getStringCellValue());
            tableEntity.setDl(xssfRow.getCell(1).getStringCellValue());
            tableEntity.setTcmc(xssfRow.getCell(2).getStringCellValue());
            tableEntity.setKjtp(xssfRow.getCell(3).getStringCellValue());
            tableEntity.setYsmc(xssfRow.getCell(4).getStringCellValue());
            tableEntity.setTcxx(xssfRow.getCell(5).getStringCellValue());

            tableEntities.add(tableEntity);
        }

        //A-3图层
        InputStream is3 = new FileInputStream("C:/Users/LiuXS/Desktop/数据信息/A-3图层.xlsx");

        XSSFWorkbook xssfWorkbook3 = new XSSFWorkbook(is3);
        XSSFSheet xssfSheet3 = xssfWorkbook3.getSheetAt(0);
//        XSSFRow titleCell = xssfSheet.getRow(0);

        for (int i = 1; i <= xssfSheet3.getLastRowNum(); i++) {

            XSSFRow xssfRow = xssfSheet3.getRow(i);

            if(xssfRow.getCell(0).getStringCellValue().isEmpty()){
                break;
            }

            TableEntity tableEntity = new TableEntity();
//            fieldEntity.setID(xssfRow.getCell(3).getStringCellValue());
            tableEntity.setCdm(xssfRow.getCell(0).getStringCellValue());
            tableEntity.setYslb(xssfRow.getCell(1).getStringCellValue());
            tableEntity.setTcmc(xssfRow.getCell(2).getStringCellValue());
            tableEntity.setYsmc(xssfRow.getCell(3).getStringCellValue());
            tableEntity.setTcxx(xssfRow.getCell(4).getStringCellValue());

            tableEntities.add(tableEntity);
        }

        //A-4图层
        InputStream is4 = new FileInputStream("C:/Users/LiuXS/Desktop/数据信息/A-4图层.xlsx");

        XSSFWorkbook xssfWorkbook4 = new XSSFWorkbook(is4);
        XSSFSheet xssfSheet4 = xssfWorkbook4.getSheetAt(0);
//        XSSFRow titleCell = xssfSheet.getRow(0);

        for (int i = 2; i <= xssfSheet4.getLastRowNum(); i++) {

            XSSFRow xssfRow = xssfSheet4.getRow(i);

            if(xssfRow.getCell(0).getStringCellValue().isEmpty()){
                break;
            }

            TableEntity tableEntity = new TableEntity();
//            fieldEntity.setID(xssfRow.getCell(3).getStringCellValue());
            tableEntity.setCdm(xssfRow.getCell(0).getStringCellValue());
            tableEntity.setDl(xssfRow.getCell(1).getStringCellValue());
            tableEntity.setTcmc(xssfRow.getCell(2).getStringCellValue());
            tableEntity.setKjtp(xssfRow.getCell(3).getStringCellValue());
            tableEntity.setYsmc(xssfRow.getCell(4).getStringCellValue());
//            tableEntity.setTcxx(xssfRow.getCell(5).getStringCellValue());

            tableEntities.add(tableEntity);
        }

        return  tableEntities;
    }



}
