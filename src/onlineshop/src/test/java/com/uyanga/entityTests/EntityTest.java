package com.uyanga.entityTests;

import com.uyanga.entity.Entity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EntityTest {

    @Test
    public void ctrThrowsExceptionWhenIdNull()
    {
        Assertions.assertThrows(NullPointerException.class, () -> new Entity(null));

    }

    @Test
    public void ctrThrowsExceptionWhenIdEmpty()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Entity(""));

    }

    @Test
    public void ctrCreatesInstance()
    {
        Entity entity = new Entity("E1");

        Assertions.assertNotNull(entity);
        Assertions.assertEquals("E1", entity.getId());

    }

}
