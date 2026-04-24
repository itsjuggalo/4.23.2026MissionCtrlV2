package io.flutter.plugins.webviewflutter;

import c3.AbstractC0878b;
import c3.InterfaceC0877a;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes3.dex */
public final class FileChooserMode {
    private static final /* synthetic */ InterfaceC0877a $ENTRIES;
    private static final /* synthetic */ FileChooserMode[] $VALUES;
    public static final Companion Companion;
    public static final FileChooserMode OPEN = new FileChooserMode("OPEN", 0, 0);
    public static final FileChooserMode OPEN_MULTIPLE = new FileChooserMode("OPEN_MULTIPLE", 1, 1);
    public static final FileChooserMode SAVE = new FileChooserMode("SAVE", 2, 2);
    public static final FileChooserMode UNKNOWN = new FileChooserMode("UNKNOWN", 3, 3);
    private final int raw;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final FileChooserMode ofRaw(int i4) {
            for (FileChooserMode fileChooserMode : FileChooserMode.values()) {
                if (fileChooserMode.getRaw() == i4) {
                    return fileChooserMode;
                }
            }
            return null;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ FileChooserMode[] $values() {
        return new FileChooserMode[]{OPEN, OPEN_MULTIPLE, SAVE, UNKNOWN};
    }

    static {
        FileChooserMode[] fileChooserModeArr$values = $values();
        $VALUES = fileChooserModeArr$values;
        $ENTRIES = AbstractC0878b.a(fileChooserModeArr$values);
        Companion = new Companion(null);
    }

    private FileChooserMode(String str, int i4, int i5) {
        this.raw = i5;
    }

    public static InterfaceC0877a getEntries() {
        return $ENTRIES;
    }

    public static FileChooserMode valueOf(String str) {
        return (FileChooserMode) Enum.valueOf(FileChooserMode.class, str);
    }

    public static FileChooserMode[] values() {
        return (FileChooserMode[]) $VALUES.clone();
    }

    public final int getRaw() {
        return this.raw;
    }
}
