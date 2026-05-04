package dh;

import bh.l;
import bh.m;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class x extends j1 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final bh.l f8246m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final cd.k f8247n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(final String name, final int i10) {
        super(name, null, i10, 2, null);
        kotlin.jvm.internal.t.f(name, "name");
        this.f8246m = l.b.f3401a;
        this.f8247n = cd.l.b(new Function0() { // from class: dh.w
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return x.B(i10, name, this);
            }
        });
    }

    public static final bh.e[] B(int i10, String str, x xVar) {
        bh.e[] eVarArr = new bh.e[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            eVarArr[i11] = bh.k.e(str + com.amazon.a.a.o.c.a.b.f4610a + xVar.m(i11), m.d.f3405a, new bh.e[0], null, 8, null);
        }
        return eVarArr;
    }

    public final bh.e[] C() {
        return (bh.e[]) this.f8247n.getValue();
    }

    @Override // dh.j1
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof bh.e)) {
            return false;
        }
        bh.e eVar = (bh.e) obj;
        return eVar.h() == l.b.f3401a && kotlin.jvm.internal.t.b(i(), eVar.i()) && kotlin.jvm.internal.t.b(d1.a(this), d1.a(eVar));
    }

    @Override // dh.j1, bh.e
    public bh.l h() {
        return this.f8246m;
    }

    @Override // dh.j1
    public int hashCode() {
        int iHashCode = i().hashCode();
        int iHashCode2 = 1;
        for (String str : bh.i.b(this)) {
            int i10 = iHashCode2 * 31;
            iHashCode2 = i10 + (str != null ? str.hashCode() : 0);
        }
        return (iHashCode * 31) + iHashCode2;
    }

    @Override // dh.j1, bh.e
    public bh.e o(int i10) {
        return C()[i10];
    }

    @Override // dh.j1
    public String toString() {
        return dd.a0.i0(bh.i.b(this), ", ", i() + '(', ")", 0, null, null, 56, null);
    }
}
