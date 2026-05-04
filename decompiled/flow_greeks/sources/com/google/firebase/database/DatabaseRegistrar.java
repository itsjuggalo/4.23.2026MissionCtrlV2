package com.google.firebase.database;

import a7.g;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.database.DatabaseRegistrar;
import e8.i;
import java.util.Arrays;
import java.util.List;
import n7.b;
import o7.c;
import o7.d;
import o7.q;
import oa.h;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
@Keep
public class DatabaseRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-rtdb";

    public static /* synthetic */ i a(d dVar) {
        return new i((g) dVar.get(g.class), dVar.h(b.class), dVar.h(j7.b.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<c> getComponents() {
        return Arrays.asList(c.c(i.class).h(LIBRARY_NAME).b(q.k(g.class)).b(q.a(b.class)).b(q.a(j7.b.class)).f(new o7.g() { // from class: e8.f
            @Override // o7.g
            public final Object create(o7.d dVar) {
                return DatabaseRegistrar.a(dVar);
            }
        }).d(), h.b(LIBRARY_NAME, "22.0.1"));
    }
}
