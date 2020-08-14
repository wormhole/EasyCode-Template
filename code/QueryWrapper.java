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
     * 更新字段
     */
    private Map<String, Object> upWrapper;

    /**
     * QueryWrapperBuilder 建造者
     */
    public static class QueryWrapperBuilder {

        private Integer limit;
        private Integer offset;
        private Map<String, String> sortWrapper;
        private Map<String, Object> eqWrapper;
        private Map<String, List<String>> keyWrapper;
        private Map<String, Object> upWrapper;

        public QueryWrapperBuilder() {
            sortWrapper = new LinkedHashMap<>();
            eqWrapper = new HashMap<>();
            keyWrapper = new HashMap<>();
            upWrapper = new HashMap<>();
        }

        /**
         * 添加字段eq条件
         *
         * @param condition 条件
         * @param column    字段名
         * @param value     值
         * @return 返回建造者对象
         */
        public synchronized QueryWrapperBuilder eq(Boolean condition, String column, Object value) {
            if (condition) {
                eqWrapper.put(column, value);
            }
            return this;
        }

        /**
         * 添加字段eq条件
         *
         * @param column 字段名
         * @param value  值
         * @return 返回建造者对象
         */
        public synchronized QueryWrapperBuilder eq(String column, Object value) {
            return eq(true, column, value);
        }

        /**
         * 添加模糊查询条件
         *
         * @param condition 条件
         * @param key       关键字
         * @param columns   字段
         * @return 返回建造者对象
         */
        public synchronized QueryWrapperBuilder like(Boolean condition, String key, List<String> columns) {
            if (condition) {
                keyWrapper.put(key, columns);
            }
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
            return like(true, key, columns);
        }

        /**
         * 分页条件
         *
         * @param condition 条件
         * @param offset    偏移量
         * @param limit     每页大小
         * @return 返回建造者对象
         */
        public synchronized QueryWrapperBuilder page(Boolean condition, Integer offset, Integer limit) {
            if (condition) {
                this.offset = offset;
                this.limit = limit;
            }
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
            return page(true, offset, limit);
        }

        /**
         * 顺序排序
         *
         * @param column 排序字段
         * @return 返回建造者对象
         */
        public synchronized QueryWrapperBuilder asc(String column) {
            return asc(true, column);
        }

        /**
         * 顺序排序
         *
         * @param condition 条件
         * @param column    排序字段
         * @return 返回建造者对象
         */
        public synchronized QueryWrapperBuilder asc(Boolean condition, String column) {
            if (condition) {
                sortWrapper.put(column, "asc");
            }
            return this;
        }

        /**
         * 逆序排序
         *
         * @param column 排序字段
         * @return 返回建造者对象
         */
        public synchronized QueryWrapperBuilder desc(String column) {
            return desc(true, column);
        }

        /**
         * 逆序排序
         *
         * @param condition 条件
         * @param column    排序字段
         * @return 返回建造者对象
         */
        public synchronized QueryWrapperBuilder desc(Boolean condition, String column) {
            if (condition) {
                sortWrapper.put(column, "desc");
            }
            return this;
        }

        /**
         * 自定义排序
         *
         * @param column 排序字段
         * @param sort   排序方式
         * @return 返回建造者对象
         */
        public synchronized QueryWrapperBuilder sort(String column, String sort) {
            return sort(true, column, sort);
        }

        /**
         * 自定义排序
         *
         * @param condition 条件
         * @param column    排序字段
         * @param sort      排序方式
         * @return 返回建造者对象
         */
        public synchronized QueryWrapperBuilder sort(Boolean condition, String column, String sort) {
            if (condition) {
                sortWrapper.put(column, sort);
            }
            return this;
        }

        /**
         * 更新操作中，需要更新的字段的值
         *
         * @param condition 条件
         * @param column    需要更新的字段
         * @param value     需要更新的值
         * @return 返回建造者对象
         */
        public synchronized QueryWrapperBuilder update(Boolean condition, String column, String value) {
            if (condition) {
                upWrapper.put(column, value);
            }
            return this;
        }

        /**
         * 更新操作中，需要更新的字段的值
         *
         * @param column 需要更新的字段
         * @param value  需要更新的值
         * @return 返回建造者对象
         */
        public synchronized QueryWrapperBuilder update(String column, String value) {
            return update(true, column, value);
        }

        /**
         * 构建ConditionRequest对象
         *
         * @return 返回ConditionRequest对象
         */
        public QueryWrapper build() {
            return new QueryWrapper(limit, offset, sortWrapper, eqWrapper, keyWrapper, upWrapper);
        }
    }
}
