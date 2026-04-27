package com.revenuecat.purchases.common.networking;

import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class PostReceiptProductInfo {
    private final Boolean shouldConsume;

    public PostReceiptProductInfo(Boolean bool) {
        this.shouldConsume = bool;
    }

    public static /* synthetic */ PostReceiptProductInfo copy$default(PostReceiptProductInfo postReceiptProductInfo, Boolean bool, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            bool = postReceiptProductInfo.shouldConsume;
        }
        return postReceiptProductInfo.copy(bool);
    }

    public final Boolean component1() {
        return this.shouldConsume;
    }

    public final PostReceiptProductInfo copy(Boolean bool) {
        return new PostReceiptProductInfo(bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PostReceiptProductInfo) && r.b(this.shouldConsume, ((PostReceiptProductInfo) obj).shouldConsume);
    }

    public final Boolean getShouldConsume() {
        return this.shouldConsume;
    }

    public int hashCode() {
        Boolean bool = this.shouldConsume;
        if (bool == null) {
            return 0;
        }
        return bool.hashCode();
    }

    public String toString() {
        return "PostReceiptProductInfo(shouldConsume=" + this.shouldConsume + ')';
    }
}
