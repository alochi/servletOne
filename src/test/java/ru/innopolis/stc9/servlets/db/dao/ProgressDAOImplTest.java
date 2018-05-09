package ru.innopolis.stc9.servlets.db.dao;

import org.junit.*;
import java.sql.SQLException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ProgressDAOImplTest {
    private ProgressDAOImpl progressDAO;

    @Before
    public void before(){
        this.progressDAO = new ProgressDAOImpl();
    }

    @Test(expected = SQLException.class)
    public void getMarkWithException() throws SQLException {
        this.progressDAO.getMark(5);
    }

/*    @Test
    public void getMarkTest() {
        ResultSet res = null;
        PreparedStatement statement = mock(PreparedStatement.class);
        ResultSet resultSet = mock(ResultSet.class);
        try {
            resultSet = (ResultSet) when(statement.executeQuery()).thenReturn(res);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        assertEquals(res,resultSet);
    }*/
}
