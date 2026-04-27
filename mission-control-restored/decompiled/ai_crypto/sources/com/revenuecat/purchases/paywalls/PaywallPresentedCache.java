package com.revenuecat.purchases.paywalls;

import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.paywalls.events.PaywallEvent;
import com.revenuecat.purchases.paywalls.events.PaywallEventType;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class PaywallPresentedCache {
    private PaywallEvent lastPaywallImpressionEvent;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PaywallEventType.values().length];
            try {
                iArr[PaywallEventType.IMPRESSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PaywallEventType.CLOSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final synchronized void cachePresentedPaywall(PaywallEvent paywallEvent) {
        r.f(paywallEvent, "paywallEvent");
        this.lastPaywallImpressionEvent = paywallEvent;
    }

    public final synchronized PaywallEvent getAndRemovePresentedEvent() {
        PaywallEvent paywallEvent;
        paywallEvent = this.lastPaywallImpressionEvent;
        this.lastPaywallImpressionEvent = null;
        return paywallEvent;
    }

    public final synchronized void receiveEvent(PaywallEvent event) {
        try {
            r.f(event, "event");
            int i7 = WhenMappings.$EnumSwitchMapping$0[event.getType().ordinal()];
            if (i7 == 1) {
                LogUtilsKt.verboseLog("Caching paywall impression event.");
                this.lastPaywallImpressionEvent = event;
            } else if (i7 == 2) {
                LogUtilsKt.verboseLog("Clearing cached paywall impression event.");
                this.lastPaywallImpressionEvent = null;
            }
        } finally {
        }
    }
}
