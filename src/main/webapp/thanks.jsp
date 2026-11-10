<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>

<body>
    <header>
        <img src="images/murach_logo.png" alt="Murach Logo" width="100">
    </header>

    <main>
        <h1>Thanks for filling out our survey</h1>

        <p>Here is the information that you entered:</p>

        <label>First Name:</label>
        <span>${survey.user.firstName}</span><br>

        <label>Last Name:</label>
        <span>${survey.user.lastName}</span><br>

        <label>Email:</label>
        <span>${survey.user.email}</span><br>

        <label>Date of Birth:</label>
        <span>${survey.user.dateOfBirth}</span><br>

        <label>Heard From:</label>
        <span>${survey.heardFrom}</span><br>

        <label>Wants Ref:</label>
        <span>${survey.wantRef}</span><br>

        <label>Wants Updates:</label>
        <span>${survey.wantUpdates}</span><br>

        <label>Contact Via:</label>
        <span>${survey.contactVia}</span><br>

        <p>To enter another survey, click on the Back button in your browser or the Return button shown below.</p>

        <form action="index.html" method="get">
            <input type="hidden" name="action" value="join">
            <input type="submit" value="Return">
        </form>
    </main>
</body>
</html>