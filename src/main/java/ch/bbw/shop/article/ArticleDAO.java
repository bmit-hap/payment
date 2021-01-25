package ch.bbw.shop.article;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ch.bbw.shop.article.Article;

@Service
public class ArticleDAO {
	
	private List<Article> articles;
	
	public ArticleDAO() {
		articles = new ArrayList<>();
		articles.add(new Article(1, "0001", "Java T-Shirt", "Ein wunderschönes T-Shirt (unisex)", 39.90));
		articles.add(new Article(2, "0002", "Java Tasse", "3dl Tasse für langen heissen Kaffeegenuss", 12.90));
		articles.add(new Article(3, "0003", "Java Bohnen", "500g original Java Bohnen (direktimport)", 15.00));
		articles.add(new Article(4, "0004", "BBW Sticker rund", "Klassische BBW Sticker (Variante rund 5cm Durchmesser)", 15.00));
		articles.add(new Article(5, "0005", "BBW Sticker quadratisch", "Klassische BBW Sticker (Variante eckig 4 x 3cm)", 15.00));
		
		articles.get(0).setImage("images/0001.jpg");
		articles.get(1).setImage("images/0002.jpg");
		articles.get(2).setImage("images/0003.jpg");
		articles.get(3).setImage("images/0004.jpg");
		articles.get(4).setImage("images/0005.jpg");
	}

	public Optional<Article> getArticleById(int id) {
		return articles.stream()
			.filter(a -> a.getId()==id)
			.findFirst();
	}
	
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticlees(List<Article> articles) {
		this.articles = articles;
	}
	
}
