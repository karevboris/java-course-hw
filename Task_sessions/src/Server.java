import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.StringTokenizer;

public class Server extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(true);

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        File file = new File(getServletContext().getRealPath("users.txt"));
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        boolean isCorrect=false;

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (login.equals("")&&password.equals("")&&session.getAttribute("login")!=null){
            writer.println(
                    "<html>\n" +
                            "<body>\n" +
                            "<p> Welcome " + session.getAttribute("login") + "</p>" +
                            "</form>\n" +
                            "</body>\n" +
                            "</html>");
            isCorrect=true;
        } else {
            while (line != null) {
                StringTokenizer stok = new StringTokenizer(line, "?");
                if (stok.nextToken().equals(login)) {
                    if (stok.nextToken().equals(password)) {
                        session.setAttribute("login", login);
                        session.setAttribute("password", password);
                        writer.println(
                                "<html>\n" +
                                        "<body>\n" +
                                        "<p> Welcome " + login + "</p>" +
                                        "</form>\n" +
                                        "</body>\n" +
                                        "</html>");
                    } else {
                        resp.sendError(400, "Incorrect password");
                    }
                    isCorrect = true;
                }
                line = reader.readLine();
            }
        }
        if(!isCorrect) writer.println(
                    "<html>\n" +
                            "<body>\n" +
                            "<form action=\"Create\" method=\"GET\">\n" +
                            "    Login: <input type=\"text\" name=\"login\" value="+login+">\n" +
                            "    <br />\n" +
                            "    Password: <input type=\"text\" name=\"password\" />\n" +
                            "    <input type=\"submit\" value=\"Create\" />\n" +
                            "</form>\n" +
                            "</body>\n" +
                            "</html>");
    }
}