/*
<<<<<<< HEAD
 * MegaMekLab - Copyright (C) 2011
=======
 * MegaMekLab - Copyright (C) 2011-2019 The MegaMek Team
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
 *
 * Original author - jtighe (torren@users.sourceforge.net)
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 */

package megameklab.com.util;

import java.awt.Component;
import java.awt.FileDialog;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
<<<<<<< HEAD
import java.io.PrintStream;
=======
import java.io.FilenameFilter;
import java.io.PrintStream;
import java.util.ResourceBundle;
>>>>>>> 8d4751035a3393010991327be554030018ec06b8

import javax.swing.BoxLayout;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JDialog;
<<<<<<< HEAD
import javax.swing.JFileChooser;
=======
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
<<<<<<< HEAD
import javax.swing.filechooser.FileNameExtensionFilter;

import megamek.MegaMek;
import megamek.client.ui.swing.UnitLoadingDialog;
import megamek.client.ui.swing.UnitSelectorDialog;
import megamek.common.Aero;
import megamek.common.BattleArmor;
import megamek.common.Entity;
import megamek.common.FixedWingSupport;
import megamek.common.GunEmplacement;
import megamek.common.Infantry;
import megamek.common.Jumpship;
import megamek.common.Mech;
import megamek.common.MechFileParser;
import megamek.common.MechView;
import megamek.common.Protomech;
import megamek.common.SmallCraft;
import megamek.common.Tank;
import megamek.common.loaders.BLKFile;
import megamek.common.templates.TROView;
=======

import megamek.client.ui.swing.UnitLoadingDialog;
import megamek.client.ui.swing.UnitSelectorDialog;
import megamek.common.*;
import megamek.common.annotations.Nullable;
import megamek.common.loaders.BLKFile;
import megamek.common.templates.TROView;
import megamek.common.util.EncodeControl;
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
import megameklab.com.MegaMekLab;
import megameklab.com.ui.MegaMekLabMainUI;

public class MenuBarCreator extends JMenuBar implements ClipboardOwner {

<<<<<<< HEAD
    /**
     *
     */
    private static final long serialVersionUID = -3998342610654551481L;
    private JMenu file = new JMenu("File");
    private JMenu help = new JMenu("Help");
    private JMenu validate = new JMenu("Validate");
    private JMenu themeMenu = new JMenu("Themes");
    private MegaMekLabMainUI parentFrame = null;
=======
    private static final long serialVersionUID = -3998342610654551481L;
    private final JMenu themeMenu;
    private final MegaMekLabMainUI parentFrame;

    private final ResourceBundle resourceMap = ResourceBundle.getBundle("megameklab.resources.Menu", new EncodeControl());
>>>>>>> 8d4751035a3393010991327be554030018ec06b8

    public MenuBarCreator(MegaMekLabMainUI parent) {

        parentFrame = parent;

<<<<<<< HEAD
        loadFileMenuOptions();

        JMenuItem item = new JMenuItem();
        item.setText("About");
        item.setMnemonic(KeyEvent.VK_A);
        item.addActionListener(e -> jMenuHelpAbout_actionPerformed());
        help.add(item);

        item = new JMenuItem();
        item.setText("Record Sheet Images");
=======
        themeMenu = createThemeMenu();
        JMenu fileMenu = createFileMenu();

        JMenuItem item = new JMenuItem();
        item.setText(resourceMap.getString("menu.help.about"));
        item.setMnemonic(KeyEvent.VK_A);
        item.addActionListener(e -> jMenuHelpAbout_actionPerformed());
        JMenu help = new JMenu(resourceMap.getString("menu.help"));
        help.add(item);

        item = new JMenuItem();
        item.setText(resourceMap.getString("menu.help.recordSheetImages"));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
        item.setMnemonic(KeyEvent.VK_R);
        item.addActionListener(e -> jMenuHelpFluff_actionPerformed());
        help.add(item);

        item = new JMenuItem();
<<<<<<< HEAD
        item.setText("Insert Image To File");
=======
        item.setText(resourceMap.getString("menu.help.insertImage"));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
        item.setMnemonic(KeyEvent.VK_I);
        item.addActionListener(e -> jMenuInsertImageFile_actionPerformed());
        help.add(item);

<<<<<<< HEAD
=======
        JMenu validate = new JMenu(resourceMap.getString("menu.validate"));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
        validate.add(loadBVMenuOptions());

        validate.add(loadValidateMenuOptions());

        validate.add(loadSpecsMenuOptions());

        validate.add(loadUnitCostBreakdownMenuOptions());
        
        validate.add(loadUnitWeightBreakdownMenuOptions());

<<<<<<< HEAD
        this.add(file);
=======
        this.add(fileMenu);
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
        this.add(validate);
        this.add(help);

    }

    private JMenu loadBVMenuOptions() {
<<<<<<< HEAD
        JMenu bv = new JMenu("BV Calculations");
        JMenuItem item = new JMenuItem();
        item.setText("Current Units BV Calculations");
=======
        JMenu bv = new JMenu(resourceMap.getString("menu.validate.bv"));
        JMenuItem item = new JMenuItem();
        item.setText(resourceMap.getString("menu.validate.bv.currentUnit"));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
        item.setMnemonic(KeyEvent.VK_B);
        item.addActionListener(e -> jMenuBVCalculations_actionPerformed());
        bv.add(item);

        item = new JMenuItem();
<<<<<<< HEAD
        item.setText("BV Calculations From File");
=======
        item.setText(resourceMap.getString("menu.validate.bv.fromFile"));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
        item.setMnemonic(KeyEvent.VK_F);
        item.addActionListener(e -> jMenuGetUnitBVFromFile_actionPerformed());
        bv.add(item);

        item = new JMenuItem();
<<<<<<< HEAD
        item.setText("BV Calculations From Cache");
=======
        item.setText(resourceMap.getString("menu.validate.bv.fromCache"));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
        item.setMnemonic(KeyEvent.VK_C);
        item.addActionListener(e -> jMenuGetUnitBVFromCache_actionPerformed());
        bv.add(item);
        return bv;
    }

    private JMenu loadValidateMenuOptions() {
<<<<<<< HEAD
        JMenu entityValidation = new JMenu("Unit Validation");
        JMenuItem item = new JMenuItem();
        item.setText("Validate Current Unit");
=======
        JMenu entityValidation = new JMenu(resourceMap.getString("menu.validate"));
        JMenuItem item = new JMenuItem();
        item.setText(resourceMap.getString("menu.validate.currentUnit"));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
        item.setMnemonic(KeyEvent.VK_V);
        item.addActionListener(e -> jMenuValidateUnit_actionPerformed());
        entityValidation.add(item);

        item = new JMenuItem();
<<<<<<< HEAD
        item.setText("Validate Unit From File");
=======
        item.setText(resourceMap.getString("menu.validate.fromFile"));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
        item.setMnemonic(KeyEvent.VK_F);
        item.addActionListener(e -> jMenuGetUnitValidationFromFile_actionPerformed());
        entityValidation.add(item);

        item = new JMenuItem();
<<<<<<< HEAD
        item.setText("Validate Unit From Cache");
=======
        item.setText(resourceMap.getString("menu.validate.fromCache"));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
        item.setMnemonic(KeyEvent.VK_C);
        item.addActionListener(e -> jMenuGetUnitValidationFromCache_actionPerformed());
        entityValidation.add(item);
        return entityValidation;
    }

    private JMenu loadUnitCostBreakdownMenuOptions() {
<<<<<<< HEAD
        JMenu entityBreakdown = new JMenu("Unit Cost Breakdown");
        JMenuItem item = new JMenuItem();
        item.setText("Breakdown Current Unit");
=======
        JMenu entityBreakdown = new JMenu(resourceMap.getString("menu.validate.cost"));
        JMenuItem item = new JMenuItem();
        item.setText(resourceMap.getString("menu.validate.cost.currentUnit"));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
        item.setMnemonic(KeyEvent.VK_V);
        item.addActionListener(e -> jMenuUnitCostBreakdown_actionPerformed());
        entityBreakdown.add(item);

        item = new JMenuItem();
<<<<<<< HEAD
        item.setText("Unit Breakdown From File");
=======
        item.setText(resourceMap.getString("menu.validate.cost.fromFile"));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
        item.setMnemonic(KeyEvent.VK_F);
        item.addActionListener(e -> jMenuGetUnitBreakdownFromFile_actionPerformed());
        entityBreakdown.add(item);

        item = new JMenuItem();
<<<<<<< HEAD
        item.setText("Unit Breakdown From Cache");
=======
        item.setText(resourceMap.getString("menu.validate.cost.fromCache"));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
        item.setMnemonic(KeyEvent.VK_C);
        item.addActionListener(e -> jMenuGetUnitBreakdownFromCache_actionPerformed());
        entityBreakdown.add(item);
        return entityBreakdown;
    }
    
    private JMenu loadUnitWeightBreakdownMenuOptions() {
<<<<<<< HEAD
        JMenu entityBreakdown = new JMenu("Unit Weight Breakdown");
        JMenuItem item = new JMenuItem();
        item.setText("Breakdown Current Unit");
=======
        JMenu entityBreakdown = new JMenu(resourceMap.getString("menu.validate.weight"));
        JMenuItem item = new JMenuItem();
        item.setText(resourceMap.getString("menu.validate.weight.currentUnit"));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
        item.addActionListener(e -> jMenuUnitWeightBreakdown_actionPerformed());
        entityBreakdown.add(item);

        item = new JMenuItem();
<<<<<<< HEAD
        item.setText("Unit Breakdown From File");
=======
        item.setText(resourceMap.getString("menu.validate.weight.fromFile"));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
        item.addActionListener(e -> jMenuGetUnitWeightBreakdownFromFile_actionPerformed());
        entityBreakdown.add(item);

        item = new JMenuItem();
<<<<<<< HEAD
        item.setText("Unit Breakdown From Cache");
=======
        item.setText(resourceMap.getString("menu.validate.weight.fromCache"));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
        item.addActionListener(e -> jMenuGetUnitWeightBreakdownFromCache_actionPerformed());
        entityBreakdown.add(item);
        return entityBreakdown;
    }

    private JMenu loadSpecsMenuOptions() {
<<<<<<< HEAD
        JMenu unitSpecs = new JMenu("Unit Specs");
        JMenuItem item = new JMenuItem();
        item.setText("Current Unit Specs");
=======
        JMenu unitSpecs = new JMenu(resourceMap.getString("menu.validate.specs"));
        JMenuItem item = new JMenuItem();
        item.setText(resourceMap.getString("menu.validate.specs.currentUnit"));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
        item.setMnemonic(KeyEvent.VK_V);
        item.addActionListener(e -> jMenuUnitSpecs_actionPerformed());
        unitSpecs.add(item);

        item = new JMenuItem();
<<<<<<< HEAD
        item.setText("Unit Specs From File");
=======
        item.setText(resourceMap.getString("menu.validate.specs.fromFile"));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
        item.setMnemonic(KeyEvent.VK_F);
        item.addActionListener(e -> jMenuGetUnitSpecsFromFile_actionPerformed());
        unitSpecs.add(item);

        item = new JMenuItem();
<<<<<<< HEAD
        item.setText("Unit Specs From Cache");
=======
        item.setText(resourceMap.getString("menu.validate.specs.fromCache"));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
        item.setMnemonic(KeyEvent.VK_C);
        item.addActionListener(e -> jMenuGetUnitSpecsFromCache_actionPerformed());
        unitSpecs.add(item);
        return unitSpecs;
    }

<<<<<<< HEAD
    private void loadFileMenuOptions() {

        file.removeAll();

        file.setMnemonic(KeyEvent.VK_F);
        JMenuItem item = new JMenuItem();

        item = new JMenuItem("Reset Current Unit");
        item.setMnemonic(KeyEvent.VK_R);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        item.addActionListener(e -> jMenuResetEntity_actionPerformed(e));
        file.add(item);

        JMenu unitMenu = new JMenu("Switch Unit Type");
=======
    private JMenu createFileMenu() {
        JMenu fileMenu = new JMenu(resourceMap.getString("menu.file"));

        fileMenu.setMnemonic(KeyEvent.VK_F);
        JMenuItem item = new JMenuItem(resourceMap.getString("menu.file.resetCurrentUnit"));
        item.setMnemonic(KeyEvent.VK_R);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        item.addActionListener(this::jMenuResetEntity_actionPerformed);
        fileMenu.add(item);

        JMenu unitMenu = new JMenu(resourceMap.getString("menu.file.switchUnitType"));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
        unitMenu.setMnemonic(KeyEvent.VK_S);
        Entity en = parentFrame.getEntity();

        if (!(en instanceof Mech)
                || ((Mech)en).isPrimitive()) {
            item = new JMenuItem();
<<<<<<< HEAD
            item.setText("Mech");
=======
            item.setText(resourceMap.getString("menu.file.unitType.mech"));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
            item.setMnemonic(KeyEvent.VK_M);
            item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,
                    Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
            item.addActionListener(e -> jMenuLoadMech());
            unitMenu.add(item);
        }

<<<<<<< HEAD
        if (!(en.isFighter()
                || (en.isFighter() && ((Aero)en).isPrimitive()))) {
            item = new JMenuItem();
            item.setText("Aero/Conv Fighter");
=======
        if (!en.isFighter()
                || ((en instanceof Aero) && ((Aero)en).isPrimitive())) {
            item = new JMenuItem();
            item.setText(resourceMap.getString("menu.file.unitType.fighter"));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
            item.setMnemonic(KeyEvent.VK_A);
            item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
                    Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
            item.addActionListener(e -> jMenuLoadAero());
            unitMenu.add(item);
        }

        if (!(en instanceof SmallCraft)
                || ((Aero)en).isPrimitive()) {
            item = new JMenuItem();
<<<<<<< HEAD
            item.setText("Dropship/Small Craft");
=======
            item.setText(resourceMap.getString("menu.file.unitType.dropshipSmallCraft"));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
            item.setMnemonic(KeyEvent.VK_D);
            item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,
                    Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
            item.addActionListener(e -> jMenuLoadDropship());
            unitMenu.add(item);
        }

        if (!(en instanceof Jumpship)
                || ((Aero)en).isPrimitive()) {
            item = new JMenuItem();
<<<<<<< HEAD
            item.setText("Jumpship/Warship/Space Station");
=======
            item.setText(resourceMap.getString("menu.file.unitType.advancedAero"));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
            item.setMnemonic(KeyEvent.VK_J);
            item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J,
                    Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
            item.addActionListener(e -> jMenuLoadAdvAero());
            unitMenu.add(item);
        }

<<<<<<< HEAD
        if (!(parentFrame.getEntity() instanceof Tank)) {
            item = new JMenuItem();
            item.setText("Combat Vehicle");
=======
        if (!(parentFrame.getEntity() instanceof Tank)
                || parentFrame.getEntity().isSupportVehicle()) {
            item = new JMenuItem();
            item.setText(resourceMap.getString("menu.file.unitType.combatVehicle"));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
            item.setMnemonic(KeyEvent.VK_T);
            item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,
                    Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
            item.addActionListener(e -> jMenuLoadVehicle());
            unitMenu.add(item);
        }

<<<<<<< HEAD
        if (!(parentFrame.getEntity() instanceof BattleArmor)) {
            item = new JMenuItem();
            item.setText("BattleArmor");
=======
        if (!parentFrame.getEntity().isSupportVehicle()) {
            item = new JMenuItem();
            item.setText("Support Vehicle");
            item.addActionListener(e -> jMenuLoadSupportVehicle());
            unitMenu.add(item);
        }

        if (!(parentFrame.getEntity() instanceof BattleArmor)) {
            item = new JMenuItem();
            item.setText(resourceMap.getString("menu.file.unitType.battleArmor"));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
            item.setMnemonic(KeyEvent.VK_B);
            item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,
                    Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
            item.addActionListener(e -> jMenuLoadBattleArmor());
            unitMenu.add(item);
        }

        if (!(parentFrame.getEntity() instanceof Infantry) || (parentFrame.getEntity() instanceof BattleArmor)) {
            item = new JMenuItem();
<<<<<<< HEAD
            item.setText("Infantry");
=======
            item.setText(resourceMap.getString("menu.file.unitType.infantry"));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
            item.setMnemonic(KeyEvent.VK_I);
            item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,
                    Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
            item.addActionListener(e -> jMenuLoadInfantry());
            unitMenu.add(item);
        }
        
        if (!parentFrame.getEntity().hasETypeFlag(Entity.ETYPE_PROTOMECH)) {
            item = new JMenuItem();
<<<<<<< HEAD
            item.setText("Protomech");
=======
            item.setText(resourceMap.getString("menu.file.unitType.protomech"));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
            item.setMnemonic(KeyEvent.VK_P);
            item.addActionListener(ev -> jMenuLoadProtomech());
            unitMenu.add(item);
        }

<<<<<<< HEAD
        JMenu pMenu = new JMenu("Primitive/Retro");
        if (!(en instanceof Mech)
                || !((Mech)en).isPrimitive()) {
            item = new JMenuItem();
            item.setText("Mech");
=======
        JMenu pMenu = new JMenu(resourceMap.getString("menu.file.unitType.primitive"));
        if (!(en instanceof Mech)
                || !((Mech)en).isPrimitive()) {
            item = new JMenuItem();
            item.setText(resourceMap.getString("menu.file.unitType.mech"));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
            item.addActionListener(e ->jMenuLoadPrimitiveMech());
            pMenu.add(item);
        }
        
        if (!(en.isFighter())
<<<<<<< HEAD
                || !((Aero)en).isPrimitive()) {
            item = new JMenuItem();
            item.setText("Aero");
=======
                || (en instanceof Aero && !((Aero)en).isPrimitive())) {
            item = new JMenuItem();
            item.setText(resourceMap.getString("menu.file.unitType.aero"));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
            item.addActionListener(e ->jMenuLoadPrimitiveAero());
            pMenu.add(item);
        }
        
<<<<<<< HEAD
        if (!(en.hasETypeFlag(Entity.ETYPE_SMALL_CRAFT))
                || !((Aero)en).isPrimitive()) {
            item = new JMenuItem();
            item.setText("Dropship/Small Craft");
=======
        if (!(en instanceof SmallCraft)
                || !((Aero)en).isPrimitive()) {
            item = new JMenuItem();
            item.setText(resourceMap.getString("menu.file.unitType.dropshipSmallCraft"));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
            item.addActionListener(e ->jMenuLoadPrimitiveDropship());
            pMenu.add(item);
        }
        
<<<<<<< HEAD
        if (!(en.hasETypeFlag(Entity.ETYPE_JUMPSHIP))
                || !((Aero)en).isPrimitive()) {
            item = new JMenuItem();
            item.setText("Jumpship");
=======
        if (!(en instanceof Jumpship)
                || !((Aero)en).isPrimitive()) {
            item = new JMenuItem();
            item.setText(resourceMap.getString("menu.file.unitType.jumpship"));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
            item.addActionListener(e ->jMenuLoadPrimitiveJumpship());
            pMenu.add(item);
        }
        
        unitMenu.add(pMenu);

<<<<<<< HEAD
        file.add(unitMenu);

        JMenu loadMenu = new JMenu("Load");
        loadMenu.setMnemonic(KeyEvent.VK_L);
        item = new JMenuItem();

        item.setText("From Cache");
        item.setMnemonic(KeyEvent.VK_C);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        item.addActionListener(e -> jMenuLoadEntity_actionPerformed(e));
        loadMenu.add(item);

        item = new JMenuItem();
        item.setText("From File");
        item.setMnemonic(KeyEvent.VK_F);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        item.addActionListener(e -> jMenuLoadEntityFromFile_actionPerformed(e));
        loadMenu.add(item);

        file.add(loadMenu);

        item = new JMenuItem(String.format("Current Unit"));
=======
        fileMenu.add(unitMenu);

        JMenu loadMenu = new JMenu(resourceMap.getString("menu.file.load"));
        loadMenu.setMnemonic(KeyEvent.VK_L);
        item = new JMenuItem();

        item.setText(resourceMap.getString("menu.file.load.fromCache"));
        item.setMnemonic(KeyEvent.VK_C);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        item.addActionListener(this::jMenuLoadEntity_actionPerformed);
        loadMenu.add(item);

        item = new JMenuItem();
        item.setText(resourceMap.getString("menu.file.load.fromFile"));
        item.setMnemonic(KeyEvent.VK_F);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        item.addActionListener(this::jMenuLoadEntityFromFile_actionPerformed);
        loadMenu.add(item);

        fileMenu.add(loadMenu);

        item = new JMenuItem(resourceMap.getString("menu.file.print.currentUnit"));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        item.setMnemonic(KeyEvent.VK_C);
        item.addActionListener(e -> jMenuPrintCurrentUnit());

<<<<<<< HEAD
        file.add(UnitPrintManager.printMenu(parentFrame, item));

        item = new JMenuItem();
        item.setText("Save");
        item.setMnemonic(KeyEvent.VK_S);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        item.addActionListener(e -> jMenuSaveEntity_actionPerformed(e));
        file.add(item);

        item = new JMenuItem();
        item.setText("Save As");
        item.setMnemonic(KeyEvent.VK_A);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        item.addActionListener(e -> jMenuSaveAsEntity_actionPerformed(e));
        file.add(item);

        JMenu exportMenu = new JMenu("Export");
        
        item = new JMenuItem("to HTML");
        item.addActionListener(e -> exportSummary(true));
        exportMenu.add(item);

        item = new JMenuItem("to Text");
        item.addActionListener(e -> exportSummary(false));
        exportMenu.add(item);

        item = new JMenuItem("to Clipboard (text)");
        item.addActionListener(e -> exportSummaryClipboard());
        exportMenu.add(item);

        file.add(exportMenu);
        
        JMenu themeMenu = createThemeMenu();
        file.add(themeMenu);

        item = new JMenuItem("Configuration");
        item.setMnemonic(KeyEvent.VK_C);
        item.addActionListener(e -> jMenuConfiguration_actionPerformed(e));
        file.add(item);

        int fileNumber = 1;
        if (CConfig.getParam(CConfig.CONFIG_SAVE_FILE_1).length() > 1) {
            file.addSeparator();
=======
        fileMenu.add(UnitPrintManager.printMenu(parentFrame, item));

        item = new JMenuItem();
        item.setText(resourceMap.getString("menu.file.save"));
        item.setMnemonic(KeyEvent.VK_S);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        item.addActionListener(this::jMenuSaveEntity_actionPerformed);
        fileMenu.add(item);

        item = new JMenuItem();
        item.setText(resourceMap.getString("menu.file.saveAs"));
        item.setMnemonic(KeyEvent.VK_A);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        item.addActionListener(this::jMenuSaveAsEntity_actionPerformed);
        fileMenu.add(item);

        JMenu exportMenu = new JMenu(resourceMap.getString("menu.file.export"));
        
        item = new JMenuItem(resourceMap.getString("menu.file.export.toHTML"));
        item.addActionListener(e -> exportSummary(true));
        exportMenu.add(item);

        item = new JMenuItem(resourceMap.getString("menu.file.export.toText"));
        item.addActionListener(e -> exportSummary(false));
        exportMenu.add(item);

        item = new JMenuItem(resourceMap.getString("menu.file.export.toClipboard"));
        item.addActionListener(e -> exportSummaryClipboard());
        exportMenu.add(item);

        fileMenu.add(exportMenu);
        
        fileMenu.add(themeMenu);

        item = new JMenuItem(resourceMap.getString("menu.file.configuration"));
        item.setMnemonic(KeyEvent.VK_C);
        item.addActionListener(this::jMenuConfiguration_actionPerformed);
        fileMenu.add(item);

        int fileNumber = 1;
        if (CConfig.getParam(CConfig.CONFIG_SAVE_FILE_1).length() > 1) {
            fileMenu.addSeparator();
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
            item = new JMenuItem();
            String newFile = CConfig.getParam(CConfig.CONFIG_SAVE_FILE_1);
            if (newFile.length() > 35) {
                item.setText(fileNumber + ". .." + newFile.substring(newFile.length() - 36));
            } else {
                item.setText(fileNumber + ". " + newFile);
            }
            item.setMnemonic(fileNumber);
            item.addActionListener(e -> jMenuLoadEntityFromFile_actionPerformed(1));

<<<<<<< HEAD
            file.add(item);
=======
            fileMenu.add(item);
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
            fileNumber++;
        }

        if (CConfig.getParam(CConfig.CONFIG_SAVE_FILE_2).length() > 1) {
            item = new JMenuItem();
            String newFile = CConfig.getParam(CConfig.CONFIG_SAVE_FILE_2);
            if (newFile.length() > 35) {
                item.setText(fileNumber + ". .." + newFile.substring(newFile.length() - 36));
            } else {
                item.setText(fileNumber + ". " + newFile);
            }
            item.setMnemonic(fileNumber);
            item.addActionListener(e -> jMenuLoadEntityFromFile_actionPerformed(2));

<<<<<<< HEAD
            file.add(item);
=======
            fileMenu.add(item);
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
            fileNumber++;
        }

        if (CConfig.getParam(CConfig.CONFIG_SAVE_FILE_3).length() > 1) {
            item = new JMenuItem();
            String newFile = CConfig.getParam(CConfig.CONFIG_SAVE_FILE_3);
            if (newFile.length() > 35) {
                item.setText(fileNumber + ". .." + newFile.substring(newFile.length() - 36));
            } else {
                item.setText(fileNumber + ". " + newFile);
            }
            item.setMnemonic(fileNumber);
            item.addActionListener(e -> jMenuLoadEntityFromFile_actionPerformed(3));

<<<<<<< HEAD
            file.add(item);
=======
            fileMenu.add(item);
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
            fileNumber++;
        }

        if (CConfig.getParam(CConfig.CONFIG_SAVE_FILE_4).length() > 1) {
            item = new JMenuItem();
            String newFile = CConfig.getParam(CConfig.CONFIG_SAVE_FILE_4);
            if (newFile.length() > 35) {
                item.setText(fileNumber + ". .." + newFile.substring(newFile.length() - 36));
            } else {
                item.setText(fileNumber + ". " + newFile);
            }
            item.setMnemonic(fileNumber);
            item.addActionListener(e -> jMenuLoadEntityFromFile_actionPerformed(4));

<<<<<<< HEAD
            file.add(item);
            fileNumber++;
        }

        file.addSeparator();

        item = new JMenuItem();
        item.setText("Exit");
        item.setMnemonic(KeyEvent.VK_X);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        item.addActionListener(ev -> parentFrame.exit());
        file.add(item);

=======
            fileMenu.add(item);
        }

        fileMenu.addSeparator();

        item = new JMenuItem();
        item.setText(resourceMap.getString("menu.file.exit"));
        item.setMnemonic(KeyEvent.VK_X);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        item.addActionListener(ev -> parentFrame.exit());
        fileMenu.add(item);

        return fileMenu;
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
    }
    
    /**
     * Creates a menu that includes all installed look and feel options
     * 
     * @return The new menu
     */
    private JMenu createThemeMenu() {
<<<<<<< HEAD
        themeMenu = new JMenu("Themes");
=======
        JMenu menu = new JMenu(resourceMap.getString("menu.file.themes"));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
        JCheckBoxMenuItem item;
        for (LookAndFeelInfo plaf : UIManager.getInstalledLookAndFeels()) {
            item = new JCheckBoxMenuItem(plaf.getName());
            if (plaf.getName().equalsIgnoreCase(
                    UIManager.getLookAndFeel().getName())) {
                item.setSelected(true);
            }
<<<<<<< HEAD
            themeMenu.add(item);
=======
            menu.add(item);
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
            item.addActionListener(ev -> {
                parentFrame.changeTheme(plaf);
                refreshThemeMenu(plaf.getName());
            });
        }
<<<<<<< HEAD
        return themeMenu;
=======
        return menu;
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
    }
    
    /**
     * Updates the checkbox items on the theme menu to show which is currently selected.
     * 
     * @param currentThemeName The name returned by {@link LookAndFeelInfo#getName()}
     */
    private void refreshThemeMenu(String currentThemeName) {
        for (int i = 0; i < themeMenu.getItemCount(); i++) {
            final JMenuItem item = themeMenu.getItem(i);
            if (item instanceof JCheckBoxMenuItem) {
<<<<<<< HEAD
                ((JCheckBoxMenuItem) item).setSelected(item.getText().equals(currentThemeName));
=======
                item.setSelected(item.getText().equals(currentThemeName));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
            }
        }
    }

    private void jMenuGetUnitBVFromCache_actionPerformed() {
        UnitLoadingDialog unitLoadingDialog = new UnitLoadingDialog(parentFrame);
        unitLoadingDialog.setVisible(true);
        UnitSelectorDialog viewer = new UnitSelectorDialog(parentFrame, unitLoadingDialog, true);

        Entity tempEntity = viewer.getChosenEntity();
        if(null == tempEntity) {
            return;
        }
        tempEntity.calculateBattleValue(true, true);
        UnitUtil.showBVCalculations(tempEntity.getBVText(), parentFrame);

    }

    private void jMenuGetUnitValidationFromCache_actionPerformed() {
        UnitLoadingDialog unitLoadingDialog = new UnitLoadingDialog(parentFrame);
        unitLoadingDialog.setVisible(true);
        UnitSelectorDialog viewer = new UnitSelectorDialog(parentFrame, unitLoadingDialog, true);

        Entity tempEntity = viewer.getChosenEntity();
        if(null == tempEntity) {
            return;
        }
        UnitUtil.showValidation(tempEntity, parentFrame);

    }

    private void jMenuGetUnitSpecsFromCache_actionPerformed() {
        UnitLoadingDialog unitLoadingDialog = new UnitLoadingDialog(parentFrame);
        unitLoadingDialog.setVisible(true);
        UnitSelectorDialog viewer = new UnitSelectorDialog(parentFrame, unitLoadingDialog, true);

        Entity tempEntity = viewer.getChosenEntity();
        if(null == tempEntity) {
            return;
        }
        UnitUtil.showUnitSpecs(tempEntity, parentFrame);

    }

    private void jMenuGetUnitBreakdownFromCache_actionPerformed() {
        UnitLoadingDialog unitLoadingDialog = new UnitLoadingDialog(parentFrame);
        unitLoadingDialog.setVisible(true);
        UnitSelectorDialog viewer = new UnitSelectorDialog(parentFrame, unitLoadingDialog, true);

        Entity tempEntity = viewer.getChosenEntity();
        if(null == tempEntity) {
            return;
        }
        UnitUtil.showUnitCostBreakDown(tempEntity, parentFrame);

    }
    
    private void jMenuGetUnitWeightBreakdownFromCache_actionPerformed() {
        UnitLoadingDialog unitLoadingDialog = new UnitLoadingDialog(parentFrame);
        unitLoadingDialog.setVisible(true);
        UnitSelectorDialog viewer = new UnitSelectorDialog(parentFrame, unitLoadingDialog, true);

        Entity tempEntity = viewer.getChosenEntity();
        if(null == tempEntity) {
            return;
        }
        UnitUtil.showUnitWeightBreakDown(tempEntity, parentFrame);

    }

    private void jMenuGetUnitBVFromFile_actionPerformed() {
<<<<<<< HEAD

        Entity tempEntity = null;
        String filePathName = System.getProperty("user.dir").toString() + "/data/mechfiles/";
        File unitFile = new File(filePathName);
        JFileChooser f = new JFileChooser(filePathName);
        f.setLocation(parentFrame.getLocation().x + 150, parentFrame.getLocation().y + 100);
        f.setDialogTitle("Choose Unit");
        f.setDialogType(JFileChooser.OPEN_DIALOG);
        f.setMultiSelectionEnabled(false);

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Unit Files", "blk", "mtf", "hmp");

        // Add a filter for mul files
        f.setFileFilter(filter);

        int returnVal = f.showOpenDialog(parentFrame);
        if ((returnVal != JFileChooser.APPROVE_OPTION) || (f.getSelectedFile() == null)) {
            // I want a file, y'know!
            return;
        }
        unitFile = f.getSelectedFile();

        try {
            tempEntity = new MechFileParser(unitFile).getEntity();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(parentFrame, String.format("Warning:Invalid unit, it might load incorrectly!\n%1$s", ex.getMessage()));
        } finally {
            tempEntity.calculateBattleValue(true, true);
            UnitUtil.showBVCalculations(tempEntity.getBVText(), parentFrame);
=======
        File unitFile = loadUnitFile();
        if (unitFile == null) {
            return;
        }

        try {
            Entity tempEntity = new MechFileParser(unitFile).getEntity();
            tempEntity.calculateBattleValue(true, true);
            UnitUtil.showBVCalculations(tempEntity.getBVText(), parentFrame);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(parentFrame,
                    String.format(resourceMap.getString("message.invalidUnit.format"),
                            ex.getMessage()));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
        }

    }

    private void jMenuGetUnitValidationFromFile_actionPerformed() {
<<<<<<< HEAD

        Entity tempEntity = null;
        String filePathName = System.getProperty("user.dir").toString() + "/data/mechfiles/";
        File unitFile = new File(filePathName);
        JFileChooser f = new JFileChooser(filePathName);
        f.setLocation(parentFrame.getLocation().x + 150, parentFrame.getLocation().y + 100);
        f.setDialogTitle("Choose Unit");
        f.setDialogType(JFileChooser.OPEN_DIALOG);
        f.setMultiSelectionEnabled(false);

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Unit Files", "blk", "mtf", "hmp");

        // Add a filter for mul files
        f.setFileFilter(filter);

        int returnVal = f.showOpenDialog(parentFrame);
        if ((returnVal != JFileChooser.APPROVE_OPTION) || (f.getSelectedFile() == null)) {
            // I want a file, y'know!
            return;
        }
        unitFile = f.getSelectedFile();

        try {
            tempEntity = new MechFileParser(unitFile).getEntity();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(parentFrame, String.format("Warning:Invalid unit, it might load incorrectly!\n%1$s", ex.getMessage()));
        } finally {
            UnitUtil.showValidation(tempEntity, parentFrame);
        }
    }

    private void jMenuGetUnitBreakdownFromFile_actionPerformed() {

        Entity tempEntity = null;
        String filePathName = System.getProperty("user.dir").toString() + "/data/mechfiles/";
        File unitFile = new File(filePathName);
        JFileChooser f = new JFileChooser(filePathName);
        f.setLocation(parentFrame.getLocation().x + 150, parentFrame.getLocation().y + 100);
        f.setDialogTitle("Choose Unit");
        f.setDialogType(JFileChooser.OPEN_DIALOG);
        f.setMultiSelectionEnabled(false);

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Unit Files", "blk", "mtf", "hmp");

        // Add a filter for mul files
        f.setFileFilter(filter);

        int returnVal = f.showOpenDialog(parentFrame);
        if ((returnVal != JFileChooser.APPROVE_OPTION) || (f.getSelectedFile() == null)) {
            // I want a file, y'know!
            return;
        }
        unitFile = f.getSelectedFile();

        try {
            tempEntity = new MechFileParser(unitFile).getEntity();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(parentFrame, String.format("Warning:Invalid unit, it might load incorrectly!\n%1$s", ex.getMessage()));
        } finally {
            UnitUtil.showUnitCostBreakDown(tempEntity, parentFrame);
=======
        File unitFile = loadUnitFile();
        if (unitFile == null) return;

        try {
            Entity tempEntity = new MechFileParser(unitFile).getEntity();
            UnitUtil.showValidation(tempEntity, parentFrame);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(parentFrame,
                    String.format(resourceMap.getString("message.invalidUnit.format"),
                    ex.getMessage()));
        }
    }

    private @Nullable
    File loadUnitFile() {
        String filePathName = System.getProperty("user.dir") + "/data/mechfiles/";
        FileDialog fDialog = new FileDialog(parentFrame,
                resourceMap.getString("dialog.chooseUnit.title"),
                FileDialog.LOAD);
        fDialog.setLocationRelativeTo(parentFrame);
        fDialog.setMultipleMode(false);
        fDialog.setDirectory(filePathName);
        fDialog.setFilenameFilter(unitFilesFilter);

        fDialog.setVisible(true);
        if (fDialog.getFile() == null) {
            return null;
        }
        return new File(fDialog.getDirectory(), fDialog.getFile());
    }

    private void jMenuGetUnitBreakdownFromFile_actionPerformed() {
        File unitFile = loadUnitFile();
        if (unitFile == null) {
            return;
        }

        try {
            Entity tempEntity = new MechFileParser(unitFile).getEntity();
            UnitUtil.showUnitCostBreakDown(tempEntity, parentFrame);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(parentFrame,
                    String.format(resourceMap.getString("message.invalidUnit.format"),
                            ex.getMessage()));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
        }
    }
    
    private void jMenuGetUnitWeightBreakdownFromFile_actionPerformed() {
<<<<<<< HEAD

        Entity tempEntity = null;
        String filePathName = System.getProperty("user.dir").toString() + "/data/mechfiles/";
        File unitFile = new File(filePathName);
        JFileChooser f = new JFileChooser(filePathName);
        f.setLocation(parentFrame.getLocation().x + 150, parentFrame.getLocation().y + 100);
        f.setDialogTitle("Choose Unit");
        f.setDialogType(JFileChooser.OPEN_DIALOG);
        f.setMultiSelectionEnabled(false);

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Unit Files", "blk", "mtf", "hmp");

        // Add a filter for mul files
        f.setFileFilter(filter);

        int returnVal = f.showOpenDialog(parentFrame);
        if ((returnVal != JFileChooser.APPROVE_OPTION) || (f.getSelectedFile() == null)) {
            // I want a file, y'know!
            return;
        }
        unitFile = f.getSelectedFile();

        try {
            tempEntity = new MechFileParser(unitFile).getEntity();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(parentFrame, String.format("Warning:Invalid unit, it might load incorrectly!\n%1$s", ex.getMessage()));
        } finally {
            UnitUtil.showUnitWeightBreakDown(tempEntity, parentFrame);
=======
        File unitFile = loadUnitFile();
        if (unitFile == null) {
            return;
        }

        try {
            Entity tempEntity = new MechFileParser(unitFile).getEntity();
            UnitUtil.showUnitWeightBreakDown(tempEntity, parentFrame);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(parentFrame,
                    String.format(resourceMap.getString("message.invalidUnit.format"),
                            ex.getMessage()));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
        }
    }    

    private void jMenuGetUnitSpecsFromFile_actionPerformed() {
<<<<<<< HEAD

        Entity tempEntity = null;
        String filePathName = System.getProperty("user.dir").toString() + "/data/mechfiles/";
        File unitFile = new File(filePathName);
        JFileChooser f = new JFileChooser(filePathName);
        f.setLocation(parentFrame.getLocation().x + 150, parentFrame.getLocation().y + 100);
        f.setDialogTitle("Choose Unit");
        f.setDialogType(JFileChooser.OPEN_DIALOG);
        f.setMultiSelectionEnabled(false);

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Unit Files", "blk", "mtf", "hmp");

        // Add a filter for mul files
        f.setFileFilter(filter);

        int returnVal = f.showOpenDialog(parentFrame);
        if ((returnVal != JFileChooser.APPROVE_OPTION) || (f.getSelectedFile() == null)) {
            // I want a file, y'know!
            return;
        }
        unitFile = f.getSelectedFile();

        try {
            tempEntity = new MechFileParser(unitFile).getEntity();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(parentFrame, String.format("Warning:Invalid unit, it might load incorrectly!\n%1$s", ex.getMessage()));
        } finally {
            UnitUtil.showUnitSpecs(tempEntity, parentFrame);
=======
        File unitFile = loadUnitFile();
        if (unitFile == null) {
            return;
        }

        try {
            Entity tempEntity = new MechFileParser(unitFile).getEntity();
            UnitUtil.showUnitSpecs(tempEntity, parentFrame);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(parentFrame,
                    String.format(resourceMap.getString("message.invalidUnit.format"),
                            ex.getMessage()));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
        }
    }

    private void jMenuInsertImageFile_actionPerformed() {
<<<<<<< HEAD

        String filePathName = System.getProperty("user.dir").toString() + "/data/mechfiles/";

        File unitFile = new File(filePathName);
        JFileChooser f = new JFileChooser(filePathName);
        f.setLocation(parentFrame.getLocation().x + 150, parentFrame.getLocation().y + 100);
        f.setDialogTitle("Load Mech");
        f.setDialogType(JFileChooser.OPEN_DIALOG);
        f.setMultiSelectionEnabled(false);

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Unit Files", "blk", "mtf", "hmp");

        // Add a filter for mul files
        f.setFileFilter(filter);

        int returnVal = f.showOpenDialog(parentFrame);
        if ((returnVal != JFileChooser.APPROVE_OPTION) || (f.getSelectedFile() == null)) {
            // I want a file, y'know!
            return;
        }
        unitFile = f.getSelectedFile();
=======
        File unitFile = loadUnitFile();
        if (unitFile == null) {
            return;
        }
>>>>>>> 8d4751035a3393010991327be554030018ec06b8

        try {
            Entity tempEntity = new MechFileParser(unitFile).getEntity();

            if (UnitUtil.validateUnit(parentFrame.getEntity()).trim().length() > 0) {
<<<<<<< HEAD
                JOptionPane.showMessageDialog(parentFrame, "Warning:Invalid unit, it might load incorrectly!");
            }

            FileDialog fDialog = new FileDialog(parentFrame, "Image Path", FileDialog.LOAD);
=======
                JOptionPane.showMessageDialog(parentFrame,
                        resourceMap.getString("message.invalidUnit.text"));
            }

            FileDialog fDialog = new FileDialog(parentFrame,
                    resourceMap.getString("dialog.imagePath.title"), FileDialog.LOAD);
>>>>>>> 8d4751035a3393010991327be554030018ec06b8

            if (parentFrame.getEntity().getFluff().getMMLImagePath().trim().length() > 0) {
                String fullPath = new File(parentFrame.getEntity().getFluff().getMMLImagePath()).getAbsolutePath();
                String imageName = fullPath.substring(fullPath.lastIndexOf(File.separatorChar) + 1);
                fullPath = fullPath.substring(0, fullPath.lastIndexOf(File.separatorChar) + 1);
                fDialog.setDirectory(fullPath);
                fDialog.setFile(imageName);
            } else {
                fDialog.setDirectory(new File(ImageHelper.fluffPath).getAbsolutePath() + File.separatorChar + "mech" + File.separatorChar);
                fDialog.setFile(parentFrame.getEntity().getChassis() + " " + parentFrame.getEntity().getModel() + ".png");
            }

            fDialog.setLocationRelativeTo(parentFrame);

            fDialog.setVisible(true);

            if (fDialog.getFile() != null) {
                String relativeFilePath = new File(fDialog.getDirectory() + fDialog.getFile()).getAbsolutePath();
<<<<<<< HEAD
                relativeFilePath = "." + File.separatorChar + relativeFilePath.substring(new File(System.getProperty("user.dir").toString()).getAbsolutePath().length() + 1);
=======
                relativeFilePath = "." + File.separatorChar + relativeFilePath.substring(new File(System.getProperty("user.dir")).getAbsolutePath().length() + 1);
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
                parentFrame.getEntity().getFluff().setMMLImagePath(relativeFilePath);
                BLKFile.encode(unitFile.getAbsolutePath(), tempEntity);
            }
        } catch (Exception ex) {
<<<<<<< HEAD

        }
        return;
=======
            MegaMekLab.getLogger().error(getClass(), "jMenuInsertImageFile_actionPerformed()", ex);
        }
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
    }

    // Show BV Calculations

<<<<<<< HEAD
    public void jMenuBVCalculations_actionPerformed() {
=======
    private void jMenuBVCalculations_actionPerformed() {
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
        parentFrame.getEntity().calculateBattleValue(true, true);
        UnitUtil.showBVCalculations(parentFrame.getEntity().getBVText(), parentFrame);
    }

<<<<<<< HEAD
    public void jMenuUnitCostBreakdown_actionPerformed() {
        UnitUtil.showUnitCostBreakDown(parentFrame.getEntity(), parentFrame);
    }
    
    public void jMenuUnitWeightBreakdown_actionPerformed() {
        UnitUtil.showUnitWeightBreakDown(parentFrame.getEntity(), parentFrame);
    }

    public void jMenuUnitSpecs_actionPerformed() {
=======
    private void jMenuUnitCostBreakdown_actionPerformed() {
        UnitUtil.showUnitCostBreakDown(parentFrame.getEntity(), parentFrame);
    }
    
    private void jMenuUnitWeightBreakdown_actionPerformed() {
        UnitUtil.showUnitWeightBreakDown(parentFrame.getEntity(), parentFrame);
    }

    private void jMenuUnitSpecs_actionPerformed() {
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
        UnitUtil.showUnitSpecs(parentFrame.getEntity(), parentFrame);
    }

    // Show Validation data.
<<<<<<< HEAD
    public void jMenuValidateUnit_actionPerformed() {
=======
    private void jMenuValidateUnit_actionPerformed() {
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
        UnitUtil.showValidation(parentFrame.getEntity(), parentFrame);
    }

    // Show data about MegaMekLab
<<<<<<< HEAD
    public void jMenuHelpAbout_actionPerformed() {

        // make the dialog
        JDialog dlg = new JDialog(parentFrame, "MegaMekLab Info");
=======
    private void jMenuHelpAbout_actionPerformed() {

        // make the dialog
        JDialog dlg = new JDialog(parentFrame, resourceMap.getString("menu.help.about.title"));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8

        // set up the contents
        JPanel child = new JPanel();
        child.setLayout(new BoxLayout(child, BoxLayout.Y_AXIS));

        // set the text up.
<<<<<<< HEAD
        JLabel mekwars = new JLabel("MegaMekLab Version: " + MegaMekLab.VERSION);
        JLabel version = new JLabel("MegaMek Version: " + MegaMek.VERSION);
        JLabel license1 = new JLabel("MegaMekLab software is under GPL. See");
        JLabel license2 = new JLabel("license.txt in ./Docs/licenses for details.");
        JLabel license3 = new JLabel("Project Info:");
        JLabel license4 = new JLabel("       https://github.com/MegaMek/megameklab       ");

        // center everything
        mekwars.setAlignmentX(Component.CENTER_ALIGNMENT);
=======
        JLabel version = new JLabel(String.format(resourceMap.getString("menu.help.about.version.format"),
                MegaMekLab.VERSION));
        JLabel license1 = new JLabel(resourceMap.getString("menu.help.about.license.1"));
        JLabel license2 = new JLabel(resourceMap.getString("menu.help.about.license.2"));
        JLabel license3 = new JLabel(resourceMap.getString("menu.help.about.info.1"));
        JLabel license4 = new JLabel(resourceMap.getString("menu.help.about.info.2"));

        // center everything
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
        version.setAlignmentX(Component.CENTER_ALIGNMENT);
        license1.setAlignmentX(Component.CENTER_ALIGNMENT);
        license2.setAlignmentX(Component.CENTER_ALIGNMENT);
        license3.setAlignmentX(Component.CENTER_ALIGNMENT);
        license4.setAlignmentX(Component.CENTER_ALIGNMENT);

        // add to child panel
        child.add(new JLabel("\n"));
<<<<<<< HEAD
        child.add(mekwars);
=======
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
        child.add(version);
        child.add(new JLabel("\n"));
        child.add(license1);
        child.add(license2);
        child.add(new JLabel("\n"));
        child.add(license3);
        child.add(license4);
        child.add(new JLabel("\n"));

        // then add child panel to the content pane.
        dlg.getContentPane().add(child);
        dlg.setLocationRelativeTo(parentFrame);
        dlg.setModal(true);
        dlg.setResizable(false);
        dlg.pack();
        dlg.setVisible(true);
    }

    // Show how to create fluff images for Record Sheets
<<<<<<< HEAD
    public void jMenuHelpFluff_actionPerformed() {

        // make the dialog
        JDialog dlg = new JDialog(parentFrame, "Image Help");
=======
    private void jMenuHelpFluff_actionPerformed() {

        // make the dialog
        JDialog dlg = new JDialog(parentFrame, resourceMap.getString("menu.help.imageHelp.title"));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8

        // set up the contents
        JPanel child = new JPanel();
        child.setLayout(new BoxLayout(child, BoxLayout.Y_AXIS));

        // set the text up.
        JTextArea recordSheetImageHelp = new JTextArea();

        recordSheetImageHelp.setEditable(false);

<<<<<<< HEAD
        recordSheetImageHelp.setText("To add a fluff image to a record sheet the following steps need to be taken\nPlease Note that currently only \'Mechs use fluff Images\nPlace the image you want to use in the data/images/fluff folder\nMegaMekLab will attempt to match the name of the \'Mech your are printing\nwith the images in the fluff folder.\nThe following is an example of how MegaMekLab look for the image\nExample\nYour \'Mech is called Archer ARC-7Q\nMegaMekLab would look for the following\n\nArcher ARC-7Q.jpg/png/gif\nARC-7Q.jpg/png/gif\nArcher.jpg/png/gif\nhud.png\n");
=======
        recordSheetImageHelp.setText(resourceMap.getString("menu.help.imageHelp.text"));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
        // center everything
        recordSheetImageHelp.setAlignmentX(Component.CENTER_ALIGNMENT);

        // add to child panel
        child.add(recordSheetImageHelp);

        // then add child panel to the content pane.
        dlg.getContentPane().add(child);

        // set the location of the dialog
        dlg.setLocationRelativeTo(parentFrame);
        dlg.setModal(true);
        dlg.setResizable(false);
        dlg.pack();
        dlg.setVisible(true);
    }

<<<<<<< HEAD
    public void jMenuConfiguration_actionPerformed(ActionEvent event) {
=======
    private void jMenuConfiguration_actionPerformed(ActionEvent event) {
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
        new ConfigurationDialog(parentFrame).setVisible(true);
        parentFrame.refreshAll();
    }

    private void jMenuLoadVehicle() {
        new megameklab.com.ui.Vehicle.MainUI();
        parentFrame.dispose();
    }

<<<<<<< HEAD
=======
    private void jMenuLoadSupportVehicle() {
        new megameklab.com.ui.supportvehicle.SVMainUI();
        parentFrame.dispose();
    }

>>>>>>> 8d4751035a3393010991327be554030018ec06b8
    private void jMenuLoadBattleArmor() {
        new megameklab.com.ui.BattleArmor.MainUI();
        parentFrame.dispose();
    }

    private void jMenuLoadMech() {
        new megameklab.com.ui.Mek.MainUI(false, false);
        parentFrame.dispose();
    }
    
    private void jMenuLoadPrimitiveMech() {
        new megameklab.com.ui.Mek.MainUI(true, false);
        parentFrame.dispose();
    }

    private void jMenuLoadAero() {
        new megameklab.com.ui.Aero.MainUI(false);
        parentFrame.dispose();
    }

    private void jMenuLoadPrimitiveAero() {
        new megameklab.com.ui.Aero.MainUI(true);
        parentFrame.dispose();
    }
    
    private void jMenuLoadDropship() {
        new megameklab.com.ui.aerospace.DropshipMainUI(false);
        parentFrame.dispose();
    }

    private void jMenuLoadPrimitiveDropship() {
        new megameklab.com.ui.aerospace.DropshipMainUI(true);
        parentFrame.dispose();
    }
    
    private void jMenuLoadAdvAero() {
        new megameklab.com.ui.aerospace.AdvancedAeroUI(false);
        parentFrame.dispose();
    }

    private void jMenuLoadPrimitiveJumpship() {
        new megameklab.com.ui.aerospace.AdvancedAeroUI(true);
        parentFrame.dispose();
    }

    private void jMenuLoadInfantry() {
    	new megameklab.com.ui.Infantry.MainUI();
        parentFrame.dispose();
    }

    private void jMenuLoadProtomech() {
        new megameklab.com.ui.protomek.ProtomekMainUI();
        parentFrame.dispose();
    }

    private void jMenuPrintCurrentUnit() {
        UnitPrintManager.printEntity(parentFrame.getEntity());
    }

<<<<<<< HEAD
    public void jMenuLoadEntity_actionPerformed(ActionEvent event) {
        loadUnit();
    }

    public void jMenuLoadEntityFromFile_actionPerformed(ActionEvent event) {
        loadUnitFromFile();
    }

    public void jMenuLoadEntityFromFile_actionPerformed(int fileNumber) {
        loadUnitFromFile(fileNumber);
    }

    public void jMenuResetEntity_actionPerformed(ActionEvent event) {
=======
    private void jMenuLoadEntity_actionPerformed(ActionEvent event) {
        loadUnit();
    }

    private void jMenuLoadEntityFromFile_actionPerformed(ActionEvent event) {
        loadUnitFromFile();
    }

    private void jMenuLoadEntityFromFile_actionPerformed(int fileNumber) {
        loadUnitFromFile(fileNumber);
    }

    private void jMenuResetEntity_actionPerformed(ActionEvent event) {
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
        CConfig.updateSaveFiles("Reset Unit");
        CConfig.setParam(CConfig.CONFIG_SAVE_FILE_1, "");
        Entity en = parentFrame.getEntity();
        if (en instanceof Tank) {
            parentFrame.createNewUnit(Entity.ETYPE_TANK);
        } else if (en instanceof Mech) {
            parentFrame.createNewUnit(Entity.ETYPE_BIPED_MECH, ((Mech)en).isPrimitive(), ((Mech)en).isIndustrial());
        } else if (en.hasETypeFlag(Entity.ETYPE_DROPSHIP)) {
            parentFrame.createNewUnit(Entity.ETYPE_DROPSHIP);
        } else if (en.hasETypeFlag(Entity.ETYPE_SMALL_CRAFT)) {
            parentFrame.createNewUnit(Entity.ETYPE_SMALL_CRAFT, ((Aero)en).isPrimitive());
        } else if (en.hasETypeFlag(Entity.ETYPE_SPACE_STATION)) {
            parentFrame.createNewUnit(Entity.ETYPE_SPACE_STATION);
        } else if (en.hasETypeFlag(Entity.ETYPE_WARSHIP)) {
            parentFrame.createNewUnit(Entity.ETYPE_WARSHIP, ((Aero)en).isPrimitive());
        } else if (en.hasETypeFlag(Entity.ETYPE_JUMPSHIP)) {
            parentFrame.createNewUnit(Entity.ETYPE_JUMPSHIP);
        } else if (parentFrame.getEntity() instanceof Aero) {
            parentFrame.createNewUnit(Entity.ETYPE_AERO, ((Aero)en).isPrimitive());
        } else if (parentFrame.getEntity() instanceof BattleArmor) {
            parentFrame.createNewUnit(Entity.ETYPE_BATTLEARMOR);
        } else if (parentFrame.getEntity() instanceof Infantry) {
            parentFrame.createNewUnit(Entity.ETYPE_INFANTRY);
        } else if (parentFrame.getEntity() instanceof Protomech) {
            parentFrame.createNewUnit(Entity.ETYPE_PROTOMECH);
        } else {
<<<<<<< HEAD
            System.out.println("util.MenuBarCreatoer: " +
                        "Received unknown entityType!");
=======
            MegaMekLab.getLogger().warning(getClass(),
            "jMenuResetEntity_actionPerformed(ActionEvent)",
                "util.MenuBarCreator: Received unknown entityType!");
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
        }
        setVisible(true);
        reload();
        refresh();
        parentFrame.setVisible(true);
        parentFrame.repaint();
    }

<<<<<<< HEAD
    public void jMenuSaveEntity_actionPerformed(ActionEvent event) {

        if (UnitUtil.validateUnit(parentFrame.getEntity()).length() > 0) {
            JOptionPane.showMessageDialog(parentFrame, "Warning: Saving an invalid unit, it might load incorrectly!");
=======
    private void jMenuSaveEntity_actionPerformed(ActionEvent event) {

        if (UnitUtil.validateUnit(parentFrame.getEntity()).length() > 0) {
            JOptionPane.showMessageDialog(parentFrame,
                    resourceMap.getString("messages.invalidUnit.text"));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
        }

        String unitName = parentFrame.getEntity().getChassis() + " " + parentFrame.getEntity().getModel();
        UnitUtil.compactCriticals(parentFrame.getEntity());

        String filePathName = CConfig.getParam(CConfig.CONFIG_SAVE_FILE_1);

        if ((filePathName.trim().length() < 1) || !filePathName.contains(unitName)) {
<<<<<<< HEAD
            FileDialog fDialog = new FileDialog(parentFrame, "Save As", FileDialog.SAVE);
=======
            FileDialog fDialog = new FileDialog(parentFrame,
                    resourceMap.getString("dialog.saveAs.title"),
                    FileDialog.SAVE);
>>>>>>> 8d4751035a3393010991327be554030018ec06b8

            filePathName = CConfig.getParam(CConfig.CONFIG_SAVE_LOC);

            fDialog.setDirectory(filePathName);
            fDialog.setFile(unitName + (parentFrame.getEntity() instanceof Mech?".mtf":".blk"));
            fDialog.setLocationRelativeTo(parentFrame);

            fDialog.setVisible(true);

            if (fDialog.getFile() != null) {
                filePathName = fDialog.getDirectory() + fDialog.getFile();
                CConfig.setParam(CConfig.CONFIG_SAVE_LOC, fDialog.getDirectory());
            } else {
                return;
            }
        }
        try {
            if (parentFrame.getEntity() instanceof Mech) {
                FileOutputStream out = new FileOutputStream(filePathName);
                PrintStream p = new PrintStream(out);

                p.println(((Mech) parentFrame.getEntity()).getMtf());
                p.close();
                out.close();
            } else {
                BLKFile.encode(filePathName, parentFrame.getEntity());
            }
            CConfig.updateSaveFiles(filePathName);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

<<<<<<< HEAD
        JOptionPane.showMessageDialog(parentFrame, parentFrame.getEntity().getChassis() + " " + parentFrame.getEntity().getModel() + " saved to " + filePathName);

    }

    public void jMenuSaveAsEntity_actionPerformed(ActionEvent event) {

        if (UnitUtil.validateUnit(parentFrame.getEntity()).length() > 0) {
            JOptionPane.showMessageDialog(parentFrame, "Warning: Saving an invalid unit, it might load incorrectly!");
=======
        JOptionPane.showMessageDialog(parentFrame,
                String.format(resourceMap.getString("dialog.saveAs.message.format"),
                        parentFrame.getEntity().getChassis(),
                        parentFrame.getEntity().getModel(), filePathName));

    }

    private void jMenuSaveAsEntity_actionPerformed(ActionEvent event) {

        if (UnitUtil.validateUnit(parentFrame.getEntity()).length() > 0) {
            JOptionPane.showMessageDialog(parentFrame,
                    resourceMap.getString("message.savingInvalidUnit.text"));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
        }

        UnitUtil.compactCriticals(parentFrame.getEntity());

<<<<<<< HEAD
        FileDialog fDialog = new FileDialog(parentFrame, "Save As", FileDialog.SAVE);
=======
        FileDialog fDialog = new FileDialog(parentFrame,
                resourceMap.getString("dialog.saveAs.title"), FileDialog.SAVE);
>>>>>>> 8d4751035a3393010991327be554030018ec06b8

        String filePathName = CConfig.getParam(CConfig.CONFIG_SAVE_LOC);

        fDialog.setDirectory(filePathName);
        fDialog.setFile(parentFrame.getEntity().getChassis() + " " + parentFrame.getEntity().getModel() + (parentFrame.getEntity() instanceof Mech?".mtf":".blk"));
        fDialog.setLocationRelativeTo(parentFrame);

        fDialog.setVisible(true);

        if (fDialog.getFile() != null) {
            filePathName = fDialog.getDirectory() + fDialog.getFile();
            CConfig.setParam(CConfig.CONFIG_SAVE_LOC, fDialog.getDirectory());
        } else {
            return;
        }

        try {
            if (parentFrame.getEntity() instanceof Mech) {
                FileOutputStream out = new FileOutputStream(filePathName);
                PrintStream p = new PrintStream(out);

                p.println(((Mech) parentFrame.getEntity()).getMtf());
                p.close();
                out.close();
            } else {
                BLKFile.encode(filePathName, parentFrame.getEntity());
            }
            CConfig.updateSaveFiles(filePathName);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

<<<<<<< HEAD
        JOptionPane.showMessageDialog(parentFrame, parentFrame.getEntity().getChassis() + " " + parentFrame.getEntity().getModel() + " saved to " + filePathName);

=======
        JOptionPane.showMessageDialog(parentFrame,
                String.format(resourceMap.getString("dialog.saveAs.message.format"),
                        parentFrame.getEntity().getChassis(),
                        parentFrame.getEntity().getModel(), filePathName));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
    }
    
    private String entitySummaryText(boolean html) {
        if (CConfig.getBooleanParam(CConfig.SUMMARY_FORMAT_TRO)) {
            TROView view = TROView.createView(parentFrame.getEntity(), html);
            return view.processTemplate();
        } else {
            MechView view = new MechView(parentFrame.getEntity(), !html, false, html);
            return view.getMechReadout();
        }
    }

<<<<<<< HEAD
    public void exportSummary(boolean html) {

        if (UnitUtil.validateUnit(parentFrame.getEntity()).length() > 0) {
            JOptionPane.showMessageDialog(parentFrame, "Warning: exporting an invalid unit!");
=======
    private void exportSummary(boolean html) {
        if (UnitUtil.validateUnit(parentFrame.getEntity()).length() > 0) {
            JOptionPane.showMessageDialog(parentFrame,
                    resourceMap.getString("message.exportingInvalidUnit.text"));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
        }

        String unitName = parentFrame.getEntity().getChassis() + " " + parentFrame.getEntity().getModel();

<<<<<<< HEAD
        FileDialog fDialog = new FileDialog(parentFrame, "Save As", FileDialog.SAVE);
        String filePathName = new File(System.getProperty("user.dir").toString()).getAbsolutePath();
=======
        FileDialog fDialog = new FileDialog(parentFrame,
                resourceMap.getString("dialog.saveAs.title"), FileDialog.SAVE);
        String filePathName = new File(System.getProperty("user.dir")).getAbsolutePath();
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
        fDialog.setDirectory(filePathName);
        fDialog.setFile(unitName + (html?".html" : ".txt"));
        fDialog.setLocationRelativeTo(parentFrame);
        fDialog.setVisible(true);

        if (fDialog.getFile() != null) {
            filePathName = fDialog.getDirectory() + fDialog.getFile();
        } else {
            return;
        }

        try {
            FileOutputStream out = new FileOutputStream(filePathName);
            PrintStream p = new PrintStream(out);
            p.println(entitySummaryText(html));
            p.close();
            out.close();
        } catch (Exception ex) {
<<<<<<< HEAD
            ex.printStackTrace();
=======
            MegaMekLab.getLogger().error(getClass(), "exportSummary(boolean)", ex);
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
        }
    }

    private void exportSummaryClipboard() {
        final String summaryText = entitySummaryText(false);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection stringSelection = new StringSelection(summaryText);
        clipboard.setContents(stringSelection, this);
    }

    private void loadUnit() {
        UnitLoadingDialog unitLoadingDialog = new UnitLoadingDialog(parentFrame);
        unitLoadingDialog.setVisible(true);
        UnitSelectorDialog viewer = new UnitSelectorDialog(parentFrame, unitLoadingDialog, true);

        Entity newUnit = viewer.getChosenEntity();
        viewer.setVisible(false);
        viewer.dispose();

        if (null == newUnit) {
            return;
        }

        if (UnitUtil.validateUnit(newUnit).trim().length() > 0) {
            JOptionPane.showMessageDialog(parentFrame, String.format(
<<<<<<< HEAD
                    "Warning:Invalid unit, it might load incorrectly!\n%1$s",
=======
                    resourceMap.getString("message.invalidUnit.format"),
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
                            UnitUtil.validateUnit(newUnit)));
        }

        if (newUnit.getEntityType() != parentFrame.getEntity().getEntityType()) {
            MegaMekLabMainUI newUI = null;
<<<<<<< HEAD
            if (newUnit.hasETypeFlag(Entity.ETYPE_SMALL_CRAFT)) {
=======
            if (newUnit.isSupportVehicle()) {
                newUI = new megameklab.com.ui.supportvehicle.SVMainUI();
            } else if (newUnit.hasETypeFlag(Entity.ETYPE_SMALL_CRAFT)) {
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
                newUI = new megameklab.com.ui.aerospace.DropshipMainUI(((Aero)newUnit).isPrimitive());
            } else if (newUnit.hasETypeFlag(Entity.ETYPE_JUMPSHIP)) {
                newUI = new megameklab.com.ui.aerospace.AdvancedAeroUI(((Aero)newUnit).isPrimitive());
            } else if (newUnit.hasETypeFlag(Entity.ETYPE_AERO)
                    && !newUnit.hasETypeFlag(Entity.ETYPE_FIXED_WING_SUPPORT)) {
                newUI = new megameklab.com.ui.Aero.MainUI(((Aero)newUnit).isPrimitive());
            } else if (newUnit.hasETypeFlag(Entity.ETYPE_BATTLEARMOR)) {
                newUI = new megameklab.com.ui.BattleArmor.MainUI();
            } else if (newUnit.hasETypeFlag(Entity.ETYPE_INFANTRY)) {
                newUI = new megameklab.com.ui.Infantry.MainUI();
            } else if (newUnit.hasETypeFlag(Entity.ETYPE_PROTOMECH)) {
                newUI = new megameklab.com.ui.protomek.ProtomekMainUI();
            } else if (newUnit.hasETypeFlag(Entity.ETYPE_MECH)) {
                newUI = new megameklab.com.ui.Mek.MainUI();
            } else if (newUnit.hasETypeFlag(Entity.ETYPE_TANK)
                    && !newUnit.hasETypeFlag(Entity.ETYPE_GUN_EMPLACEMENT)) {
                newUI = new megameklab.com.ui.Vehicle.MainUI();
            }
            if (null == newUI) {
                JOptionPane.showMessageDialog(parentFrame,
<<<<<<< HEAD
                        "Warning: Could not create new UI, aborting unit load!"
                        +System.lineSeparator()
                        +"Probable cause: Unsupported unit type.");
=======
                        resourceMap.getString("message.abortUnitLoad.text"));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
                return;
            }
            parentFrame.dispose();
            UnitUtil.updateLoadedUnit(newUnit);
            newUI.setEntity(newUnit);
            newUI.reloadTabs();
            newUI.repaint();
            newUI.refreshAll();
            return;
        }

        CConfig.updateSaveFiles("");
        UnitUtil.updateLoadedUnit(newUnit);

        if (viewer.getChosenMechSummary().getSourceFile().getName().endsWith(".zip")) {
            String fileName = viewer.getChosenMechSummary().getSourceFile().getAbsolutePath();
            fileName = fileName.substring(0, fileName.lastIndexOf(File.separatorChar) + 1);
            fileName = fileName + viewer.getChosenMechSummary().getName() + ".mtf";
            CConfig.updateSaveFiles(fileName);
        } else {
            CConfig.updateSaveFiles(viewer.getChosenMechSummary().getSourceFile().getAbsolutePath());
        }
        parentFrame.setEntity(newUnit);
        reload();
        refresh();
        parentFrame.setVisible(true);
    }

    private void loadUnitFromFile() {
        loadUnitFromFile(-1);
    }

    private void loadUnitFromFile(int fileNumber) {
<<<<<<< HEAD

        String filePathName = System.getProperty("user.dir").toString() + "/data/mechfiles/";
=======
        String filePathName = System.getProperty("user.dir") + "/data/mechfiles/";
>>>>>>> 8d4751035a3393010991327be554030018ec06b8

        if (fileNumber > 0) {
            switch (fileNumber) {
                case 1:
                    filePathName = CConfig.getParam(CConfig.CONFIG_SAVE_FILE_1);
                    break;
                case 2:
                    filePathName = CConfig.getParam(CConfig.CONFIG_SAVE_FILE_2);
                    break;
                case 3:
                    filePathName = CConfig.getParam(CConfig.CONFIG_SAVE_FILE_3);
                    break;
                case 4:
                    filePathName = CConfig.getParam(CConfig.CONFIG_SAVE_FILE_4);
                    break;
            }
        }

        File unitFile = new File(filePathName);
        if (!(unitFile.isFile())) {
<<<<<<< HEAD
            JFileChooser f = new JFileChooser(filePathName);
            f.setLocation(parentFrame.getLocation().x + 150, parentFrame.getLocation().y + 100);
            f.setDialogTitle("Load Mech");
            f.setDialogType(JFileChooser.OPEN_DIALOG);
            f.setMultiSelectionEnabled(false);

            FileNameExtensionFilter filter = new FileNameExtensionFilter("Unit Files", "blk", "mtf", "hmp");

            // Add a filter for mul files
            f.setFileFilter(filter);

            int returnVal = f.showOpenDialog(parentFrame);
            if ((returnVal != JFileChooser.APPROVE_OPTION) || (f.getSelectedFile() == null)) {
                // I want a file, y'know!
                return;
            }
            unitFile = f.getSelectedFile();
=======
            unitFile = loadUnitFile();
            if (unitFile == null) {
                // I want a file, y'know!
                return;
            }
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
        }

        loadUnitFromFile(unitFile);
    }

    private void loadUnitFromFile(File unitFile) {
        try {
            Entity tempEntity = new MechFileParser(unitFile).getEntity();


            if (null == tempEntity) {
                return;
            }

            if (UnitUtil.validateUnit(tempEntity).trim().length() > 0) {
                JOptionPane.showMessageDialog(parentFrame, String.format(
<<<<<<< HEAD
                        "Warning:Invalid unit, it might load incorrectly!\n%1$s",
=======
                        resourceMap.getString("message.invalidUnit.format"),
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
                                UnitUtil.validateUnit(tempEntity)));
            }

            if (tempEntity.getEntityType() != parentFrame.getEntity().getEntityType()) {
                MegaMekLabMainUI newUI = null;
<<<<<<< HEAD
                if (tempEntity.hasETypeFlag(Entity.ETYPE_SMALL_CRAFT)) {
=======
                if (tempEntity.isSupportVehicle()) {
                    newUI = new megameklab.com.ui.supportvehicle.SVMainUI();
                } else if (tempEntity.hasETypeFlag(Entity.ETYPE_SMALL_CRAFT)) {
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
                    newUI = new megameklab.com.ui.aerospace.DropshipMainUI(((Aero)tempEntity).isPrimitive());
                } else if (tempEntity.hasETypeFlag(Entity.ETYPE_JUMPSHIP)) {
                    newUI = new megameklab.com.ui.aerospace.AdvancedAeroUI(((Aero)tempEntity).isPrimitive());
                } else if ((tempEntity instanceof Aero)
                        && !(tempEntity instanceof FixedWingSupport)) {
                    newUI = new megameklab.com.ui.Aero.MainUI(((Aero)tempEntity).isPrimitive());
                } else if (tempEntity instanceof BattleArmor) {
                    newUI = new megameklab.com.ui.BattleArmor.MainUI();
                } else if (tempEntity instanceof Infantry) {
                    newUI = new megameklab.com.ui.Infantry.MainUI();
                } else if (tempEntity instanceof Mech) {
                    newUI = new megameklab.com.ui.Mek.MainUI();
                } else if (tempEntity instanceof Protomech) {
                    newUI = new megameklab.com.ui.protomek.ProtomekMainUI();
                } else if ((tempEntity instanceof Tank)
                        && !(tempEntity instanceof GunEmplacement)) {
                    newUI = new megameklab.com.ui.Vehicle.MainUI();
                }
                if (null == newUI) {
                    JOptionPane.showMessageDialog(parentFrame,
<<<<<<< HEAD
                            "Warning: Could not create new UI, aborting unit load!");
=======
                            resourceMap.getString("message.abortUnitLoad.text"));
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
                    return;
                }
                parentFrame.dispose();
                UnitUtil.updateLoadedUnit(tempEntity);
                newUI.setEntity(tempEntity);
                newUI.reloadTabs();
                newUI.repaint();
                newUI.refreshAll();
                return;
            }
            parentFrame.setEntity(tempEntity);
            UnitUtil.updateLoadedUnit(parentFrame.getEntity());

            CConfig.updateSaveFiles(unitFile.getAbsolutePath());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(parentFrame, String.format(
<<<<<<< HEAD
                    "Warning:Invalid unit, it might load incorrectly!\n%1$s",
=======
                    resourceMap.getString("message.invalidUnit.format"),
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
                    ex.getMessage()));
        }
        reload();
        refresh();
        parentFrame.setVisible(true);
    }

    private void refresh() {
        parentFrame.refreshAll();
    }

    private void reload() {
        parentFrame.reloadTabs();
    }

    @Override
    public void lostOwnership(Clipboard arg0, Transferable arg1) {

    }

<<<<<<< HEAD
=======
    private final FilenameFilter unitFilesFilter =
            (dir, filename) -> {
                String fn = filename.toLowerCase();
                return fn.endsWith(".mtf")
                        || fn.endsWith(".blk")
                        || fn.endsWith(".hmp");
            };
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
}
