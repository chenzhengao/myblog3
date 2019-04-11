package myblog.pojo;

import java.util.List;

/**
 * @program: myblog3
 * @description: 分页类
 * @author: czg
 * @create: 2019-04-08 15:41
 */
public class Page<T> {
    //当前页
    private int currentPage;
    //总页数
    private int totalPage;
    //一页包含几行数据
    private int pageSize=5;
    //总数据数
    private int allDataSize;
    //当页数据
    private List<T> rows;
    //当前执行的SQL
    private String sql;

    //起点下标
    private int startNum;
    //终点下标
    private int endNum;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;

        startNum=pageSize*(currentPage-1);
        endNum=pageSize*currentPage;
        if(currentPage==totalPage){
            endNum=allDataSize;
        }
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getAllDataSize() {
        return allDataSize;
    }

    public void setAllDataSize(int allDataSize) {
        this.allDataSize = allDataSize;
        //设置总页数
        totalPage=allDataSize%pageSize==0?allDataSize/pageSize:allDataSize/pageSize+1;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public int getStartNum() {
        return startNum;
    }

    public void setStartNum(int startNum) {
        this.startNum = startNum;
    }

    public int getEndNum() {
        return endNum;
    }

    public void setEndNum(int endNum) {
        this.endNum = endNum;
    }

    @Override
    public String toString() {
        return "Page{" +
                "currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", pageSize=" + pageSize +
                ", allDataSize=" + allDataSize +
                ", rows=" + rows +
                ", sql='" + sql + '\'' +
                ", startNum=" + startNum +
                ", endNum=" + endNum +
                '}';
    }
}
