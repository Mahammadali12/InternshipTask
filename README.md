# Instructions to run the project (Internship task)

- Extract attached zip folder or clone the repo in the email
- `cd` into the project folder where mvnw exists
- execute `mvn spring-boot:run` to run the project
- in the project folder **task_data.mv.db** file will be created which is the database itself
- project will be started on port 8080, visit `localhost:8080/` for the project

1. User will be reguired *login* and *password* for every endpoint it visits  **except localhost:8080/register** 
2. Visit **localhost:8080/register** and through **html form page** create a user 
3. After submitting form, in  the terminal created user will be indicated with id and other information
4. login to api with `username` and `password` that were submited to **html form**

## Creating Client
- In order to create client (make Post request) visit  localhost:8080/client 
- Enter credentials for client **contactName** **companyName** **phoneNumber** and submit form
-  **Pay attention to the terminal (command line ) that you run** `mvn spring-boot:run`. After submitting form white blank screen welcome you  
- Attributes of the created **Client** will be printed to the terminal
    - Or open inspector of web browser and pay attention to network part, you will see 201 http status code which indicates created. In the payload of the Http response all information about created **Client** will be available including **ID** 
    

## Getting Client
- In order to get client (make Get request) visit localhost:8080/client/{IdOfClient}
- replace {IdOfClient} with desired **Id** of the client. For example `localhost:8080/client/11` which will return client with id of *11*.
- If 404 Error occured repeat **Creating Client** part again or make sure you enter valid **Id** of **Client**
