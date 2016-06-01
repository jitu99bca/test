<%@page import="com.achp.spring.mongodb.mode.Person"%>
<%@page import="java.util.List"%>
<%@page import="com.achp.spring.mongodb.util.MongoTemplateUtil"%>
<%@page import="org.springframework.data.mongodb.core.MongoTemplate"%>
<%@page import="com.achp.spring.mongodb.service.PersonServiceUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<liferay-theme:defineObjects />
<portlet:defineObjects />
<portlet:actionURL  var="savePerson" name="savePerson">
</portlet:actionURL>
<portlet:actionURL  var="updatePerson" name="updatePerson">
</portlet:actionURL>
<portlet:actionURL  var="litsPersons" name="litsPersons">
</portlet:actionURL>

 <form action="<%=savePerson.toString()%>" method="post">
            <label for="name">Person Name</label>
           <input type="text" id="<portlet:namespace/>name" name="<portlet:namespace/>name"/>
            <input type="submit" value="Submit"/>
        </form>
 <%
 MongoTemplate mongoTemplate=MongoTemplateUtil.getMongoTemplate();
 List<Person> persons=PersonServiceUtil.listPerson(mongoTemplate);
 /* for(Person person:persons){
	 System.out.println("persons::::" + person.getName());
 } */
 //System.out.println("persons::::***"+persons.toString() );
 
 
 %>
    <table border="1">
    <%for(Person person:persons){ 
    %>
    <portlet:actionURL  var="deletePerson" name="deletePerson">
    <portlet:param name="id" value="<%=person.getId()%>"/>
    
   
   </portlet:actionURL>
   
            <tr>
                 <td style="width:300px;"><%=person.getName() %></td>
                <td><input type="button" value="delete" onclick="window.location='<%=deletePerson.toString()%>'"/></td>
            </tr>
        <%} %>
    </table>  
