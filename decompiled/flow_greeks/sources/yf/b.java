package yf;

import ce.o;
import fe.f0;
import fe.k1;
import fe.l1;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.n0;
import xf.a2;
import xf.b1;
import xf.c1;
import xf.f1;
import xf.f2;
import xf.g2;
import xf.i0;
import xf.i2;
import xf.l2;
import xf.m2;
import xf.q0;
import xf.r0;
import xf.t1;
import xf.u0;
import xf.u1;
import xf.v0;
import xf.v1;
import xf.z0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public interface b extends g2, bg.r {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: yf.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0474a extends t1.c.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f25400a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ f2 f25401b;

            public C0474a(b bVar, f2 f2Var) {
                this.f25400a = bVar;
                this.f25401b = f2Var;
            }

            @Override // xf.t1.c
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public bg.k a(t1 state, bg.i type) {
                kotlin.jvm.internal.t.f(state, "state");
                kotlin.jvm.internal.t.f(type, "type");
                b bVar = this.f25400a;
                f2 f2Var = this.f25401b;
                Object objM = bVar.m(type);
                kotlin.jvm.internal.t.d(objM, "null cannot be cast to non-null type org.jetbrains.kotlin.types.KotlinType");
                r0 r0VarN = f2Var.n((r0) objM, m2.f25015e);
                kotlin.jvm.internal.t.e(r0VarN, "safeSubstitute(...)");
                bg.k kVarH = bVar.h((bg.i) r0VarN);
                kotlin.jvm.internal.t.c(kVarH);
                return kVarH;
            }
        }

        public static boolean A(b bVar, bg.i receiver, ef.c fqName) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            kotlin.jvm.internal.t.f(fqName, "fqName");
            if (receiver instanceof r0) {
                return ((r0) receiver).getAnnotations().E(fqName);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static boolean B(b bVar, bg.o receiver, bg.n nVar) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (!(receiver instanceof l1)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
            }
            l1 l1Var = (l1) receiver;
            if (nVar == null ? true : nVar instanceof u1) {
                return cg.d.r(l1Var, (u1) nVar, null, 4, null);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + l1Var + ", " + n0.b(l1Var.getClass())).toString());
        }

        public static boolean C(b bVar, bg.j a10, bg.j b10) {
            kotlin.jvm.internal.t.f(a10, "a");
            kotlin.jvm.internal.t.f(b10, "b");
            if (!(a10 instanceof c1)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + a10 + ", " + n0.b(a10.getClass())).toString());
            }
            if (b10 instanceof c1) {
                return ((c1) a10).L0() == ((c1) b10).L0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + b10 + ", " + n0.b(b10.getClass())).toString());
        }

        public static bg.i D(b bVar, Collection types) {
            kotlin.jvm.internal.t.f(types, "types");
            return d.a(types);
        }

        public static boolean E(b bVar, bg.n receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof u1) {
                return ce.i.x0((u1) receiver, o.a.f3975b);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static boolean F(b bVar, bg.n receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof u1) {
                return ((u1) receiver).b() instanceof fe.e;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static boolean G(b bVar, bg.n receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof u1) {
                fe.h hVarB = ((u1) receiver).b();
                fe.e eVar = hVarB instanceof fe.e ? (fe.e) hVarB : null;
                return (eVar == null || !f0.a(eVar) || eVar.h() == fe.f.f9476e || eVar.h() == fe.f.f9477f) ? false : true;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static boolean H(b bVar, bg.n receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof u1) {
                return ((u1) receiver).d();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static boolean I(b bVar, bg.i receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof r0) {
                return v0.a((r0) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static boolean J(b bVar, bg.n receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof u1) {
                fe.h hVarB = ((u1) receiver).b();
                fe.e eVar = hVarB instanceof fe.e ? (fe.e) hVarB : null;
                return (eVar != null ? eVar.y0() : null) instanceof fe.a0;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static boolean K(b bVar, bg.n receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof u1) {
                return receiver instanceof lf.q;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static boolean L(b bVar, bg.n receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof u1) {
                return receiver instanceof q0;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static boolean M(b bVar) {
            return false;
        }

        public static boolean N(b bVar, bg.i receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            return (receiver instanceof c1) && ((c1) receiver).O0();
        }

        public static boolean O(b bVar, bg.i receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            return receiver instanceof z0;
        }

        public static boolean P(b bVar, bg.n receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof u1) {
                return ce.i.x0((u1) receiver, o.a.f3977c);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static boolean Q(b bVar, bg.i receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof r0) {
                return i2.l((r0) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static boolean R(b bVar, bg.d receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            return receiver instanceof kf.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean S(b bVar, bg.k receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof r0) {
                return ce.i.t0((r0) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static boolean T(b bVar, bg.d receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof i) {
                return ((i) receiver).Z0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static boolean U(b bVar, bg.i receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof r0) {
                return receiver instanceof b1;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean V(b bVar, bg.j receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof c1) {
                if (v0.a((r0) receiver)) {
                    return false;
                }
                c1 c1Var = (c1) receiver;
                if (c1Var.N0().b() instanceof k1) {
                    return false;
                }
                return c1Var.N0().b() != null || (receiver instanceof kf.a) || (receiver instanceof i) || (receiver instanceof xf.y) || (c1Var.N0() instanceof lf.q) || W(bVar, (bg.k) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static boolean W(b bVar, bg.k kVar) {
            return (kVar instanceof f1) && bVar.b(((f1) kVar).F0());
        }

        public static boolean X(b bVar, bg.m receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof a2) {
                return ((a2) receiver).c();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean Y(b bVar, bg.j receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof c1) {
                return cg.d.u((r0) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean Z(b bVar, bg.j receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof c1) {
                return cg.d.v((r0) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static boolean a(b bVar, bg.n c12, bg.n c22) {
            kotlin.jvm.internal.t.f(c12, "c1");
            kotlin.jvm.internal.t.f(c22, "c2");
            if (!(c12 instanceof u1)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + c12 + ", " + n0.b(c12.getClass())).toString());
            }
            if (c22 instanceof u1) {
                return kotlin.jvm.internal.t.b(c12, c22);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + c22 + ", " + n0.b(c22.getClass())).toString());
        }

        public static boolean a0(b bVar, bg.i receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (!(receiver instanceof l2)) {
                return false;
            }
            ((l2) receiver).N0();
            return false;
        }

        public static int b(b bVar, bg.i receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof r0) {
                return ((r0) receiver).L0().size();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static boolean b0(b bVar, bg.n receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof u1) {
                fe.h hVarB = ((u1) receiver).b();
                return hVarB != null && ce.i.C0(hVarB);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static bg.l c(b bVar, bg.j receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof c1) {
                return (bg.l) receiver;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static bg.k c0(b bVar, bg.g receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof i0) {
                return ((i0) receiver).V0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static bg.d d(b bVar, bg.k receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof c1) {
                if (receiver instanceof f1) {
                    return bVar.g(((f1) receiver).F0());
                }
                if (receiver instanceof i) {
                    return (i) receiver;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static bg.i d0(b bVar, bg.d receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof i) {
                return ((i) receiver).Y0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static bg.e e(b bVar, bg.j receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof c1) {
                if (receiver instanceof xf.y) {
                    return (xf.y) receiver;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static bg.i e0(b bVar, bg.i receiver, boolean z10) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof l2) {
                return c.b((l2) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static bg.f f(b bVar, bg.g receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof i0) {
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static t1 f0(b bVar, boolean z10, boolean z11) {
            return yf.a.b(z10, z11, bVar, null, null, 24, null);
        }

        public static bg.g g(b bVar, bg.i receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof r0) {
                l2 l2VarQ0 = ((r0) receiver).Q0();
                if (l2VarQ0 instanceof i0) {
                    return (i0) l2VarQ0;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static bg.k g0(b bVar, bg.e receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof xf.y) {
                return ((xf.y) receiver).Z0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static bg.k h(b bVar, bg.i receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof r0) {
                l2 l2VarQ0 = ((r0) receiver).Q0();
                if (l2VarQ0 instanceof c1) {
                    return (c1) l2VarQ0;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static int h0(b bVar, bg.n receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof u1) {
                return ((u1) receiver).getParameters().size();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static bg.m i(b bVar, bg.i receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof r0) {
                return cg.d.d((r0) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static Collection i0(b bVar, bg.j receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            bg.n nVarF = bVar.f(receiver);
            if (nVarF instanceof lf.q) {
                return ((lf.q) nVarF).j();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static c1 j(b bVar, bg.j type, bg.b status) {
            kotlin.jvm.internal.t.f(type, "type");
            kotlin.jvm.internal.t.f(status, "status");
            if (type instanceof c1) {
                return o.b((c1) type, status);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + type + ", " + n0.b(type.getClass())).toString());
        }

        public static bg.m j0(b bVar, bg.c receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof n) {
                return ((n) receiver).e();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static bg.b k(b bVar, bg.d receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof i) {
                return ((i) receiver).W0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static t1.c k0(b bVar, bg.j type) {
            kotlin.jvm.internal.t.f(type, "type");
            if (type instanceof c1) {
                return new C0474a(bVar, v1.f25085c.a((r0) type).c());
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + type + ", " + n0.b(type.getClass())).toString());
        }

        public static bg.i l(b bVar, bg.j lowerBound, bg.j upperBound) {
            kotlin.jvm.internal.t.f(lowerBound, "lowerBound");
            kotlin.jvm.internal.t.f(upperBound, "upperBound");
            if (!(lowerBound instanceof c1)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + bVar + ", " + n0.b(bVar.getClass())).toString());
            }
            if (upperBound instanceof c1) {
                return u0.e((c1) lowerBound, (c1) upperBound);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + bVar + ", " + n0.b(bVar.getClass())).toString());
        }

        public static Collection l0(b bVar, bg.n receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof u1) {
                Collection collectionC = ((u1) receiver).c();
                kotlin.jvm.internal.t.e(collectionC, "getSupertypes(...)");
                return collectionC;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static bg.m m(b bVar, bg.i receiver, int i10) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof r0) {
                return (bg.m) ((r0) receiver).L0().get(i10);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static bg.c m0(b bVar, bg.d receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof i) {
                return ((i) receiver).N0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static List n(b bVar, bg.i receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof r0) {
                return ((r0) receiver).L0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static bg.n n0(b bVar, bg.j receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof c1) {
                return ((c1) receiver).N0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static ef.d o(b bVar, bg.n receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof u1) {
                fe.h hVarB = ((u1) receiver).b();
                kotlin.jvm.internal.t.d(hVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                return nf.e.p((fe.e) hVarB);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static bg.k o0(b bVar, bg.g receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof i0) {
                return ((i0) receiver).W0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static bg.o p(b bVar, bg.n receiver, int i10) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof u1) {
                Object obj = ((u1) receiver).getParameters().get(i10);
                kotlin.jvm.internal.t.e(obj, "get(...)");
                return (bg.o) obj;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static bg.i p0(b bVar, bg.i receiver, boolean z10) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof bg.j) {
                return bVar.a((bg.j) receiver, z10);
            }
            if (!(receiver instanceof bg.g)) {
                throw new IllegalStateException("sealed");
            }
            bg.g gVar = (bg.g) receiver;
            return bVar.B0(bVar.a((bg.j) bVar.d(gVar), z10), bVar.a((bg.j) bVar.e(gVar), z10));
        }

        public static List q(b bVar, bg.n receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof u1) {
                List parameters = ((u1) receiver).getParameters();
                kotlin.jvm.internal.t.e(parameters, "getParameters(...)");
                return parameters;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static bg.k q0(b bVar, bg.j receiver, boolean z10) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof c1) {
                return ((c1) receiver).R0(z10);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static ce.l r(b bVar, bg.n receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof u1) {
                fe.h hVarB = ((u1) receiver).b();
                kotlin.jvm.internal.t.d(hVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                return ce.i.Q((fe.e) hVarB);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static ce.l s(b bVar, bg.n receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof u1) {
                fe.h hVarB = ((u1) receiver).b();
                kotlin.jvm.internal.t.d(hVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                return ce.i.T((fe.e) hVarB);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static bg.i t(b bVar, bg.o receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof l1) {
                return cg.d.o((l1) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static bg.i u(b bVar, bg.m receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (bVar.c(receiver)) {
                return null;
            }
            if (receiver instanceof a2) {
                return ((a2) receiver).getType().Q0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static bg.o v(b bVar, bg.n receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof u1) {
                fe.h hVarB = ((u1) receiver).b();
                if (hVarB instanceof l1) {
                    return (l1) hVarB;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static bg.i w(b bVar, bg.i receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof r0) {
                return jf.k.k((r0) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static List x(b bVar, bg.o receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof l1) {
                List upperBounds = ((l1) receiver).getUpperBounds();
                kotlin.jvm.internal.t.e(upperBounds, "getUpperBounds(...)");
                return upperBounds;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static bg.t y(b bVar, bg.m receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof a2) {
                m2 m2VarB = ((a2) receiver).b();
                kotlin.jvm.internal.t.e(m2VarB, "getProjectionKind(...)");
                return bg.q.a(m2VarB);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }

        public static bg.t z(b bVar, bg.o receiver) {
            kotlin.jvm.internal.t.f(receiver, "$receiver");
            if (receiver instanceof l1) {
                m2 m2VarO = ((l1) receiver).o();
                kotlin.jvm.internal.t.e(m2VarO, "getVariance(...)");
                return bg.q.a(m2VarO);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.b(receiver.getClass())).toString());
        }
    }

    bg.i B0(bg.j jVar, bg.j jVar2);

    @Override // bg.p
    bg.k a(bg.j jVar, boolean z10);

    @Override // bg.p
    boolean b(bg.j jVar);

    @Override // bg.p
    boolean c(bg.m mVar);

    @Override // bg.p
    bg.k d(bg.g gVar);

    @Override // bg.p
    bg.k e(bg.g gVar);

    @Override // bg.p
    bg.n f(bg.j jVar);

    @Override // bg.p
    bg.d g(bg.k kVar);

    @Override // bg.p
    bg.k h(bg.i iVar);
}
