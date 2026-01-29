package com.deepakLearning.HMS.dto;

import com.deepakLearning.HMS.type.BloodGroupType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BloodGroupCountResponseEntity {
    private BloodGroupType bloodGroupType;
    private Long count;

    public BloodGroupCountResponseEntity(BloodGroupType bloodGroupType, Long count) {
        this.bloodGroupType = bloodGroupType;
        this.count = count;
    }
}
