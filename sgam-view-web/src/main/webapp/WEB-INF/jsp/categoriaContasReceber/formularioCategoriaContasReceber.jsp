<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<shiro:hasPermission name="sgam.configuracoes.categoria_contas_receber.editar">

<%@ include file="/headerMenu.jsp" %> 


<div class="row wrapper border-bottom white-bg page-heading">
     <div class="col-lg-12">
         <h2>Categorias de recebimento</h2>
         <ol class="breadcrumb">
             <li>
                 <a href="${linkTo[LoginController].paginaInicial}">Inicio</a>
             </li>
             <li>
                 <span>Configurações</span>
             </li>
             <li class="active">
                 <strong>Categoria das Contas a Receber</strong>
             </li>

			<div class="pull-right">
            	<a class="label label-default" href="${linkTo[CategoriaContasReceberController].listagemCategoriasContasReceber}"> <i class="fa fa-angle-left"></i><i class="fa fa-angle-left"></i> Voltar</a>
            </div>

         </ol>
     </div>
 </div>
 
 <div class="wrapper wrapper-content animated fadeInRight">
 	<div class="row">
 		<form id="categoriaContasReceberForm" method="post" class="form-horizontal" action="${linkTo[CategoriaContasReceberController].cadastraCategoriaContasReceber}">
			<div class="col-lg-8">
		        <div class="ibox-content">
	         		<input type="hidden" name="categoria.id" value="${categoria.id }"/>
	         	
	             	<div class="form-group">
	             		<label class="col-sm-4 control-label">Nome</label>
	                    <div class="col-sm-8">
	                    	<input type="text" disabled="disabled" class="form-control" value="${categoria.nome}">
	                    	<input type="hidden" name="categoria.nome" value="${categoria.nome}">
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">Descrição</label>
	                    <div class="col-sm-8">
	                    	<textarea class="form-control" disabled="disabled" rows="5" cols="">${categoria.descricao}</textarea>
	                    	<input type="hidden" name="categoria.descricao" value="${categoria.descricao}">
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">Valor</label>
	                    <div class="col-sm-8">
	                    	<input type="text" id="txtValorCategoria" class="form-control" name="categoria.valor" value="<fmt:formatNumber value="${categoria.valor}" type="number"  pattern="#,##0.00"/>"  >
	                    </div>
	                </div>
				</div>
				
				<br/>
					
				<div class="row">
					<div class="col-lg-12">
						<div class="ibox-content">
							<div class="form-group">
			                    <div class="col-sm-12">
			                        <a class="btn btn-outline btn-default" href="${linkTo[CategoriaContasReceberController].listagemCategoriasContasReceber}"> Cancelar</a>
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
	   	</form>         
    </div>
</div>

<script src="${pageContext.request.contextPath}/manual_install_components/jquery-maskmoney/jquery.maskMoney.min.js"></script>
<script src="${pageContext.request.contextPath}/js/paginas/categoriaContasReceber/formularioCategoriaContasReceber.js"></script>
   
<script src="${pageContext.request.contextPath}/js/plugins/jquery-ui/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/js/plugins/validate/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-validation-messages.js"></script>

﻿<%@ include file="/footer.jsp" %>

</shiro:hasPermission>

<shiro:lacksPermission name="sgam.configuracoes.categoria_contas_receber.editar">
	<jsp:include page="/semPermissaoAcesso.jsp" flush="true"/>
</shiro:lacksPermission>