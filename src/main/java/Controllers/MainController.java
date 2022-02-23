package Controllers;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@ComponentScan
@RequestMapping()
public class MainController {
@GetMapping
    public String main(){
    return main();
}
}
