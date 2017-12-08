import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.StringTokenizer;

public class Create extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        File file = new File(getServletContext().getRealPath("users.txt"));

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        StringBuilder stringBuilder = new StringBuilder();
        while (line != null) {
            stringBuilder.append(line).append('\n');
            StringTokenizer stok = new StringTokenizer(line, "?");
            if (stok.nextToken().equals(login)) {
                resp.sendError(400, "Login already used");
            }
            line = reader.readLine();
        }
        stringBuilder.append(login).append('?').append(password);

        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(stringBuilder.toString());
        fileWriter.close();
        writer.println(
                "<html>\n" +
                        "<body>\n" +
                        "<p> Welcome " + login + "</p>" +
                        "</form>\n" +
                        "</body>\n" +
                        "</html>");
    }
}
