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
public class RevsionHelper extends AbstractViewHelper<Model.Revsion> {

    public RevsionHelper() {
        super(new String[]{"Id", "Matricule", "Date Fin D'assurance", "Date Fin de visite technique", "KMT Fin de vidange"});
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex < list.size()) {
            switch (columnIndex) {
                case 0:
                    return list.get(rowIndex).getIdRev();
                case 1:
                    return list.get(rowIndex).getV().getMatrVh();
                case 2:
                    return list.get(rowIndex).getDateFinas();
                case 3:
                    return list.get(rowIndex).getDateVist();
                case 4:
                    return list.get(rowIndex).getVid();

                default:
                    return null;
            }
        }
        return null;

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
    public void save(Revsion t) {
        super.save(t); //To change body of generated methods, choose Tools | Templates.
    }

}
