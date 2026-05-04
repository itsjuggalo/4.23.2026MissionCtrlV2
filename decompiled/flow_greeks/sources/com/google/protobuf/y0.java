package com.google.protobuf;

import com.google.protobuf.f;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class y0 implements m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u0 f7254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u1 f7255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f7256c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r f7257d;

    public y0(u1 u1Var, r rVar, u0 u0Var) {
        this.f7255b = u1Var;
        this.f7256c = rVar.e(u0Var);
        this.f7257d = rVar;
        this.f7254a = u0Var;
    }

    private int k(u1 u1Var, Object obj) {
        return u1Var.i(u1Var.g(obj));
    }

    private void l(u1 u1Var, r rVar, Object obj, k1 k1Var, q qVar) throws Throwable {
        u1 u1Var2;
        Object objF = u1Var.f(obj);
        u uVarD = rVar.d(obj);
        while (k1Var.w() != Integer.MAX_VALUE) {
            try {
                u1Var2 = u1Var;
                r rVar2 = rVar;
                k1 k1Var2 = k1Var;
                q qVar2 = qVar;
                try {
                    if (!n(k1Var2, qVar2, rVar2, uVarD, u1Var2, objF)) {
                        u1Var2.o(obj, objF);
                        return;
                    }
                    k1Var = k1Var2;
                    qVar = qVar2;
                    rVar = rVar2;
                    u1Var = u1Var2;
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    u1Var2.o(obj, objF);
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
                u1Var2 = u1Var;
            }
        }
        u1Var.o(obj, objF);
    }

    public static y0 m(u1 u1Var, r rVar, u0 u0Var) {
        return new y0(u1Var, rVar, u0Var);
    }

    @Override // com.google.protobuf.m1
    public void a(Object obj, Object obj2) {
        o1.F(this.f7255b, obj, obj2);
        if (this.f7256c) {
            o1.D(this.f7257d, obj, obj2);
        }
    }

    @Override // com.google.protobuf.m1
    public void b(Object obj) {
        this.f7255b.j(obj);
        this.f7257d.f(obj);
    }

    @Override // com.google.protobuf.m1
    public final boolean c(Object obj) {
        return this.f7257d.c(obj).k();
    }

    @Override // com.google.protobuf.m1
    public boolean d(Object obj, Object obj2) {
        if (!this.f7255b.g(obj).equals(this.f7255b.g(obj2))) {
            return false;
        }
        if (this.f7256c) {
            return this.f7257d.c(obj).equals(this.f7257d.c(obj2));
        }
        return true;
    }

    @Override // com.google.protobuf.m1
    public int e(Object obj) {
        int iK = k(this.f7255b, obj);
        return this.f7256c ? iK + this.f7257d.c(obj).f() : iK;
    }

    @Override // com.google.protobuf.m1
    public Object f() {
        u0 u0Var = this.f7254a;
        return u0Var instanceof y ? ((y) u0Var).O() : u0Var.c().e();
    }

    @Override // com.google.protobuf.m1
    public int g(Object obj) {
        int iHashCode = this.f7255b.g(obj).hashCode();
        return this.f7256c ? (iHashCode * 53) + this.f7257d.c(obj).hashCode() : iHashCode;
    }

    @Override // com.google.protobuf.m1
    public void h(Object obj, b2 b2Var) {
        Iterator itN = this.f7257d.c(obj).n();
        if (itN.hasNext()) {
            android.support.v4.media.session.b.a(((Map.Entry) itN.next()).getKey());
            throw null;
        }
        o(this.f7255b, obj, b2Var);
    }

    @Override // com.google.protobuf.m1
    public void i(Object obj, k1 k1Var, q qVar) throws Throwable {
        l(this.f7255b, this.f7257d, obj, k1Var, qVar);
    }

    @Override // com.google.protobuf.m1
    public void j(Object obj, byte[] bArr, int i10, int i11, f.a aVar) {
        y yVar = (y) obj;
        if (yVar.unknownFields == v1.c()) {
            yVar.unknownFields = v1.k();
        }
        android.support.v4.media.session.b.a(obj);
        throw null;
    }

    public final boolean n(k1 k1Var, q qVar, r rVar, u uVar, u1 u1Var, Object obj) throws d0 {
        int iA = k1Var.a();
        int iL = 0;
        if (iA != a2.f6897a) {
            if (a2.b(iA) != 2) {
                return k1Var.C();
            }
            Object objB = rVar.b(qVar, this.f7254a, a2.a(iA));
            if (objB == null) {
                return u1Var.m(obj, k1Var, 0);
            }
            rVar.h(k1Var, objB, qVar, uVar);
            return true;
        }
        Object objB2 = null;
        i iVarZ = null;
        while (k1Var.w() != Integer.MAX_VALUE) {
            int iA2 = k1Var.a();
            if (iA2 == a2.f6899c) {
                iL = k1Var.l();
                objB2 = rVar.b(qVar, this.f7254a, iL);
            } else if (iA2 == a2.f6900d) {
                if (objB2 != null) {
                    rVar.h(k1Var, objB2, qVar, uVar);
                } else {
                    iVarZ = k1Var.z();
                }
            } else if (!k1Var.C()) {
                break;
            }
        }
        if (k1Var.a() != a2.f6898b) {
            throw d0.b();
        }
        if (iVarZ != null) {
            if (objB2 != null) {
                rVar.i(iVarZ, objB2, qVar, uVar);
            } else {
                u1Var.d(obj, iL, iVarZ);
            }
        }
        return true;
    }

    public final void o(u1 u1Var, Object obj, b2 b2Var) {
        u1Var.s(u1Var.g(obj), b2Var);
    }
}
