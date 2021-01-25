package ch.bbw.shop.cart;

import java.util.Optional;

import ch.bbw.shop.article.ArticleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ch.bbw.shop.article.Article;

@RestController
@RequestMapping("/carts")
public class CartService {
	
	@Autowired
	private CartDAO cartDAO;
	
	@Autowired 
	private ArticleDAO articleDAO;
	
	@GetMapping
	public ResponseEntity<String> getCarts() {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public Token createCart() {
		Token token = cartDAO.createCart();
		System.out.println("create cart : " + token.getId());
		return token;
	}

	@GetMapping("/{token}")
	public Cart getCart(@PathVariable("token")String tokenId) {
		System.out.println("getCart: " + tokenId);
		Optional<Cart> cart = cartDAO.getCartByTokenId(tokenId);
		if (cart.isPresent()) {
			return cart.get();
		} else {
			// TODO: return status 404
			return null;
		}
	}

	@PostMapping("/{id}/{token}")
	public ResponseEntity<Cart> addArticleToCart(@PathVariable("token")String tokenId, @PathVariable("id")int articleId) {
		Optional<Cart> optCart = cartDAO.getCartByTokenId(tokenId);
		if (optCart.isPresent()) {
			Optional<Article> optArticle = articleDAO.getArticleById(articleId);
			if (optArticle.isPresent()) {
				Cart cart = optCart.get();
				cart.addArticle(optArticle.get());
				return ResponseEntity.ok(cart);
			}
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}/{token}")
	public ResponseEntity<Cart> delArticleFromCart(@PathVariable("token")String tokenId, @PathVariable("id")int articleId) {
		Optional<Cart> optCart = cartDAO.getCartByTokenId(tokenId);
		if (optCart.isPresent()) {
			Optional<Article> optArticle = articleDAO.getArticleById(articleId);
			if (optArticle.isPresent()) {
				Cart cart = optCart.get();
				cart.delArticle(optArticle.get());
				return ResponseEntity.ok(cart);
			}
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
