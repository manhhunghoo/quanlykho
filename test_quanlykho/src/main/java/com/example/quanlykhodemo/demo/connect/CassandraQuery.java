package com.example.quanlykhodemo.demo.connect;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class CassandraQuery {
    private Session session;

    public CassandraQuery(Session session) {
        this.session = session;
    }

    public void runQuery() {
        ResultSet results = session.execute("SELECT * FROM mykeyspace.mytable WHERE id = 1");
        for (Row row : results) {
            System.out.println(row.getString("name"));
        }
    }
}
