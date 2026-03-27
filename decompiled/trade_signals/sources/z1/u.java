package z1;

import android.content.Context;
import java.util.Collections;
import java.util.Set;
import w1.C2900c;
import w1.InterfaceC2907j;
import w1.InterfaceC2908k;
import z1.i;

/* JADX INFO: loaded from: classes.dex */
public class u implements t {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile v f24722e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final J1.a f24723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final J1.a f24724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final F1.e f24725c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final G1.r f24726d;

    public u(J1.a aVar, J1.a aVar2, F1.e eVar, G1.r rVar, G1.v vVar) {
        this.f24723a = aVar;
        this.f24724b = aVar2;
        this.f24725c = eVar;
        this.f24726d = rVar;
        vVar.c();
    }

    public static u c() {
        v vVar = f24722e;
        if (vVar != null) {
            return vVar.c();
        }
        throw new IllegalStateException("Not initialized!");
    }

    public static Set d(f fVar) {
        return fVar instanceof g ? Collections.unmodifiableSet(((g) fVar).a()) : Collections.singleton(C2900c.b("proto"));
    }

    public static void f(Context context) {
        if (f24722e == null) {
            synchronized (u.class) {
                try {
                    if (f24722e == null) {
                        f24722e = e.a().b(context).a();
                    }
                } finally {
                }
            }
        }
    }

    @Override // z1.t
    public void a(o oVar, InterfaceC2908k interfaceC2908k) {
        this.f24725c.a(oVar.f().f(oVar.c().d()), b(oVar), interfaceC2908k);
    }

    public final i b(o oVar) {
        i.a aVarG = i.a().i(this.f24723a.a()).o(this.f24724b.a()).n(oVar.g()).h(new h(oVar.b(), oVar.d())).g(oVar.c().a());
        if (oVar.c().e() != null && oVar.c().e().a() != null) {
            aVarG.l(oVar.c().e().a());
        }
        oVar.c().b();
        return aVarG.d();
    }

    public G1.r e() {
        return this.f24726d;
    }

    public InterfaceC2907j g(f fVar) {
        return new q(d(fVar), p.a().b(fVar.getName()).c(fVar.b()).a(), this);
    }
}
