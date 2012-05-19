package eu.xibit.jwui.components;

public final class Html extends AComponent {

    private String content = null;

    public Html() {
        super();
    }




    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }



    @Override
    public String render() {
        if (this.content == null) {
            return "";
        }
        return this.content + "\n";
    }

}