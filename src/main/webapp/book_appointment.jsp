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
                <a class="nav-link" aria-current="page" href="#">Doctors</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" aria-current="page" href="#">Profile</a>
              </li>
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="#">Book Appointment</a>
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
          <br/>
          <div class="card">
            <div class="card-header">
                List of Doctors
            </div>
            <div class="card-body">
<form id="appointmentForm" novalidate>
    <!-- Doctor Selection -->
    <div class="mb-3">
      <label for="doctorSelect" class="form-label">Select Doctor</label>
      <select class="form-select" id="doctorSelect" name="doctor" required>
        <option value="" disabled selected>Select a doctor</option>
        <option value="Dr. Smith">Dr. Smith</option>
        <option value="Dr. Johnson">Dr. Johnson</option>
        <option value="Dr. Lee">Dr. Lee</option>
      </select>
      <div class="invalid-feedback">Please select a doctor.</div>
    </div>
  
    <!-- Time Slot Selection -->
    <div class="mb-3">
      <label for="timeSlotSelect" class="form-label">Select Time Slot</label>
      <select class="form-select" id="timeSlotSelect" name="timeSlot" required>
        <option value="" disabled selected>Select a time slot</option>
        <option value="9:00 AM">9:00 AM</option>
        <option value="10:00 AM">10:00 AM</option>
        <option value="11:00 AM">11:00 AM</option>
      </select>
      <div class="invalid-feedback">Please select a time slot.</div>
    </div>
  
    <!-- Reason for Appointment -->
    <div class="mb-3">
      <label for="reasonInput" class="form-label">Reason for Appointment</label>
      <textarea class="form-control" id="reasonInput" name="reason" rows="3" required></textarea>
      <div class="invalid-feedback">Please provide a reason for the appointment.</div>
    </div>
  
    <!-- Submit Button -->
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
  
  <script>

    // Bootstrap Validation Script
    (function () {
      'use strict';
  
      // Fetch all the forms we want to apply custom Bootstrap validation to
      const forms = document.querySelectorAll('#appointmentForm');
  
      // Loop over them and prevent submission
      Array.prototype.slice.call(forms).forEach(function (form) {
        form.addEventListener('submit', function (event) {
          if (!form.checkValidity()) {
            event.preventDefault();
            event.stopPropagation();
          }
  
          form.classList.add('was-validated');
        }, false);
      });
    })();
  </script>
  
  </div>
  </div>
  <br><br><br><br>
  <!-- Bootstrap Bundle with Popper -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
  <!-- jQuery -->
  <script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
</body>
</html>
</body>
</html>