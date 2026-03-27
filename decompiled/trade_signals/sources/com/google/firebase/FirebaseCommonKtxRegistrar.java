package com.google.firebase;

import M2.C0700c;
import M2.E;
import M2.InterfaceC0701d;
import M2.g;
import M2.q;
import Y6.AbstractC1020n0;
import Y6.I;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2595q;

/* JADX INFO: loaded from: classes.dex */
@Keep
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/google/firebase/FirebaseCommonKtxRegistrar;", "Lcom/google/firebase/components/ComponentRegistrar;", "<init>", "()V", "", "LM2/c;", "getComponents", "()Ljava/util/List;", "com.google.firebase-firebase-common"}, k = 1, mv = {2, 0, 0})
public final class FirebaseCommonKtxRegistrar implements ComponentRegistrar {

    public static final class a implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f15549a = new a();

        @Override // M2.g
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final I create(InterfaceC0701d interfaceC0701d) {
            Object objD = interfaceC0701d.d(E.a(J2.a.class, Executor.class));
            AbstractC2304t.e(objD, "get(...)");
            return AbstractC1020n0.a((Executor) objD);
        }
    }

    public static final class b implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f15550a = new b();

        @Override // M2.g
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final I create(InterfaceC0701d interfaceC0701d) {
            Object objD = interfaceC0701d.d(E.a(J2.c.class, Executor.class));
            AbstractC2304t.e(objD, "get(...)");
            return AbstractC1020n0.a((Executor) objD);
        }
    }

    public static final class c implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f15551a = new c();

        @Override // M2.g
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final I create(InterfaceC0701d interfaceC0701d) {
            Object objD = interfaceC0701d.d(E.a(J2.b.class, Executor.class));
            AbstractC2304t.e(objD, "get(...)");
            return AbstractC1020n0.a((Executor) objD);
        }
    }

    public static final class d implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f15552a = new d();

        @Override // M2.g
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final I create(InterfaceC0701d interfaceC0701d) {
            Object objD = interfaceC0701d.d(E.a(J2.d.class, Executor.class));
            AbstractC2304t.e(objD, "get(...)");
            return AbstractC1020n0.a((Executor) objD);
        }
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<C0700c> getComponents() {
        C0700c c0700cD = C0700c.c(E.a(J2.a.class, I.class)).b(q.k(E.a(J2.a.class, Executor.class))).f(a.f15549a).d();
        AbstractC2304t.e(c0700cD, "build(...)");
        C0700c c0700cD2 = C0700c.c(E.a(J2.c.class, I.class)).b(q.k(E.a(J2.c.class, Executor.class))).f(b.f15550a).d();
        AbstractC2304t.e(c0700cD2, "build(...)");
        C0700c c0700cD3 = C0700c.c(E.a(J2.b.class, I.class)).b(q.k(E.a(J2.b.class, Executor.class))).f(c.f15551a).d();
        AbstractC2304t.e(c0700cD3, "build(...)");
        C0700c c0700cD4 = C0700c.c(E.a(J2.d.class, I.class)).b(q.k(E.a(J2.d.class, Executor.class))).f(d.f15552a).d();
        AbstractC2304t.e(c0700cD4, "build(...)");
        return AbstractC2595q.l(c0700cD, c0700cD2, c0700cD3, c0700cD4);
    }
}
