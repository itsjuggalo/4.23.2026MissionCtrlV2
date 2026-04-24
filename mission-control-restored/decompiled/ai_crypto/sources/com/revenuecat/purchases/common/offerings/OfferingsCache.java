package com.revenuecat.purchases.common.offerings;

import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.DefaultLocaleProvider;
import com.revenuecat.purchases.common.LocaleProvider;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.caching.InMemoryCachedObject;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class OfferingsCache {
    private String cachedLanguageTags;
    private final DateProvider dateProvider;
    private final DeviceCache deviceCache;
    private final LocaleProvider localeProvider;
    private final InMemoryCachedObject<Offerings> offeringsCachedObject;

    public OfferingsCache(DeviceCache deviceCache, DateProvider dateProvider, InMemoryCachedObject<Offerings> offeringsCachedObject, LocaleProvider localeProvider) {
        r.f(deviceCache, "deviceCache");
        r.f(dateProvider, "dateProvider");
        r.f(offeringsCachedObject, "offeringsCachedObject");
        r.f(localeProvider, "localeProvider");
        this.deviceCache = deviceCache;
        this.dateProvider = dateProvider;
        this.offeringsCachedObject = offeringsCachedObject;
        this.localeProvider = localeProvider;
    }

    public final synchronized void cacheOfferings(Offerings offerings, JSONObject offeringsResponse) {
        r.f(offerings, "offerings");
        r.f(offeringsResponse, "offeringsResponse");
        this.offeringsCachedObject.cacheInstance(offerings);
        this.deviceCache.cacheOfferingsResponse(offeringsResponse);
        this.offeringsCachedObject.updateCacheTimestamp(this.dateProvider.getNow());
        char[] charArray = this.localeProvider.getCurrentLocalesLanguageTags().toCharArray();
        r.e(charArray, "this as java.lang.String).toCharArray()");
        this.cachedLanguageTags = new String(charArray);
    }

    public final synchronized void clearCache() {
        this.offeringsCachedObject.clearCache();
        this.deviceCache.clearOfferingsResponseCache();
        this.cachedLanguageTags = null;
    }

    public final synchronized void forceCacheStale() {
        this.offeringsCachedObject.clearCacheTimestamp();
        this.cachedLanguageTags = null;
    }

    public final synchronized Offerings getCachedOfferings() {
        return this.offeringsCachedObject.getCachedInstance();
    }

    public final synchronized JSONObject getCachedOfferingsResponse() {
        return this.deviceCache.getOfferingsResponseCache();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized boolean isOfferingsCacheStale(boolean r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            com.revenuecat.purchases.common.caching.InMemoryCachedObject<com.revenuecat.purchases.Offerings> r0 = r2.offeringsCachedObject     // Catch: java.lang.Throwable -> L20
            java.util.Date r0 = r0.getLastUpdatedAt$purchases_defaultsRelease()     // Catch: java.lang.Throwable -> L20
            com.revenuecat.purchases.common.DateProvider r1 = r2.dateProvider     // Catch: java.lang.Throwable -> L20
            boolean r3 = com.revenuecat.purchases.common.caching.DateExtensionsKt.isCacheStale(r0, r3, r1)     // Catch: java.lang.Throwable -> L20
            if (r3 != 0) goto L22
            java.lang.String r3 = r2.cachedLanguageTags     // Catch: java.lang.Throwable -> L20
            com.revenuecat.purchases.common.LocaleProvider r0 = r2.localeProvider     // Catch: java.lang.Throwable -> L20
            java.lang.String r0 = r0.getCurrentLocalesLanguageTags()     // Catch: java.lang.Throwable -> L20
            boolean r3 = kotlin.jvm.internal.r.b(r3, r0)     // Catch: java.lang.Throwable -> L20
            if (r3 != 0) goto L1e
            goto L22
        L1e:
            r3 = 0
            goto L23
        L20:
            r3 = move-exception
            goto L25
        L22:
            r3 = 1
        L23:
            monitor-exit(r2)
            return r3
        L25:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.offerings.OfferingsCache.isOfferingsCacheStale(boolean):boolean");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ OfferingsCache(DeviceCache deviceCache, DateProvider dateProvider, InMemoryCachedObject inMemoryCachedObject, LocaleProvider localeProvider, int i7, AbstractC2148j abstractC2148j) {
        dateProvider = (i7 & 2) != 0 ? new DefaultDateProvider() : dateProvider;
        this(deviceCache, dateProvider, (i7 & 4) != 0 ? new InMemoryCachedObject(null, dateProvider, 1, null) : inMemoryCachedObject, (i7 & 8) != 0 ? new DefaultLocaleProvider() : localeProvider);
    }
}
