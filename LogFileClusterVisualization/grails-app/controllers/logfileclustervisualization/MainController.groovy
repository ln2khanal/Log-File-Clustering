package logfileclustervisualization

class MainController {
    def ClusterService
    
    def index() {
       
        def clusterInfo = ClusterService.clusterInformation();
        def list = ClusterService.makeList();    
        def counts = ClusterService.clusterLogCount().split(":")
        render(view: "showcluster", model: [clusterInfo: clusterInfo,list:list,logs:counts[0],clusters:counts[1]])
    }
    def insertToTheCluster(){
        def data = ClusterService.insertMessageToTheCluster(params["message"]).split("CHAR")
        def clusterInfo = data[0]
        def listFiles = data[1]
        def counts = ClusterService.clusterLogCount().split(":")
        render(view: "showcluster", model: [clusterInfo: data[0],list:data[1],logs:counts[0],clusters:counts[1]])
    }
    def showClusterContent(){
        def info = ClusterService.listFileContents(params["cluster"]).split("CHAR")
        def counts = ClusterService.clusterLogCount().split(":")
        
        render(view:"displaymessage", model:[message:info[0],list:info[1],logs:counts[0],clusters:counts[1]])
    }
    def infoClusterCreation(){
        def message = "Clusters are created successfully."
        render(view: "index", model: [message: message])
        
    }
}
