package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.AbstractC0846i;
import androidx.lifecycle.K;
import c0.AbstractC0870a;
import o0.d;

/* JADX INFO: loaded from: classes.dex */
public abstract class D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AbstractC0870a.b f7627a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AbstractC0870a.b f7628b = new c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AbstractC0870a.b f7629c = new a();

    public static final class a implements AbstractC0870a.b {
    }

    public static final class b implements AbstractC0870a.b {
    }

    public static final class c implements AbstractC0870a.b {
    }

    public static final class d implements K.b {
        @Override // androidx.lifecycle.K.b
        public J b(Class modelClass, AbstractC0870a extras) {
            kotlin.jvm.internal.r.f(modelClass, "modelClass");
            kotlin.jvm.internal.r.f(extras, "extras");
            return new F();
        }
    }

    public static final A a(AbstractC0870a abstractC0870a) {
        kotlin.jvm.internal.r.f(abstractC0870a, "<this>");
        o0.f fVar = (o0.f) abstractC0870a.a(f7627a);
        if (fVar == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
        }
        N n4 = (N) abstractC0870a.a(f7628b);
        if (n4 == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        Bundle bundle = (Bundle) abstractC0870a.a(f7629c);
        String str = (String) abstractC0870a.a(K.c.f7658d);
        if (str != null) {
            return b(fVar, n4, str, bundle);
        }
        throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
    }

    public static final A b(o0.f fVar, N n4, String str, Bundle bundle) {
        E eD = d(fVar);
        F fE = e(n4);
        A a4 = (A) fE.f().get(str);
        if (a4 != null) {
            return a4;
        }
        A a5 = A.f7616f.a(eD.b(str), bundle);
        fE.f().put(str, a5);
        return a5;
    }

    public static final void c(o0.f fVar) {
        kotlin.jvm.internal.r.f(fVar, "<this>");
        AbstractC0846i.b bVarB = fVar.getLifecycle().b();
        if (bVarB != AbstractC0846i.b.INITIALIZED && bVarB != AbstractC0846i.b.CREATED) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (fVar.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider") == null) {
            E e4 = new E(fVar.getSavedStateRegistry(), (N) fVar);
            fVar.getSavedStateRegistry().h("androidx.lifecycle.internal.SavedStateHandlesProvider", e4);
            fVar.getLifecycle().a(new B(e4));
        }
    }

    public static final E d(o0.f fVar) {
        kotlin.jvm.internal.r.f(fVar, "<this>");
        d.c cVarC = fVar.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider");
        E e4 = cVarC instanceof E ? (E) cVarC : null;
        if (e4 != null) {
            return e4;
        }
        throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
    }

    public static final F e(N n4) {
        kotlin.jvm.internal.r.f(n4, "<this>");
        return (F) new K(n4, new d()).b("androidx.lifecycle.internal.SavedStateHandlesVM", F.class);
    }
}
