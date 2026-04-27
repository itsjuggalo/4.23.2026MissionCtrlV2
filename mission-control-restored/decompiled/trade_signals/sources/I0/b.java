package I0;

import android.graphics.Rect;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f4019e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f4020f = new b(0, 0, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4023c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f4024d;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public b(int i8, int i9, int i10, int i11) {
        this.f4021a = i8;
        this.f4022b = i9;
        this.f4023c = i10;
        this.f4024d = i11;
        if (i8 > i10) {
            throw new IllegalArgumentException(("Left must be less than or equal to right, left: " + i8 + ", right: " + i10).toString());
        }
        if (i9 <= i11) {
            return;
        }
        throw new IllegalArgumentException(("top must be less than or equal to bottom, top: " + i9 + ", bottom: " + i11).toString());
    }

    public final int a() {
        return this.f4024d - this.f4022b;
    }

    public final int b() {
        return this.f4021a;
    }

    public final int c() {
        return this.f4022b;
    }

    public final int d() {
        return this.f4023c - this.f4021a;
    }

    public final boolean e() {
        return a() == 0 && d() == 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC2304t.b(b.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        AbstractC2304t.d(obj, "null cannot be cast to non-null type androidx.window.core.Bounds");
        b bVar = (b) obj;
        return this.f4021a == bVar.f4021a && this.f4022b == bVar.f4022b && this.f4023c == bVar.f4023c && this.f4024d == bVar.f4024d;
    }

    public final Rect f() {
        return new Rect(this.f4021a, this.f4022b, this.f4023c, this.f4024d);
    }

    public int hashCode() {
        return (((((this.f4021a * 31) + this.f4022b) * 31) + this.f4023c) * 31) + this.f4024d;
    }

    public String toString() {
        return b.class.getSimpleName() + " { [" + this.f4021a + ',' + this.f4022b + ',' + this.f4023c + ',' + this.f4024d + "] }";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(Rect rect) {
        this(rect.left, rect.top, rect.right, rect.bottom);
        AbstractC2304t.f(rect, "rect");
    }
}
