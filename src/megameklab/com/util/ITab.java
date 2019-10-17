/*
 * MegaMekLab - Copyright (C) 2008 
 * 
 * Original author - jtighe (torren@users.sourceforge.net)
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * for more details.
 */
package megameklab.com.util;

import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JPanel;

<<<<<<< HEAD
import megamek.common.Aero;
import megamek.common.BattleArmor;
import megamek.common.Infantry;
import megamek.common.Jumpship;
import megamek.common.Mech;
import megamek.common.Protomech;
import megamek.common.SmallCraft;
import megamek.common.Tank;
import megamek.common.VTOL;
=======
import megamek.common.*;
>>>>>>> 8d4751035a3393010991327be554030018ec06b8
import megameklab.com.ui.EntitySource;

public class ITab extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = -5771036622436158024L;
    protected EntitySource eSource;

    public ITab(EntitySource eSource) {
        this.eSource = eSource;
    }

<<<<<<< HEAD
=======
    public Entity getEntity() { return eSource.getEntity(); }

>>>>>>> 8d4751035a3393010991327be554030018ec06b8
    public Mech getMech() {
        return (Mech) eSource.getEntity();
    }
    
    public Protomech getProtomech() {
        return (Protomech) eSource.getEntity();
    }

    public Tank getTank() {
        return (Tank) eSource.getEntity();
    }

    public VTOL getVTOL() {
        return (VTOL) eSource.getEntity();
    }

    public Aero getAero() {
        return (Aero) eSource.getEntity();
    }
    
    public SmallCraft getSmallCraft() {
        return (SmallCraft) eSource.getEntity();
    }

    public Jumpship getJumpship() {
        return (Jumpship) eSource.getEntity();
    }

    public BattleArmor getBattleArmor() {
        return (BattleArmor) eSource.getEntity();
    }
    
    public Infantry getInfantry() {
    	return (Infantry) eSource.getEntity();
    }

    protected void setFieldSize(JComponent box, Dimension maxSize) {
        box.setPreferredSize(maxSize);
        box.setMaximumSize(maxSize);
        box.setMinimumSize(maxSize);
    }

}