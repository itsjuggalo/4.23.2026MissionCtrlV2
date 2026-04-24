package T;

import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import java.util.List;

/* JADX INFO: renamed from: T.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0926h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DisplayCutout f7850a;

    /* JADX INFO: renamed from: T.h$a */
    public static class a {
        public static DisplayCutout a(Rect rect, List<Rect> list) {
            return new DisplayCutout(rect, list);
        }

        public static List<Rect> b(DisplayCutout displayCutout) {
            return displayCutout.getBoundingRects();
        }

        public static int c(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetBottom();
        }

        public static int d(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetLeft();
        }

        public static int e(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetRight();
        }

        public static int f(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetTop();
        }
    }

    public C0926h(DisplayCutout displayCutout) {
        this.f7850a = displayCutout;
    }

    public static C0926h e(DisplayCutout displayCutout) {
        if (displayCutout == null) {
            return null;
        }
        return new C0926h(displayCutout);
    }

    public int a() {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.c(this.f7850a);
        }
        return 0;
    }

    public int b() {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.d(this.f7850a);
        }
        return 0;
    }

    public int c() {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.e(this.f7850a);
        }
        return 0;
    }

    public int d() {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.f(this.f7850a);
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0926h.class != obj.getClass()) {
            return false;
        }
        return S.c.a(this.f7850a, ((C0926h) obj).f7850a);
    }

    public int hashCode() {
        DisplayCutout displayCutout = this.f7850a;
        if (displayCutout == null) {
            return 0;
        }
        return displayCutout.hashCode();
    }

    public String toString() {
        return "DisplayCutoutCompat{" + this.f7850a + "}";
    }
}
