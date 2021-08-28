import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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

        JButton generateButton = new JButton();

        add(this.view);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                view.clearRandomImage();
                super.windowClosing(e);
            }
        });

        this.view.setPreferredSize(new Dimension(windowWidth, windowHeight));

        pack();
        setVisible(true);
    }
}