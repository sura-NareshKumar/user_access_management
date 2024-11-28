# user_access_management

A web-based application for managing user access to software applications in an organization. This system supports user registration, role-based access, software management, and access request approvals.

Features:-----
User Registration: New users can sign up and are assigned the "Employee" role by default.
Login Authentication: Role-based redirection after login:
Admin: Create and manage software.
Manager: View and approve/reject access requests.
Employee: Request access to software.
Software Management: Admins can add new software and define access levels (Read, Write, Admin).
Access Requests: Employees can submit access requests for software.
Approval System: Managers can view, approve, or reject pending access requests.

Technologies Used:-----
Backend: Spring MVC, Spring Boot
Frontend: JSP, HTML, CSS
Database: MySQL
Build Tool: Maven
