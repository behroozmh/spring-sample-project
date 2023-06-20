package ir.behi.YmlAtRuntime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceModel {
    private Integer id;
    private String name;
    private String url;
    private Integer tryCount;
}
