    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     */

    package com.mycompany.ite_114_lab3;

    import org.apache.commons.math3.linear.Array2DRowRealMatrix;
    import org.apache.commons.math3.linear.EigenDecomposition;
    import org.apache.commons.math3.linear.RealMatrix;
    import org.apache.commons.math3.linear.RealVector;

    /**
     *
     * @author Chesler John  Hamili
     */
    public class Ite_114_lab3 {

        public static void main(String[] args) {
         // Step 1: Define the 3x3 pollution dispersion matrix (Barangay zones)
            double[][] pollutionMatrix = {
                {0.8, 0.1, 0.1},  // Zone A: Main road (High pollution retention)
                {0.1, 0.8, 0.1},  // Zone B: Residential area
                {0.1, 0.1, 0.8}   // Zone C: Green space (More dispersion)
            };

            // Step 2: Compute eigenvalues and eigenvectors
            RealMatrix matrix = new Array2DRowRealMatrix(pollutionMatrix);
            EigenDecomposition eigen = new EigenDecomposition(matrix);
            double[] eigenValues = eigen.getRealEigenvalues();

            System.out.println("Barangay Pollution Analysis Report");
            System.out.println("-------------------------------------------------");

            // Step 3: Display eigenvalues (How pollution persists)
            System.out.println("**Key Pollution Retention Factors (Eigenvalues):**");
            for (int i = 0; i < eigenValues.length; i++) {
                System.out.printf("   - Factor %d: %.4f\n", (i + 1), eigenValues[i]);
            }

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
                System.out.printf("   Zone A: %.4f | Zone B: %.4f | Zone C: %.4f\n",
                        eigenVector.getEntry(0), eigenVector.getEntry(1), eigenVector.getEntry(2));
            }

            // Interpretation of Eigenvectors
            System.out.println("\n**Interpretation of Pollution Distribution Patterns:**");
            System.out.println("- If the values in an eigenvector are similar, pollution spreads evenly across zones.");
            System.out.println("- Large positive or negative values indicate zones that contribute more to pollution.");
            System.out.println("- Zone A (Main Road) is expected to retain more pollution, while Zone C (Green Space) helps disperse it.");
            System.out.println("- By analyzing these patterns, the barangay can decide where to place air filters or plant trees.");

            System.out.println("-------------------------------------------------");
        }
    }

