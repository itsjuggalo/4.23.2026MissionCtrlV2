package com.google.firebase.firestore;

import a7.p;
import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.firestore.FirestoreRegistrar;
import java.util.Arrays;
import java.util.List;
import m9.s;
import o7.q;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
@Keep
public class FirestoreRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-fst";

    public static /* synthetic */ h a(o7.d dVar) {
        return new h((Context) dVar.get(Context.class), (a7.g) dVar.get(a7.g.class), dVar.h(n7.b.class), dVar.h(j7.b.class), new s(dVar.b(oa.i.class), dVar.b(o9.j.class), (p) dVar.get(p.class)));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    public List<o7.c> getComponents() {
        return Arrays.asList(o7.c.c(h.class).h(LIBRARY_NAME).b(q.k(a7.g.class)).b(q.k(Context.class)).b(q.i(o9.j.class)).b(q.i(oa.i.class)).b(q.a(n7.b.class)).b(q.a(j7.b.class)).b(q.h(p.class)).f(new o7.g() { // from class: d9.p0
            @Override // o7.g
            public final Object create(o7.d dVar) {
                return FirestoreRegistrar.a(dVar);
            }
        }).d(), oa.h.b(LIBRARY_NAME, "26.0.2"));
    }
}
