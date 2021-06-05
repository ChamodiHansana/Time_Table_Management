/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package time_table_management.Forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import net.proteanit.sql.DbUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;
import org.jfree.data.jdbc.JDBCPieDataset;
import time_table_management.DBconnect;

/**
 *
 * @author Win 10
 */
public final class StatLecturers extends javax.swing.JFrame {

    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    
    /**
     * Creates new form StatLecturers
     */
    public StatLecturers() {
        initComponents();
        con=DBconnect.connect();
        latestLceture();
        latestSubject();
        latestLocation();
        totLceture();
        totStudent();
        totSubject();
        totLocation();
        
        
        
        
       
    }
    public void statload(){
       
        jPanel1.removeAll();
         jPanel2.removeAll();
        
          
          
        String SQL = "SELECT level ,totLec FROM lec_level";
         DefaultCategoryDataset barChartData=new DefaultCategoryDataset();
        try {
            barChartData = new JDBCCategoryDataset(con,SQL);
        } catch (SQLException ex) {
            Logger.getLogger(StatLecturers.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         JFreeChart barcht=ChartFactory.createBarChart("Number of lecturers in each Level", "levels", "Number of Lecturers", barChartData, PlotOrientation.VERTICAL, false,true,true);
         CategoryPlot p= barcht.getCategoryPlot();
         p.setRangeGridlinePaint(Color.ORANGE);
         ChartPanel myChart = new ChartPanel(barcht);
         
         jPanel1.setLayout(new java.awt.BorderLayout());
         jPanel1.add(myChart,BorderLayout.CENTER);
         //jPanel1.setSize(370, 320);
         jPanel1.validate();
         
         
         String SQL1 = "SELECT faculty ,totLec FROM lec_faculty";
         DefaultPieDataset piedata=new DefaultPieDataset();
          try {
            piedata = new JDBCPieDataset(con,SQL1);
        } catch (SQLException ex) {
            Logger.getLogger(StatLecturers.class.getName()).log(Level.SEVERE, null, ex);
        }
       
         JFreeChart piechart=ChartFactory.createPieChart("Number of lecturers in each Faculty",piedata ,true,true,true);
         
         PiePlot p1=(PiePlot)piechart.getPlot();
         PieSectionLabelGenerator lg=new StandardPieSectionLabelGenerator("{0}={1}");
         p1.setLabelGenerator(lg);
         //p1.setForegroundAlpha(TOP_ALIGNMENT);
         
         ChartPanel myChart2 = new ChartPanel(piechart);
        
         jPanel2.setLayout(new java.awt.BorderLayout());
         jPanel2.add(myChart2,BorderLayout.CENTER);
        // jPanel2.setSize(370, 320);
         jPanel2.validate();
       
        
        
    }
    
     public void totLceture(){
       
        
        try{
            
            String sql="SELECT * FROM tot_lec";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            
            while(rs.next()){
                jLabel12.setText(rs.getString("totalLec"));
            }
           
            
        }catch(Exception e){
         
        }
        
        
    } 
     
     public void totStudent(){
       
        
        try{
            
            String sql="SELECT * FROM tot_std";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            
            while(rs.next()){
                jLabel13.setText(rs.getString("totalstd)"));
            }
           
            
        }catch(Exception e){
         
        }
        
        
    } 
     
     public void totSubject(){
       
        
        try{
            
            String sql="SELECT * FROM tot_sub";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            
            while(rs.next()){
                jLabel14.setText(rs.getString("TotalSubject"));
            }
           
            
        }catch(Exception e){
         
        }
        
        
    } 
     
     public void totLocation(){
       
        
        try{
            
            String sql="SELECT * FROM tot_location";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            
            while(rs.next()){
                jLabel15.setText(rs.getString("totallocation"));
            }
           
            
        }catch(Exception e){
         
        }
        
        
    } 
     
    
    public void latestLceture(){
       
        
        try{
            
            String sql="SELECT * FROM lecturer";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            
            while(rs.next()){
                jTextField2.setText(rs.getString("name"));
            }
           
            
        }catch(Exception e){
         
        }
        
        
    } 
    
    
    
    
    
    public void latestSubject(){
       
        
        try{
            
            String sql="SELECT * FROM subject";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            
            while(rs.next()){
                jTextField3.setText(rs.getString("name"));
            }
           
            
        }catch(Exception e){
         
        }
        
        
    } 
     public void latestLocation(){
       
        
        try{
            
            String sql="SELECT * FROM locations";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            
            while(rs.next()){
                jTextField1.setText(rs.getString("roomName"));
            }
           
            
        }catch(Exception e){
         
        }
        
        
    } 
    
    
    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        panel2 = new java.awt.Panel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        panel3 = new java.awt.Panel();
        button2 = new java.awt.Button();
        jButton4 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        jLabel9.setText("Latest Lecturer:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel2.setBackground(new java.awt.Color(95, 158, 160));
        panel2.setPreferredSize(new java.awt.Dimension(1000, 100));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Time Table Generator");

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addContainerGap(421, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(373, 373, 373))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(176, 224, 230));
        jPanel6.setPreferredSize(new java.awt.Dimension(1000, 525));
        jPanel6.setRequestFocusEnabled(false);

        panel3.setBackground(new java.awt.Color(64, 224, 208));
        panel3.setPreferredSize(new java.awt.Dimension(200, 525));

        button2.setLabel("button1");

        jButton4.setBackground(new java.awt.Color(46, 139, 87));
        jButton4.setText("Session Management");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(46, 139, 87));
        jButton8.setText("Generate Table");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(46, 139, 87));
        jButton9.setText("Data Management");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(222, Short.MAX_VALUE))
        );

        jButton10.setBackground(new java.awt.Color(105, 105, 105));
        jButton10.setText("Students");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(105, 105, 105));
        jButton11.setText("Lecturers");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(105, 105, 105));
        jButton12.setText("Locations");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(169, 169, 169));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("What's new");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Latest Group:");

        jLabel5.setText("Latest Subject:");

        jLabel6.setText("Latest Lecturer:");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(338, 338, 338))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(43, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel6)
                        .addComponent(jLabel4)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 353, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );

        jLabel7.setText("Registered Lecturers=");

        jLabel8.setText("Registered Students=");

        jLabel10.setText("Registerd subjects=");

        jLabel11.setText("Registerd Locations=");

        jLabel12.setText("jLabel12");

        jLabel13.setText("jLabel13");

        jLabel14.setText("jLabel14");

        jLabel15.setText("jLabel15");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel12)
                                        .addGap(38, 38, 38)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel13))
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel14)
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel15)))))))
                .addGap(0, 49, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel12)
                    .addComponent(jLabel8)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel14)
                    .addComponent(jLabel11)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        
        
        String SQL = "SELECT academcYear ,totSTD FROM std_year";
         DefaultCategoryDataset barChartData=new DefaultCategoryDataset();
        try {
            barChartData = new JDBCCategoryDataset(con,SQL);
        } catch (SQLException ex) {
            Logger.getLogger(StatLecturers.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         JFreeChart barcht=ChartFactory.createBarChart("Number of students in each year", "year", "Number of Students", barChartData, PlotOrientation.VERTICAL, false,true,true);
         CategoryPlot p= barcht.getCategoryPlot();
         p.setRangeGridlinePaint(Color.ORANGE);
         ChartPanel myChart = new ChartPanel(barcht);
         
         jPanel1.setLayout(new java.awt.BorderLayout());
         jPanel1.add(myChart,BorderLayout.CENTER);
         //jPanel1.setSize(370, 320);
         jPanel1.validate();
         
         
         String SQL1 = "SELECT program ,totSTD FROM std_faculty";
         DefaultPieDataset piedata=new DefaultPieDataset();
          try {
            piedata = new JDBCPieDataset(con,SQL1);
        } catch (SQLException ex) {
            Logger.getLogger(StatLecturers.class.getName()).log(Level.SEVERE, null, ex);
        }
       
         JFreeChart piechart=ChartFactory.createPieChart("Number of Students in each Faculty",piedata ,true,false,true);
         
         PiePlot p1=(PiePlot)piechart.getPlot();
         //p1.setForegroundAlpha(TOP_ALIGNMENT);
          PieSectionLabelGenerator lg=new StandardPieSectionLabelGenerator("{0}={1}");
         p1.setLabelGenerator(lg);
         
         ChartPanel myChart2 = new ChartPanel(piechart);
        
         jPanel2.setLayout(new java.awt.BorderLayout());
         jPanel2.add(myChart2,BorderLayout.CENTER);
        // jPanel2.setSize(370, 320);
         jPanel2.validate();
        
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
         jPanel1.removeAll();
         jPanel2.removeAll();
        
          
          
        String SQL = "SELECT level ,totLec FROM lec_level";
         DefaultCategoryDataset barChartData=new DefaultCategoryDataset();
        try {
            barChartData = new JDBCCategoryDataset(con,SQL);
        } catch (SQLException ex) {
            Logger.getLogger(StatLecturers.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         JFreeChart barcht=ChartFactory.createBarChart("Number of lecturers in each Level", "levels", "Number of Lecturers", barChartData, PlotOrientation.VERTICAL, false,true,true);
         CategoryPlot p= barcht.getCategoryPlot();
         p.setRangeGridlinePaint(Color.ORANGE);
         ChartPanel myChart = new ChartPanel(barcht);
         
         jPanel1.setLayout(new java.awt.BorderLayout());
         jPanel1.add(myChart,BorderLayout.CENTER);
         //jPanel1.setSize(370, 320);
         jPanel1.validate();
         
         
         String SQL1 = "SELECT faculty ,totLec FROM lec_faculty";
         DefaultPieDataset piedata=new DefaultPieDataset();
          try {
            piedata = new JDBCPieDataset(con,SQL1);
        } catch (SQLException ex) {
            Logger.getLogger(StatLecturers.class.getName()).log(Level.SEVERE, null, ex);
        }
       
         JFreeChart piechart=ChartFactory.createPieChart("Number of lecturers in each Faculty",piedata ,true,true,true);
         
         PiePlot p1=(PiePlot)piechart.getPlot();
         PieSectionLabelGenerator lg=new StandardPieSectionLabelGenerator("{0}={1}");
         p1.setLabelGenerator(lg);
         //p1.setForegroundAlpha(TOP_ALIGNMENT);
         
         ChartPanel myChart2 = new ChartPanel(piechart);
        
         jPanel2.setLayout(new java.awt.BorderLayout());
         jPanel2.add(myChart2,BorderLayout.CENTER);
        // jPanel2.setSize(370, 320);
         jPanel2.validate();
        
        
    }//GEN-LAST:event_jButton11ActionPerformed
    
    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
          String SQL = "SELECT roomType ,totLoc FROM location_lablec";
         DefaultCategoryDataset barChartData=new DefaultCategoryDataset();
        try {
            barChartData = new JDBCCategoryDataset(con,SQL);
        } catch (SQLException ex) {
            Logger.getLogger(StatLecturers.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         JFreeChart barcht=ChartFactory.createBarChart("Number of labs and lecture halls", "roomtype", "Number of locations", barChartData, PlotOrientation.VERTICAL, false,true,true);
         CategoryPlot p= barcht.getCategoryPlot();
         p.setRangeGridlinePaint(Color.ORANGE);
         ChartPanel myChart = new ChartPanel(barcht);
         
         jPanel1.setLayout(new java.awt.BorderLayout());
         jPanel1.add(myChart,BorderLayout.CENTER);
         //jPanel1.setSize(370, 320);
         jPanel1.validate();
         
         
           String SQL1 = "SELECT buildName ,totLoc FROM location_builname";
         DefaultCategoryDataset barChartData1=new DefaultCategoryDataset();
        try {
            barChartData1 = new JDBCCategoryDataset(con,SQL1);
        } catch (SQLException ex) {
            Logger.getLogger(StatLecturers.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         JFreeChart barcht1=ChartFactory.createBarChart("Number of Locations in each building", "Buildings", "Number of locations", barChartData1, PlotOrientation.VERTICAL, false,true,true);
         CategoryPlot p1= barcht1.getCategoryPlot();
         p1.setRangeGridlinePaint(Color.ORANGE);
         ChartPanel myChart1 = new ChartPanel(barcht1);
         
         jPanel2.setLayout(new java.awt.BorderLayout());
         jPanel2.add(myChart1,BorderLayout.CENTER);
         //jPanel1.setSize(370, 320);
         jPanel2.validate();
     
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
         DataManagement al=new DataManagement();
        al.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         SessionManagement al=new SessionManagement();
        al.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
         GenerateTimeTableMain al=new GenerateTimeTableMain();
        al.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

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
            java.util.logging.Logger.getLogger(StatLecturers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StatLecturers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StatLecturers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StatLecturers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StatLecturers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button2;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private java.awt.Panel panel2;
    private java.awt.Panel panel3;
    // End of variables declaration//GEN-END:variables
}
