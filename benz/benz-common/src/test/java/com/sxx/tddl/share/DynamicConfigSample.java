package com.sxx.tddl.share;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.taobao.tddl.client.jdbc.TDataSource;

public class DynamicConfigSample {

    public static void main(String[] args) throws Exception {

        TDataSource ds = new TDataSource();
        ds.setAppName("LIFEMALL_APP");
        ds.setDynamicRule(true);
        ds.init();

        System.out.println("init done");
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            // select 10 records
            conn = ds.getConnection();
            // ps =
            // conn.prepareStatement("SELECT * FROM autonic_multiGroup_multiAtom limit 10");
            ps = conn.prepareStatement("SELECT * FROM permission where user_id= 2052103431");
            // ps =
            // conn.prepareStatement("SELECT COUNT(*) FROM autonic_multiGroup_multiAtom");
            // PreparedStatement ps =
            // conn.prepareStatement("show create table  autonic_multiGroup_multiAtom");
            // PreparedStatement ps =
            // conn.prepareStatement("delete from autonic_multiGroup_multiAtom where gmt_create='0000-00-00'");
            // ps.execute();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                StringBuilder sb = new StringBuilder();
                int count = rs.getMetaData().getColumnCount();
                for (int i = 1; i <= count; i++) {
                    String key = rs.getMetaData().getColumnLabel(i);
                    Object val = rs.getObject(i);
                    sb.append("[" + rs.getMetaData().getTableName(i) + "." + key + "->" + val + "]");
                }
                System.out.println(sb.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        System.out.println("query done");
    }
}
