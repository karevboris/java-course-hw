import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

@WebServlet(name = "SecondServlet")
public class SecondServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String docType = "<!DOCTYPE html>";
        String title = "Information";

        String agent = req.getHeader("user-agent");
        String browser = null;

        if (agent.indexOf("Firefox")>-1) browser = "Firefox";
        else if (agent.indexOf("Opera")>-1) browser = "Opera";
        else if (agent.indexOf("Chrome")>-1) browser = "Chrome";
        else if (agent.indexOf("MSIE")>-1) browser = "Internet Explorer";
        else if (agent.indexOf("Safari")>-1) browser = "Safari";
        else browser = "Неизвестный";

        PrintWriter writer = resp.getWriter();
        Calendar calendar = Calendar.getInstance();
        String am = (calendar.get(Calendar.AM_PM)==0)?"AM":"PM";

        writer.println(docType + "<html>\n" +
                "<head>" +
                "<title>" + title + "</title>" +
                "</head>" +
                "<body>" +
                "<h1>" + title + "</h1>\n" +
                "<table border=\"1\">"+
                "<tr><td>Date</td><td><i><center>"+calendar.get(Calendar.DAY_OF_MONTH)+"."+calendar.get(Calendar.MONTH)+"."+calendar.get(Calendar.YEAR)+"</central></i></td></tr>"+
                "<tr><td>Time</td><td><i><center>"+calendar.get(Calendar.HOUR)+" : "+calendar.get(Calendar.MINUTE)+" : "+calendar.get(Calendar.SECOND)+ "  " + am + "</central></i></td></tr>"+
                "<tr><td>Browser name</td><td><i><center>" + browser + "</central></i></td></tr>" +
                "</table>" +
                "</body>" +
                "</html>");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
