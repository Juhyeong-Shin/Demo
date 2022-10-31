package com.example.demo.user;


import lombok.AllArgsConstructor;
import lombok.Data;


import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
public class User {
    private Integer id;

    @Size(min=2, message = "Name은 2글자 이상 입력해주세요.")
    private String name;

    @Past   //현재회원이 가입한 날짜를 과거데이터만 가능한 제약조건
    private Date joinDate;
}