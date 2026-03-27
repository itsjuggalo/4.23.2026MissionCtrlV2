package com.revenuecat.purchases;

import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class FontAlias {
    public static final Companion Companion = new Companion(null);
    private final String value;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final F3.b serializer() {
            return FontAlias$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    private /* synthetic */ FontAlias(String str) {
        this.value = str;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ FontAlias m60boximpl(String str) {
        return new FontAlias(str);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static String m61constructorimpl(String value) {
        r.f(value, "value");
        return value;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m62equalsimpl(String str, Object obj) {
        return (obj instanceof FontAlias) && r.b(str, ((FontAlias) obj).m66unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m63equalsimpl0(String str, String str2) {
        return r.b(str, str2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m64hashCodeimpl(String str) {
        return str.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m65toStringimpl(String str) {
        return "FontAlias(value=" + str + ')';
    }

    public boolean equals(Object obj) {
        return m62equalsimpl(this.value, obj);
    }

    public final /* synthetic */ String getValue() {
        return this.value;
    }

    public int hashCode() {
        return m64hashCodeimpl(this.value);
    }

    public String toString() {
        return m65toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ String m66unboximpl() {
        return this.value;
    }
}
