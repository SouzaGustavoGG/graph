/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import graph.Coordinate;
import graph.Graph;
import graph.Map;
import graph.search.AStar;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import org.jfree.data.xy.XYDataset;

/**
 *
 * @author geevb
 */
public class mapMenuView extends javax.swing.JFrame {

    Map map;
    Graph graph;
    
    /**
     * Creates new form mapMenuView
     */
    public mapMenuView(Map map, Graph graph) {
        this.map = map;
        this.graph = graph;
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setVisible(true);
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitle = new javax.swing.JLabel();
        jButtonAddCoordinate = new javax.swing.JButton();
        jButtonRemoveCoordinate = new javax.swing.JButton();
        jButtonPlotMap = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();
        jButtonDiff = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelTitle.setFont(new java.awt.Font("Ubuntu", 1, 28)); // NOI18N
        jLabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitle.setText("Coordenadas A *");
        jLabelTitle.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, java.awt.Color.gray));

        jButtonAddCoordinate.setText("Adicionar");
        jButtonAddCoordinate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddCoordinateActionPerformed(evt);
            }
        });

        jButtonRemoveCoordinate.setText("Remover");

        jButtonPlotMap.setText("Mostrar Coordenadas");
        jButtonPlotMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPlotMapActionPerformed(evt);
            }
        });

        jButtonBack.setText("Voltar");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        jButtonDiff.setText("Distância");
        jButtonDiff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDiffActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonAddCoordinate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonPlotMap, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonRemoveCoordinate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonDiff, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addGap(63, 63, 63))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddCoordinate, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRemoveCoordinate, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonPlotMap, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDiff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(86, 86, 86)
                .addComponent(jButtonBack)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddCoordinateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddCoordinateActionPerformed
        String x = JOptionPane.showInputDialog("Insira o valor da coordenada X");
        String y = JOptionPane.showInputDialog("Insira o valor da coordenada Y");
        String nome = JOptionPane.showInputDialog("Insira o nome da Coordenada");
        
        if(x.equals("") || y.equals("")) {
            JOptionPane.showMessageDialog(null, "X e Y não podem ser nulos");
            return;
        }
        
        try {
            int int_x = Integer.parseInt(x);
            int int_y = Integer.parseInt(y);
            
            this.map.addCoordinate(new Coordinate(int_x, int_y, nome));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return;
        }
        
        JOptionPane.showMessageDialog(null, "Coordenada inserida com sucesso!");        
    }//GEN-LAST:event_jButtonAddCoordinateActionPerformed

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        this.dispose();
        new mainMenuView(this.graph, this.map);
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jButtonPlotMapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPlotMapActionPerformed
        this.map.addCoordinate(new Coordinate(950 , 231, "A"));
        this.map.addCoordinate(new Coordinate(607 , 486, "B"));
        this.map.addCoordinate(new Coordinate(891 , 762, "C"));
        this.map.addCoordinate(new Coordinate(456 , 19,  "D"));
        this.map.addCoordinate(new Coordinate(821 , 445, "E"));
        this.map.addCoordinate(new Coordinate(615 , 792, "F"));
        this.map.addCoordinate(new Coordinate(922 , 738, "G"));
        this.map.addCoordinate(new Coordinate(176 , 406, "H"));
        this.map.addCoordinate(new Coordinate(935 , 917, "I"));
        this.map.addCoordinate(new Coordinate(410 , 894, "J"));
        this.map.addCoordinate(new Coordinate(58 , 353,  "K"));
        this.map.addCoordinate(new Coordinate(813 , 10,  "L"));
        this.map.addCoordinate(new Coordinate(139 , 203, "M"));
        this.map.addCoordinate(new Coordinate(199 , 604, "N"));
        this.map.addCoordinate(new Coordinate(272 , 199, "O"));
        this.map.addCoordinate(new Coordinate(15 , 747,  "P"));
        this.map.addCoordinate(new Coordinate(445 , 932, "Q"));
        this.map.addCoordinate(new Coordinate(466 , 419, "R"));
        this.map.addCoordinate(new Coordinate(846 , 525, "S"));
        this.map.addCoordinate(new Coordinate(203 , 672, "T"));
        
        new MapPlot("Coordenadas", this.map.createDataset());
    }//GEN-LAST:event_jButtonPlotMapActionPerformed

    private void jButtonDiffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDiffActionPerformed
  	String name1 = JOptionPane.showInputDialog("Nome da primeira coordenada");
        Coordinate cor1 = this.map.getCordinateByName(name1);
        
        if(cor1 == null) {
            JOptionPane.showMessageDialog(null, "Cordenada " + name1 + " não existe.");
            return;
        }
        
        String name2 = JOptionPane.showInputDialog("Nome da segunda coordenada");
        Coordinate cor2 = this.map.getCordinateByName(name2);        
        if(cor2 == null) {
            JOptionPane.showMessageDialog(null, "Cordenada " + name2 + " não existe.");
            return;
        }
        
        String result = this.map.getAStar(name1, name2);

        JOptionPane.showMessageDialog(null, result);
    }//GEN-LAST:event_jButtonDiffActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddCoordinate;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonDiff;
    private javax.swing.JButton jButtonPlotMap;
    private javax.swing.JButton jButtonRemoveCoordinate;
    private javax.swing.JLabel jLabelTitle;
    // End of variables declaration//GEN-END:variables
}

