package com.google.firebase.appcheck.debug;

import a7.g;
import com.google.firebase.appcheck.debug.FirebaseAppCheckDebugRegistrar;
import com.google.firebase.components.ComponentRegistrar;
import d7.a;
import d7.b;
import f7.c;
import g7.e;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import o7.d;
import o7.e0;
import o7.q;
import oa.h;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class FirebaseAppCheckDebugRegistrar implements ComponentRegistrar {
    public static /* synthetic */ e a(e0 e0Var, e0 e0Var2, e0 e0Var3, d dVar) {
        return new e((g) dVar.get(g.class), dVar.b(c.class), (Executor) dVar.f(e0Var), (Executor) dVar.f(e0Var2), (Executor) dVar.f(e0Var3));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List getComponents() {
        final e0 e0VarA = e0.a(d7.c.class, Executor.class);
        final e0 e0VarA2 = e0.a(a.class, Executor.class);
        final e0 e0VarA3 = e0.a(b.class, Executor.class);
        return Arrays.asList(o7.c.c(e.class).h("fire-app-check-debug").b(q.k(g.class)).b(q.i(c.class)).b(q.l(e0VarA)).b(q.l(e0VarA2)).b(q.l(e0VarA3)).f(new o7.g() { // from class: f7.b
            @Override // o7.g
            public final Object create(d dVar) {
                return FirebaseAppCheckDebugRegistrar.a(e0VarA, e0VarA2, e0VarA3, dVar);
            }
        }).d(), h.b("fire-app-check-debug", "19.0.1"));
    }
}
