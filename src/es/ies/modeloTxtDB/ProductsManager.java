package es.ies.modeloTxtDB;

import es.ies.Controller.ControllerPath;

import java.io.*;
import java.util.*;

public class ProductsManager {
    private final Map<String, List<Material>> categorias;
    private final String[] nombresCategorias = {"cimientoYestructura", "cubiertasYtecho",
            "paredesYfachadas", "pisoYrevestimiento"};
    private final ControllerPath controllerPath = new ControllerPath();

        public ProductsManager() throws IOException {
            categorias = new HashMap<>();
            cargarCategorias();
        }

        private ArrayList cargarCategorias() throws IOException {

            ArrayList products = new ArrayList<>();
            int contador = 0;
            for (String nombreCategoria : this.nombresCategorias) {
                categorias.put(nombreCategoria, new ArrayList<>());
                for (Object p :cargarMateriales(nombreCategoria,contador)){
                    products.add(p);
                }
                contador++;
            }
            return products;
        }

    private ArrayList cargarMateriales(String categoria,int index) throws IOException {
            String[][] ElementForGenerate = {{"1,ladrillo,2,0.2x0.5,50,1,2900",
                    "2,madera de estructura,12,0.3x0.3x3,200,2,1020",
                    "3,acero de refurzo,10,7,300,2,1390"
            },
            {"4,tejas metalicas,12,4,1200,2,1230",
                    "5,tuberia de drenaje,1,5,1500,3,456",
                    "6,impermeabilizante,5,1x1,2500,1,356"
            },
            {"7,lleso,2,0.5x0.5,700,1,1232",
                    "8,loza,1,0.3x0.3,1000,1,123000",
                    "9,pintura,3,-,1000,1,129"
            },
            {"10,madera para pizo,8,0.7x2,2000,2,6734",
                    "11,azulejo,1,12,0.3x0.3x3,1000,1,21345",
                    "12,pizo concreo,3,0.5x0.5,1200,3,120067"
            }};
        ArrayList<Material> materialArray = new ArrayList<>();
        File file = new File(controllerPath.getDinamicProductsTypePath(categoria));
        if (!file.exists()) {
            FileManager getPath = new FileManager();
            getPath.createFileIfNotExists(controllerPath.getDinamicProductsTypePath(categoria));
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(controllerPath.getDinamicProductsTypePath(categoria)))) {
                bw.write(ElementForGenerate[index][0]);
                bw.newLine();
                bw.write(ElementForGenerate[index][1]);
                bw.newLine();
                bw.write(ElementForGenerate[index][2]);
                bw.newLine();
            }
            try (BufferedReader br = new BufferedReader(new FileReader(controllerPath.getDinamicProductsTypePath(categoria)))) {
                    String linea = br.readLine();
                    while ((linea = br.readLine()) != null) {
                        String[] campos = linea.split(",");
                        Material material = new Material(
                                Integer.parseInt(campos[0]), campos[1], Double.parseDouble(campos[2]),
                                campos[3], Float.parseFloat(campos[4]), campos[5], Integer.parseInt(campos[6])
                        );
                        materialArray.add(material);

                    }
                } catch (IOException e) {

                }
            }


        return materialArray;
    }

    public void agregarCategoria(String nombreCategoria) {
        categorias.put(nombreCategoria, new ArrayList<>());
    }

    public void agregarMaterial(String categoria, Material material) {
        categorias.get(categoria).add(material);
        guardarMaterial(categoria, material);
    }

    private void guardarMaterial(String categoria, Material material) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(categoria + ".txt", true))) {
            bw.write(material.toString());
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Material obtenerMaterial(String categoria, int id) {
        for (Material material : categorias.get(categoria)) {
            if (material.getId() == id) {
                return material;
            }
        }
        return null;
    }

    public void setMaterial(String categoria, int id, Material nuevoMaterial) {
        List<Material> materiales = categorias.get(categoria);
        for (int i = 0; i < materiales.size(); i++) {
            if (materiales.get(i).getId() == id) {
                materiales.set(i, nuevoMaterial);
                guardarTodosMateriales(categoria);
                break;
            }
        }
    }

    private void guardarTodosMateriales(String categoria) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(categoria + ".txt"))) {
            for (Material material : categorias.get(categoria)) {
                bw.write(material.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNombreCategoria(String nombreCamel) {
        return nombreCamel.replaceAll("([a-z])([A-Z]+)", "$1 $2").toLowerCase();
    }

    public ArrayList getAllMaterials() throws IOException {
        ArrayList arrayList = cargarCategorias();
        return arrayList;
    }

    private void generateProducts(){
            int contador = 1;
            Map<String,String> listProductsGenerate = new HashMap<>();
            for (String nombre :nombresCategorias){
                switch (contador){
                    case 1:
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + contador);
                }
                contador++;
            }

    }

    public static void main(String[] args) throws IOException {
        ProductsManager tienda = new ProductsManager();
        // Ejemplo de uso
        Material nuevoMaterial = new Material(1, "Ladrillo", 2.5, "0.2x0.1x0.05", 0.5, "2 días", 100);
        tienda.agregarMaterial("cimientoYestructura", nuevoMaterial);
        Material material = tienda.obtenerMaterial("cimientoYestructura", 1);
        System.out.println(material);
    }
}


