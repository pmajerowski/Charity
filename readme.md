

<h1>  Charity donnation - "oddam w dobre ręce"</h1>

![decoration](https://user-images.githubusercontent.com/105345146/226097518-5563ed41-c010-4b16-a67f-b4a71f48c2d1.svg)
  

<h2>Overview</h2>
</hr>
Charity donation is an in-progress educational purposes project.<br>
The aim of the project is to create a place where everyone will be able to give away unnecessary things to trusted institutions. <br>
If the user has things at home that he does not use but are in good condition and he wants to give them to people who can use them - but he does not know how to do it easily - there it comes. The application sets up a clear and easy-to-use interface for the user to declare a donation, select a trusted foundation, and arrange transportation.
<br>
The application is designed following Model-View-Controller architecture separating services and repositories from controllers and views.
<br>


<h2>Technologies used</h2>
 </hr>
<ul>
  <li>Java</li>
  <li>Spring boot</li>
  <li>Spring Security</li>
  <li>Hibernate / JPA</li>
  <li>Docker</li>
  <li>MySQL</li>
  <li>Maven</li>
  <li>JUnit 5</li>
  <li>Mockito</li>
  <li>JSP</li>
  <li>CSS</li>
  <li>JavaScript</li>
  <li>Lombok</li>
  
</ul>


<h2>Building and running</h2>
<hr>

<h3>Prerequisites</h3>

Before you can build and run this application, you need to have the following software installed on your machine:
<br>
 <ul>
  <li><a href="https://www.oracle.com/pl/java/technologies/downloads/">Java</a> JDK version 11 or later</li>
  <li><a href="https://maven.apache.org/download.cgi">Maven</a> version 3.6 or later</li>
  <li><a href="https://www.docker.com/products/docker-desktop/">Docker</a> version 20.10 or later</li>
  <li><a href="https://docs.docker.com/compose/install/">Docker Compose</a> version 2.12 or later</li>
 </ul>
 
<h3>Building the Application</h3>
To build the application, run the following command from the root directory of the project:
<li>
$ <code>mvn clean package</code>
  </li>
 

This will compile the Java code, run the tests, and produce a JAR file containing the application.
<br>

<h3>Running the Application</h3>

To run the application along with a database deployed via docker-compose.yml, follow the steps below: <br>
<ol>
  <li>Open a terminal and navigate to the root directory of the project.</li>
  <li>Run the following command to start the database - remember that Docker desktop must be up and running:</li>
  $ <code>docker-compose up -d</code> <br>
This will download and start the necessary Docker images for the database, and create a Docker network for them to communicate on.
<br>
<li><strong>OPTIONAL</strong></li>
  <p>In order to activate the email sending features it is required to configure environmental variables. The messages will then be sent from the given email account.</p>
  <ul>
  <li>$ <code>export EMAIL=</code>{email_address} </li>
  <li>$ <code>export EMAIL_PASSWORD=</code>{email_password} <br>
    (note: some services, e.g. Google, require unique generated token. <br>
    Find out more: <a href="https://www.getmailbird.com/gmail-app-password/">https://www.getmailbird.com/gmail-app-password/</a>)</li>
  <li>$ <code>export HOST_NAME=</code>{host_name}</li>
  <li>$ <code>export PORT=</code>{port}</li>
  <br>
  </ul>

(<strong>note: IF YOU DECIDE TO CONFIGURE THE ENVIRONMENTAL VARIABLES, in order to finish the registration process you'll need to activate the account using a link sent to you by email - the real email address would be required in the registration process</strong>)
 
  <li>Run the application with this command:</li>
  $ <code>java -jar target/charity-0.0.1-SNAPSHOT.jar</code> <br>
  
  This will start the Tomcat server embedded within Spring Boot.
  
  <li>Open a web browser and navigate to  <strong>http://localhost:8080</strong> . You should see the home page of the application.</li>
 
 </ol>
    
 <h3> Stopping the Application</h3>
 To stop the application and the database, press <kbd>control+C</kbd> in the terminal.
 
 <h2>Usage</h2>
 <hr>
 
 <p>Apart from the landing page, the main application is available for logged users only. In order to proceed you can either register, creating a new account, or log in using below credentials:<br>
  <ul>login as user: 
    <li> email: <code> test@charity_donation.com </code>
    <li>password: <code> CharityDonation33$ </code>
  </ul>
  <ul>login as admin: 
    <li> email: <code> admin@charity_donation.com </code>
    <li>password: <code> CharityDonation44$ </code>
  </ul>
  </p>
  <p>
  It is important to note that - in the current version - not all the functionalities are implemented. Some links might not work as expected. But the main part which is the donation form works perfectly fine, adds donations to the database and sends a confirmation email.
  </p>

<h2>Acknowledgments</h2>

The purpose of the Charity project is strictly educational. All layout templates were provided by Coders Lab - School of IT. The main part of JavaScript and CSS were pre-written - only some parts (like form verification) were implemented during the process. <br>
However, the back end of the application was made from scratch using the technologies listed above. 
