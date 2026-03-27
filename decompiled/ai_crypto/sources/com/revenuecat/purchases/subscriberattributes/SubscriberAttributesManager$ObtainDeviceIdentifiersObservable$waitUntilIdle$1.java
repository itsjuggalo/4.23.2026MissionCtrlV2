package com.revenuecat.purchases.subscriberattributes;

import E5.E;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes2.dex */
public final class SubscriberAttributesManager$ObtainDeviceIdentifiersObservable$waitUntilIdle$1 extends s implements Function0 {
    final /* synthetic */ Function0 $completion;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubscriberAttributesManager$ObtainDeviceIdentifiersObservable$waitUntilIdle$1(Function0 function0) {
        super(0);
        this.$completion = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object invoke() {
        m175invoke();
        return E.f1657a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m175invoke() {
        this.$completion.invoke();
    }
}
