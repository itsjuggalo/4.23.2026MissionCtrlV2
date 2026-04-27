package O0;

import android.graphics.Rect;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4009c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f4010d;

    public b(int i7, int i8, int i9, int i10) {
        this.f4007a = i7;
        this.f4008b = i8;
        this.f4009c = i9;
        this.f4010d = i10;
        if (i7 > i9) {
            throw new IllegalArgumentException(("Left must be less than or equal to right, left: " + i7 + ", right: " + i9).toString());
        }
        if (i8 <= i10) {
            return;
        }
        throw new IllegalArgumentException(("top must be less than or equal to bottom, top: " + i8 + ", bottom: " + i10).toString());
    }

    public final int a() {
        return this.f4010d - this.f4008b;
    }

    public final int b() {
        return this.f4007a;
    }

    public final int c() {
        return this.f4008b;
    }

    public final int d() {
        return this.f4009c - this.f4007a;
    }

    public final boolean e() {
        return a() == 0 && d() == 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!r.b(b.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        r.d(obj, "null cannot be cast to non-null type androidx.window.core.Bounds");
        b bVar = (b) obj;
        return this.f4007a == bVar.f4007a && this.f4008b == bVar.f4008b && this.f4009c == bVar.f4009c && this.f4010d == bVar.f4010d;
    }

    public final Rect f() {
        return new Rect(this.f4007a, this.f4008b, this.f4009c, this.f4010d);
    }

    public int hashCode() {
        return (((((this.f4007a * 31) + this.f4008b) * 31) + this.f4009c) * 31) + this.f4010d;
    }

    public String toString() {
        return b.class.getSimpleName() + " { [" + this.f4007a + ',' + this.f4008b + ',' + this.f4009c + ',' + this.f4010d + "] }";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(Rect rect) {
        this(rect.left, rect.top, rect.right, rect.bottom);
        r.f(rect, "rect");
    }
}
