package com.revenuecat.purchases.paywalls.events;

import com.revenuecat.purchases.InternalRevenueCatAPI;

/* JADX INFO: loaded from: classes3.dex */
@InternalRevenueCatAPI
public enum PaywallEventType {
    IMPRESSION("paywall_impression"),
    CANCEL("paywall_cancel"),
    CLOSE("paywall_close");

    private final String value;

    PaywallEventType(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
