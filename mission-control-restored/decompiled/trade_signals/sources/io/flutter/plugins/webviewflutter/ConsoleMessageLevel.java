package io.flutter.plugins.webviewflutter;

import kotlin.jvm.internal.AbstractC2296k;
import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class ConsoleMessageLevel {
    private static final /* synthetic */ InterfaceC2874a $ENTRIES;
    private static final /* synthetic */ ConsoleMessageLevel[] $VALUES;
    public static final Companion Companion;
    private final int raw;
    public static final ConsoleMessageLevel DEBUG = new ConsoleMessageLevel("DEBUG", 0, 0);
    public static final ConsoleMessageLevel ERROR = new ConsoleMessageLevel("ERROR", 1, 1);
    public static final ConsoleMessageLevel LOG = new ConsoleMessageLevel("LOG", 2, 2);
    public static final ConsoleMessageLevel TIP = new ConsoleMessageLevel("TIP", 3, 3);
    public static final ConsoleMessageLevel WARNING = new ConsoleMessageLevel("WARNING", 4, 4);
    public static final ConsoleMessageLevel UNKNOWN = new ConsoleMessageLevel("UNKNOWN", 5, 5);

    public static final class Companion {
        private Companion() {
        }

        public final ConsoleMessageLevel ofRaw(int i8) {
            for (ConsoleMessageLevel consoleMessageLevel : ConsoleMessageLevel.values()) {
                if (consoleMessageLevel.getRaw() == i8) {
                    return consoleMessageLevel;
                }
            }
            return null;
        }

        public /* synthetic */ Companion(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    private static final /* synthetic */ ConsoleMessageLevel[] $values() {
        return new ConsoleMessageLevel[]{DEBUG, ERROR, LOG, TIP, WARNING, UNKNOWN};
    }

    static {
        ConsoleMessageLevel[] consoleMessageLevelArr$values = $values();
        $VALUES = consoleMessageLevelArr$values;
        $ENTRIES = AbstractC2875b.a(consoleMessageLevelArr$values);
        Companion = new Companion(null);
    }

    private ConsoleMessageLevel(String str, int i8, int i9) {
        this.raw = i9;
    }

    public static InterfaceC2874a getEntries() {
        return $ENTRIES;
    }

    public static ConsoleMessageLevel valueOf(String str) {
        return (ConsoleMessageLevel) Enum.valueOf(ConsoleMessageLevel.class, str);
    }

    public static ConsoleMessageLevel[] values() {
        return (ConsoleMessageLevel[]) $VALUES.clone();
    }

    public final int getRaw() {
        return this.raw;
    }
}
