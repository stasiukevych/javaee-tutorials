package javaeetutorials.jpa.orm;


import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javaeetutorials.jpa.orm.attributes.Customer;
import javaeetutorials.jpa.orm.attributes.CustomerType;
import javaeetutorials.jpa.orm.ordering.Comment;
import javaeetutorials.jpa.orm.ordering.Newsline;
import javaeetutorials.jpa.orm.primaryKeys.embeddable.News;
import javaeetutorials.jpa.orm.primaryKeys.embeddable.NewsId;
import javaeetutorials.jpa.orm.primaryKeys.idClass.Computer;
import javaeetutorials.jpa.orm.primaryKeys.idClass.LaptopID;
import javaeetutorials.jpa.orm.relationship.Order;
import javaeetutorials.jpa.orm.relationship.OrderLine;
import javaeetutorials.jpa.orm.tables.Laptop;

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

    return Response.ok().entity(entityManager.find(Customer.class, customer.getId()).toString())
        .build();
  }

  @GET
  @Path("persistOrder")
  @Transactional
  public Response fetchingRelationship() {
    Order order = new Order();
    order.setCreation(new Date());
    order.setDescription("order #1");

    OrderLine orderLine = new OrderLine();
    orderLine.setNumberOfLine(1);
    orderLine.setDescription("order line #1");
    entityManager.persist(orderLine);

    OrderLine orderLine1 = new OrderLine();
    orderLine1.setNumberOfLine(2);
    orderLine1.setDescription("order line #2");
    entityManager.persist(orderLine1);

    OrderLine orderLine2 = new OrderLine();
    orderLine2.setNumberOfLine(3);
    orderLine2.setDescription("order line #3");
    entityManager.persist(orderLine2);

    order.setOrderLines(List.of(orderLine, orderLine1, orderLine2));

    entityManager.persist(order);

    return Response.ok().entity(order.toString()).build();
  }

  @GET
  @Path("findOrder")
  @Transactional
  public Response findOrder() {
    // testing fetching

    Order order = entityManager.find(Order.class, 1L);

    System.out.println("Order before getOrderLines: " + order.toString());

    List<OrderLine> orderLines = order.getOrderLines();

    return Response.ok().entity(order + orderLines.toString()).build();
  }

  @GET
  @Path("persistComments")
  @Transactional
  public Response persistComments() throws InterruptedException {
    // testing persist comments

    Comment comment = new Comment();
    comment.setContent("content #1");
    comment.setNickname("hs2");
    comment.setPostedDate(new Date());
    comment.setNote(1);
    entityManager.persist(comment);
    Thread.sleep(10000);

    Comment comment1 = new Comment();
    comment1.setContent("content #2");
    comment1.setNickname("hs4");
    comment1.setPostedDate(new Date());
    comment1.setNote(2);
    entityManager.persist(comment1);
    Thread.sleep(10000);

    Comment comment2 = new Comment();
    comment2.setContent("content #3");
    comment2.setNickname("hs3");
    comment2.setPostedDate(new Date());
    comment2.setNote(5);
    entityManager.persist(comment2);
    Thread.sleep(10000);

    Newsline newsline = new Newsline();
    newsline.setContent("newline cont#1");
    newsline.setComments(new ArrayList<>() {{
      add(comment2);
      add(comment);
      add(comment1);
    }});
    entityManager.persist(newsline);

    return Response.ok().entity(newsline.toString()).build();
  }

  @GET
  @Path("findNewsline")
  @Transactional
  public Response findNewsline() {
    // testing findNewsline

    Newsline newsline = entityManager.find(Newsline.class, 1L);

    System.out.println("Newsline before getComments: " + newsline.toString());

    List<Comment> comments = newsline.getComments();

    return Response.ok().entity(comments.toString()).build();
  }
}