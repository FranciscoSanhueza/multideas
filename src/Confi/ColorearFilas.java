/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Confi;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class ColorearFilas extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean Selected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, Selected, hasFocus, row, col);
        try {
            if (Integer.parseInt(table.getValueAt(row, 4).toString()) < 3) {
                setForeground(Color.red);
            }else{
                setForeground(Color.black);
             }
            return this;
        } catch (java.lang.NumberFormatException ex) {
            setForeground(Color.red);
        } catch(java.lang.NullPointerException nu){
            setForeground(Color.red);
        }
        return this;
    }

}
