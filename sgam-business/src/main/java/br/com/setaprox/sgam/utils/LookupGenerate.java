package br.com.setaprox.sgam.utils;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.naming.InitialContext;

public class LookupGenerate {

	@SuppressWarnings("unchecked")
	public static <T> T getRecource(@SuppressWarnings("rawtypes") Class T) {
		try {
			
			BeanManager beanManager = (BeanManager) new InitialContext().lookup("java:comp/BeanManager");
			Bean<T> classBean = (Bean<T>) beanManager.resolve(beanManager.getBeans(T));
			CreationalContext<?> creationalContext = beanManager.createCreationalContext(null);
			
			return classBean.create((CreationalContext<T>) creationalContext);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
			
		}
	}
	
}
