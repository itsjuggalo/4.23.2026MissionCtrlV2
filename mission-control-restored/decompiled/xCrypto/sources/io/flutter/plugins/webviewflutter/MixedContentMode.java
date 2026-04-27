package io.flutter.plugins.webviewflutter;

import c3.AbstractC0878b;
import c3.InterfaceC0877a;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes3.dex */
public final class MixedContentMode {
    private static final /* synthetic */ InterfaceC0877a $ENTRIES;
    private static final /* synthetic */ MixedContentMode[] $VALUES;
    public static final Companion Companion;
    private final int raw;
    public static final MixedContentMode ALWAYS_ALLOW = new MixedContentMode("ALWAYS_ALLOW", 0, 0);
    public static final MixedContentMode COMPATIBILITY_MODE = new MixedContentMode("COMPATIBILITY_MODE", 1, 1);
    public static final MixedContentMode NEVER_ALLOW = new MixedContentMode("NEVER_ALLOW", 2, 2);

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final MixedContentMode ofRaw(int i4) {
            for (MixedContentMode mixedContentMode : MixedContentMode.values()) {
                if (mixedContentMode.getRaw() == i4) {
                    return mixedContentMode;
                }
            }
            return null;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ MixedContentMode[] $values() {
        return new MixedContentMode[]{ALWAYS_ALLOW, COMPATIBILITY_MODE, NEVER_ALLOW};
    }

    static {
        MixedContentMode[] mixedContentModeArr$values = $values();
        $VALUES = mixedContentModeArr$values;
        $ENTRIES = AbstractC0878b.a(mixedContentModeArr$values);
        Companion = new Companion(null);
    }

    private MixedContentMode(String str, int i4, int i5) {
        this.raw = i5;
    }

    public static InterfaceC0877a getEntries() {
        return $ENTRIES;
    }

    public static MixedContentMode valueOf(String str) {
        return (MixedContentMode) Enum.valueOf(MixedContentMode.class, str);
    }

    public static MixedContentMode[] values() {
        return (MixedContentMode[]) $VALUES.clone();
    }

    public final int getRaw() {
        return this.raw;
    }
}
