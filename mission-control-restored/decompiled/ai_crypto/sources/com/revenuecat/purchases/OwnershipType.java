package com.revenuecat.purchases;

import E5.j;
import E5.k;
import E5.l;
import java.lang.annotation.Annotation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.s;
import r6.AbstractC2637y;

/* JADX INFO: loaded from: classes.dex */
public enum OwnershipType {
    PURCHASED,
    FAMILY_SHARED,
    UNKNOWN;

    public static final Companion Companion = new Companion(null);
    private static final j $cachedSerializer$delegate = k.a(l.f1675b, Companion.AnonymousClass1.INSTANCE);

    public static final class Companion {

        /* JADX INFO: renamed from: com.revenuecat.purchases.OwnershipType$Companion$1, reason: invalid class name */
        public static final class AnonymousClass1 extends s implements Function0 {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final n6.b invoke() {
                return AbstractC2637y.a("com.revenuecat.purchases.OwnershipType", OwnershipType.values(), new String[]{"PURCHASED", "FAMILY_SHARED", "UNKNOWN"}, new Annotation[][]{null, null, null}, null);
            }
        }

        public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
            this();
        }

        private final /* synthetic */ n6.b get$cachedSerializer() {
            return (n6.b) OwnershipType.$cachedSerializer$delegate.getValue();
        }

        public final n6.b serializer() {
            return get$cachedSerializer();
        }

        private Companion() {
        }
    }
}
