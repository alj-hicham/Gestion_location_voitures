/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import Model.Facture;

/**
 * @author azzus
 */
public class facturehelper extends AbstractViewHelper<Model.Facture> {
    public facturehelper() {
        super(new String[]{"idfact", "idcont", "date", "montafatct"});
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        if (rowIndex < list.size()) {
            switch (columnIndex) {
                case 0:
                    return list.get(rowIndex).getIdfact();
                case 1:
                    return list.get(rowIndex).getIdcont();
                case 2:
                    return list.get(rowIndex).getDate();
                case 3:
                    return list.get(rowIndex).getMontafatct();
                default:
                    return null;
            }
        }
        return null;


    }

    @Override
    public void update(Facture t, int S) {
        super.update(t, S); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(int s) {
        super.remove(s); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Facture t) {
        super.save(t); //To change body of generated methods, choose Tools | Templates.
    }

}
