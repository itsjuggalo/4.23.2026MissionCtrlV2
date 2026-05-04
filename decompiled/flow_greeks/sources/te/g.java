package te;

import cd.o;
import fe.l1;
import java.util.List;
import kotlin.jvm.internal.t;
import xf.a2;
import xf.c2;
import xf.f0;
import xf.g0;
import xf.i2;
import xf.m2;
import xf.r0;
import xf.z1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends f0 {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21917a;

        static {
            int[] iArr = new int[c.values().length];
            try {
                iArr[c.f21904c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[c.f21903b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[c.f21902a.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f21917a = iArr;
        }
    }

    @Override // xf.f0
    public a2 a(l1 parameter, g0 typeAttr, z1 typeParameterUpperBoundEraser, r0 erasedUpperBound) {
        t.f(parameter, "parameter");
        t.f(typeAttr, "typeAttr");
        t.f(typeParameterUpperBoundEraser, "typeParameterUpperBoundEraser");
        t.f(erasedUpperBound, "erasedUpperBound");
        if (!(typeAttr instanceof te.a)) {
            return super.a(parameter, typeAttr, typeParameterUpperBoundEraser, erasedUpperBound);
        }
        te.a aVarL = (te.a) typeAttr;
        if (!aVarL.i()) {
            aVarL = aVarL.l(c.f21902a);
        }
        int i10 = a.f21917a[aVarL.g().ordinal()];
        if (i10 == 1) {
            return new c2(m2.f25015e, erasedUpperBound);
        }
        if (i10 != 2 && i10 != 3) {
            throw new o();
        }
        if (!parameter.o().b()) {
            return new c2(m2.f25015e, nf.e.m(parameter).I());
        }
        List parameters = erasedUpperBound.N0().getParameters();
        t.e(parameters, "getParameters(...)");
        if (!parameters.isEmpty()) {
            return new c2(m2.f25017g, erasedUpperBound);
        }
        a2 a2VarT = i2.t(parameter, aVarL);
        t.c(a2VarT);
        return a2VarT;
    }
}
