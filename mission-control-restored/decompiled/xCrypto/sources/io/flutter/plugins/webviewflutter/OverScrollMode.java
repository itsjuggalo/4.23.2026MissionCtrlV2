package io.flutter.plugins.webviewflutter;

import c3.AbstractC0878b;
import c3.InterfaceC0877a;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes3.dex */
public final class OverScrollMode {
    private static final /* synthetic */ InterfaceC0877a $ENTRIES;
    private static final /* synthetic */ OverScrollMode[] $VALUES;
    public static final Companion Companion;
    private final int raw;
    public static final OverScrollMode ALWAYS = new OverScrollMode("ALWAYS", 0, 0);
    public static final OverScrollMode IF_CONTENT_SCROLLS = new OverScrollMode("IF_CONTENT_SCROLLS", 1, 1);
    public static final OverScrollMode NEVER = new OverScrollMode("NEVER", 2, 2);
    public static final OverScrollMode UNKNOWN = new OverScrollMode("UNKNOWN", 3, 3);

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final OverScrollMode ofRaw(int i4) {
            for (OverScrollMode overScrollMode : OverScrollMode.values()) {
                if (overScrollMode.getRaw() == i4) {
                    return overScrollMode;
                }
            }
            return null;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ OverScrollMode[] $values() {
        return new OverScrollMode[]{ALWAYS, IF_CONTENT_SCROLLS, NEVER, UNKNOWN};
    }

    static {
        OverScrollMode[] overScrollModeArr$values = $values();
        $VALUES = overScrollModeArr$values;
        $ENTRIES = AbstractC0878b.a(overScrollModeArr$values);
        Companion = new Companion(null);
    }

    private OverScrollMode(String str, int i4, int i5) {
        this.raw = i5;
    }

    public static InterfaceC0877a getEntries() {
        return $ENTRIES;
    }

    public static OverScrollMode valueOf(String str) {
        return (OverScrollMode) Enum.valueOf(OverScrollMode.class, str);
    }

    public static OverScrollMode[] values() {
        return (OverScrollMode[]) $VALUES.clone();
    }

    public final int getRaw() {
        return this.raw;
    }
}
