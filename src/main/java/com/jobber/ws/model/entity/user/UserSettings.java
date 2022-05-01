package com.jobber.ws.model.entity.user;

import com.jobber.ws.model.entity.settings.*;
import lombok.Data;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;

@Entity
@Table(name = "USER_SETTINGS")
@Data
@Scope("prototype")
public class UserSettings {

    @Id
    private Long id;

    @OneToOne
    private User owner;

    @Enumerated(EnumType.ORDINAL)
    private Language language = Language.AZ;

    @Enumerated(EnumType.ORDINAL)
    private Theme theme = Theme.LIGHT;

    @Enumerated(EnumType.ORDINAL)
    private ProfileVisibility profileVisibility = ProfileVisibility.ON;

    @Enumerated(EnumType.ORDINAL)
    private OfferNotification offerNotification = OfferNotification.ON;

    @Enumerated(EnumType.ORDINAL)
    private OnlineVisibility onlineVisibility = OnlineVisibility.ON;

}
