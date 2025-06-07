package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


 public class CarListTest {
    private CarList carList;

    @Before
    public void setUp() throws Exception {
        carList=new CarArrayList();
        for (int i=0; i<100;i++){
            carList.add(new Car("Brand"+i,i));
        }
    }
    @Test
    public void whenAdded100ElementsWhenSizeMustBe100(){

        assertEquals(100,carList.size());
    }
    @Test
    public void WhenElementRemoveByIndexThenSizeMustBeDecreased(){
        assertTrue(carList.removeAt(5));
        assertEquals(99,carList.size());
    }

    @Test
    public void WhenElementRemovedThenSizeMustBeDecreased(){
        Car car=new Car("BMW",15);
        carList.add(car);
        assertEquals(101,carList.size());
        assertTrue(carList.remove(car));
        assertEquals(100,carList.size());
    }
    @Test
    public void WhenNonExistentElementRemovedThenReturnFalse(){
        Car car=new Car("BMW",15);
        assertFalse(carList.remove(car));
        assertEquals(100,carList.size());
    }

    @Test
    public void whenListCleardThenSizeMustBe0(){
        carList.clear();
        assertEquals(0,carList.size());
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void whenIndexOutOfBoundsThenThrowException(){
        carList.get(100);
    }
    @Test
    public void methodGetReturnedByValue(){
        Car car=carList.get(0);
        assertEquals("Brand0",car.getBrand());
    }
}
