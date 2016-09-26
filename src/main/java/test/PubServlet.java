package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SrcServlet
 */
public class PubServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
   public static final String HTML_START="<html><head><title>Hello World Servlet, S2I</title></head><body>";
   public static final String HTML_END="</body></html>";
       
   /**
    * @see HttpServlet#HttpServlet()
    */
   public SrcServlet() {
      super();
   }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      PrintWriter out = response.getWriter();
      try {
         Date date = new Date();
         InetAddress ip = InetAddress.getLocalHost();
         String host = ip.getHostName();
	 
         out.println(HTML_START + "<h2>Hello, world!</h2><br/><h3>Host="+host+"</h3><h3>Date="+date +"</h3>"+ HTML_END);
      } 
      finally {
         out.close();
      }
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
