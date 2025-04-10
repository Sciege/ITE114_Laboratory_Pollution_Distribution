

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.EigenDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Chesler John  Hamili
 */

public class NewJFrame extends javax.swing.JFrame {
    private List<JTextField> cellList = new ArrayList<>();
    private double[][] eigenvectorMatrix; // store eigenvectors for visualization
    private int gridSize = 0; // store the grid size

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
    initComponents();
    getContentPane().setBackground(new Color(163, 135, 114)); 
    // Customize the existing heatmap panel WITHOUT replacing it
    final JPanel existingHeatmap = heatmap; // Save reference to the original panel
    heatmap.getParent().setLayout(new BorderLayout());  

    // clear any existing layout
    existingHeatmap.setBackground(Color.WHITE);
    
    // Add a component listener to detect when the panel gets sized
    existingHeatmap.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
            System.out.println("Heatmap resized to: " + existingHeatmap.getWidth() + "x" + existingHeatmap.getHeight());
            existingHeatmap.repaint(); 
        }
    });
    
    // Override paintComponent by adding a custom JPanel inside the existing one
    //this is just overriding calling inside the java again
    JPanel customPaintPanel = new JPanel() {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (eigenvectorMatrix != null && gridSize > 0) {
            drawHeatmap(g, getWidth(), getHeight()); 
        }
    }
};
    
    customPaintPanel.setOpaque(false); // transparent
    existingHeatmap.removeAll(); // remove any existing components
    existingHeatmap.setLayout(new BorderLayout()); 
    existingHeatmap.add(customPaintPanel, BorderLayout.CENTER); 
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        heatmap = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        eigenvectors_panel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        pollution = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        eigen_panel = new javax.swing.JPanel();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        panelGrid = new javax.swing.JPanel();
        input = new javax.swing.JTextField();
        OK = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(163, 135, 114));

        heatmap.setBackground(new java.awt.Color(194, 191, 176));

        javax.swing.GroupLayout heatmapLayout = new javax.swing.GroupLayout(heatmap);
        heatmap.setLayout(heatmapLayout);
        heatmapLayout.setHorizontalGroup(
            heatmapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        heatmapLayout.setVerticalGroup(
            heatmapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 399, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(191, 191, 176));

        javax.swing.GroupLayout eigenvectors_panelLayout = new javax.swing.GroupLayout(eigenvectors_panel);
        eigenvectors_panel.setLayout(eigenvectors_panelLayout);
        eigenvectors_panelLayout.setHorizontalGroup(
            eigenvectors_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        eigenvectors_panelLayout.setVerticalGroup(
            eigenvectors_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(254, 244, 234));
        jLabel5.setText("Interpretation of Pollution Distribution Patterns");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(eigenvectors_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(132, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(116, 116, 116))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(8, 8, 8)
                .addComponent(eigenvectors_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pollution.setBackground(new java.awt.Color(194, 191, 176));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(254, 244, 234));
        jLabel3.setText("Key Pollution Retention Factors ");

        eigen_panel.setPreferredSize(new java.awt.Dimension(0, 0));
        eigen_panel.setLayout(new java.awt.GridLayout());

        javax.swing.GroupLayout pollutionLayout = new javax.swing.GroupLayout(pollution);
        pollution.setLayout(pollutionLayout);
        pollutionLayout.setHorizontalGroup(
            pollutionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pollutionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(112, 112, 112))
            .addGroup(pollutionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(eigen_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pollutionLayout.setVerticalGroup(
            pollutionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pollutionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eigen_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(194, 191, 176));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(254, 244, 234));
        jLabel2.setText("Enter Size");

        jButton1.setBackground(new java.awt.Color(208, 161, 137));
        jButton1.setText("Enter");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        panelGrid.setLayout(new java.awt.GridLayout(1, 0));

        input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputActionPerformed(evt);
            }
        });

        OK.setBackground(new java.awt.Color(208, 161, 137));
        OK.setText("Analyze");
        OK.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        OK.setOpaque(true);
        OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator2)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(panelGrid, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 3, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addComponent(jLabel2)
                                .addGap(27, 27, 27)
                                .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(165, 165, 165)
                                .addComponent(OK, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelGrid, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OK)
                .addGap(34, 34, 34))
        );

        jLabel1.setFont(new java.awt.Font("Bell MT", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 244, 234));
        jLabel1.setText(" Barangay Pollution Analysis");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(heatmap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(pollution, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 991, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(heatmap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pollution, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKActionPerformed
        // TODO add your handling code here:
      
        try {

            gridSize = (int) Math.sqrt(cellList.size());
            double[][] pollutionMatrix = new double[gridSize][gridSize];

            Font textFieldFont = new Font("Arial", Font.PLAIN, 14);
            // Extract values from JTextFields
            for (int i = 0; i < gridSize; i++) {
                for (int j = 0; j < gridSize; j++) {
                    int index = i * gridSize + j;
                    JTextField cell = cellList.get(index);
                    cell.setFont(textFieldFont);
                    String text = cell.getText().trim();   
                    try {
                        pollutionMatrix[i][j] = Double.parseDouble(text);
                    } catch (NumberFormatException e) {
                        pollutionMatrix[i][j] = 0.0; 
                    }
                }
            }

            RealMatrix matrix = new Array2DRowRealMatrix(pollutionMatrix);
            EigenDecomposition eigen = new EigenDecomposition(matrix);

            eigenvectorMatrix = new double[gridSize][gridSize]; 

            for (int i = 0; i < gridSize; i++) {
                RealVector eigenVector = eigen.getEigenvector(i);
                for (int j = 0; j < gridSize; j++) {
                    eigenvectorMatrix[i][j] = eigenVector.getEntry(j);
                }
            }
            //debugging
            for (int i = 0; i < gridSize; i++) {
                for (int j = 0; j < gridSize; j++) {
                    System.out.print(eigenvectorMatrix[i][j] + " ");
                }
                System.out.println();
            }
            // debug 
            System.out.println("Before repaint - Heatmap dimensions: " + heatmap.getWidth() + "x" + heatmap.getHeight());

            
            if (!heatmap.isVisible()) {
                heatmap.setVisible(true);
            }

            // Force layout update
            heatmap.invalidate();
            heatmap.validate();
            heatmap.repaint();
            // --- FROM HERE, NOTHING CHANGES ---

            double[] eigenValues = eigen.getRealEigenvalues();

            System.out.println("Barangay Pollution Analysis Report");
            System.out.println("-------------------------------------------------");

            // Step 3: Display eigenvalues (How pollution persists)
            System.out.println("**Key Pollution Retention Factors (Eigenvalues):**");
            for (int i = 0; i < eigenValues.length; i++) {
                System.out.printf("   - Factor %d: %.4f\n", (i + 1), eigenValues[i]);
            }

    eigen_panel.removeAll();
    eigen_panel.setLayout(new GridLayout(eigenValues.length * 2 + 4, 1, 5, 5)); 

// Add a header label
    double maxEigenValue = 0;
    for (double value : eigenValues) {
    maxEigenValue = Math.max(maxEigenValue, value);
    }
    for (int i = 0; i < eigenValues.length; i++) {
    String eigenValueText = String.format("   - Factor %d: %.4f", (i + 1), eigenValues[i]);
    JLabel eigenLabel = new JLabel(eigenValueText, JLabel.CENTER);
    eigenLabel.setFont(new Font("Arial",Font.BOLD, 14));
    eigen_panel.add(eigenLabel);

    // **interpretation Logic**
    String interpretation;
    if (eigenValues[i] == 1.0) {
        interpretation = "⚠️ Zone " + (i + 1) + " retains pollution for a long time.";
    } else if (eigenValues[i] < 1.0) {
        interpretation = "✅ Zone " + (i + 1) + " disperses pollution efficiently.";
    } else if (eigenValues[i] == maxEigenValue) {
        interpretation = "🚨 Zone " + (i + 1) + " requires stricter pollution control!";
    } else {
        interpretation = "ℹ️ Zone " + (i + 1) + " has moderate pollution retention.";
    }

    JLabel interpretationLabel = new JLabel(interpretation, JLabel.CENTER);
    interpretationLabel.setFont(new Font("Arial",Font.PLAIN, 14));
    eigen_panel.add(interpretationLabel);
}

    // Refresh the panel
    eigen_panel.revalidate();
    eigen_panel.repaint();


            // Interpretation of Eigenvalues
            System.out.println("\n**Interpretation of Eigenvalues:**");
            System.out.println("- Higher eigenvalues indicate zones where pollution persists longer.");
            System.out.println("- Lower eigenvalues suggest zones where pollution disperses more easily.");
            System.out.println("- If an eigenvalue is significantly larger, that zone may need stricter pollution control measures.");

            // Display pollution distribution pattern (Eigenvectors)
            System.out.println("\n**Barangay Pollution Distribution Pattern (Eigenvectors):**");
            System.out.println("-------------------------------------------------");

            for (int i = 0; i < pollutionMatrix.length; i++) {
                RealVector eigenVector = eigen.getEigenvector(i);
                System.out.printf("Pattern %d:\n", (i + 1));
                for (int j = 0; j < pollutionMatrix.length; j++) {
                    System.out.printf("   Zone %c: %.4f |", 'A' + j, eigenVector.getEntry(j));
                }
            }
            eigenvectors_panel.removeAll();
            eigenvectors_panel.setLayout(new GridLayout(pollutionMatrix.length * 2 + 4, 1, 5, 5)); // Adjust grid layout size
for (int i = 0; i < pollutionMatrix.length; i++) {
    RealVector eigenVector = eigen.getEigenvector(i);
    
    // Display eigenvector values
    StringBuilder vectorText = new StringBuilder("   Pattern " + (i + 1) + ": ");
    for (int j = 0; j < eigenVector.getDimension(); j++) {
        vectorText.append(String.format("Zone %c: %.4f | ", 'A' + j, eigenVector.getEntry(j)));
    }

    JLabel eigenvectorLabel = new JLabel(vectorText.toString(), JLabel.CENTER);
    eigenvectorLabel.setFont(new Font("Arial",Font.BOLD, 14));
    eigenvectors_panel.add(eigenvectorLabel);

    // **Interpretation Logic for Eigenvectors**
    double maxVal = -Double.MAX_VALUE;
    double minVal = Double.MAX_VALUE;
    int maxIndex = -1; // To track the index of the zone with the maximum value
    int minIndex = -1; // To track the index of the zone with the minimum value

// Loop through the eigenvector to find the max and min values, and their corresponding indices
    for (int j = 0; j < eigenVector.getDimension(); j++) {
    double entry = eigenVector.getEntry(j);
    
    if (entry > maxVal) {
        maxVal = entry;
        maxIndex = j;
    }
    
    if (entry < minVal) {
        minVal = entry;
        minIndex = j;
    }
}

String vectorInterpretation;

if (Math.abs(maxVal - minVal) < 0.05) {
    //same
    vectorInterpretation = "📡 Pollution spreads evenly across all zones.";
} else if (maxVal > 0.5) {
    //big positive
    vectorInterpretation = String.format("🚗 Zone %c with highest value (%.4f) contributes the most to pollution.", 'A' + maxIndex, maxVal);
} else if (minVal < 0) {
    //big negative
    vectorInterpretation = String.format("🌱 Zone %c with negative value (%.4f) acts as a pollution sink.", 'A' + minIndex, minVal);
} else {
    vectorInterpretation = "🔄 Mixed pollution distribution pattern.";
}

    JLabel vectorInterpretationLabel = new JLabel(vectorInterpretation, JLabel.CENTER);
    vectorInterpretationLabel.setFont(new Font("Arial",Font.PLAIN, 14));
    eigenvectors_panel.add(vectorInterpretationLabel);
}  
   
// Refresh the panel to display the changes
eigenvectors_panel.revalidate();
eigenvectors_panel.repaint();

            // Interpretation of Eigenvectors
            System.out.println("\n**Interpretation of Pollution Distribution Patterns:**");
            System.out.println("- If the values in an eigenvector are similar, pollution spreads evenly across zones.");
            System.out.println("- Large positive or negative values indicate zones that contribute more to pollution.");
            System.out.println("- Zone A (Main Road) is expected to retain more pollution, while Zone C (Green Space) helps disperse it.");
            System.out.println("- By analyzing these patterns, the barangay can decide where to place air filters or plant trees.");

            System.out.println("-------------------------------------------------");
            heatmap.repaint();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_OKActionPerformed

    private void inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            int size = Integer.parseInt(input.getText());
            if (size < 2 || size > 5) {
                JOptionPane.showMessageDialog(this, "Please enter a number between 2 and 5.");
                return;
            }

            panelGrid.removeAll();
            panelGrid.setLayout(new GridLayout(size + 1, size + 1, 5, 5));
            cellList.clear();  // Clear previous references

            JLabel zonesLabel = new JLabel("Zones", JLabel.CENTER);
            zonesLabel.setFont(new Font("Arial", Font.BOLD, 14)); 
            panelGrid.add(zonesLabel);

            for (int i = 1; i <= size; i++) {
            JLabel topLabel = new JLabel("Zone " + i, JLabel.CENTER);
            topLabel.setFont(new Font("Arial", Font.BOLD, 14));
            panelGrid.add(topLabel);
            }

            for (int i = 1; i <= size; i++) {
            JLabel leftLabel = new JLabel("Zone " + i, JLabel.CENTER);
            leftLabel.setFont(new Font("Arial", Font.BOLD, 14));
            panelGrid.add(leftLabel);

        for (int j = 1; j <= size; j++) {
            JTextField cell = new JTextField();
            cell.setHorizontalAlignment(JTextField.CENTER);
            panelGrid.add(cell);
            cellList.add(cell);
            }
    }
            panelGrid.revalidate();
            panelGrid.repaint();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a number.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed
  
    //search it
    //help
    private void drawHeatmap(Graphics g, int width, int height) {
    if (eigenvectorMatrix == null || gridSize == 0 || g == null) return;

    System.out.println("Drawing heatmap with dimensions: " + width + "x" + height);
    if (width <= 0 || height <= 0) return;

    int cellWidth = width / gridSize;
    int cellHeight = height / gridSize;

    // Find min & max eigenvector values for normalization
    double minValue = Double.MAX_VALUE;
    double maxValue = Double.MIN_VALUE;

    for (int i = 0; i < gridSize; i++) {
        for (int j = 0; j < gridSize; j++) {
            double value = eigenvectorMatrix[i][j];
            if (value < minValue) minValue = value;
            if (value > maxValue) maxValue = value;
        }
    }

    // Avoid division by zero
    if (Math.abs(maxValue - minValue) < 0.00001) {
        maxValue = minValue + 1.0;
    }

    Graphics2D g2d = (Graphics2D) g;
    Font font = new Font("Arial", Font.BOLD, 20);
    g2d.setFont(font);
    for (int i = 0; i < gridSize; i++) {
        for (int j = 0; j < gridSize; j++) {
            double value = eigenvectorMatrix[i][j];
            double normalized = (value - minValue) / (maxValue - minValue); // Normalize to 0–1

            
            float red = (float) normalized;   // More positive = more red
            float blue = (float) (1 - normalized); // More negative = more blue
            Color color = new Color(red, 0, blue);

            g2d.setColor(color);
            g2d.fillRect(j * cellWidth, i * cellHeight, cellWidth, cellHeight);

            // draw cell borders
            g2d.setColor(Color.BLACK);
            g2d.drawRect(j * cellWidth, i * cellHeight, cellWidth, cellHeight);

         
            g2d.setColor(Color.BLACK);
            String valueText = String.format("%.2f", value);
            g2d.drawString(valueText, j * cellWidth + cellWidth / 4, i * cellHeight + cellHeight / 2);
        }
    }

    //legend
    drawLegend(g2d, width, height);
}

private void drawLegend(Graphics2D g2d, int panelWidth, int panelHeight) {
    int legendWidth = 25;
    int legendHeight = 100;
    int startX = panelWidth - legendWidth - 8;
    int startY = 15;

    
    Font currentFont = g2d.getFont();

    // font for the legend text to prevent it from being affected by heatmap font
    Font legendFont = new Font("Arial", Font.PLAIN, 12);  
    g2d.setFont(legendFont);
    
    
    // Draw legend title
    g2d.setColor(Color.WHITE);
    g2d.drawString("Legend", startX - 8, startY - 5);

    // Draw gradient (Blue → Purple → Red)
    for (int i = 0; i < legendHeight; i++) {
        float ratio = (float) i / legendHeight; // Normalize from 0 to 1
        float red = ratio;   // More red for high values
        float blue = 1 - ratio; // More blue for low values
        g2d.setColor(new Color(blue, 0, red)); 
        g2d.fillRect(startX, startY + i, legendWidth, 1);
    }

    // Draw border
    g2d.setColor(Color.WHITE);
    g2d.drawRect(startX, startY, legendWidth, legendHeight);

    // labels
    g2d.drawString("High (Red)", startX - 60, startY + 10);
    // neutral is purple blue+red = purple
    g2d.drawString("Neutral", startX - 60, startY + legendHeight / 2);
    g2d.drawString("Low (Blue)", startX - 60, startY + legendHeight - 10);
}

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton OK;
    private javax.swing.JPanel eigen_panel;
    private javax.swing.JPanel eigenvectors_panel;
    private javax.swing.JPanel heatmap;
    private javax.swing.JTextField input;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JPanel panelGrid;
    private javax.swing.JPanel pollution;
    // End of variables declaration//GEN-END:variables
}
