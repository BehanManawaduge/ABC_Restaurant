<?php 
include_once('admin/includes/config.php');

if (isset($_POST['submit'])) {
    $fname = $_POST['name'];
    $emailid = $_POST['email'];
    $phonenumber = $_POST['phonenumber'];
    $bookingdate = $_POST['bookingdate'];
    $bookingtime = $_POST['bookingtime'];
    $noadults = $_POST['noadults'];
    $nochildrens = $_POST['nochildrens'];
    $bno = mt_rand(100000000, 9999999999);

    // Code for Insertion
    $query = mysqli_query($con, "INSERT INTO tblbookings(bookingNo, fullName, emailId, phoneNumber, bookingDate, bookingTime, noAdults, noChildrens) VALUES('$bno', '$fname', '$emailid', '$phonenumber', '$bookingdate', '$bookingtime', '$noadults', '$nochildrens')");

    if ($query) {
        echo '<script>alert("Your order sent successfully. Booking number is: '.$bno.'")</script>';
        echo "<script type='text/javascript'> document.location = 'index.php'; </script>";
    } else {
        echo "<script>alert('Something went wrong. Please try again.');</script>";
    }
}
?>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>Restaurant Table Booking System</title>
    <!-- Meta tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="" />

    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery UI CSS -->
    <link rel="stylesheet" href="css/jquery-ui.css" />
    <!-- Wickedpicker CSS -->
    <link href="css/wickedpicker.css" rel="stylesheet" type='text/css' />

    <!-- Google Fonts -->
    <link href="//fonts.googleapis.com/css?family=Roboto:300,400,500,700" rel="stylesheet">
</head>

<body>
    <div class="container my-5">
        <h1 class="text-center mb-4">Table Booking Form</h1>
        <div class="card p-4 shadow">
            <form action="#" method="post">
                <div class="form-group">
                    <label for="name">Name</label>
                    <input type="text" class="form-control" name="name" id="name" placeholder="Name" required>
                </div>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" name="email" id="email" placeholder="Email" required>
                </div>
                <div class="form-group">
                    <label for="phonenumber">Phone Number</label>
                    <input type="text" class="form-control" name="phonenumber" id="phonenumber" placeholder="Phone Number" required>
                </div>
                <div class="form-group">
                    <label for="bookingdate">Booking Date</label>
                    <input type="text" class="form-control" id="datepicker" name="bookingdate" placeholder="Booking Date" required>
                </div>
                <div class="form-group">
                    <label for="bookingtime">Booking Time</label>
                    <input type="text" id="timepicker" name="bookingtime" class="form-control" placeholder="Time" required onkeypress="return false;">
                </div>
                <div class="form-group">
                    <label for="noadults">Number of Adults</label>
                    <select class="form-control" name="noadults" id="noadults" required>
                        <option value="">Number of Adults</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="nochildrens">Number of Children</label>
                    <select class="form-control" name="nochildrens" id="nochildrens" required>
                        <option value="">Number of Children</option>
                        <option value="0">0</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary btn-block" name="submit">Reserve a Table</button>
            </form>
            <div class="text-center mt-3">
                <p>Check Booking <a href="check-status.php" target="_blank">Status</a></p>
                <p>Admin Panel <a href="admin/" target="_blank">Login here</a></p>
            </div>
        </div>
    </div>

    <!-- jQuery and Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <!-- Calendar JS -->
    <script src="js/jquery-ui.js"></script>
    <script>
        $(function () {
            $("#datepicker").datepicker();
        });
    </script>

    <!-- Timepicker JS -->
    <script type="text/javascript" src="js/wickedpicker.js"></script>
    <script type="text/javascript">
        $('#timepicker').wickedpicker({ twentyFour: false });
    </script>
</body>

</html>
