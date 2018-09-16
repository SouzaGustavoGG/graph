/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import console.ConsoleScanner;
import graph.Graph;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author geevb
 */
public class mainMenuView extends javax.swing.JFrame {
    
    Graph graph;
    /**
     * Creates new form mainMenuView
     */
    public mainMenuView(Graph graph) {
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

        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonMenuVertex = new javax.swing.JButton();
        jButtonAddEdge = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButtonBFSearch = new javax.swing.JButton();
        jButtonDFSearch = new javax.swing.JButton();
        jButtonPrimSearch = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButtonExit = new javax.swing.JButton();
        jButtonShowGraph = new javax.swing.JButton();
        jButtonAdjacentes = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Vértices");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Arcos");

        jButtonMenuVertex.setText("Adicionar ou Remover");
        jButtonMenuVertex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuVertexActionPerformed(evt);
            }
        });

        jButtonAddEdge.setText("Adicionar ou Remover");
        jButtonAddEdge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddEdgeActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Buscas");

        jButtonBFSearch.setText("Breadh First");
        jButtonBFSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBFSearchActionPerformed(evt);
            }
        });

        jButtonDFSearch.setText("Depth First");
        jButtonDFSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDFSearchActionPerformed(evt);
            }
        });

        jButtonPrimSearch.setText("Prim");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 26)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Menu Principal");

        jButtonExit.setText("Sair");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });

        jButtonShowGraph.setText("Mostrar Grafo");
        jButtonShowGraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonShowGraphActionPerformed(evt);
            }
        });

        jButtonAdjacentes.setText("Adjacentes");
        jButtonAdjacentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdjacentesActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Grafo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButtonMenuVertex, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonAddEdge, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonAdjacentes, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonBFSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonDFSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonPrimSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonShowGraph, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(226, 226, 226))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonAddEdge, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jButtonMenuVertex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonAdjacentes, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonShowGraph, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBFSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDFSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPrimSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonExit)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBFSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBFSearchActionPerformed
        List<String> finalIds = new ArrayList<>();
        String startid = JOptionPane.showInputDialog("Insira o ID do Vértice Inicial");
        String addNewFinalVertex;
        do {
            finalIds.add(JOptionPane.showInputDialog("Insira o ID do Vértice Final"));
            addNewFinalVertex = JOptionPane.showInputDialog("Deseja inserir um novo Vértice Final [Y] ou [N]");
        }while(addNewFinalVertex.equals("Y"));
        
        this.graph.bfs(startid , finalIds);
    }//GEN-LAST:event_jButtonBFSearchActionPerformed

    private void jButtonMenuVertexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuVertexActionPerformed
        this.dispose();
        new vertexMenuView(this.graph);
    }//GEN-LAST:event_jButtonMenuVertexActionPerformed

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jButtonAddEdgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddEdgeActionPerformed
        this.dispose(); 
        new edgeMenuView(this.graph);
    }//GEN-LAST:event_jButtonAddEdgeActionPerformed

    private void jButtonShowGraphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonShowGraphActionPerformed
        this.graph.showGraph();
    }//GEN-LAST:event_jButtonShowGraphActionPerformed

    private void jButtonDFSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDFSearchActionPerformed
        List<String> finalIds = new ArrayList<>();
        String startid = JOptionPane.showInputDialog("Insira o ID do Vértice Inicial");
        String addNewFinalVertex;
        do {
            finalIds.add(JOptionPane.showInputDialog("Insira o ID do Vértice Final"));
            addNewFinalVertex = JOptionPane.showInputDialog("Deseja inserir um novo Vértice Final [Y] ou [N]");
        }while(addNewFinalVertex.equals("Y"));
        
        this.graph.dfs(startid , finalIds);
    }//GEN-LAST:event_jButtonDFSearchActionPerformed

    private void jButtonAdjacentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdjacentesActionPerformed
        String id1 = JOptionPane.showInputDialog("Insira o ID do Vértice 1");
        String id2 = JOptionPane.showInputDialog("Insira o ID do Vértice 2");
        String ehAdjacente = (graph.adjacent(id1, id2)) ? "Sim" : "Não";
        JOptionPane.showMessageDialog(null, "Os vértices " + id1 + " e " + id2 + " são adjacentes? \n\n" + ehAdjacente);
    }//GEN-LAST:event_jButtonAdjacentesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddEdge;
    private javax.swing.JButton jButtonAdjacentes;
    private javax.swing.JButton jButtonBFSearch;
    private javax.swing.JButton jButtonDFSearch;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonMenuVertex;
    private javax.swing.JButton jButtonPrimSearch;
    private javax.swing.JButton jButtonShowGraph;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
