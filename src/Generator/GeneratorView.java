package Generator;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GeneratorView extends JPanel
{
    private GeneratorModel model;
    private boolean shouldDraw;

    public GeneratorView(GeneratorModel model)
    {
        this.model = model;
        this.shouldDraw = false;
    }

    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);

        paintRandomImage(graphics);

        this.repaint();
    }

    private void paintRandomImage(Graphics graphics)
    {
        if(this.shouldDraw)
        {
            this.model.generateRandomImage();
            this.shouldDraw = false;
        }

        BufferedImage canvas = this.model.getCanvas();
        BufferedImage randomlyGeneratedImage = this.model.getRandomlyGeneratedImage();

        int width = this.model.getWindowWidth();
        int height = this.model.getWindowHeight();

        graphics.drawImage(canvas, 0, 0, width, height, null);
        graphics.drawImage(randomlyGeneratedImage, 0, 0, width, height, null);

        this.repaint();
    }

    public void clearRandomImage()
    {
        String filePath = System.getProperty("user.dir") + "/img/temp.png";
        String formatName = "png";
        this.model.clearRandomImage(filePath, formatName);
    }

    public void toggleShouldDraw() { this.shouldDraw = !this.shouldDraw; }
}