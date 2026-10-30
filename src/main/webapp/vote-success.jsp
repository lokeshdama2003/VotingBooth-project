<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Vote Confirmation</title>

    <link rel="stylesheet" href="css/style.css">

</head>

<body>

<header>

    <h1>Electronic Voting Booth</h1>

    <p>Vote Confirmation</p>

</header>


<div class="container">

    <div class="card">

        <h2 class="success">
            &#10003; Vote Successfully Recorded
        </h2>


        <p>
            <b>Voter ID:</b>

            <%= request.getAttribute("voterId") %>
        </p>


        <p>
            <b>Party Selected:</b>

            <%= request.getAttribute("partyName") %>
        </p>


        <p>
            <b>Vote ID:</b>

            <%= request.getAttribute("voteId") %>
        </p>


        <p>
            <b>Status:</b> Vote Confirmed
        </p>


        <hr>


        <p>
            Thank you. Your vote has been recorded successfully.
        </p>


        <a href="vote.html">

            <button type="button">
                Back to Voting
            </button>

        </a>


        <a href="results">

            <button type="button">
                View Results
            </button>

        </a>

    </div>

</div>


<footer>

    Electronic Voting System

</footer>

</body>

</html>