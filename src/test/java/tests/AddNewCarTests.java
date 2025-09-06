package tests;

import models.User;
import org.testng.annotations.BeforeClass;
import models.Car;
import org.testng.annotations.Test;


public class AddNewCarTests extends TestBase{
    @BeforeClass
    public void preCondition(){
        if(!app.getHelperUser().isLogged()){
            app.getHelperUser().login(new User().setEmail("margo@gmail.com").setPassword("Mmar123456$"));
        }
    }
    @Test
    public void addNewCarSuccess(){
        int i = (int) ((System.currentTimeMillis()/1000)%3600);

        Car car = Car.builder()
                .location("Tel Aviv, Israel")
                .manufacture("Mazda")
                .model("M3")
                .year("2024")
                .fuel("Petrol")
                .seats(4)
                .carClass("A")
                .carRegNumber("698-900-"+i)
                .price(50)
                .about("Nice Car")
                .build();
        logger.info("Test start with test data --->" + car.toString());


        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().attachPhoto("D:\\Qa30\\Qa30_IlCarro\\Bugatti_Veyron_16.4_–_Frontansicht_(1),_5._April_2012,_Düsseldorf.jpg");
        app.getHelperCar().submitCarForm();
    }


}
