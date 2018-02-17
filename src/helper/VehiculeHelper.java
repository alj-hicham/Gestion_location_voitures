/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import javax.swing.*;

/**
 * @author Lenovo
 */
public class VehiculeHelper extends AbstractViewHelper<Model.Vehicule> {
    JLabel p = new JLabel();

    public VehiculeHelper() {
        super(new String[]{"Matricule", "Id Revision", "Date D'Achat ", "Prix D'Achat", "Kilometrage", "Categories", "Marque", "Model", "Nombre de Port", "Nombre De Place", "Type Du Boite Vitesse", "type de climatiseur ", "Prix Jour", "Disponibilite", "Image"});
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex < list.size()) {
            switch (columnIndex) {
                case 0:
                    return list.get(rowIndex).getMatrVh();
                case 1:
                    return list.get(rowIndex).getIdRev();
                case 2:
                    return list.get(rowIndex).getDateAchat();
                case 3:
                    return list.get(rowIndex).getPrixAchat();

                case 4:
                    return list.get(rowIndex).getKms();
                case 5:
                    return list.get(rowIndex).getCat().getNomCat();
                case 6:
                    return list.get(rowIndex).getMa().getNimMarque();
                case 7:
                    return list.get(rowIndex).getMo().getNomModel();
                case 8:
                    return list.get(rowIndex).getNbPort();
                case 9:
                    return list.get(rowIndex).getNbPasssager();
                case 10:
                    return list.get(rowIndex).getBoitevitesse();
                case 11:
                    return list.get(rowIndex).getAc();
                case 12:
                    return list.get(rowIndex).getPrixJourVh();
                case 13:
                    return list.get(rowIndex).isStatutVh();
                case 14:
                    return list.get(rowIndex).getImagVh();
                default:
                    return null;
            }
        }
        return null;

    }

}
