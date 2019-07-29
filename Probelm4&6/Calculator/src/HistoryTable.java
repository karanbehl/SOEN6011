import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;


import javax.swing.JScrollPane;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


/**
* HistoryTable class contains view of Table
* @author  Karan Behl
* @version 1.0
* @since   2019-07-29 
*/
public class HistoryTable extends JFrame {
    private boolean DEBUG = false;
     private ArrayList<HistoryHelper> historyList;
    public HistoryTable(ArrayList<HistoryHelper> historyList) {
        super("History");
        this.historyList=new ArrayList<HistoryHelper>(historyList);
        MyTableModel myModel = new MyTableModel();
        JTable table = new JTable(myModel);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));

        //Create the scroll pane and add the table to it. 
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this window.
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    
    /**
    * This class defines the model of Table
    * @author  Karan Behl
    * @version 1.0
    * @since   2019-07-29 
    */
    class MyTableModel extends AbstractTableModel {
    	 private String[] columnNames = {"Value of x","Value of y"," Answer"};
  	   public int getColumnCount() {
  		      return columnNames.length;
  		   }
  		   public int getRowCount() {
  		      int size;
  		      if (historyList == null) {
  		         size = 0;
  		      }
  		      else {
  		         size = historyList.size();
  		      }
  		      return size;
  		   }
  		   public Object getValueAt(int row, int col) {
  		      Object temp = null;
  		      if (col == 0) {
  		         temp = historyList.get(row).getValueofx();
  		      }
  		      else if (col == 1) {
  		         temp = historyList.get(row).getValueofy();
  		      }
  		      else if (col == 2) {
  		         temp = new Double(historyList.get(row).getSolution());
  		      }
  		      return temp;
  		   }
  		   // needed to show column names in JTable
  		   public String getColumnName(int col) {
  		      return columnNames[col];
  		   }
  		   public Class getColumnClass(int col) {
  		      if (col == 2) {
  		         return Double.class;
  		      }
  		      else {
  		         return String.class;
  		      }
  		   }
    }
}
