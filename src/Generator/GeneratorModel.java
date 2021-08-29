package Generator;

import Utility.ImageHandler;

import java.awt.image.BufferedImage;
import java.util.Random;

public class GeneratorModel
{
    private int windowWidth;
    private int windowHeight;
    private BufferedImage canvas;
    private BufferedImage randomlyGeneratedImage;

    private Random random;

    public GeneratorModel(int windowWidth, int windowHeight)
    {
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;

        this.canvas = loadImage(System.getProperty("user.dir") + "/img/canvas.jpg");
        this.randomlyGeneratedImage = loadImage(System.getProperty("user.dir") + "/img/temp.png");

        this.random = new Random(System.currentTimeMillis());
    }

    public int getWindowWidth() { return this.windowWidth; }
    public int getWindowHeight() { return this.windowHeight; }

    public void generateRandomImage()
    {
        for(int x = 0; x < windowWidth; x++)
        {
            for(int y = 0; y < windowHeight; y++)
            {
                int alpha = this.random.nextInt(256);
                int red = this.random.nextInt(256);
                int green = this.random.nextInt(256);
                int blue = this.random.nextInt(256);

                int pixelValue = (alpha<<24) | (red<<16) | (green<<8) | blue;
                randomlyGeneratedImage.setRGB(x, y, pixelValue);
            }
        }
    }

    public BufferedImage getCanvas() { return this.canvas; }
    public BufferedImage getRandomlyGeneratedImage() { return this.randomlyGeneratedImage; }

    public void clearRandomImage(String filePath, String formatName)
    {
        for(int x = 0; x < windowWidth; x++)
        {
            for(int y = 0; y < windowHeight; y++)
            {
                int pixelValue = 0;
                randomlyGeneratedImage.setRGB(x, y, pixelValue);
            }
        }

        saveImage(randomlyGeneratedImage, filePath, formatName);
    }

    public void saveImage(BufferedImage image, String filePath, String formatName)
    {
        ImageHandler.saveImage(image, filePath, formatName);
    }

    public void saveImage(String filePath, String formatName)
    {
        ImageHandler.saveImage(randomlyGeneratedImage, filePath, formatName);
    }

    public BufferedImage loadImage(String filePath)
    {
        return ImageHandler.loadImage(filePath);
    }
}