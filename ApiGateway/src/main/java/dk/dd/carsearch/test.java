package dk.dd.carsearch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class test {
    public static void main(String[] args) {

        User u1 = new User("1", "Jonas");
        User u2 = new User("1", "Andreas");
        Collection<User> collect = new ArrayList<>();
        collect.add(u1);
        collect.add(u2);
        System.out.println(collect);


        List<User> collectFilter = collect
                .stream()
                .filter(User -> User.getName().equals("Jonas"))
                .collect(Collectors.toList());
        System.out.println(collectFilter);
    }
}
