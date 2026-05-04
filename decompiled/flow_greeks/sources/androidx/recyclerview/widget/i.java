package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import u0.p;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class i extends t0.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerView f2851d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final t0.a f2852e = new a(this);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends t0.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final i f2853d;

        public a(i iVar) {
            this.f2853d = iVar;
        }

        @Override // t0.a
        public void g(View view, p pVar) {
            super.g(view, pVar);
            if (this.f2853d.n() || this.f2853d.f2851d.getLayoutManager() == null) {
                return;
            }
            this.f2853d.f2851d.getLayoutManager().d0(view, pVar);
        }

        @Override // t0.a
        public boolean j(View view, int i10, Bundle bundle) {
            if (super.j(view, i10, bundle)) {
                return true;
            }
            if (this.f2853d.n() || this.f2853d.f2851d.getLayoutManager() == null) {
                return false;
            }
            return this.f2853d.f2851d.getLayoutManager().t0(view, i10, bundle);
        }
    }

    public i(RecyclerView recyclerView) {
        this.f2851d = recyclerView;
    }

    @Override // t0.a
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if (!(view instanceof RecyclerView) || n()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().Z(accessibilityEvent);
        }
    }

    @Override // t0.a
    public void g(View view, p pVar) {
        super.g(view, pVar);
        pVar.X(RecyclerView.class.getName());
        if (n() || this.f2851d.getLayoutManager() == null) {
            return;
        }
        this.f2851d.getLayoutManager().c0(pVar);
    }

    @Override // t0.a
    public boolean j(View view, int i10, Bundle bundle) {
        if (super.j(view, i10, bundle)) {
            return true;
        }
        if (n() || this.f2851d.getLayoutManager() == null) {
            return false;
        }
        return this.f2851d.getLayoutManager().r0(i10, bundle);
    }

    public boolean n() {
        return this.f2851d.I();
    }
}
