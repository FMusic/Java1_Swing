package com.fm.utils;

import javax.swing.*;
import java.awt.*;

public class SwingUtils {

    public static JPanel setPanel(JPanel panel, Component... comps) {
        for(Component comp: comps){
            panel.add(comp);
        }
        return panel;
    }
}
