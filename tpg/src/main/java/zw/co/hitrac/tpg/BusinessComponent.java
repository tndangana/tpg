package zw.co.hitrac.tpg;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author tndangana
 * @param <T>
 */
public interface BusinessComponent<T> extends Serializable {

    public T save(T t);

    public List<T> findAll();

    public T find(Long id);
    
    public void delete(T t);
    
  

}
