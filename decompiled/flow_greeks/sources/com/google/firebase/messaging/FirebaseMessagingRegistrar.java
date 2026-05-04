package com.google.firebase.messaging;

import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
@Keep
public class FirebaseMessagingRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-fcm";

    public static /* synthetic */ FirebaseMessaging a(o7.e0 e0Var, o7.d dVar) {
        a7.g gVar = (a7.g) dVar.get(a7.g.class);
        android.support.v4.media.session.b.a(dVar.get(p9.a.class));
        return new FirebaseMessaging(gVar, null, dVar.b(oa.i.class), dVar.b(o9.j.class), (ga.h) dVar.get(ga.h.class), dVar.d(e0Var), (c9.d) dVar.get(c9.d.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    public List<o7.c> getComponents() {
        final o7.e0 e0VarA = o7.e0.a(v8.b.class, i4.j.class);
        return Arrays.asList(o7.c.c(FirebaseMessaging.class).h(LIBRARY_NAME).b(o7.q.k(a7.g.class)).b(o7.q.h(p9.a.class)).b(o7.q.i(oa.i.class)).b(o7.q.i(o9.j.class)).b(o7.q.k(ga.h.class)).b(o7.q.j(e0VarA)).b(o7.q.k(c9.d.class)).f(new o7.g() { // from class: com.google.firebase.messaging.e0
            @Override // o7.g
            public final Object create(o7.d dVar) {
                return FirebaseMessagingRegistrar.a(e0VarA, dVar);
            }
        }).c().d(), oa.h.b(LIBRARY_NAME, "25.0.1"));
    }
}
