/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testjava;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JTable;

/**
 *
 * @author DELL
 */
class HelloWorldPrinter implements Printable {

    @Override
    public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
        if (page > 0) {
         return NO_SUCH_PAGE;
    }
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
        g.drawString("Hello world!+\nBy Youathor Yiaveu", 100, 100);
        return PAGE_EXISTS;
    }
}
public class testPrint2 {
    private static JTable table;
    public static void main(String [] args){
        Object[][] data = {{ "a", "b", "e", 4, false } };
          String[] columnNames = { "A", "B", "C", "D", "E" };
          table = new JTable(data, columnNames);
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(new HelloWorldPrinter());
        boolean doPrint = job.printDialog();
        if (doPrint) {
            try {
                job.print();
            } catch (PrinterException e) {
                // The job did not successfully
                // complete
            }
        }
    }
}
