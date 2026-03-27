package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.AbstractC1157i;
import java.util.Iterator;
import kotlin.jvm.internal.AbstractC2304t;
import z0.d;

/* JADX INFO: renamed from: androidx.lifecycle.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1156h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1156h f11968a = new C1156h();

    /* JADX INFO: renamed from: androidx.lifecycle.h$a */
    public static final class a implements d.a {
        @Override // z0.d.a
        public void a(z0.f owner) {
            AbstractC2304t.f(owner, "owner");
            if (!(owner instanceof N)) {
                throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner".toString());
            }
            M viewModelStore = ((N) owner).getViewModelStore();
            z0.d savedStateRegistry = owner.getSavedStateRegistry();
            Iterator it = viewModelStore.c().iterator();
            while (it.hasNext()) {
                J jB = viewModelStore.b((String) it.next());
                AbstractC2304t.c(jB);
                C1156h.a(jB, savedStateRegistry, owner.getLifecycle());
            }
            if (!viewModelStore.c().isEmpty()) {
                savedStateRegistry.i(a.class);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.h$b */
    public static final class b implements InterfaceC1159k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC1157i f11969a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ z0.d f11970b;

        public b(AbstractC1157i abstractC1157i, z0.d dVar) {
            this.f11969a = abstractC1157i;
            this.f11970b = dVar;
        }

        @Override // androidx.lifecycle.InterfaceC1159k
        public void b(InterfaceC1161m source, AbstractC1157i.a event) {
            AbstractC2304t.f(source, "source");
            AbstractC2304t.f(event, "event");
            if (event == AbstractC1157i.a.ON_START) {
                this.f11969a.c(this);
                this.f11970b.i(a.class);
            }
        }
    }

    public static final void a(J viewModel, z0.d registry, AbstractC1157i lifecycle) {
        AbstractC2304t.f(viewModel, "viewModel");
        AbstractC2304t.f(registry, "registry");
        AbstractC2304t.f(lifecycle, "lifecycle");
        C c8 = (C) viewModel.c("androidx.lifecycle.savedstate.vm.tag");
        if (c8 == null || c8.d()) {
            return;
        }
        c8.a(registry, lifecycle);
        f11968a.c(registry, lifecycle);
    }

    public static final C b(z0.d registry, AbstractC1157i lifecycle, String str, Bundle bundle) {
        AbstractC2304t.f(registry, "registry");
        AbstractC2304t.f(lifecycle, "lifecycle");
        AbstractC2304t.c(str);
        C c8 = new C(str, A.f11912f.a(registry.b(str), bundle));
        c8.a(registry, lifecycle);
        f11968a.c(registry, lifecycle);
        return c8;
    }

    public final void c(z0.d dVar, AbstractC1157i abstractC1157i) {
        AbstractC1157i.b bVarB = abstractC1157i.b();
        if (bVarB == AbstractC1157i.b.INITIALIZED || bVarB.b(AbstractC1157i.b.STARTED)) {
            dVar.i(a.class);
        } else {
            abstractC1157i.a(new b(abstractC1157i, dVar));
        }
    }
}
