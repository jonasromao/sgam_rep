<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<shiro:hasPermission name="sgam.configuracoes.perfil.incluir">

<%@ include file="/headerMenu.jsp" %> 

<link href="${pageContext.request.contextPath}/manual_install_components/eonasdan-bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/plugins/dataTables/datatables.min.css" rel="stylesheet">

<div class="row wrapper border-bottom white-bg page-heading">
     <div class="col-lg-12">
         <h2>Fluxo de Caixa</h2>
         <ol class="breadcrumb">
             <li>
                 <a href="${linkTo[LoginController].paginaInicial}">Inicio</a>
             </li>
			<li>
                 <span>Financeiro</span>
             </li>
             <li class="active">
                <strong>Fluxo de Caixa</strong>
             </li>

         </ol>
     </div>
 </div>
 
 <div class="wrapper wrapper-content animated fadeInRight">
 	<form class="form-horizontal" method="post"  action="${linkTo[MetricasController].buscaPeriodo}">
		<div class="ibox float-e-margins">
			<div class="ibox-content">
		 		<div class="row">
			    	<div class="col-lg-3">
						<div class="form-group">
		             		<label class="col-sm-3 control-label">Inicio</label>
		                    <div class="col-sm-9">
		                    	<div class="input-group date">
		                    		<input type="text" class="form-control" name="dataInicio" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${dataInicio}" />"  data-mask="99/99/9999" >
		                    		<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
		                    	</div>
		                    </div>
		                </div>
			    	</div>
			    	
			    	<div class="col-lg-3">
						<div class="form-group">
		             		<label class="col-sm-3 control-label">Fim</label>
		                    <div class="col-sm-9">
		                    	<div class="input-group date">
		                    		<input type="text" class="form-control" name="dataFim" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${dataFim}" />" data-mask="99/99/9999" >
		                    		<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
		                    	</div>
		                    </div>
		                </div>
			    	</div>
			    	
			    	<div class="col-lg-3">
						<div class="form-group">
		             		<label class="col-sm-3 control-label">Status</label>
		                    <div class="col-sm-9">
		                    	<select class="form-control" name="status">
		                    		<option value="P" <c:if test="${status eq 'P'}">selected="selected"</c:if> > Pago</option>
		                    		<option value="NP" <c:if test="${status eq 'NP'}">selected="selected"</c:if> >Não Pago</option>
		                    		<option value="T" <c:if test="${status eq 'T'}">selected="selected"</c:if> >Todos</option>
		                    	</select>
		                    </div>
		                </div>
			    	</div>
			    	
			    	<div class="col-lg-3 pull-right">
						<button type="submit" id="btnBuscar" class="btn btn-primary pull-right">Buscar</button>
			    	</div>
				</div>
			</div>
		</div>
	</form>
	
		<div class="row">
			<div class="col-lg-12">
	        	<div class="ibox float-e-margins">
		        	<div class="ibox-title">
	                    <h5><strong>Totais </strong> <small>Visão geral do caixa no período</small></h5>
	                    <div class="ibox-tools">
	                        <a class="collapse-link">
	                            <i class="fa fa-chevron-up"></i>
	                        </a>
	                    </div>
	                </div>
		        	
		        	<div class="ibox-content">
		        		<div class="table-responsive">
							<table id="tabelaTotaisMetricas" class="table table-striped table-bordered table-hover"> 
								<thead>
									<tr>
										<th>Associados</th>
										<th>Recursos</th>
										<th>Contas a pagar</th>
										<th>Total Geral</th>
									</tr>
								</thead>
								
								<tbody>
									<tr>
										<td><fmt:formatNumber value="${valorTotalAssociado}" type="currency"/></td>
										<td><fmt:formatNumber value="${valorTotalAluguel}" type="currency"/></td>
										<td><fmt:formatNumber value="${valorContasPagar}" type="currency"/></td>
										<td><fmt:formatNumber value="${totalGeral}" type="currency"/></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
		    </div>            
	    </div>
		
		<div class="row">
			<div class="col-lg-12">
	        	<div class="ibox float-e-margins">
		        	<div class="ibox-title">
	                    <h5>Associados<small> Visão detalhada de valores recebidos dos associados</small></h5>
	                    <div class="ibox-tools">
	                        <a class="collapse-link">
	                            <i class="fa fa-chevron-up"></i>
	                        </a>
	                    </div>
	                </div>
		        	
		        	<div class="ibox-content">
		        		<div class="table-responsive">
							<table id="tabelaAssociadosMetricas" class="table table-striped table-bordered table-hover"> 
								<thead>
									<tr>
										<th>Morador</th>
										<th>Vencimento</th>
										<th>Pagamento</th>
										<th>Valor</th>
									</tr>
								</thead>
								<tfoot>
						            <tr>
						                <th colspan="3" style="text-align:right">Total:</th>
						                <th><fmt:formatNumber value="${valorTotalAssociado}" type="currency"/></th>
						            </tr>
						        </tfoot>
								
								<tbody>
									<c:forEach var="conta" items="${contasReceberAssociados}">
										<tr >
											<td>${conta.morador.nome}</td>
											<td><fmt:formatDate pattern="dd/MM/yyyy" value="${conta.dataVencimento}" /></td>
											<td><fmt:formatDate pattern="dd/MM/yyyy" value="${conta.dataPagamento}" /></td>
											<td><fmt:formatNumber value="${conta.valor}" type="currency"/></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
		    </div>            
	    </div>
	    
		<div class="row">
			<div class="col-lg-12">
	        	<div class="ibox float-e-margins">
		        	<div class="ibox-title">
	                    <h5>Recursos<small> Visão detalhada de valores recebidos por recurso</small></h5>
	                    <div class="ibox-tools">
	                        <a class="collapse-link">
	                            <i class="fa fa-chevron-up"></i>
	                        </a>
	                    </div>
	                </div>
		        	
		        	<div class="ibox-content">
		        		<div class="table-responsive">
							<table id="tabelaRecursosMetricas" class="table table-striped table-bordered table-hover"> 
								<thead>
									<tr>
										<th>Recurso</th>
										<th>Início</th>
										<th>Fim</th>
										<th>Período</th>
										<th>Pagamento</th>
										<th>Valor</th>
									</tr>
								</thead>
								<tfoot>
						            <tr>
						                <th colspan="5" style="text-align:right">Total:</th>
						                <th><fmt:formatNumber value="${valorTotalAluguel}" type="currency"/></th>
						            </tr>
						        </tfoot>
								
								<tbody>
									<c:forEach var="conta" items="${contasReceber}">
										<tr >
											<td>${conta.aluguel.recurso.nome}</td>
											<td><fmt:formatDate pattern="dd/MM/yyyy" value="${conta.aluguel.dataInicial}" /></td>
											<td><fmt:formatDate pattern="dd/MM/yyyy" value="${conta.aluguel.dataFinal}" /></td>
											<td><fmt:formatDate pattern="HH:mm" value="${conta.aluguel.dataInicial}" /> - <fmt:formatDate pattern="HH:mm" value="${conta.aluguel.dataFinal}" /></td>
											<td><fmt:formatDate pattern="dd/MM/yyyy" value="${conta.dataPagamento}" /></td>
											<td><fmt:formatNumber value="${conta.valor}" type="currency"/></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
		    </div>            
	    </div>
	    
	    <div class="row">
			<div class="col-lg-12">
	        	<div class="ibox float-e-margins">
		        	<div class="ibox-title">
	                    <h5>Contas a pagar<small> Visão detalhada de valores das contas a pagar</small></h5>
	                    <div class="ibox-tools">
	                        <a class="collapse-link">
	                            <i class="fa fa-chevron-up"></i>
	                        </a>
	                    </div>
	                </div>
		        	
		        	<div class="ibox-content">
		        		<div class="table-responsive">
							<table id="tabelaContasPagarMetricas" class="table table-striped table-bordered table-hover"> 
								<thead>
									<tr>
										<th>Nome</th>
										<th>Fornecedor</th>
										<th>Emissão</th>
										<th>Vencimento</th>
										<th>Pagamento</th>
										<th>Valor</th>
									</tr>
								</thead>
								<tfoot>
						            <tr>
						                <th colspan="5" style="text-align:right">Total:</th>
						                <th><fmt:formatNumber value="${valorContasPagar}" type="currency"/></th>
						            </tr>
						        </tfoot>
								
								<tbody>
									<c:forEach var="conta" items="${contasPagar}">
										<tr >
											<td>${conta.nome}</td>
											<td>${conta.fornecedor.nome}</td>
											<td><fmt:formatDate pattern="dd/MM/yyyy" value="${conta.dataEmissao}" /></td>
											<td><fmt:formatDate pattern="dd/MM/yyyy" value="${conta.dataVencimento}" /></td>
											<td><fmt:formatDate pattern="dd/MM/yyyy" value="${conta.dataPagamento}" /></td>
											<td><fmt:formatNumber value="${conta.valor}" type="currency"/></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
		    </div>            
	    </div>
	    
	    
</div>

<script src="${pageContext.request.contextPath}/manual_install_components/moment/moment-with-locales.min.js"></script>
<script src="${pageContext.request.contextPath}/manual_install_components/eonasdan-bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/js/plugins/dataTables/datatables.min.js"></script>
<script src="${pageContext.request.contextPath}/js/paginas/metricas/listagemMetricas.js"></script>

﻿<%@ include file="/footer.jsp" %>

</shiro:hasPermission>

<shiro:lacksPermission name="sgam.configuracoes.perfil.incluir">
	<jsp:include page="/semPermissaoAcesso.jsp" flush="true"/>
</shiro:lacksPermission>