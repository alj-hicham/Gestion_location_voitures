/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import Model.Revsion;

/**
 * @author Lenovo
 */
public class ViHelper extends AbstractViewHelper<Model.Revsion> {

    public ViHelper() {
        super(new String[]{"Id Revision", "Matrecule", "KMT"});
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex < list.size()) {
            switch (columnIndex) {
                case 0:
                    return list.get(rowIndex).getV().getIdRev();
                case 1:
                    return list.get(rowIndex).getV().getMatrVh();
                case 2:
                    return list.get(rowIndex).getVid();
                default:
                    return null;
            }
        }
        return null;

    }

    @Override
    public void save(Revsion t) {
        super.save(t);
    }

    @Override
    public void update(Revsion t, int S) {
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
