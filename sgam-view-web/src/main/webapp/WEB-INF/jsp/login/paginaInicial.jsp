<%@ include file="/headerMenu.jsp" %> 

<div class="wrapper wrapper-content">
        <div class="row">
                    <div class="col-lg-3">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <span class="label label-success pull-right">Geral</span>
                                <h5>Moradores</h5>
                            </div>
                            <div class="ibox-content">
                                <h1 class="no-margins">2.000</h1>
                                <div class="stat-percent font-bold text-success">98% <i class="fa fa-bolt"></i></div>
                                <small>Total de Moradores</small>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <span class="label label-info pull-right">Geral</span>
                                <h5>Associados</h5>
                            </div>
                            <div class="ibox-content">
                                <h1 class="no-margins">500</h1>
                                <div class="stat-percent font-bold text-info">25% <i class="fa fa-level-up"></i></div>
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
                                <h1 class="no-margins">15</h1>
                                <div class="stat-percent font-bold text-navy">44% <i class="fa fa-level-up"></i></div>
                                <small>Novos Associados</small>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <span class="label label-danger pull-right">Abertas</span>
                                <h5>Ocorrências</h5>
                            </div>
                            <div class="ibox-content">
                                <h1 class="no-margins">5</h1>
                                <div class="stat-percent font-bold text-danger">38% <i class="fa fa-level-down"></i></div>
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
                                    <a class="close-link">
                                        <i class="fa fa-times"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="ibox-content ibox-heading">
                                <h3><i class="fa fa-envelope-o"></i> Novas ocorrências</h3>
                                <small><i class="fa fa-tim"></i> Existem 5 ocorrências abertas.</small>
                            </div>
                            <div class="ibox-content">
                                <div class="feed-activity-list">

                                    <div class="feed-element">
                                        <div>
                                            <small class="pull-right text-navy">1m ago</small>
                                            <strong>Monica Smith</strong>
                                            <div>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum</div>
                                            <small class="text-muted">Today 5:60 pm - 12.06.2014</small>
                                        </div>
                                    </div>

                                    <div class="feed-element">
                                        <div>
                                            <small class="pull-right">2m ago</small>
                                            <strong>Jogn Angel</strong>
                                            <div>There are many variations of passages of Lorem Ipsum available</div>
                                            <small class="text-muted">Today 2:23 pm - 11.06.2014</small>
                                        </div>
                                    </div>

                                    <div class="feed-element">
                                        <div>
                                            <small class="pull-right">5m ago</small>
                                            <strong>Jesica Ocean</strong>
                                            <div>Contrary to popular belief, Lorem Ipsum</div>
                                            <small class="text-muted">Today 1:00 pm - 08.06.2014</small>
                                        </div>
                                    </div>

                                    <div class="feed-element">
                                        <div>
                                            <small class="pull-right">5m ago</small>
                                            <strong>Monica Jackson</strong>
                                            <div>The generated Lorem Ipsum is therefore </div>
                                            <small class="text-muted">Yesterday 8:48 pm - 10.06.2014</small>
                                        </div>
                                    </div>


                                    <div class="feed-element">
                                        <div>
                                            <small class="pull-right">5m ago</small>
                                            <strong>Anna Legend</strong>
                                            <div>All the Lorem Ipsum generators on the Internet tend to repeat </div>
                                            <small class="text-muted">Yesterday 8:48 pm - 10.06.2014</small>
                                        </div>
                                    </div>
                                    <div class="feed-element">
                                        <div>
                                            <small class="pull-right">5m ago</small>
                                            <strong>Damian Nowak</strong>
                                            <div>The standard chunk of Lorem Ipsum used </div>
                                            <small class="text-muted">Yesterday 8:48 pm - 10.06.2014</small>
                                        </div>
                                    </div>
                                    <div class="feed-element">
                                        <div>
                                            <small class="pull-right">5m ago</small>
                                            <strong>Gary Smith</strong>
                                            <div>200 Latin words, combined with a handful</div>
                                            <small class="text-muted">Yesterday 8:48 pm - 10.06.2014</small>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-8">

                        <div class="row">
                            <div class="col-lg-12">
                                <div class="ibox float-e-margins">
                                    <div class="ibox-title">
                                        <h5>Agendamento dos espaços</h5>
                                        <div class="ibox-tools">
                                            <a class="collapse-link">
                                                <i class="fa fa-chevron-up"></i>
                                            </a>
                                            <a class="close-link">
                                                <i class="fa fa-times"></i>
                                            </a>
                                        </div>
                                    </div>
                                    <div class="ibox-content">
                                        <table class="table table-hover no-margins">
                                            <thead>
                                            <tr>
                                                <th>Recurso</th>
                                                <th>Data</th>
                                                <th>Morador</th>
                                                <th>Observação</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <tr>
                                                <td><span class="label label-warning">Quadra</span> </td>
                                                <td><i class="fa fa-clock-o"></i> 10/06/2016 06:30h</td>
                                                <td>Samantha</td>
                                                <td class="text-navy"> Observação </td>
                                            </tr>
                                            <tr>
                                                <td><span class="label label-warning">Quadra</span> </td>
                                                <td><i class="fa fa-clock-o"></i> 10/06/2016 08:30h</td>
                                                <td>Monica</td>
                                                <td class="text-navy"> Observação </td>
                                            </tr>
 
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
                                        <h5>Contas a pagar</h5>
                                        <div class="ibox-tools">
                                            <a class="collapse-link">
                                                <i class="fa fa-chevron-up"></i>
                                            </a>
                                            <a class="close-link">
                                                <i class="fa fa-times"></i>
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
                                            <tr>
                                                <td>Energia </td>
                                                <td>Escelsa</td>
                                                <td>10/06/2016</td>
                                                <td class="text-navy"> R$ 85,00 </td>
                                                <td><span class="label label-warning">Pendente</span> </td>
                                            </tr>
                                            <tr>
                                                <td>Água</td>
                                                <td>Cesan</td>
                                                <td>10/06/2016</td>
                                                <td class="text-navy"> R$ 20,00 </td>
                                                <td><span class="label label-warning">Pendente</span> </td>
                                            </tr>
 
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