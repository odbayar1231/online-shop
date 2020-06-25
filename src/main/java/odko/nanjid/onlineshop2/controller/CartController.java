package odko.nanjid.onlineshop2.controller;

import odko.nanjid.onlineshop2.domain.dto.ResponseDTO;
import odko.nanjid.onlineshop2.service.CartService;
import odko.nanjid.onlineshop2.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/cart")
@SessionAttributes({"userName"})
public class CartController {

    @Autowired
    CartService cartService;
    @Autowired
    ItemService itemService;

    @GetMapping
    public String getCartItems(Model model){
        model = cartService.getCartItems(model);
        return "cart/cart";
    }

    @PostMapping(value = "/",consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}, produces = "application/json")
    public  @ResponseBody ResponseDTO saveCardItem(@RequestParam Map<String,String> params){
        Long productId = Long.valueOf(params.get("productId"));
        int quantity = Integer.valueOf(params.get("quantity"));
        return cartService.addItem(productId,quantity);
    }

    @PostMapping(value = "/remove")
    public String removeItem(@RequestParam Long itemId) {
        itemService.deleteItemById(itemId);
        return "redirect:/cart";
    }



}
