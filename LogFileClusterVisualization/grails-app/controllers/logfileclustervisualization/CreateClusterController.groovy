package logfileclustervisualization

class CreateClusterController {
    def CreateClusterService
    def index() { 
        def message = "Module is  created successfully."
        render(view: "index", model: [message: message])
    }
    def cluster(){
        def message = "Clusters are created successfully"
        if(CreateClusterService.clusterService()){        
            redirect(controller: "Main", action:"infoClusterCreation")
        }
        else{
            render(view: "index", model: [message: message])
        }
    }
}
