package com.iu.home.product;

import java.util.List;

public class ProductService {
	
	// Service는 DAO에 의존적이라 멤버변수 선언
	private ProductDAO productDAO = new ProductDAO ( );
	
	{
		this.productDAO=new ProductDAO();
		
	}
	
	public void ProductService( ) {
		this.productDAO = new ProductDAO();
		
	}

	// 결합도가 낮다(약하다)
	public void setProductDAO(ProductDAO productDAO) {
				this.productDAO=productDAO;
	}
	
	public ProductDTO getProductDetail(ProductDTO productDTO) throws Exception{
		return productDAO.getProductDetail(productDTO);
	}
	
	
	public List<ProductDTO> getProductList() throws Exception {
		return productDAO.getProductList();
	
	}

	//결합도가 높다(강하다)
	
	public int setAddProduct(ProductDTO productDTO, List<OptionDTO> ar) throws Exception{
			//product, option
			Long productNum = productDAO.getProductNum( );
			productDTO.setProductNum(productNum);
			int result = productDAO.setAddProduct(productDTO);

			for(OptionDTO optionDTO : ar ) {
			optionDTO.setOptionNum(productNum);
			result = productDAO.setAddOption(optionDTO);
			}

			return result;
	}

	

}
