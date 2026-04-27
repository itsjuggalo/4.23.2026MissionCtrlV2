package io.flutter.plugins.webviewflutter;

import c3.AbstractC0878b;
import c3.InterfaceC0877a;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes3.dex */
public final class SslErrorType {
    private static final /* synthetic */ InterfaceC0877a $ENTRIES;
    private static final /* synthetic */ SslErrorType[] $VALUES;
    public static final Companion Companion;
    private final int raw;
    public static final SslErrorType DATE_INVALID = new SslErrorType("DATE_INVALID", 0, 0);
    public static final SslErrorType EXPIRED = new SslErrorType("EXPIRED", 1, 1);
    public static final SslErrorType ID_MISMATCH = new SslErrorType("ID_MISMATCH", 2, 2);
    public static final SslErrorType INVALID = new SslErrorType("INVALID", 3, 3);
    public static final SslErrorType NOT_YET_VALID = new SslErrorType("NOT_YET_VALID", 4, 4);
    public static final SslErrorType UNTRUSTED = new SslErrorType("UNTRUSTED", 5, 5);
    public static final SslErrorType UNKNOWN = new SslErrorType("UNKNOWN", 6, 6);

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final SslErrorType ofRaw(int i4) {
            for (SslErrorType sslErrorType : SslErrorType.values()) {
                if (sslErrorType.getRaw() == i4) {
                    return sslErrorType;
                }
            }
            return null;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ SslErrorType[] $values() {
        return new SslErrorType[]{DATE_INVALID, EXPIRED, ID_MISMATCH, INVALID, NOT_YET_VALID, UNTRUSTED, UNKNOWN};
    }

    static {
        SslErrorType[] sslErrorTypeArr$values = $values();
        $VALUES = sslErrorTypeArr$values;
        $ENTRIES = AbstractC0878b.a(sslErrorTypeArr$values);
        Companion = new Companion(null);
    }

    private SslErrorType(String str, int i4, int i5) {
        this.raw = i5;
    }

    public static InterfaceC0877a getEntries() {
        return $ENTRIES;
    }

    public static SslErrorType valueOf(String str) {
        return (SslErrorType) Enum.valueOf(SslErrorType.class, str);
    }

    public static SslErrorType[] values() {
        return (SslErrorType[]) $VALUES.clone();
    }

    public final int getRaw() {
        return this.raw;
    }
}
