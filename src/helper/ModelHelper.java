/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import Model.Model;


/**
 * @author Lenovo
 */
public class ModelHelper extends AbstractViewHelper<Model> {

    public ModelHelper() {
        super(new String[]{"Id Model", "Nom Model", "Nom Marque", "Annee"});
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex < list.size()) {
            switch (columnIndex) {
                case 0:
                    return list.get(rowIndex).getIdModel();
                case 1:
                    return list.get(rowIndex).getNomModel();
                case 2:
                    return list.get(rowIndex).getM().getNimMarque();
                case 3:
                    return list.get(rowIndex).getAnnee();
                default:
                    return null;
            }
        }
        return null;


    }

    @Override
    public void update(Model t, int S) {
        super.update(t, S); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public void remove(int s) {
        super.remove(s); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Model t) {
        super.save(t); //To change body of generated methods, choose Tools | Templates.
    }


}
