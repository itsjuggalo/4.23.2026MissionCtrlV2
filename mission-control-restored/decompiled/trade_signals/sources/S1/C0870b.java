package S1;

import R1.a;
import com.google.android.gms.common.internal.AbstractC1293m;

/* JADX INFO: renamed from: S1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0870b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final R1.a f7392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a.d f7393c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f7394d;

    public C0870b(R1.a aVar, a.d dVar, String str) {
        this.f7392b = aVar;
        this.f7393c = dVar;
        this.f7394d = str;
        this.f7391a = AbstractC1293m.b(aVar, dVar, str);
    }

    public static C0870b a(R1.a aVar, a.d dVar, String str) {
        return new C0870b(aVar, dVar, str);
    }

    public final String b() {
        return this.f7392b.b();
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0870b)) {
            return false;
        }
        C0870b c0870b = (C0870b) obj;
        return AbstractC1293m.a(this.f7392b, c0870b.f7392b) && AbstractC1293m.a(this.f7393c, c0870b.f7393c) && AbstractC1293m.a(this.f7394d, c0870b.f7394d);
    }

    public final int hashCode() {
        return this.f7391a;
    }
}
