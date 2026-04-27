package x1;

import A1.b;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import o1.InterfaceC2299k;
import r1.p;
import r1.u;
import s1.m;
import y1.x;
import z1.InterfaceC2859d;

/* JADX INFO: renamed from: x1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2818c implements e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Logger f25277f = Logger.getLogger(u.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f25278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f25279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s1.e f25280c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC2859d f25281d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final A1.b f25282e;

    public C2818c(Executor executor, s1.e eVar, x xVar, InterfaceC2859d interfaceC2859d, A1.b bVar) {
        this.f25279b = executor;
        this.f25280c = eVar;
        this.f25278a = xVar;
        this.f25281d = interfaceC2859d;
        this.f25282e = bVar;
    }

    @Override // x1.e
    public void a(final p pVar, final r1.i iVar, final InterfaceC2299k interfaceC2299k) {
        this.f25279b.execute(new Runnable() { // from class: x1.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f25270a.e(pVar, interfaceC2299k, iVar);
            }
        });
    }

    public final /* synthetic */ Object d(p pVar, r1.i iVar) {
        this.f25281d.N(pVar, iVar);
        this.f25278a.b(pVar, 1);
        return null;
    }

    public final /* synthetic */ void e(final p pVar, InterfaceC2299k interfaceC2299k, r1.i iVar) {
        try {
            m mVarA = this.f25280c.a(pVar.b());
            if (mVarA == null) {
                String str = String.format("Transport backend '%s' is not registered", pVar.b());
                f25277f.warning(str);
                interfaceC2299k.a(new IllegalArgumentException(str));
            } else {
                final r1.i iVarB = mVarA.b(iVar);
                this.f25282e.h(new b.a() { // from class: x1.b
                    @Override // A1.b.a
                    public final Object a() {
                        return this.f25274a.d(pVar, iVarB);
                    }
                });
                interfaceC2299k.a(null);
            }
        } catch (Exception e7) {
            f25277f.warning("Error scheduling event " + e7.getMessage());
            interfaceC2299k.a(e7);
        }
    }
}
