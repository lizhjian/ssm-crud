package com.ziroom.azeroth.mapper.azeroth;

import com.ziroom.azeroth.entity.TargetImport;
import java.util.List;

public interface TargetImportMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TargetImport record);

    TargetImport selectByPrimaryKey(Long id);

    List<TargetImport> selectAll();

    int updateByPrimaryKey(TargetImport record);
}