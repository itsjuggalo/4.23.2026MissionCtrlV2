package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.i;
import androidx.lifecycle.j0;
import k2.d;
import y1.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a.b f2396a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a.b f2397b = new c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a.b f2398c = new a();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements a.b {
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b implements a.b {
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c implements a.b {
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d implements j0.b {
        @Override // androidx.lifecycle.j0.b
        public i0 b(Class modelClass, y1.a extras) {
            kotlin.jvm.internal.t.f(modelClass, "modelClass");
            kotlin.jvm.internal.t.f(extras, "extras");
            return new e0();
        }
    }

    public static final z a(k2.f fVar, m0 m0Var, String str, Bundle bundle) {
        d0 d0VarD = d(fVar);
        e0 e0VarE = e(m0Var);
        z zVar = (z) e0VarE.f().get(str);
        if (zVar != null) {
            return zVar;
        }
        z zVarA = z.f2489f.a(d0VarD.b(str), bundle);
        e0VarE.f().put(str, zVarA);
        return zVarA;
    }

    public static final z b(y1.a aVar) {
        kotlin.jvm.internal.t.f(aVar, "<this>");
        k2.f fVar = (k2.f) aVar.a(f2396a);
        if (fVar == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
        }
        m0 m0Var = (m0) aVar.a(f2397b);
        if (m0Var == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        Bundle bundle = (Bundle) aVar.a(f2398c);
        String str = (String) aVar.a(j0.c.f2444d);
        if (str != null) {
            return a(fVar, m0Var, str, bundle);
        }
        throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
    }

    public static final void c(k2.f fVar) {
        kotlin.jvm.internal.t.f(fVar, "<this>");
        i.b bVarB = fVar.getLifecycle().b();
        if (bVarB != i.b.INITIALIZED && bVarB != i.b.CREATED) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (fVar.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider") == null) {
            d0 d0Var = new d0(fVar.getSavedStateRegistry(), (m0) fVar);
            fVar.getSavedStateRegistry().h("androidx.lifecycle.internal.SavedStateHandlesProvider", d0Var);
            fVar.getLifecycle().a(new a0(d0Var));
        }
    }

    public static final d0 d(k2.f fVar) {
        kotlin.jvm.internal.t.f(fVar, "<this>");
        d.c cVarC = fVar.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider");
        d0 d0Var = cVarC instanceof d0 ? (d0) cVarC : null;
        if (d0Var != null) {
            return d0Var;
        }
        throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
    }

    public static final e0 e(m0 m0Var) {
        kotlin.jvm.internal.t.f(m0Var, "<this>");
        return (e0) new j0(m0Var, new d()).b("androidx.lifecycle.internal.SavedStateHandlesVM", e0.class);
    }
}
