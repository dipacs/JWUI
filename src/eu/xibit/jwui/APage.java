/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.xibit.jwui;

import eu.xibit.jwui.components.AComponent;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class is the base class of all the JWUI pages. You need to create a servlet which inherited from this class.
 * In you servlet class, overwrite initPage(...) abstract method, and create your UI as you want. A hello world page 
 * may looks like this: 
 * <p><pre><code>
 * public class JwuiTest extends APage {
 * 
 *     protected void initPage(Request request, Response response) {
 *         // creating a label
 *         Label lbl = new Label();
 *         
 *         // setting propertyes of the label
 *         lbl.setText("Hello Wrold!");
 *         lbl.setFontFamily(EFontFamily.ComicSansMS);
 *         lbl.setFontSize(32);
 * 
 *         // adding the label as the root component of this page
 *         this.setRootComponent(lbl);
 *     }
 * }
 * </code></pre></p>
 * @author dipacs
 */
public abstract class APage extends HttpServlet {

    private AComponent rootComponent;
    private final List<String> javaScriptIncludes = new ArrayList<>();
    private String title = "Untitled Document";

    
    
    
    @Override
    protected final void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        initPage(new Request(req), new Response(resp));
        if (rootComponent != null) {
            PrintWriter out = resp.getWriter();
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html;charset=UTF-8");

            out.println("<!DOCTYPE html>");
            out.println("<html><head>");
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
            String t = this.title;
            if (t == null || t.equals("")) {
                t = "Untitled Document";
            }
            out.println("<title>" + t + "</title>");
            for (String scriptUrl : javaScriptIncludes) {
                out.println("<script type=\"text/javascript\" src=\"" + scriptUrl + "\"></script>");
            }
            /*
             * <script type="text/javascript" src="ABC.js"></script>
             */
            
            out.println("</head><body style=\"margin:0;padding:0;\">");
            out.println(rootComponent.render());
            out.println("</body></html>");
            out.close();
        }
    }

    @Override
    protected final void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
    
    @Override
    public final String getServletInfo() {
        String title = this.getTitle();
        if (title == null || title.equals("")) {
            title = "Untitled Document";
        }
        return "JWUI page: " + title;
    }

    
    
    public AComponent getRootComponent() {
        return rootComponent;
    }

    public void setRootComponent(AComponent rootComponent) {
        this.rootComponent = rootComponent;
    }

    public List<String> getJavaScriptIncludes() {
        return javaScriptIncludes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    
    
    protected abstract void initPage(Request request, Response response);
}
