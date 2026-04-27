package v6;

import H6.f;
import H6.n;
import I6.AbstractC0645z;
import I6.B0;
import I6.D0;
import I6.E0;
import I6.M;
import I6.N0;
import I6.S;
import I6.Y;
import R5.InterfaceC0851h;
import R5.m0;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2489q;
import p5.AbstractC2592n;
import p5.r;

/* JADX INFO: renamed from: v6.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2881e {

    /* JADX INFO: renamed from: v6.e$a */
    public static final class a extends AbstractC0645z {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f23906d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(E0 e02, boolean z7) {
            super(e02);
            this.f23906d = z7;
        }

        @Override // I6.E0
        public boolean b() {
            return this.f23906d;
        }

        @Override // I6.AbstractC0645z, I6.E0
        public B0 e(S key) {
            AbstractC2304t.f(key, "key");
            B0 b0E = super.e(key);
            if (b0E == null) {
                return null;
            }
            InterfaceC0851h interfaceC0851hS = key.O0().s();
            return AbstractC2881e.c(b0E, interfaceC0851hS instanceof m0 ? (m0) interfaceC0851hS : null);
        }
    }

    public static final B0 c(B0 b02, m0 m0Var) {
        if (m0Var == null || b02.b() == N0.f4370e) {
            return b02;
        }
        if (m0Var.p() != b02.b()) {
            return new D0(e(b02));
        }
        if (!b02.c()) {
            return new D0(b02.getType());
        }
        n NO_LOCKS = f.f3979e;
        AbstractC2304t.e(NO_LOCKS, "NO_LOCKS");
        return new D0(new Y(NO_LOCKS, new C2880d(b02)));
    }

    public static final S d(B0 b02) {
        S type = b02.getType();
        AbstractC2304t.e(type, "getType(...)");
        return type;
    }

    public static final S e(B0 typeProjection) {
        AbstractC2304t.f(typeProjection, "typeProjection");
        return new C2877a(typeProjection, null, false, null, 14, null);
    }

    public static final boolean f(S s8) {
        AbstractC2304t.f(s8, "<this>");
        return s8.O0() instanceof InterfaceC2878b;
    }

    public static final E0 g(E0 e02, boolean z7) {
        AbstractC2304t.f(e02, "<this>");
        if (!(e02 instanceof M)) {
            return new a(e02, z7);
        }
        M m8 = (M) e02;
        m0[] m0VarArrJ = m8.j();
        List<C2489q> listA0 = AbstractC2592n.A0(m8.i(), m8.j());
        ArrayList arrayList = new ArrayList(r.s(listA0, 10));
        for (C2489q c2489q : listA0) {
            arrayList.add(c((B0) c2489q.c(), (m0) c2489q.d()));
        }
        return new M(m0VarArrJ, (B0[]) arrayList.toArray(new B0[0]), z7);
    }

    public static /* synthetic */ E0 h(E0 e02, boolean z7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            z7 = true;
        }
        return g(e02, z7);
    }
}
