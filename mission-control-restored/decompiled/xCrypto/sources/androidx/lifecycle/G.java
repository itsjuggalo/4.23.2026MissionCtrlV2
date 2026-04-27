package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.K;
import c0.AbstractC0870a;
import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: classes.dex */
public final class G extends K.d implements K.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Application f7636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final K.b f7637c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Bundle f7638d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AbstractC0846i f7639e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public o0.d f7640f;

    public G(Application application, o0.f owner, Bundle bundle) {
        kotlin.jvm.internal.r.f(owner, "owner");
        this.f7640f = owner.getSavedStateRegistry();
        this.f7639e = owner.getLifecycle();
        this.f7638d = bundle;
        this.f7636b = application;
        this.f7637c = application != null ? K.a.f7649f.a(application) : new K.a();
    }

    @Override // androidx.lifecycle.K.b
    public J a(Class modelClass) {
        kotlin.jvm.internal.r.f(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName != null) {
            return d(canonicalName, modelClass);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.lifecycle.K.b
    public J b(Class modelClass, AbstractC0870a extras) {
        kotlin.jvm.internal.r.f(modelClass, "modelClass");
        kotlin.jvm.internal.r.f(extras, "extras");
        String str = (String) extras.a(K.c.f7658d);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        }
        if (extras.a(D.f7627a) == null || extras.a(D.f7628b) == null) {
            if (this.f7639e != null) {
                return d(str, modelClass);
            }
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
        Application application = (Application) extras.a(K.a.f7651h);
        boolean zIsAssignableFrom = AbstractC0838a.class.isAssignableFrom(modelClass);
        Constructor constructorC = (!zIsAssignableFrom || application == null) ? H.c(modelClass, H.f7642b) : H.c(modelClass, H.f7641a);
        return constructorC == null ? this.f7637c.b(modelClass, extras) : (!zIsAssignableFrom || application == null) ? H.d(modelClass, constructorC, D.a(extras)) : H.d(modelClass, constructorC, application, D.a(extras));
    }

    @Override // androidx.lifecycle.K.d
    public void c(J viewModel) {
        kotlin.jvm.internal.r.f(viewModel, "viewModel");
        if (this.f7639e != null) {
            o0.d dVar = this.f7640f;
            kotlin.jvm.internal.r.c(dVar);
            AbstractC0846i abstractC0846i = this.f7639e;
            kotlin.jvm.internal.r.c(abstractC0846i);
            C0845h.a(viewModel, dVar, abstractC0846i);
        }
    }

    public final J d(String key, Class modelClass) {
        J jD;
        Application application;
        kotlin.jvm.internal.r.f(key, "key");
        kotlin.jvm.internal.r.f(modelClass, "modelClass");
        AbstractC0846i abstractC0846i = this.f7639e;
        if (abstractC0846i == null) {
            throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
        boolean zIsAssignableFrom = AbstractC0838a.class.isAssignableFrom(modelClass);
        Constructor constructorC = (!zIsAssignableFrom || this.f7636b == null) ? H.c(modelClass, H.f7642b) : H.c(modelClass, H.f7641a);
        if (constructorC == null) {
            return this.f7636b != null ? this.f7637c.a(modelClass) : K.c.f7656b.a().a(modelClass);
        }
        o0.d dVar = this.f7640f;
        kotlin.jvm.internal.r.c(dVar);
        C cB = C0845h.b(dVar, abstractC0846i, key, this.f7638d);
        if (!zIsAssignableFrom || (application = this.f7636b) == null) {
            jD = H.d(modelClass, constructorC, cB.c());
        } else {
            kotlin.jvm.internal.r.c(application);
            jD = H.d(modelClass, constructorC, application, cB.c());
        }
        jD.e("androidx.lifecycle.savedstate.vm.tag", cB);
        return jD;
    }
}
