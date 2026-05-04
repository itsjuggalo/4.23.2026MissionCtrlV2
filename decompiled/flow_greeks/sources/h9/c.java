package h9;

import bb.d0;
import bb.u;
import com.google.android.gms.common.api.a;
import com.google.protobuf.s1;
import j9.t;
import j9.y;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f11244a = new c();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11245a;

        static {
            int[] iArr = new int[d0.c.values().length];
            f11245a = iArr;
            try {
                iArr[d0.c.NULL_VALUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11245a[d0.c.BOOLEAN_VALUE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11245a[d0.c.DOUBLE_VALUE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11245a[d0.c.INTEGER_VALUE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11245a[d0.c.TIMESTAMP_VALUE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f11245a[d0.c.STRING_VALUE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f11245a[d0.c.BYTES_VALUE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f11245a[d0.c.REFERENCE_VALUE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f11245a[d0.c.GEO_POINT_VALUE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f11245a[d0.c.MAP_VALUE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f11245a[d0.c.ARRAY_VALUE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public final void a(bb.b bVar, b bVar2) {
        j(bVar2, 50);
        Iterator it = bVar.h().iterator();
        while (it.hasNext()) {
            f((d0) it.next(), bVar2);
        }
    }

    public final void b(String str, b bVar) {
        j(bVar, 37);
        t tVarB = t.B(str);
        int iU = tVarB.u();
        for (int i10 = 5; i10 < iU; i10++) {
            String strO = tVarB.o(i10);
            j(bVar, 60);
            i(strO, bVar);
        }
    }

    public final void c(u uVar, b bVar) {
        j(bVar, 55);
        for (Map.Entry entry : uVar.d0().entrySet()) {
            String str = (String) entry.getKey();
            d0 d0Var = (d0) entry.getValue();
            d(str, bVar);
            f(d0Var, bVar);
        }
    }

    public final void d(String str, b bVar) {
        j(bVar, 25);
        i(str, bVar);
    }

    public void e(d0 d0Var, b bVar) {
        f(d0Var, bVar);
        bVar.c();
    }

    public final void f(d0 d0Var, b bVar) {
        switch (a.f11245a[d0Var.w0().ordinal()]) {
            case 1:
                j(bVar, 5);
                return;
            case 2:
                j(bVar, 10);
                bVar.d(d0Var.m0() ? 1L : 0L);
                return;
            case 3:
                double dP0 = d0Var.p0();
                if (Double.isNaN(dP0)) {
                    j(bVar, 13);
                    return;
                }
                j(bVar, 15);
                if (dP0 == -0.0d) {
                    bVar.b(0.0d);
                    return;
                } else {
                    bVar.b(dP0);
                    return;
                }
            case 4:
                j(bVar, 15);
                bVar.b(d0Var.r0());
                return;
            case 5:
                s1 s1VarV0 = d0Var.v0();
                j(bVar, 20);
                bVar.d(s1VarV0.e0());
                bVar.d(s1VarV0.d0());
                return;
            case 6:
                d(d0Var.u0(), bVar);
                h(bVar);
                return;
            case 7:
                j(bVar, 30);
                bVar.a(d0Var.n0());
                h(bVar);
                return;
            case 8:
                b(d0Var.t0(), bVar);
                return;
            case 9:
                kb.a aVarQ0 = d0Var.q0();
                j(bVar, 45);
                bVar.b(aVarQ0.d0());
                bVar.b(aVarQ0.e0());
                return;
            case 10:
                if (y.y(d0Var)) {
                    j(bVar, a.e.API_PRIORITY_OTHER);
                    return;
                } else if (y.D(d0Var)) {
                    g(d0Var.s0(), bVar);
                    return;
                } else {
                    c(d0Var.s0(), bVar);
                    h(bVar);
                    return;
                }
            case 11:
                a(d0Var.l0(), bVar);
                h(bVar);
                return;
            default:
                throw new IllegalArgumentException("unknown index value type " + d0Var.w0());
        }
    }

    public final void g(u uVar, b bVar) {
        Map mapD0 = uVar.d0();
        j(bVar, 53);
        int iI0 = ((d0) mapD0.get("value")).l0().i0();
        j(bVar, 15);
        bVar.d(iI0);
        d("value", bVar);
        f((d0) mapD0.get("value"), bVar);
    }

    public final void h(b bVar) {
        bVar.d(2L);
    }

    public final void i(String str, b bVar) {
        bVar.e(str);
    }

    public final void j(b bVar, int i10) {
        bVar.d(i10);
    }
}
