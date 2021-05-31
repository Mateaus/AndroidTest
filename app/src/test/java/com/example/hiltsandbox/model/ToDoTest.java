package com.example.hiltsandbox.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ToDoTest {

    private ToDo toDo;

    @Before
    public void setup() {
        toDo = new ToDo(1, 2, "hi", false);
    }

    @Test
    public void testConstructor() {
        assertEquals(1, toDo.getUserId());
        assertEquals(2, toDo.getId());
        assertEquals("hi", toDo.getTitle());
        assertFalse(toDo.isCompleted());
    }

    @Test
    public void testUserId() {
        toDo.setUserId(5);
        assertEquals(5, toDo.getUserId());
    }

    @Test
    public void testId() {
        toDo.setId(7);
        assertEquals(7, toDo.getId());
    }

    @Test
    public void testTitle() {
        toDo.setTitle("HelloWorld");
        assertEquals("HelloWorld", toDo.getTitle());
    }

    @Test
    public void testCompletedWhenTrue() {
        toDo.setCompleted(true);

        assertTrue(toDo.isCompleted());
    }

    @Test
    public void testCompletedWhenFalse() {
        toDo.setCompleted(false);

        assertFalse(toDo.isCompleted());
    }
}
