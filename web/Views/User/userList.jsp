<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jspf"%>

<div class="container">
    <div class="row">
        <div class="span3">
            <%@ include file="../common/sidebar.jspf"%>
        </div>
        <div class="span9">
            <div class="well">
                <div class="page-header">
                    <h1>Users Registered to this system</h1>
                </div>

                <table class="table table-bordered table-striped">

                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Action</th>
                        
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach items="${requestScope.userList}" var="currentUser">
                        <tr>
                            <td>Resolve Later</td>
                            <td>${currentUser.name}</td>
                            <td>
                                
                                <form action="Delete" method="post">
                                    <input type="hidden" name="idToDel" value="Resolve Later">
                                    <button type="submit" class="btn btn-primary">DELETE</button>
                                </form>
                                
                            </td>
                            
                        </tr>
                    </c:forEach>

                    </tbody>
                    <tfoot>
                    <tr>
                        
                        <td colspan="2"><div align="center">Todo = <span class="badge">${requestScope.userCount}</span></div></td>
                        
                    </tr>
                    </tfoot>
                </table>

                <c:if test="${empty requestScope.userList}">
                    <div class="alert alert-info">
                        <div align="center">Your todo list is empty !</div>
                    </div>
                </c:if>

                <c:if test="${not empty requestScope.userList}">
                <div align="center">
                   
                    <form action="Delete" method="post">
                        
                        <button type="submit" class="btn btn-primary">Drop Table</button>
                    </form>
                    
                </div>
                </c:if>

            </div>
        </div>
    </div>
</div>

<%--end content--%>
<%@ include file="../common/footer.jspf"%>