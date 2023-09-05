package javaeetutorials.jpa.orm;


import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import javaeetutorials.jpa.orm.attributes.Customer;
import javaeetutorials.jpa.orm.attributes.CustomerType;
import javaeetutorials.jpa.orm.primaryKeys.embeddable.News;
import javaeetutorials.jpa.orm.primaryKeys.embeddable.NewsId;
import javaeetutorials.jpa.orm.primaryKeys.idClass.Computer;
import javaeetutorials.jpa.orm.primaryKeys.idClass.LaptopID;
import javaeetutorials.jpa.orm.tables.Laptop;

import java.util.Date;

@Path("orm")
public class OrmChecks {

    @Inject
    private EntityManager entityManager;

    @GET
    @Path("findLaptops")
    public Response findAllLaptops() {
        return Response.ok().entity(entityManager.find(Laptop.class, 1L)).build();
    }

    @GET
    @Path("persistWithEmbeddableId")
    @Transactional
    public Response persistWithEmbeddableId() {
        NewsId id = new NewsId();
        id.setTitle("Title #2");
        id.setLanguage("Espanyol");

        News news = new News();
        news.setId(id);
        news.setContent("hhhh jjjjj kkkkk");
        news.setDescription("testing value");

        entityManager.persist(news);

        return Response.ok().entity(entityManager.find(News.class, id).toString()).build();
    }


    @GET
    @Path("persistWithIdClass")
    @Transactional
    public Response persistWithIdClass() {
        Computer computer = new Computer();
        computer.setId(1L);
        computer.setVersion("version 1");
        computer.setName("new version 1");

        entityManager.persist(computer);

        LaptopID laptopID = new LaptopID();
        laptopID.setId(1L);
        laptopID.setVersion("version 1");
        return Response.ok().entity(entityManager.find(Computer.class, laptopID).toString()).build();
    }

    @GET
    @Path("temporalTest")
    @Transactional
    public Response temporalTest() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setDateOfBirth(new Date());
        customer.setRequestToStoreHistory(new Date());
        customer.setNameOfCustomer("customer #1");
        customer.setCustomerType(CustomerType.SHIPPING);

        entityManager.persist(customer);

        return Response.ok().entity(entityManager.find(Customer.class, customer.getId()).toString()).build();
    }
}