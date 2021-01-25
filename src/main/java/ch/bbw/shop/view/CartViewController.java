package ch.bbw.shop.view;

import java.util.ArrayList;
import java.util.List;

import ch.bbw.shop.cart.Token;
import ch.bbw.shop.cart.CartDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CartViewController {

	@Autowired
	private CartDAO cartDAO;
	
	public List<Token> getCarts() {
		return new ArrayList<Token>(cartDAO.getAllCartTokens());
	}
}
