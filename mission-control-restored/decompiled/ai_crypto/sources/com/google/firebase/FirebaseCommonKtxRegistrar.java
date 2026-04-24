package com.google.firebase;

import F5.AbstractC0556n;
import b3.C0982E;
import b3.C0986c;
import b3.InterfaceC0987d;
import b3.InterfaceC0990g;
import b3.q;
import b6.AbstractC1086o0;
import b6.I;
import com.google.firebase.components.ComponentRegistrar;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class FirebaseCommonKtxRegistrar implements ComponentRegistrar {

    public static final class a implements InterfaceC0990g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f11984a = new a();

        @Override // b3.InterfaceC0990g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final I a(InterfaceC0987d interfaceC0987d) {
            Object objE = interfaceC0987d.e(C0982E.a(U2.a.class, Executor.class));
            r.e(objE, "c.get(Qualified.qualifie…a, Executor::class.java))");
            return AbstractC1086o0.a((Executor) objE);
        }
    }

    public static final class b implements InterfaceC0990g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f11985a = new b();

        @Override // b3.InterfaceC0990g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final I a(InterfaceC0987d interfaceC0987d) {
            Object objE = interfaceC0987d.e(C0982E.a(U2.c.class, Executor.class));
            r.e(objE, "c.get(Qualified.qualifie…a, Executor::class.java))");
            return AbstractC1086o0.a((Executor) objE);
        }
    }

    public static final class c implements InterfaceC0990g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f11986a = new c();

        @Override // b3.InterfaceC0990g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final I a(InterfaceC0987d interfaceC0987d) {
            Object objE = interfaceC0987d.e(C0982E.a(U2.b.class, Executor.class));
            r.e(objE, "c.get(Qualified.qualifie…a, Executor::class.java))");
            return AbstractC1086o0.a((Executor) objE);
        }
    }

    public static final class d implements InterfaceC0990g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f11987a = new d();

        @Override // b3.InterfaceC0990g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final I a(InterfaceC0987d interfaceC0987d) {
            Object objE = interfaceC0987d.e(C0982E.a(U2.d.class, Executor.class));
            r.e(objE, "c.get(Qualified.qualifie…a, Executor::class.java))");
            return AbstractC1086o0.a((Executor) objE);
        }
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<C0986c> getComponents() {
        C0986c c0986cD = C0986c.c(C0982E.a(U2.a.class, I.class)).b(q.k(C0982E.a(U2.a.class, Executor.class))).f(a.f11984a).d();
        r.e(c0986cD, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        C0986c c0986cD2 = C0986c.c(C0982E.a(U2.c.class, I.class)).b(q.k(C0982E.a(U2.c.class, Executor.class))).f(b.f11985a).d();
        r.e(c0986cD2, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        C0986c c0986cD3 = C0986c.c(C0982E.a(U2.b.class, I.class)).b(q.k(C0982E.a(U2.b.class, Executor.class))).f(c.f11986a).d();
        r.e(c0986cD3, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        C0986c c0986cD4 = C0986c.c(C0982E.a(U2.d.class, I.class)).b(q.k(C0982E.a(U2.d.class, Executor.class))).f(d.f11987a).d();
        r.e(c0986cD4, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        return AbstractC0556n.j(c0986cD, c0986cD2, c0986cD3, c0986cD4);
    }
}
