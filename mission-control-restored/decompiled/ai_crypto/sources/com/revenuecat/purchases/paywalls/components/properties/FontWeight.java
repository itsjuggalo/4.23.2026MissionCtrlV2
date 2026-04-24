package com.revenuecat.purchases.paywalls.components.properties;

import E5.j;
import E5.k;
import E5.l;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.s;
import n6.b;

/* JADX INFO: loaded from: classes2.dex */
@InternalRevenueCatAPI
public enum FontWeight {
    EXTRA_LIGHT,
    THIN,
    LIGHT,
    REGULAR,
    MEDIUM,
    SEMI_BOLD,
    BOLD,
    EXTRA_BOLD,
    BLACK;

    public static final Companion Companion = new Companion(null);
    private static final j $cachedSerializer$delegate = k.a(l.f1675b, Companion.AnonymousClass1.INSTANCE);

    public static final class Companion {

        /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.properties.FontWeight$Companion$1, reason: invalid class name */
        public static final class AnonymousClass1 extends s implements Function0 {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return FontWeightDeserializer.INSTANCE;
            }
        }

        public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
            this();
        }

        private final /* synthetic */ b get$cachedSerializer() {
            return (b) FontWeight.$cachedSerializer$delegate.getValue();
        }

        public final b serializer() {
            return get$cachedSerializer();
        }

        private Companion() {
        }
    }
}
