package l0;

import android.graphics.Insets;
import android.graphics.Rect;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f14959e = new b(0, 0, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14962c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f14963d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {
        public static Insets a(int i10, int i11, int i12, int i13) {
            return Insets.of(i10, i11, i12, i13);
        }
    }

    public b(int i10, int i11, int i12, int i13) {
        this.f14960a = i10;
        this.f14961b = i11;
        this.f14962c = i12;
        this.f14963d = i13;
    }

    public static b a(b bVar, b bVar2) {
        return b(Math.max(bVar.f14960a, bVar2.f14960a), Math.max(bVar.f14961b, bVar2.f14961b), Math.max(bVar.f14962c, bVar2.f14962c), Math.max(bVar.f14963d, bVar2.f14963d));
    }

    public static b b(int i10, int i11, int i12, int i13) {
        return (i10 == 0 && i11 == 0 && i12 == 0 && i13 == 0) ? f14959e : new b(i10, i11, i12, i13);
    }

    public static b c(Rect rect) {
        return b(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static b d(Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public Insets e() {
        return a.a(this.f14960a, this.f14961b, this.f14962c, this.f14963d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f14963d == bVar.f14963d && this.f14960a == bVar.f14960a && this.f14962c == bVar.f14962c && this.f14961b == bVar.f14961b;
    }

    public int hashCode() {
        return (((((this.f14960a * 31) + this.f14961b) * 31) + this.f14962c) * 31) + this.f14963d;
    }

    public String toString() {
        return "Insets{left=" + this.f14960a + ", top=" + this.f14961b + ", right=" + this.f14962c + ", bottom=" + this.f14963d + '}';
    }
}
