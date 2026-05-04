package com.google.firebase.crashlytics;

import a7.g;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.ComponentRegistrar;
import d7.a;
import d7.b;
import d7.c;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import o7.d;
import o7.e0;
import o7.q;
import q7.h;
import v7.i;
import va.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class CrashlyticsRegistrar implements ComponentRegistrar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e0 f6116a = e0.a(a.class, ExecutorService.class);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e0 f6117b = e0.a(b.class, ExecutorService.class);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e0 f6118c = e0.a(c.class, ExecutorService.class);

    static {
        va.b.a(c.a.f23219a);
    }

    public final h b(d dVar) {
        i.f(false);
        long jCurrentTimeMillis = System.currentTimeMillis();
        h hVarB = h.b((g) dVar.get(g.class), (ga.h) dVar.get(ga.h.class), dVar.h(r7.a.class), dVar.h(AnalyticsConnector.class), dVar.h(sa.a.class), (ExecutorService) dVar.f(this.f6116a), (ExecutorService) dVar.f(this.f6117b), (ExecutorService) dVar.f(this.f6118c));
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (jCurrentTimeMillis2 > 16) {
            r7.g.f().b("Initializing Crashlytics blocked main for " + jCurrentTimeMillis2 + " ms");
        }
        return hVarB;
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List getComponents() {
        return Arrays.asList(o7.c.c(h.class).h("fire-cls").b(q.k(g.class)).b(q.k(ga.h.class)).b(q.l(this.f6116a)).b(q.l(this.f6117b)).b(q.l(this.f6118c)).b(q.a(r7.a.class)).b(q.a(AnalyticsConnector.class)).b(q.a(sa.a.class)).f(new o7.g() { // from class: q7.f
            @Override // o7.g
            public final Object create(o7.d dVar) {
                return this.f18872a.b(dVar);
            }
        }).e().d(), oa.h.b("fire-cls", "20.0.3"));
    }
}
