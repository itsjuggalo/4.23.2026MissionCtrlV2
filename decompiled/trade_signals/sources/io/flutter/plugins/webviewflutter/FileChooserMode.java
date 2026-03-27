package io.flutter.plugins.webviewflutter;

import kotlin.jvm.internal.AbstractC2296k;
import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class FileChooserMode {
    private static final /* synthetic */ InterfaceC2874a $ENTRIES;
    private static final /* synthetic */ FileChooserMode[] $VALUES;
    public static final Companion Companion;
    public static final FileChooserMode OPEN = new FileChooserMode("OPEN", 0, 0);
    public static final FileChooserMode OPEN_MULTIPLE = new FileChooserMode("OPEN_MULTIPLE", 1, 1);
    public static final FileChooserMode SAVE = new FileChooserMode("SAVE", 2, 2);
    public static final FileChooserMode UNKNOWN = new FileChooserMode("UNKNOWN", 3, 3);
    private final int raw;

    public static final class Companion {
        private Companion() {
        }

        public final FileChooserMode ofRaw(int i8) {
            for (FileChooserMode fileChooserMode : FileChooserMode.values()) {
                if (fileChooserMode.getRaw() == i8) {
                    return fileChooserMode;
                }
            }
            return null;
        }

        public /* synthetic */ Companion(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    private static final /* synthetic */ FileChooserMode[] $values() {
        return new FileChooserMode[]{OPEN, OPEN_MULTIPLE, SAVE, UNKNOWN};
    }

    static {
        FileChooserMode[] fileChooserModeArr$values = $values();
        $VALUES = fileChooserModeArr$values;
        $ENTRIES = AbstractC2875b.a(fileChooserModeArr$values);
        Companion = new Companion(null);
    }

    private FileChooserMode(String str, int i8, int i9) {
        this.raw = i9;
    }

    public static InterfaceC2874a getEntries() {
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
