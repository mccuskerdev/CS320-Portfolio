package com.mycompany.contacts;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    private ContactService service;
    private Contact contact;

    @BeforeEach
    void setup() {
        service = new ContactService();
        contact = new Contact("1", "John", "Doe", "1234567890", "123 Street");
        service.addContact(contact);
    }

    @Test
    void testAddContact() {
        Contact newContact = new Contact("2", "Jane", "Doe", "0987654321", "456 Street");
        service.addContact(newContact);
        assertEquals("Jane", newContact.getFirstName());
    }

    @Test
    void testDeleteContact() {
        service.deleteContact("1");
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("1");
        });
    }

    @Test
    void testUpdateFirstName() {
        service.updateFirstName("1", "Mike");
        assertEquals("Mike", contact.getFirstName());
    }

    @Test
    void testUpdateLastName() {
        service.updateLastName("1", "Smith");
        assertEquals("Smith", contact.getLastName());
    }

    @Test
    void testUpdatePhone() {
        service.updatePhone("1", "1112223333");
        assertEquals("1112223333", contact.getPhone());
    }

    @Test
    void testUpdateAddress() {
        service.updateAddress("1", "New Address");
        assertEquals("New Address", contact.getAddress());
    }
}