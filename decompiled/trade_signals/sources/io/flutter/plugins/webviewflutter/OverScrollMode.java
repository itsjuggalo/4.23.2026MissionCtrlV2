package io.flutter.plugins.webviewflutter;

import kotlin.jvm.internal.AbstractC2296k;
import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class OverScrollMode {
    private static final /* synthetic */ InterfaceC2874a $ENTRIES;
    private static final /* synthetic */ OverScrollMode[] $VALUES;
    public static final Companion Companion;
    private final int raw;
    public static final OverScrollMode ALWAYS = new OverScrollMode("ALWAYS", 0, 0);
    public static final OverScrollMode IF_CONTENT_SCROLLS = new OverScrollMode("IF_CONTENT_SCROLLS", 1, 1);
    public static final OverScrollMode NEVER = new OverScrollMode("NEVER", 2, 2);
    public static final OverScrollMode UNKNOWN = new OverScrollMode("UNKNOWN", 3, 3);

    public static final class Companion {
        private Companion() {
        }

        public final OverScrollMode ofRaw(int i8) {
            for (OverScrollMode overScrollMode : OverScrollMode.values()) {
                if (overScrollMode.getRaw() == i8) {
                    return overScrollMode;
                }
            }
            return null;
        }

        public /* synthetic */ Companion(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    private static final /* synthetic */ OverScrollMode[] $values() {
        return new OverScrollMode[]{ALWAYS, IF_CONTENT_SCROLLS, NEVER, UNKNOWN};
    }

    static {
        OverScrollMode[] overScrollModeArr$values = $values();
        $VALUES = overScrollModeArr$values;
        $ENTRIES = AbstractC2875b.a(overScrollModeArr$values);
        Companion = new Companion(null);
    }

    private OverScrollMode(String str, int i8, int i9) {
        this.raw = i9;
    }

    public static InterfaceC2874a getEntries() {
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
