<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ page import="java.util.List" %>

<%@ page import="com.voting.model.Candidate" %>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Voting Results</title>

    <link rel="stylesheet" href="css/style.css">

</head>

<body>

<header>

    <h1>Electronic Voting Booth</h1>

    <p>Voting Results</p>

</header>


<div class="container">


    <!-- Voting Status -->

    <div class="card center">

        <h2>
            Voting Status:
            <%= request.getAttribute("status") %>
        </h2>

    </div>


    <!-- Turnout -->

    <div class="card">

        <h2>Turnout Statistics</h2>


        <div class="stats">


            <div class="stat-box">

                <p>Total Voters</p>

                <h3>
                    <%= request.getAttribute("totalVoters") %>
                </h3>

            </div>


            <div class="stat-box">

                <p>Votes Cast</p>

                <h3>
                    <%= request.getAttribute("votesCast") %>
                </h3>

            </div>


            <div class="stat-box">

                <p>Turnout</p>

                <h3>
                    <%= request.getAttribute("turnout") %>%
                </h3>

            </div>


        </div>

    </div>


    <!-- Final Results -->

    <div class="card">

        <h2>Final Results</h2>


        <table>

            <thead>

                <tr>

                    <th>Party ID</th>

                    <th>Party</th>

                    <th>Total Votes</th>

                </tr>

            </thead>


            <tbody>

            <%

                List<Candidate> candidates =
                    (List<Candidate>)
                    request.getAttribute("candidates");


                if (candidates != null) {

                    for (Candidate candidate : candidates) {

            %>

                <tr>

                    <td>
                        <%= candidate.getCanId() %>
                    </td>

                    <td>
                        <%= candidate.getCanName() %>
                    </td>

                    <td>
                        <%= candidate.getVoteCount() %>
                    </td>

                </tr>


            <%

                    }

                }

            %>

            </tbody>

        </table>

    </div>


    <div class="center">

        <a href="index.html">

            <button type="button">
                Back to Home
            </button>

        </a>

    </div>


</div>


<footer>

    Electronic Voting System

</footer>

</body>

</html>