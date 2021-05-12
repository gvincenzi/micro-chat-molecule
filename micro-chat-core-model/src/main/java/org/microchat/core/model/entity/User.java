package org.microchat.core.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    private String userId;
    @Column
    private String nickname;
    @Column(nullable = false)
    private String channelUUID;
    @Column
    private String code;
    @Column
    private ChannelType channelType;
}
