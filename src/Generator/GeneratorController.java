package Generator;

import GUI.GeneratorMenuBar;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.ImageFilter;

public class GeneratorController extends JFrame
{
    private GeneratorModel model;
    private GeneratorView view;

    public GeneratorController(int windowWidth, int windowHeight)
    {
        super("Random Image Generator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(50, 50);

        this.model = new GeneratorModel(windowWidth, windowHeight);
        this.view = new GeneratorView(this.model);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                view.clearRandomImage();
                super.windowClosing(e);
            }
        });
        add(this.view);

        GeneratorMenuBar generatorMenuBar = new GeneratorMenuBar(model, view, this);
        add(generatorMenuBar, BorderLayout.NORTH);

        JPanel generateButtonPanel = new JPanel();
        generateButtonPanel.setBackground(Color.LIGHT_GRAY);
        generateButtonPanel.setPreferredSize(new Dimension(windowWidth, 35));

        JButton generateButton = new JButton("Generate Random Image");
        generateButton.setPreferredSize(new Dimension(200, 25));
        generateButton.addActionListener(e -> view.toggleShouldDraw());
        generateButtonPanel.add(generateButton, BorderLayout.CENTER);

        add(generateButtonPanel, BorderLayout.SOUTH);

        this.view.setPreferredSize(new Dimension(windowWidth, windowHeight));

        pack();
        setVisible(true);
    }
}