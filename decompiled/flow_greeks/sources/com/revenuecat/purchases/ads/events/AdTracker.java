package com.revenuecat.purchases.ads.events;

import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.ads.events.AdEvent;
import com.revenuecat.purchases.ads.events.types.AdDisplayedData;
import com.revenuecat.purchases.ads.events.types.AdFailedToLoadData;
import com.revenuecat.purchases.ads.events.types.AdLoadedData;
import com.revenuecat.purchases.ads.events.types.AdOpenedData;
import com.revenuecat.purchases.ads.events.types.AdRevenueData;
import com.revenuecat.purchases.common.events.EventsManager;
import kotlin.Metadata;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/revenuecat/purchases/ads/events/AdTracker;", "", "Lcom/revenuecat/purchases/common/events/EventsManager;", "eventsManager", "<init>", "(Lcom/revenuecat/purchases/common/events/EventsManager;)V", "Lcom/revenuecat/purchases/ads/events/types/AdDisplayedData;", "data", "Lcd/h0;", "trackAdDisplayed", "(Lcom/revenuecat/purchases/ads/events/types/AdDisplayedData;)V", "Lcom/revenuecat/purchases/ads/events/types/AdOpenedData;", "trackAdOpened", "(Lcom/revenuecat/purchases/ads/events/types/AdOpenedData;)V", "Lcom/revenuecat/purchases/ads/events/types/AdRevenueData;", "trackAdRevenue", "(Lcom/revenuecat/purchases/ads/events/types/AdRevenueData;)V", "Lcom/revenuecat/purchases/ads/events/types/AdLoadedData;", "trackAdLoaded", "(Lcom/revenuecat/purchases/ads/events/types/AdLoadedData;)V", "Lcom/revenuecat/purchases/ads/events/types/AdFailedToLoadData;", "trackAdFailedToLoad", "(Lcom/revenuecat/purchases/ads/events/types/AdFailedToLoadData;)V", "Lcom/revenuecat/purchases/common/events/EventsManager;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AdTracker {
    private final EventsManager eventsManager;

    public AdTracker(EventsManager eventsManager) {
        t.f(eventsManager, "eventsManager");
        this.eventsManager = eventsManager;
    }

    public final void trackAdDisplayed(AdDisplayedData data) {
        t.f(data, "data");
        this.eventsManager.track(new AdEvent.Displayed(null, 0, null, 0L, data.getNetworkName(), data.getMediatorName(), data.getPlacement(), data.getAdUnitId(), data.getImpressionId(), 15, null));
    }

    public final void trackAdFailedToLoad(AdFailedToLoadData data) {
        t.f(data, "data");
        this.eventsManager.track(new AdEvent.FailedToLoad(null, 0, null, 0L, data.getNetworkName(), data.getMediatorName(), data.getPlacement(), data.getAdUnitId(), null, data.getMediatorErrorCode(), 15, null));
    }

    public final void trackAdLoaded(AdLoadedData data) {
        t.f(data, "data");
        this.eventsManager.track(new AdEvent.Loaded(null, 0, null, 0L, data.getNetworkName(), data.getMediatorName(), data.getPlacement(), data.getAdUnitId(), data.getImpressionId(), 15, null));
    }

    public final void trackAdOpened(AdOpenedData data) {
        t.f(data, "data");
        this.eventsManager.track(new AdEvent.Open(null, 0, null, 0L, data.getNetworkName(), data.getMediatorName(), data.getPlacement(), data.getAdUnitId(), data.getImpressionId(), 15, null));
    }

    public final void trackAdRevenue(AdRevenueData data) {
        t.f(data, "data");
        this.eventsManager.track(new AdEvent.Revenue(null, 0, null, 0L, data.getNetworkName(), data.getMediatorName(), data.getPlacement(), data.getAdUnitId(), data.getImpressionId(), data.getRevenueMicros(), data.getCurrency(), data.getPrecision(), 15, null));
    }
}
