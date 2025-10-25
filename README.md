# Selenium Automation Assignment

## Project Overview
This project is an **automation assignment using Selenium and TestNG** 
The automation covers **end-to-end user and admin scenarios** for the website: [Daily Finance](https://dailyfinance.roadtocareer.net/).

The main objectives include:
- User registration and email verification
- Password reset (positive & negative scenarios)
- Item addition and validation
- User profile update and login verification
- Admin functionalities (search users, CSV registration, export users)
- Generating Allure reports for test results

The project follows **Page Object Model (POM) architecture** for maintainability and scalability.

---

## Test Scenarios / Features

### User Registration
- Register a new user (`gmailuser+<random_digit>@gmail.com`)
- Assert that a congratulations email is received

### Password Reset
- Negative test: invalid email
- Negative test: blank email
- Valid email password reset
- Assert login with the new password

### Item Management
- Add 2 items: one with all fields, one with only mandatory fields
- Verify both items appear in the item list

### User Profile Update
- Update user Gmail
- Assert login with updated email is successful
- Assert login with previous email fails

### Admin Actions
- Login securely using admin credentials (from terminal)
- Search for updated user email
- Register 3 users using CSV file
- Export all users to a text file

## Technologies Used
- Java
- Selenium WebDriver
- TestNG
- Gradle
- Allure Reports
- OpenCSV / FileWriter (for CSV and text file handling)




