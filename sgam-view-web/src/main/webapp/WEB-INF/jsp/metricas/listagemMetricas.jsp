<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<shiro:hasPermission name="sgam.configuracoes.perfil.incluir">

<%@ include file="/headerMenu.jsp" %> 

<link href="${pageContext.request.contextPath}/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/plugins/dataTables/datatables.min.css" rel="stylesheet">

<div class="row wrapper border-bottom white-bg page-heading">
     <div class="col-lg-12">
         <h2>Métricas</h2>
         <ol class="breadcrumb">
             <li>
                 <a href="${linkTo[LoginController].paginaInicial}">Inicio</a>
             </li>

             <li class="active">
                <strong>Métricas</strong>
             </li>

         </ol>
     </div>
 </div>
 
 <div class="wrapper wrapper-content animated fadeInRight">
 	<form class="form-horizontal" >
		<div class="ibox-content">
	 		<div class="row">
		    	<div class="col-lg-4">
					<div class="form-group">
	             		<label class="col-sm-4 control-label">Data Inicial</label>
	                    <div class="col-sm-8">
	                    	<div class="input-group date">
	                    		<input type="text" class="form-control" name="aluguelComercio.dataEmissao"  data-mask="99/99/9999" >
	                    		<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
	                    	</div>
	                    </div>
	                </div>
		    	</div>
		    	
		    	<div class="col-lg-4">
					<div class="form-group">
	             		<label class="col-sm-4 control-label">Data Final</label>
	                    <div class="col-sm-8">
	                    	<div class="input-group date">
	                    		<input type="text" class="form-control" name="aluguelComercio.dataEmissao" data-mask="99/99/9999" >
	                    		<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
	                    	</div>
	                    </div>
	                </div>
		    	</div>
		    	
		    	<div class="col-lg-4 pull-right">
					<button type="button" id="btnBuscar"    class="btn btn-primary pull-right">Buscar</button>
		    	</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-lg-12">
	        	<div class="ibox float-e-margins">
		        	<div class="ibox-title">
	                    <h5>Recursos <small>Visão detalhada de valores recebidos por recurso</small></h5>
	                    <div class="ibox-tools">
	                        <a class="collapse-link">
	                            <i class="fa fa-chevron-up"></i>
	                        </a>
	                    </div>
	                </div>
		        	
		        	<div class="ibox-content">
		        		<div class="table-responsive">
							<table id="tableListagemContasReceberAssociados" class="table table-striped table-bordered table-hover"> 
								<thead>
									<tr>
										<th>Número</th>
										<th>Nome</th>
										<th>Emissão</th>
										<th>Vencimento</th>
										<th>Valor</th>
										<th>Status</th>
										<th>Opções</th>
									</tr>
								</thead>
								
								<tbody>
									<c:forEach var="conta" items="${contasAssociados}">
										<tr class="linhaContaReceber">
											<td>${conta.numero}</td>
											<td>${conta.nome}</td>
											<td><fmt:formatDate pattern="dd/MM/yyyy" value="${conta.dataEmissao}" /></td>
											<td><fmt:formatDate pattern="dd/MM/yyyy" value="${conta.dataVencimento}" /></td>
											<td><fmt:formatNumber value="${conta.valor}" type="currency"/></td>
											
											<c:choose>
												<c:when test="${conta.status eq 'Recebida'}">
													<td><span class="label label-primary">${conta.status}</span></td>
												</c:when>
												
												<c:when test="${conta.status eq 'Pendente'}">
													<td><span class="label label-warning">${conta.status}</span></td>
												</c:when>
												
												<c:otherwise>
													<td><span class="label label-danger">${conta.status}</span></td>
												</c:otherwise>
											</c:choose>
											
											
											<td style="text-align: center; margin: 20px 0; padding: 10px;"> 
												<shiro:hasPermission name="sgam.financeiro.contas_receber.editar">
													<a title="Editar" class="editar" href="${linkTo[ContasReceberController].editarContaAssociado(conta.id)}"> <i class="fa fa-edit"></i> </a> &nbsp;
												</shiro:hasPermission>
												<shiro:hasPermission name="sgam.financeiro.contas_receber.excluir">
													<a title="Excluir" class="remover" href="${linkTo[ContasReceberController].removeConta(conta.id)}"> <i class="fa fa-trash-o"></i> </a>
												</shiro:hasPermission>
											</td>
											
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
		    </div>            
	    </div>
		
		
    </form>	
</div>

<script src="${pageContext.request.contextPath}/js/paginas/metricas/listagemMetricas.js"></script>

﻿<%@ include file="/footer.jsp" %>

</shiro:hasPermission>

<shiro:lacksPermission name="sgam.configuracoes.perfil.incluir">
	<jsp:include page="/semPermissaoAcesso.jsp" flush="true"/>
</shiro:lacksPermission>