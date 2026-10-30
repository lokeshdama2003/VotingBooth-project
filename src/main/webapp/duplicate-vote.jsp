<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Duplicate Vote</title>
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
            &#9888; Duplicate Vote
        </h2>
        <p>
            You have already voted.
        </p>
        <p>
            A voter can vote only once.
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