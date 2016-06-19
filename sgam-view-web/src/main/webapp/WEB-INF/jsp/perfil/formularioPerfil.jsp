<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="/headerMenu.jsp" %> 

<link href="${pageContext.request.contextPath}/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/plugins/dataTables/datatables.min.css" rel="stylesheet">

<div class="row wrapper border-bottom white-bg page-heading">
     <div class="col-lg-12">
         <h2>Perfil</h2>
         <ol class="breadcrumb">
             <li>
                 <a href="${linkTo[LoginController].paginaInicial}">Inicio</a>
             </li>
             <li>
                 <span>Configurações</span>
             </li>
             <li class="active">
                 <a href="${linkTo[PerfilController].listagemPerfis}"><strong>Perfil</strong></a>
             </li>

			<div class="pull-right">
            	<a class="label label-default" href="${linkTo[PerfilController].listagemPerfis}"> <i class="fa fa-angle-left"></i><i class="fa fa-angle-left"></i> Voltar</a>
            </div>

         </ol>
     </div>
 </div>
 
 <div class="wrapper wrapper-content animated fadeInRight">
 	<form id="ocorrenciaForm" method="post" class="form-horizontal" action="${linkTo[PerfilController].cadastraPerfil}">
 		
 		<input type="hidden" name="perfil.id" value="${perfil.id }"/>
		
 		<div class="row">
	    	<div class="col-lg-4">
	    		<div class="ibox-content">
			    	<div class="form-group">
			 			<label class="col-sm-3 control-label">Nome</label>
						<div class="col-sm-9">
							<input id="nomePerfil" type="text" class="form-control" name="ocorrencia.titulo" value="${ocorrencia.titulo}">
						</div>
					</div>
					
					<div class="form-group">
			 			<label class="col-sm-3 control-label">Descrição</label>
						<div class="col-sm-9">
							<textarea class="form-control" name="perfil.descricao" rows="2" cols="">${perfil.descricao}</textarea>
						</div>
					</div>
					
					
					<div class="row">
						<div class="col-lg-12">
							<div class="form-group">
			                    <div class="col-sm-12">
			                        <a class="btn btn-outline btn-default" href="${linkTo[OcorrenciaController].listagemOcorrencias}"> Cancelar</a>
			                        <button id="btnSalvar" class="btn btn-primary" type="submit"> <i class="fa fa-check"></i> Salvar</button>
			                        
			                        <ul class="errors">
										<c:forEach items="${errors}" var="error">
											<li>
												${error.category}: ${error.message}
											</li>
										</c:forEach>
									</ul>
			                    </div>
			                </div>			
						</div>
					</div>
	           	</div>
	    	</div>

		 	<div class="col-lg-8">
		 		<div class="ibox-content">
       				<table id="tabelaFuncoes" class="table table-condensed table-hover ">
              			<thead>
                			<tr>
                				<th>
                           			<div class="checkbox checkbox-primary">
                               			<input id="checkboxAll" type="checkbox">
                 						<label for="checkboxAll"></label>
                           			</div>
                             	</th>
                    			<th>Nome</th>
                    			<th>Menu</th>
                    			<th>Descrição</th>
                			</tr>
               			</thead>
               			<tbody>
	               			<c:forEach items="${funcoes}" var="funcao">
								<tr>
									<td>
										<div class="checkbox checkbox-primary">
                                  			<input type="checkbox" class="marcar" name="perfil.funcoes" id="${funcao.id}" value="${funcao.id}"  >
                                  			<label for="${funcao.id}"></label>
                              			</div>
									</td>
	
									<td>
										${funcao.nome}
									</td>
									
									<td>
										${funcao.categoriaFuncao.nome}
									</td>
						
									<td>
										${funcao.descricao}
									</td>
								</tr>
		 					</c:forEach>
             			</tbody>
					</table>
		 		</div>  
	 		</div> 
	    </div>
    </form>	
</div>


<script src="${pageContext.request.contextPath}/js/plugins/dataTables/datatables.min.js"></script>
<script src="${pageContext.request.contextPath}/js/plugins/jquery-ui/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/js/plugins/validate/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-validation-messages.js"></script>

<script src="${pageContext.request.contextPath}/js/paginas/perfil/formularioPerfil.js"></script>

﻿<%@ include file="/footer.jsp" %>