public class GeneratorController
{
    private GeneratorModel model;
    private GeneratorView view;

    public GeneratorController()
    {
        this.model = new GeneratorModel();
        this.view = new GeneratorView(this.model);
    }
}