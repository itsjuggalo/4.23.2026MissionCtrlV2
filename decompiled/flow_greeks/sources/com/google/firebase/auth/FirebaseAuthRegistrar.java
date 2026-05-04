package com.google.firebase.auth;

import androidx.annotation.Keep;
import com.google.firebase.auth.FirebaseAuthRegistrar;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import o7.e0;
import o7.q;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
@Keep
public class FirebaseAuthRegistrar implements ComponentRegistrar {
    public static /* synthetic */ FirebaseAuth lambda$getComponents$0(e0 e0Var, e0 e0Var2, e0 e0Var3, e0 e0Var4, e0 e0Var5, o7.d dVar) {
        return new n7.g((a7.g) dVar.get(a7.g.class), dVar.b(j7.b.class), dVar.b(o9.i.class), (Executor) dVar.f(e0Var), (Executor) dVar.f(e0Var2), (Executor) dVar.f(e0Var3), (ScheduledExecutorService) dVar.f(e0Var4), (Executor) dVar.f(e0Var5));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    public List<o7.c> getComponents() {
        final e0 e0VarA = e0.a(d7.a.class, Executor.class);
        final e0 e0VarA2 = e0.a(d7.b.class, Executor.class);
        final e0 e0VarA3 = e0.a(d7.c.class, Executor.class);
        final e0 e0VarA4 = e0.a(d7.c.class, ScheduledExecutorService.class);
        final e0 e0VarA5 = e0.a(d7.d.class, Executor.class);
        return Arrays.asList(o7.c.d(FirebaseAuth.class, n7.b.class).b(q.k(a7.g.class)).b(q.m(o9.i.class)).b(q.l(e0VarA)).b(q.l(e0VarA2)).b(q.l(e0VarA3)).b(q.l(e0VarA4)).b(q.l(e0VarA5)).b(q.i(j7.b.class)).f(new o7.g() { // from class: m7.h1
            @Override // o7.g
            public final Object create(o7.d dVar) {
                return FirebaseAuthRegistrar.lambda$getComponents$0(e0VarA, e0VarA2, e0VarA3, e0VarA4, e0VarA5, dVar);
            }
        }).d(), o9.h.a(), oa.h.b("fire-auth", "24.0.1"));
    }
}
