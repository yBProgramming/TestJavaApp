/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testjava;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Graphics2D;
import java.io.FileOutputStream;
import java.io.File;
import  java.awt.Shape;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.PrintRequestAttributeSet;

/**
 *
 * @author DELL
 */
public class testExportPDF extends JFrame {
  private JTable table;

  public testExportPDF() {
    getContentPane().setLayout(new BorderLayout());
    createTable();
  }
  private void createTable() {
      try {
          Object[][] data = {{ "a", "b", "e", 4, false } };
          String[] columnNames = { "A", "B", "C", "D", "E" };
          table = new JTable(data, columnNames);
          
          MessageFormat header = new MessageFormat("Reporting");
            MessageFormat footer = new MessageFormat("{0,number,integer}");
            PrintRequestAttributeSet attr;
          table.print(JTable.PrintMode.FIT_WIDTH, header, footer, true, null, true,null);
          
//          JPanel tPanel = new JPanel(new BorderLayout());
//          tPanel.add(table.getTableHeader(), BorderLayout.NORTH);
//          tPanel.add(table, BorderLayout.CENTER);
//          
//          getContentPane().add(tPanel, BorderLayout.CENTER);
      } catch (PrinterException ex) {
          Logger.getLogger(testExportPDF.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
  private void print() {
    Document document = new Document(PageSize.A4.rotate());
    try {
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(new File("D:\\jTable.pdf")));

      document.open();
        PdfContentByte cb = writer.getDirectContent();

      cb.saveState();
        Graphics2D g2 = cb.createGraphicsShapes(table.getWidth(), table.getHeight());

        Shape oldClip = g2.getClip();
      g2.clipRect(0, 0, table.getWidth(), table.getHeight());

      table.print(g2);
      g2.setClip(oldClip);

      g2.dispose();
      cb.restoreState();
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
    document.close();
  }
  public static void main(String[] args) {
    testExportPDF frame = new testExportPDF();
    frame.pack();
    frame.setVisible(true);
    frame.print();
  }
}
