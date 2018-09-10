/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import graph.Graph;

/**
 *
 * @author geevb
 */
public class edgeMenuView extends javax.swing.JFrame {
    
    Graph graph;

    /**
     * Creates new form edgeMenuView
     */
    public edgeMenuView(Graph graph) {
        this.graph = graph;
        initComponents();
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
        jButtonAddEdge = new javax.swing.JButton();
        jLabelAddEdge = new javax.swing.JLabel();
        jLabelRemoveEdge = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldOrigem = new javax.swing.JTextField();
        jTextFieldNewId = new javax.swing.JTextField();
        jLabelNewId = new javax.swing.JLabel();
        jLabelNewValue = new javax.swing.JLabel();
        jTextFieldNewValue = new javax.swing.JTextField();
        jButtonRemoveEdge = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldVerticeOrigemId = new javax.swing.JTextField();
        jTextFieldVerticeDestinoId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldDestino = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelTitle.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitle.setText("Arcos");

        jButtonAddEdge.setText("Adicionar");
        jButtonAddEdge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddEdgeActionPerformed(evt);
            }
        });

        jLabelAddEdge.setFont(new java.awt.Font("Ubuntu", 2, 15)); // NOI18N
        jLabelAddEdge.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAddEdge.setText("Adicionar Arco");

        jLabelRemoveEdge.setFont(new java.awt.Font("Ubuntu", 2, 15)); // NOI18N
        jLabelRemoveEdge.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRemoveEdge.setText("Remover Arco");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("ID Arco Origem");

        jTextFieldOrigem.setText("ID...");
        jTextFieldOrigem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldOrigemActionPerformed(evt);
            }
        });

        jTextFieldNewId.setText("ID...");
        jTextFieldNewId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNewIdActionPerformed(evt);
            }
        });

        jLabelNewId.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabelNewId.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelNewId.setText("ID Novo Arco");

        jLabelNewValue.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabelNewValue.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelNewValue.setText("Valor Novo Arco");

        jTextFieldNewValue.setText("Valor...");

        jButtonRemoveEdge.setText("Remover");
        jButtonRemoveEdge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveEdgeActionPerformed(evt);
            }
        });

        jButtonSair.setText("Sair");

        jLabel2.setText("ID Vértice Origem");

        jLabel3.setText("ID Vértice Destino");

        jTextFieldVerticeOrigemId.setText("ID...");

        jTextFieldVerticeDestinoId.setText("ID...");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("ID Arco Destino");

        jTextFieldDestino.setText("ID...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabelAddEdge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextFieldNewId, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelNewId, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldVerticeOrigemId, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelNewValue, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldNewValue, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                            .addComponent(jTextFieldVerticeDestinoId))))
                                .addGap(126, 126, 126)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                                    .addComponent(jTextFieldDestino, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldOrigem, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelRemoveEdge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jButtonAddEdge, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonRemoveEdge, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitle)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAddEdge)
                    .addComponent(jLabelRemoveEdge))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNewId, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNewValue, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNewId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNewValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldVerticeOrigemId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldVerticeDestinoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddEdge)
                    .addComponent(jButtonRemoveEdge))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jButtonSair)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddEdgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddEdgeActionPerformed
        String id = this.jTextFieldNewId.getText();
        String value = this.jTextFieldNewValue.getText();
        String vertexId1 = this.jTextFieldVerticeOrigemId.getText();
        String vertexId2 = this.jTextFieldVerticeDestinoId.getText();        
        graph.addEdge(id, value, vertexId1, vertexId2);
        this.dispose();
        new mainMenuView(this.graph);
    }//GEN-LAST:event_jButtonAddEdgeActionPerformed

    private void jTextFieldOrigemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldOrigemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldOrigemActionPerformed

    private void jTextFieldNewIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNewIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNewIdActionPerformed

    private void jButtonRemoveEdgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveEdgeActionPerformed
        String id1 = this.jTextFieldOrigem.getText();
        String id2 = this.jTextFieldDestino.getText();
        graph.removeEdge(id1, id2);
        this.dispose();
        new mainMenuView(this.graph);
    }//GEN-LAST:event_jButtonRemoveEdgeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddEdge;
    private javax.swing.JButton jButtonRemoveEdge;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelAddEdge;
    private javax.swing.JLabel jLabelNewId;
    private javax.swing.JLabel jLabelNewValue;
    private javax.swing.JLabel jLabelRemoveEdge;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JTextField jTextFieldDestino;
    private javax.swing.JTextField jTextFieldNewId;
    private javax.swing.JTextField jTextFieldNewValue;
    private javax.swing.JTextField jTextFieldOrigem;
    private javax.swing.JTextField jTextFieldVerticeDestinoId;
    private javax.swing.JTextField jTextFieldVerticeOrigemId;
    // End of variables declaration//GEN-END:variables
}