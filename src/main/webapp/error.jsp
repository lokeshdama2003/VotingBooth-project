<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Voting Error</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<header>
    <h1>Electronic Voting Booth</h1>
    <p>Vote Confirmation</p>
</header>

<div class="container">
    <div class="card">
        <h2 class="error">
            &#9888; Voting Failed
        </h2>
        <p>
            The vote could not be recorded.
        </p>

        <p>
            Please check your Voter ID and try again.
        </p>
        <a href="vote.html">
            <button type="button">
                Back to Voting
            </button>
        </a>
    </div>
</div>
<footer>
    Electronic Voting System
</footer>
</body>
</html>