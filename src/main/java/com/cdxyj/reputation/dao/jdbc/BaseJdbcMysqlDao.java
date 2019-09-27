package com.cdxyj.reputation.dao.jdbc;

import com.cdxyj.reputation.vo.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * @Author jiangwei
 * @Description
 * @Date 2019/9/27
 **/
public class BaseJdbcMysqlDao extends BaseJdbcDao {
    public BaseJdbcMysqlDao() {
        super();
    }
    public boolean tableExist(String tableName) throws DataAccessException {
        StringBuffer sql = new StringBuffer(200);
        sql.append("select `TABLE_NAME` from `INFORMATION_SCHEMA`.`TABLES` where `TABLE_NAME`='");
        sql.append(tableName).append("'");
        List<?> list = getJdbcTemplate().queryForList(sql.toString());
        return (list != null && !list.isEmpty());
    }

    public boolean dataExist(String tableName, String whereClause)
            throws DataAccessException {
        if (StringUtils.isBlank(tableName)) {
            throw new IllegalArgumentException("数据判存失败：表名参数不合法！");
        }
        StringBuffer sql = new StringBuffer(200);
        sql.append("SELECT 1 FROM ").append(tableName).append(
                " WHERE 1 = 1 ");
        if (StringUtils.isNotBlank(whereClause)) {
            sql.append(" AND (").append(whereClause).append(") limit 0,1");
        }
        return getJdbcTemplate().queryForList(sql.toString()).size() == 1;
    }

    public long getSequence(String seqName) throws DataAccessException {
        StringBuffer sql = new StringBuffer(100);
        sql.append("SELECT nextval('").append(seqName).append("')");
        return getJdbcTemplate().queryForObject(sql.toString(),Integer.class);
    }

    public String getSequenceStr(String seqName) throws DataAccessException {
        StringBuffer sql = new StringBuffer(100);
        sql.append("SELECT cast(nextval('").append(seqName).append(
                "') as char(20))");
        return (String) getJdbcTemplate().queryForObject(sql.toString(),
                String.class);
    }
    public String prepareSql(String sql, PageInfo page) {
        if(page == null) return sql;
        StringBuffer sqlBuf = new StringBuffer(50 + sql.length());
        sqlBuf.append(sql);
        sqlBuf.append(" limit ");
        sqlBuf.append(page.getStartIndex());
        sqlBuf.append(",");
        sqlBuf.append(page.getResults());
        return sqlBuf.toString();
    }
}
