<%@page session="true" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>ClayMorphism Login</title>
<style>
@import url("https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap");

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: "Poppins", sans-serif;
}

:root {
  --dark-dimmed: #2f363e;
  --accent: #ffcc33;
  --accent-dimmed: #ffcc33;
  --light: #fff;
}

body {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  margin: 10px;
  background: var(--dark-dimmed);
}

.container {
  position: relative;
  width: 350px;
  min-height: 500px;
  display: flex;
  justify-content: center;
  align-items: center;
  background: var(--dark-dimmed);
  box-shadow: 25px 25px 75px rgba(0, 0, 0, 0.25),
    10px 10px 70px rgba(0, 0, 0, 0.25), inset 5px 5px 10px rgba(0, 0, 0, 0.5),
    inset 5px 5px 10px rgba(255, 255, 255, 0.2),
    inset -5px -5px 15px rgba(0, 0, 0, 0.75);
  border-radius: 50px;
  padding: 50px;
}

form {
  position: relative;
  width: 100%;
}

.container h3 {
  color: var(--light);
  font-weight: 600;
  font-size: 2em;
  width: 100%;
  text-align: center;
  margin-bottom: 30px;
  letter-spacing: 2px;
  text-transform: uppercase;
}

.inputBox {
  position: relative;
  width: 100%;
  margin-bottom: 15px;
}

.inputBox span {
  display: inline;
  color: var(--light);
  margin-bottom: 10px;
  text-transform: uppercase;
  letter-spacing: 1px;
  font-size: 0.75em;
  border-left: 4px solid #fff;
  padding-left: 4px;
  line-height: 1em;
}

.inputBox .box {
  display: flex;
}

.inputBox .box .icon {
  position: relative;
  width: 48px;
  height: 40px;
  background: var(--accent);
  display: flex;
  justify-content: center;
  align-items: center;
  border-radius: 50%;
  margin-right: 10px;
  color: var(--light);
  font-size: 1.15em;
  box-shadow: 5px 5px 7px rgba(0, 0, 0, 0.25),
    inset 2px 2px 5px rgba(255, 255, 255, 0.25),
    inset -3px -3px 5px rgba(0, 0, 0, 0.5);
}

.inputBox .box input {
  position: relative;
  width: 100%;
  border: none;
  outline: none;
  letter-spacing: 1px;
  font-size: 0.85em;
  padding: 10px 20px;
  border-radius: 30px;
  box-shadow: 5px 5px 7px rgba(0, 0, 0, 0.25),
    inset 2px 2px 5px rgba(0, 0, 0, 0.35),
    inset -3px -3px 5px rgba(0, 0, 0, 0.5);
}

.inputBox .box input[type="submit"] {
  background: var(--accent-dimmed);
  box-shadow: 5px 5px 7px rgba(0, 0, 0, 0.25),
    inset 2px 2px 5px rgba(255, 255, 255, 0.25),
    inset -3px -3px 5px rgba(0, 0, 0, 0.5);
  color: var(--light);
  cursor: pointer;
  text-transform: uppercase;
  font-weight: 600;
  margin-top: 10px;
}

.inputBox .box input[type="submit"]:hover {
  filter: brightness(1.05);
}

label {
  color: var(--light);
  text-transform: uppercase;
  letter-spacing: 1px;
  font-size: 0.85em;
  display: flex;
  align-items: center;
}

label input {
  margin-right: 5px;
}

.forgot {
  color: var(--light);
  text-transform: uppercase;
  letter-spacing: 1px;
  font-size: 0.85em;
  text-decoration: none;
}

.forgot:hover {
  text-decoration: underline;
}
</style>
</head>

<body>
<%  %><div class="container">
    <form method="POST" action="Login">
      <h3>Log In</h3>
      <div class="inputBox">
        <span>Username</span>
        <div class="box">
          <div class="icon">
            <ion-icon name="person"></ion-icon>
          </div>
          <input name="username" type="text">
        </div>
      </div>

      <div class="inputBox">
        <span>Password</span>
        <div class="box">
          <div class="icon">
            <ion-icon name="lock-closed"></ion-icon>
          </div>
          <input name="password" type="password">
        </div>
      </div>

      <div class="inputBox">
        <div class="box">
          <input type="submit" value="Log in">
        </div>
      </div>

      <a href="#" class="forgot">Forgot the password?</a>

    </form>
  </div>

  <!--  IonIcons  -->
  <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
  <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>

</body>

</html>