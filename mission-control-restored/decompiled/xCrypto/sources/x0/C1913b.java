package x0;

import android.graphics.Rect;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: x0.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1913b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f15694c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f15695d;

    public C1913b(int i4, int i5, int i6, int i7) {
        this.f15692a = i4;
        this.f15693b = i5;
        this.f15694c = i6;
        this.f15695d = i7;
        if (i4 > i6) {
            throw new IllegalArgumentException(("Left must be less than or equal to right, left: " + i4 + ", right: " + i6).toString());
        }
        if (i5 <= i7) {
            return;
        }
        throw new IllegalArgumentException(("top must be less than or equal to bottom, top: " + i5 + ", bottom: " + i7).toString());
    }

    public final int a() {
        return this.f15695d - this.f15693b;
    }

    public final int b() {
        return this.f15692a;
    }

    public final int c() {
        return this.f15693b;
    }

    public final int d() {
        return this.f15694c - this.f15692a;
    }

    public final boolean e() {
        return a() == 0 && d() == 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!r.b(C1913b.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        r.d(obj, "null cannot be cast to non-null type androidx.window.core.Bounds");
        C1913b c1913b = (C1913b) obj;
        return this.f15692a == c1913b.f15692a && this.f15693b == c1913b.f15693b && this.f15694c == c1913b.f15694c && this.f15695d == c1913b.f15695d;
    }

    public final Rect f() {
        return new Rect(this.f15692a, this.f15693b, this.f15694c, this.f15695d);
    }

    public int hashCode() {
        return (((((this.f15692a * 31) + this.f15693b) * 31) + this.f15694c) * 31) + this.f15695d;
    }

    public String toString() {
        return C1913b.class.getSimpleName() + " { [" + this.f15692a + ',' + this.f15693b + ',' + this.f15694c + ',' + this.f15695d + "] }";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C1913b(Rect rect) {
        this(rect.left, rect.top, rect.right, rect.bottom);
        r.f(rect, "rect");
    }
}
