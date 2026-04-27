package com.google.firebase.datatransport;

import X3.h;
import android.content.Context;
import b3.C0982E;
import b3.C0986c;
import b3.InterfaceC0987d;
import b3.InterfaceC0990g;
import b3.q;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.datatransport.TransportRegistrar;
import java.util.Arrays;
import java.util.List;
import o1.InterfaceC2298j;
import p1.C2366a;
import r1.u;
import s3.InterfaceC2643a;
import s3.InterfaceC2644b;

/* JADX INFO: loaded from: classes.dex */
public class TransportRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-transport";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ InterfaceC2298j lambda$getComponents$0(InterfaceC0987d interfaceC0987d) {
        u.f((Context) interfaceC0987d.a(Context.class));
        return u.c().g(C2366a.f21455h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ InterfaceC2298j lambda$getComponents$1(InterfaceC0987d interfaceC0987d) {
        u.f((Context) interfaceC0987d.a(Context.class));
        return u.c().g(C2366a.f21455h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ InterfaceC2298j lambda$getComponents$2(InterfaceC0987d interfaceC0987d) {
        u.f((Context) interfaceC0987d.a(Context.class));
        return u.c().g(C2366a.f21454g);
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<C0986c> getComponents() {
        return Arrays.asList(C0986c.e(InterfaceC2298j.class).h(LIBRARY_NAME).b(q.l(Context.class)).f(new InterfaceC0990g() { // from class: s3.c
            @Override // b3.InterfaceC0990g
            public final Object a(InterfaceC0987d interfaceC0987d) {
                return TransportRegistrar.lambda$getComponents$0(interfaceC0987d);
            }
        }).d(), C0986c.c(C0982E.a(InterfaceC2643a.class, InterfaceC2298j.class)).b(q.l(Context.class)).f(new InterfaceC0990g() { // from class: s3.d
            @Override // b3.InterfaceC0990g
            public final Object a(InterfaceC0987d interfaceC0987d) {
                return TransportRegistrar.lambda$getComponents$1(interfaceC0987d);
            }
        }).d(), C0986c.c(C0982E.a(InterfaceC2644b.class, InterfaceC2298j.class)).b(q.l(Context.class)).f(new InterfaceC0990g() { // from class: s3.e
            @Override // b3.InterfaceC0990g
            public final Object a(InterfaceC0987d interfaceC0987d) {
                return TransportRegistrar.lambda$getComponents$2(interfaceC0987d);
            }
        }).d(), h.b(LIBRARY_NAME, "19.0.0"));
    }
}
