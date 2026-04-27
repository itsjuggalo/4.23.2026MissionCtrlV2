package R;

import android.view.accessibility.AccessibilityManager;

/* JADX INFO: renamed from: R.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0687c {

    /* JADX INFO: renamed from: R.c$a */
    public interface a {
        void onTouchExplorationStateChanged(boolean z7);
    }

    /* JADX INFO: renamed from: R.c$b */
    public static final class b implements AccessibilityManager.TouchExplorationStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f4569a;

        public b(a aVar) {
            this.f4569a = aVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                return this.f4569a.equals(((b) obj).f4569a);
            }
            return false;
        }

        public int hashCode() {
            return this.f4569a.hashCode();
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public void onTouchExplorationStateChanged(boolean z7) {
            this.f4569a.onTouchExplorationStateChanged(z7);
        }
    }

    public static boolean a(AccessibilityManager accessibilityManager, a aVar) {
        return accessibilityManager.addTouchExplorationStateChangeListener(new b(aVar));
    }

    public static boolean b(AccessibilityManager accessibilityManager, a aVar) {
        return accessibilityManager.removeTouchExplorationStateChangeListener(new b(aVar));
    }
}
