/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

/**
 * @author Lenovo
 */
public class ContratHelper extends AbstractViewHelper<Model.Contrat> {

    public ContratHelper() {
        super(new String[]{"c.IDCONT", " c.IDUTIL", "c.CIN",
                "l.NOMCLI", "l.PRENCLI", "c.MATRVH",
                "m.NOMMODEL", "r.NOMMARQUE", " c.DATEDEBUT", " c.DATEFIN",
                "c.DUREE", " c.GPS", " c.SIGEBEBE", " c.CHAINESNAIGE"});
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex < list.size()) {
            switch (columnIndex) {
                case 0:
                    return list.get(rowIndex).getIdCont();
                case 1:
                    return list.get(rowIndex).getIdutil();
                case 2:
                    return list.get(rowIndex).getCin();
                case 3:
                    return list.get(rowIndex).getCl().getNOMCLI();
                case 4:
                    return list.get(rowIndex).getCl().getPRENCLI();
                case 5:
                    return list.get(rowIndex).getMatrVh();
                case 6:
                    return list.get(rowIndex).getMod().getNomModel();
                case 7:
                    return list.get(rowIndex).getMar().getNimMarque();
                case 8:
                    return list.get(rowIndex).getDateDebut();
                case 9:
                    return list.get(rowIndex).getDateFin();
                case 10:
                    return list.get(rowIndex).getDuree();
                case 11:
                    return list.get(rowIndex).isGps();
                case 12:
                    return list.get(rowIndex).isSiegebebe();
                case 13:
                    return list.get(rowIndex).isChainesnaige();

                default:
                    return null;
            }
        }
        return null;

    }

}
