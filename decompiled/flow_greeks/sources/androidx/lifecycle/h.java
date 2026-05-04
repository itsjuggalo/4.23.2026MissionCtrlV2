package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.i;
import java.util.Iterator;
import k2.d;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f2415a = new h();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements d.a {
        @Override // k2.d.a
        public void a(k2.f owner) {
            kotlin.jvm.internal.t.f(owner, "owner");
            if (!(owner instanceof m0)) {
                throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner");
            }
            l0 viewModelStore = ((m0) owner).getViewModelStore();
            k2.d savedStateRegistry = owner.getSavedStateRegistry();
            Iterator it = viewModelStore.c().iterator();
            while (it.hasNext()) {
                i0 i0VarB = viewModelStore.b((String) it.next());
                kotlin.jvm.internal.t.c(i0VarB);
                h.a(i0VarB, savedStateRegistry, owner.getLifecycle());
            }
            if (viewModelStore.c().isEmpty()) {
                return;
            }
            savedStateRegistry.i(a.class);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f2416a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k2.d f2417b;

        public b(i iVar, k2.d dVar) {
            this.f2416a = iVar;
            this.f2417b = dVar;
        }

        @Override // androidx.lifecycle.k
        public void b(m source, i.a event) {
            kotlin.jvm.internal.t.f(source, "source");
            kotlin.jvm.internal.t.f(event, "event");
            if (event == i.a.ON_START) {
                this.f2416a.c(this);
                this.f2417b.i(a.class);
            }
        }
    }

    public static final void a(i0 viewModel, k2.d registry, i lifecycle) {
        kotlin.jvm.internal.t.f(viewModel, "viewModel");
        kotlin.jvm.internal.t.f(registry, "registry");
        kotlin.jvm.internal.t.f(lifecycle, "lifecycle");
        b0 b0Var = (b0) viewModel.c("androidx.lifecycle.savedstate.vm.tag");
        if (b0Var == null || b0Var.d()) {
            return;
        }
        b0Var.a(registry, lifecycle);
        f2415a.c(registry, lifecycle);
    }

    public static final b0 b(k2.d registry, i lifecycle, String str, Bundle bundle) {
        kotlin.jvm.internal.t.f(registry, "registry");
        kotlin.jvm.internal.t.f(lifecycle, "lifecycle");
        kotlin.jvm.internal.t.c(str);
        b0 b0Var = new b0(str, z.f2489f.a(registry.b(str), bundle));
        b0Var.a(registry, lifecycle);
        f2415a.c(registry, lifecycle);
        return b0Var;
    }

    public final void c(k2.d dVar, i iVar) {
        i.b bVarB = iVar.b();
        if (bVarB == i.b.INITIALIZED || bVarB.b(i.b.STARTED)) {
            dVar.i(a.class);
        } else {
            iVar.a(new b(iVar, dVar));
        }
    }
}
