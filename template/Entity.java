##设置回调
$!callback.setFileName($tool.append($tableInfo.name, ".java"))
$!callback.setSavePath($tool.append($tableInfo.savePath, "/model/entity"))

##使用全局变量实现默认包导入
#if($tableInfo.savePackageName)package $!{tableInfo.savePackageName}.#{end}model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * ($!{tableInfo.name})实体类
 *
 * @author $!author
 * @since $!time.currTime()
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class $!{tableInfo.name} implements Serializable {
    private static final long serialVersionUID = $!tool.serial();
    
#foreach($column in $tableInfo.fullColumn)
    private $!{tool.getClsNameByFullName($column.type)} $!{column.name};
#end
}