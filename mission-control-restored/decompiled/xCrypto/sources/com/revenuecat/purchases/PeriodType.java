package com.revenuecat.purchases;

import J3.AbstractC0351y;
import W2.j;
import W2.k;
import W2.l;
import java.lang.annotation.Annotation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public enum PeriodType {
    NORMAL,
    INTRO,
    TRIAL,
    PREPAID;

    public static final Companion Companion = new Companion(null);
    private static final j $cachedSerializer$delegate = k.a(l.f5481b, Companion.AnonymousClass1.INSTANCE);

    public static final class Companion {

        /* JADX INFO: renamed from: com.revenuecat.purchases.PeriodType$Companion$1, reason: invalid class name */
        public static final class AnonymousClass1 extends s implements Function0 {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final F3.b invoke() {
                return AbstractC0351y.a("com.revenuecat.purchases.PeriodType", PeriodType.values(), new String[]{"normal", "intro", "trial", "prepaid"}, new Annotation[][]{null, null, null, null}, null);
            }
        }

        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        private final /* synthetic */ F3.b get$cachedSerializer() {
            return (F3.b) PeriodType.$cachedSerializer$delegate.getValue();
        }

        public final F3.b serializer() {
            return get$cachedSerializer();
        }

        private Companion() {
        }
    }
}
