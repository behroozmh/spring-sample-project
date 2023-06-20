package ir.behi.YmlAtRuntime;

import org.springframework.core.io.DefaultResourceLoader;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class YamlUtils {
    public static List<ServiceModel> getListYaml() {
        List<ServiceModel> lst = new ArrayList<>();
        try {
            DefaultResourceLoader loader = new DefaultResourceLoader();
            InputStream inputStream = loader.getResource("services.yml").getInputStream();
            Yaml yaml = new Yaml(new Constructor(ServiceListModel.class));
            ServiceListModel load = yaml.load(inputStream);
            lst = load.getServices();
            inputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lst;
    }
}
