/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import Model.Categorie;

/**
 * @author soufyane
 */
public class CategorieHelper extends AbstractViewHelper<Model.Categorie> {

    public CategorieHelper() {
        super(new String[]{"Id Cat", "Nom Cat"});
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex < list.size()) {
            switch (columnIndex) {
                case 0:
                    return list.get(rowIndex).getIdCat();
                case 1:
                    return list.get(rowIndex).getNomCat();
                default:
                    return null;
            }
        }
        return null;

    }

    @Override
    public void save(Categorie t) {
        super.save(t);
    }

    @Override
    public void update(Categorie t, int S) {
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

