package com.google.firebase.inappmessaging;

import a7.g;
import aa.n2;
import android.app.Application;
import android.content.Context;
import androidx.annotation.Keep;
import ca.k;
import ca.n;
import ca.z;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.ComponentRegistrar;
import d7.a;
import d7.b;
import d7.c;
import ga.h;
import i4.j;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import o7.d;
import o7.e0;
import q9.q;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
@Keep
public class FirebaseInAppMessagingRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-fiam";
    private e0 backgroundExecutor = e0.a(a.class, Executor.class);
    private e0 blockingExecutor = e0.a(b.class, Executor.class);
    private e0 lightWeightExecutor = e0.a(c.class, Executor.class);
    private e0 legacyTransportFactory = e0.a(v8.a.class, j.class);

    /* JADX INFO: Access modifiers changed from: private */
    public q providesFirebaseInAppMessaging(d dVar) {
        g gVar = (g) dVar.get(g.class);
        h hVar = (h) dVar.get(h.class);
        fa.a aVarH = dVar.h(AnalyticsConnector.class);
        c9.d dVar2 = (c9.d) dVar.get(c9.d.class);
        ba.d dVarD = ba.c.a().c(new n((Application) gVar.m())).b(new k(aVarH, dVar2)).a(new ca.a()).f(new ca.e0(new n2())).e(new ca.q((Executor) dVar.f(this.lightWeightExecutor), (Executor) dVar.f(this.backgroundExecutor), (Executor) dVar.f(this.blockingExecutor))).d();
        return ba.b.a().c(new aa.b(((c7.a) dVar.get(c7.a.class)).b(AppMeasurement.FIAM_ORIGIN), (Executor) dVar.f(this.blockingExecutor))).a(new ca.d(gVar, hVar, dVarD.o())).b(new z(gVar)).e(dVarD).d((j) dVar.f(this.legacyTransportFactory)).build().a();
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    public List<o7.c> getComponents() {
        return Arrays.asList(o7.c.c(q.class).h(LIBRARY_NAME).b(o7.q.k(Context.class)).b(o7.q.k(h.class)).b(o7.q.k(g.class)).b(o7.q.k(c7.a.class)).b(o7.q.a(AnalyticsConnector.class)).b(o7.q.l(this.legacyTransportFactory)).b(o7.q.k(c9.d.class)).b(o7.q.l(this.backgroundExecutor)).b(o7.q.l(this.blockingExecutor)).b(o7.q.l(this.lightWeightExecutor)).f(new o7.g() { // from class: q9.s
            @Override // o7.g
            public final Object create(o7.d dVar) {
                return this.f18948a.providesFirebaseInAppMessaging(dVar);
            }
        }).e().d(), oa.h.b(LIBRARY_NAME, "22.0.2"));
    }
}
