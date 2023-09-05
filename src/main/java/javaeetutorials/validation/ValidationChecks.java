package javaeetutorials.validation;

import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.executable.ExecutableValidator;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import javaeetutorials.validation.constraintComposition.BadEmail;
import javaeetutorials.validation.groups.InnItem;
import javaeetutorials.validation.groups.NewType;
import javaeetutorials.validation.groups.OldType;
import javaeetutorials.validation.implBasedOnContext.PassportItem;
import javaeetutorials.validation.simpleConstraint.Laptop;
import javaeetutorials.validation.withInterceptor.User;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;

@Path("validations")
public class ValidationChecks {

    @Inject
    private Validator validator;


    @GET
    @Path("lapNotNull")
    public Response getLaptopNotNullError() {
        Laptop laptop = new Laptop();
        laptop.versionId = null;

        Set<ConstraintViolation<Laptop>> constraintViolations = validator.validate(laptop);

        return Response.status(Response.Status.FORBIDDEN).entity(
                constraintViolations.toString()
        ).build();
    }

    @GET
    @Path("lapNotNullProgrm")
    public Response getLaptopNotNullProgramError() {
        Laptop laptop = new Laptop();
        laptop.versionId = null;

        Validator validator1;
        try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
            validator1 = factory.getValidator();
        }

        Set<ConstraintViolation<Laptop>> constraintViolations = validator1.validate(laptop);

        return Response.status(Response.Status.FORBIDDEN).entity(
                constraintViolations.toString()
        ).build();
    }

    @GET
    @Path("badEmail")
    public Response getBadEmailError() {
        BadEmail badEmail = new BadEmail();
        badEmail.badEmail = "23";

        Set<ConstraintViolation<BadEmail>> constraintViolations = validator.validate(badEmail);

        return Response.status(Response.Status.FORBIDDEN).entity(
                constraintViolations.toString()
        ).build();
    }

    @GET
    @Path("badPassports")
    public Response getPassportsError() {
        PassportItem ps1 = new PassportItem();
        ps1.id = 123L;
        ps1.type = "old";
        ps1.info = "good passport";

        PassportItem ps2 = new PassportItem();
        ps2.id = null;
        ps2.type = "old";
        ps2.info = "good passport";

        PassportItem ps3 = new PassportItem();
        ps3.id = 123L;
        ps3.type = null;
        ps3.info = "good passport";

        Set<ConstraintViolation<PassportItem>> constraintViolations = validator.validate(ps1);
        Set<ConstraintViolation<PassportItem>> constraintViolations1 = validator.validate(ps2);
        Set<ConstraintViolation<PassportItem>> constraintViolations2 = validator.validate(ps3);

        return Response.status(Response.Status.FORBIDDEN).entity(
                List.of(constraintViolations, constraintViolations1, constraintViolations2).toString()
        ).build();
    }

    @GET
    @Path("badInn")
    public Response getInnError() {
        InnItem inn1 = new InnItem();
        inn1.value = "23424";
        inn1.type = "2342342";
        inn1.legacyType = null;

        InnItem inn2 = new InnItem();
        inn2.value = "23424";
        inn2.type = null;
        inn2.legacyType = "sdfasdfasdf";

        Set<ConstraintViolation<InnItem>> constraintViolations = validator.validate(inn1, OldType.class);
        Set<ConstraintViolation<InnItem>> constraintViolations1 = validator.validate(inn2, NewType.class);

        String err1 = "OldType interface :" + constraintViolations.toString();
        String err2 = "NewType interface :" + constraintViolations1.toString();

        return Response.status(Response.Status.FORBIDDEN).entity(
                err1.concat("\n").concat(err2)
        ).build();
    }

    @GET
    @Path("methodCheck")
    public Response methodCheck() throws NoSuchMethodException {
        InnItem inn = new InnItem();
        inn.value = "23424";
        inn.type = "2342342";
        inn.legacyType = null;

        Method createInnByCountry = inn.getClass().getMethod("createInnByCountry", String.class);
        ExecutableValidator executableValidator = validator.forExecutables();
        Set<ConstraintViolation<InnItem>> validated = executableValidator.validateReturnValue(inn, createInnByCountry, new Object[]{"11"});

        return Response.status(Response.Status.FORBIDDEN).entity(
                validated.toString()
        ).build();
    }

    @Inject
    private User user;

    @GET
    @Path("checkIntercepting")
    public Response checkIntercepting() {
        return Response.status(Response.Status.FORBIDDEN).entity(user.getName()).build();
    }
}