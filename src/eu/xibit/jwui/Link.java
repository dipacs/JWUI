package eu.xibit.jwui;

public final class Link {

    private String url; 
    private boolean inNewTab = false;  




    public Link(String url) {
        super();
        this.url = url;
    }




    public String getUrl() {
        return this.url;
    }

    public boolean isInNewTab() {
        return this.inNewTab;
    }

    public void setInNewTab(boolean value) {    
        this.inNewTab = value;
    }



    @Override
    public String toString() {
        return this.url;
    }

}