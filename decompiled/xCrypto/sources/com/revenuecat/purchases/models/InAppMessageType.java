package com.revenuecat.purchases.models;

/* JADX INFO: loaded from: classes3.dex */
public enum InAppMessageType {
    BILLING_ISSUES(2);

    private final int inAppMessageCategoryId;

    InAppMessageType(int i4) {
        this.inAppMessageCategoryId = i4;
    }

    public final int getInAppMessageCategoryId$purchases_defaultsRelease() {
        return this.inAppMessageCategoryId;
    }
}
