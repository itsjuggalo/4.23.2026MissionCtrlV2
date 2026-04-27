package com.google.protobuf;

import com.google.protobuf.AbstractC1059f;
import com.google.protobuf.C0;
import com.google.protobuf.C1073u;
import com.google.protobuf.H;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: com.google.protobuf.a0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1051a0 implements o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final W f10998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w0 f10999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f11000c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r f11001d;

    public C1051a0(w0 w0Var, r rVar, W w4) {
        this.f10999b = w0Var;
        this.f11000c = rVar.e(w4);
        this.f11001d = rVar;
        this.f10998a = w4;
    }

    private int k(w0 w0Var, Object obj) {
        return w0Var.i(w0Var.g(obj));
    }

    private void l(w0 w0Var, r rVar, Object obj, m0 m0Var, C1070q c1070q) throws Throwable {
        w0 w0Var2;
        Object objF = w0Var.f(obj);
        C1073u c1073uD = rVar.d(obj);
        while (m0Var.w() != Integer.MAX_VALUE) {
            try {
                w0Var2 = w0Var;
                r rVar2 = rVar;
                m0 m0Var2 = m0Var;
                C1070q c1070q2 = c1070q;
                try {
                    if (!n(m0Var2, c1070q2, rVar2, c1073uD, w0Var2, objF)) {
                        w0Var2.o(obj, objF);
                        return;
                    }
                    m0Var = m0Var2;
                    c1070q = c1070q2;
                    rVar = rVar2;
                    w0Var = w0Var2;
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    w0Var2.o(obj, objF);
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
                w0Var2 = w0Var;
            }
        }
        w0Var.o(obj, objF);
    }

    public static C1051a0 m(w0 w0Var, r rVar, W w4) {
        return new C1051a0(w0Var, rVar, w4);
    }

    @Override // com.google.protobuf.o0
    public void a(Object obj, Object obj2) {
        q0.G(this.f10999b, obj, obj2);
        if (this.f11000c) {
            q0.E(this.f11001d, obj, obj2);
        }
    }

    @Override // com.google.protobuf.o0
    public void b(Object obj) {
        this.f10999b.j(obj);
        this.f11001d.f(obj);
    }

    @Override // com.google.protobuf.o0
    public final boolean c(Object obj) {
        return this.f11001d.c(obj).n();
    }

    @Override // com.google.protobuf.o0
    public boolean d(Object obj, Object obj2) {
        if (!this.f10999b.g(obj).equals(this.f10999b.g(obj2))) {
            return false;
        }
        if (this.f11000c) {
            return this.f11001d.c(obj).equals(this.f11001d.c(obj2));
        }
        return true;
    }

    @Override // com.google.protobuf.o0
    public int e(Object obj) {
        int iK = k(this.f10999b, obj);
        return this.f11000c ? iK + this.f11001d.c(obj).i() : iK;
    }

    @Override // com.google.protobuf.o0
    public Object f() {
        W w4 = this.f10998a;
        return w4 instanceof AbstractC1077y ? ((AbstractC1077y) w4).newMutableInstance() : w4.newBuilderForType().buildPartial();
    }

    @Override // com.google.protobuf.o0
    public int g(Object obj) {
        int iHashCode = this.f10999b.g(obj).hashCode();
        return this.f11000c ? (iHashCode * 53) + this.f11001d.c(obj).hashCode() : iHashCode;
    }

    @Override // com.google.protobuf.o0
    public void h(Object obj, D0 d02) {
        Iterator itR = this.f11001d.c(obj).r();
        while (itR.hasNext()) {
            Map.Entry entry = (Map.Entry) itR.next();
            C1073u.b bVar = (C1073u.b) entry.getKey();
            if (bVar.j() != C0.c.MESSAGE || bVar.d() || bVar.f()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof H.a) {
                bVar.getNumber();
                ((H.a) entry).a();
                throw null;
            }
            d02.c(bVar.getNumber(), entry.getValue());
        }
        o(this.f10999b, obj, d02);
    }

    @Override // com.google.protobuf.o0
    public void i(Object obj, m0 m0Var, C1070q c1070q) throws Throwable {
        l(this.f10999b, this.f11001d, obj, m0Var, c1070q);
    }

    @Override // com.google.protobuf.o0
    public void j(Object obj, byte[] bArr, int i4, int i5, AbstractC1059f.a aVar) {
        AbstractC1077y abstractC1077y = (AbstractC1077y) obj;
        if (abstractC1077y.unknownFields == x0.c()) {
            abstractC1077y.unknownFields = x0.o();
        }
        android.support.v4.media.session.b.a(obj);
        throw null;
    }

    public final boolean n(m0 m0Var, C1070q c1070q, r rVar, C1073u c1073u, w0 w0Var, Object obj) throws D {
        int iQ = m0Var.q();
        int iK = 0;
        if (iQ != C0.f10887a) {
            if (C0.b(iQ) != 2) {
                return m0Var.C();
            }
            Object objB = rVar.b(c1070q, this.f10998a, C0.a(iQ));
            if (objB == null) {
                return w0Var.m(obj, m0Var, 0);
            }
            rVar.h(m0Var, objB, c1070q, c1073u);
            return true;
        }
        Object objB2 = null;
        AbstractC1062i abstractC1062iZ = null;
        while (m0Var.w() != Integer.MAX_VALUE) {
            int iQ2 = m0Var.q();
            if (iQ2 == C0.f10889c) {
                iK = m0Var.k();
                objB2 = rVar.b(c1070q, this.f10998a, iK);
            } else if (iQ2 == C0.f10890d) {
                if (objB2 != null) {
                    rVar.h(m0Var, objB2, c1070q, c1073u);
                } else {
                    abstractC1062iZ = m0Var.z();
                }
            } else if (!m0Var.C()) {
                break;
            }
        }
        if (m0Var.q() != C0.f10888b) {
            throw D.b();
        }
        if (abstractC1062iZ != null) {
            if (objB2 != null) {
                rVar.i(abstractC1062iZ, objB2, c1070q, c1073u);
            } else {
                w0Var.d(obj, iK, abstractC1062iZ);
            }
        }
        return true;
    }

    public final void o(w0 w0Var, Object obj, D0 d02) {
        w0Var.s(w0Var.g(obj), d02);
    }
}
