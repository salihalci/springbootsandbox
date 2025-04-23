package com.salci_study.restful_web_services.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();



    static {
        users.add(new User(1, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(2, "John", LocalDate.now().minusYears(40)));
        users.add(new User(3, "Paul", LocalDate.now().minusYears(50)));
    }

    public List<User> findAll() {
        return users;
    }



    public User findOne(int id) {

        User retVal = null;

        for (int i = 0; i < users.size(); i++) {

            User tempUser = users.get(i);

            if (tempUser.getId() == id)
                retVal = tempUser;
        }

        return retVal;

    }

    public User deleteOne(int id) {

        User retVal = null;

        for (int i = 0; i < users.size(); i++) {

            User tempUser = users.get(i);

            if (tempUser.getId() == id) {
                users.remove(tempUser);
                retVal = tempUser;
                break;
            }
        }

        return retVal;

    }

    //public User save(User user)
    public User save(User user){
        int idSeq=0;

        for(int x=0;x<users.size();x++){
            if(users.get(x).getId()>idSeq)
                idSeq=users.get(x).getId();
        }
        idSeq=++idSeq;

        user.setId(idSeq);
        users.add(user);
        return user;
    }
}
