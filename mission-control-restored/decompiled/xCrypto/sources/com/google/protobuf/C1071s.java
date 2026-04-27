package com.google.protobuf;

import com.google.firebase.firestore.index.FirestoreIndexValueWriter;
import com.google.protobuf.AbstractC1077y;
import com.google.protobuf.C0;
import com.google.protobuf.W;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p2.C1698D;

/* JADX INFO: renamed from: com.google.protobuf.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1071s extends r {

    /* JADX INFO: renamed from: com.google.protobuf.s$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11165a;

        static {
            int[] iArr = new int[C0.b.values().length];
            f11165a = iArr;
            try {
                iArr[C0.b.f10891c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11165a[C0.b.f10892d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11165a[C0.b.f10893e.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11165a[C0.b.f10894f.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11165a[C0.b.f10895g.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f11165a[C0.b.f10896h.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f11165a[C0.b.f10897i.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f11165a[C0.b.f10898j.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f11165a[C0.b.f10903o.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f11165a[C0.b.f10905q.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f11165a[C0.b.f10906r.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f11165a[C0.b.f10907s.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f11165a[C0.b.f10908t.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f11165a[C0.b.f10904p.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f11165a[C0.b.f10902n.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f11165a[C0.b.f10899k.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f11165a[C0.b.f10900l.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f11165a[C0.b.f10901m.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    @Override // com.google.protobuf.r
    public int a(Map.Entry entry) {
        return ((AbstractC1077y.c) entry.getKey()).getNumber();
    }

    @Override // com.google.protobuf.r
    public Object b(C1070q c1070q, W w4, int i4) {
        return c1070q.a(w4, i4);
    }

    @Override // com.google.protobuf.r
    public C1073u c(Object obj) {
        android.support.v4.media.session.b.a(obj);
        throw null;
    }

    @Override // com.google.protobuf.r
    public C1073u d(Object obj) {
        android.support.v4.media.session.b.a(obj);
        throw null;
    }

    @Override // com.google.protobuf.r
    public boolean e(W w4) {
        return false;
    }

    @Override // com.google.protobuf.r
    public void f(Object obj) {
        c(obj).s();
    }

    @Override // com.google.protobuf.r
    public Object g(Object obj, m0 m0Var, Object obj2, C1070q c1070q, C1073u c1073u, Object obj3, w0 w0Var) {
        Object objValueOf;
        Object objH;
        ArrayList arrayList;
        AbstractC1077y.d dVar = (AbstractC1077y.d) obj2;
        int iD = dVar.d();
        if (dVar.f11264d.d() && dVar.f11264d.f()) {
            switch (a.f11165a[dVar.b().ordinal()]) {
                case 1:
                    arrayList = new ArrayList();
                    m0Var.F(arrayList);
                    break;
                case 2:
                    arrayList = new ArrayList();
                    m0Var.A(arrayList);
                    break;
                case 3:
                    arrayList = new ArrayList();
                    m0Var.l(arrayList);
                    break;
                case 4:
                    arrayList = new ArrayList();
                    m0Var.j(arrayList);
                    break;
                case 5:
                    arrayList = new ArrayList();
                    m0Var.n(arrayList);
                    break;
                case 6:
                    arrayList = new ArrayList();
                    m0Var.I(arrayList);
                    break;
                case 7:
                    arrayList = new ArrayList();
                    m0Var.r(arrayList);
                    break;
                case 8:
                    arrayList = new ArrayList();
                    m0Var.u(arrayList);
                    break;
                case 9:
                    arrayList = new ArrayList();
                    m0Var.f(arrayList);
                    break;
                case 10:
                    arrayList = new ArrayList();
                    m0Var.d(arrayList);
                    break;
                case 11:
                    arrayList = new ArrayList();
                    m0Var.m(arrayList);
                    break;
                case 12:
                    arrayList = new ArrayList();
                    m0Var.a(arrayList);
                    break;
                case 13:
                    arrayList = new ArrayList();
                    m0Var.e(arrayList);
                    break;
                case 14:
                    arrayList = new ArrayList();
                    m0Var.o(arrayList);
                    obj3 = q0.z(obj, iD, arrayList, dVar.f11264d.c(), obj3, w0Var);
                    break;
                default:
                    throw new IllegalStateException("Type cannot be packed: " + dVar.f11264d.e());
            }
            c1073u.w(dVar.f11264d, arrayList);
            return obj3;
        }
        if (dVar.b() != C0.b.f10904p) {
            switch (a.f11165a[dVar.b().ordinal()]) {
                case 1:
                    objValueOf = Double.valueOf(m0Var.readDouble());
                    break;
                case 2:
                    objValueOf = Float.valueOf(m0Var.readFloat());
                    break;
                case 3:
                    objValueOf = Long.valueOf(m0Var.G());
                    break;
                case 4:
                    objValueOf = Long.valueOf(m0Var.b());
                    break;
                case 5:
                    objValueOf = Integer.valueOf(m0Var.B());
                    break;
                case 6:
                    objValueOf = Long.valueOf(m0Var.c());
                    break;
                case 7:
                    objValueOf = Integer.valueOf(m0Var.g());
                    break;
                case 8:
                    objValueOf = Boolean.valueOf(m0Var.h());
                    break;
                case 9:
                    objValueOf = Integer.valueOf(m0Var.k());
                    break;
                case 10:
                    objValueOf = Integer.valueOf(m0Var.D());
                    break;
                case 11:
                    objValueOf = Long.valueOf(m0Var.i());
                    break;
                case 12:
                    objValueOf = Integer.valueOf(m0Var.s());
                    break;
                case 13:
                    objValueOf = Long.valueOf(m0Var.t());
                    break;
                case 14:
                    throw new IllegalStateException("Shouldn't reach here.");
                case FirestoreIndexValueWriter.INDEX_TYPE_NUMBER /* 15 */:
                    objValueOf = m0Var.z();
                    break;
                case 16:
                    objValueOf = m0Var.v();
                    break;
                case C1698D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                    if (!dVar.e()) {
                        Object objH2 = c1073u.h(dVar.f11264d);
                        if (objH2 instanceof AbstractC1077y) {
                            o0 o0VarD = j0.a().d(objH2);
                            if (!((AbstractC1077y) objH2).isMutable()) {
                                Object objF = o0VarD.f();
                                o0VarD.a(objF, objH2);
                                c1073u.w(dVar.f11264d, objF);
                                objH2 = objF;
                            }
                            m0Var.L(objH2, o0VarD, c1070q);
                            return obj3;
                        }
                    }
                    objValueOf = m0Var.N(dVar.c().getClass(), c1070q);
                    break;
                case C1698D.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                    if (!dVar.e()) {
                        Object objH3 = c1073u.h(dVar.f11264d);
                        if (objH3 instanceof AbstractC1077y) {
                            o0 o0VarD2 = j0.a().d(objH3);
                            if (!((AbstractC1077y) objH3).isMutable()) {
                                Object objF2 = o0VarD2.f();
                                o0VarD2.a(objF2, objH3);
                                c1073u.w(dVar.f11264d, objF2);
                                objH3 = objF2;
                            }
                            m0Var.O(objH3, o0VarD2, c1070q);
                            return obj3;
                        }
                    }
                    objValueOf = m0Var.K(dVar.c().getClass(), c1070q);
                    break;
                default:
                    objValueOf = null;
                    break;
            }
        } else {
            int iB = m0Var.B();
            if (dVar.f11264d.c().a(iB) == null) {
                return q0.J(obj, iD, iB, obj3, w0Var);
            }
            objValueOf = Integer.valueOf(iB);
        }
        if (dVar.e()) {
            c1073u.a(dVar.f11264d, objValueOf);
            return obj3;
        }
        int i4 = a.f11165a[dVar.b().ordinal()];
        if ((i4 == 17 || i4 == 18) && (objH = c1073u.h(dVar.f11264d)) != null) {
            objValueOf = C.h(objH, objValueOf);
        }
        c1073u.w(dVar.f11264d, objValueOf);
        return obj3;
    }

    @Override // com.google.protobuf.r
    public void h(m0 m0Var, Object obj, C1070q c1070q, C1073u c1073u) {
        AbstractC1077y.d dVar = (AbstractC1077y.d) obj;
        c1073u.w(dVar.f11264d, m0Var.K(dVar.c().getClass(), c1070q));
    }

    @Override // com.google.protobuf.r
    public void i(AbstractC1062i abstractC1062i, Object obj, C1070q c1070q, C1073u c1073u) {
        AbstractC1077y.d dVar = (AbstractC1077y.d) obj;
        W.a aVarNewBuilderForType = dVar.c().newBuilderForType();
        AbstractC1063j abstractC1063jA = abstractC1062i.A();
        aVarNewBuilderForType.mergeFrom(abstractC1063jA, c1070q);
        c1073u.w(dVar.f11264d, aVarNewBuilderForType.buildPartial());
        abstractC1063jA.a(0);
    }

    @Override // com.google.protobuf.r
    public void j(D0 d02, Map.Entry entry) {
        AbstractC1077y.c cVar = (AbstractC1077y.c) entry.getKey();
        if (!cVar.d()) {
            switch (a.f11165a[cVar.e().ordinal()]) {
                case 1:
                    d02.e(cVar.getNumber(), ((Double) entry.getValue()).doubleValue());
                    break;
                case 2:
                    d02.A(cVar.getNumber(), ((Float) entry.getValue()).floatValue());
                    break;
                case 3:
                    d02.n(cVar.getNumber(), ((Long) entry.getValue()).longValue());
                    break;
                case 4:
                    d02.l(cVar.getNumber(), ((Long) entry.getValue()).longValue());
                    break;
                case 5:
                    d02.r(cVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    break;
                case 6:
                    d02.h(cVar.getNumber(), ((Long) entry.getValue()).longValue());
                    break;
                case 7:
                    d02.d(cVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    break;
                case 8:
                    d02.o(cVar.getNumber(), ((Boolean) entry.getValue()).booleanValue());
                    break;
                case 9:
                    d02.b(cVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    break;
                case 10:
                    d02.p(cVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    break;
                case 11:
                    d02.u(cVar.getNumber(), ((Long) entry.getValue()).longValue());
                    break;
                case 12:
                    d02.H(cVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    break;
                case 13:
                    d02.z(cVar.getNumber(), ((Long) entry.getValue()).longValue());
                    break;
                case 14:
                    d02.r(cVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    break;
                case FirestoreIndexValueWriter.INDEX_TYPE_NUMBER /* 15 */:
                    d02.N(cVar.getNumber(), (AbstractC1062i) entry.getValue());
                    break;
                case 16:
                    d02.k(cVar.getNumber(), (String) entry.getValue());
                    break;
                case C1698D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                    d02.M(cVar.getNumber(), entry.getValue(), j0.a().c(entry.getValue().getClass()));
                    break;
                case C1698D.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                    d02.L(cVar.getNumber(), entry.getValue(), j0.a().c(entry.getValue().getClass()));
                    break;
            }
        }
        switch (a.f11165a[cVar.e().ordinal()]) {
            case 1:
                q0.O(cVar.getNumber(), (List) entry.getValue(), d02, cVar.f());
                break;
            case 2:
                q0.S(cVar.getNumber(), (List) entry.getValue(), d02, cVar.f());
                break;
            case 3:
                q0.V(cVar.getNumber(), (List) entry.getValue(), d02, cVar.f());
                break;
            case 4:
                q0.d0(cVar.getNumber(), (List) entry.getValue(), d02, cVar.f());
                break;
            case 5:
                q0.U(cVar.getNumber(), (List) entry.getValue(), d02, cVar.f());
                break;
            case 6:
                q0.R(cVar.getNumber(), (List) entry.getValue(), d02, cVar.f());
                break;
            case 7:
                q0.Q(cVar.getNumber(), (List) entry.getValue(), d02, cVar.f());
                break;
            case 8:
                q0.M(cVar.getNumber(), (List) entry.getValue(), d02, cVar.f());
                break;
            case 9:
                q0.c0(cVar.getNumber(), (List) entry.getValue(), d02, cVar.f());
                break;
            case 10:
                q0.X(cVar.getNumber(), (List) entry.getValue(), d02, cVar.f());
                break;
            case 11:
                q0.Y(cVar.getNumber(), (List) entry.getValue(), d02, cVar.f());
                break;
            case 12:
                q0.Z(cVar.getNumber(), (List) entry.getValue(), d02, cVar.f());
                break;
            case 13:
                q0.a0(cVar.getNumber(), (List) entry.getValue(), d02, cVar.f());
                break;
            case 14:
                q0.U(cVar.getNumber(), (List) entry.getValue(), d02, cVar.f());
                break;
            case FirestoreIndexValueWriter.INDEX_TYPE_NUMBER /* 15 */:
                q0.N(cVar.getNumber(), (List) entry.getValue(), d02);
                break;
            case 16:
                q0.b0(cVar.getNumber(), (List) entry.getValue(), d02);
                break;
            case C1698D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                List list = (List) entry.getValue();
                if (list != null && !list.isEmpty()) {
                    q0.T(cVar.getNumber(), (List) entry.getValue(), d02, j0.a().c(list.get(0).getClass()));
                    break;
                }
                break;
            case C1698D.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                List list2 = (List) entry.getValue();
                if (list2 != null && !list2.isEmpty()) {
                    q0.W(cVar.getNumber(), (List) entry.getValue(), d02, j0.a().c(list2.get(0).getClass()));
                    break;
                }
                break;
        }
    }
}
