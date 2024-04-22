package org.juice_project.domain;

import lombok.Data;

import java.util.List;

@Data
public class BomRequestVO {
    private int prodId;
    private List<BomVO> materials;
}
