package com.google.firebase;

import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import dd.r;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import ng.k0;
import ng.r1;
import o7.e0;
import o7.g;
import o7.q;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
@Keep
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/google/firebase/FirebaseCommonKtxRegistrar;", "Lcom/google/firebase/components/ComponentRegistrar;", "<init>", "()V", "", "Lo7/c;", "getComponents", "()Ljava/util/List;", "com.google.firebase-firebase-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FirebaseCommonKtxRegistrar implements ComponentRegistrar {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6019a = new a();

        @Override // o7.g
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final k0 create(o7.d dVar) {
            Object objF = dVar.f(e0.a(d7.a.class, Executor.class));
            t.e(objF, "get(...)");
            return r1.b((Executor) objF);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f6020a = new b();

        @Override // o7.g
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final k0 create(o7.d dVar) {
            Object objF = dVar.f(e0.a(d7.c.class, Executor.class));
            t.e(objF, "get(...)");
            return r1.b((Executor) objF);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f6021a = new c();

        @Override // o7.g
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final k0 create(o7.d dVar) {
            Object objF = dVar.f(e0.a(d7.b.class, Executor.class));
            t.e(objF, "get(...)");
            return r1.b((Executor) objF);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f6022a = new d();

        @Override // o7.g
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final k0 create(o7.d dVar) {
            Object objF = dVar.f(e0.a(d7.d.class, Executor.class));
            t.e(objF, "get(...)");
            return r1.b((Executor) objF);
        }
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<o7.c> getComponents() {
        o7.c cVarD = o7.c.e(e0.a(d7.a.class, k0.class)).b(q.l(e0.a(d7.a.class, Executor.class))).f(a.f6019a).d();
        t.e(cVarD, "build(...)");
        o7.c cVarD2 = o7.c.e(e0.a(d7.c.class, k0.class)).b(q.l(e0.a(d7.c.class, Executor.class))).f(b.f6020a).d();
        t.e(cVarD2, "build(...)");
        o7.c cVarD3 = o7.c.e(e0.a(d7.b.class, k0.class)).b(q.l(e0.a(d7.b.class, Executor.class))).f(c.f6021a).d();
        t.e(cVarD3, "build(...)");
        o7.c cVarD4 = o7.c.e(e0.a(d7.d.class, k0.class)).b(q.l(e0.a(d7.d.class, Executor.class))).f(d.f6022a).d();
        t.e(cVarD4, "build(...)");
        return r.n(cVarD, cVarD2, cVarD3, cVarD4);
    }
}
