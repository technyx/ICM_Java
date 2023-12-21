package org.technyx.icm.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Faq")
@Table(name = "tb_faq")
public class Faq extends BaseObject{

    @Column(name = "c_question"
            , columnDefinition = "TEXT")
    private String question;

    @Column(name = "c_answer"
            , columnDefinition = "TEXT")
    private String answer;
}
