package ch.bbw.shop.cart;

import ch.bbw.shop.article.Article;

public class CartEntry {
	private Article article;
	private int count;
	
	public CartEntry(Article a) {
		this.article = a;
		this.count = 1;
	}
	
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void plusOneArticle() {
		this.count++;
	}
	public void minusOneArticle() {
		this.count--;
	}
	public double getPreis() {
		return article.getPrice()*count;
	}
	
}
