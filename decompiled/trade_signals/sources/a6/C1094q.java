package a6;

import I6.A0;
import R5.InterfaceC0844a;
import R5.InterfaceC0848e;
import R5.c0;
import R5.g0;
import R5.t0;
import c6.C1261e;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2595q;
import u6.C2800o;
import u6.InterfaceC2795j;

/* JADX INFO: renamed from: a6.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1094q implements InterfaceC2795j {

    /* JADX INFO: renamed from: a6.q$a */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10152a;

        static {
            int[] iArr = new int[C2800o.i.a.values().length];
            try {
                iArr[C2800o.i.a.OVERRIDABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f10152a = iArr;
        }
    }

    public static final I6.S d(t0 t0Var) {
        return t0Var.getType();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // u6.InterfaceC2795j
    public InterfaceC2795j.b a(InterfaceC0844a superDescriptor, InterfaceC0844a subDescriptor, InterfaceC0848e interfaceC0848e) {
        AbstractC2304t.f(superDescriptor, "superDescriptor");
        AbstractC2304t.f(subDescriptor, "subDescriptor");
        if (subDescriptor instanceof C1261e) {
            C1261e c1261e = (C1261e) subDescriptor;
            AbstractC2304t.e(c1261e.getTypeParameters(), "getTypeParameters(...)");
            int i8 = 1;
            if (!(!r0.isEmpty())) {
                C2800o.i iVarW = C2800o.w(superDescriptor, subDescriptor);
                A0 a02 = null;
                Object[] objArr = 0;
                if ((iVarW != null ? iVarW.c() : null) != null) {
                    return InterfaceC2795j.b.UNKNOWN;
                }
                List listK = c1261e.k();
                AbstractC2304t.e(listK, "getValueParameters(...)");
                U6.h hVarB = U6.r.B(p5.z.P(listK), C1093p.f10151a);
                I6.S returnType = c1261e.getReturnType();
                AbstractC2304t.c(returnType);
                U6.h hVarF = U6.r.F(hVarB, returnType);
                c0 c0VarL0 = c1261e.l0();
                for (I6.S s8 : U6.r.E(hVarF, AbstractC2595q.m(c0VarL0 != null ? c0VarL0.getType() : null))) {
                    if ((!s8.M0().isEmpty()) && !(s8.R0() instanceof f6.k)) {
                        return InterfaceC2795j.b.UNKNOWN;
                    }
                }
                InterfaceC0844a interfaceC0844aA = (InterfaceC0844a) superDescriptor.c(new f6.i(a02, i8, objArr == true ? 1 : 0).c());
                if (interfaceC0844aA == null) {
                    return InterfaceC2795j.b.UNKNOWN;
                }
                if (interfaceC0844aA instanceof g0) {
                    g0 g0Var = (g0) interfaceC0844aA;
                    AbstractC2304t.e(g0Var.getTypeParameters(), "getTypeParameters(...)");
                    if (!r0.isEmpty()) {
                        interfaceC0844aA = g0Var.u().n(AbstractC2595q.i()).a();
                        AbstractC2304t.c(interfaceC0844aA);
                    }
                }
                C2800o.i.a aVarC = C2800o.f23551f.F(interfaceC0844aA, subDescriptor, false).c();
                AbstractC2304t.e(aVarC, "getResult(...)");
                return a.f10152a[aVarC.ordinal()] == 1 ? InterfaceC2795j.b.OVERRIDABLE : InterfaceC2795j.b.UNKNOWN;
            }
        }
        return InterfaceC2795j.b.UNKNOWN;
    }

    @Override // u6.InterfaceC2795j
    public InterfaceC2795j.a b() {
        return InterfaceC2795j.a.SUCCESS_ONLY;
    }
}
