package zw.co.hitrac.tpg.web.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import zw.co.hitrac.tpg.TpgPageParametersUtil;
import zw.co.hitrac.tpg.web.chart.AdvancedPerformanceChart2;
import zw.co.hitrac.tpg.web.model.StudentModel;

/**
 *
 * @author pchikumba
 */
public class StudentViewPage extends WebPage {

    private StudentModel studentModel;

    public StudentViewPage(PageParameters parameters) {
        super(parameters);
        createModel(parameters);

        add(new AdvancedPerformanceChart2("performanceChart", studentModel.getObject().getId(), 1000, 500));

    }

    private void createModel(PageParameters parameters) {
        Long id = TpgPageParametersUtil.extractId(parameters);
        studentModel = new StudentModel(id);
    }

}
