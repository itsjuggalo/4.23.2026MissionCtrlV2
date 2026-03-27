package com.revenuecat.purchases.paywalls.components.common;

import F3.b;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
@InternalRevenueCatAPI
public final class LocaleId {
    public static final Companion Companion = new Companion(null);
    private final String value;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final b serializer() {
            return LocaleId$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    private /* synthetic */ LocaleId(String str) {
        this.value = str;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ LocaleId m166boximpl(String str) {
        return new LocaleId(str);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static String m167constructorimpl(String value) {
        r.f(value, "value");
        return value;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m168equalsimpl(String str, Object obj) {
        return (obj instanceof LocaleId) && r.b(str, ((LocaleId) obj).m172unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m169equalsimpl0(String str, String str2) {
        return r.b(str, str2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m170hashCodeimpl(String str) {
        return str.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m171toStringimpl(String str) {
        return "LocaleId(value=" + str + ')';
    }

    public boolean equals(Object obj) {
        return m168equalsimpl(this.value, obj);
    }

    public final /* synthetic */ String getValue() {
        return this.value;
    }

    public int hashCode() {
        return m170hashCodeimpl(this.value);
    }

    public String toString() {
        return m171toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ String m172unboximpl() {
        return this.value;
    }
}
