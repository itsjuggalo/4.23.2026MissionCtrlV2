package com.revenuecat.purchases.paywalls.components;

import F3.b;
import J3.Y;
import W2.j;
import W2.k;
import W2.l;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import java.lang.annotation.Annotation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes3.dex */
@InternalRevenueCatAPI
public final class TabControlComponent implements PaywallComponent {
    public static final TabControlComponent INSTANCE = new TabControlComponent();
    private static final /* synthetic */ j $cachedSerializer$delegate = k.a(l.f5481b, AnonymousClass1.INSTANCE);

    /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.TabControlComponent$1, reason: invalid class name */
    public static final class AnonymousClass1 extends s implements Function0 {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final b invoke() {
            return new Y("tab_control", TabControlComponent.INSTANCE, new Annotation[0]);
        }
    }

    private TabControlComponent() {
    }

    private final /* synthetic */ b get$cachedSerializer() {
        return (b) $cachedSerializer$delegate.getValue();
    }

    public final b serializer() {
        return get$cachedSerializer();
    }
}
