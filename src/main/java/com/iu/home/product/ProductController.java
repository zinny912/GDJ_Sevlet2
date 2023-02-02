package com.iu.home.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
   private static final long serialVersionUID = 1L;
    private ProductDAO productDAO;   
    private ProductService productService;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        productDAO = new ProductDAO();
        
       //Controller는 Serviece에 대해 의존적이라 멤버변수 선언
        productService = new ProductService();
        
        
        
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("Product page");
      
      System.out.println(request.getRequestURL());
     
      String uri = request.getRequestURI();
            
      uri= uri.substring(uri.lastIndexOf("/")+1);
      
      
      
      String path ="";
      if (uri.equals("list.do")) {
       	  //product.jsp
    	
    	 try {
    		 
			List<ProductDTO> ar = productService.getProductList();
			request.setAttribute("list", ar);
			
    	 } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 path = "productList.jsp";
    	  
      } else if (uri.equals("add.do")) {
    	  
    	  path = "productAdd.jsp";
    	  
      } else if (uri.equals("update.do")) {
    	  
    	  path = "productUpdate.jsp";
    	  
      } else if (uri.equals("delete.do")) {
    	  
    	  path = "productDelete.jsp";
    	  
      } else if (uri.equals("detail.do")) {
    	
    	 ProductDTO productDTO = new ProductDTO();
    	 Long num = Long.parseLong(request.getParameter("productNum"));
    	 productDTO.setProductNum(num);
    	 try {
    		  productDTO = productService.getProductDetail(productDTO);
    		  request.setAttribute("detail", productDTO);
    		  
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	  path = "productDetail.jsp";
    	
    	  
    	  
    	  
      } else {
    	
    	 path = "home.jsp";
      }
      
      RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/product/"+path);
      view.forward(request, response);   
     
      
      
//      String name = request.getParameter("name");
//      String detail = request.getParameter("detail");
//     
//      
//      System.out.println("Name : "+name);
//      System.out.println("Price : "+detail);
//      ProductDTO productDTO = new ProductDTO();
//      productDTO.setProductName(name);
//      productDTO.setProductDetail(detail);
//            
//      int result = productService.setAddProduct(productDTO, new ArrayList<ProductDTO>);
//      System.out.println();
//      
      
//      RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/product/productList.jsp");
//      view.forward(request, response);
      
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}