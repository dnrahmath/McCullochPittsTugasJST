/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mccullochpittstugasjst;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Siti Fatonah
 */
public class mainPanel extends javax.swing.JFrame {

    /**
     * Creates new form mainPanel
     */
    public mainPanel() {
        initComponents();
        jCBFlag.setBackground(new Color(255, 255, 255, 255));
        jButtonInput.requestFocusInWindow();
    }
    
    void LatihFunc(int inputBobot,int inputThreshold,int[] dataInput){
        
        
        //-----------------------------------------------------------------------------
        //mengubah data input menjadi boolean
        boolean[] dataInputBoolean = new boolean[dataInput.length]; 
        for (int i = 0; i < dataInput.length; i++) {
            if(dataInput[i] == 0){
                dataInputBoolean[i] = false;
            }else {
                dataInputBoolean[i] = true;
            }
        }
         
        
        //--------------------------------------------------
        int[] dataNilaiY = new int[4];
        //mengunnakan operasi logika menentukan NilaiY
        int operationNilaiY = jCBFlag.getSelectedIndex();
        if (operationNilaiY == 0){ //AND
            for (int i = 0; i < dataNilaiY.length; i++) {
                if(dataInputBoolean[i] && dataInputBoolean[i+4]){
                    dataNilaiY[i] = 1;
                }else{
                    dataNilaiY[i] = 0;
                }
            }
        }if (operationNilaiY == 1){//OR
            for (int i = 0; i < dataNilaiY.length; i++) {
                if(dataInputBoolean[i] || dataInputBoolean[i+4]){
                    dataNilaiY[i] = 1;
                }else{
                    dataNilaiY[i] = 0;
                }
            }
        }else{//XOR
            for (int i = 0; i < dataNilaiY.length; i++) {
                if(!(dataInputBoolean[i] || dataInputBoolean[i+4])){
                    dataNilaiY[i] = 1;
                }else{
                    dataNilaiY[i] = 0;
                }
            }
        }
        
        jTNilaiYCol1.setText(String.valueOf(dataNilaiY[0]));
        jTNilaiYCol2.setText(String.valueOf(dataNilaiY[1]));
        jTNilaiYCol3.setText(String.valueOf(dataNilaiY[2]));
        jTNilaiYCol4.setText(String.valueOf(dataNilaiY[3]));
        
        
        
        
        //-----------------------------------------------------------------------------
        //menghitung menggunakan Rumus Table pelatihan 
        int[] rumusHasilPelatihan = {
            dataInput[0]*inputBobot+dataInput[4]*inputBobot,
            dataInput[1]*inputBobot+dataInput[5]*inputBobot,
            dataInput[2]*inputBobot+dataInput[6]*inputBobot,
            dataInput[3]*inputBobot+dataInput[7]*inputBobot,                   
        };
        
        
        //-----------------------------------------------------------------------------
        int[] dataKeluaran = new int[4]; 
        
        for (int i = 0; i < rumusHasilPelatihan.length; i++) {
            //output
            //menghitung menggunakan f(net)
            if(rumusHasilPelatihan[i] >= 2){
                dataKeluaran[i] = 1;
            }else if(rumusHasilPelatihan[i] < 2){ 
                dataKeluaran[i] = 0;
            }
        }
        
        
        //-----------------------------------------------------------------------------
        jTPelatihanCol1.setText(String.valueOf(rumusHasilPelatihan[0]));
        jTPelatihanCol2.setText(String.valueOf(rumusHasilPelatihan[1]));
        jTPelatihanCol3.setText(String.valueOf(rumusHasilPelatihan[2]));
        jTPelatihanCol4.setText(String.valueOf(rumusHasilPelatihan[3]));
        
        jTKeluaranCol1.setText(String.valueOf(dataKeluaran[0]));
        jTKeluaranCol2.setText(String.valueOf(dataKeluaran[1]));
        jTKeluaranCol3.setText(String.valueOf(dataKeluaran[2]));
        jTKeluaranCol4.setText(String.valueOf(dataKeluaran[3]));
        
        
        //-----------------------------------------------------------------------------
        //mengubah NilaiY dan dataKeluaran menjadi boolean
        boolean[] dataNilaiYBoolean = new boolean[dataNilaiY.length]; 
        boolean[] dataKeluaranBoolean = new boolean[dataKeluaran.length]; 
        for (int i = 0; i < dataKeluaran.length; i++) {
            if(dataKeluaran[i] == 0){
                dataNilaiYBoolean[i] = false;
                dataKeluaranBoolean[i] = false;
            }else {
                dataNilaiYBoolean[i] = true;
                dataKeluaranBoolean[i] = true;
            }
        }
        
        
        
        //-----------------------------------------------------------------------------
        //mengunnakan operasi logika menentukan NilaiY
                
        //int operationNilaiY = jCBFlag.getSelectedIndex();
        String[] NilaiHasil = new String[4];
        if (operationNilaiY == 0){ //AND
            for (int i = 0; i < NilaiHasil.length; i++) {
                if(dataNilaiYBoolean[i] && dataKeluaranBoolean[i]){
                    NilaiHasil[i] = "OK";
                }else{
                    NilaiHasil[i] = "NOT OK";
                }
            }
        }if (operationNilaiY == 1){//OR
            for (int i = 0; i < NilaiHasil.length; i++) {
                if(dataNilaiYBoolean[i] || dataKeluaranBoolean[i]){
                    NilaiHasil[i] = "OK";
                }else{
                    NilaiHasil[i] = "NOT OK";
                }
            }
        }else{//XOR
            for (int i = 0; i < NilaiHasil.length; i++) {
                if(!(dataNilaiYBoolean[i] || dataKeluaranBoolean[i])){
                    NilaiHasil[i] = "OK";
                }else{
                    NilaiHasil[i] = "NOT OK";
                }
            }
        }
        
        jTNilaiHasilCol1.setText(NilaiHasil[0]);
        jTNilaiHasilCol2.setText(NilaiHasil[1]);
        jTNilaiHasilCol3.setText(NilaiHasil[2]);
        jTNilaiHasilCol4.setText(NilaiHasil[3]);
        
        
        
        
        //-----------------------------------------------------------------------------
        
        
        
        //-----------------------------------------------------------------------------
        
        
    };
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jCBFlag = new javax.swing.JComboBox<>();
        jTFBobot = new javax.swing.JTextField();
        jTFThreshold = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTFX1Col1 = new javax.swing.JTextField();
        jTFX1Col2 = new javax.swing.JTextField();
        jTFX1Col3 = new javax.swing.JTextField();
        jTFX1Col4 = new javax.swing.JTextField();
        jTFX2Col1 = new javax.swing.JTextField();
        jTFX2Col2 = new javax.swing.JTextField();
        jTFX2Col3 = new javax.swing.JTextField();
        jTFX2Col4 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTNilaiYCol1 = new javax.swing.JTextField();
        jTNilaiYCol2 = new javax.swing.JTextField();
        jTNilaiYCol3 = new javax.swing.JTextField();
        jTNilaiYCol4 = new javax.swing.JTextField();
        jTPelatihanCol1 = new javax.swing.JTextField();
        jTPelatihanCol2 = new javax.swing.JTextField();
        jTPelatihanCol3 = new javax.swing.JTextField();
        jTPelatihanCol4 = new javax.swing.JTextField();
        jTKeluaranCol1 = new javax.swing.JTextField();
        jTKeluaranCol2 = new javax.swing.JTextField();
        jTKeluaranCol3 = new javax.swing.JTextField();
        jTKeluaranCol4 = new javax.swing.JTextField();
        jTNilaiHasilCol1 = new javax.swing.JTextField();
        jTNilaiHasilCol2 = new javax.swing.JTextField();
        jTNilaiHasilCol3 = new javax.swing.JTextField();
        jTNilaiHasilCol4 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jButtonInput = new javax.swing.JButton();
        jButtonReset = new javax.swing.JButton();
        jButtonLatih = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBackground(new java.awt.Color(255, 204, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 48)); // NOI18N
        jLabel1.setText("Mc Culloch - Pitts");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(279, 279, 279))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 204, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel2.setText("Nama  : Dwi Nanda Rahmat Herlambang");

        jLabel3.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel3.setText("NPM   : 201943501726");

        jLabel4.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel4.setText("Kelas : R8U");

        jLabel5.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel5.setText("Tugas : Jaringan Syaraf Tiruan");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(563, 563, 563))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 204, 153));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel6.setText("FLAG      :");

        jLabel7.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel7.setText("BOBOT     :");

        jLabel8.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel8.setText("THRESHOLD :");

        jCBFlag.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jCBFlag.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AND", "OR", "XOR" }));

        jTFBobot.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N

        jTFThreshold.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jCBFlag, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(447, 447, 447))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTFBobot, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(jTFThreshold))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBFlag, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFBobot, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTFThreshold, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 204, 153));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel10.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("DATA INPUT");

        jLabel12.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("X2");
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel13.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("X1");
        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTFX1Col1.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N

        jTFX1Col2.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N

        jTFX1Col3.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N

        jTFX1Col4.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N

        jTFX2Col1.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N

        jTFX2Col2.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N

        jTFX2Col3.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N

        jTFX2Col4.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTFX1Col1)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(jTFX1Col2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTFX1Col3)
                    .addComponent(jTFX1Col4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(jTFX2Col1)
                    .addComponent(jTFX2Col2)
                    .addComponent(jTFX2Col3)
                    .addComponent(jTFX2Col4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFX1Col1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFX2Col1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFX1Col2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFX2Col2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFX1Col3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFX2Col3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFX1Col4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFX2Col4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 204, 153));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel14.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("PELATIHAN");
        jLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel15.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("NILAI Y");
        jLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel16.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("NILAI HASIL");
        jLabel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel17.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("KELUARAN");
        jLabel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTNilaiYCol1.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N

        jTNilaiYCol2.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N

        jTNilaiYCol3.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N

        jTNilaiYCol4.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N

        jTPelatihanCol1.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N

        jTPelatihanCol2.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N

        jTPelatihanCol3.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N

        jTPelatihanCol4.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N

        jTKeluaranCol1.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N

        jTKeluaranCol2.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N

        jTKeluaranCol3.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N

        jTKeluaranCol4.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N

        jTNilaiHasilCol1.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N

        jTNilaiHasilCol2.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N

        jTNilaiHasilCol3.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N

        jTNilaiHasilCol4.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTNilaiYCol1)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(jTNilaiYCol2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTNilaiYCol3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTNilaiYCol4))
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTPelatihanCol1)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(jTPelatihanCol2)
                    .addComponent(jTPelatihanCol3)
                    .addComponent(jTPelatihanCol4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTKeluaranCol1)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(jTKeluaranCol2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTKeluaranCol3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTKeluaranCol4))
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTNilaiHasilCol1)
                    .addComponent(jTNilaiHasilCol2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTNilaiHasilCol3)
                    .addComponent(jTNilaiHasilCol4))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTNilaiYCol1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTPelatihanCol1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTKeluaranCol1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTNilaiHasilCol1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTNilaiYCol2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTPelatihanCol2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTKeluaranCol2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTNilaiHasilCol2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTNilaiYCol3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTPelatihanCol3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTKeluaranCol3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTNilaiHasilCol3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTNilaiYCol4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTPelatihanCol4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTKeluaranCol4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTNilaiHasilCol4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 204, 153));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButtonInput.setBackground(new java.awt.Color(255, 255, 255));
        jButtonInput.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jButtonInput.setText("INPUT");
        jButtonInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInputActionPerformed(evt);
            }
        });

        jButtonReset.setBackground(new java.awt.Color(255, 255, 255));
        jButtonReset.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jButtonReset.setText("RESET");
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });

        jButtonLatih.setBackground(new java.awt.Color(255, 255, 255));
        jButtonLatih.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jButtonLatih.setText("LATIH");
        jButtonLatih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLatihActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonLatih, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonInput, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jButtonInput, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jButtonLatih, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(156, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInputActionPerformed
        // TODO add your handling code here:
        
        //input bobot default
        jTFBobot.setText("1");
        
        //input bobot default
        jTFThreshold.setText("2");
        
        jTFX1Col1.setText("1");
        jTFX1Col2.setText("1");
        jTFX1Col3.setText("0");
        jTFX1Col4.setText("0");
        jTFX2Col1.setText("1");
        jTFX2Col2.setText("0");
        jTFX2Col3.setText("1");
        jTFX2Col4.setText("0");
    }//GEN-LAST:event_jButtonInputActionPerformed

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
        // TODO add your handling code here:
        //jCBFlag.setSelectedIndex(0);
        jTFBobot.setText("");
        jTFThreshold.setText("");
        jTFX1Col1.setText("");
        jTFX1Col2.setText("");
        jTFX1Col3.setText("");
        jTFX1Col4.setText("");
        jTFX2Col1.setText("");
        jTFX2Col2.setText("");
        jTFX2Col3.setText("");
        jTFX2Col4.setText("");
        jTNilaiYCol1.setText("");
        jTNilaiYCol2.setText("");
        jTNilaiYCol3.setText("");
        jTNilaiYCol4.setText("");
        jTPelatihanCol1.setText("");
        jTPelatihanCol2.setText("");
        jTPelatihanCol3.setText("");
        jTPelatihanCol4.setText("");
        jTKeluaranCol1.setText("");
        jTKeluaranCol2.setText("");
        jTKeluaranCol3.setText("");
        jTKeluaranCol4.setText("");
        jTNilaiHasilCol1.setText("");
        jTNilaiHasilCol2.setText("");
        jTNilaiHasilCol3.setText("");
        jTNilaiHasilCol4.setText("");
    }//GEN-LAST:event_jButtonResetActionPerformed

    private void jButtonLatihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLatihActionPerformed
        // TODO add your handling code here:
        try{
            int inputBobot = Integer.parseInt(jTFBobot.getText());
            int inputThreshold = Integer.parseInt(jTFThreshold.getText());
            int[] dataInput= {
                Integer.parseInt(jTFX1Col1.getText()),
                Integer.parseInt(jTFX1Col2.getText()),
                Integer.parseInt(jTFX1Col3.getText()),
                Integer.parseInt(jTFX1Col4.getText()),
                Integer.parseInt(jTFX2Col1.getText()),
                Integer.parseInt(jTFX2Col2.getText()),
                Integer.parseInt(jTFX2Col3.getText()),
                Integer.parseInt(jTFX2Col4.getText()),
            };
            LatihFunc(inputBobot,inputThreshold,dataInput);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(
                        null,
                        "Data Harus Berupa Angka",
                        "Message", JOptionPane.INFORMATION_MESSAGE);
        };
        
    }//GEN-LAST:event_jButtonLatihActionPerformed

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
            java.util.logging.Logger.getLogger(mainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonInput;
    private javax.swing.JButton jButtonLatih;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JComboBox<String> jCBFlag;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTextField jTFBobot;
    private javax.swing.JTextField jTFThreshold;
    private javax.swing.JTextField jTFX1Col1;
    private javax.swing.JTextField jTFX1Col2;
    private javax.swing.JTextField jTFX1Col3;
    private javax.swing.JTextField jTFX1Col4;
    private javax.swing.JTextField jTFX2Col1;
    private javax.swing.JTextField jTFX2Col2;
    private javax.swing.JTextField jTFX2Col3;
    private javax.swing.JTextField jTFX2Col4;
    private javax.swing.JTextField jTKeluaranCol1;
    private javax.swing.JTextField jTKeluaranCol2;
    private javax.swing.JTextField jTKeluaranCol3;
    private javax.swing.JTextField jTKeluaranCol4;
    private javax.swing.JTextField jTNilaiHasilCol1;
    private javax.swing.JTextField jTNilaiHasilCol2;
    private javax.swing.JTextField jTNilaiHasilCol3;
    private javax.swing.JTextField jTNilaiHasilCol4;
    private javax.swing.JTextField jTNilaiYCol1;
    private javax.swing.JTextField jTNilaiYCol2;
    private javax.swing.JTextField jTNilaiYCol3;
    private javax.swing.JTextField jTNilaiYCol4;
    private javax.swing.JTextField jTPelatihanCol1;
    private javax.swing.JTextField jTPelatihanCol2;
    private javax.swing.JTextField jTPelatihanCol3;
    private javax.swing.JTextField jTPelatihanCol4;
    // End of variables declaration//GEN-END:variables
}
