<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="/headerMenu.jsp" %> 

<div class="wrapper wrapper-content">
        <div class="row">
                    <div class="col-lg-3">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <span class="label label-success pull-right">Geral</span>
                                <h5><a id="linkMoradorListagem" onclick="marcarMenuAtivo('menuCadastros', 'submenuMoradores', 'collapseCadastros')" href="${linkTo[MoradorController].listagemMoradores}">Moradores</a></h5>
                            </div>
                            <div class="ibox-content">
                                <h1 class="no-margins">${totalMoradores}</h1>
                                <div class="stat-percent font-bold text-success"><i class="fa fa-group"></i></div>
                                <small>Total de Moradores</small>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <span class="label label-info pull-right">Geral</span>
                                <h5><a id="linkMoradorListagem" onclick="marcarMenuAtivo('menuCadastros', 'submenuMoradores', 'collapseCadastros')" href="${linkTo[MoradorController].listagemMoradores}">Associados</a></h5>
                            </div>
                            <div class="ibox-content">
                                <h1 class="no-margins">${totalAssociados}</h1>
                                <div class="stat-percent font-bold text-info"><fmt:formatNumber value="${porcentSocios}" type="number" pattern="#,##0.00"/>% <i class="fa fa-group"></i></div>
                                <small>Total de Associados</small>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <span class="label label-primary pull-right">Mês</span>
                                <h5>Associados</h5>
                            </div>
                            <div class="ibox-content">
                                <h1 class="no-margins">${totalAssociadosMes}</h1>
                                <div class="stat-percent font-bold text-navy"><fmt:formatNumber value="${porcentSociosMes}" type="number" pattern="#,##0.00"/>% <i class="fa fa-group"></i></div>
                                <small>Novos Associados</small>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <span class="label label-danger pull-right">Abertas</span>
                                <h5><a onclick="marcarMenuAtivo('menuOcorrencias', '', '')" href="${linkTo[OcorrenciaController].listagemOcorrencias}">Ocorrências</a></h5>
                            </div>
                            <div class="ibox-content">
                                <h1 class="no-margins">${qtdOcorrencias}</h1>
                                <div class="stat-percent font-bold text-danger"> <i class="fa fa-warning"></i></div>
                                <small>Ocorrências Abertas</small>
                            </div>
                        </div>
            		</div>
        </div>
        <div class="row">
                    <div class="col-lg-12">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <h5>Pagamentos</h5>
                                <div class="pull-right">
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-xs btn-white">Mensal</button>
                                        <button type="button" class="btn btn-xs btn-white">Anual</button>
                                    </div>
                                </div>
                            </div>
                            <div class="ibox-content">
                                <div class="row">
                                <div class="col-lg-9">
                                    <div class="flot-chart">
                                        <div class="flot-chart-content" id="flot-dashboard-chart"></div>
                                    </div>
                                </div>
                                <div class="col-lg-3">
                                    <ul class="stat-list">
                                        <li>
                                            <h2 class="no-margins">300</h2>
                                            <small>Quantidade alugado</small>
                                            <div class="stat-percent">48% <i class="fa fa-level-up text-navy"></i></div>
                                            <div class="progress progress-mini">
                                                <div style="width: 48%;" class="progress-bar"></div>
                                            </div>
                                        </li>
                                        <li>
                                            <h2 class="no-margins ">290</h2>
                                            <small>Quantidade pago</small>
                                            <div class="stat-percent">60% <i class="fa fa-level-down text-navy"></i></div>
                                            <div class="progress progress-mini">
                                                <div style="width: 60%;" class="progress-bar"></div>
                                            </div>
                                        </li>
                                        <li>
                                            <h2 class="no-margins ">R$ 8.500,00</h2>
                                            <small>Valor Total</small>
                                            <div class="stat-percent">90% <i class="fa fa-bolt text-navy"></i></div>
                                            <div class="progress progress-mini">
                                                <div style="width: 22%;" class="progress-bar"></div>
                                            </div>
                                        </li>
                                        </ul>
                                    </div>
                                </div>
                                </div>

                            </div>
                        </div>
                    </div>


                <div class="row">
                    <div class="col-lg-4">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <h5>Ocorrências</h5>
                                <div class="ibox-tools">
                                    <a class="collapse-link">
                                        <i class="fa fa-chevron-up"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="ibox-content ibox-heading">
                                <h3><i class="fa fa-envelope-o"></i> Novas ocorrências</h3>
                                <small><i class="fa fa-tim"></i> Existem ${qtdOcorrencias} ocorrências abertas.</small>
                            </div>
                            <div class="ibox-content">
                                <div class="feed-activity-list">
									<c:forEach var="ocorrencia" items="${ocorrencias}">
										<div class="feed-element">
	                                        <div>
	                                        
		                                        <c:choose>
													<c:when test="${ocorrencia.prioridade eq 'Baixa'}">
														<small class="pull-right text-navy"><span class="label label-primary">${ocorrencia.prioridade}</span></small>
													</c:when>
													
													<c:when test="${ocorrencia.prioridade eq 'Média'}">
														<small class="pull-right text-navy"><span class="label label-warning">${ocorrencia.prioridade}</span></small>
													</c:when>
													
													<c:otherwise>
														<small class="pull-right text-navy"><span class="label label-danger">${ocorrencia.prioridade}</span></small>
													</c:otherwise>
												</c:choose>
	                                        
	                                            
	                                            <strong><a onclick="marcarMenuAtivo('menuCadastros', 'submenuMoradores', 'collapseCadastros')" href="${linkTo[MoradorController].editarMorador(ocorrencia.morador.id)}">${ocorrencia.morador.nome}</a></strong>
	                                            <div><a onclick="marcarMenuAtivo('menuOcorrencias', '', '')" href="${linkTo[OcorrenciaController].editarOcorrencia(ocorrencia.id)}">${ocorrencia.titulo}</a></div>
	                                            <small class="text-muted">Aberta desde <fmt:formatDate pattern="dd/MM/yyyy" value="${ocorrencia.dataInicio}" /></small>
	                                        </div>
	                                    </div>
									</c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-8">

                        <div class="row">
                            <div class="col-lg-12">
                                <div class="ibox float-e-margins">
                                    <div class="ibox-title">
                                        <h5>Agendamentos de hoje - <fmt:formatDate pattern="dd/MM/yyyy" value="${dataAtual}" /></h5>
                                        <div class="ibox-tools">
                                            <a class="collapse-link">
                                                <i class="fa fa-chevron-up"></i>
                                            </a>
                                        </div>
                                    </div>
                                    <div class="ibox-content">
                                        <table class="table table-hover no-margins">
                                            <thead>
                                            <tr>
                                                <th>Recurso</th>
                                                <th>Morador</th>
                                                <th>Inicio</th>
                                                <th>Fim</th>
                                                <th>Valor</th>
                                                <th>Pagamento</th>
                                            </tr>
                                            </thead>
                                            <tbody>
	                                            <c:forEach var="aluguel" items="${alugueis}">
													<tr>
														<td>${aluguel.recurso.nome}</td>
														<td><a onclick="marcarMenuAtivo('menuCadastros', 'submenuMoradores', 'collapseCadastros')" title="Link para acessar cadastro do morador" href="${linkTo[MoradorController].editarMorador(aluguel.morador.id)}">${aluguel.morador.nome}</a></td>
														<td><i class="fa fa-clock-o"></i> <fmt:formatDate pattern="HH:mm" value="${aluguel.dataInicial}" /></td>
														<td><i class="fa fa-clock-o"></i> <fmt:formatDate pattern="HH:mm" value="${aluguel.dataFinal}" /></td>
														<td><fmt:formatNumber value="${aluguel.contaReceber.valor}" type="currency"/></td>
														<c:choose>
															<c:when test="${aluguel.contaReceber.status eq 'Recebida'}">
																<td><span class="label label-primary">${aluguel.contaReceber.status}</span></td>
															</c:when>
															
															<c:when test="${aluguel.contaReceber.status eq 'Pendente'}">
																<td><span class="label label-warning">${aluguel.contaReceber.status}</span></td>
															</c:when>
															
															<c:otherwise>
																<td><span class="label label-danger">${aluguel.contaReceber.status}</span></td>
															</c:otherwise>
														</c:choose>
													</tr>
												</c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            
                        </div>

                        <div class="row">
                            <div class="col-lg-12">
                                <div class="ibox float-e-margins">
                                    <div class="ibox-title">
                                        <h5>Contas a pagar do mês atual</h5>
                                        <div class="ibox-tools">
                                            <a class="collapse-link">
                                                <i class="fa fa-chevron-up"></i>
                                            </a>
                                        </div>
                                    </div>
                                    <div class="ibox-content">
                                        <table class="table table-hover no-margins">
                                            <thead>
                                            <tr>
                                                <th>Nome</th>
                                                <th>Fornecedor</th>
                                                <th>Vencimento</th>
                                                <th>Valor</th>
                                                <th>Status</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            	<c:forEach var="conta" items="${contas}">
													<tr>
														<td>${conta.nome}</td>
														<td><a onclick="marcarMenuAtivo('menuCadastros', 'submenuFornecedores', 'collapseCadastros')" title="Link para acessar cadastro do fornecedor" href="${linkTo[FornecedorController].editarFornecedor(conta.fornecedor.id)}">${conta.fornecedor.nome}</a></td>
														<td><fmt:formatDate pattern="dd/MM/yyyy" value="${conta.dataVencimento}" /></td>
														<td><fmt:formatNumber value="${conta.valor}" type="currency"/></td>
														<c:choose>
															<c:when test="${conta.status eq 'Paga'}">
																<td><span class="label label-primary">${conta.status}</span></td>
															</c:when>
															
															<c:when test="${conta.status eq 'Pendente'}">
																<td><span class="label label-warning">${conta.status}</span></td>
															</c:when>
															
															<c:otherwise>
																<td><span class="label label-danger">${conta.status}</span></td>
															</c:otherwise>
														</c:choose>
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
            </div>


 <!-- Flot -->
    <script src="${pageContext.request.contextPath}/js/plugins/flot/jquery.flot.js"></script>
    <script src="${pageContext.request.contextPath}/js/plugins/flot/jquery.flot.tooltip.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/plugins/flot/jquery.flot.spline.js"></script>
    <script src="${pageContext.request.contextPath}/js/plugins/flot/jquery.flot.resize.js"></script>
    <script src="${pageContext.request.contextPath}/js/plugins/flot/jquery.flot.pie.js"></script>
    <script src="${pageContext.request.contextPath}/js/plugins/flot/jquery.flot.symbol.js"></script>
    <script src="${pageContext.request.contextPath}/js/plugins/flot/jquery.flot.time.js"></script>   

    <!-- Peity -->
    <script src="${pageContext.request.contextPath}/js/plugins/peity/jquery.peity.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/demo/peity-demo.js"></script>

    <!-- jQuery UI -->
    <script src="${pageContext.request.contextPath}/js/plugins/jquery-ui/jquery-ui.min.js"></script>
    
    <!-- Jvectormap -->
    <script src="${pageContext.request.contextPath}/js/plugins/jvectormap/jquery-jvectormap-2.0.2.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
    
    <!-- EayPIE -->
    <script src="${pageContext.request.contextPath}/js/plugins/easypiechart/jquery.easypiechart.js"></script>
    
    <!-- Sparkline -->
    <script src="${pageContext.request.contextPath}/js/plugins/sparkline/jquery.sparkline.min.js"></script>

    <!-- Sparkline demo data  -->
    <script src="${pageContext.request.contextPath}/js/demo/sparkline-demo.js"></script>


	<script src="${pageContext.request.contextPath}/js/paginas/login/paginaInicial.js"></script>

  ﻿<%@ include file="/footer.jsp" %>               