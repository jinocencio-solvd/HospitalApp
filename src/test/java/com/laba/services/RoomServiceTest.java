package com.laba.services;

import static org.testng.Assert.assertEquals;

import com.laba.enums.DaoType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class RoomServiceTest {

    private final RoomService roomService;

    @Factory(dataProvider = "dataProvider")
    public RoomServiceTest(DaoType daoType) {
        roomService = new RoomService(daoType);
    }

    @DataProvider(name = "dataProvider")
    public static Object[][] testData() {
        return new Object[][]{
            {DaoType.JDBC},
//            {DaoType.MYBATIS}
        };
    }

    @Test
    public void testGetRoomsByDepartmentId() {
        int numRoomsByDept = roomService.getRoomsByDepartmentId(1).size();
        assertEquals(numRoomsByDept, 3);
    }

}