/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import console.Draw;
import graph.Graph;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author geevb
 */
public class mainMenuView extends javax.swing.JFrame {
    
    private Graph graph;
    private Draw<String,Integer> draw;
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
        jScrollBar1 = new javax.swing.JScrollBar();
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
        jButtonPlanaridade = new javax.swing.JButton();
        jButtonDijkstraSearch = new javax.swing.JButton();
        jButtonColors = new javax.swing.JButton();
        jButtonFloydSearch = new javax.swing.JButton();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Vértices");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Arcos");

        jButtonMenuVertex.setText("Adicionar ou Remover");
        jButtonMenuVertex.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray));
        jButtonMenuVertex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuVertexActionPerformed(evt);
            }
        });

        jButtonAddEdge.setText("Adicionar ou Remover");
        jButtonAddEdge.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray));
        jButtonAddEdge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddEdgeActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Buscas");

        jButtonBFSearch.setText("Breadh First");
        jButtonBFSearch.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray));
        jButtonBFSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBFSearchActionPerformed(evt);
            }
        });

        jButtonDFSearch.setText("Depth First");
        jButtonDFSearch.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray));
        jButtonDFSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDFSearchActionPerformed(evt);
            }
        });

        jButtonPrimSearch.setText("Prim");
        jButtonPrimSearch.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray));
        jButtonPrimSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrimSearchActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 28)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Menu Principal");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, java.awt.Color.gray));

        jButtonExit.setText("Sair");
        jButtonExit.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray));
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });

        jButtonShowGraph.setText("Mostrar Grafo");
        jButtonShowGraph.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray));
        jButtonShowGraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonShowGraphActionPerformed(evt);
            }
        });

        jButtonAdjacentes.setText("Ver Adjacentes");
        jButtonAdjacentes.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray));
        jButtonAdjacentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdjacentesActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Grafo");

        jButtonPlanaridade.setText("Planaridade");
        jButtonPlanaridade.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray));
        jButtonPlanaridade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPlanaridadeActionPerformed(evt);
            }
        });

        jButtonDijkstraSearch.setText("Dijkstra");
        jButtonDijkstraSearch.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray));
        jButtonDijkstraSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDijkstraSearchActionPerformed(evt);
            }
        });

        jButtonColors.setText("Coloração");
        jButtonColors.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray));
        jButtonColors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonColorsActionPerformed(evt);
            }
        });

        jButtonFloydSearch.setText("Floyd");
        jButtonFloydSearch.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        jButtonFloydSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonFloydSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFloydSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButtonAdjacentes, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonMenuVertex, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAddEdge, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jButtonShowGraph, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jButtonPlanaridade, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jButtonColors, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonDijkstraSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(jButtonFloydSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(160, 160, 160))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonBFSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jButtonDFSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jButtonPrimSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89))))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonMenuVertex, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAddEdge, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonAdjacentes, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPlanaridade, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonColors, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonShowGraph, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBFSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDFSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPrimSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDijkstraSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonFloydSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
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
        }while(addNewFinalVertex.equals("Y") || addNewFinalVertex.equals("y"));
        
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
            String graphName = "graph.png";
            graph.showGraph();
            try {
                    Draw drw = new Draw();
                    drw.drawGraph(this.graph, graphName);
            } catch (IOException e) {
                    e.printStackTrace();
            }
            
            new DisplayImage(graphName);
    }//GEN-LAST:event_jButtonShowGraphActionPerformed

    private void jButtonDFSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDFSearchActionPerformed
        List<String> finalIds = new ArrayList<>();
        String startid = JOptionPane.showInputDialog("Insira o ID do Vértice Inicial");
        String addNewFinalVertex;
        do {
            finalIds.add(JOptionPane.showInputDialog("Insira o ID do Vértice Final"));
            addNewFinalVertex = JOptionPane.showInputDialog("Deseja inserir um novo Vértice Final [Y] ou [N]");
        }while(addNewFinalVertex.equals("Y") || addNewFinalVertex.equals("y"));
        
        this.graph.dfs(startid , finalIds);
    }//GEN-LAST:event_jButtonDFSearchActionPerformed

    private void jButtonAdjacentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdjacentesActionPerformed
        String id1 = JOptionPane.showInputDialog("Insira o ID do Vértice 1");
        String id2 = JOptionPane.showInputDialog("Insira o ID do Vértice 2");
        String isAdjacente = (graph.adjacent(id1, id2)) ? "Sim" : "Não";
        JOptionPane.showMessageDialog(null, "Os vértices " + id1 + " e " + id2 + " são adjacentes? \n\n"
                + "                       " + isAdjacente);
    }//GEN-LAST:event_jButtonAdjacentesActionPerformed

    private void jButtonPlanaridadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPlanaridadeActionPerformed
        String cyclesGreaterThanThree = JOptionPane.showInputDialog("Possui ciclos maiores que 3? [Y] ou [N]: ");
        String isPlanar = (graph.isPlanar(cyclesGreaterThanThree.equals("Y"))) ? "Sim" : "Não";
        JOptionPane.showMessageDialog(null, "O Grafo é planar? \n"
                + "                " + isPlanar);
    }//GEN-LAST:event_jButtonPlanaridadeActionPerformed

    private void jButtonPrimSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrimSearchActionPerformed
        if(graph.isOriented()) {
            JOptionPane.showMessageDialog(null, "O grafo deve ser Não-Orientado!");
        } else {
            graph.prim();
        }
    }//GEN-LAST:event_jButtonPrimSearchActionPerformed

    private void jButtonDijkstraSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDijkstraSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonDijkstraSearchActionPerformed

    private void jButtonColorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonColorsActionPerformed
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of verticesz\n");
        this.graph.getVertices().forEach(kek -> System.out.println(kek.toString()));
        int V = scan.nextInt();
 
        /** get graph **/
        System.out.println("\nEnter matrix\n");
        int[][] graph = new int[V][V];
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                graph[i][j] = scan.nextInt();
 
        System.out.println("\nEnter number of colors");
        int c = scan.nextInt();
        
        this.graph.coloring(V, c, graph);
    }//GEN-LAST:event_jButtonColorsActionPerformed

    private void jButtonFloydSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFloydSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonFloydSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddEdge;
    private javax.swing.JButton jButtonAdjacentes;
    private javax.swing.JButton jButtonBFSearch;
    private javax.swing.JButton jButtonColors;
    private javax.swing.JButton jButtonDFSearch;
    private javax.swing.JButton jButtonDijkstraSearch;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonFloydSearch;
    private javax.swing.JButton jButtonMenuVertex;
    private javax.swing.JButton jButtonPlanaridade;
    private javax.swing.JButton jButtonPrimSearch;
    private javax.swing.JButton jButtonShowGraph;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
