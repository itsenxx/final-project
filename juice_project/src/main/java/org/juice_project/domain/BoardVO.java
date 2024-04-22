package org.juice_project.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Getter
@Setter
public class BoardVO {
  private int boardId;
  private int boardEmpId;
  private String title;
  private String content;
  private String file1;
  private String file2;
  private String boardDate;
  private int forWho;
  private String empName;
}
