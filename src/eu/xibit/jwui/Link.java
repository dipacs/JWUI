package eu.xibit.jwui;

/**
 * This class represents a target of a link. You can define the target url, and the typo of opening the link.
 * 
 * @author dipacs
 */
public final class Link {

    private String url; 
    private boolean inNewTab = false;  




	/**
	 * Creates a new instance of <code>Link</code>.
	 * @param url 
	 */
    public Link(String url) {
        super();
        this.url = url;
    }




	/**
	 * Returns the target URL of this link.
	 * 
	 * @return 
	 * The target URL of this link.
	 */
    public String getUrl() {
        return this.url;
    }

	/**
	 * Indicates if this link needs to be opened in a new browser tab.
	 * 
	 * @return 
	 * True if this link must be opened in a new browser tab, otherwise false.
	 */
    public boolean isInNewTab() {
        return this.inNewTab;
    }

	/**
	 * Sets the new tab property of this link.
	 * 
	 * @param value 
	 * The new value of the in new tab property.
	 */
    public void setInNewTab(boolean value) {    
        this.inNewTab = value;
    }



	/**
	 * 
	 * @return 
	 */
    @Override
    public String toString() {
        return this.url;
    }

}