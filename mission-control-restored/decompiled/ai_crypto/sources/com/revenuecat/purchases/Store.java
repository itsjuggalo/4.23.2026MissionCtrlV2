package com.revenuecat.purchases;

import E5.j;
import E5.k;
import E5.l;
import E5.p;
import E5.q;
import java.lang.annotation.Annotation;
import java.util.Locale;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import r6.AbstractC2637y;

/* JADX INFO: loaded from: classes.dex */
public enum Store {
    APP_STORE,
    MAC_APP_STORE,
    PLAY_STORE,
    STRIPE,
    PROMOTIONAL,
    UNKNOWN_STORE,
    AMAZON,
    RC_BILLING,
    EXTERNAL,
    PADDLE;

    public static final Companion Companion = new Companion(null);
    private static final j $cachedSerializer$delegate = k.a(l.f1675b, Companion.AnonymousClass1.INSTANCE);

    public static final class Companion {

        /* JADX INFO: renamed from: com.revenuecat.purchases.Store$Companion$1, reason: invalid class name */
        public static final class AnonymousClass1 extends s implements Function0 {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final n6.b invoke() {
                return AbstractC2637y.a("com.revenuecat.purchases.Store", Store.values(), new String[]{"app_store", "mac_app_store", "play_store", "stripe", "promotional", "unknown", "amazon", "rc_billing", "external", "paddle"}, new Annotation[][]{null, null, null, null, null, null, null, null, null, null}, null);
            }
        }

        public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
            this();
        }

        private final /* synthetic */ n6.b get$cachedSerializer() {
            return (n6.b) Store.$cachedSerializer$delegate.getValue();
        }

        public final /* synthetic */ Store fromString(String text) {
            Object objB;
            r.f(text, "text");
            try {
                p.a aVar = p.f1681b;
                String upperCase = text.toUpperCase(Locale.ROOT);
                r.e(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                objB = p.b(Store.valueOf(upperCase));
            } catch (Throwable th) {
                p.a aVar2 = p.f1681b;
                objB = p.b(q.a(th));
            }
            Store store = Store.UNKNOWN_STORE;
            if (p.g(objB)) {
                objB = store;
            }
            return (Store) objB;
        }

        public final n6.b serializer() {
            return get$cachedSerializer();
        }

        private Companion() {
        }
    }
}
