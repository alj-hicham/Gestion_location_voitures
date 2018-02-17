/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import Model.Permit;

/**
 * @author Amine Smaki
 */
public class PermitHelper extends AbstractViewHelper<Model.Permit> {
    public PermitHelper() {
        super(new String[]{"NUMPT", "CATPT"});
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex < list.size()) {
            switch (columnIndex) {
                case 0:
                    return list.get(rowIndex).getNUMPT();
                case 1:
                    return list.get(rowIndex).getCATPT();
                default:
                    return null;
            }
        }
        return null;

    }

    @Override
    public void save(Permit t) {
        super.save(t);
    }

    @Override
    public void update(Permit t, int S) {
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
