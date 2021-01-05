package net.sf.jsqlparser.statement.select;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import org.junit.Test;

public class Select_HierarchicalQueryTest {

    @Test
    public void connectByRoot() throws JSQLParserException {
        String sql = " SELECT CONNECT_BY_ROOT last_name as ln, Salary\n" +
                "      FROM employees\n" +
                "      WHERE department_id = 110\n" +
                "      CONNECT BY PRIOR employee_id = manager_id\n" +
                "      GROUP BY name";

        final Statement stm = CCJSqlParserUtil.parse(sql);
        System.out.println(stm);
    }
}
