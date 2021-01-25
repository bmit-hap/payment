package ch.bbw.shop.cart;

import ch.bbw.shop.article.Article;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cart {
	private HashMap<String, CartEntry> cartEntries; // Article number, CartEntry
	
	public Cart() {
		cartEntries = new HashMap<>();
	}
	
	public List<CartEntry> getCartEntries() {
		return new ArrayList<>(cartEntries.values());
	}

	public void clear() {
		cartEntries.clear();		
	}
	
	public int getCount() {
		int count=0;
		for (CartEntry ce : cartEntries.values()) {
			count += ce.getCount();
		}
		return count;
	}
	
	public double getTotalPrice() {
		double total=0;
		for (CartEntry ce : cartEntries.values()) {
			total += ce.getPreis();
		}	
		return total;
	}

	public void addArticle(Article article) {
		if (cartEntries.containsKey(article.getNumber())) {
			CartEntry cartEntry = cartEntries.get(article.getNumber());
			cartEntry.plusOneArticle();
		} else {
			CartEntry cartEntry = new CartEntry(article);
			cartEntries.put(article.getNumber(), cartEntry);
		}
	}
	
	public void delArticle(Article article) {
		if (cartEntries.containsKey(article.getNumber())) {
			CartEntry cartEntry = cartEntries.get(article.getNumber());
			cartEntry.minusOneArticle();
			
			if (cartEntry.getCount()==0) {
				cartEntries.remove(article.getNumber());
			}
		}
	}	
	
}
