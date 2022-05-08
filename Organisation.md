This is what each team member in this group has contributed to this project:

-Jessie
*I implemented the Concert and Performer domain classes and also helped annotate the DTOs to ensure proper serialisation and de-serialisation. 
 I implemented the Config class for the authentication cookie and the Concert and Performer mappers. Other than that, I also implemented some APIs in the ConcertResource. 
-Jasveer
*I implemented User domain class and helped in implementing some APIs in the ConcertResource. Some of the APIs I implemented were overridden by Jessie 
 when he pushed his implementations of the APIs to the repo. However, I also helped him out in the implementation of the APIs he did.
-David
* Domain - I have constructed BOOKING and SEATS class 
* Mapper - I have completed the BookingMapper and SeatMapper as creating SeatMapper is required before the completion of the BookingMapper
* Service - I have done the login api, and all the concert related api such as retrieve all concerts, retrieve concerts summary



When we first started this project, we have discussed and came into an agreement that all of us will do some parts of each section(Domain,
mapper, and service), which is why there are commits from all of our teammates for domain model. We have constructed our domain model based on the 
concert-common/dto class, ConcertResourceIT class(the testing case so that we know what variable we need to add) and the database(for the annotation).

As for the concurrency issue, 3 of the subscription test were not working hence we were not able to implement any concurrency measures for those test. We tried handling the 
concurrency issue through pessimistic locking as is implemented in many of the APIs. The read locks can be obtained and read when needed. 