package dk.dd.carsearch;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class CarSearchController
{
   private CarSearchClient client;

    public CarSearchController(dk.dd.carsearch.CarSearchClient client) {
        this.client = client;
    }

    @GetMapping("/cars/{brand}")
    @ResponseBody
    @CrossOrigin(origins = "*") // allow request from any client
    public Collection<Car> myCars(@PathVariable String brand)
    {
        return client.readCars()
                .getContent()
                .stream()
                .filter(Car -> Car.getBrand().equals(brand))
                .collect(Collectors.toList());
    }

    @GetMapping("/cars")
    @ResponseBody
    @CrossOrigin(origins = "*") // allow request from any client
    public Collection<Car> myCars()
    {
        return client.readCars()
                .getContent()
                .stream()
                .collect(Collectors.toList());
    }

    private Collection<Car> fallback()
    {
        return new ArrayList<>();
    }
}