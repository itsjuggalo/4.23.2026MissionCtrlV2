package com.google.firebase.appcheck;

import a7.g;
import com.google.firebase.appcheck.FirebaseAppCheckRegistrar;
import com.google.firebase.components.ComponentRegistrar;
import d7.a;
import d7.b;
import d7.c;
import e7.e;
import h7.j;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import o7.d;
import o7.e0;
import o7.q;
import o9.h;
import o9.i;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class FirebaseAppCheckRegistrar implements ComponentRegistrar {
    public static /* synthetic */ e a(e0 e0Var, e0 e0Var2, e0 e0Var3, e0 e0Var4, d dVar) {
        return new j((g) dVar.get(g.class), dVar.b(i.class), (Executor) dVar.f(e0Var), (Executor) dVar.f(e0Var2), (Executor) dVar.f(e0Var3), (ScheduledExecutorService) dVar.f(e0Var4));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List getComponents() {
        final e0 e0VarA = e0.a(d7.d.class, Executor.class);
        final e0 e0VarA2 = e0.a(c.class, Executor.class);
        final e0 e0VarA3 = e0.a(a.class, Executor.class);
        final e0 e0VarA4 = e0.a(b.class, ScheduledExecutorService.class);
        return Arrays.asList(o7.c.d(e.class, j7.b.class).h("fire-app-check").b(q.k(g.class)).b(q.l(e0VarA)).b(q.l(e0VarA2)).b(q.l(e0VarA3)).b(q.l(e0VarA4)).b(q.i(i.class)).f(new o7.g() { // from class: e7.f
            @Override // o7.g
            public final Object create(o7.d dVar) {
                return FirebaseAppCheckRegistrar.a(e0VarA, e0VarA2, e0VarA3, e0VarA4, dVar);
            }
        }).c().d(), h.a(), oa.h.b("fire-app-check", "19.0.1"));
    }
}
