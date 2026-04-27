package com.revenuecat.purchases.paywalls.components;

import F3.b;
import com.revenuecat.purchases.InternalRevenueCatAPI;

/* JADX INFO: loaded from: classes3.dex */
@InternalRevenueCatAPI
public interface PaywallComponent {
    public static final Companion Companion = Companion.$$INSTANCE;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final b serializer() {
            return new PaywallComponentSerializer();
        }
    }
}
