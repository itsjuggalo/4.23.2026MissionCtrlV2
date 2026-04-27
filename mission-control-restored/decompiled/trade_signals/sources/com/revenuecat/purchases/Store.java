package com.revenuecat.purchases;

import io.flutter.plugins.firebase.database.FlutterFirebaseDatabaseException;
import java.lang.annotation.Annotation;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.AbstractC2306v;
import o5.AbstractC2484l;
import o5.AbstractC2491s;
import o5.C2490r;
import o5.EnumC2486n;
import o5.InterfaceC2483k;
import o7.A;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0087\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/revenuecat/purchases/Store;", "", "(Ljava/lang/String;I)V", "APP_STORE", "MAC_APP_STORE", "PLAY_STORE", "STRIPE", "PROMOTIONAL", "UNKNOWN_STORE", "AMAZON", "RC_BILLING", "EXTERNAL", "PADDLE", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
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


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final InterfaceC2483k $cachedSerializer$delegate = AbstractC2484l.b(EnumC2486n.f21975b, Companion.AnonymousClass1.INSTANCE);

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\tHÆ\u0001¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/revenuecat/purchases/Store$Companion;", "", "<init>", "()V", "", "text", "Lcom/revenuecat/purchases/Store;", "fromString", "(Ljava/lang/String;)Lcom/revenuecat/purchases/Store;", "Lk7/b;", "serializer", "()Lk7/b;", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {

        /* JADX INFO: renamed from: com.revenuecat.purchases.Store$Companion$1, reason: invalid class name */
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class AnonymousClass1 extends AbstractC2306v implements Function0 {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final k7.b invoke() {
                return A.a("com.revenuecat.purchases.Store", Store.values(), new String[]{"app_store", "mac_app_store", "play_store", "stripe", "promotional", FlutterFirebaseDatabaseException.UNKNOWN_ERROR_CODE, "amazon", "rc_billing", "external", "paddle"}, new Annotation[][]{null, null, null, null, null, null, null, null, null, null}, null);
            }
        }

        private Companion() {
        }

        private final /* synthetic */ k7.b get$cachedSerializer() {
            return (k7.b) Store.$cachedSerializer$delegate.getValue();
        }

        public final /* synthetic */ Store fromString(String text) {
            Object objB;
            AbstractC2304t.f(text, "text");
            try {
                C2490r.a aVar = C2490r.f21981b;
                String upperCase = text.toUpperCase(Locale.ROOT);
                AbstractC2304t.e(upperCase, "toUpperCase(...)");
                objB = C2490r.b(Store.valueOf(upperCase));
            } catch (Throwable th) {
                C2490r.a aVar2 = C2490r.f21981b;
                objB = C2490r.b(AbstractC2491s.a(th));
            }
            Store store = Store.UNKNOWN_STORE;
            if (C2490r.g(objB)) {
                objB = store;
            }
            return (Store) objB;
        }

        public final k7.b serializer() {
            return get$cachedSerializer();
        }

        public /* synthetic */ Companion(AbstractC2296k abstractC2296k) {
            this();
        }
    }
}
