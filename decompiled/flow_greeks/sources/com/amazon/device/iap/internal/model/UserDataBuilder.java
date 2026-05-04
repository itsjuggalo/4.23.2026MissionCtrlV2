package com.amazon.device.iap.internal.model;

import com.amazon.device.iap.model.LWAConsentStatus;
import com.amazon.device.iap.model.UserData;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class UserDataBuilder {
    private LWAConsentStatus lwaConsentStatus;
    private String marketplace;
    private String userId;

    public UserData build() {
        return new UserData(this);
    }

    public LWAConsentStatus getLWAConsentStatus() {
        return this.lwaConsentStatus;
    }

    public String getMarketplace() {
        return this.marketplace;
    }

    public String getUserId() {
        return this.userId;
    }

    public UserDataBuilder setLWAConsentStatus(String str) {
        this.lwaConsentStatus = LWAConsentStatus.getEnumForValue(str);
        return this;
    }

    public UserDataBuilder setMarketplace(String str) {
        this.marketplace = str;
        return this;
    }

    public UserDataBuilder setUserId(String str) {
        this.userId = str;
        return this;
    }
}
