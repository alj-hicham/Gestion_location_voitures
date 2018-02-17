/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import Model.Client;


/**
 * @author Amine Smaki
 */
public class ClientHelper extends AbstractViewHelper<Model.Client> {

    public ClientHelper() {
        super(new String[]{"CIN", "NUMPT", "NOMCLI", "PRENCLI", "DATENAIS", "VILLENAIS", "ADRES", "TEL1", "TEL2"});
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex < list.size()) {
            switch (columnIndex) {
                case 0:
                    return list.get(rowIndex).getCIN();
                case 1:
                    return list.get(rowIndex).getNUMPT();
                case 2:
                    return list.get(rowIndex).getNOMCLI();
                case 3:
                    return list.get(rowIndex).getPRENCLI();
                case 4:
                    return list.get(rowIndex).getDATENAIS();
                case 5:
                    return list.get(rowIndex).getVILLENAIS();
                case 6:
                    return list.get(rowIndex).getADRES();
                case 7:
                    return list.get(rowIndex).getTEL1();
                case 8:
                    return list.get(rowIndex).getTEL2();
                default:
                    return null;
            }
        }
        return null;

    }

    @Override
    public void save(Client t) {
        super.save(t);
    }

    @Override
    public void update(Client t, int S) {
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
