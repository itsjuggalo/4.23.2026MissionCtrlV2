package com.revenuecat.purchases.paywalls.components;

import E5.j;
import E5.k;
import E5.l;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.s;
import n6.b;

/* JADX INFO: loaded from: classes2.dex */
enum DestinationSurrogate {
    customer_center,
    privacy_policy,
    terms,
    url,
    sheet,
    unknown;

    public static final Companion Companion = new Companion(null);
    private static final j $cachedSerializer$delegate = k.a(l.f1675b, Companion.AnonymousClass1.INSTANCE);

    public static final class Companion {

        /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.DestinationSurrogate$Companion$1, reason: invalid class name */
        public static final class AnonymousClass1 extends s implements Function0 {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return DestinationSurrogateDeserializer.INSTANCE;
            }
        }

        public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
            this();
        }

        private final /* synthetic */ b get$cachedSerializer() {
            return (b) DestinationSurrogate.$cachedSerializer$delegate.getValue();
        }

        public final b serializer() {
            return get$cachedSerializer();
        }

        private Companion() {
        }
    }
}
