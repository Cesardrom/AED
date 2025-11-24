package com.docencia.personas.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.docencia.personas.model.Rol;
import com.docencia.personas.services.implementation.RoleService;

@SpringBootTest
public class RolServiceTest {
    private static final String ROLE_NOMBRE = "Role nombre";
    private static final String ROL_1 = "ROL-1"; 
    RoleService roleService;
    Rol rol;

    @Autowired
    public RolServiceTest(RoleService roleService) {
        this.roleService = roleService;
    }

    @BeforeEach
    void beforeEach(){
        if(rol == null){
            rol = new Rol(ROL_1, ROLE_NOMBRE);
        }
        roleService.save(rol);
    }
    
    @Test
    void findByTest(){
        Rol rolFind =  new Rol(ROL_1, null);
        rolFind = roleService.findBy(rolFind);
        Assertions.assertNotNull(rolFind);
        Assertions.assertEquals(ROL_1, rolFind.getId());
        Assertions.assertEquals(ROLE_NOMBRE, rolFind.getNombre());
    }

}
