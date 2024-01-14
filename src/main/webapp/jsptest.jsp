<html>
<body>
<h2>Hello World JSP!</h2>

<p>Counting to three:</p>
<% for (int i = 1; i < 4; i++) { %>
<li><%= i %>
</li>
<% } %>


<br/>
<a href="/hello">Hello Servlet</a><br/>
<a href="/time">Time Servlet</a><br/>
<a href="/json">JSON Servlet</a><br/>


</body>
</html>
