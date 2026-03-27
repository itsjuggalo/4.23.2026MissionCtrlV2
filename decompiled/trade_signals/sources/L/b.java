package L;

import android.graphics.Insets;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f4921e = new b(0, 0, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f4925d;

    public static class a {
        public static Insets a(int i8, int i9, int i10, int i11) {
            return Insets.of(i8, i9, i10, i11);
        }
    }

    public b(int i8, int i9, int i10, int i11) {
        this.f4922a = i8;
        this.f4923b = i9;
        this.f4924c = i10;
        this.f4925d = i11;
    }

    public static b a(b bVar, b bVar2) {
        return b(Math.max(bVar.f4922a, bVar2.f4922a), Math.max(bVar.f4923b, bVar2.f4923b), Math.max(bVar.f4924c, bVar2.f4924c), Math.max(bVar.f4925d, bVar2.f4925d));
    }

    public static b b(int i8, int i9, int i10, int i11) {
        return (i8 == 0 && i9 == 0 && i10 == 0 && i11 == 0) ? f4921e : new b(i8, i9, i10, i11);
    }

    public static b c(Rect rect) {
        return b(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static b d(Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public Insets e() {
        return a.a(this.f4922a, this.f4923b, this.f4924c, this.f4925d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f4925d == bVar.f4925d && this.f4922a == bVar.f4922a && this.f4924c == bVar.f4924c && this.f4923b == bVar.f4923b;
    }

    public int hashCode() {
        return (((((this.f4922a * 31) + this.f4923b) * 31) + this.f4924c) * 31) + this.f4925d;
    }

    public String toString() {
        return "Insets{left=" + this.f4922a + ", top=" + this.f4923b + ", right=" + this.f4924c + ", bottom=" + this.f4925d + '}';
    }
}
