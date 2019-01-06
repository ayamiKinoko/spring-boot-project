package com.example.demo.config;

import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.Naming;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.MysqlDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DomaConfig implements Config {
    private DataSource dataSource;

    @Autowired
    Naming naming;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = new TransactionAwareDataSourceProxy(dataSource);
    }

    @Override
    public Dialect getDialect() {
        return new MysqlDialect();
    }

    @Override
    public DataSource getDataSource() {
        return dataSource;
    }

    @Override
    public Naming getNaming() {
        return naming;
    }

}
