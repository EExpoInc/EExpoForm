package eexpoform.servlet;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jodd.bean.BeanUtil;
import eexpoforms.test.BlogPostEntity;
import eexpoforms.test.BlogPostForm;

@SuppressWarnings("serial")
@WebServlet("/EntityPopulateServlet")
public class EntityPopulateServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
			IOException {
		BlogPostEntity bpe = new BlogPostForm();
//		System.out.println(req.getParameter("authorId"));
		Map<String,Object> param = prepareToJodd(req.getParameterMap());
		BeanUtil.populateBean(bpe, param);
		
		req.setAttribute("entity", bpe);
		 RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
         rd.forward(req, resp);      
		
		
		
	}

	private Map<String, Object> prepareToJodd(Map<String, String[]> parameterMap) {
		Map<String, Object> result = new LinkedHashMap<>();
		for(String k:parameterMap.keySet()){
			String[] vs = parameterMap.get(k);
			if(vs.length == 1){
				result.put(k, vs[0]);
			}else{
				result.put(k, vs);
			}
			if(result.get(k).equals("")){
				result.put(k, null);
			}
		}
		return result;
	}
}
