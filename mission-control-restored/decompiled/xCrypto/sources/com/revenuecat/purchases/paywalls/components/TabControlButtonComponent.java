package com.revenuecat.purchases.paywalls.components;

import F3.b;
import H3.e;
import I3.d;
import J3.AbstractC0325a0;
import J3.k0;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
@InternalRevenueCatAPI
public final class TabControlButtonComponent implements PaywallComponent {
    public static final Companion Companion = new Companion(null);
    private final StackComponent stack;
    private final int tabIndex;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final b serializer() {
            return TabControlButtonComponent$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ TabControlButtonComponent(int i4, int i5, StackComponent stackComponent, k0 k0Var) {
        if (3 != (i4 & 3)) {
            AbstractC0325a0.a(i4, 3, TabControlButtonComponent$$serializer.INSTANCE.getDescriptor());
        }
        this.tabIndex = i5;
        this.stack = stackComponent;
    }

    public static /* synthetic */ void getTabIndex$annotations() {
    }

    public static final /* synthetic */ void write$Self(TabControlButtonComponent tabControlButtonComponent, d dVar, e eVar) {
        dVar.k(eVar, 0, tabControlButtonComponent.tabIndex);
        dVar.u(eVar, 1, StackComponent$$serializer.INSTANCE, tabControlButtonComponent.stack);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TabControlButtonComponent)) {
            return false;
        }
        TabControlButtonComponent tabControlButtonComponent = (TabControlButtonComponent) obj;
        return this.tabIndex == tabControlButtonComponent.tabIndex && r.b(this.stack, tabControlButtonComponent.stack);
    }

    public final /* synthetic */ StackComponent getStack() {
        return this.stack;
    }

    public final /* synthetic */ int getTabIndex() {
        return this.tabIndex;
    }

    public int hashCode() {
        return (Integer.hashCode(this.tabIndex) * 31) + this.stack.hashCode();
    }

    public String toString() {
        return "TabControlButtonComponent(tabIndex=" + this.tabIndex + ", stack=" + this.stack + ')';
    }

    public TabControlButtonComponent(int i4, StackComponent stack) {
        r.f(stack, "stack");
        this.tabIndex = i4;
        this.stack = stack;
    }
}
