package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.AbstractC0846i;
import java.util.Iterator;
import o0.d;

/* JADX INFO: renamed from: androidx.lifecycle.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0845h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0845h f7672a = new C0845h();

    /* JADX INFO: renamed from: androidx.lifecycle.h$a */
    public static final class a implements d.a {
        @Override // o0.d.a
        public void a(o0.f owner) {
            kotlin.jvm.internal.r.f(owner, "owner");
            if (!(owner instanceof N)) {
                throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner");
            }
            M viewModelStore = ((N) owner).getViewModelStore();
            o0.d savedStateRegistry = owner.getSavedStateRegistry();
            Iterator it = viewModelStore.c().iterator();
            while (it.hasNext()) {
                J jB = viewModelStore.b((String) it.next());
                kotlin.jvm.internal.r.c(jB);
                C0845h.a(jB, savedStateRegistry, owner.getLifecycle());
            }
            if (viewModelStore.c().isEmpty()) {
                return;
            }
            savedStateRegistry.i(a.class);
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.h$b */
    public static final class b implements InterfaceC0848k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC0846i f7673a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ o0.d f7674b;

        public b(AbstractC0846i abstractC0846i, o0.d dVar) {
            this.f7673a = abstractC0846i;
            this.f7674b = dVar;
        }

        @Override // androidx.lifecycle.InterfaceC0848k
        public void a(InterfaceC0850m source, AbstractC0846i.a event) {
            kotlin.jvm.internal.r.f(source, "source");
            kotlin.jvm.internal.r.f(event, "event");
            if (event == AbstractC0846i.a.ON_START) {
                this.f7673a.c(this);
                this.f7674b.i(a.class);
            }
        }
    }

    public static final void a(J viewModel, o0.d registry, AbstractC0846i lifecycle) {
        kotlin.jvm.internal.r.f(viewModel, "viewModel");
        kotlin.jvm.internal.r.f(registry, "registry");
        kotlin.jvm.internal.r.f(lifecycle, "lifecycle");
        C c4 = (C) viewModel.c("androidx.lifecycle.savedstate.vm.tag");
        if (c4 == null || c4.d()) {
            return;
        }
        c4.b(registry, lifecycle);
        f7672a.c(registry, lifecycle);
    }

    public static final C b(o0.d registry, AbstractC0846i lifecycle, String str, Bundle bundle) {
        kotlin.jvm.internal.r.f(registry, "registry");
        kotlin.jvm.internal.r.f(lifecycle, "lifecycle");
        kotlin.jvm.internal.r.c(str);
        C c4 = new C(str, A.f7616f.a(registry.b(str), bundle));
        c4.b(registry, lifecycle);
        f7672a.c(registry, lifecycle);
        return c4;
    }

    public final void c(o0.d dVar, AbstractC0846i abstractC0846i) {
        AbstractC0846i.b bVarB = abstractC0846i.b();
        if (bVarB == AbstractC0846i.b.INITIALIZED || bVarB.c(AbstractC0846i.b.STARTED)) {
            dVar.i(a.class);
        } else {
            abstractC0846i.a(new b(abstractC0846i, dVar));
        }
    }
}
