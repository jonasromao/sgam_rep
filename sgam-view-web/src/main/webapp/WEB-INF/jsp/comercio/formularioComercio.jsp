<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<shiro:hasPermission name="sgam.cadastros.morador.incluir">

<%@ include file="/headerMenu.jsp" %> 

<link href="${pageContext.request.contextPath}/manual_install_components/eonasdan-bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">

<div class="row wrapper border-bottom white-bg page-heading">
     <div class="col-lg-12">
         <h2>Comércios</h2>
         <ol class="breadcrumb">
             <li>
                 <a href="${linkTo[LoginController].paginaInicial}">Inicio</a>
             </li>
             <li>
                 <span>Cadastros</span>
             </li>
             <li class="active">
                 <a href="${linkTo[ComercioController].listagemMoradores}"><strong>Comércios</strong></a>
             </li>

			<div class="pull-right">
            	<a class="label label-default" href="${linkTo[ComercioController].listagemComercios}"> <i class="fa fa-angle-left"></i><i class="fa fa-angle-left"></i> Voltar</a>
            </div>

         </ol>
     </div>
 </div>
 
 <div class="wrapper wrapper-content animated fadeInRight">
 	<div class="row">
 		<form id="comercioForm" method="post" class="form-horizontal"  action="${linkTo[ComercioController].cadastraComercio}">
			<div class="col-lg-6">
		        <div class="ibox-content">
	         		<input type="hidden" name="comercio.id" value="${morador.id }"/>
	         		<input type="hidden" name="comercio.segmento.id" value="${comercio.segmento.id}" />
	         		
	             	<div class="form-group">
	             		<label class="col-sm-4 control-label">Nome Fantasia</label>
	                    <div class="col-sm-8">
	                    	<input id="nome" type="text" class="form-control" name="comercio.nomeFantasia" value="${comercio.nomeFantasia}">
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">Razão Social</label>
	                    <div class="col-sm-8">
	                    	<input type="text" class="form-control" name="comercio.razaoSocial" value="${comercio.razaoSocial}">
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">CNPJ</label>
	                    <div class="col-sm-8">
	                    	<input type="text" class="form-control" name="comercio.cnpj" value="${comercio.cnpj}" data-mask="999.999.999-99">
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">I.E</label>
	                    <div class="col-sm-8">
	                    	<input type="text" class="form-control" name="comercio.ie" value="${comercio.ie}">
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">Inicio Atividade</label>
	                    <div class="col-sm-8">
	                    	<div class="input-group" id="divInicioAtividade">
	                    		<input type="text" class="form-control" name="comercio.inicioAtividade" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${comercio.inicioAtividade}" />"  data-mask="99/99/9999" >
	                    		<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
	                    	</div>
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">Segmento</label>
	                    <div class="col-sm-8">
	                    	<select class="form-control" name="comercio.segmento.id">
	                    		<option>Selecione</option>
	                    	</select>
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">Telefone Fixo</label>
	                    <div class="col-sm-8">
	                    	<input type="text" class="form-control" name="comercio.telefone" value="${comercio.telefone}" data-mask="9999-9999">
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">Celular</label>
	                    <div class="col-sm-8">
	                    	<input type="text" class="form-control" name="comercio.celular" value="${comercio.celular}" data-mask="99999-9999">
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">Email</label>
	                    <div class="col-sm-8">
	                    	<input type="text" class="form-control" name="comercio.email" value="${comercio.email}">
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">Responsável</label>
	                    <div class="col-sm-8">
	                    	<input type="text" class="form-control" name="comercio.responsavel" value="${comercio.responsavel}">
	                    </div>
	                </div>

				</div>
				
				<br/>
					
				<div class="row">
					<div class="col-lg-12">
						<div class="ibox-content">
							<div class="form-group">
			                    <div class="col-sm-12">
			                        <a class="btn btn-outline btn-default" href="${linkTo[ComercioController].listagemComercio}"> Cancelar</a>
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
			    <div class="ibox-content">
		   			<div class="form-group">
		            	<label class="col-sm-4 control-label">Rua</label>
		              	<div class="col-sm-8">
		            		<input type="text" class="form-control" name="comercio.endereco.rua" value="${comercio.endereco.rua}">
		                </div>
		        	</div>
		               
		            <div class="form-group">
		            	<label class="col-sm-4 control-label">Número</label>
		                <div class="col-sm-8">
		                	<input type="text" id="numeroMorador" class="form-control" name="comercio.endereco.numero" value="${comercio.endereco.numero}">
		                </div>
		          	</div>
		          	
		          	<div class="form-group">
		            	<label class="col-sm-4 control-label">CEP</label>
		                <div class="col-sm-8">
		                	<input type="text" class="form-control" name="comercio.endereco.cep" value="${comercio.endereco.numero}" data-mask="99999-999">
		                </div>
		          	</div>
		               
		            <div class="form-group">
		            	<label class="col-sm-4 control-label">Bairro</label>
		                <div class="col-sm-8">
		                	<input type="text" class="form-control" name="comercio.endereco.bairro" value="${comercio.endereco.bairro}">
		                </div>
		          	</div>
		               
		            <div class="form-group">
		            	<label class="col-sm-4 control-label">Cidade</label>
		                <div class="col-sm-8">
		                	<input type="text" class="form-control" name="comercio.endereco.cidade" value="${comercio.endereco.cidade}">
		                </div>
		          	</div>
			    </div>
		   	</div>
		   	
		   	<br/>
		   	
		   	<div class="row">
		    	<div class="col-lg-12">
		    		<div class="ibox-content">
				    	<div class="form-group">
			            	<label class="col-sm-4 control-label">Observação</label>
			                <div class="col-sm-8">
			                	<textarea class="form-control" name="comercio.observacao" rows="4" cols="">${comercio.observacao}</textarea>
			                </div>
			          	</div>
		    		</div>
		    	</div>
		    </div>
		   	
	   	</form>         
    </div>
</div>

<script src="${pageContext.request.contextPath}/js/plugins/jasny/jasny-bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/manual_install_components/moment/moment-with-locales.min.js"></script>
<script src="${pageContext.request.contextPath}/manual_install_components/eonasdan-bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>

<script src="${pageContext.request.contextPath}/js/plugins/jquery-ui/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/js/plugins/validate/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-validation-messages.js"></script>
 
<script src="${pageContext.request.contextPath}/js/paginas/comercio/formularioComercio.js"></script>

﻿<%@ include file="/footer.jsp" %>

</shiro:hasPermission>

<shiro:lacksPermission name="sgam.cadastros.morador.incluir">
	<jsp:include page="/semPermissaoAcesso.jsp" flush="true"/>
</shiro:lacksPermission>
