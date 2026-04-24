package com.revenuecat.purchases.paywalls.components.common;

import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.StackComponent$$serializer;
import com.revenuecat.purchases.paywalls.components.StickyFooterComponent;
import com.revenuecat.purchases.paywalls.components.StickyFooterComponent$$serializer;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;
import n6.b;
import p6.e;
import q6.d;
import r6.AbstractC2611a0;
import r6.k0;

/* JADX INFO: loaded from: classes2.dex */
@InternalRevenueCatAPI
public final class PaywallComponentsConfig {
    public static final Companion Companion = new Companion(null);
    private final Background background;
    private final StackComponent stack;
    private final StickyFooterComponent stickyFooter;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
            this();
        }

        public final b serializer() {
            return PaywallComponentsConfig$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ PaywallComponentsConfig(int i7, StackComponent stackComponent, Background background, StickyFooterComponent stickyFooterComponent, k0 k0Var) {
        if (3 != (i7 & 3)) {
            AbstractC2611a0.a(i7, 3, PaywallComponentsConfig$$serializer.INSTANCE.getDescriptor());
        }
        this.stack = stackComponent;
        this.background = background;
        if ((i7 & 4) == 0) {
            this.stickyFooter = null;
        } else {
            this.stickyFooter = stickyFooterComponent;
        }
    }

    public static /* synthetic */ void getStickyFooter$annotations() {
    }

    public static final /* synthetic */ void write$Self(PaywallComponentsConfig paywallComponentsConfig, d dVar, e eVar) {
        dVar.x(eVar, 0, StackComponent$$serializer.INSTANCE, paywallComponentsConfig.stack);
        dVar.x(eVar, 1, BackgroundDeserializer.INSTANCE, paywallComponentsConfig.background);
        if (!dVar.C(eVar, 2) && paywallComponentsConfig.stickyFooter == null) {
            return;
        }
        dVar.r(eVar, 2, StickyFooterComponent$$serializer.INSTANCE, paywallComponentsConfig.stickyFooter);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallComponentsConfig)) {
            return false;
        }
        PaywallComponentsConfig paywallComponentsConfig = (PaywallComponentsConfig) obj;
        return r.b(this.stack, paywallComponentsConfig.stack) && r.b(this.background, paywallComponentsConfig.background) && r.b(this.stickyFooter, paywallComponentsConfig.stickyFooter);
    }

    public final /* synthetic */ Background getBackground() {
        return this.background;
    }

    public final /* synthetic */ StackComponent getStack() {
        return this.stack;
    }

    public final /* synthetic */ StickyFooterComponent getStickyFooter() {
        return this.stickyFooter;
    }

    public int hashCode() {
        int iHashCode = ((this.stack.hashCode() * 31) + this.background.hashCode()) * 31;
        StickyFooterComponent stickyFooterComponent = this.stickyFooter;
        return iHashCode + (stickyFooterComponent == null ? 0 : stickyFooterComponent.hashCode());
    }

    public String toString() {
        return "PaywallComponentsConfig(stack=" + this.stack + ", background=" + this.background + ", stickyFooter=" + this.stickyFooter + ')';
    }

    public PaywallComponentsConfig(StackComponent stack, Background background, StickyFooterComponent stickyFooterComponent) {
        r.f(stack, "stack");
        r.f(background, "background");
        this.stack = stack;
        this.background = background;
        this.stickyFooter = stickyFooterComponent;
    }

    public /* synthetic */ PaywallComponentsConfig(StackComponent stackComponent, Background background, StickyFooterComponent stickyFooterComponent, int i7, AbstractC2148j abstractC2148j) {
        this(stackComponent, background, (i7 & 4) != 0 ? null : stickyFooterComponent);
    }
}
