<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="produtcs">
    <h2>
       Product
    </h2>
    <form:form modelAttribute="product" class="form-horizontal" id="add-product-form">
        <div class="form-group has-feedback">
            <petclinic:inputField label="Name" name="name"/>
            <petclinic:inputField label="Price" name="price"/>
           <%-- <select class="form-control mb-4" id="productType" label="ProductType" name="productType">
                            <c:forEach items="${producttypes}" var="producttype">
                            <option value="${producttype.name}">${producttype.name}"</option>
                            </c:forEach>
           </select> --%>
           <div class="control-group">
           	<petclinic:selectField label="Product Type" name="productType" size="3" names="${productType}"></petclinic:selectField>
           </div>
           
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
            	<input type="hidden" name="id" value="${card.id}">
                <button class="btn btn-default" type="submit">Add product</button>
                   
                   
            </div>
        </div>
    </form:form>
</petclinic:layout>