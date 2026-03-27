package R;

import android.view.View;
import android.view.accessibility.AccessibilityRecord;

/* JADX INFO: loaded from: classes.dex */
public abstract class B {
    public static void a(AccessibilityRecord accessibilityRecord, int i7) {
        accessibilityRecord.setMaxScrollX(i7);
    }

    public static void b(AccessibilityRecord accessibilityRecord, int i7) {
        accessibilityRecord.setMaxScrollY(i7);
    }

    public static void c(AccessibilityRecord accessibilityRecord, View view, int i7) {
        accessibilityRecord.setSource(view, i7);
    }
}
