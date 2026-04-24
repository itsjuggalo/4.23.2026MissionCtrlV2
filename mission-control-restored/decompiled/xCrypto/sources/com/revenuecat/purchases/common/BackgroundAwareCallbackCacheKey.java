package com.revenuecat.purchases.common;

import java.util.List;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class BackgroundAwareCallbackCacheKey {
    private final boolean appInBackground;
    private final List<String> cacheKey;

    public BackgroundAwareCallbackCacheKey(List<String> cacheKey, boolean z4) {
        r.f(cacheKey, "cacheKey");
        this.cacheKey = cacheKey;
        this.appInBackground = z4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BackgroundAwareCallbackCacheKey copy$default(BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey, List list, boolean z4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            list = backgroundAwareCallbackCacheKey.cacheKey;
        }
        if ((i4 & 2) != 0) {
            z4 = backgroundAwareCallbackCacheKey.appInBackground;
        }
        return backgroundAwareCallbackCacheKey.copy(list, z4);
    }

    public final List<String> component1() {
        return this.cacheKey;
    }

    public final boolean component2() {
        return this.appInBackground;
    }

    public final BackgroundAwareCallbackCacheKey copy(List<String> cacheKey, boolean z4) {
        r.f(cacheKey, "cacheKey");
        return new BackgroundAwareCallbackCacheKey(cacheKey, z4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BackgroundAwareCallbackCacheKey)) {
            return false;
        }
        BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey = (BackgroundAwareCallbackCacheKey) obj;
        return r.b(this.cacheKey, backgroundAwareCallbackCacheKey.cacheKey) && this.appInBackground == backgroundAwareCallbackCacheKey.appInBackground;
    }

    public final boolean getAppInBackground() {
        return this.appInBackground;
    }

    public final List<String> getCacheKey() {
        return this.cacheKey;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        int iHashCode = this.cacheKey.hashCode() * 31;
        boolean z4 = this.appInBackground;
        ?? r12 = z4;
        if (z4) {
            r12 = 1;
        }
        return iHashCode + r12;
    }

    public String toString() {
        return "BackgroundAwareCallbackCacheKey(cacheKey=" + this.cacheKey + ", appInBackground=" + this.appInBackground + ')';
    }
}
