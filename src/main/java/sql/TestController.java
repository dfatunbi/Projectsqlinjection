package sql;

import io.github.lucienh.sqlinjection.dao.InjectionParamDao;
import io.github.lucienh.sqlinjection.dao.InjectionParamDaoImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TestController {

    private TestDao testDao;

    @Resource
    public void setTestDao(TestDao testDao) {
        this.testDao = testDao;
    }

    private InjectionParamDao injectionParamDao;

    @Resource
    public void setInjectionParamDao(InjectionParamDao injectionParamDao) {
        this.injectionParamDao = injectionParamDao;
    }

    @RequestMapping(value = "/sql/injection", method = RequestMethod.GET)
    public Map findByName(HttpServletRequest request) {
        String name = request.getParameter("name");
        System.out.println("name is " + name);
        try {
            injectionParamDao.addInjectionLog(name);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List list = testDao.nativeFindByName(name);
        Map<String, Object> map = new HashMap<String, Object>(2);
        map.put("success", true);
        map.put("data", list);
        return map;
    }

    @RequestMapping(value = "/post/sql/injection", method = RequestMethod.POST)
    public Map postFindByName(HttpServletRequest request) {
        String name = request.getParameter("name");
        System.out.println("name is " + name);
        List list = testDao.nativeFindByName(name);
        Map<String, Object> map = new HashMap<String, Object>(2);
        map.put("success", true);
        map.put("data", list);
        return map;
    }

    @RequestMapping(value = "/sql/_init", method = RequestMethod.GET)
    public void init() {
        testDao.init();
    }
}