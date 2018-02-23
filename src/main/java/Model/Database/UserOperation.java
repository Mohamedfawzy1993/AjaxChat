package Model.Database;

import Beans.User;

import java.util.HashMap;

public class UserOperation {

    HashMap<String , User> userHashMap ;

    public UserOperation(HashMap<String , User> map)
    {
        userHashMap = map;
    }


    public User getUser(String userName)  {
        User user = userHashMap.get(userName);
        return user;
    }

    public void setUser(User user){
        userHashMap.put(user.getUsername() , user);
    }
}
