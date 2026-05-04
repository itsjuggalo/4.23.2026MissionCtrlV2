package com.google.firebase.datatransport;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.datatransport.TransportRegistrar;
import i4.j;
import j4.a;
import java.util.Arrays;
import java.util.List;
import l4.u;
import o7.c;
import o7.d;
import o7.e0;
import o7.g;
import o7.q;
import oa.h;
import v8.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
@Keep
public class TransportRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-transport";

    public static /* synthetic */ j a(d dVar) {
        u.f((Context) dVar.get(Context.class));
        return u.c().g(a.f13880g);
    }

    public static /* synthetic */ j b(d dVar) {
        u.f((Context) dVar.get(Context.class));
        return u.c().g(a.f13881h);
    }

    public static /* synthetic */ j c(d dVar) {
        u.f((Context) dVar.get(Context.class));
        return u.c().g(a.f13881h);
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<c> getComponents() {
        return Arrays.asList(c.c(j.class).h(LIBRARY_NAME).b(q.k(Context.class)).f(new g() { // from class: v8.c
            @Override // o7.g
            public final Object create(o7.d dVar) {
                return TransportRegistrar.c(dVar);
            }
        }).d(), c.e(e0.a(v8.a.class, j.class)).b(q.k(Context.class)).f(new g() { // from class: v8.d
            @Override // o7.g
            public final Object create(o7.d dVar) {
                return TransportRegistrar.b(dVar);
            }
        }).d(), c.e(e0.a(b.class, j.class)).b(q.k(Context.class)).f(new g() { // from class: v8.e
            @Override // o7.g
            public final Object create(o7.d dVar) {
                return TransportRegistrar.a(dVar);
            }
        }).d(), h.b(LIBRARY_NAME, "19.0.0"));
    }
}
