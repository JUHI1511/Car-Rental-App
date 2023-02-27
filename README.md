# Car-Rental-App
<hr>
The Car Rental Management System is a Java-based booking solution for renting car. It consolidates data provided by different rental services and hence provides the user details and rates in real-time.Customers may want to make changes in their bookings. The application allows them to book, cancel, view and update their bookings with ease other than this, it eases the management of bookings too. All the bookings,  can be viewed, added and modified on a single application by the administrator

## Admin
```
1.Sign Up and Login
2.View Customer List
3.Crud Operations on Companies6
4.Crud Operations on Variants
5.Crud Operations on Car Details
6.Bookings(Get All Bookings and Booking by Id)
```
## Customer
```
1.Create his user account.
2. Login into the application.
3. Check for available cars.
4.Add update get(only his) delete Customer details.
5. Crud Operations on Bookings.
```
## Application Flow
```
Flow of Data is:
Controller receives the actual object.It is then processed by service layers.
Entity is persisted to DAO (Data Access Object)
While retrieving entity, it is then converted into DTO's with Model Mapper Class.
DTO's is returned.
Exception package consists of a Global Exception Handler and several other custom exception classes.
```
```
Flow of Security is:
Only requests to /registerUser is permitted to all.
Authentication is performed through authentication manager of springframework security.
Upon Successful authentication, accessToken and refreshToken are generated using JWT.
These are returned to the user.
User must include the accessToken in Authorization header of every request henceforth to access authorized APIs.
```

API requests collection on Postman:http://surl.li/fcceh (Shortened URL of Postman)

Setting of accessTokens in postman can be automated using variables and test to set the variable.

