package com.revival.inventory.cart.service.impl;

import com.revival.inventory.cart.entities.BookItem;
import com.revival.inventory.cart.entities.external.Book;
import com.revival.inventory.cart.service.BookServiceClient;
import com.revival.inventory.cart.service.CartService;
import com.revival.inventory.cart.entities.Cart;
import com.revival.inventory.cart.entities.CartItem;
import com.revival.inventory.cart.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final BookServiceClient bookServiceClient;

    @Override
    public Cart addToCart(CartItem cartItem) {
        var userId = cartItem.getUserId();
        var bookId = cartItem.getBookId();
        BigInteger quantity = getBookQuantity(userId, bookId);
        if (quantity != null) {
            cartRepository.updateCartItem(userId, bookId, quantity.add(BigInteger.ONE));
        } else {
            cartItem.setQuantity(BigInteger.ONE);
            cartRepository.save(cartItem);
        }
        return getUserCart(userId);
    }

    private BigInteger getBookQuantity(BigInteger userId, BigInteger bookId) {
        CartItem cartItem = cartRepository.findByUserAndBook(userId, bookId);
        return cartItem != null ? cartItem.getQuantity() : null;
    }

    @Override
    public Cart getUserCart(BigInteger userId) {
        List<CartItem> cartItems = cartRepository.getCartItems(userId);
        return prepareUserCart(cartItems);
    }

    @Override
    public Cart removeFromCart(BigInteger userId, BigInteger bookId) {
        CartItem cartItem = cartRepository.findByUserAndBook(userId, bookId);
        BigInteger quantity = cartItem.getQuantity();
        if (quantity.equals(BigInteger.ONE)) {
            cartRepository.removeBookFromCart(userId, bookId);
        } else {
            cartRepository.updateCartItem(userId, bookId, quantity.subtract(BigInteger.ONE));
        }
        return getUserCart(userId);
    }

    private Cart prepareUserCart(List<CartItem> cartItems) {
        List<BookItem> books = cartItems.stream()
                .map(this::buildBookItem).collect(Collectors.toList());

        int cartTotal = books.stream()
                .map(bookItem -> bookItem.getQuantity().intValue() * bookItem.getPrice().intValue())
                .reduce(0, Integer::sum);

        return new Cart(BigInteger.valueOf(cartTotal), books);
    }

    private BookItem buildBookItem(CartItem cartItem) {
        Book book = bookServiceClient.getBook(cartItem.getBookId());
        return BookItem
                .builder()
                .id(book.getId())
                .title(book.getTitle())
                .price(book.getPrice())
                .imagePath(book.getImagePath())
                .quantity(cartItem.getQuantity())
                .build();
    }
}
