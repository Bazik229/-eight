package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    Product book = new Book(1,"Война и мир",200,"Толстой", 600, 1995);
    Product book1 = new Book(2,"Мастер и Маргарита",300,"Булгаков", 200, 1982);
    Product book2 = new Book(3,"Ведьмак",1300,"Сапковский", 2000, 1882);


    @Test
    void shouldRemoveById() {
        ProductRepository productRepository = new ProductRepository();

        productRepository.save(book);
        productRepository.save(book1);
        productRepository.save(book2);

        productRepository.removeById(1);
        Product[] expected = {book1, book2};
        Product[] actual = productRepository.findAll();
        assertArrayEquals(expected,actual);

    }

    @Test
    void shouldRemoveByIdElementNull() {
        ProductRepository productRepository = new ProductRepository();

        productRepository.save(book);
        productRepository.save(book1);

        assertThrows(NotFoundException.class, () ->{
            productRepository.removeById(3);
        });
    }
}