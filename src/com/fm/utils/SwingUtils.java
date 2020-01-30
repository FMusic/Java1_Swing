package com.fm.utils;

import javax.swing.*;
import java.awt.*;

public class SwingUtils {

    public static JPanel setPanel(JPanel panel, JComponent... comps) {
        boolean isPnlBox = panel.getLayout() instanceof BoxLayout;
        for(Component comp: comps){
            panel.add(comp);
        }
        return panel;
    }
}
