<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Register Patient</title>
  </head>
  <body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
          <a class="navbar-brand" href="#">Healthcare Mgmt</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="#">Register as Patient</a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
      <br/>
      <svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
        <symbol id="check-circle-fill" fill="currentColor" viewBox="0 0 16 16">
          <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
        </symbol>
        <symbol id="info-fill" fill="currentColor" viewBox="0 0 16 16">
          <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.93-9.412-1 4.705c-.07.34.029.533.304.533.194 0 .487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2z"/>
        </symbol>
        <symbol id="exclamation-triangle-fill" fill="currentColor" viewBox="0 0 16 16">
          <path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
        </symbol>
      </svg>
      <div class="container" style="margin-left: 15%;margin-right: 15%;">
        <div class="alert alert-info d-flex items-align-center alert-dismissible fade show" role="alert">
          <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Info:"><use xlink:href="#info-fill"/></svg>
          <%= request.getAttribute("message") %>
          <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
          <br/>
          <div class="card">
            <div class="card-header">
              Patient Credentials Info
            </div>
            <div class="card-body">
              <form>
                <div class="form-group">
                  <label for="exampleInputEmail1">Email address</label>
                  <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                  <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                </div>
                <div class="form-group">
                  <label for="exampleInputPassword1">Password</label>
                  <input type="password" class="form-control" id="exampleInputPassword1">
                  <small>Must Be 8 Characters long.</small>
                </div>
                <div class="form-group">
                  <label for="exampleInputPassword1">Confirm Password</label>
                  <input type="password" class="form-control" id="exampleInputPassword1">
                </div>
                <!-- <div class="form-group form-check">
                  <input type="checkbox" class="form-check-input" id="exampleCheck1">
                  <label class="form-check-label" for="exampleCheck1">Check me out</label>
                </div> -->
                <br/>
                <!-- <button type="submit" class="btn btn-primary">Submit</button> -->
              </form>
            </div>
          </div>
          <br/>
          <div class="card">
            <div class="card-header">
              Patient Profile Info
            </div>
            <div class="card-body">
              <form class="row g-3">
                <div class="col-md-6">
                  <label for="inputPassword4" class="form-label">First Name</label>
                  <input type="password" class="form-control" id="inputPassword4" placeholder="John">
                </div>
                <div class="col-md-6">
                  <label for="inputAddress" class="form-label">Last Name</label>
                  <input type="text" class="form-control" id="inputAddress" placeholder="Doe">
                </div>
                <div class="col-12">
                  <label for="inputEmail4" class="form-label">Email</label>
                  <input type="email" class="form-control" id="inputEmail4">
                </div>
                <div class="col-12">
                  <label for="inputAddress2" class="form-label">Phone Number</label>
                  <input type="tel" class="form-control" id="inputAddress2" placeholder="+91 1234557889">
                </div>
                <div class="col-12">
                  <label for="inputAddress2" class="form-label">Address</label>
                  <input type="tel" class="form-control" id="inputAddress2" placeholder="123 Main St.">
                </div>
                <div class="col-md-6">
                  <label for="inputCity" class="form-label">City</label>
                  <input type="text" class="form-control" id="inputCity">
                </div>
                <div class="col-md-4">
                  <label for="inputState" class="form-label">State</label>
                  <select id="inputState" class="form-select">
                    <option selected>Choose...</option>
                    <option>Delhi</option>
                    <option>UP</option>
                    <option>Rajasthan</option>
                    <option>Haryana</option>
                    <option>Ladakh</option>
                    <option>Jammu & Kashmir</option>
                    <option>Punjab</option>
                    <option>Uttarakhand</option>
                    <option>Bihar</option>
                    <option>Himachal Pradesh</option>
                    <option>Jharkhand</option>
                    <option>Gujarat</option>
                    <option>Maharastra</option>
                    <option>West Bengal</option>
                    <option>Sikkim</option>
                    <option>Arunachal Pradesh</option>
                    <option>Manipur</option>
                    <option>Meghalaya</option>
                    <option>Assam</option>
                    <option>Nagaland</option>
                    <option>Telangana</option>
                    <option>Andhra Pradesh</option>
                    <option>Kerala</option>
                    <option>Goa</option>
                    <option>Tamil Nadu</option>
                    <option>Puducherry</option>
                    <option>Daman, Diu and Nagar Haveli</option>
                    <option>Andaman and Nicobar</option>
                    <option>Lakshadweep</option>
                  </select>
                </div>
                <div class="col-md-2">
                  <label for="inputZip" class="form-label">Pin code</label>
                  <input type="text" class="form-control" id="inputZip">
                </div>
                <div class="col-12">
                  <!-- <div class="form-check">
                    <label class="form-label">Gender</label>
                    <input class="form-check-input" type="checkbox" id="gridCheck">
                    <label class="form-check-label" for="gridCheck">
                      Male
                    </label>
                  </div> -->
                  <fieldset class="row">
                    <legend class="col-form-label col-sm-2 pt-0">Gender</legend>
                    <div class="col-sm-10">
                      <div class="form-check">
                        <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios1" value="male" checked>
                        <label class="form-check-label" for="gridRadios1">
                          Male
                        </label>
                      </div>
                      <div class="form-check">
                        <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios2" value="female">
                        <label class="form-check-label" for="gridRadios2">
                          Female
                        </label>
                      </div>
                      <div class="form-check">
                        <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios2" value="others">
                        <label class="form-check-label" for="gridRadios2">
                          Others
                        </label>
                      </div>
                    </div>
                  </fieldset>
                </div>
                <div class="col-12">
                  <button type="submit" class="btn btn-primary">Sign in</button>
                </div>
              </form>
            </div>
          </div>
      </div>
      <br><br><br><br>
      <!-- CREATE TABLE Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL, 
    email VARCHAR(255) NOT NULL UNIQUE,
    role ENUM('Admin', 'Doctor', 'Patient') NOT NULL,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    phone_number VARCHAR(15),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
); -->
    <!-- Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

  </body>
</html>