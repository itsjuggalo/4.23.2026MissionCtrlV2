package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.h;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f6355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f6356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f6357c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LayoutInflater f6358e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LayoutInflater f6359f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public g.a f6360g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6361h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f6362i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public h f6363j;

    public a(Context context, int i4, int i5) {
        this.f6355a = context;
        this.f6358e = LayoutInflater.from(context);
        this.f6361h = i4;
        this.f6362i = i5;
    }

    @Override // androidx.appcompat.view.menu.g
    public void a(d dVar, boolean z4) {
        g.a aVar = this.f6360g;
        if (aVar != null) {
            aVar.a(dVar, z4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.g
    public void b(boolean z4) {
        ViewGroup viewGroup = (ViewGroup) this.f6363j;
        if (viewGroup == null) {
            return;
        }
        d dVar = this.f6357c;
        int i4 = 0;
        if (dVar != null) {
            dVar.q();
            ArrayList arrayListA = this.f6357c.A();
            int size = arrayListA.size();
            int i5 = 0;
            for (int i6 = 0; i6 < size; i6++) {
                e eVar = (e) arrayListA.get(i6);
                if (o(i5, eVar)) {
                    View childAt = viewGroup.getChildAt(i5);
                    e itemData = childAt instanceof h.a ? ((h.a) childAt).getItemData() : null;
                    View viewN = n(eVar, childAt, viewGroup);
                    if (eVar != itemData) {
                        viewN.setPressed(false);
                        viewN.jumpDrawablesToCurrentState();
                    }
                    if (viewN != childAt) {
                        e(viewN, i5);
                    }
                    i5++;
                }
            }
            i4 = i5;
        }
        while (i4 < viewGroup.getChildCount()) {
            if (!l(viewGroup, i4)) {
                i4++;
            }
        }
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean d(d dVar, e eVar) {
        return false;
    }

    public void e(View view, int i4) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f6363j).addView(view, i4);
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean f(d dVar, e eVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.g
    public void g(g.a aVar) {
        this.f6360g = aVar;
    }

    @Override // androidx.appcompat.view.menu.g
    public void h(Context context, d dVar) {
        this.f6356b = context;
        this.f6359f = LayoutInflater.from(context);
        this.f6357c = dVar;
    }

    public abstract void i(e eVar, h.a aVar);

    @Override // androidx.appcompat.view.menu.g
    public boolean j(j jVar) {
        g.a aVar = this.f6360g;
        if (aVar != null) {
            return aVar.b(jVar);
        }
        return false;
    }

    public h.a k(ViewGroup viewGroup) {
        return (h.a) this.f6358e.inflate(this.f6362i, viewGroup, false);
    }

    public boolean l(ViewGroup viewGroup, int i4) {
        viewGroup.removeViewAt(i4);
        return true;
    }

    public g.a m() {
        return this.f6360g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View n(e eVar, View view, ViewGroup viewGroup) {
        h.a aVarK = view instanceof h.a ? (h.a) view : k(viewGroup);
        i(eVar, aVarK);
        return (View) aVarK;
    }

    public abstract boolean o(int i4, e eVar);
}
