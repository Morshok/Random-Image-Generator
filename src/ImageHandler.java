import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageHandler
{

    private ImageHandler() { }

    public static BufferedImage loadImage(String filePath)
    {
        try
        {
            File file = new File(filePath);
            return ImageIO.read(file);
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public static void saveImage(BufferedImage image, String filePath, String formatName)
    {
        try
        {
            File file = new File(filePath);
            ImageIO.write(image, formatName, file);
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}