<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Search User</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/grid/kendo.common.min.css"/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/grid/kendo.default.min.css"/>"></link>    
	<script src="<c:url value="/resources/js/vendor/jquery-1.12.1.js"/>"></script>
	<script	src="<c:url value="/resources/js/vendor/kendo.all.min.js"/>"></script>
</head>
<body>

<div id="example">
    <div id="grid"></div>
    <script>
        $(document).ready(function () {
            $("#grid").kendoGrid({
                dataSource: {
                    type: "odata",
                    transport: {
                        read: "http://demos.telerik.com/kendo-ui/service/Northwind.svc/Customers"
                    },
                    pageSize: 20
                },
                height: 550,
                sortable: true,
                pageable: {
                    refresh: true,
                    pageSizes: true,
                    buttonCount: 5
                },
                columns: [{
                    template: "<div class='customer-photo' style='background-image: url(../content/web/Customers/#:data.CustomerID#.jpg);'></div> <div class='customer-name'>#: ContactName #</div>",
                    field: "ContactName",
                    title: "Name",
                    width: 240
                }, {
                    field: "ContactTitle",
                    title: "Address"
                }, {
                    field: "CompanyName",
                    title: "Owner"
                }, {
                    field: "Country",
                    title: "Email Id",
                    width: 150
                }]
            });
        });
    </script>
</div>

<style type="text/css">
    .customer-photo {
        display: inline-block;
        width: 32px;
        height: 32px;
        border-radius: 50%;
        background-size: 32px 35px;
        background-position: center center;
        vertical-align: middle;
        line-height: 32px;
        box-shadow: inset 0 0 1px #999, inset 0 0 10px rgba(0,0,0,.2);
        margin-left: 5px;
    }

    .customer-name {
        display: inline-block;
        vertical-align: middle;
        line-height: 32px;
        padding-left: 3px;
    }
</style>


</body>
</html>