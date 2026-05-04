package ge;

import cd.w;
import ce.o;
import com.google.firebase.analytics.FirebaseAnalytics;
import dd.o0;
import fe.h0;
import io.flutter.plugins.firebase.database.Constants;
import kotlin.jvm.internal.t;
import lf.x;
import xf.c1;
import xf.m2;
import xf.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ef.f f10552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ef.f f10553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ef.f f10554c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ef.f f10555d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ef.f f10556e;

    static {
        ef.f fVarK = ef.f.k(Constants.ERROR_MESSAGE);
        t.e(fVarK, "identifier(...)");
        f10552a = fVarK;
        ef.f fVarK2 = ef.f.k("replaceWith");
        t.e(fVarK2, "identifier(...)");
        f10553b = fVarK2;
        ef.f fVarK3 = ef.f.k(FirebaseAnalytics.Param.LEVEL);
        t.e(fVarK3, "identifier(...)");
        f10554c = fVarK3;
        ef.f fVarK4 = ef.f.k("expression");
        t.e(fVarK4, "identifier(...)");
        f10555d = fVarK4;
        ef.f fVarK5 = ef.f.k("imports");
        t.e(fVarK5, "identifier(...)");
        f10556e = fVarK5;
    }

    public static final c b(ce.i iVar, String message, String replaceWith, String level, boolean z10) {
        t.f(iVar, "<this>");
        t.f(message, "message");
        t.f(replaceWith, "replaceWith");
        t.f(level, "level");
        l lVar = new l(iVar, o.a.B, o0.l(w.a(f10555d, new x(replaceWith)), w.a(f10556e, new lf.b(dd.r.k(), new f(iVar)))), false, 8, null);
        ef.c cVar = o.a.f4021y;
        cd.q qVarA = w.a(f10552a, new x(message));
        cd.q qVarA2 = w.a(f10553b, new lf.a(lVar));
        ef.f fVar = f10554c;
        ef.b bVarC = ef.b.f8779d.c(o.a.A);
        ef.f fVarK = ef.f.k(level);
        t.e(fVarK, "identifier(...)");
        return new l(iVar, cVar, o0.l(qVarA, qVarA2, w.a(fVar, new lf.k(bVarC, fVarK))), z10);
    }

    public static /* synthetic */ c c(ce.i iVar, String str, String str2, String str3, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = "";
        }
        if ((i10 & 4) != 0) {
            str3 = "WARNING";
        }
        if ((i10 & 8) != 0) {
            z10 = false;
        }
        return b(iVar, str, str2, str3, z10);
    }

    public static final r0 d(ce.i iVar, h0 module) {
        t.f(module, "module");
        c1 c1VarM = module.p().m(m2.f25015e, iVar.X());
        t.e(c1VarM, "getArrayType(...)");
        return c1VarM;
    }
}
