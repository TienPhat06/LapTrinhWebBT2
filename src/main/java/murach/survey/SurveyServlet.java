//package murach.survey;
//
//import java.io.*;
//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
//import jakarta.servlet.annotation.WebServlet;
//
//import murach.business.User;
//import murach.business.Survey;
//
//@WebServlet("/survey")
//public class SurveyServlet extends HttpServlet {
//
//    @Override
//    protected void doPost(HttpServletRequest request,
//                          HttpServletResponse response)
//            throws ServletException, IOException {
//
//        // 1. Cấu hình bảng mã UTF-8 hỗ trợ Tiếng Việt
//        request.setCharacterEncoding("UTF-8");
//
//        // 2. Mặc định trang điều hướng ban đầu
//        String url = "/index.html";
//
//        // 3. Đọc tham số action từ request
//        String action = request.getParameter("action");
//        if (action == null) {
//            action = "join"; // Mặc định mở trang index.html nếu không truyền action
//        }
//
//        if (action.equals("join")) {
//            url = "/index.html";
//        }
//        else if (action.equals("add")) {
//            // Đọc dữ liệu thông tin cá nhân
//            String firstName = request.getParameter("firstName");
//            String lastName = request.getParameter("lastName");
//            String email = request.getParameter("email");
//            String dateOfBirth = request.getParameter("dateOfBirth");
//
//            // Đọc dữ liệu thông tin khảo sát
//            String heardFrom = request.getParameter("heardFrom");
//            String wantRef = request.getParameter("wantRef");
//            String wantUpdates = request.getParameter("wantUpdates");
//            String contactVia = request.getParameter("contactVia");
//
//            // Xử lý giá trị mặc định cho checkbox khi không được tích
//            if (wantRef == null) {
//                wantRef = "No";
//            }
//            if (wantUpdates == null) {
//                wantUpdates = "No";
//            }
//
//            // Khởi tạo các đối tượng nghiệp vụ (OOP)
//            User user = new User(firstName, lastName, email, dateOfBirth);
//            Survey survey = new Survey(user, heardFrom, wantRef, wantUpdates, contactVia);
//
//            // Lưu đối tượng survey vào request scope để truyền dữ liệu sang JSP
//            request.setAttribute("survey", survey);
//
//            // Chuyển hướng sang trang kết quả thanks.jsp
//            url = "/thanks.jsp";
//        }
//
//        // 4. Forward request và response đến URL mục tiêu
//        getServletContext()
//                .getRequestDispatcher(url)
//                .forward(request, response);
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request,
//                         HttpServletResponse response)
//            throws ServletException, IOException {
//        doPost(request, response);
//    }
//}

package murach.survey;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import murach.business.User;
import murach.business.Survey;

@WebServlet("/survey")
public class SurveyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = "join";
        }

        String url = "/index.html";

        if (action.equals("add")) {
            // 1. Lấy thông tin User từ index.html
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String dateOfBirth = request.getParameter("dateOfBirth");

            User user = new User(firstName, lastName, email, dateOfBirth);

            // 2. Lấy nguồn thông tin (Radio "contactVia" trong index.html)
            String heardFrom = request.getParameter("contactVia");

            // 3. Xử lý Checkbox (Cả 2 checkbox trong index.html đều đặt name="rock")
            String[] rockOptions = request.getParameterValues("rock");
            String wantRef = "No";
            String wantUpdates = "No";

            if (rockOptions != null) {
                for (String option : rockOptions) {
                    if (option.equals("YES, I'd like that")) {
                        wantRef = "Yes";
                    }
                    if (option.equals("YES, please send me email announcement")) {
                        wantUpdates = "Yes";
                    }
                }
            }

            // 4. Phương thức liên hệ (Select box "contact" trong index.html)
            String contactVia = request.getParameter("contact");

            // 5. Khởi tạo đối tượng Survey và gán dữ liệu
            Survey survey = new Survey();
            survey.setUser(user);
            survey.setHeardFrom(heardFrom);
            survey.setWantRef(wantRef);
            survey.setWantUpdates(wantUpdates);
            survey.setContactVia(contactVia);

            // 6. Lưu thông tin vào request attribute để thanks.jsp hiển thị
            request.setAttribute("survey", survey);

            url = "/thanks.jsp";
        }

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}