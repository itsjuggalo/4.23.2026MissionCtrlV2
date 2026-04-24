package com.revenuecat.purchases.paywalls.components.common;

import com.revenuecat.purchases.InternalRevenueCatAPI;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;
import n6.b;

/* JADX INFO: loaded from: classes2.dex */
@InternalRevenueCatAPI
public final class LocalizationKey {
    public static final Companion Companion = new Companion(null);
    private final String value;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
            this();
        }

        public final b serializer() {
            return LocalizationKey$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    private /* synthetic */ LocalizationKey(String str) {
        this.value = str;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ LocalizationKey m160boximpl(String str) {
        return new LocalizationKey(str);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static String m161constructorimpl(String value) {
        r.f(value, "value");
        return value;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m162equalsimpl(String str, Object obj) {
        return (obj instanceof LocalizationKey) && r.b(str, ((LocalizationKey) obj).m166unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m163equalsimpl0(String str, String str2) {
        return r.b(str, str2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m164hashCodeimpl(String str) {
        return str.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m165toStringimpl(String str) {
        return "LocalizationKey(value=" + str + ')';
    }

    public boolean equals(Object obj) {
        return m162equalsimpl(this.value, obj);
    }

    public final /* synthetic */ String getValue() {
        return this.value;
    }

    public int hashCode() {
        return m164hashCodeimpl(this.value);
    }

    public String toString() {
        return m165toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ String m166unboximpl() {
        return this.value;
    }
}
