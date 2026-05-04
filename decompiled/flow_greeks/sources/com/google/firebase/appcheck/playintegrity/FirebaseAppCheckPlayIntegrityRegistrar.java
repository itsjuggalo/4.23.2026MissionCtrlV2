package com.google.firebase.appcheck.playintegrity;

import a7.g;
import com.google.firebase.appcheck.playintegrity.FirebaseAppCheckPlayIntegrityRegistrar;
import com.google.firebase.components.ComponentRegistrar;
import d7.b;
import d7.c;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import l7.i;
import o7.d;
import o7.e0;
import o7.q;
import oa.h;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class FirebaseAppCheckPlayIntegrityRegistrar implements ComponentRegistrar {
    public static /* synthetic */ i a(e0 e0Var, e0 e0Var2, d dVar) {
        return new i((g) dVar.get(g.class), (Executor) dVar.f(e0Var), (Executor) dVar.f(e0Var2));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List getComponents() {
        final e0 e0VarA = e0.a(c.class, Executor.class);
        final e0 e0VarA2 = e0.a(b.class, Executor.class);
        return Arrays.asList(o7.c.c(i.class).h("fire-app-check-play-integrity").b(q.k(g.class)).b(q.l(e0VarA)).b(q.l(e0VarA2)).f(new o7.g() { // from class: k7.a
            @Override // o7.g
            public final Object create(d dVar) {
                return FirebaseAppCheckPlayIntegrityRegistrar.a(e0VarA, e0VarA2, dVar);
            }
        }).d(), h.b("fire-app-check-play-integrity", "19.0.1"));
    }
}
