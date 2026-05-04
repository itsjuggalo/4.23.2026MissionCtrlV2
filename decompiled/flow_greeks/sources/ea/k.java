package ea;

import aa.h2;
import android.text.TextUtils;
import com.google.firebase.inappmessaging.model.MessageType;
import ea.a;
import ea.c;
import ea.d;
import ea.f;
import ea.h;
import ea.j;
import ea.n;
import java.util.Map;
import q9.a0;
import q9.b0;
import q9.c0;
import q9.v;
import q9.w;
import q9.x;
import q9.y;
import q9.z;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends i {
        public a(e eVar, MessageType messageType, Map map) {
            super(eVar, messageType, map);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8610a;

        static {
            int[] iArr = new int[z.b.values().length];
            f8610a = iArr;
            try {
                iArr[z.b.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8610a[z.b.IMAGE_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8610a[z.b.MODAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8610a[z.b.CARD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static a.b a(v vVar) {
        a.b bVarA = ea.a.a();
        if (!TextUtils.isEmpty(vVar.a0())) {
            bVarA.b(vVar.a0());
        }
        return bVarA;
    }

    public static ea.a b(v vVar, x xVar) {
        a.b bVarA = a(vVar);
        if (!xVar.equals(x.b0())) {
            d.b bVarA2 = d.a();
            if (!TextUtils.isEmpty(xVar.a0())) {
                bVarA2.b(xVar.a0());
            }
            if (xVar.d0()) {
                n.b bVarA3 = n.a();
                c0 c0VarC0 = xVar.c0();
                if (!TextUtils.isEmpty(c0VarC0.c0())) {
                    bVarA3.c(c0VarC0.c0());
                }
                if (!TextUtils.isEmpty(c0VarC0.b0())) {
                    bVarA3.b(c0VarC0.b0());
                }
                bVarA2.c(bVarA3.a());
            }
            bVarA.c(bVarA2.a());
        }
        return bVarA.a();
    }

    public static i c(z zVar, String str, String str2, boolean z10, Map map) {
        p6.n.o(zVar, "FirebaseInAppMessaging content cannot be null.");
        p6.n.o(str, "FirebaseInAppMessaging campaign id cannot be null.");
        p6.n.o(str2, "FirebaseInAppMessaging campaign name cannot be null.");
        h2.a("Decoding message: " + zVar.toString());
        e eVar = new e(str, str2, z10);
        int i10 = b.f8610a[zVar.e0().ordinal()];
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? new a(new e(str, str2, z10), MessageType.UNSUPPORTED, map) : f(zVar.b0()).a(eVar, map) : h(zVar.f0()).a(eVar, map) : g(zVar.d0()).a(eVar, map) : e(zVar.a0()).a(eVar, map);
    }

    public static n d(c0 c0Var) {
        n.b bVarA = n.a();
        if (!TextUtils.isEmpty(c0Var.b0())) {
            bVarA.b(c0Var.b0());
        }
        if (!TextUtils.isEmpty(c0Var.c0())) {
            bVarA.c(c0Var.c0());
        }
        return bVarA.a();
    }

    public static c.b e(w wVar) {
        c.b bVarD = c.d();
        if (!TextUtils.isEmpty(wVar.b0())) {
            bVarD.c(wVar.b0());
        }
        if (!TextUtils.isEmpty(wVar.e0())) {
            bVarD.e(g.a().b(wVar.e0()).a());
        }
        if (wVar.g0()) {
            bVarD.b(a(wVar.a0()).a());
        }
        if (wVar.h0()) {
            bVarD.d(d(wVar.c0()));
        }
        if (wVar.i0()) {
            bVarD.f(d(wVar.f0()));
        }
        return bVarD;
    }

    public static f.b f(y yVar) {
        f.b bVarD = f.d();
        if (yVar.p0()) {
            bVarD.h(d(yVar.j0()));
        }
        if (yVar.k0()) {
            bVarD.c(d(yVar.b0()));
        }
        if (!TextUtils.isEmpty(yVar.a0())) {
            bVarD.b(yVar.a0());
        }
        if (yVar.l0() || yVar.m0()) {
            bVarD.f(b(yVar.f0(), yVar.g0()));
        }
        if (yVar.n0() || yVar.o0()) {
            bVarD.g(b(yVar.h0(), yVar.i0()));
        }
        if (!TextUtils.isEmpty(yVar.e0())) {
            bVarD.e(g.a().b(yVar.e0()).a());
        }
        if (!TextUtils.isEmpty(yVar.d0())) {
            bVarD.d(g.a().b(yVar.d0()).a());
        }
        return bVarD;
    }

    public static h.b g(a0 a0Var) {
        h.b bVarD = h.d();
        if (!TextUtils.isEmpty(a0Var.c0())) {
            bVarD.c(g.a().b(a0Var.c0()).a());
        }
        if (a0Var.d0()) {
            bVarD.b(a(a0Var.a0()).a());
        }
        return bVarD;
    }

    public static j.b h(b0 b0Var) {
        j.b bVarD = j.d();
        if (!TextUtils.isEmpty(b0Var.c0())) {
            bVarD.c(b0Var.c0());
        }
        if (!TextUtils.isEmpty(b0Var.f0())) {
            bVarD.e(g.a().b(b0Var.f0()).a());
        }
        if (b0Var.h0()) {
            bVarD.b(b(b0Var.a0(), b0Var.b0()));
        }
        if (b0Var.i0()) {
            bVarD.d(d(b0Var.d0()));
        }
        if (b0Var.j0()) {
            bVarD.f(d(b0Var.g0()));
        }
        return bVarD;
    }
}
