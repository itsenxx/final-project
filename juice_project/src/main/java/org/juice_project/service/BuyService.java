package org.juice_project.service;



import org.juice_project.domain.BomVO;
import org.juice_project.domain.BuyVO;
import org.juice_project.domain.Criteria;


import java.util.List;

public interface BuyService {
    public List<BuyVO> getList();


    public void register(BuyVO vo);
    public BuyVO get(int mater_id);
    public boolean modify(BuyVO bom);
    public boolean remove(String mater_id);

}
