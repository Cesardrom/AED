package org.docencia.hotel.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.transaction.Transactional;

public class GuestModelTest {
    private Hotel hotel;
    private Guest guest1 = new Guest("G1");

    @BeforeEach
    @Transactional
    void beforeEach() {
        guest1 = new Guest();
    }

    @Test
    void getPhoneNumberTest() {
        String phoneNumber = guest1.getPhone();
        Assertions.assertEquals(phoneNumber, guest1.getPhone());
    }

    @Test
    void getEmailTest() {
        String email = guest1.getEmail();
        Assertions.assertEquals(email, guest1.getEmail());
    }

    @Test
    void getFullNameTest() {
        String fullName = guest1.getFullName();
        Assertions.assertEquals(fullName, guest1.getFullName());
    }

    @Test
    void getIdTest() {
        String id = guest1.getId();
        Assertions.assertEquals(id, guest1.getId());
    }

    @Test
    void constructorIdTest() {
        Guest guest2 = new Guest("G1");
        Assertions.assertEquals("G1", guest2.getId());
    }

    @Test
    void guestContructorTest() {
        Guest guest2 = new Guest();
        guest2.setId("G1");
        guest2.setFullName("John Doe");
        guest2.setEmail("juan@gmail.com");
        guest2.setPhone("123456789");
        Assertions.assertEquals("G1", guest2.getId());
    }

    @Test
    void guestEqualsTest() {
        guest1.setId("G1");
        guest1.setFullName("John Doe");
        guest1.setEmail("juan@gmail.com");
        guest1.setPhone("123456789");
        Guest guest2 = new Guest("G1");
        Assertions.assertTrue(guest1.equals(guest2));
    }

    @Test 
    void guestHashCodeTest() {
        Guest guest1 = new Guest("G1");
        Guest guest2 = new Guest("G1");

        Assertions.assertEquals(guest1.hashCode(), guest2.hashCode());
    }
    @Test
    void guestEqualsIsNotObjectTest() {
        Assertions.assertFalse(guest1.equals("guest"));
    }
    @Test
void guestConstructorTest() {
    Guest guest = new Guest("G1", "Juan Pérez", "juan@email.com", "123456789");
    
    Assertions.assertEquals("G1", guest.getId());
    Assertions.assertEquals("Juan Pérez", guest.getFullName());
    Assertions.assertEquals("juan@email.com", guest.getEmail());
    Assertions.assertEquals("123456789", guest.getPhone());
}

@Test
void guestEqualsSameObjectTest() {
    Guest guest = new Guest("G1", "Juan Pérez", "juan@email.com", "123456789");
    Assertions.assertTrue(guest.equals(guest));
}



}