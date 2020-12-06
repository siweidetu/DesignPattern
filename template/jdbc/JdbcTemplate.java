package main.java.template.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
/**封装所有jdbc处理流程的抽象类*/
public abstract class JdbcTemplate {
	private DataSource dataSource;
	
	public JdbcTemplate(DataSource dataSource){
		this.dataSource = dataSource;
	}
	
	public final List<?> executeQuery(String sql,RowMapper<?> rowMapper,Object[] values){
		try {
			//获取连接
			Connection conn = this.getConnection();
			//创建语句集
			PreparedStatement pstm = this.createPreparedStatement(conn, sql);
			//执行语句集
			ResultSet rs = this.executeQuery(pstm, values);
			//处理结果集
			List<?> result = this.parseResultSet(rs, rowMapper);
			//关闭结果集
			rs.close();
			//关闭语句集
			pstm.close();
			//关闭连接
			conn.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 查询结果集转化
	 * @param rs
	 * @param rowMapper
	 * @return
	 * @throws Exception
	 */
	private List<?> parseResultSet(ResultSet rs,RowMapper<?> rowMapper) throws Exception{
		List<Object> result  = new ArrayList<Object>();
		int rowNum = 0;
		while(rs.next()){
			result.add(rowMapper.mapRow(rs, rowNum++));
		}
		return result;
	}
	
	/***
	 * 执行查询
	 * @param pstm
	 * @param values
	 * @return
	 * @throws SQLException
	 */
	private ResultSet executeQuery(PreparedStatement pstm,Object[] values) throws SQLException{
		for(int i=0;i<values.length;i++){
			pstm.setObject(i, values[i]);
		}
		return pstm.executeQuery();
	}
	
	/**
	 * 通过数据库连接获取预编译查询窗口
	 * @param conn
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	private PreparedStatement createPreparedStatement(Connection conn,String sql) throws SQLException{
		return conn.prepareStatement(sql);
	}
	
	/**
	 * 通过数据源获取数据库连接
	 * @return
	 * @throws SQLException
	 */
	private Connection getConnection() throws SQLException{
		return this.dataSource.getConnection();
	}
}
