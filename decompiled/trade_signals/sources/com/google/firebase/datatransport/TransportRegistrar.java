package com.google.firebase.datatransport;

import M2.C0700c;
import M2.E;
import M2.InterfaceC0701d;
import M2.g;
import M2.q;
import a4.h;
import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.datatransport.TransportRegistrar;
import java.util.Arrays;
import java.util.List;
import t3.InterfaceC2743a;
import t3.InterfaceC2744b;
import w1.InterfaceC2907j;
import x1.C2952a;
import z1.u;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class TransportRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-transport";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ InterfaceC2907j lambda$getComponents$0(InterfaceC0701d interfaceC0701d) {
        u.f((Context) interfaceC0701d.get(Context.class));
        return u.c().g(C2952a.f24151h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ InterfaceC2907j lambda$getComponents$1(InterfaceC0701d interfaceC0701d) {
        u.f((Context) interfaceC0701d.get(Context.class));
        return u.c().g(C2952a.f24151h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ InterfaceC2907j lambda$getComponents$2(InterfaceC0701d interfaceC0701d) {
        u.f((Context) interfaceC0701d.get(Context.class));
        return u.c().g(C2952a.f24150g);
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<C0700c> getComponents() {
        return Arrays.asList(C0700c.e(InterfaceC2907j.class).h(LIBRARY_NAME).b(q.l(Context.class)).f(new g() { // from class: t3.c
            @Override // M2.g
            public final Object create(InterfaceC0701d interfaceC0701d) {
                return TransportRegistrar.lambda$getComponents$0(interfaceC0701d);
            }
        }).d(), C0700c.c(E.a(InterfaceC2743a.class, InterfaceC2907j.class)).b(q.l(Context.class)).f(new g() { // from class: t3.d
            @Override // M2.g
            public final Object create(InterfaceC0701d interfaceC0701d) {
                return TransportRegistrar.lambda$getComponents$1(interfaceC0701d);
            }
        }).d(), C0700c.c(E.a(InterfaceC2744b.class, InterfaceC2907j.class)).b(q.l(Context.class)).f(new g() { // from class: t3.e
            @Override // M2.g
            public final Object create(InterfaceC0701d interfaceC0701d) {
                return TransportRegistrar.lambda$getComponents$2(interfaceC0701d);
            }
        }).d(), h.b(LIBRARY_NAME, "19.0.0"));
    }
}
