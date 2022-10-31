package com.example.demo.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    private static int usersCount = 3;

    static {
        users.add(new User(1, "add", new Date()));
        users.add(new User(2, "ken", new Date()));
        users.add(new User(3, "minnal", new Date()));
    }

    public List<User> findAll() {   //전체사용자 조희
        return users;
    }

    public User save(User user) {       //사용자 추가
        if (user.getId() == null) {
            user.setId(++usersCount);
        }

        users.add(user);
        return user;
    }

    public User findOne(int id) {       //개별사용자 조회
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User deleteById(int id){ //list형태의 데이터를 순차적 접근 , 열거형타입의 데이터
        Iterator <User> iterator = users.iterator();    //회색인 이유는 어떠한 클래스에서도 한번도 사용하지 않아서.

        while (iterator.hasNext()) {
            User user = iterator.next();

            if(user.getId() == id){
                iterator.remove();
                return user;
            }
        }

        return null;
    }
}
