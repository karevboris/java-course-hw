import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;
import java.util.StringTokenizer;

public class Cookies extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie userName = new Cookie("login", req.getParameter("login"));
        Cookie userPassword = new Cookie("password", req.getParameter("password"));

        Cookie[] cookies = req.getCookies();

        userName.setMaxAge(60*60*24);
        userPassword.setMaxAge(60*60*24);

        String loginCookie = null;

        for(Cookie cookie:cookies)
        {
            if(cookie.getName().equals("login")) {
                loginCookie = cookie.getValue();
            }
        }

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        File file = new File(getServletContext().getRealPath("users.txt"));
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        boolean isCorrect=false;

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (login.equals("")&&password.equals("")&&loginCookie!=null){
            writer.println(
                    "<html>\n" +
                            "<body>\n" +
                            "<p> Welcome " + loginCookie + "</p>" +
                            "</form>\n" +
                            "</body>\n" +
                            "</html>");
            isCorrect=true;
        } else {
            while (line != null) {
                StringTokenizer stok = new StringTokenizer(line, "?");
                if (stok.nextToken().equals(login)) {
                    if (stok.nextToken().equals(password)) {
                        resp.addCookie(userName);
                        resp.addCookie(userPassword);
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
