package R3;

import D3.A;
import D3.B;
import D3.C;
import D3.v;
import D3.w;
import D3.x;
import D3.y;
import D3.z;
import N3.I0;
import R3.a;
import R3.c;
import R3.d;
import R3.f;
import R3.h;
import R3.j;
import R3.n;
import android.text.TextUtils;
import com.google.firebase.inappmessaging.model.MessageType;
import java.util.Map;
import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes.dex */
public class k {

    public class a extends i {
        public a(e eVar, MessageType messageType, Map map) {
            super(eVar, messageType, map);
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7177a;

        static {
            int[] iArr = new int[z.b.values().length];
            f7177a = iArr;
            try {
                iArr[z.b.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7177a[z.b.IMAGE_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7177a[z.b.MODAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7177a[z.b.CARD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static a.b a(v vVar) {
        a.b bVarA = R3.a.a();
        if (!TextUtils.isEmpty(vVar.S())) {
            bVarA.b(vVar.S());
        }
        return bVarA;
    }

    public static R3.a b(v vVar, x xVar) {
        a.b bVarA = a(vVar);
        if (!xVar.equals(x.T())) {
            d.b bVarA2 = d.a();
            if (!TextUtils.isEmpty(xVar.S())) {
                bVarA2.b(xVar.S());
            }
            if (xVar.V()) {
                n.b bVarA3 = n.a();
                C cU = xVar.U();
                if (!TextUtils.isEmpty(cU.U())) {
                    bVarA3.c(cU.U());
                }
                if (!TextUtils.isEmpty(cU.T())) {
                    bVarA3.b(cU.T());
                }
                bVarA2.c(bVarA3.a());
            }
            bVarA.c(bVarA2.a());
        }
        return bVarA.a();
    }

    public static i c(z zVar, String str, String str2, boolean z7, Map map) {
        AbstractC2848n.o(zVar, "FirebaseInAppMessaging content cannot be null.");
        AbstractC2848n.o(str, "FirebaseInAppMessaging campaign id cannot be null.");
        AbstractC2848n.o(str2, "FirebaseInAppMessaging campaign name cannot be null.");
        I0.a("Decoding message: " + zVar.toString());
        e eVar = new e(str, str2, z7);
        int i8 = b.f7177a[zVar.W().ordinal()];
        return i8 != 1 ? i8 != 2 ? i8 != 3 ? i8 != 4 ? new a(new e(str, str2, z7), MessageType.UNSUPPORTED, map) : f(zVar.T()).a(eVar, map) : h(zVar.X()).a(eVar, map) : g(zVar.V()).a(eVar, map) : e(zVar.S()).a(eVar, map);
    }

    public static n d(C c8) {
        n.b bVarA = n.a();
        if (!TextUtils.isEmpty(c8.T())) {
            bVarA.b(c8.T());
        }
        if (!TextUtils.isEmpty(c8.U())) {
            bVarA.c(c8.U());
        }
        return bVarA.a();
    }

    public static c.b e(w wVar) {
        c.b bVarD = c.d();
        if (!TextUtils.isEmpty(wVar.T())) {
            bVarD.c(wVar.T());
        }
        if (!TextUtils.isEmpty(wVar.W())) {
            bVarD.e(g.a().b(wVar.W()).a());
        }
        if (wVar.Y()) {
            bVarD.b(a(wVar.S()).a());
        }
        if (wVar.Z()) {
            bVarD.d(d(wVar.U()));
        }
        if (wVar.a0()) {
            bVarD.f(d(wVar.X()));
        }
        return bVarD;
    }

    public static f.b f(y yVar) {
        f.b bVarD = f.d();
        if (yVar.h0()) {
            bVarD.h(d(yVar.b0()));
        }
        if (yVar.c0()) {
            bVarD.c(d(yVar.T()));
        }
        if (!TextUtils.isEmpty(yVar.S())) {
            bVarD.b(yVar.S());
        }
        if (yVar.d0() || yVar.e0()) {
            bVarD.f(b(yVar.X(), yVar.Y()));
        }
        if (yVar.f0() || yVar.g0()) {
            bVarD.g(b(yVar.Z(), yVar.a0()));
        }
        if (!TextUtils.isEmpty(yVar.W())) {
            bVarD.e(g.a().b(yVar.W()).a());
        }
        if (!TextUtils.isEmpty(yVar.V())) {
            bVarD.d(g.a().b(yVar.V()).a());
        }
        return bVarD;
    }

    public static h.b g(A a8) {
        h.b bVarD = h.d();
        if (!TextUtils.isEmpty(a8.U())) {
            bVarD.c(g.a().b(a8.U()).a());
        }
        if (a8.V()) {
            bVarD.b(a(a8.S()).a());
        }
        return bVarD;
    }

    public static j.b h(B b8) {
        j.b bVarD = j.d();
        if (!TextUtils.isEmpty(b8.U())) {
            bVarD.c(b8.U());
        }
        if (!TextUtils.isEmpty(b8.X())) {
            bVarD.e(g.a().b(b8.X()).a());
        }
        if (b8.Z()) {
            bVarD.b(b(b8.S(), b8.T()));
        }
        if (b8.a0()) {
            bVarD.d(d(b8.V()));
        }
        if (b8.b0()) {
            bVarD.f(d(b8.Y()));
        }
        return bVarD;
    }
}
