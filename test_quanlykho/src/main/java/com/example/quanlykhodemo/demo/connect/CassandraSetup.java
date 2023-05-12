package com.example.quanlykhodemo.demo.connect;

import com.datastax.oss.driver.api.core.CqlSession;

public class CassandraSetup {
    private CqlSession session;

    public CassandraSetup(CqlSession session) {
        this.session = session;
    }

    public void createKeyspace(String keyspaceName, String replicationStrategy, int replicationFactor) {
        String query = "CREATE KEYSPACE IF NOT EXISTS " + keyspaceName +
                " WITH replication = {'class': '" + replicationStrategy +
                "', 'replication_factor': '" + replicationFactor + "'}";

        session.execute(query);
    }

    public void createTable(String tableName) {
        String query = "CREATE TABLE IF NOT EXISTS " + tableName +
                " (id INT PRIMARY KEY, name TEXT, age INT)";

        session.execute(query);
    }
}
