/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;


import Model.user;

/**
 * @author Amine Smaki
 */
public class UserHelper extends AbstractViewHelper<Model.user> {
    public UserHelper() {
        super(new String[]{"IDUTIL", "NONUTIL", "PASSUTIL", "ROLE"});
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex < list.size()) {
            switch (columnIndex) {
                case 0:
                    return list.get(rowIndex).getIDUTIL();
                case 1:
                    return list.get(rowIndex).getNONUTIL();
                case 2:
                    return list.get(rowIndex).getPASSUTIL();
                case 3:
                    return list.get(rowIndex).getROLE();
                default:
                    return null;
            }
        }
        return null;

    }

    @Override
    public void save(user t) {
        super.save(t);
    }

    @Override
    public void update(user t, int S) {
        super.update(t, S); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(int s) {
        super.remove(s); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getRowCount() {
        return super.getRowCount();
    }
}
