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
                "SELECT C_DocType.C_DocType_ID,NULL,COALESCE(C_DocType_Trl.Name,C_DocType.Name) " +
                        "AS Name,C_DocType.IsActive FROM C_DocType LEFT JOIN C_DocType_TRL " +
                        "ON (C_DocType.C_DocType_ID=C_DocType_Trl.C_DocType_ID " +
                        "AND C_DocType_Trl.AD_Language='es_AR') " +
                        "WHERE C_DocType.AD_Client_ID=1010016 AND C_DocType.AD_Client_ID IN (0,1010016) " +
                        "AND C_DocType.c_doctype_id in " +
                        "( select c_doctype2.c_doctype_id from c_doctype as c_doctype2 " +
                        "where substring( c_doctype2.printname from length(c_doctype2.printname) ) " +
                        "= ( select letra from c_letra_comprobante as clc where clc.c_letra_comprobante_id = 1010039) ) " +
                        "AND ( (1010094!=0 AND C_DocType.ad_org_id = 1010094) OR 1010094=0 ) ORDER BY 3 LIMIT 2000");
        System.out.println(stmt);
    }
}
