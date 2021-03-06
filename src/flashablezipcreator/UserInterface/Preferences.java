/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashablezipcreator.UserInterface;

import flashablezipcreator.DiskOperations.Read;
import flashablezipcreator.DiskOperations.Write;
import flashablezipcreator.Protocols.PreferenceProperties;
import flashablezipcreator.Protocols.Project;
import flashablezipcreator.Protocols.Xml;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

/**
 *
 * @author Nikhil
 */
public class Preferences extends javax.swing.JFrame {

    public static PreferenceProperties pp = new PreferenceProperties();

    Write w;
    Read r;
    public JDialog dialog;

    public Preferences() throws FileNotFoundException, ParserConfigurationException, SAXException, IOException {
        w = new Write();
        r = new Read();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() throws FileNotFoundException, ParserConfigurationException, SAXException, IOException {
        dialog = new JDialog(this, "Preferences", true);
        dialog.setResizable(false);
        MainPanel = new javax.swing.JPanel();
        panelPreferenceOptions = new javax.swing.JPanel();
        JSPPreferences = new javax.swing.JScrollPane();
        listPreferences = new javax.swing.JList<>();
        panelPreferencesDetails = new javax.swing.JPanel();
        paneGeneral = new javax.swing.JLayeredPane();
        panelGeneral = new javax.swing.JPanel();
        lblGeneralHeading = new javax.swing.JLabel();
        lblAndroidVersion = new javax.swing.JLabel();
        cbAndroidVersion = new javax.swing.JCheckBox();
        lblGeneralOptions = new javax.swing.JLabel();
        lblHoverInformation = new javax.swing.JLabel();
        lblProjectSetup = new javax.swing.JLabel();
        cbQuickSetup = new javax.swing.JCheckBox();
        lblLogging = new javax.swing.JLabel();
        cbSaveLogs = new javax.swing.JCheckBox();
        lblUpdates = new javax.swing.JLabel();
        cbUpdates = new javax.swing.JCheckBox();
        panelAroma = new javax.swing.JPanel();
        lblAromaOptions = new javax.swing.JLabel();
        lblAromaHeading = new javax.swing.JLabel();
        lblAromaHoverInformation = new javax.swing.JLabel();
        lblAromaVersion = new javax.swing.JLabel();
        cbAromaVersion = new javax.swing.JComboBox<>();
        lblZipCreatorName = new javax.swing.JLabel();
        txtZipCreatorName = new javax.swing.JTextField();
        lblZipVersion = new javax.swing.JLabel();
        txtZipVersion = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        btnOK = new javax.swing.JButton();

        File f = new File("Preferences.config");
        if (f.exists()) {
            pp.preferencesFilePresent = true;
            pp.preferencesConfig = r.getFileString("Preferences.config");
        }

        pp.themes = new ArrayList<>();
        pp.themes.add("Nikhil");
        pp.themes.add("Ics");
        pp.themes.add("RedBlack");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        MainPanel.setBackground(new java.awt.Color(255, 255, 255));
        MainPanel.setOpaque(false);

        panelPreferenceOptions.setBackground(new java.awt.Color(255, 255, 255));
        panelPreferenceOptions.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        listPreferences.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        listPreferences.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {"  General", "  Aroma"};

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
        listPreferences.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listPreferences.setFixedCellHeight(50);
        listPreferences.setSelectedIndex(0);
        listPreferences.setValueIsAdjusting(true);
        listPreferences.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                String selectedValue = listPreferences.getSelectedValue();
                switch (selectedValue) {
                    case "  General":
                        panelAroma.setVisible(false);
                        panelGeneral.setVisible(true);
                        break;
                    case "  Aroma":
                        panelGeneral.setVisible(false);
                        panelAroma.setVisible(true);
                        break;
                }
            }
        });
        JSPPreferences.setViewportView(listPreferences);

        javax.swing.GroupLayout panelPreferenceOptionsLayout = new javax.swing.GroupLayout(panelPreferenceOptions);
        panelPreferenceOptions.setLayout(panelPreferenceOptionsLayout);
        panelPreferenceOptionsLayout.setHorizontalGroup(
                panelPreferenceOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(JSPPreferences, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
        );
        panelPreferenceOptionsLayout.setVerticalGroup(
                panelPreferenceOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(JSPPreferences)
        );

        panelPreferencesDetails.setBackground(new java.awt.Color(255, 255, 255));
        panelPreferencesDetails.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        panelGeneral.setBackground(new java.awt.Color(255, 255, 255));

        lblGeneralHeading.setBackground(new java.awt.Color(204, 204, 204));
        lblGeneralHeading.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblGeneralHeading.setText("Important options for working with AFZC");

        lblAndroidVersion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblAndroidVersion.setText("Android Version");

        cbAndroidVersion.setBackground(new java.awt.Color(255, 255, 255));
        if (pp.preferencesFilePresent) {
            cbAndroidVersion.setSelected(Xml.getAndroidVersionDetail(pp.preferencesConfig));
            pp.IsFromLollipop = cbAndroidVersion.isSelected();
        } else {
            cbAndroidVersion.setSelected(true);
            pp.IsFromLollipop = true;
        }
        cbAndroidVersion.setText("Android 5.x+");
        cbAndroidVersion.setToolTipText("Enable Support for 5.x+ based Roms");

        lblGeneralOptions.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblGeneralOptions.setText("General Options");

        lblHoverInformation.setText("Hover your mouse over options to get additional info");

        lblAromaVersion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblAromaVersion.setText("Aroma Version");

        cbAromaVersion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Version 3.00b1 - MELATI", "Version 2.70 RC2 - FLAMBOYAN", "Version 2.56 - EDELWEIS"}));
        cbAromaVersion.setOpaque(false);
        cbAromaVersion.setToolTipText("Choose which Aroma Binary to use.");

        if (pp.preferencesFilePresent) {
            String av = Xml.getAromaVersion(pp.preferencesConfig);
            cbAromaVersion.setSelectedItem(av);
            pp.aromaVersion = av;
        }

        lblProjectSetup.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblProjectSetup.setText("Quick Setup");

        cbQuickSetup.setBackground(new java.awt.Color(255, 255, 255));
        if (pp.preferencesFilePresent) {
            cbQuickSetup.setSelected(Xml.getQuickSetup(pp.preferencesConfig));
            pp.isQuickSetup = cbQuickSetup.isSelected();
        } else {
            cbQuickSetup.setSelected(true);
            pp.isQuickSetup = true;
        }
        cbQuickSetup.setText("Don't show popup before adding any object");
        cbQuickSetup.setToolTipText("Enabling this will not open a detailed dialog box and create objects quickly");

        lblZipCreatorName.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblZipCreatorName.setText("Zip Creator Name");

        txtZipCreatorName.setToolTipText("This Name will reflect in Aroma as Zip Creator");
        if (pp.preferencesFilePresent) {
            txtZipCreatorName.setText(Xml.getZipCreatorName(pp.preferencesConfig));
            pp.zipCreatorName = txtZipCreatorName.getText();
        } else {
            txtZipCreatorName.setText(pp.zipCreatorName);
        }

        lblZipVersion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblZipVersion.setText("Release Version");

        txtZipVersion.setToolTipText("This Version will reflect in Aroma as Release Version");
        if (pp.preferencesFilePresent) {
            txtZipVersion.setText(Xml.getZipVersion(pp.preferencesConfig));
            pp.zipVersion = txtZipVersion.getText();
        } else {
            txtZipVersion.setText(pp.zipVersion);
        }

        lblLogging.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblLogging.setText("Logging");

        cbSaveLogs.setBackground(new java.awt.Color(255, 255, 255));
        if (pp.preferencesFilePresent) {
            cbSaveLogs.setSelected(Xml.getLogsIndicator(pp.preferencesConfig));
        }

        cbSaveLogs.setText("Save Logs");
        cbSaveLogs.setToolTipText("Enabling this will save a log file every time you use this tool");

        lblUpdates.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblUpdates.setText("Updates");
        lblUpdates.setToolTipText("Enabling this will check for updates on start of the application");

        cbUpdates.setBackground(new java.awt.Color(255, 255, 255));
        if (pp.preferencesFilePresent) {
            cbUpdates.setSelected(Xml.getCheckUpdatesIndicator(pp.preferencesConfig));
        } else {
            cbUpdates.setSelected(pp.checkUpdatesOnStartUp);
        }
        cbUpdates.setText("Check updates on startup");
        cbUpdates.setToolTipText("Enabling this will check for updates on start of the application.");

        javax.swing.GroupLayout panelGeneralLayout = new javax.swing.GroupLayout(panelGeneral);
        panelGeneral.setLayout(panelGeneralLayout);
        panelGeneralLayout.setHorizontalGroup(
                panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelGeneralLayout.createSequentialGroup()
                                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelGeneralLayout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblGeneralHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblHoverInformation)
                                                        .addComponent(lblProjectSetup, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cbQuickSetup)
                                                        .addComponent(lblAndroidVersion, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cbAndroidVersion)
                                                        .addComponent(lblLogging, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cbSaveLogs)
                                                        .addComponent(lblUpdates, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cbUpdates)))
                                        .addGroup(panelGeneralLayout.createSequentialGroup()
                                                .addGap(79, 79, 79)
                                                .addComponent(lblGeneralOptions)))
                                .addContainerGap(45, Short.MAX_VALUE))
        );
        panelGeneralLayout.setVerticalGroup(
                panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGeneralLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblGeneralOptions)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblHoverInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(lblGeneralHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblAndroidVersion, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(cbAndroidVersion)
                                .addGap(18, 18, 18)
                                .addComponent(lblLogging, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(cbSaveLogs)
                                .addGap(18, 18, 18)
                                .addComponent(lblProjectSetup, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(cbQuickSetup)
                                .addGap(18, 18, 18)
                                .addComponent(lblUpdates, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(cbUpdates)
                                .addContainerGap(52, Short.MAX_VALUE))
        );

        panelAroma.setBackground(new java.awt.Color(255, 255, 255));
        panelAroma.setPreferredSize(new java.awt.Dimension(385, 415));

        lblAromaOptions.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblAromaOptions.setText("Aroma Options");

        lblAromaHeading.setBackground(new java.awt.Color(204, 204, 204));
        lblAromaHeading.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAromaHeading.setText("Important options for working with Aroma");

        lblAromaHoverInformation.setText("Hover your mouse over options to get additional info");

        lblAromaVersion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblAromaVersion.setText("Binary Version");

        cbAromaVersion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Version 3.00b1 - MELATI", "Version 2.70 RC2 - FLAMBOYAN", "Version 2.56 - EDELWEIS"}));
        cbAromaVersion.setToolTipText("Choose which Aroma Binary to use.");
        cbAromaVersion.setOpaque(false);

        lblZipCreatorName.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblZipCreatorName.setText("Zip Creator Name");

        txtZipCreatorName.setToolTipText("This Name will reflect in Aroma as Zip Creator");

        lblZipVersion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblZipVersion.setText("Release Version");

        txtZipVersion.setToolTipText("This Version will reflect in Aroma as Release Version");

        javax.swing.GroupLayout panelAromaLayout = new javax.swing.GroupLayout(panelAroma);
        panelAroma.setLayout(panelAromaLayout);
        panelAromaLayout.setHorizontalGroup(
                panelAromaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelAromaLayout.createSequentialGroup()
                                .addGroup(panelAromaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelAromaLayout.createSequentialGroup()
                                                .addGap(79, 79, 79)
                                                .addComponent(lblAromaOptions))
                                        .addGroup(panelAromaLayout.createSequentialGroup()
                                                .addGap(37, 37, 37)
                                                .addGroup(panelAromaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblAromaHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblAromaHoverInformation)
                                                        .addComponent(lblAromaVersion, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cbAromaVersion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblZipCreatorName, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(panelAromaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(txtZipCreatorName, javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(lblZipVersion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(txtZipVersion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(44, Short.MAX_VALUE))
        );
        panelAromaLayout.setVerticalGroup(
                panelAromaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAromaLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblAromaOptions)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblAromaHoverInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(lblAromaHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(lblAromaVersion, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbAromaVersion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblZipCreatorName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtZipCreatorName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblZipVersion, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtZipVersion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(114, Short.MAX_VALUE))
        );

        panelAroma.setVisible(false);

        paneGeneral.setLayer(panelGeneral, javax.swing.JLayeredPane.DEFAULT_LAYER);
        paneGeneral.setLayer(panelAroma, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout paneGeneralLayout = new javax.swing.GroupLayout(paneGeneral);
        paneGeneral.setLayout(paneGeneralLayout);
        paneGeneralLayout.setHorizontalGroup(
                paneGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(paneGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(panelAroma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        paneGeneralLayout.setVerticalGroup(
                paneGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(paneGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(panelAroma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelPreferencesDetailsLayout = new javax.swing.GroupLayout(panelPreferencesDetails);
        panelPreferencesDetails.setLayout(panelPreferencesDetailsLayout);
        panelPreferencesDetailsLayout.setHorizontalGroup(
                panelPreferencesDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(paneGeneral)
        );
        panelPreferencesDetailsLayout.setVerticalGroup(
                panelPreferencesDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(paneGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        btnCancel.setText("Cancel");
        btnCancel.setContentAreaFilled(false);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnOK.setText("OK");
        btnOK.setContentAreaFilled(false);
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnOKActionPerformed(evt);
                } catch (ParserConfigurationException ex) {
                    Logger.getLogger(Preferences.class.getName()).log(Level.SEVERE, null, ex);
                } catch (TransformerException ex) {
                    Logger.getLogger(Preferences.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Preferences.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
                MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addGap(0, 1, Short.MAX_VALUE)
                                                .addComponent(panelPreferenceOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(panelPreferencesDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        MainPanelLayout.setVerticalGroup(
                MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(panelPreferenceOptions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(panelPreferencesDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        btnCancel.getAccessibleContext().setAccessibleName("btnPreferencesOk");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        dialog.getContentPane().add(MainPanel);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                dialog.dispose();
            }
        });
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {
        dialog.dispose();
    }

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) throws ParserConfigurationException, TransformerException, IOException {
        String xml = null;
        pp.aromaVersion = cbAromaVersion.getSelectedItem().toString();
        pp.IsFromLollipop = cbAndroidVersion.isSelected();
        pp.isQuickSetup = cbQuickSetup.isSelected();
        pp.zipCreatorName = txtZipCreatorName.getText();
        pp.checkUpdatesOnStartUp = cbUpdates.isSelected();
        Project.zipCreator = pp.zipCreatorName;
        pp.zipVersion = txtZipVersion.getText();
        Project.releaseVersion = pp.zipVersion;
        pp.saveLogs = cbSaveLogs.isSelected();
        xml = Xml.getPreferenceConfigString(pp);
        Write w = new Write();
        w.writeStringToFile(xml, "Preferences.config");
        dialog.dispose();
    }

    // Variables declaration - do not modify                     
    private javax.swing.JScrollPane JSPPreferences;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOK;
    private javax.swing.JCheckBox cbAndroidVersion;
    private javax.swing.JComboBox<String> cbAromaVersion;
    private javax.swing.JCheckBox cbQuickSetup;
    private javax.swing.JCheckBox cbSaveLogs;
    private javax.swing.JCheckBox cbUpdates;
    private javax.swing.JLabel lblAndroidVersion;
    private javax.swing.JLabel lblAromaHeading;
    private javax.swing.JLabel lblAromaHoverInformation;
    private javax.swing.JLabel lblAromaOptions;
    private javax.swing.JLabel lblAromaVersion;
    private javax.swing.JLabel lblGeneralHeading;
    private javax.swing.JLabel lblGeneralOptions;
    private javax.swing.JLabel lblHoverInformation;
    private javax.swing.JLabel lblLogging;
    private javax.swing.JLabel lblProjectSetup;
    private javax.swing.JLabel lblUpdates;
    private javax.swing.JLabel lblZipCreatorName;
    private javax.swing.JLabel lblZipVersion;
    private javax.swing.JList<String> listPreferences;
    private javax.swing.JLayeredPane paneGeneral;
    private javax.swing.JPanel panelAroma;
    private javax.swing.JPanel panelGeneral;
    private javax.swing.JPanel panelPreferenceOptions;
    private javax.swing.JPanel panelPreferencesDetails;
    private javax.swing.JTextField txtZipCreatorName;
    private javax.swing.JTextField txtZipVersion;
    // End of variables declaration                   
}
