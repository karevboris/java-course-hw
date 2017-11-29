import org.json.simple.JSONObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "myServlet")
public class myServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        double coefA = Double.parseDouble((String)request.getParameter("coefA"));
        double coefB = Double.parseDouble((String)request.getParameter("coefB"));
        double coefC = Double.parseDouble((String)request.getParameter("coefC"));

        JSONObject json = new JSONObject();
        if (coefA!=0) {
            double D = (coefB) * (coefB) - 4 * coefA * coefC;
            if (D < 0) {
                json.put("x1", "negativeDiscrimenant");
                json.put("x2", "negativeDiscrimenant");
            } else {
                json.put("x1", (-coefB + Math.sqrt(D)) / (2 * coefA));
                json.put("x2", (-coefB - Math.sqrt(D)) / (2 * coefA));
            }
        } else{
            if (coefB!=0) {
                json.put("x1", -coefC/coefB);
                json.put("x2", "-");
            } else if(coefC==0){
                json.put("x1", "x-любое");
                json.put("x2", "x-любое");
            } else {
                json.put("x1", "incorrectly");
                json.put("x2", "incorrectly");
            }
        }

        response.setContentType("application/json");
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json.toString());
    }
}
