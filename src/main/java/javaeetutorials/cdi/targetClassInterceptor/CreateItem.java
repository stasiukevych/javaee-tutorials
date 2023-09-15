package javaeetutorials.cdi.targetClassInterceptor;

import jakarta.interceptor.ExcludeClassInterceptors;

public class CreateItem {

/*    @Inject
    private Logger logger;*/

  @ExcludeClassInterceptors
  public String createItems() {
    return "items was created";
  }

  /*  @AroundInvoke
    private Object logMethod(InvocationContext ic) throws Exception {
        logger.entering(ic.getTarget().toString(), ic.getMethod().getName());
        try {
            return ic.proceed();
        } finally {
            logger.exiting(ic.getTarget().toString(), ic.getMethod().getName());
        }
    }*/
}