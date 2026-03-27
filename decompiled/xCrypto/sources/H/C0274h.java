package H;

import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import java.util.List;

/* JADX INFO: renamed from: H.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0274h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DisplayCutout f559a;

    /* JADX INFO: renamed from: H.h$a */
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

    public C0274h(DisplayCutout displayCutout) {
        this.f559a = displayCutout;
    }

    public static C0274h e(DisplayCutout displayCutout) {
        if (displayCutout == null) {
            return null;
        }
        return new C0274h(displayCutout);
    }

    public int a() {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.c(this.f559a);
        }
        return 0;
    }

    public int b() {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.d(this.f559a);
        }
        return 0;
    }

    public int c() {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.e(this.f559a);
        }
        return 0;
    }

    public int d() {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.f(this.f559a);
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0274h.class != obj.getClass()) {
            return false;
        }
        return G.b.a(this.f559a, ((C0274h) obj).f559a);
    }

    public int hashCode() {
        DisplayCutout displayCutout = this.f559a;
        if (displayCutout == null) {
            return 0;
        }
        return displayCutout.hashCode();
    }

    public String toString() {
        return "DisplayCutoutCompat{" + this.f559a + "}";
    }
}
