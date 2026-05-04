package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.j0;
import java.lang.reflect.Constructor;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class f0 extends j0.d implements j0.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Application f2408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j0.b f2409c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Bundle f2410d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public i f2411e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public k2.d f2412f;

    public f0(Application application, k2.f owner, Bundle bundle) {
        kotlin.jvm.internal.t.f(owner, "owner");
        this.f2412f = owner.getSavedStateRegistry();
        this.f2411e = owner.getLifecycle();
        this.f2410d = bundle;
        this.f2408b = application;
        this.f2409c = application != null ? j0.a.f2435f.a(application) : new j0.a();
    }

    @Override // androidx.lifecycle.j0.b
    public i0 a(Class modelClass) {
        kotlin.jvm.internal.t.f(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName != null) {
            return d(canonicalName, modelClass);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.lifecycle.j0.b
    public i0 b(Class modelClass, y1.a extras) {
        kotlin.jvm.internal.t.f(modelClass, "modelClass");
        kotlin.jvm.internal.t.f(extras, "extras");
        String str = (String) extras.a(j0.c.f2444d);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        }
        if (extras.a(c0.f2396a) == null || extras.a(c0.f2397b) == null) {
            if (this.f2411e != null) {
                return d(str, modelClass);
            }
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
        Application application = (Application) extras.a(j0.a.f2437h);
        boolean zIsAssignableFrom = a.class.isAssignableFrom(modelClass);
        Constructor constructorC = (!zIsAssignableFrom || application == null) ? g0.c(modelClass, g0.f2414b) : g0.c(modelClass, g0.f2413a);
        return constructorC == null ? this.f2409c.b(modelClass, extras) : (!zIsAssignableFrom || application == null) ? g0.d(modelClass, constructorC, c0.b(extras)) : g0.d(modelClass, constructorC, application, c0.b(extras));
    }

    @Override // androidx.lifecycle.j0.d
    public void c(i0 viewModel) {
        kotlin.jvm.internal.t.f(viewModel, "viewModel");
        if (this.f2411e != null) {
            k2.d dVar = this.f2412f;
            kotlin.jvm.internal.t.c(dVar);
            i iVar = this.f2411e;
            kotlin.jvm.internal.t.c(iVar);
            h.a(viewModel, dVar, iVar);
        }
    }

    public final i0 d(String key, Class modelClass) {
        i0 i0VarD;
        Application application;
        kotlin.jvm.internal.t.f(key, "key");
        kotlin.jvm.internal.t.f(modelClass, "modelClass");
        i iVar = this.f2411e;
        if (iVar == null) {
            throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
        boolean zIsAssignableFrom = a.class.isAssignableFrom(modelClass);
        Constructor constructorC = (!zIsAssignableFrom || this.f2408b == null) ? g0.c(modelClass, g0.f2414b) : g0.c(modelClass, g0.f2413a);
        if (constructorC == null) {
            return this.f2408b != null ? this.f2409c.a(modelClass) : j0.c.f2442b.a().a(modelClass);
        }
        k2.d dVar = this.f2412f;
        kotlin.jvm.internal.t.c(dVar);
        b0 b0VarB = h.b(dVar, iVar, key, this.f2410d);
        if (!zIsAssignableFrom || (application = this.f2408b) == null) {
            i0VarD = g0.d(modelClass, constructorC, b0VarB.c());
        } else {
            kotlin.jvm.internal.t.c(application);
            i0VarD = g0.d(modelClass, constructorC, application, b0VarB.c());
        }
        i0VarD.e("androidx.lifecycle.savedstate.vm.tag", b0VarB);
        return i0VarD;
    }
}
