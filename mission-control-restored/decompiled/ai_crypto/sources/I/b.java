package I;

import android.graphics.Insets;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f2676e = new b(0, 0, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2679c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f2680d;

    public static class a {
        public static Insets a(int i7, int i8, int i9, int i10) {
            return Insets.of(i7, i8, i9, i10);
        }
    }

    public b(int i7, int i8, int i9, int i10) {
        this.f2677a = i7;
        this.f2678b = i8;
        this.f2679c = i9;
        this.f2680d = i10;
    }

    public static b a(b bVar, b bVar2) {
        return b(Math.max(bVar.f2677a, bVar2.f2677a), Math.max(bVar.f2678b, bVar2.f2678b), Math.max(bVar.f2679c, bVar2.f2679c), Math.max(bVar.f2680d, bVar2.f2680d));
    }

    public static b b(int i7, int i8, int i9, int i10) {
        return (i7 == 0 && i8 == 0 && i9 == 0 && i10 == 0) ? f2676e : new b(i7, i8, i9, i10);
    }

    public static b c(Rect rect) {
        return b(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static b d(Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public Insets e() {
        return a.a(this.f2677a, this.f2678b, this.f2679c, this.f2680d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f2680d == bVar.f2680d && this.f2677a == bVar.f2677a && this.f2679c == bVar.f2679c && this.f2678b == bVar.f2678b;
    }

    public int hashCode() {
        return (((((this.f2677a * 31) + this.f2678b) * 31) + this.f2679c) * 31) + this.f2680d;
    }

    public String toString() {
        return "Insets{left=" + this.f2677a + ", top=" + this.f2678b + ", right=" + this.f2679c + ", bottom=" + this.f2680d + '}';
    }
}
