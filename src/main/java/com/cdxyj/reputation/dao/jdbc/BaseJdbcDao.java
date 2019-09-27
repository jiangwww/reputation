package com.cdxyj.reputation.dao.jdbc;

import com.cdxyj.reputation.dao.IBaseJdbcDao;
import com.cdxyj.reputation.vo.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

/**
 * @Author jiangwei
 * @Description
 * @Date 2019/9/27
 **/
public class BaseJdbcDao implements IBaseJdbcDao{
    @Autowired
    JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate(){
        return jdbcTemplate;
    }
    @Override
    public int update(String sql, Object[] args, int[] argTypes) throws DataAccessException {
        try {
            int i = getJdbcTemplate().update(sql, args, argTypes);
            return i;
        } catch (DataAccessException e) {
            throw e;
        }
    }

    @Override
    public String queryForString(String sql) throws DataAccessException {
        try {
            String str = (String) getJdbcTemplate().queryForObject(sql, String.class);
            return str;
        } catch (DataAccessException e) {
            throw e;
        }
    }

    @Override
    public int queryForInt(String sql) throws DataAccessException {
        return 0;
    }

    @Override
    public long queryForLong(String sql) throws DataAccessException {
        return 0;
    }

    @Override
    public <T> Object queryForObject(String sql, Class<T> objectClass) throws DataAccessException {
        return null;
    }

    @Override
    public boolean tableExist(String tableName) throws DataAccessException {
        return false;
    }

    @Override
    public boolean dataExist(String tableName, String whereClause) throws DataAccessException {
        return false;
    }

    @Override
    public long getSequence(String name) throws DataAccessException {
        return 0;
    }

    @Override
    public <T> List<T> queryForList(String sql, Object[] args, int[] argTypes, Class<T> poClass) throws DataAccessException {
        return null;
    }

    @Override
    public <T> T queryForObject(String sql, Object[] args, int[] argTypes, Class<T> poClass) throws DataAccessException {
        return null;
    }

    @Override
    public <T> List<T> queryByPage(String sql, Object[] args, int[] argTypes, PageInfo page, Class<T> poClass) throws DataAccessException {
        return null;
    }

    @Override
    public <T> List<T> queryByPage(String sql, PageInfo page, Class<T> poClass) throws DataAccessException {
        return queryByPage(sql, page, new BeanPropertyRowMapper<T>(poClass));
    }

    public <T> List<T> queryByPage(String sql, PageInfo page, RowMapper<T> mapper)
            throws DataAccessException {
        try {
            if(page != null){
                page.setTotalRecords(getMaxRowCount(sql));
            }
            List<T> list = getJdbcTemplate().query(prepareSql(sql, page), mapper);
            return list;
        } catch (DataAccessException e) {
            throw e;
        }
    }
    public String prepareSql(String sql, PageInfo page) {
        if(page == null) return sql;

        StringBuffer sqlBuf = new StringBuffer(50 + sql.length());
        long PageTotalRecords = page.getTotalRecords();
        /*** 总记录数 */
        int PageStartIndex = page.getStartIndex();
        /** 显示记录开始页数 */
        int PageResults = page.getResults();
        /** 页面显示记录条数 */
        int end = PageStartIndex + PageResults;
        /** 显示到第几条记录条数 */
        sqlBuf
                .append("SELECT tt.* FROM")
                .append(" (SELECT ROWNUM rid,t.* FROM (")
                .append(sql)
                .append(") t) tt WHERE rid >")
                .append(
                        (PageTotalRecords > 0 && PageStartIndex > PageTotalRecords) ? 0
                                : PageStartIndex)
                .append(" AND rid <= ")
                .append(
                        (PageTotalRecords > 0 && end > PageTotalRecords) ? PageTotalRecords
                                : end);
        return sqlBuf.toString();
    }
    @Override
    public String getSequenceStr(String seqName) throws DataAccessException {
        return null;
    }

    @Override
    public int getMaxRowCount(String sql, Object[] args, int[] argTypes) throws DataAccessException {
        return 0;
    }

    @Override
    public int getMaxRowCount(String sql) throws DataAccessException {
        return 0;
    }

    @Override
    public <T> List<T> queryForList(String sql, Class<T> poClass) throws DataAccessException {
        return null;
    }
}
