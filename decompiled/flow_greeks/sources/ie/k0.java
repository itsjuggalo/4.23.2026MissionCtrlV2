package ie;

import fe.a;
import fe.a1;
import fe.b;
import fe.b1;
import fe.g1;
import fe.s1;
import fe.y0;
import fe.z0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import xf.d2;
import xf.f2;
import xf.m2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class k0 extends x0 implements y0 {
    public fe.w A;
    public fe.w B;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final fe.e0 f12369i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public fe.u f12370j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Collection f12371k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final y0 f12372l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b.a f12373m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f12374n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f12375o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f12376p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f12377q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f12378r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f12379s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public List f12380t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public b1 f12381u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public b1 f12382v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public List f12383w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public l0 f12384x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public a1 f12385y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f12386z;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public fe.m f12387a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public fe.e0 f12388b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public fe.u f12389c;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public b.a f12392f;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public b1 f12395i;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public ef.f f12397k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public xf.r0 f12398l;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public y0 f12390d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f12391e = false;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public d2 f12393g = d2.f24949b;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f12394h = true;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public List f12396j = null;

        public a() {
            this.f12387a = k0.this.b();
            this.f12388b = k0.this.l();
            this.f12389c = k0.this.getVisibility();
            this.f12392f = k0.this.h();
            this.f12395i = k0.this.f12381u;
            this.f12397k = k0.this.getName();
            this.f12398l = k0.this.getType();
        }

        public static /* synthetic */ void a(int i10) {
            String str = (i10 == 1 || i10 == 2 || i10 == 3 || i10 == 5 || i10 == 7 || i10 == 9 || i10 == 11 || i10 == 19 || i10 == 13 || i10 == 14 || i10 == 16 || i10 == 17) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i10 == 1 || i10 == 2 || i10 == 3 || i10 == 5 || i10 == 7 || i10 == 9 || i10 == 11 || i10 == 19 || i10 == 13 || i10 == 14 || i10 == 16 || i10 == 17) ? 2 : 3];
            switch (i10) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 13:
                case 14:
                case 16:
                case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                case 19:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
                    break;
                case 4:
                    objArr[0] = "type";
                    break;
                case 6:
                    objArr[0] = "modality";
                    break;
                case 8:
                    objArr[0] = "visibility";
                    break;
                case 10:
                    objArr[0] = "kind";
                    break;
                case 12:
                    objArr[0] = "typeParameters";
                    break;
                case 15:
                    objArr[0] = "substitution";
                    break;
                case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                    objArr[0] = "name";
                    break;
                default:
                    objArr[0] = "owner";
                    break;
            }
            if (i10 == 1) {
                objArr[1] = "setOwner";
            } else if (i10 == 2) {
                objArr[1] = "setOriginal";
            } else if (i10 == 3) {
                objArr[1] = "setPreserveSourceElement";
            } else if (i10 == 5) {
                objArr[1] = "setReturnType";
            } else if (i10 == 7) {
                objArr[1] = "setModality";
            } else if (i10 == 9) {
                objArr[1] = "setVisibility";
            } else if (i10 == 11) {
                objArr[1] = "setKind";
            } else if (i10 == 19) {
                objArr[1] = "setName";
            } else if (i10 == 13) {
                objArr[1] = "setTypeParameters";
            } else if (i10 == 14) {
                objArr[1] = "setDispatchReceiverParameter";
            } else if (i10 == 16) {
                objArr[1] = "setSubstitution";
            } else if (i10 != 17) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
            } else {
                objArr[1] = "setCopyOverrides";
            }
            switch (i10) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 13:
                case 14:
                case 16:
                case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                case 19:
                    break;
                case 4:
                    objArr[2] = "setReturnType";
                    break;
                case 6:
                    objArr[2] = "setModality";
                    break;
                case 8:
                    objArr[2] = "setVisibility";
                    break;
                case 10:
                    objArr[2] = "setKind";
                    break;
                case 12:
                    objArr[2] = "setTypeParameters";
                    break;
                case 15:
                    objArr[2] = "setSubstitution";
                    break;
                case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                    objArr[2] = "setName";
                    break;
                default:
                    objArr[2] = "setOwner";
                    break;
            }
            String str2 = String.format(str, objArr);
            if (i10 != 1 && i10 != 2 && i10 != 3 && i10 != 5 && i10 != 7 && i10 != 9 && i10 != 11 && i10 != 19 && i10 != 13 && i10 != 14 && i10 != 16 && i10 != 17) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        public y0 n() {
            return k0.this.Q0(this);
        }

        public z0 o() {
            y0 y0Var = this.f12390d;
            if (y0Var == null) {
                return null;
            }
            return y0Var.d();
        }

        public a1 p() {
            y0 y0Var = this.f12390d;
            if (y0Var == null) {
                return null;
            }
            return y0Var.g();
        }

        public a q(boolean z10) {
            this.f12394h = z10;
            return this;
        }

        public a r(b.a aVar) {
            if (aVar == null) {
                a(10);
            }
            this.f12392f = aVar;
            return this;
        }

        public a s(fe.e0 e0Var) {
            if (e0Var == null) {
                a(6);
            }
            this.f12388b = e0Var;
            return this;
        }

        public a t(fe.b bVar) {
            this.f12390d = (y0) bVar;
            return this;
        }

        public a u(fe.m mVar) {
            if (mVar == null) {
                a(0);
            }
            this.f12387a = mVar;
            return this;
        }

        public a v(d2 d2Var) {
            if (d2Var == null) {
                a(15);
            }
            this.f12393g = d2Var;
            return this;
        }

        public a w(fe.u uVar) {
            if (uVar == null) {
                a(8);
            }
            this.f12389c = uVar;
            return this;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(fe.m mVar, y0 y0Var, ge.h hVar, fe.e0 e0Var, fe.u uVar, boolean z10, ef.f fVar, b.a aVar, g1 g1Var, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
        super(mVar, hVar, fVar, null, z10, g1Var);
        if (mVar == null) {
            w(0);
        }
        if (hVar == null) {
            w(1);
        }
        if (e0Var == null) {
            w(2);
        }
        if (uVar == null) {
            w(3);
        }
        if (fVar == null) {
            w(4);
        }
        if (aVar == null) {
            w(5);
        }
        if (g1Var == null) {
            w(6);
        }
        this.f12371k = null;
        this.f12380t = Collections.EMPTY_LIST;
        this.f12369i = e0Var;
        this.f12370j = uVar;
        this.f12372l = y0Var == null ? this : y0Var;
        this.f12373m = aVar;
        this.f12374n = z11;
        this.f12375o = z12;
        this.f12376p = z13;
        this.f12377q = z14;
        this.f12378r = z15;
        this.f12379s = z16;
    }

    public static k0 O0(fe.m mVar, ge.h hVar, fe.e0 e0Var, fe.u uVar, boolean z10, ef.f fVar, b.a aVar, g1 g1Var, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
        if (mVar == null) {
            w(7);
        }
        if (hVar == null) {
            w(8);
        }
        if (e0Var == null) {
            w(9);
        }
        if (uVar == null) {
            w(10);
        }
        if (fVar == null) {
            w(11);
        }
        if (aVar == null) {
            w(12);
        }
        if (g1Var == null) {
            w(13);
        }
        return new k0(mVar, null, hVar, e0Var, uVar, z10, fVar, aVar, g1Var, z11, z12, z13, z14, z15, z16);
    }

    public static fe.z T0(f2 f2Var, fe.x0 x0Var) {
        if (f2Var == null) {
            w(30);
        }
        if (x0Var == null) {
            w(31);
        }
        if (x0Var.d0() != null) {
            return x0Var.d0().c(f2Var);
        }
        return null;
    }

    public static fe.u Y0(fe.u uVar, b.a aVar) {
        return (aVar == b.a.FAKE_OVERRIDE && fe.t.g(uVar.f())) ? fe.t.f9514h : uVar;
    }

    public static b1 d1(f2 f2Var, y0 y0Var, b1 b1Var) {
        xf.r0 r0VarP = f2Var.p(b1Var.getType(), m2.f25016f);
        if (r0VarP == null) {
            return null;
        }
        return new n0(y0Var, new rf.c(y0Var, r0VarP, ((rf.f) b1Var.getValue()).a(), b1Var.getValue()), b1Var.getAnnotations());
    }

    public static b1 e1(f2 f2Var, y0 y0Var, b1 b1Var) {
        xf.r0 r0VarP = f2Var.p(b1Var.getType(), m2.f25016f);
        if (r0VarP == null) {
            return null;
        }
        return new n0(y0Var, new rf.d(y0Var, r0VarP, b1Var.getValue()), b1Var.getAnnotations());
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static /* synthetic */ void w(int r11) {
        /*
            Method dump skipped, instruction units count: 538
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ie.k0.w(int):void");
    }

    @Override // fe.t1
    public boolean A() {
        return this.f12375o;
    }

    @Override // fe.d0
    public boolean E0() {
        return this.f12377q;
    }

    @Override // fe.d0
    public boolean N() {
        return this.f12376p;
    }

    @Override // fe.b
    /* JADX INFO: renamed from: N0, reason: merged with bridge method [inline-methods] */
    public y0 L(fe.m mVar, fe.e0 e0Var, fe.u uVar, b.a aVar, boolean z10) {
        y0 y0VarN = X0().u(mVar).t(null).s(e0Var).w(uVar).r(aVar).q(z10).n();
        if (y0VarN == null) {
            w(42);
        }
        return y0VarN;
    }

    public k0 P0(fe.m mVar, fe.e0 e0Var, fe.u uVar, y0 y0Var, b.a aVar, ef.f fVar, g1 g1Var) {
        if (mVar == null) {
            w(32);
        }
        if (e0Var == null) {
            w(33);
        }
        if (uVar == null) {
            w(34);
        }
        if (aVar == null) {
            w(35);
        }
        if (fVar == null) {
            w(36);
        }
        if (g1Var == null) {
            w(37);
        }
        return new k0(mVar, y0Var, getAnnotations(), e0Var, uVar, i0(), fVar, aVar, g1Var, q0(), A(), N(), E0(), isExternal(), Q());
    }

    @Override // fe.u1
    public boolean Q() {
        return this.f12379s;
    }

    public y0 Q0(a aVar) {
        b1 b1Var;
        Function0 function0;
        if (aVar == null) {
            w(29);
        }
        k0 k0VarP0 = P0(aVar.f12387a, aVar.f12388b, aVar.f12389c, aVar.f12390d, aVar.f12392f, aVar.f12397k, S0(aVar.f12391e, aVar.f12390d));
        List typeParameters = aVar.f12396j == null ? getTypeParameters() : aVar.f12396j;
        ArrayList arrayList = new ArrayList(typeParameters.size());
        f2 f2VarB = xf.c0.b(typeParameters, aVar.f12393g, k0VarP0, arrayList);
        xf.r0 r0Var = aVar.f12398l;
        xf.r0 r0VarP = f2VarB.p(r0Var, m2.f25017g);
        if (r0VarP == null) {
            return null;
        }
        xf.r0 r0VarP2 = f2VarB.p(r0Var, m2.f25016f);
        if (r0VarP2 != null) {
            k0VarP0.Z0(r0VarP2);
        }
        b1 b1Var2 = aVar.f12395i;
        if (b1Var2 != null) {
            b1 b1VarC = b1Var2.c(f2VarB);
            if (b1VarC == null) {
                return null;
            }
            b1Var = b1VarC;
        } else {
            b1Var = null;
        }
        b1 b1Var3 = this.f12382v;
        b1 b1VarE1 = b1Var3 != null ? e1(f2VarB, k0VarP0, b1Var3) : null;
        ArrayList arrayList2 = new ArrayList();
        Iterator it = this.f12380t.iterator();
        while (it.hasNext()) {
            b1 b1VarD1 = d1(f2VarB, k0VarP0, (b1) it.next());
            if (b1VarD1 != null) {
                arrayList2.add(b1VarD1);
            }
        }
        k0VarP0.b1(r0VarP, arrayList, b1Var, b1VarE1, arrayList2);
        l0 l0Var = this.f12384x == null ? null : new l0(k0VarP0, this.f12384x.getAnnotations(), aVar.f12388b, Y0(this.f12384x.getVisibility(), aVar.f12392f), this.f12384x.W(), this.f12384x.isExternal(), this.f12384x.isInline(), aVar.f12392f, aVar.o(), g1.f9483a);
        if (l0Var != null) {
            xf.r0 returnType = this.f12384x.getReturnType();
            l0Var.M0(T0(f2VarB, this.f12384x));
            l0Var.P0(returnType != null ? f2VarB.p(returnType, m2.f25017g) : null);
        }
        m0 m0Var = this.f12385y == null ? null : new m0(k0VarP0, this.f12385y.getAnnotations(), aVar.f12388b, Y0(this.f12385y.getVisibility(), aVar.f12392f), this.f12385y.W(), this.f12385y.isExternal(), this.f12385y.isInline(), aVar.f12392f, aVar.p(), g1.f9483a);
        if (m0Var != null) {
            List listP0 = s.P0(m0Var, this.f12385y.i(), f2VarB, false, false, null);
            if (listP0 == null) {
                k0VarP0.a1(true);
                listP0 = Collections.singletonList(m0.O0(m0Var, nf.e.m(aVar.f12387a).I(), ((s1) this.f12385y.i().get(0)).getAnnotations()));
            }
            if (listP0.size() != 1) {
                throw new IllegalStateException();
            }
            m0Var.M0(T0(f2VarB, this.f12385y));
            m0Var.Q0((s1) listP0.get(0));
        }
        fe.w wVar = this.A;
        r rVar = wVar == null ? null : new r(wVar.getAnnotations(), k0VarP0);
        fe.w wVar2 = this.B;
        k0VarP0.V0(l0Var, m0Var, rVar, wVar2 == null ? null : new r(wVar2.getAnnotations(), k0VarP0));
        if (aVar.f12394h) {
            hg.l lVarC = hg.l.c();
            Iterator it2 = f().iterator();
            while (it2.hasNext()) {
                lVarC.add(((y0) it2.next()).c(f2VarB));
            }
            k0VarP0.w0(lVarC);
        }
        if (A() && (function0 = this.f12507h) != null) {
            k0VarP0.K0(this.f12506g, function0);
        }
        return k0VarP0;
    }

    @Override // fe.y0
    /* JADX INFO: renamed from: R0, reason: merged with bridge method [inline-methods] */
    public l0 d() {
        return this.f12384x;
    }

    public final g1 S0(boolean z10, y0 y0Var) {
        g1 g1VarJ;
        if (z10) {
            if (y0Var == null) {
                y0Var = a();
            }
            g1VarJ = y0Var.j();
        } else {
            g1VarJ = g1.f9483a;
        }
        if (g1VarJ == null) {
            w(28);
        }
        return g1VarJ;
    }

    public void U0(l0 l0Var, a1 a1Var) {
        V0(l0Var, a1Var, null, null);
    }

    public void V0(l0 l0Var, a1 a1Var, fe.w wVar, fe.w wVar2) {
        this.f12384x = l0Var;
        this.f12385y = a1Var;
        this.A = wVar;
        this.B = wVar2;
    }

    public boolean W0() {
        return this.f12386z;
    }

    public a X0() {
        return new a();
    }

    public void Z0(xf.r0 r0Var) {
        if (r0Var == null) {
            w(14);
        }
    }

    public void a1(boolean z10) {
        this.f12386z = z10;
    }

    public void b1(xf.r0 r0Var, List list, b1 b1Var, b1 b1Var2, List list2) {
        if (r0Var == null) {
            w(17);
        }
        if (list == null) {
            w(18);
        }
        if (list2 == null) {
            w(19);
        }
        F0(r0Var);
        this.f12383w = new ArrayList(list);
        this.f12382v = b1Var2;
        this.f12381u = b1Var;
        this.f12380t = list2;
    }

    public void c1(fe.u uVar) {
        if (uVar == null) {
            w(20);
        }
        this.f12370j = uVar;
    }

    @Override // ie.w0, fe.a
    public b1 e0() {
        return this.f12381u;
    }

    @Override // fe.a
    public Collection f() {
        Collection collection = this.f12371k;
        if (collection == null) {
            collection = Collections.EMPTY_LIST;
        }
        if (collection == null) {
            w(41);
        }
        return collection;
    }

    @Override // fe.y0
    public a1 g() {
        return this.f12385y;
    }

    @Override // ie.w0, fe.a
    public xf.r0 getReturnType() {
        xf.r0 type = getType();
        if (type == null) {
            w(23);
        }
        return type;
    }

    @Override // ie.w0, fe.a
    public List getTypeParameters() {
        List list = this.f12383w;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("typeParameters == null for " + this);
    }

    @Override // fe.q
    public fe.u getVisibility() {
        fe.u uVar = this.f12370j;
        if (uVar == null) {
            w(25);
        }
        return uVar;
    }

    @Override // fe.b
    public b.a h() {
        b.a aVar = this.f12373m;
        if (aVar == null) {
            w(39);
        }
        return aVar;
    }

    @Override // fe.d0
    public boolean isExternal() {
        return this.f12378r;
    }

    @Override // ie.w0, fe.a
    public b1 k0() {
        return this.f12382v;
    }

    @Override // fe.d0
    public fe.e0 l() {
        fe.e0 e0Var = this.f12369i;
        if (e0Var == null) {
            w(24);
        }
        return e0Var;
    }

    @Override // fe.y0
    public fe.w l0() {
        return this.B;
    }

    @Override // fe.y0
    public fe.w o0() {
        return this.A;
    }

    @Override // fe.a
    public List p0() {
        List list = this.f12380t;
        if (list == null) {
            w(22);
        }
        return list;
    }

    @Override // fe.t1
    public boolean q0() {
        return this.f12374n;
    }

    @Override // fe.m
    public Object t0(fe.o oVar, Object obj) {
        return oVar.f(this, obj);
    }

    @Override // fe.b
    public void w0(Collection collection) {
        if (collection == null) {
            w(40);
        }
        this.f12371k = collection;
    }

    @Override // fe.y0
    public List x() {
        ArrayList arrayList = new ArrayList(2);
        l0 l0Var = this.f12384x;
        if (l0Var != null) {
            arrayList.add(l0Var);
        }
        a1 a1Var = this.f12385y;
        if (a1Var != null) {
            arrayList.add(a1Var);
        }
        return arrayList;
    }

    @Override // fe.a
    public Object z(a.InterfaceC0175a interfaceC0175a) {
        return null;
    }

    @Override // fe.i1
    public y0 c(f2 f2Var) {
        if (f2Var == null) {
            w(27);
        }
        return f2Var.k() ? this : X0().v(f2Var.j()).t(a()).n();
    }

    @Override // ie.n
    public y0 a() {
        y0 y0Var = this.f12372l;
        y0 y0VarA = y0Var == this ? this : y0Var.a();
        if (y0VarA == null) {
            w(38);
        }
        return y0VarA;
    }
}
