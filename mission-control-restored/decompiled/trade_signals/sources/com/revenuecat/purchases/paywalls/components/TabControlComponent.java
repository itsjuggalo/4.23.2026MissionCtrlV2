package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.InternalRevenueCatAPI;
import java.lang.annotation.Annotation;
import k7.b;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2306v;
import o5.AbstractC2484l;
import o5.EnumC2486n;
import o5.InterfaceC2483k;
import o7.C2498c0;

/* JADX INFO: loaded from: classes.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004HÆ\u0001¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/TabControlComponent;", "Lcom/revenuecat/purchases/paywalls/components/PaywallComponent;", "<init>", "()V", "Lk7/b;", "serializer", "()Lk7/b;", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
public final class TabControlComponent implements PaywallComponent {
    public static final TabControlComponent INSTANCE = new TabControlComponent();
    private static final /* synthetic */ InterfaceC2483k $cachedSerializer$delegate = AbstractC2484l.b(EnumC2486n.f21975b, AnonymousClass1.INSTANCE);

    /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.TabControlComponent$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass1 extends AbstractC2306v implements Function0 {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final b invoke() {
            return new C2498c0("tab_control", TabControlComponent.INSTANCE, new Annotation[0]);
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
