##定义初始变量
#set($tableName = $tool.append($tableInfo.name, "DAO"))
##设置回调
$!callback.setFileName($tool.append($tableName, ".java"))
$!callback.setSavePath($tool.append($tableInfo.savePath, "/dao"))

#if($tableInfo.savePackageName)package $!{tableInfo.savePackageName}.#{end}dao;

import $!{tableInfo.savePackageName}.model.entity.$!{tableInfo.name};
import net.stackoverflow.cms.common.QueryWrapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * ($!{tableInfo.name})表数据库访问层
 *
 * @author $!author
 * @since $!time.currTime()
 */
@Repository
public interface $!{tableName} {
    
    /**
     * 根据条件统计
     *
     * @param wrapper
     * @return
     */
    int countByCondition(QueryWrapper wrapper);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    $!{tableInfo.name} select(String id);
    
    /**
     * 条件查询
     *
     * @param wrapper
     * @return
     */
    List<$!{tableInfo.name}> selectByCondition(QueryWrapper wrapper);

    /**
     * 新增
     *
     * @param permission
     * @return
     */
    int insert($!{tableInfo.name} $!tool.firstLowerCase($!{tableInfo.name}));

    /**
     * 批量新增
     *
     * @param permissions
     * @return
     */
    int batchInsert(List<$!{tableInfo.name}> $!tool.firstLowerCase($!{tableInfo.name})s);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int delete(String id);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    int batchDelete(List<String> ids);
    
    /**
     * 根据条件删除
     *
     * @param wrapper
     * @return
     */
    int deleteByCondition(QueryWrapper wrapper);

    /**
     * 更新
     *
     * @param permission
     * @return
     */
    int update($!{tableInfo.name} $!tool.firstLowerCase($!{tableInfo.name}));

    /**
     * 批量更新
     *
     * @param permissions
     * @return
     */
    int batchUpdate(List<$!{tableInfo.name}> $!tool.firstLowerCase($!{tableInfo.name})s);
    
    /**
     * 根据条件更新
     *
     * @param wrapper
     * @return
     */
    int updateByCondition(QueryWrapper wrapper);
}