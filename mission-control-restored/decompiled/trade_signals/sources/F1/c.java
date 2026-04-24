package F1;

import A1.m;
import G1.x;
import H1.InterfaceC0586d;
import I1.b;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import w1.InterfaceC2908k;
import z1.p;
import z1.u;

/* JADX INFO: loaded from: classes.dex */
public class c implements e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Logger f1507f = Logger.getLogger(u.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f1508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f1509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final A1.e f1510c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC0586d f1511d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final I1.b f1512e;

    public c(Executor executor, A1.e eVar, x xVar, InterfaceC0586d interfaceC0586d, I1.b bVar) {
        this.f1509b = executor;
        this.f1510c = eVar;
        this.f1508a = xVar;
        this.f1511d = interfaceC0586d;
        this.f1512e = bVar;
    }

    @Override // F1.e
    public void a(final p pVar, final z1.i iVar, final InterfaceC2908k interfaceC2908k) {
        this.f1509b.execute(new Runnable() { // from class: F1.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f1500a.e(pVar, interfaceC2908k, iVar);
            }
        });
    }

    public final /* synthetic */ Object d(p pVar, z1.i iVar) {
        this.f1511d.u(pVar, iVar);
        this.f1508a.a(pVar, 1);
        return null;
    }

    public final /* synthetic */ void e(final p pVar, InterfaceC2908k interfaceC2908k, z1.i iVar) {
        try {
            m mVarA = this.f1510c.a(pVar.b());
            if (mVarA == null) {
                String str = String.format("Transport backend '%s' is not registered", pVar.b());
                f1507f.warning(str);
                interfaceC2908k.a(new IllegalArgumentException(str));
            } else {
                final z1.i iVarA = mVarA.a(iVar);
                this.f1512e.c(new b.a() { // from class: F1.b
                    @Override // I1.b.a
                    public final Object a() {
                        return this.f1504a.d(pVar, iVarA);
                    }
                });
                interfaceC2908k.a(null);
            }
        } catch (Exception e8) {
            f1507f.warning("Error scheduling event " + e8.getMessage());
            interfaceC2908k.a(e8);
        }
    }
}
