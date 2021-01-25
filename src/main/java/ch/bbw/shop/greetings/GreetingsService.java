package ch.bbw.shop.greetings;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greetings")
public class GreetingsService {

	@GetMapping
	public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
		return new Greeting(2, name);
	}

}

