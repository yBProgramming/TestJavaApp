/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testjava;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


/**
 *
 * @author DELL
 */
public class testExportExcel {
    
public static void main(String[] args)  {
        try {

        //Populate DefaultTableModel data
        DefaultTableModel dtm = new DefaultTableModel();
            Vector<String> cols = new Vector<String>();
            dtm.addColumn("ຖັນທີ໋ 1");
            dtm.addColumn("ຖັນທີ໋ 2");
            dtm.addColumn("ຖັນທີ໋ 3");

            Vector<String> dtmrow = null;
            for (int i=1;i<=10;i++) {
                dtmrow = new Vector<String>();
                for (int j=1;j<=3;j++) {
                    dtmrow.add("ແຖວທີ໋ " + j + "." + i );
                }
                dtm.addRow(dtmrow);
            }
            
            JTable table = new JTable();
            table.setModel(dtm);
            toExcel(table, new File("D:\\excel_file.xls"));

        //Exporting to Excel           

            Workbook​ wb = new HSSFWorkbook();
            CreationHelper createhelper = wb.getCreationHelper();
            Sheet sheet = wb.createSheet("new sheet");
            Row row = sheet.createRow(0);
            Cell cell = null;
            cell = row.createCell(0);
            cell.setCellValue("ຖັນທີ່1");
            cell = row.createCell(1);
            cell.setCellValue("ຖັນທີ່2");
            cell = row.createCell(2);
            cell.setCellValue("ຖັນທີ່3");
            
            for (int i=1;i<dtm.getRowCount();i++) {
                row = sheet.createRow(i);
                for (int j=0;j<dtm.getColumnCount();j++) {

                    cell = row.createCell(j);
                    cell.setCellValue((String) dtm.getValueAt(i, j));
                }
            }


            FileOutputStream out = new FileOutputStream("D:\\workbook.xls");
            wb.write(out);
            out.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(testExportExcel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(testExportExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
     
   }

public static void toExcel(JTable table, File file){
    try{
        TableModel model = table.getModel();
        FileWriter excel = new FileWriter(file);

        for(int i = 0; i < model.getColumnCount(); i++){
            excel.write(model.getColumnName(i) + "\t");
        }

        excel.write("\n");

        for(int i=0; i< model.getRowCount(); i++) {
            for(int j=0; j < model.getColumnCount(); j++) {
                excel.write(model.getValueAt(i,j).toString()+"\t");
            }
            excel.write("\n");
        }

        excel.close();

    }catch(IOException e){ System.out.println(e); }
}
}
