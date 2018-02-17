package helper;

import Model.Marque;


/**
 * @author HMVH
 */
public class MarqueHelper extends AbstractViewHelper<Model.Marque> {

    public MarqueHelper() {
        super(new String[]{"Id Marque", "Nom Marque"});
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex < list.size()) {
            switch (columnIndex) {
                case 0:
                    return list.get(rowIndex).getIdMarque();
                case 1:
                    return list.get(rowIndex).getNimMarque();
                default:
                    return null;
            }
        }
        return null;

    }

    @Override
    public void save(Marque t) {
        super.save(t);
    }

    @Override
    public void update(Marque t, int S) {
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
