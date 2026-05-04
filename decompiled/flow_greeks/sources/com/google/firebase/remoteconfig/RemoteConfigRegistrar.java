package com.google.firebase.remoteconfig;

import a7.g;
import android.content.Context;
import androidx.annotation.Keep;
import c7.a;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.remoteconfig.RemoteConfigRegistrar;
import d7.b;
import ga.h;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import o7.c;
import o7.d;
import o7.e0;
import o7.q;
import pa.z;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
@Keep
public class RemoteConfigRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-rc";

    public static /* synthetic */ z a(e0 e0Var, d dVar) {
        return new z((Context) dVar.get(Context.class), (ScheduledExecutorService) dVar.f(e0Var), (g) dVar.get(g.class), (h) dVar.get(h.class), ((a) dVar.get(a.class)).b("frc"), dVar.b(AnalyticsConnector.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<c> getComponents() {
        final e0 e0VarA = e0.a(b.class, ScheduledExecutorService.class);
        return Arrays.asList(c.d(z.class, sa.a.class).h(LIBRARY_NAME).b(q.k(Context.class)).b(q.l(e0VarA)).b(q.k(g.class)).b(q.k(h.class)).b(q.k(a.class)).b(q.i(AnalyticsConnector.class)).f(new o7.g() { // from class: pa.a0
            @Override // o7.g
            public final Object create(o7.d dVar) {
                return RemoteConfigRegistrar.a(e0VarA, dVar);
            }
        }).e().d(), oa.h.b(LIBRARY_NAME, "23.0.1"));
    }
}
