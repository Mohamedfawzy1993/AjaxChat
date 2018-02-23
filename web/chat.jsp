<%--
  Created by IntelliJ IDEA.
  User: 885
  Date: 2/23/2018
  Time: 12:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>

</head>
<body style="background-image: url('images/Beautiful-Wallpaper.jpg') ; background-repeat: no-repeat;  background-attachment:fixed;   background-size: cover;" >

<div class="container">
    <br><br>
    <div class="row">
        <div class="col text-right">

            <button type="button" class="btn btn-primary"><i class="fas fa-sign-out-alt" style="font-size:21px;color:white"></i></button>
            <br><br><br>
        </div>
    </div>
    <div class="row">
        <div class="col-12 col-md-8">
            <table class="table" style="background-color: white">

                <thead class="thead-dark">
                <tr>
                    <th scope="w-25">Sender</th>
                    <th scope="w-75">Message</th>
                </tr>
                </thead>
                <tbody>
                <tr>

                    <td>Otto</td>
                    <td>@mdo</td>
                </tr>
                <tr>

                    <td>Thornton</td>
                    <td>@fat</td>
                </tr>
                <tr>

                    <td>Larry the Bird</td>
                    <td>@twitter</td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="col-6 col-md-4 ">
            <table class="table"  style="background-color: white">
                <thead>
                <tr>
                    <th>Online Users</th>
                </tr>
                </thead>
                <tr>
                    <td>Mohamed</td>
                </tr>
            </table>
        </div>
    </div>
    <div class="row">
        <div class="input-group mb-3 col-12 col-md-8"  >
            <input type="text" class="form-control" placeholder="Message" aria-label="Message" aria-describedby="basic-addon2">
            <div class="input-group-append">
                <button class="btn btn-outline-secondary" type="button" style="background-color: white">Send</button>
            </div>
    </div>
</div>

</div>

</table>
</body>
</html>
