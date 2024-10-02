package kg.mega.mega_taxi.service;


import kg.mega.mega_taxi.model.Orders;
import lombok.AllArgsConstructor;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class ReportService {

    @Autowired
    private final OrdersService ordersService;

    public byte[] getExcelFile() throws IOException {

        List<Orders> orders = ordersService.getAllOrders();

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        //create workbook sheet
        XSSFWorkbook workbook = new XSSFWorkbook();
        int rowNum = 1;

        XSSFSheet sheet = workbook.createSheet("Orders");

        XSSFRow headerRow = sheet.createRow(0);

        XSSFCell orderId = headerRow.createCell(0, CellType.STRING);
        orderId.setCellValue("ID order");

        XSSFCell destinationPoint = headerRow.createCell(1, CellType.STRING);
        destinationPoint.setCellValue("Destination Point");

        XSSFCell sourcePoint = headerRow.createCell(2, CellType.STRING);
        sourcePoint.setCellValue("Source Point");

        XSSFCell price = headerRow.createCell(3, CellType.STRING);
        price.setCellValue("Price");

        for(Orders orders1 : orders){
           XSSFRow row = sheet.createRow(rowNum);
           rowNum ++;
           XSSFCell orderId1 = row.createCell(0,CellType.NUMERIC);
           orderId1.setCellValue(orders1.getId());

           XSSFCell destPoint = row.createCell(1, CellType.STRING);
           destPoint.setCellValue(orders1.getDestinationPoint());

           XSSFCell srcPoint = row.createCell(2, CellType.STRING);
           srcPoint.setCellValue(orders1.getSourcePoint());

           XSSFCell price1 = row.createCell(3, CellType.NUMERIC);
           price1.setCellValue(orders1.getPrice());

        }




        workbook.write(bos);
        bos.close();


    return bos.toByteArray();
    }
}
