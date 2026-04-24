package com.revenuecat.purchases.paywalls.components;

import F3.b;
import J3.AbstractC0325a0;
import J3.k0;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
@InternalRevenueCatAPI
public final class StickyFooterComponent implements PaywallComponent {
    public static final Companion Companion = new Companion(null);
    private final StackComponent stack;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final b serializer() {
            return StickyFooterComponent$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ StickyFooterComponent(int i4, StackComponent stackComponent, k0 k0Var) {
        if (1 != (i4 & 1)) {
            AbstractC0325a0.a(i4, 1, StickyFooterComponent$$serializer.INSTANCE.getDescriptor());
        }
        this.stack = stackComponent;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StickyFooterComponent) && r.b(this.stack, ((StickyFooterComponent) obj).stack);
    }

    public final /* synthetic */ StackComponent getStack() {
        return this.stack;
    }

    public int hashCode() {
        return this.stack.hashCode();
    }

    public String toString() {
        return "StickyFooterComponent(stack=" + this.stack + ')';
    }

    public StickyFooterComponent(StackComponent stack) {
        r.f(stack, "stack");
        this.stack = stack;
    }
}
