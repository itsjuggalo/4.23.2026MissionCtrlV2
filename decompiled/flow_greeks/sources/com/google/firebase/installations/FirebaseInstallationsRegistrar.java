package com.google.firebase.installations;

import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.installations.FirebaseInstallationsRegistrar;
import d7.a;
import d7.b;
import ga.g;
import ga.h;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import o7.c;
import o7.d;
import o7.e0;
import o7.q;
import o9.i;
import p7.y;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
@Keep
public class FirebaseInstallationsRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-installations";

    public static /* synthetic */ h a(d dVar) {
        return new g((a7.g) dVar.get(a7.g.class), dVar.b(i.class), (ExecutorService) dVar.f(e0.a(a.class, ExecutorService.class)), y.b((Executor) dVar.f(e0.a(b.class, Executor.class))));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<c> getComponents() {
        return Arrays.asList(c.c(h.class).h(LIBRARY_NAME).b(q.k(a7.g.class)).b(q.i(i.class)).b(q.l(e0.a(a.class, ExecutorService.class))).b(q.l(e0.a(b.class, Executor.class))).f(new o7.g() { // from class: ga.j
            @Override // o7.g
            public final Object create(o7.d dVar) {
                return FirebaseInstallationsRegistrar.a(dVar);
            }
        }).d(), o9.h.a(), oa.h.b(LIBRARY_NAME, "19.0.1"));
    }
}
