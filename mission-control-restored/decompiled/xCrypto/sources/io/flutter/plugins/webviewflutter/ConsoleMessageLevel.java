package io.flutter.plugins.webviewflutter;

import c3.AbstractC0878b;
import c3.InterfaceC0877a;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes3.dex */
public final class ConsoleMessageLevel {
    private static final /* synthetic */ InterfaceC0877a $ENTRIES;
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
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final ConsoleMessageLevel ofRaw(int i4) {
            for (ConsoleMessageLevel consoleMessageLevel : ConsoleMessageLevel.values()) {
                if (consoleMessageLevel.getRaw() == i4) {
                    return consoleMessageLevel;
                }
            }
            return null;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ ConsoleMessageLevel[] $values() {
        return new ConsoleMessageLevel[]{DEBUG, ERROR, LOG, TIP, WARNING, UNKNOWN};
    }

    static {
        ConsoleMessageLevel[] consoleMessageLevelArr$values = $values();
        $VALUES = consoleMessageLevelArr$values;
        $ENTRIES = AbstractC0878b.a(consoleMessageLevelArr$values);
        Companion = new Companion(null);
    }

    private ConsoleMessageLevel(String str, int i4, int i5) {
        this.raw = i5;
    }

    public static InterfaceC0877a getEntries() {
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
