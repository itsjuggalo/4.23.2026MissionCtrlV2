package w;

import android.graphics.Insets;

/* JADX INFO: renamed from: w.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1264c {
    public static final C1264c e = new C1264c(0, 0, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f10679c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f10680d;

    public C1264c(int i, int i6, int i7, int i8) {
        this.f10677a = i;
        this.f10678b = i6;
        this.f10679c = i7;
        this.f10680d = i8;
    }

    public static C1264c a(int i, int i6, int i7, int i8) {
        return (i == 0 && i6 == 0 && i7 == 0 && i8 == 0) ? e : new C1264c(i, i6, i7, i8);
    }

    public final Insets b() {
        return AbstractC1263b.a(this.f10677a, this.f10678b, this.f10679c, this.f10680d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C1264c.class != obj.getClass()) {
            return false;
        }
        C1264c c1264c = (C1264c) obj;
        return this.f10680d == c1264c.f10680d && this.f10677a == c1264c.f10677a && this.f10679c == c1264c.f10679c && this.f10678b == c1264c.f10678b;
    }

    public final int hashCode() {
        return (((((this.f10677a * 31) + this.f10678b) * 31) + this.f10679c) * 31) + this.f10680d;
    }

    public final String toString() {
        return "Insets{left=" + this.f10677a + ", top=" + this.f10678b + ", right=" + this.f10679c + ", bottom=" + this.f10680d + '}';
    }
}
