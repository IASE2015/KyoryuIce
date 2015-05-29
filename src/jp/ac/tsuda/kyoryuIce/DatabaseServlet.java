package jp.ac.tsuda.kyoryuIce;

//import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
// java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.ac.tsuda.kyoryuIce.Ice;
import jp.ac.tsuda.kyoryuIce.PMF;

/**
 *
 * @author 
 */
public class DatabaseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        Connection con = null;
        try {
            /*Class.forName("org.apache.derby.jdbc.ClientDriver");
            tring driverUrl = "jdbc:derby://localhost:1527/shohin";
            con = DriverManager.getConnection(driverUrl, "db", "db");
            Statement stmt = con.createStatement();
            String sql = "select from "+ Ice.class.getName();
            ResultSet rs = stmt.executeQuery(sql);
            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            while (rs.next()) {
                Map<String, Object> record = new HashMap<String, Object>();
                record.put("id", new Integer(rs.getInt("SHOHIN_ID")));
                record.put("name", rs.getString("SHOHIN_NAME"));
                record.put("price", new Integer(rs.getInt("PRICE")));
                list.add(record);
            }
            rs.close();
            stmt.close();
            request.setAttribute("data", list);*/
	        PersistenceManagerFactory factory = PMF.get();
	        PersistenceManager manager = factory.getPersistenceManager();
	        String param1 = request.getParameter("id");
	        PrintWriter out = response.getWriter();
            List<Ice> list = null;
            if (param1 == null || param1 ==""){
                String query = "select from " + Ice.class.getName();
                try {
                    list = (List<Ice>)manager.newQuery(query).execute();
                } catch(JDOObjectNotFoundException e){}
            } else {
                try {
                	Ice data = (Ice)manager.getObjectById(Ice.class,Long.parseLong(param1));
                    list = new ArrayList();
                    list.add(data);
                } catch(JDOObjectNotFoundException e){}
            }
            String res = "[";
            if (list!= null){
                for(Ice d : list){
                    res += "{id:" + d.getId() + ",name:'" + d.getName() + "',price:'" +
                        d.getPrice() + "'},";
                }
            }
            res += "]";
            out.println(res);
            manager.close();

            RequestDispatcher rd = request.getRequestDispatcher("/database.html");
            rd.forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new ServletException(e);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseServlet.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        Connection con = null;
    	//try {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        
        PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
        String param1 = request.getParameter("id");
        PrintWriter out = response.getWriter();
        List<Ice> list = null;
        if (param1 == null || param1 ==""){
            String query = "select from " + Ice.class.getName();
            try {
                list = (List<Ice>)manager.newQuery(query).execute();
            } catch(JDOObjectNotFoundException e){}
        } else {
            try {
            	Ice data = (Ice)manager.getObjectById(Ice.class,Long.parseLong(param1));
                list = new ArrayList();
                list.add(data);
            } catch(JDOObjectNotFoundException e){}
        }
        String res = "[";
        
        if (list != null){
        	for(Ice d : list){
                res += "{id:" + d.getId() + ",name:'" + d.getName() + "',price:'" +
                    d.getPrice() + "'},";
            }
        }
        res += "]";
        out.println(res);
        manager.close();

        RequestDispatcher rd = request.getRequestDispatcher("/database.html");
        rd.forward(request, response);
  
    	/*}catch (Exception e) {
	        throw new ServletException(e);
	    } finally {
	        try {
	            if (con != null) {
	                con.close();
	            }
	        } catch (SQLException e) {
	            throw new ServletException(e);
	        }
	    }*/
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
