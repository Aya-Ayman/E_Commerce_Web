/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_access_layer.DAO;

import data_access_layer.database_manager.DatabaseManager;
import data_access_layer.interfaces.Promo_Dao_Interface;
import data_transfer_layer.Promo_DTO;
import data_transfer_layer.User_DTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asmaa
 */
public class Promo_DAO implements Promo_Dao_Interface, Serializable {
/*
    
    
    CREATE TABLE promoCode
 (
 cartNumber number NOT NULL,
 promoNumber VARCHAR2(25) NOT NULL,
 PRIMARY KEY (promoNumber)
 );   
    */
    private final String TAG = this.getClass().getName() + ": ";

    private PreparedStatement st;
    private ResultSet rs;
    private DatabaseManager managerObj;
    private final Connection con;
    private Statement s;
    private String selectState, deleteState, updateState, insertState;

    public Promo_DAO() {
        managerObj = new DatabaseManager();
        this.con = managerObj.getCon();
    }

    @Override
    public int create(Promo_DTO obj, Connection con) {
        // insert into promocode values(10,'asmaa11')
        try {
            st = con.prepareStatement("INSERT INTO promocode values(?,?)", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            st.setLong(1, obj.getCartNumber());
            st.setString(2, obj.getPromoNumber());
            rs = st.executeQuery();
            rs = st.getResultSet();
            System.out.println("create Promo ...............");
            return 0;
        } catch (SQLException ex) {
            System.out.println(TAG + ex.getMessage());
            return -1;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
                System.out.println(TAG + ex.getMessage());
            }

        }
    }

    @Override
    public Promo_DTO retreive(String promoNumber, Connection con) {
        // select * from promocode where promonumber ='asmaa123'

        Promo_DTO obj = null;
        try {
            s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = s.executeQuery(" SELECT * from promocode where promonumber  = '" + promoNumber + "'");
            if (rs.next()) {
                obj = new Promo_DTO();
                obj.setCartNumber(rs.getLong("cartnumber"));
                obj.setPromoNumber(rs.getString("promonumber"));
            }
        } catch (Exception x) {
            System.out.println(TAG + x.getMessage());

            x.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
                System.out.println(TAG + ex.getMessage());
            }

        }

        return obj;
    }

    @Override
    public int update(Promo_DTO obj, Connection con) {
//        update promocode set cartnumber = 20 where promonumber ='asmaa123'

        try {
            st = con.prepareStatement("UPDATE promocode set cartnumber = ?  where promonumber= ? ");

            st.setLong(1, obj.getCartNumber());
            st.setString(2, obj.getPromoNumber());
            rs = st.executeQuery();
            rs = st.getResultSet();

        } catch (Exception ex) {
            System.out.println(TAG + ex.getMessage());

            ex.printStackTrace();

            return -1;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
                System.out.println(TAG + ex.getMessage());
            }

        }

        return 0;

    }

    @Override
    public int delete(Promo_DTO obj, Connection con) {
        // delete from promocode where promonumber ='asmaa123'
        try {
            s = con.createStatement();
            s.executeUpdate(" DELETE FROM promocode where promonumber = '" + obj.getPromoNumber() + "'");
        } catch (SQLException ex) {
            System.out.println(TAG + ex.getMessage());

            ex.printStackTrace();
        }
        try {
            if (obj.getPromoNumber() != null) {
            } else {
                System.out.println(" No promo to delete");
            }
            return 0;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
                System.out.println(TAG + ex.getMessage());
            }
        }
    }

}
