package com.cops.ntsf.controller;

import com.cops.ntsf.model.Complaint;
import com.cops.ntsf.dao.ComplaintDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ViewComplaintByID extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user_id = request.getParameter("user_id");
        List<Complaint> complaintDetails = ComplaintDAO.viewComplaintByID(user_id);
        request.setAttribute("complaintDetails", complaintDetails);
        RequestDispatcher dis = request.getRequestDispatcher("complaints.jsp");
        dis.forward(request, response);


//        for (int i = 0; i<complaintDetails.size(); i++)
//        {
//            System.out.print(complaintDetails.get(i).getUser_id());
//            System.out.print(complaintDetails.get(i).getTitle());
//            System.out.print(complaintDetails.get(i).getDescription());
//            System.out.print(complaintDetails.get(i).getComplaint_no());
//        }


    }
}
