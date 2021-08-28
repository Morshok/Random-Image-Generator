import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GeneratorView extends JPanel
{
    private GeneratorModel model;
    private BufferedImage canvas;
    private BufferedImage randomlyGeneratedImage;
    private boolean shouldDraw;

    public GeneratorView(GeneratorModel model)
    {
        this.model = model;
        this.shouldDraw = false;

        this.canvas = this.model.loadImage(System.getProperty("user.dir") + "/img/canvas.jpg");
        this.randomlyGeneratedImage = this.model.loadImage(System.getProperty("user.dir") + "/img/temp.png");
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
            getRandomImage();
            this.shouldDraw = false;
        }

        int width = this.model.getWindowWidth();
        int height = this.model.getWindowHeight();

        graphics.drawImage(this.canvas, 0, 0, width, height, null);
        graphics.drawImage(this.randomlyGeneratedImage, 0, 0, width, height, null);

        this.repaint();
    }

    private void getRandomImage() { this.model.generateRandomImage(this.randomlyGeneratedImage);}
    public void clearRandomImage()
    {
        String filePath = System.getProperty("user.dir") + "/img/temp.png";
        String formatName = "png";
        this.model.clearRandomImage(this.randomlyGeneratedImage, filePath, formatName);
    }

    public void toggleShouldDraw() { this.shouldDraw = !this.shouldDraw; }
}