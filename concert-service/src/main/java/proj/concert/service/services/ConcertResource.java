package proj.concert.service.services;

import proj.concert.common.dto.ConcertDTO;
import proj.concert.common.dto.UserDTO;
import proj.concert.service.domain.Concert;
import proj.concert.service.domain.User;
import proj.concert.service.mapper.ConcertMapper;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/concert-service")
public class ConcertResource {
    //private static Logger LOGGER = LoggerFactory.getLogger(ConcertUtils.class);
    //private static Logger LOGGER = LoggerFactory.getLogger(ConcertResource.class);
    PersistenceManager p = PersistenceManager.instance();
    //EntityManager em = PersistenceManager.instance().createEntityManager();


    @POST
    @Path("/login")
    public Response login(UserDTO user){
        EntityManager em = p.createEntityManager();

        try{


            em.getTransaction().begin();
            //USER has NOT YET completed!!!
            //was using list before and got an error, asking me to use typedquery
            TypedQuery<User> users = em.createQuery("select a from User a where a.username = :username and a.password = :password", User.class);
            users.setParameter("username", user.getUsername());
            users.setParameter("password", user.getPassword());
            users.setLockMode(LockModeType.OPTIMISTIC);//either optimistic or pessimistic
            em.getTransaction().commit();

            User u = users.getSingleResult();
            if (u == null){
                return Response.status(Response.Status.UNAUTHORIZED).build();
            }
            else{
                NewCookie newCookie = new NewCookie()

                return Response.ok().cookie(newSesson(u,em)).build(); //session doesnt work
            }



        }
        finally{
            em.close();
        }

    }
    @GET
    @Path("/concerts/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getConcertById(@PathParam("id") long id){
        EntityManager em = p.createEntityManager();
        try{
            em.getTransaction().begin();
            Concert concert = em.find(Concert.class, id);
            em.getTransaction().commit();
            if (concert == null){
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            return Response.ok(ConcertMapper.toConcertDTO(concert)).build();
        }
        finally {
            em.close();
        }


    }
"""
    @GET
    @Path("/concerts")
    public Response getAllConcerts(){
        EntityManager em = p.createEntityManager();
        List<ConcertDTO> dtoconcert = new ArrayList<>();
        try{
            em.getTransaction().begin();
            TypedQuery<Concert> concertQuery = em.createQuery("select a from Concert a", Concert.class);
            List<Concert> listconcert = concertQuery.getResultList();
            for (Concert c : listconcert){
                dtoconcert.add(ConcertMapper.toConcertDTO(c));

            }
            //ist<String> list = new ArrayList<String>();
            //GenericEntity<List<String>> entity = new GenericEntity<List<String>>(list) {};
            //Response response = Response.ok(entity).build();

        }

"""





    // TODO Implement this.

}
