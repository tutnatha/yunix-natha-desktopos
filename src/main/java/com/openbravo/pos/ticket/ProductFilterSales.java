//    uniCenta oPOS  - Touch Friendly Point Of Sale
//    Copyright (c) 2009-2017 uniCenta
//    https://unicenta.com
//
//    This file is part of uniCenta oPOS
//
//    uniCenta oPOS is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//   uniCenta oPOS is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with uniCenta oPOS.  If not, see <http://www.gnu.org/licenses/>.

package com.openbravo.pos.ticket;

import java.util.List;
import com.openbravo.basic.BasicException;
import com.openbravo.data.gui.ComboBoxValModel;
import com.openbravo.data.gui.ListQBFModelNumber;
import com.openbravo.data.loader.QBFCompareEnum;
import com.openbravo.data.loader.SentenceList;
import com.openbravo.data.user.EditorCreator;
import com.openbravo.editor.JEditorKeys;
import com.openbravo.editor.JEditorString;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.forms.DataLogicSales;

/**
 *
 * @author JG uniCenta
 */
public class ProductFilterSales extends javax.swing.JPanel implements EditorCreator {
    
    private SentenceList m_sentcat;
    private ComboBoxValModel m_CategoryModel;
    
    /** Creates new form ProductFilterSales
     * @param dlSales
     * @param jKeys */
    public ProductFilterSales(DataLogicSales dlSales, JEditorKeys jKeys) {
        initComponents();
        
        // El modelo de categorias
        m_sentcat = dlSales.getCategoriesList();
        m_CategoryModel = new ComboBoxValModel();           
        
//        m_jCboPriceBuy.setModel(new ListQBFModelNumber());
        m_jCboPriceBuy.setModel(ListQBFModelNumber.getMandatoryNumber());
        m_jPriceBuy.addEditorKeys(jKeys);
        
//        m_jCboPriceSell.setModel(new ListQBFModelNumber());
        m_jCboPriceSell.setModel(ListQBFModelNumber.getMandatoryNumber());
        m_jPriceSell.addEditorKeys(jKeys);
        
        m_jtxtName.addEditorKeys(jKeys);
        
        m_jtxtBarCode.addEditorKeys(jKeys);
        
        m_jtxtReference.addEditorKeys(jKeys);
    }
    
    /**
     *
     */
    public void activate() {
        
        m_jtxtBarCode.reset();
        m_jtxtBarCode.setEditModeEnum(JEditorString.MODE_123);
        m_jtxtName.reset();
        m_jPriceBuy.reset();
        m_jPriceSell.reset();
        m_jtxtName.activate();
        m_jtxtReference.reset();
        
        try {
            List catlist = m_sentcat.list();
            catlist.add(0, null);
            m_CategoryModel = new ComboBoxValModel(catlist);
            m_jCategory.setModel(m_CategoryModel);
        } catch (BasicException eD) {
            // no hay validacion
        }
    }
    
    /**
     *
     * @return
     * @throws BasicException
     */
    public Object createValue() throws BasicException {
        
        Object[] afilter = new Object[12];
        
        // Nombre
        if (m_jtxtName.getText() == null || m_jtxtName.getText().equals("")) {
            afilter[0] = QBFCompareEnum.COMP_NONE;
            afilter[1] = null;
        } else {
            afilter[0] = QBFCompareEnum.COMP_RE;
            afilter[1] = "%" + m_jtxtName.getText() + "%";
        }
        
        // Precio de compra
        afilter[3] = m_jPriceBuy.getDoubleValue();
        afilter[2] = afilter[3] == null ? QBFCompareEnum.COMP_NONE : m_jCboPriceBuy.getSelectedItem();

        // Precio de venta
        afilter[5] = m_jPriceSell.getDoubleValue();
        afilter[4] = afilter[5] == null ? QBFCompareEnum.COMP_NONE : m_jCboPriceSell.getSelectedItem();
        
        // Categoria
        if (m_CategoryModel.getSelectedKey() == null) {
            afilter[6] = QBFCompareEnum.COMP_NONE;
            afilter[7] = null;
        } else {
            afilter[6] = QBFCompareEnum.COMP_EQUALS;
            afilter[7] = m_CategoryModel.getSelectedKey();
        }
        
        // el codigo de barras
        if (m_jtxtBarCode.getText() == null || m_jtxtBarCode.getText().equals("")) {
            afilter[8] = QBFCompareEnum.COMP_NONE;
            afilter[9] = null;
        } else{
            afilter[8] = QBFCompareEnum.COMP_RE;
            afilter[9] = "%" + m_jtxtBarCode.getText() + "%";
        }
        
        // el codigo de barras
        if (m_jtxtReference.getText() == null || m_jtxtReference.getText().equals("")) {
            afilter[10] = QBFCompareEnum.COMP_NONE;
            afilter[11] = null;
        }else{
            afilter[10] = QBFCompareEnum.COMP_RE;
            afilter[11] = "%" + m_jtxtReference.getText() + "%";
        }
        
        return afilter;
    } 
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        m_jtxtName = new com.openbravo.editor.JEditorString();
        jLabel2 = new javax.swing.JLabel();
        m_jCategory = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        m_jCboPriceBuy = new javax.swing.JComboBox();
        m_jPriceBuy = new com.openbravo.editor.JEditorCurrency();
        jLabel3 = new javax.swing.JLabel();
        m_jCboPriceSell = new javax.swing.JComboBox();
        m_jtxtBarCode = new com.openbravo.editor.JEditorString();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        m_jtxtReference = new com.openbravo.editor.JEditorString();
        m_jPriceSell = new com.openbravo.editor.JEditorCurrency();

        setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        setMaximumSize(new java.awt.Dimension(32767, 34767));
        setPreferredSize(new java.awt.Dimension(410, 200));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText(AppLocal.getIntString("label.prodname")); // NOI18N
        jLabel5.setPreferredSize(new java.awt.Dimension(110, 30));
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 77, -1, -1));

        m_jtxtName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m_jtxtName.setPreferredSize(new java.awt.Dimension(250, 30));
        add(m_jtxtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 78, 270, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText(AppLocal.getIntString("label.prodcategory")); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(110, 30));
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 114, -1, -1));

        m_jCategory.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m_jCategory.setPreferredSize(new java.awt.Dimension(250, 30));
        add(m_jCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 114, 240, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText(AppLocal.getIntString("label.prodpricebuy")); // NOI18N
        jLabel4.setPreferredSize(new java.awt.Dimension(110, 30));
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 149, -1, -1));

        m_jCboPriceBuy.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m_jCboPriceBuy.setPreferredSize(new java.awt.Dimension(150, 30));
        m_jCboPriceBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jCboPriceBuyActionPerformed(evt);
            }
        });
        add(m_jCboPriceBuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 149, -1, -1));

        m_jPriceBuy.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m_jPriceBuy.setPreferredSize(new java.awt.Dimension(150, 30));
        add(m_jPriceBuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 149, 119, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText(AppLocal.getIntString("label.prodpricesell")); // NOI18N
        jLabel3.setPreferredSize(new java.awt.Dimension(110, 30));
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 184, -1, -1));

        m_jCboPriceSell.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m_jCboPriceSell.setPreferredSize(new java.awt.Dimension(150, 30));
        add(m_jCboPriceSell, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 184, -1, -1));

        m_jtxtBarCode.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m_jtxtBarCode.setMaximumSize(new java.awt.Dimension(100, 25));
        m_jtxtBarCode.setPreferredSize(new java.awt.Dimension(230, 30));
        add(m_jtxtBarCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 42, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText(AppLocal.getIntString("label.prodbarcode")); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(110, 30));
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 42, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText(AppLocal.getIntString("label.prodreference")); // NOI18N
        jLabel6.setPreferredSize(new java.awt.Dimension(110, 30));
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        m_jtxtReference.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m_jtxtReference.setMaximumSize(new java.awt.Dimension(100, 25));
        m_jtxtReference.setPreferredSize(new java.awt.Dimension(230, 30));
        add(m_jtxtReference, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 6, -1, -1));

        m_jPriceSell.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m_jPriceSell.setPreferredSize(new java.awt.Dimension(150, 30));
        add(m_jPriceSell, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 120, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void m_jCboPriceBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jCboPriceBuyActionPerformed

    }//GEN-LAST:event_m_jCboPriceBuyActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JComboBox m_jCategory;
    private javax.swing.JComboBox m_jCboPriceBuy;
    private javax.swing.JComboBox m_jCboPriceSell;
    private com.openbravo.editor.JEditorCurrency m_jPriceBuy;
    private com.openbravo.editor.JEditorCurrency m_jPriceSell;
    private com.openbravo.editor.JEditorString m_jtxtBarCode;
    private com.openbravo.editor.JEditorString m_jtxtName;
    private com.openbravo.editor.JEditorString m_jtxtReference;
    // End of variables declaration//GEN-END:variables
    
}
