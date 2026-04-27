package a1;

import a1.i;
import android.content.Context;
import g1.InterfaceC1259e;
import java.util.Collections;
import java.util.Set;
import k1.InterfaceC1567a;

/* JADX INFO: loaded from: classes.dex */
public class u implements t {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile v f6106e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC1567a f6107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC1567a f6108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC1259e f6109c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h1.r f6110d;

    public u(InterfaceC1567a interfaceC1567a, InterfaceC1567a interfaceC1567a2, InterfaceC1259e interfaceC1259e, h1.r rVar, h1.v vVar) {
        this.f6107a = interfaceC1567a;
        this.f6108b = interfaceC1567a2;
        this.f6109c = interfaceC1259e;
        this.f6110d = rVar;
        vVar.c();
    }

    public static u c() {
        v vVar = f6106e;
        if (vVar != null) {
            return vVar.f();
        }
        throw new IllegalStateException("Not initialized!");
    }

    public static Set d(f fVar) {
        return fVar instanceof g ? Collections.unmodifiableSet(((g) fVar).a()) : Collections.singleton(X0.c.b("proto"));
    }

    public static void f(Context context) {
        if (f6106e == null) {
            synchronized (u.class) {
                try {
                    if (f6106e == null) {
                        f6106e = AbstractC0780e.a().a(context).build();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // a1.t
    public void a(o oVar, X0.k kVar) {
        this.f6109c.a(oVar.f().f(oVar.c().d()), b(oVar), kVar);
    }

    public final i b(o oVar) {
        i.a aVarG = i.a().i(this.f6107a.a()).o(this.f6108b.a()).n(oVar.g()).h(new h(oVar.b(), oVar.d())).g(oVar.c().a());
        if (oVar.c().e() != null && oVar.c().e().a() != null) {
            aVarG.l(oVar.c().e().a());
        }
        oVar.c().b();
        return aVarG.d();
    }

    public h1.r e() {
        return this.f6110d;
    }

    public X0.j g(f fVar) {
        return new q(d(fVar), p.a().b(fVar.getName()).c(fVar.b()).a(), this);
    }
}
