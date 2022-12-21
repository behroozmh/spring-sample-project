package ir.behi.library.base;

import java.util.ArrayList;
import java.util.List;

/**
 * create User: behrooz.mh
 * Date: 12/20/2022
 * TIME: 12:57 PM
 **/
public interface GeneralMapper<E, M> {
    E ToEntity(M model);

    M ToDTO(E entity);

    default List<E> ToEntities(List<M> models) {
        if (models != null & models.size() > 0) {
            List<E> entities = new ArrayList<>();
            for (M model : models)
                entities.add(ToEntity(model));
            return entities;
        } else return new ArrayList<>();
    }

    default List<M> ToDTOs(List<E> entities) {
        if (entities != null & entities.size() > 0) {
            List<M> models = new ArrayList<>();
            for (E entity : entities)
                models.add(ToDTO(entity));
            return models;
        } else return new ArrayList<>();
    }
}
