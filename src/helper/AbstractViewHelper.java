
/////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////  A EMPORTER MANUELEMENT !!  /////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////

package helper;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
//import util.Reflexsivity;

/**
 * @param <T>
 * @author dell
 */
public abstract class AbstractViewHelper<T> extends AbstractTableModel {

    protected String[] titres;                    // les titres
    protected List<T> list = new ArrayList<>();  // le contenu (liste de userHelper)
    protected JTable jTable = new JTable();       // jTable           plate-forme ! ( DataGridView !! ) 

    public AbstractViewHelper() {
    }

    public AbstractViewHelper(String[] titres) {
        this.titres = titres;
    }


    public AbstractViewHelper(String[] titres, JTable jTable, List<T> list) {
        this.titres = titres;
        this.jTable = jTable;
        this.list = list;
        jTable.setModel(this);
    }

    public JTable getjTable() {
        return jTable;
    }

    public void setjTable(JTable jTable) {
        this.jTable = jTable;
    }

    public void save(T t) {
        list.add(t);
        for (int i = 0; i < titres.length; i++) {
            fireTableRowsInserted(titres.length - 1, i);
        }
    }

    /*  public void remove(T t) {
          int selected = jTable.getSelectedRow();
          list.remove(selected);
          for (int i = 0; i < titres.length; i++) {
              fireTableRowsDeleted(selected, i);

          }
      }*/
    public void remove(int s) {
        list.remove(s);
        for (int i = 0; i < titres.length; i++) {
            fireTableRowsDeleted(s, i);

        }
    }

    /*public void update(T t) {
        int selected = jTable.getSelectedRow();
        list.set(selected, t);
        for (int i = 0; i < titres.length; i++) {
            fireTableRowsUpdated(selected, i);
        }
    }*/
    public void update(T t, int S) {
        list.set(S, t);
        fireTableDataChanged();
    }

    public T getSelected() {
        return list.get(jTable.getSelectedRow());
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return titres.length;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
        fireTableDataChanged();
    }

    public T getValueAt(int rowIndex) {
        if (rowIndex < list.size()) {
            return list.get(rowIndex);
        }

        return null;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return titres[columnIndex];
    }

    public String[] getTitres() {
        return titres;
    }

    public void setTitres(String[] titres) {
        this.titres = titres;
    }

//    @Override
//    public Object getValueAt(int rowIndex, int columnIndex) {
//        if (rowIndex < list.size()) {
//            for (int i = 0; i < titres.length; i++) {
//                if (columnIndex == i) {
//                    try {
//                        return Reflexsivity.lancerGetters(list.get(rowIndex), i + 1);
//                    } catch (Exception ex) {
//                    }
//                }
//            }
//        }
//        return null;
//    }


}
