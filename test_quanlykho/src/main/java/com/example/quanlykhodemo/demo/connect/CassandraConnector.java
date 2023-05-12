package com.example.quanlykhodemo.demo.connect;

import com.datastax.oss.driver.api.core.CqlSession;

public class CassandraConnector {
    private CqlSession session;

    public void connect(String node, Integer port) {
        session = CqlSession.builder()
                .addContactPoint(node)
                .withPort(port)
                .withKeyspace("my_keyspace") // tùy chọn, chỉ định keyspace mặc định
                .build();
    }

    public void close() {
        session.close();
    }
}