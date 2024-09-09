package es.ies.Controller;

public class ControllerPath {
    private String projectPath = "";
    private String executionPath = "";
    private String resourcesPath = "";
    private String productsPath = "";

    public ControllerPath() {
        this.executionPath = getExecutionPath();
        this.projectPath = getProjectPath();
        this.resourcesPath = getResourcesPath();
        this.productsPath = getProductsPath();
    }

//obtener ruta//
    private String getProjectPath() {
        if (this.executionPath.substring(this.executionPath.length()-3)=="src") {
            return this.executionPath.substring(0,
                    this.executionPath.length() - 3);
        }
        return this.executionPath;
    }

    private String getExecutionPath() {
        return System.getProperty("user.dir")+"/";
    }

    public String getResourcesPath() {
        return this.projectPath + "resources/";
    }

    public String getProductsPath() {
        return this.projectPath + "products/";
    }


    public String getDinamicResourcesTypePath(String resouceType){
        return resourcesPath+resouceType+"/";
    }

    public String getDinamicElementPath(String element){
        return this.projectPath + element;
    }

    public String getDinamicResourceTypePath(String resourceType){
        return this.resourcesPath+resourceType+"/";
    }

    public String getDinamicProductsTypePath(String productsType) {
        return this.productsPath+productsType+".txt";
    }

}
