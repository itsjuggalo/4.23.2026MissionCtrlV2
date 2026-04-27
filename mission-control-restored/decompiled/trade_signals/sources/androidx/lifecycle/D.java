package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.AbstractC1157i;
import androidx.lifecycle.K;
import kotlin.jvm.internal.AbstractC2304t;
import p0.AbstractC2539a;
import z0.d;

/* JADX INFO: loaded from: classes.dex */
public abstract class D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AbstractC2539a.b f11923a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AbstractC2539a.b f11924b = new c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AbstractC2539a.b f11925c = new a();

    public static final class a implements AbstractC2539a.b {
    }

    public static final class b implements AbstractC2539a.b {
    }

    public static final class c implements AbstractC2539a.b {
    }

    public static final class d implements K.b {
        @Override // androidx.lifecycle.K.b
        public J b(Class modelClass, AbstractC2539a extras) {
            AbstractC2304t.f(modelClass, "modelClass");
            AbstractC2304t.f(extras, "extras");
            return new F();
        }
    }

    public static final A a(AbstractC2539a abstractC2539a) {
        AbstractC2304t.f(abstractC2539a, "<this>");
        z0.f fVar = (z0.f) abstractC2539a.a(f11923a);
        if (fVar == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
        }
        N n8 = (N) abstractC2539a.a(f11924b);
        if (n8 == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        Bundle bundle = (Bundle) abstractC2539a.a(f11925c);
        String str = (String) abstractC2539a.a(K.c.f11954d);
        if (str != null) {
            return b(fVar, n8, str, bundle);
        }
        throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
    }

    public static final A b(z0.f fVar, N n8, String str, Bundle bundle) {
        E eD = d(fVar);
        F fE = e(n8);
        A a8 = (A) fE.f().get(str);
        if (a8 != null) {
            return a8;
        }
        A a9 = A.f11912f.a(eD.b(str), bundle);
        fE.f().put(str, a9);
        return a9;
    }

    public static final void c(z0.f fVar) {
        AbstractC2304t.f(fVar, "<this>");
        AbstractC1157i.b bVarB = fVar.getLifecycle().b();
        if (bVarB != AbstractC1157i.b.INITIALIZED && bVarB != AbstractC1157i.b.CREATED) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (fVar.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider") == null) {
            E e8 = new E(fVar.getSavedStateRegistry(), (N) fVar);
            fVar.getSavedStateRegistry().h("androidx.lifecycle.internal.SavedStateHandlesProvider", e8);
            fVar.getLifecycle().a(new B(e8));
        }
    }

    public static final E d(z0.f fVar) {
        AbstractC2304t.f(fVar, "<this>");
        d.c cVarC = fVar.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider");
        E e8 = cVarC instanceof E ? (E) cVarC : null;
        if (e8 != null) {
            return e8;
        }
        throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
    }

    public static final F e(N n8) {
        AbstractC2304t.f(n8, "<this>");
        return (F) new K(n8, new d()).b("androidx.lifecycle.internal.SavedStateHandlesVM", F.class);
    }
}
