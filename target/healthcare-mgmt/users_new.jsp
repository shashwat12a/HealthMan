<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>List Doctors</title>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.5/css/jquery.dataTables.min.css">
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
                <a class="nav-link" aria-current="page" href="/healthcare-mgmt/users/list/">Users</a>
              </li>
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="/healthcare-mgmt/users/add/">Add User</a>
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
                Add a new User
            </div>
            <div class="card-body">
              <form id="registrationForm" method="post" action="/healthcare-mgmt/users/add/" novalidate>
                <div class="mb-3">
                  <label for="email" class="form-label">Email address</label>
                  <input type="email" class="form-control" id="email" name="email" placeholder="Enter your email" required>
                  <div class="invalid-feedback">Please enter a valid email address.</div>
                </div>
                <div class="mb-3">
                  <label for="password" class="form-label">Password</label>
                  <input type="password" class="form-control" id="password" name="password" placeholder="Enter your password" required minlength="6">
                  <div class="invalid-feedback">Password must be at least 6 characters long.</div>
                </div>
                <div class="mb-3">
                  <label for="username" class="form-label">Username</label>
                  <input type="text" class="form-control" id="username" name="username" placeholder="Enter your username" required>
                  <div class="invalid-feedback">Please enter a username.</div>
                </div>
                <div class="mb-3">
                  <label for="role" class="form-label">Role</label>
                  <select class="form-select" name="role" id="role" required>
                    <option>Select a role</option>
                    <option value="doctor">Doctor</option>
                    <option value="patient">Patient</option>
                  </select>
                  <div class="invalid-feedback">Please select a role.</div>
                </div>
          
                <!-- Fields for Doctor -->
                <div id="doctorFields" style="display: none;">
                  <div class="mb-3">
                    <label for="speciality" class="form-label">Speciality</label>
                    <input type="text" name="speciality" class="form-control" id="speciality" placeholder="Enter your speciality">
                    <div class="invalid-feedback">Please enter your speciality.</div>
                  </div>
                  <div class="mb-3">
                    <label for="qualifications" class="form-label">Qualifications</label>
                    <input type="text" name="qualifications" class="form-control" id="qualifications" placeholder="Enter your qualifications">
                    <div class="invalid-feedback">Please enter your qualifications.</div>
                  </div>
                </div>
          
                <!-- Fields for Patient -->
                <div id="patientFields" style="display: none;">
                  <div class="mb-3">
                    <label for="dob" class="form-label">Date of Birth</label>
                    <input type="date" name="dob" class="form-control" id="dob">
                    <div class="invalid-feedback">Please enter your date of birth.</div>
                  </div>
                  <div class="mb-3">
                    <label for="gender" class="form-label">Gender</label>
                    <select class="form-select" name="gender" id="gender">
                      <option value="">Select your gender</option>
                      <option value="male">Male</option>
                      <option value="female">Female</option>
                      <option value="other">Other</option>
                    </select>
                    <div class="invalid-feedback">Please select your gender.</div>
                  </div>
                  <div class="mb-3">
                    <label for="address" class="form-label">Address</label>
                    <textarea class="form-control" name="address" id="address" rows="3" placeholder="Enter your address"></textarea>
                    <div class="invalid-feedback">Please enter your address.</div>
                  </div>
                </div>
          
                <div class="mb-3">
                  <label for="first-name" class="form-label">First Name</label>
                  <input type="text" name="first-name" class="form-control" id="first-name" placeholder="Enter your first name" required>
                  <div class="invalid-feedback">Please enter your first name.</div>
                </div>
                <div class="mb-3">
                  <label for="last-name" class="form-label">Last Name</label>
                  <input type="text" name="last-name" class="form-control" id="last-name" placeholder="Enter your last name" required>
                  <div class="invalid-feedback">Please enter your last name.</div>
                </div>
                <div class="mb-3">
                  <label for="phone" class="form-label">Phone Number</label>
                  <input type="tel" name="phone" class="form-control" id="phone" placeholder="Enter your phone number" required pattern="[0-9]{10}">
                  <div class="invalid-feedback">Please enter a valid 10-digit phone number.</div>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
              </form>
            </div>
            </div>
          </div>
      </div>
      <br><br><br><br>
      <script>
        document.getElementById('role').addEventListener('change', function () {
          const role = this.value;
          const doctorFields = document.getElementById('doctorFields');
          const patientFields = document.getElementById('patientFields');
          
          if (role === 'doctor') {
            doctorFields.style.display = 'block';
            patientFields.style.display = 'none';
            document.getElementById('speciality').setAttribute('required', true);
            document.getElementById('qualifications').setAttribute('required', true);
            document.getElementById('dob').removeAttribute('required');
            document.getElementById('gender').removeAttribute('required');
            document.getElementById('address').removeAttribute('required');
          } else if (role === 'patient') {
            patientFields.style.display = 'block';
            doctorFields.style.display = 'none';
            document.getElementById('dob').setAttribute('required', true);
            document.getElementById('gender').setAttribute('required', true);
            document.getElementById('address').setAttribute('required', true);
            document.getElementById('speciality').removeAttribute('required');
            document.getElementById('qualifications').removeAttribute('required');
          } else {
            doctorFields.style.display = 'none';
            patientFields.style.display = 'none';
          }
        });
    
        document.getElementById('registrationForm').addEventListener('submit', function (event) {
          if (!this.checkValidity()) {
            event.preventDefault();
            event.stopPropagation();
          }
          this.classList.add('was-validated');
        });
      </script>
    <!-- Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
    <!-- DataTables JS -->
    <script src="https://cdn.datatables.net/1.13.5/js/jquery.dataTables.min.js"></script>
</body>
</html>
  </body>
</html>