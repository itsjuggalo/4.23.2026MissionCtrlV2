package com.revenuecat.purchases.customercenter.events;

import F3.b;
import J3.AbstractC0351y;
import W2.j;
import W2.k;
import W2.l;
import java.lang.annotation.Annotation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public enum CustomerCenterDisplayMode {
    FULL_SCREEN;

    public static final Companion Companion = new Companion(null);
    private static final j $cachedSerializer$delegate = k.a(l.f5481b, Companion.AnonymousClass1.INSTANCE);

    public static final class Companion {

        /* JADX INFO: renamed from: com.revenuecat.purchases.customercenter.events.CustomerCenterDisplayMode$Companion$1, reason: invalid class name */
        public static final class AnonymousClass1 extends s implements Function0 {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return AbstractC0351y.a("com.revenuecat.purchases.customercenter.events.CustomerCenterDisplayMode", CustomerCenterDisplayMode.values(), new String[]{"full_screen"}, new Annotation[][]{null}, null);
            }
        }

        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        private final /* synthetic */ b get$cachedSerializer() {
            return (b) CustomerCenterDisplayMode.$cachedSerializer$delegate.getValue();
        }

        public final b serializer() {
            return get$cachedSerializer();
        }

        private Companion() {
        }
    }
}
