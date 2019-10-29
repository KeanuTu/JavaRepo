package jdbc;
 
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
 
class ConnectionpoolWorkingThread extends Thread {
    private ConnectionPool cp;
 
    public ConnectionpoolWorkingThread(ConnectionPool cp) {
        this.cp = cp;
    }
 
    public void run() {
        Connection c = cp.getConnection();
        try (Statement st = c.createStatement()) {
            for (int i = 0; i < TestConnectionPool.insertTime; i++) {
                String sql = "select * from hero";
                st.execute(sql);
            }
 
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        cp.returnConnection(c);
    }
}