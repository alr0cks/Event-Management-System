# DBMS MiniProject

This is my 3rd year DBMS mini project, made along with Akhil Narang, Aniket Raj and Aditya Maheshwari

It is basically a registration system, which allow users to initially create an account, and then register for various events
Upon registering for an event, they will receive email confirmation along with a Generared QR code.

For database connection, this project requires a `login.properties` file placed in the root of the repository (format given below). It will be ignored by git. It requires a few properties declared in key=value pairs, namely

`username`

`password`

`host`

`port`

`database`

If not set, it will assume default values, which are

```
username=root
password=student123
database=project
hostname=localhost
port=3306
```
