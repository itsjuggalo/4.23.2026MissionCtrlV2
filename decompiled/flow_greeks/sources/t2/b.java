package t2;

import android.graphics.Rect;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f20633e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f20634f = new b(0, 0, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f20635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f20636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f20637c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f20638d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    public b(int i10, int i11, int i12, int i13) {
        this.f20635a = i10;
        this.f20636b = i11;
        this.f20637c = i12;
        this.f20638d = i13;
        if (i10 > i12) {
            throw new IllegalArgumentException(("Left must be less than or equal to right, left: " + i10 + ", right: " + i12).toString());
        }
        if (i11 <= i13) {
            return;
        }
        throw new IllegalArgumentException(("top must be less than or equal to bottom, top: " + i11 + ", bottom: " + i13).toString());
    }

    public final int a() {
        return this.f20638d - this.f20636b;
    }

    public final int b() {
        return this.f20635a;
    }

    public final int c() {
        return this.f20636b;
    }

    public final int d() {
        return this.f20637c - this.f20635a;
    }

    public final boolean e() {
        return a() == 0 && d() == 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!t.b(b.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        t.d(obj, "null cannot be cast to non-null type androidx.window.core.Bounds");
        b bVar = (b) obj;
        return this.f20635a == bVar.f20635a && this.f20636b == bVar.f20636b && this.f20637c == bVar.f20637c && this.f20638d == bVar.f20638d;
    }

    public final Rect f() {
        return new Rect(this.f20635a, this.f20636b, this.f20637c, this.f20638d);
    }

    public int hashCode() {
        return (((((this.f20635a * 31) + this.f20636b) * 31) + this.f20637c) * 31) + this.f20638d;
    }

    public String toString() {
        return b.class.getSimpleName() + " { [" + this.f20635a + ',' + this.f20636b + ',' + this.f20637c + ',' + this.f20638d + "] }";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(Rect rect) {
        this(rect.left, rect.top, rect.right, rect.bottom);
        t.f(rect, "rect");
    }
}
