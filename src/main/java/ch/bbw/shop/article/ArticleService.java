package ch.bbw.shop.article;

import java.util.List;
import java.util.Optional;

import ch.bbw.shop.greetings.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
public class ArticleService {

	@Autowired
	private ArticleDAO articleDAO;

	@GetMapping(value = "/greeting")
	public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
		return new Greeting(2, name);
	}

	@GetMapping
	public List<Article> getArticles() {
		return articleDAO.getArticles();
	}

	@GetMapping("/{id}")
	public Article getArticle(@PathVariable("id")int id) {
		Optional<Article> article = articleDAO.getArticleById(id);
		return article.isPresent() ? article.get() : null;
	}
}

