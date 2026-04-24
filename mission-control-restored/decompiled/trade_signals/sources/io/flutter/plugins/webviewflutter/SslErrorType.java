package io.flutter.plugins.webviewflutter;

import kotlin.jvm.internal.AbstractC2296k;
import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class SslErrorType {
    private static final /* synthetic */ InterfaceC2874a $ENTRIES;
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
        private Companion() {
        }

        public final SslErrorType ofRaw(int i8) {
            for (SslErrorType sslErrorType : SslErrorType.values()) {
                if (sslErrorType.getRaw() == i8) {
                    return sslErrorType;
                }
            }
            return null;
        }

        public /* synthetic */ Companion(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    private static final /* synthetic */ SslErrorType[] $values() {
        return new SslErrorType[]{DATE_INVALID, EXPIRED, ID_MISMATCH, INVALID, NOT_YET_VALID, UNTRUSTED, UNKNOWN};
    }

    static {
        SslErrorType[] sslErrorTypeArr$values = $values();
        $VALUES = sslErrorTypeArr$values;
        $ENTRIES = AbstractC2875b.a(sslErrorTypeArr$values);
        Companion = new Companion(null);
    }

    private SslErrorType(String str, int i8, int i9) {
        this.raw = i9;
    }

    public static InterfaceC2874a getEntries() {
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
