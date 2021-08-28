import javax.swing.*;
import java.awt.*;

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

        add(this.view);

        this.view.setPreferredSize(new Dimension(windowWidth, windowHeight));

        pack();
        setVisible(true);
    }
}