package GUI;

import Generator.GeneratorController;
import Generator.GeneratorModel;
import Generator.GeneratorView;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GeneratorMenuBar extends JMenuBar
{
    public GeneratorMenuBar(GeneratorModel model, GeneratorView view, GeneratorController controller)
    {
        setBackground(Color.LIGHT_GRAY);

        JMenu fileMenu = new JMenu("File");
        JMenu imageMenu = new JMenu("Image");

        JMenuItem saveMenuItem = new JMenuItem(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Save as");
                fileChooser.setFileFilter(
                        new FileNameExtensionFilter(
                                "Image files",
                                ImageIO.getReaderFileSuffixes()
                        )
                );

                int userSelection = fileChooser.showSaveDialog(controller);

                if(userSelection == JFileChooser.APPROVE_OPTION)
                {
                    model.saveImage(fileChooser.getSelectedFile().getAbsolutePath(), "png");
                }
            }
        });
        saveMenuItem.setText("Save");

        JMenuItem clearImageMenuItem = new JMenuItem(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.clearRandomImage();
            }
        });
        clearImageMenuItem.setText("Clear");

        fileMenu.add(saveMenuItem);
        imageMenu.add(clearImageMenuItem);
        add(fileMenu);
        add(imageMenu);
    }
}