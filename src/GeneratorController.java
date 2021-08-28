import javax.swing.*;
import java.awt.*;

public class GeneratorController extends JFrame
{
    private GeneratorModel model;
    private GeneratorView view;

    public GeneratorController(int width, int height)
    {
        super("Random Image Generator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(50, 50);

        this.model = new GeneratorModel();
        this.view = new GeneratorView(this.model);

        add(this.view);

        this.view.setPreferredSize(new Dimension(width, height));

        pack();
        setVisible(true);
    }
}