package net.stackoverflow.cms.common;

import lombok.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 条件查询（新版模板）
 *
 * @author minsheng.cai
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class QueryWrapper {
    /**
     * 每页大小
     */
    private Integer limit;
    /**
     * 偏移量
     */
    private Integer offset;
    /**
     * 排序条件
     */
    private Map<String, String> sortWrapper;
    /**
     * 相等条件
     */
    private Map<String, Object> eqWrapper;
    /**
     * 模糊查询条件
     */
    private Map<String, List<String>> keyWrapper;

    /**
     * QueryWrapperBuilder 建造者
     */
    public static class QueryWrapperBuilder {

        private Integer limit;
        private Integer offset;
        private Map<String, String> sortWrapper;
        private Map<String, Object> eqWrapper;
        private Map<String, List<String>> keyWrapper;

        public QueryWrapperBuilder() {
            sortWrapper = new LinkedHashMap<>();
            eqWrapper = new HashMap<>();
            keyWrapper = new HashMap<>();
        }

        /**
         * 添加字段eq条件
         *
         * @param column 字段名
         * @param value  值
         * @return 返回建造者对象
         */
        public synchronized QueryWrapperBuilder eq(String column, Object value) {
            assert column != null;
            eqWrapper.put(column, value);
            return this;
        }

        /**
         * 添加模糊查询条件
         *
         * @param key     关键字
         * @param columns 字段
         * @return 返回建造者对象
         */
        public synchronized QueryWrapperBuilder like(String key, List<String> columns) {
            assert key != null && columns != null && columns.size() > 0;
            keyWrapper.put(key, columns);
            return this;
        }

        /**
         * 分页条件
         *
         * @param offset 偏移量
         * @param limit  每页大小
         * @return 返回建造者对象
         */
        public synchronized QueryWrapperBuilder page(Integer offset, Integer limit) {
            assert offset >= 0 && limit > 1;
            this.offset = offset;
            this.limit = limit;
            return this;
        }

        /**
         * 顺序排序
         *
         * @param column 排序字段
         * @return 返回建造者对象
         */
        public synchronized QueryWrapperBuilder asc(String column) {
            assert column != null;
            sortWrapper.put(column, "asc");
            return this;
        }

        /**
         * 逆序排序
         *
         * @param column 排序字段
         * @return 返回建造者对象
         */
        public synchronized QueryWrapperBuilder desc(String column) {
            assert column != null;
            sortWrapper.put(column, "desc");
            return this;
        }

        /**
         * 构建ConditionRequest对象
         *
         * @return 返回ConditionRequest对象
         */
        public QueryWrapper build() {
            return new QueryWrapper(limit, offset, sortWrapper, eqWrapper, keyWrapper);
        }
    }
}
