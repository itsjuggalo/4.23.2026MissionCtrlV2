package com.revenuecat.purchases.models;

/* JADX INFO: loaded from: classes2.dex */
public enum InAppMessageType {
    BILLING_ISSUES(2);

    private final int inAppMessageCategoryId;

    InAppMessageType(int i7) {
        this.inAppMessageCategoryId = i7;
    }

    public final int getInAppMessageCategoryId$purchases_defaultsRelease() {
        return this.inAppMessageCategoryId;
    }
}
