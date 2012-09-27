<!--
  To change this template, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta name="layout" content="homeLayout"/>
<title>Log file clustering</title>
<style type="text/css" media="screen">
#status {
  background-color: #eee;
  border: .2em solid #fff;
  margin: 2em 2em 1em;
  padding: 1em;
  width: 12em;
  float: left;
  -moz-box-shadow: 0px 0px 1.25em #ccc;
  -webkit-box-shadow: 0px 0px 1.25em #ccc;
  box-shadow: 0px 0px 1.25em #ccc;
  -moz-border-radius: 0.6em;
  -webkit-border-radius: 0.6em;
  border-radius: 0.6em;
}

.ie6 #status {
  display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
}

#status ul {
  font-size: 0.9em;
  list-style-type: none;
  margin-bottom: 0.6em;
  padding: 0;
}

#status li {
  line-height: 1.3;
}

#status h1 {
  text-transform: uppercase;
  font-size: 1.1em;
  margin: 0 0 0.3em;
}

#page-body {
  margin: 2em 1em 1.25em 18em;
}

h2 {
  margin-top: 1em;
  margin-bottom: 0.3em;
  font-size: 1em;
}

p {
  line-height: 1.5;
  margin: 0.25em 0;
}

#controller-list ul {
  list-style-position: inside;
}

#controller-list li {
  line-height: 1.3;
  list-style-position: inside;
  margin: 0.25em 0;
}

@media screen and (max-width: 480px) {
  #status {
    display: none;
    }

#page-body {
margin: 0 1em 1em;
}

#page-body h1 {
margin-top: 0;
}
}
</style>
<g:javascript src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"/>
<script type="text/javascript" src="${resource(dir: 'js', file: 'jquery.1.7.1.min.js')}"></script>
<script type="text/javascript" src="${resource(dir: 'js', file: 'jquery.easing.1.3.js')}"></script>
<script type="text/javascript" src="${resource(dir: 'js', file: 'jquery.coda-slider-2.0.js')}"></script>
<script type="text/javascript">
$(function () {
var chart;
$(document).ready(function() {
chart = new Highcharts.Chart({
chart: {
renderTo: 'container',
plotBackgroundColor: null,
plotBorderWidth: null,
plotShadow: false
},
title: {
text: 'Log file clustering and visulization'
},
tooltip: {
formatter: function() {
    return '<b>'+ this.point.name +'</b>: '+ this.percentage +' %';
}
},
plotOptions: {
pie: {
    allowPointSelect: true,
    cursor: 'pointer',
    dataLabels: {
        enabled: true,
        color: '#000000',
        connectorColor: '#000000',
        formatter: function() {
            return '<b>'+ this.point.name +'</b>: '+ this.percentage +' %';
        }
    }
}
},
series: ${clusterInfo}
});
});
    
});
</script>
</head>
<body>

  <a href="#page-body" class="skip"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
  <div id="status" role="complementary">
    <h1><u>Clusters Info:</u></h1>
    <ul>
      <li>Total clusters: ${clusters}</li>
      <li>Total log messages: ${logs}</li>
    </ul>

    <h1><u>Browse Clusters:</u></h1>
    <ul>
      <g:form cotroller="Main" action="showClusterContent" method="post">
        <fieldset>
    ${list}
          <input style="width: 150px;" type="submit" value = "BROWSE CLUSTER" />
        </fieldset>
      </g:form>

    </ul>
    <h1><u>Application info:</u></h1>
    <ul>
      <li>Version: 1.0</li>
      <li>Licencing: Free</li>
    </ul>
  </div>
  <div id="page-body" role="main">
    <script src="${resource(dir: 'js', file: 'highcharts.js')}"></script>
    <script src="${resource(dir: 'js/modules', file: 'exporting.js')}"></script>
    <div id="container" style="min-width: 500px; height: 500px; margin: 0 auto"></div>
    <g:form cotroller="Main" action="insertToTheCluster"method ="post">
      <fieldset>
        <label>Message:</label>
        <input style="width: 90%;"type="text" name="message"><br/>
        <input style="width:400px;" type="submit" value="CLUSTER"/>
      </fieldset>
    </g:form>
  </div>
</body>
</html>
