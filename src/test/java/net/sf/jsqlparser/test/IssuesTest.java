/*-
 * #%L
 * JSQLParser library
 * %%
 * Copyright (C) 2004 - 2020 JSQLParser
 * %%
 * Dual licensed under GNU LGPL 2.1 or Apache License 2.0
 * #L%
 */
package net.sf.jsqlparser.test;

import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.create.index.CreateIndex;
import net.sf.jsqlparser.util.TablesNamesFinder;
import org.junit.Test;

import java.util.List;

public class IssuesTest {

    @Test
    public void issue607() throws Exception {
        String sqlString = "select * from User u where (u.name,u.age)=('bazz',20)";
        Statement statement = CCJSqlParserUtil.parse(sqlString);
        TablesNamesFinder tablesNamesFinder = new TablesNamesFinder();
        List<String> tableList = tablesNamesFinder.getTableList(statement);
        tableList.forEach(System.out::println);
    }

    @Test
    public void nextIssue() throws Exception {
        Statement stmt = CCJSqlParserUtil.parse(
                "SELECT {fn CURRENT_TIMESTAMP(0)} AS COL");
        System.out.println(stmt);
    }
}
