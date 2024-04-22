package org.juice_project.service;

import org.juice_project.domain.BoardVO;
import org.juice_project.domain.Criteria;
import org.juice_project.domain.MaterialVO;

import java.util.List;

public interface MaterialService {
    public List<MaterialVO> getList(Criteria cri);
}
