package com.google.firebase.inappmessaging.display;

import a7.g;
import android.app.Application;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.List;
import o7.c;
import o7.d;
import oa.h;
import q9.q;
import s9.b;
import x9.a;
import x9.e;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
@Keep
public class FirebaseInAppMessagingDisplayRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-fiamd";

    /* JADX INFO: Access modifiers changed from: private */
    public b buildFirebaseInAppMessagingUI(d dVar) {
        g gVar = (g) dVar.get(g.class);
        q qVar = (q) dVar.get(q.class);
        Application application = (Application) gVar.m();
        b bVarA = w9.b.a().c(w9.d.a().a(new a(application)).b()).b(new e(qVar)).a().a();
        application.registerActivityLifecycleCallbacks(bVarA);
        return bVarA;
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    public List<c> getComponents() {
        return Arrays.asList(c.c(b.class).h(LIBRARY_NAME).b(o7.q.k(g.class)).b(o7.q.k(q.class)).f(new o7.g() { // from class: s9.c
            @Override // o7.g
            public final Object create(o7.d dVar) {
                return this.f20143a.buildFirebaseInAppMessagingUI(dVar);
            }
        }).e().d(), h.b(LIBRARY_NAME, "22.0.2"));
    }
}
