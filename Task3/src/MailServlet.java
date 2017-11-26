import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.StringTokenizer;

@WebServlet(name = "MailServlet")
public class MailServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            final String username = "myexampleservlet@gmail.com";
            final String password = "myexampleservlet123";

            Properties props = new Properties();
            props.put("mail.smtp.user", username);
            props.put("mail.smtp.password", password);
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            Session session = Session.getDefaultInstance(props,
                    new Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });

            PrintWriter writer = response.getWriter();

            try {
                Message msg = new MimeMessage(session);
                msg.setFrom(new InternetAddress(username));

                String email = request.getParameter("cc");
                StringTokenizer stok = new StringTokenizer(email, ";");

                InternetAddress dests[]=new InternetAddress[stok.countTokens()+1];
                dests[0] = new InternetAddress(request.getParameter("email"));
                int i=1;
                while (stok.hasMoreTokens()) {
                    dests[i] = new InternetAddress(stok.nextToken());
                    i++;
                }

                msg.addRecipients(Message.RecipientType.TO, dests);

                msg.setSubject(request.getParameter("subject"));
                msg.setText(request.getParameter("text"));

                Transport.send(msg);
                String title = "Send Email";
                String res = "Sent message successfully....";
                String docType =
                        "<!doctype html public \"-//w3c//dtd html 4.0 " +
                                "transitional//en\">\n";
                writer.println(docType +
                        "<html>\n" +
                        "<head><title>" + title + "</title></head>\n" +
                        "<body bgcolor=\"#f0f0f0\">\n" +
                        "<h1 align=\"center\">" + title + "</h1>\n" +
                        "<p align=\"center\">" + res + "</p>\n" +
                        "</body></html>");
            }catch (MessagingException mex) {
                mex.printStackTrace();
            }
        }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
