package ch.bbw.shop.cart;

import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;

import ch.bbw.shop.article.Article;
import ch.bbw.shop.cart.Token;
import org.springframework.stereotype.Service;

import ch.bbw.shop.cart.Cart;

@Service
public class CartDAO {

	private final HashMap<Token, Cart> carts;
	
	public CartDAO() {
		carts = new HashMap<>();
	}
	
	public Token createCart() {
		Cart cart = new Cart();
		Token token = new Token();
		carts.put(token, cart);
		return token;
	}

	public Optional<Cart> getCartByTokenId(String tokenId) {
		Optional<Token> t = carts.keySet().stream()
				.filter(k -> k.getId().equals(tokenId))
				.findFirst();
		if (t.isPresent()) {
			return Optional.of(carts.get(t.get()));
		} else {
			System.out.println("getCartByTokenId: not found");
			return Optional.empty();
		}
	}
	
	public Collection<Token> getAllCartTokens() {
		return carts.keySet();
	}

}
