package net.littlebits.ui;

import net.littlebits.ui.controls.ActionButton;
import net.littlebits.ui.controls.ImagePanel;
import net.technicpack.launcher.ui.LauncherFrame;
import net.technicpack.launchercore.install.LauncherDirectories;
import net.technicpack.ui.controls.TiledBackground;
import net.technicpack.ui.lang.ResourceLoader;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BitcraftPanel extends JPanel {
    final protected ResourceLoader resources;
   

    public static final Color COLOR_LITTLEBITS_ORANGE = new Color(255,138,0); // #FF8A00
    public static final Color COLOR_LITTLEBITS_BUTTON_HOVER = new Color(230,140,0); // #e67c00
    public static final Color COLOR_LITTLEBITS_WHITE = new Color(255,255,255);
    public static final Color COLOR_LITTLEBITS_TEXT = new Color(68,68,68); // #444
    public static final Color COLOR_LITTLEBITS_TEXT_FIELD_BG = new Color(238,238,238); // #eee
    public static final Color COLOR_LITTLEBITS_TEXT_FIELD_STROKE = new Color(136,136,136); // #ccc

    public static final Color COLOR_LITTLEBITS_GREY_BG = new Color(238,238,238); // #eee

    public static final Font mainFont = new Font("Courier New", 0, 12);

    public ImagePanel containerPanel;
    public JPanel contentPanel;
    public JLabel debugInfo;

    public JPanel bottomPanel;

    public BitcraftPanel(final ResourceLoader loader, Dimension contentDimensions) {
        setLayout(new BorderLayout());
        this.resources = loader;

        this.setFont(mainFont.deriveFont(Font.PLAIN, 16));

        JPanel background = new JPanel(null);
        background.setOpaque(true);
        background.setForeground(COLOR_LITTLEBITS_WHITE);
        background.setBackground(LauncherFrame.COLOR_GREEN);
        background.setLayout(new BorderLayout());
        //background.setFilterImage(true);
        this.add(background, BorderLayout.CENTER);

        BufferedImage backgroundImage = resources.getImage("BITCRAFT-purple-HR.png");

        containerPanel = new ImagePanel();
        containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));
        containerPanel.setBackground(Color.green);
        containerPanel.setImage(backgroundImage);
        containerPanel.setOpaque(true);

        background.add(containerPanel);

        contentPanel = new JPanel();
        contentPanel.setBackground(COLOR_LITTLEBITS_WHITE);
        contentPanel.setForeground(COLOR_LITTLEBITS_TEXT);

        contentPanel.setPreferredSize(contentDimensions);
        contentPanel.setMaximumSize(contentDimensions);
        contentPanel.setMinimumSize(contentDimensions);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        BufferedImage bitcraftLogo = resources.getImage("bitcraft-logo-2x.png");
        ImagePanel bcLogoContainerPanel = new ImagePanel(new GridBagLayout());
        bcLogoContainerPanel.setImage(bitcraftLogo);
        bcLogoContainerPanel.setOpaque(false);

        Dimension bcLogoDimensions = new Dimension(593,158);
        bcLogoContainerPanel.setPreferredSize(bcLogoDimensions);
        bcLogoContainerPanel.setMinimumSize(bcLogoDimensions);
        bcLogoContainerPanel.setMaximumSize(bcLogoDimensions);

        containerPanel.add(Box.createVerticalStrut(50));
        containerPanel.add(bcLogoContainerPanel);
        containerPanel.add(Box.createVerticalStrut(50));
        containerPanel.add(contentPanel);

        debugInfo = new JLabel("");
        debugInfo.setForeground(Color.lightGray);
        debugInfo.setFont(mainFont.deriveFont(Font.PLAIN, 12));

        bottomPanel = new JPanel(new GridBagLayout());
        bottomPanel.add(debugInfo, new GridBagConstraints(0,2,1,1,1,1, GridBagConstraints.LAST_LINE_START, GridBagConstraints.NONE, new Insets(0,0,15,0), 0,0));
        bottomPanel.setOpaque(false);

        bottomPanel.setBorder(new EmptyBorder(0, 40, 0, 40));

        containerPanel.add(bottomPanel, BorderLayout.PAGE_END);




    }
}
