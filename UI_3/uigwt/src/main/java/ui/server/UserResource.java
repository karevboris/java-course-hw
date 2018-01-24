package ui.server;

import com.netcracker.Entities.User;
import com.netcracker.Service.UserService.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ui.shared.UserGWT;

import javax.ws.rs.*;
import java.util.LinkedList;
import java.util.List;

@Path("user")
public class UserResource {
    private ApplicationContext context = new ClassPathXmlApplicationContext("ui/context.xml");
    private UserService userService = (UserService)context.getBean("userBean");

    @GET
    @Produces("application/json")
    public List<UserGWT> getAll(){
        List<UserGWT> userGWTS = new LinkedList<>();
        for(User user:userService.getAll()){
            userGWTS.add(new UserGWT(user.getId(), user.getLogin(), user.getPassword(), user.getAdmin()));
        }
        return userGWTS;
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public UserGWT get(@PathParam("id") int id){
        User user = userService.readById(id);
        return new UserGWT(user.getId(), user.getLogin(), user.getPassword(), user.getAdmin());
    }

    @POST
    @Consumes("application/json")
    public void add(UserGWT userGWT){
        userService.add(new User(userGWT.getPassword(),userGWT.getAdmin(),userGWT.getLogin()));
    }

    @POST
    @Path("/update")
    @Consumes("application/json")
    public Boolean update(UserGWT userGWT){
        if(userService.readById(userGWT.getId())==null) return false;
        User user = new User(userGWT.getPassword(),userGWT.getAdmin(),userGWT.getLogin());
        user.setId(userGWT.getId());
        userService.update(user);
        return true;
    }

    @DELETE
    @Path("/{id}")
    public Integer deleteById(@PathParam("id") int id){
        User user = userService.readById(id);
        if(user==null) return 1;
        userService.deleteById(id);
        if(userService.readById(id)!=null) return 2;
        return 0;
    }

    @DELETE
    @Consumes("application/json")
    public Integer delete(UserGWT userGWT){
        User user = userService.readById(userGWT.getId());
        if(user==null) return 1;
        user = new User(userGWT.getPassword(),userGWT.getAdmin(),userGWT.getLogin());
        user.setId(userGWT.getId());
        userService.delete(user);
        if(userService.readById(userGWT.getId())!=null) return 2;
        return 0;
    }
}
