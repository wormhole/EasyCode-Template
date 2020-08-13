##定义初始变量
#set($tableName = $tool.append($tableInfo.name, "DAO"))
##设置回调
$!callback.setFileName($tool.append($tableName, ".java"))
$!callback.setSavePath($tool.append($tableInfo.savePath, "/dao"))

#if($tableInfo.savePackageName)package $!{tableInfo.savePackageName}.#{end}dao;

import $!{tableInfo.savePackageName}.model.entity.$!{tableInfo.name};
import net.stackoverflow.cms.common.QueryWrapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * ($!{tableInfo.name})表数据库访问层
 *
 * @author $!author
 * @since $!time.currTime()
 */
@Mapper
public interface $!{tableName} {

    List<$!{tableInfo.name}> selectByCondition(QueryWrapper wrapper);
    
    int countByCondition(QueryWrapper wrapper);

    $!{tableInfo.name} select(String id);

    int insert($!{tableInfo.name} $!tool.firstLowerCase($!{tableInfo.name}));

    int batchInsert(List<$!{tableInfo.name}> $!tool.firstLowerCase($!{tableInfo.name})s);

    int delete(String id);

    int batchDelete(List<String> ids);

    int update($!{tableInfo.name} $!tool.firstLowerCase($!{tableInfo.name}));

    int batchUpdate(List<$!{tableInfo.name}> $!tool.firstLowerCase($!{tableInfo.name})s);

}