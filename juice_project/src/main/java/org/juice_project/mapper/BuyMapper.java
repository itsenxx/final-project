package org.juice_project.mapper;



import org.juice_project.domain.BuyVO;
import org.juice_project.domain.Criteria;

import java.util.List;

public interface BuyMapper {




    void insertSelectKey1(BuyVO vo);

    BuyVO read(int mater_id);

    int update(BuyVO buy);

    int delete(String mater_id);

    List<BuyVO> getList();
}