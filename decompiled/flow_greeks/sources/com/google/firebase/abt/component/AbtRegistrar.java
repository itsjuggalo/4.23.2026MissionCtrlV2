package com.google.firebase.abt.component;

import android.content.Context;
import androidx.annotation.Keep;
import c7.a;
import com.google.firebase.abt.component.AbtRegistrar;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.List;
import o7.c;
import o7.d;
import o7.g;
import o7.q;
import oa.h;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
@Keep
public class AbtRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-abt";

    public static /* synthetic */ a a(d dVar) {
        return new a((Context) dVar.get(Context.class), dVar.b(AnalyticsConnector.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<c> getComponents() {
        return Arrays.asList(c.c(a.class).h(LIBRARY_NAME).b(q.k(Context.class)).b(q.i(AnalyticsConnector.class)).f(new g() { // from class: c7.b
            @Override // o7.g
            public final Object create(d dVar) {
                return AbtRegistrar.a(dVar);
            }
        }).d(), h.b(LIBRARY_NAME, "21.1.1"));
    }
}
