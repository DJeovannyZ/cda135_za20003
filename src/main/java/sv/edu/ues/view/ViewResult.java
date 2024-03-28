package sv.edu.ues.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import sv.edu.ues.Variable;

public class ViewResult extends JFrame {
    private JTable table = new JTable();

    private DefaultTableModel model = new DefaultTableModel();

    public ViewResult(ArrayList<Variable> listVariables, String nombre) {
        setLayout(new BorderLayout());
        JLabel title = new JLabel(nombre, JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        table.setModel(model);
        table.setFont(new Font("Arial", Font.PLAIN, 14));

        String equations = "";
        for (Variable v : listVariables) {
            equations += v.getEquation() + "   ";
        }
        JLabel lblEquations = new JLabel(equations, JLabel.CENTER);
        lblEquations.setText(equations);
        lblEquations.setFont(new Font("Arial", Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane(table);
        this.add(title, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
        this.add(lblEquations, BorderLayout.SOUTH);

        model.addColumn("Iteraciones");
        for (Variable v : listVariables) {
            model.addColumn("Variable " + v.getName());
        }

        Object[] firstRow = new Object[listVariables.size() + 1];
        firstRow[0] = "";
        for (int i = 0; i < listVariables.size(); i++) {
            firstRow[i + 1] = 0;
        }
        model.addRow(firstRow);

        for (int i = 1; i < listVariables.get(0).getValues().size(); i++) {
            Object[] row = new Object[listVariables.size() + 1];
            row[0] = i;
            for (int j = 0; j < listVariables.size(); j++) {
                row[j + 1] = listVariables.get(j).getValue(i);

            }
            model.addRow(row);
        }

        Object[] lastRow = new Object[listVariables.size() + 1];
        lastRow[0] = "";
        if (listVariables.get(0).isConverge()) {
            for (int i = 0; i < listVariables.size(); i++) {
                Variable v = listVariables.get(i);
                lastRow[i + 1] = "Converge a " + v.getLastValue();
            }
        } else {
            for (int i = 0; i < listVariables.size(); i++) {
                lastRow[i + 1] = "No Converge";
            }
        }
        model.addRow(lastRow);

        configureTable();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 88 + listVariables.get(0).getValues().size() * 20);
        this.setVisible(true);
        this.setTitle("java");

    }

    private void configureTable() {
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.BLACK);
        header.setForeground(Color.WHITE);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        table.setDefaultRenderer(Object.class, centerRenderer);

        table.setRowHeight(20);
        table.setSelectionBackground(new Color(107, 116, 134));
    }
}
