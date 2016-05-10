package zw.co.hitrac.tpg;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.string.StringValue;

/**
 *
 * @author Tonderai Ndangana
 * 21/04/2016
 */
public class TpgPageParametersUtil {

    public final static String ID = "id";

    private TpgPageParametersUtil() {
    }

    public static Long extractId(PageParameters parameters, String IdName) {
        StringValue idStringValue = parameters.get(IdName);
        Long id = null;
        if (idStringValue != null) {

            try {
                id = Long.valueOf(idStringValue.toString());

            } catch (NumberFormatException ex) {
                id = null;
            }
        }
        return id;
    }

    public static Long extractId(PageParameters parameters) {
        return extractId(parameters, ID);
    }
}
