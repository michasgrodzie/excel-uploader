package hm.projekty.kombajn.uploader;

import hm.projekty.kombajn.model.Karton;
import hm.projekty.kombajn.model.Paleta;
import hm.projekty.kombajn.utils.ExcelNames;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.IOException;
import java.io.InputStream;


import java.time.*;

import java.util.*;
@Slf4j
public class ExcelUploader {

    private  Map<Karton, Paleta> finalList;

    private final Workbook workbook;

    public ExcelUploader(InputStream is) throws IOException {
        workbook =new XSSFWorkbook(is);
        this.setPalHu();
        this.setMezOut();
        this.setHsIn();
        this.setHsOut();
        this.setMezIn();

    }



    public Map<Karton,Paleta>getFinalList(){
        return finalList;
    }





    private void setPalHu() {
        Sheet sheet = workbook.getSheet(ExcelNames.SHEET_PAL_HU);
            Iterator<Row>rowIterator = sheet.rowIterator();
            Map<Karton,Paleta>palKart =new HashMap<>();
                while (rowIterator.hasNext()){
                    Row currentRow = rowIterator.next();
                    if(currentRow.getRowNum() == 0){
                        continue;
                    }
                    Karton karton = new Karton();
                    Paleta paleta = new Paleta();
                       String kartHu =  currentRow.getCell(0).getStringCellValue();
                        String palHu = currentRow.getCell(1).getStringCellValue();
                        paleta.setPalNo(palHu);
                            karton.setHuNo(kartHu);
                                karton.setPaleta(paleta);
                                    palKart.put(karton,paleta);
                }
                finalList = palKart;
    }
    private void setHsIn(){
        Sheet sheet = workbook.getSheet(ExcelNames.SHEET_HS_INN);
            Iterator<Row>rowIterator = sheet.rowIterator();
            Date date = new Date();
                while (rowIterator.hasNext()){
                    Row currentRow = rowIterator.next();
                        if(currentRow.getRowNum() == 0){
                            continue;
                        }
                    for (Paleta paleta : finalList.values()) {
                        if (Objects.equals(currentRow.getCell(0).getStringCellValue(), paleta.getPalNo())) {
                            if (currentRow.getCell(1).getCellType() == CellType.NUMERIC) {
                                date = currentRow.getCell(1).getDateCellValue();
                            }
                            if (currentRow.getCell(2).getCellType() == CellType.NUMERIC) {
                                LocalTime lt = currentRow.getCell(2).getDateCellValue().toInstant().atZone(ZoneId.systemDefault()).toLocalTime().minusMinutes(24);
                                LocalDate lcd = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                                LocalDateTime localDateTime = LocalDateTime.of(lcd, lt);
                                paleta.setDateTime(localDateTime);
                            }
                        }
                    }
                }
    }


    private void setHsOut(){
        Sheet sheet = workbook.getSheet(ExcelNames.SHEET_HS_OUT);
        Iterator<Row>rowIterator = sheet.rowIterator();
        Date date = new Date();
        while (rowIterator.hasNext()){
            Row currentRow = rowIterator.next();
            if(currentRow.getRowNum() == 0){
                continue;
            }
            for (Paleta paleta : finalList.values()) {
                if (Objects.equals(currentRow.getCell(0).getStringCellValue(), paleta.getPalNo())) {
                    if (currentRow.getCell(1).getCellType() == CellType.NUMERIC) {
                        date = currentRow.getCell(1).getDateCellValue();
                    }
                    if (currentRow.getCell(2).getCellType() == CellType.NUMERIC) {
                        LocalTime lt = currentRow.getCell(2).getDateCellValue().toInstant().atZone(ZoneId.systemDefault()).toLocalTime().minusMinutes(24);
                        LocalDate lcd = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                        LocalDateTime localDateTime = LocalDateTime.of(lcd, lt);
                        paleta.setDateTimeOut(localDateTime);
                    }
                }
            }
        }



    }

    private void setMezIn(){
        Sheet sheet = workbook.getSheet(ExcelNames.SHEET_MEZZ_INN);
        Iterator<Row>rowIterator = sheet.rowIterator();
        Date date = new Date();
        while (rowIterator.hasNext()){
            Row currentRow = rowIterator.next();
            if(currentRow.getRowNum() == 0){
                continue;
            }
            for (Paleta paleta : finalList.values()) {
                if (Objects.equals(currentRow.getCell(0).getStringCellValue(), paleta.getPalNo())) {
                    if (currentRow.getCell(1).getCellType() == CellType.NUMERIC) {
                        date = currentRow.getCell(1).getDateCellValue();
                    }
                    if (currentRow.getCell(2).getCellType() == CellType.NUMERIC) {
                        LocalTime lt = currentRow.getCell(2).getDateCellValue().toInstant().atZone(ZoneId.systemDefault()).toLocalTime().minusMinutes(24);
                        LocalDate lcd = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                        LocalDateTime localDateTime = LocalDateTime.of(lcd, lt);
                        paleta.setMezzInn(localDateTime);
                    }
                }
            }
        }
    }

    private void setMezOut(){

        Sheet sheet = workbook.getSheet(ExcelNames.SHEET_MEZZ_OUT);
        Iterator<Row>rowIterator = sheet.rowIterator();
        Date date = new Date();
        while (rowIterator.hasNext()){
            Row currentRow = rowIterator.next();
            if(currentRow.getRowNum() == 0){
                continue;
            }
            for (Karton karton : finalList.keySet()) {
                if (Objects.equals(currentRow.getCell(0).getStringCellValue(), karton.getHuNo())) {
                    if (currentRow.getCell(1).getCellType() == CellType.NUMERIC) {
                        date = currentRow.getCell(1).getDateCellValue();
                    }
                    if (currentRow.getCell(2).getCellType() == CellType.NUMERIC) {
                        LocalTime lt = currentRow.getCell(2).getDateCellValue().toInstant().atZone(ZoneId.systemDefault()).toLocalTime().minusMinutes(24);
                        LocalDate lcd = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                        LocalDateTime localDateTime = LocalDateTime.of(lcd, lt);
                        karton.setMezzOut(localDateTime);

                    }
                }
            }
        }

    }






}
