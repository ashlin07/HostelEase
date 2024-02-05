@RestController
public class DemoController {
    @GetMapping('/')
    public void helloWorld(){
        System.out.println("HEllo world!");
    }
}
