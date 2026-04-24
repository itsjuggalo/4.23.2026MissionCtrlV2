package z;

import android.graphics.Insets;
import android.graphics.Rect;

/* JADX INFO: renamed from: z.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1963b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C1963b f16021e = new C1963b(0, 0, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f16022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f16023b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f16024c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f16025d;

    /* JADX INFO: renamed from: z.b$a */
    public static class a {
        public static Insets a(int i4, int i5, int i6, int i7) {
            return Insets.of(i4, i5, i6, i7);
        }
    }

    public C1963b(int i4, int i5, int i6, int i7) {
        this.f16022a = i4;
        this.f16023b = i5;
        this.f16024c = i6;
        this.f16025d = i7;
    }

    public static C1963b a(C1963b c1963b, C1963b c1963b2) {
        return b(Math.max(c1963b.f16022a, c1963b2.f16022a), Math.max(c1963b.f16023b, c1963b2.f16023b), Math.max(c1963b.f16024c, c1963b2.f16024c), Math.max(c1963b.f16025d, c1963b2.f16025d));
    }

    public static C1963b b(int i4, int i5, int i6, int i7) {
        return (i4 == 0 && i5 == 0 && i6 == 0 && i7 == 0) ? f16021e : new C1963b(i4, i5, i6, i7);
    }

    public static C1963b c(Rect rect) {
        return b(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static C1963b d(Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public Insets e() {
        return a.a(this.f16022a, this.f16023b, this.f16024c, this.f16025d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C1963b.class != obj.getClass()) {
            return false;
        }
        C1963b c1963b = (C1963b) obj;
        return this.f16025d == c1963b.f16025d && this.f16022a == c1963b.f16022a && this.f16024c == c1963b.f16024c && this.f16023b == c1963b.f16023b;
    }

    public int hashCode() {
        return (((((this.f16022a * 31) + this.f16023b) * 31) + this.f16024c) * 31) + this.f16025d;
    }

    public String toString() {
        return "Insets{left=" + this.f16022a + ", top=" + this.f16023b + ", right=" + this.f16024c + ", bottom=" + this.f16025d + '}';
    }
}
