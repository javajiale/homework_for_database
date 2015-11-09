package cn.edu.zucc.booklib.control;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zucc.booklib.model.BeanSystemUser;
import cn.edu.zucc.booklib.util.BaseException;
import cn.edu.zucc.booklib.util.BusinessException;
import cn.edu.zucc.booklib.util.DBUtil;
import cn.edu.zucc.booklib.util.DbException;

public class SystemUserManager {
	public String  logIn(BeanSystemUser su) throws DbException{
		String result = null;
		Connection conn = null;
		try{
			conn = DBUtil.getConnection();
			java.sql.CallableStatement psc = conn.prepareCall("{call prc_login(?,?,?)}");
			psc.setString(1, su.getXh());
			psc.setString(2, su.getPassword());
			psc.registerOutParameter(3, Types.VARCHAR);
			psc.execute();
			result = psc.getString(3);
			psc.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		return result;
	}
	
	public boolean add(BeanSystemUser su) throws DbException{
		Connection conn = null;
		try{
			conn = DBUtil.getConnection();
			java.sql.PreparedStatement pst = conn.prepareStatement("{call prc_add(?,?,?,?)}");
			pst.setString(1, su.getXh());
			pst.setString(2, su.getNames());
			pst.setString(3, su.getPassword());
			pst.setString(4, su.getDescrip());
			return pst.execute();
		} catch (SQLException e){
			e.printStackTrace();
			throw new DbException(e);
		}
	}
	
	public boolean delete(BeanSystemUser su) throws DbException{
		Connection conn = null;
		try{
			conn = DBUtil.getConnection();
			java.sql.PreparedStatement pst = conn.prepareStatement("{call prc_delete(?)}");
			pst.setString(1, su.getXh());
			return pst.execute();
		} catch (SQLException e){
			e.printStackTrace();
			throw new DbException(e);
		}
	}
	
	public boolean modify(BeanSystemUser su) throws DbException{
		Connection conn = null;
		try{
			conn = DBUtil.getConnection();
			java.sql.PreparedStatement pst = conn.prepareStatement("{call prc_modify(?,?,?,?)}");
			pst.setString(1, su.getXh());
			pst.setString(2, su.getNames());
			pst.setString(3, su.getPassword());
			pst.setString(4, su.getDescrip());
			return pst.execute();
		} catch (SQLException e){
			e.printStackTrace();
			throw new DbException(e);
		}
	}
	
}
