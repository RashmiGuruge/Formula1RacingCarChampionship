package RacingCarChampionship;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GUI {

    public static JFrame jFrame;

    public static void table (){

        //Create the Jframe
        jFrame = new JFrame();

        //https://stackhowto.com/jpanel-java-swing-example/
        //Create the JPanel
        JPanel panel = new JPanel();

        //Specify the position and size of the JPanel
        panel.setBounds(40,50,150,150);

        jFrame.setLayout(new FlowLayout(FlowLayout.LEADING));

        // Frame Title
        jFrame.setTitle("Formula 1 racing car championship.");

        //https://www.tutorialspoint.com/how-to-add-a-title-to-jtable-in-java-swing
        // Column Names
        String[] tableRow = {"Driver Name"," Team ", " Location ", " Races Count "," Points ", "First Positions", "Second Positions","Third Positions"};

        // Data to be displayed in the JTable
        String[][] tableData = new String[Formula1ChampionshipManager.championshipDriversList.size()][8];
        for (int x=0; x<Formula1ChampionshipManager.championshipDriversList.size();x++){
            tableData[x][0] = Formula1ChampionshipManager.championshipDriversList.get(x).getDriverName();
            tableData[x][1] = Formula1ChampionshipManager.championshipDriversList.get(x).getDriverTeam();
            tableData[x][2] = Formula1ChampionshipManager.championshipDriversList.get(x).getDriverLocation();
            tableData[x][3] = String.valueOf(Formula1ChampionshipManager.championshipDriversList.get(x).getNumberOfRaces());
            tableData[x][4] = String.valueOf(Formula1ChampionshipManager.championshipDriversList.get(x).getNumberOfPoints());
            tableData[x][5] = String.valueOf(Formula1ChampionshipManager.championshipDriversList.get(x).getFirstPosition());
            tableData[x][6] = String.valueOf(Formula1ChampionshipManager.championshipDriversList.get(x).getSecondPosition());
            tableData[x][7] = String.valueOf(Formula1ChampionshipManager.championshipDriversList.get(x).getThirdPosition());
        }

        /*
            https://stackhowto.com/jframe-java-swing-example/
            https://www.tutorialspoint.com/how-to-change-each-column-width-of-a-jtable-in-java
            https://www.tutorialspoint.com/program-to-combine-borderlayout-gridlayout-and-flowlayout-in-java-swing
         */

        // Initializing the JTable
        JTable jTable = new JTable(tableData,tableRow);

        //ROW height
        jTable.setRowHeight(30);

        // set the column width for each column
        jTable.getColumnModel().getColumn(0).setPreferredWidth(90);
        jTable.getColumnModel().getColumn(1).setPreferredWidth(90);
        jTable.getColumnModel().getColumn(2).setPreferredWidth(90);
        jTable.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTable.getColumnModel().getColumn(4).setPreferredWidth(60);
        jTable.getColumnModel().getColumn(5).setPreferredWidth(100);
        jTable.getColumnModel().getColumn(6).setPreferredWidth(100);
        jTable.getColumnModel().getColumn(7).setPreferredWidth(100);


        //get the column values to the center (column 3,4,5,6,7)
        DefaultTableCellRenderer valueCenter = new DefaultTableCellRenderer();
        valueCenter.setHorizontalAlignment(JLabel.CENTER);
        jTable.getColumnModel().getColumn(3).setCellRenderer(valueCenter);
        jTable.getColumnModel().getColumn(4).setCellRenderer(valueCenter);
        jTable.getColumnModel().getColumn(5).setCellRenderer(valueCenter);
        jTable.getColumnModel().getColumn(6).setCellRenderer(valueCenter);
        jTable.getColumnModel().getColumn(7).setCellRenderer(valueCenter);


        // adding it to JScrollPane
        JScrollPane jScrollPane = new JScrollPane(jTable);

        //jTable.setFillsViewportHeight(true);
        jScrollPane.setPreferredSize(new Dimension(800, 500));
        panel.add(jScrollPane);

        //Add JPanel to JFrame
        jFrame.add(panel);


        //JButton
        JButton button1 =new JButton("Ascending Order Of Points");
        button1.addActionListener((ActionEvent e) -> Formula1Driver.ascending());
        button1.setPreferredSize(new Dimension(200, 50));
        jFrame.add(button1);

        jTable.setPreferredScrollableViewportSize(jTable.getPreferredSize());
        jTable.setFillsViewportHeight(true);


        //JButton
        JButton button2 =new JButton("Descending Order Of Points");
        button2.addActionListener((ActionEvent e) -> Formula1Driver.descending());
        button2.setPreferredSize(new Dimension(200, 50));
        jFrame.add(button2);


        //JButton
        JButton button3 = new JButton("Descending Order Of First Position");
        button3.addActionListener((ActionEvent e) -> Formula1Driver.firstPositionDescending());
        button3.setPreferredSize(new Dimension(240, 50));
        jFrame.add(button3);


        // Frame Size
        jFrame.setSize(830,650);

        // Frame background color
        jFrame.getContentPane().setBackground(Color.cyan);

        Font font = new Font("Verdana", Font.PLAIN, 13);
        jTable.setFont(font);

        //Fix the Size of the JFrame
        jFrame.setResizable(false);

        // set JFrame in center of the screen
        jFrame.setLocationRelativeTo(null);

        // Frame Visible = true
        jFrame.setVisible(true);


    }
}
