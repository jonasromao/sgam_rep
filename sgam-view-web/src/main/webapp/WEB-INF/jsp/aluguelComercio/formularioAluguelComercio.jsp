<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="/headerMenu.jsp" %> 
<%@ include file="/moradorModal.jsp" %>

<link href="${pageContext.request.contextPath}/manual_install_components/eonasdan-bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet">


<div class="row wrapper border-bottom white-bg page-heading">
     <div class="col-lg-12">
         <h2>Faturamento</h2>
         <ol class="breadcrumb">
             <li>
                 <a href="${linkTo[LoginController].paginaInicial}">Inicio</a>
             </li>
             <li>
                 <span>Faturamento</span>
             </li>
             <li class="active">
                 <a href="${linkTo[AluguelComercioController].listagemAluguelComercio}"><strong>Comércio</strong></a>
             </li>

			<div class="pull-right">
            	<a class="label label-default" href="${linkTo[AluguelComercioController].listagemAluguelComercio}"> <i class="fa fa-angle-left"></i><i class="fa fa-angle-left"></i> Voltar</a>
            </div>

         </ol>
     </div>
 </div>
 
 <div class="wrapper wrapper-content animated fadeInRight">
 	<div class="row">
 		<form method="post" class="form-horizontal" action="${linkTo[AluguelComercioController].cadastraAluguelComercio}">
			<div class="col-lg-6">
			<fieldset>
			    <legend>Geral</legend>
		        <div class="ibox-content">
		        
	         		<input type="hidden" name="aluguelComercio.id" value="${aluguelComercio.id }"/>
	         		     		
	         	
	             	<div class="form-group">
		            	<label class="col-sm-4 control-label">Morador</label>
		                <div class="col-sm-8">
		                	<div class="input-group">
		                		<input id="idMoradorFaturamento" type="hidden" name="aluguelComercio.aluguel.morador.id" value="${aluguelComercio.aluguel.morador.id }"/> 
		                		<input id="nomeMoradorFaturamento" type="text" class="form-control" value="${aluguelComercio.aluguel.morador.nome}">
		                		<a class="input-group-addon" id="btnAbreModalMoradorFaturamento" style="cursor: pointer;"><i class="fa fa-user"></i></a>
		                	</div>
		            	</div>
		            </div>
	                
	                <div class="form-group">
	                	<label class="col-sm-4 control-label">Recurso</label>
	                    <div class="col-sm-8">
	                    	<select class="form-control m-b" name="aluguelComercio.aluguel.recurso.id">
	                         <option value="0">Selecione</option>
	                         <c:forEach items="${recursos}" var="recurso">
	                         	<option value="${recurso.id}" <c:if test="${aluguelComercio.aluguel.recurso.id == recurso.id}">selected="selected"</c:if> >${recurso.nome} </option>
	                         </c:forEach>
	                    	</select>
	                    </div>
	                </div>
	                
	                <div class="form-group" id="dataInicial">
	             		<label class="col-sm-4 control-label">Período</label>
	                    <div class="col-sm-8">
	                    	<div class="input-group date">
	                    		<input type="text" class="form-control" name="aluguelComercio.aluguel.dataInicial" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${aluguelComercio.aluguel.dataInicial}" />"  data-mask="99/99/9999" >
	                    		<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
	                    	</div>
	                    </div>
	                </div>
	                
	                <div class="form-group" id="dataFinal">
	             		<label class="col-sm-4 control-label"></label>
	                    <div class="col-sm-8">
	                    	<div class="input-group date">
	                    		<input type="text" class="form-control" name="aluguelComercio.aluguel.dataFinal" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${aluguelComercio.aluguel.dataFinal}" />"  data-mask="99/99/9999" >
	                    		<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
	                    	</div>
	                    </div>
	                </div>
	                
	                <div class="form-group" id="dataPagamento">
	             		<label class="col-sm-4 control-label">Pagamento</label>
	                    <div class="col-sm-8">
	                    	<div class="input-group date">
	                    		<input type="text" class="form-control" name="aluguelComercio.aluguel.dataEmissaoFaturamento" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${aluguelComercio.aluguel.dataEmissaoFaturamento}" />"  data-mask="99/99/9999" >
	                    		<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
	                    	</div>
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">Observação</label>
	                    <div class="col-sm-8">
	                    	<textarea name="aluguelComercio.aluguel.observacao" class="form-control" rows="" cols="">${aluguelComercio.aluguel.observacao}</textarea>
	                    </div>
	                </div>
	                
				</div>
				</fieldset>
				<br/>
					
				<div class="row">
					<div class="col-lg-12">
						<div class="ibox-content">
							<div class="form-group">
			                    <div class="col-sm-12">
			                        <a class="btn btn-outline btn-default" href="${linkTo[AluguelComercioController].listagemAluguelComercio}" > Cancelar</a>
			                        <button class="btn btn-primary" type="submit"> <i class="fa fa-check"></i> Salvar</button>
			                    </div>
			                </div>			
						</div>
					</div>
				</div>	
				
				<ul class="errors">
					<c:forEach items="${errors}" var="error">
						<li>
							${error.category}: ${error.message}
						</li>
					</c:forEach>
				</ul>
				
		    </div> 

		    <div class="col-lg-6">
		    <fieldset>
			    <legend>Comércio</legend>
			    <div class="ibox-content">
			    	
			    	<div class="form-group">
		            	<label class="col-sm-4 control-label">Nome</label>
		              	<div class="col-sm-8">
		            		<input type="text" class="form-control" name="aluguelComercio.nome" value="${aluguelComercio.nome}">
		                </div>
		        	</div>
			    	
		   			<div class="form-group">
		            	<label class="col-sm-4 control-label">Alvará</label>
		              	<div class="col-sm-8">
		            		<input type="text" class="form-control" name="aluguelComercio.numeroAlvara" value="${aluguelComercio.numeroAlvara}">
		                </div>
		        	</div>
		        	
		        	<div class="form-group" id="dataPagamento">
	             		<label class="col-sm-4 control-label">Data Emissão</label>
	                    <div class="col-sm-8">
	                    	<div class="input-group date">
	                    		<input type="text" class="form-control" name="aluguelComercio.dataEmissao" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${aluguelComercio.dataEmissao}" />"  data-mask="99/99/9999" >
	                    		<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
	                    	</div>
	                    </div>
	                </div>
	                
	                <div class="form-group" id="dataPagamento">
	             		<label class="col-sm-4 control-label">Data Vencimento</label>
	                    <div class="col-sm-8">
	                    	<div class="input-group date">
	                    		<input type="text" class="form-control" name="aluguelComercio.dataVencimento" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${aluguelComercio.dataVencimento}" />"  data-mask="99/99/9999" >
	                    		<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
	                    	</div>
	                    </div>
	                </div>
		               
		            <div class="form-group">
		            	<label class="col-sm-4 control-label">Largura</label>
		                <div class="col-sm-8">
		                	<input type="text" class="form-control" name="aluguelComercio.larguraBarraca" value="${aluguelComercio.larguraBarraca}">
		                </div>
		          	</div>
		          	
		          	<div class="form-group">
		            	<label class="col-sm-4 control-label">Comprimento</label>
		                <div class="col-sm-8">
		                	<input type="text" class="form-control" name="aluguelComercio.comprimentoBarraca" value="${aluguelComercio.comprimentoBarraca}">
		                </div>
		          	</div>
		               
		            <div class="form-group">
		            	<label class="col-sm-4 control-label">Quantidade Pessoas</label>
		                <div class="col-sm-8">
		                	<input type="text" class="form-control" name="aluguelComercio.qtdePessoas" value="${aluguelComercio.qtdePessoas}">
		                </div>
		          	</div>
		               
		            <div class="form-group">
		            	<label class="col-sm-4 control-label">Equipamentos</label>
		                <div class="col-sm-8">
		                	<input type="text" class="form-control" name="aluguelComercio.equipamentos" value="${aluguelComercio.equipamentos}">
		                </div>
		          	</div>
		          	
		          	<div class="form-group">
		            	<label class="col-sm-4 control-label">Produtos</label>
		                <div class="col-sm-8">
		                	<input type="text" class="form-control" name="aluguelComercio.produtos" value="${aluguelComercio.produtos}">
		                </div>
		          	</div>
		          	
			    </div> 
			    </fieldset>
		   	</div> 
	   	</form>         
    </div>
</div>

<script src="${pageContext.request.contextPath}/manual_install_components/moment/moment-with-locales.min.js"></script>
<script src="${pageContext.request.contextPath}/manual_install_components/eonasdan-bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
    
<script src="${pageContext.request.contextPath}/js/paginas/aluguelComercio/formularioAluguelComercio.js"></script>

﻿<%@ include file="/footer.jsp" %>
