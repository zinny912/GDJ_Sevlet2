package com.iu.home.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iu.home.util.DBConnection;

public class ProductDAO {
	
		
	public Long getProductNum() throws Exception {
		
		Connection connection = DBConnection.getConnection();
		
		String sql = "SELECT PRODUCT_SEQ.NEXTVAL FROM DUAL";

		PreparedStatement st = connection.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		rs.next();
		
		Long num = rs.getLong(1);
		
		DBConnection.disConnection(rs, st, connection);
		
		return num;
		
	}
		
	
//-----------------------------------------------------------	
	public List<OptionDTO> getOptionList() throws Exception {
		
		ArrayList<OptionDTO> ar = new ArrayList<OptionDTO>();
		
		Connection connection = DBConnection.getConnection();
		
		String sql = "SELECT OPTIONNUM, PRODUCTNUM, OPTIONNAME, OPTIONPRICE, OPTIONSTOCK"
				+ " FROM PRODUCTOPTION";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			
			OptionDTO optionDTO = new OptionDTO();
			optionDTO.setOptionNum(rs.getLong("OPTIONNUM"));
			optionDTO.setProductNum(rs.getLong("PRODUCTNUM"));
			optionDTO.setOptionName(rs.getString("OPTIONNAME"));
			optionDTO.setOptionPrice(rs.getLong("OPTIONPRICE"));
			optionDTO.setOptionStock(rs.getLong("OPTIONSTOCK"));
			ar.add(optionDTO);
			
		}
		
		DBConnection.disConnection(rs, st, connection);
				
		return ar;
		
	}
	
	
	public int setAddOption(OptionDTO optionDTO) throws Exception {
		
		Connection connection = DBConnection.getConnection();
		
		String sql = "INSERT INTO PRODUCTOPTION (OPTIONNUM, PRODUCTNUM, OPTIONNAME, OPTIONPRICE, OPTIONSTOCK)"
				+ " VALUES(PRODUCTOPTION_SEQ.NEXTVAL, ?, ?, ?, ?)";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setLong(1, optionDTO.getProductNum());
		st.setString(2, optionDTO.getOptionName());
		st.setLong(3, optionDTO.getOptionPrice());
		st.setLong(4, optionDTO.getOptionStock());
		
		int result = st.executeUpdate();
		
		DBConnection.disConnection(st, connection);
		
		return result;
	}
	
//------------------------------------------------------------------	
	public ProductDTO getProductDetail(ProductDTO productDTO) throws Exception{
		
				
		Connection connection = DBConnection.getConnection();
		
		String sql = "SELECT * FROM PRODUCT"
				+ " WHERE PRODUCTNUM = ?";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setLong(1, productDTO.getProductNum());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			productDTO.setProductNum(rs.getLong("PRODUCTNUM"));
			productDTO.setProductName(rs.getString("PRODUCTNAME"));
			productDTO.setProductJumsu(rs.getDouble("PRODUCTJUMSU"));
			productDTO.setProductDetail(rs.getString("PRODUCTDETAIL"));
		} else {
			
			productDTO=null;
			
		}
		
		return productDTO;
		
	}
	
	
	
	
	public List<ProductDTO> getProductList ()throws Exception{
		ArrayList<ProductDTO> ar = new ArrayList<ProductDTO>();
		
		Connection connection = DBConnection.getConnection();
		
		String sql = "SELECT PRODUCTNUM, PRODUCTNAME, PRODUCTJUMSU"
				+ " FROM PRODUCT ORDER BY PRODUCTJUMSU DESC";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProductNum(rs.getLong("PRODUCTNUM"));
			productDTO.setProductName(rs.getString("PRODUCTNAME"));
			productDTO.setProductJumsu(rs.getDouble("PRODUCTJUMSU"));
			ar.add(productDTO);
		}
		
		DBConnection.disConnection(rs, st, connection);
		
		return ar;
	}
	
	
	//setAddProduct
	public int setAddProduct(ProductDTO productDTO)throws Exception{
		
		Connection connection = DBConnection.getConnection();
		
		String sql = "INSERT INTO PRODUCT (PRODUCTNUM, PRODUCTNAME, PRODUCTDETAIL, PRODUCTJUMSU)"
				+ " VALUES (?, ?, ?, 0.0)";
				
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setLong(1, productDTO.getProductNum());
		st.setString(2, productDTO.getProductName());
		st.setString(3, productDTO.getProductDetail());
		//st.setDouble(3, productDTO.getProductJumsu());
		
		int result = st.executeUpdate();
		
		DBConnection.disConnection(st, connection);
		
		return result;
		
	}
	
}	