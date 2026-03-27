package androidx.recyclerview.widget;

import H.C0267a;
import I.t;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: loaded from: classes.dex */
public class i extends C0267a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerView f8193d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C0267a f8194e = new a(this);

    public static class a extends C0267a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final i f8195d;

        public a(i iVar) {
            this.f8195d = iVar;
        }

        @Override // H.C0267a
        public void g(View view, t tVar) {
            super.g(view, tVar);
            if (this.f8195d.n() || this.f8195d.f8193d.getLayoutManager() == null) {
                return;
            }
            this.f8195d.f8193d.getLayoutManager().d0(view, tVar);
        }

        @Override // H.C0267a
        public boolean j(View view, int i4, Bundle bundle) {
            if (super.j(view, i4, bundle)) {
                return true;
            }
            if (this.f8195d.n() || this.f8195d.f8193d.getLayoutManager() == null) {
                return false;
            }
            return this.f8195d.f8193d.getLayoutManager().t0(view, i4, bundle);
        }
    }

    public i(RecyclerView recyclerView) {
        this.f8193d = recyclerView;
    }

    @Override // H.C0267a
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

    @Override // H.C0267a
    public void g(View view, t tVar) {
        super.g(view, tVar);
        tVar.W(RecyclerView.class.getName());
        if (n() || this.f8193d.getLayoutManager() == null) {
            return;
        }
        this.f8193d.getLayoutManager().b0(tVar);
    }

    @Override // H.C0267a
    public boolean j(View view, int i4, Bundle bundle) {
        if (super.j(view, i4, bundle)) {
            return true;
        }
        if (n() || this.f8193d.getLayoutManager() == null) {
            return false;
        }
        return this.f8193d.getLayoutManager().r0(i4, bundle);
    }

    public boolean n() {
        return this.f8193d.I();
    }
}
