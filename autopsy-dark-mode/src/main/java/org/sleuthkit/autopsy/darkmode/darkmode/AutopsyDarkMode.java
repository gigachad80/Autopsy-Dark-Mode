package org.sleuthkit.autopsy.darkmode;

import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.*;
import java.awt.*;
import java.util.logging.Logger;
import java.util.logging.Level;
import org.openide.modules.OnStart;
import org.openide.windows.WindowManager;

/**
 * Autopsy Dark Mode Module - FlatLaf Implementation
 */
@OnStart
public class AutopsyDarkMode implements Runnable {
    
    private static final Logger logger = Logger.getLogger(AutopsyDarkMode.class.getName());
    
    @Override
    public void run() {
        logger.log(Level.INFO, "========================================");
        logger.log(Level.INFO, "AUTOPSY DARK MODE MODULE STARTING");
        logger.log(Level.INFO, "========================================");
        
        // Apply FlatLaf Dark theme immediately
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
            logger.log(Level.INFO, "FlatDarkLaf theme set successfully");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to set FlatDarkLaf", e);
        }
        
        // Re-apply when UI is ready
        WindowManager.getDefault().invokeWhenUIReady(() -> {
            applyDarkThemeAggressively();
            logger.log(Level.INFO, "Dark theme re-applied after UI ready");
        });
        
        // Keep applying every 2 seconds for first 10 seconds
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(2000);
                    SwingUtilities.invokeLater(this::applyDarkThemeAggressively);
                    logger.log(Level.INFO, "Dark theme re-applied (attempt " + (i + 1) + ")");
                } catch (InterruptedException e) {
                    break;
                }
            }
        }).start();
    }
    
    private void applyDarkThemeAggressively() {
        try {
            // Set FlatLaf Dark
            UIManager.setLookAndFeel(new FlatDarkLaf());
            
            // Force update all windows
            for (Window window : Window.getWindows()) {
                SwingUtilities.updateComponentTreeUI(window);
                updateAllComponents(window);
            }
            
            logger.log(Level.INFO, "Dark theme applied and components updated");
            
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error in applyDarkThemeAggressively", e);
        }
    }
    
    private void updateAllComponents(Component component) {
        if (component == null) return;
        
        component.invalidate();
        component.validate();
        component.repaint();
        
        if (component instanceof Container) {
            Container container = (Container) component;
            for (Component child : container.getComponents()) {
                updateAllComponents(child);
            }
        }
    }
}
