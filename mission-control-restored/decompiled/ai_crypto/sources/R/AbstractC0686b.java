package R;

import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: renamed from: R.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0686b {
    public static int a(AccessibilityEvent accessibilityEvent) {
        return accessibilityEvent.getContentChangeTypes();
    }

    public static void b(AccessibilityEvent accessibilityEvent, int i7) {
        accessibilityEvent.setContentChangeTypes(i7);
    }
}
