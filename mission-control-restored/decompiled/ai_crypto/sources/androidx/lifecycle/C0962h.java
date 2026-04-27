package androidx.lifecycle;

import F0.d;
import android.os.Bundle;
import androidx.lifecycle.AbstractC0963i;
import java.util.Iterator;

/* JADX INFO: renamed from: androidx.lifecycle.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0962h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0962h f7770a = new C0962h();

    /* JADX INFO: renamed from: androidx.lifecycle.h$a */
    public static final class a implements d.a {
        @Override // F0.d.a
        public void a(F0.f owner) {
            kotlin.jvm.internal.r.f(owner, "owner");
            if (!(owner instanceof N)) {
                throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner");
            }
            M mF = ((N) owner).f();
            F0.d dVarV = owner.v();
            Iterator it = mF.c().iterator();
            while (it.hasNext()) {
                J jB = mF.b((String) it.next());
                kotlin.jvm.internal.r.c(jB);
                C0962h.a(jB, dVarV, owner.a());
            }
            if (mF.c().isEmpty()) {
                return;
            }
            dVarV.i(a.class);
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.h$b */
    public static final class b implements InterfaceC0965k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC0963i f7771a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ F0.d f7772b;

        public b(AbstractC0963i abstractC0963i, F0.d dVar) {
            this.f7771a = abstractC0963i;
            this.f7772b = dVar;
        }

        @Override // androidx.lifecycle.InterfaceC0965k
        public void a(InterfaceC0967m source, AbstractC0963i.a event) {
            kotlin.jvm.internal.r.f(source, "source");
            kotlin.jvm.internal.r.f(event, "event");
            if (event == AbstractC0963i.a.ON_START) {
                this.f7771a.c(this);
                this.f7772b.i(a.class);
            }
        }
    }

    public static final void a(J viewModel, F0.d registry, AbstractC0963i lifecycle) {
        kotlin.jvm.internal.r.f(viewModel, "viewModel");
        kotlin.jvm.internal.r.f(registry, "registry");
        kotlin.jvm.internal.r.f(lifecycle, "lifecycle");
        C c7 = (C) viewModel.c("androidx.lifecycle.savedstate.vm.tag");
        if (c7 == null || c7.d()) {
            return;
        }
        c7.b(registry, lifecycle);
        f7770a.c(registry, lifecycle);
    }

    public static final C b(F0.d registry, AbstractC0963i lifecycle, String str, Bundle bundle) {
        kotlin.jvm.internal.r.f(registry, "registry");
        kotlin.jvm.internal.r.f(lifecycle, "lifecycle");
        kotlin.jvm.internal.r.c(str);
        C c7 = new C(str, A.f7714f.a(registry.b(str), bundle));
        c7.b(registry, lifecycle);
        f7770a.c(registry, lifecycle);
        return c7;
    }

    public final void c(F0.d dVar, AbstractC0963i abstractC0963i) {
        AbstractC0963i.b bVarB = abstractC0963i.b();
        if (bVarB == AbstractC0963i.b.INITIALIZED || bVarB.b(AbstractC0963i.b.STARTED)) {
            dVar.i(a.class);
        } else {
            abstractC0963i.a(new b(abstractC0963i, dVar));
        }
    }
}
