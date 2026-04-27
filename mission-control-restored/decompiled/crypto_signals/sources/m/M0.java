package m;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import k.InterfaceC0747a;

/* JADX INFO: loaded from: classes.dex */
public final class M0 implements l.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l.i f8257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l.j f8258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Toolbar f8259c;

    public M0(Toolbar toolbar) {
        this.f8259c = toolbar;
    }

    @Override // l.p
    public final void c() {
        if (this.f8258b != null) {
            l.i iVar = this.f8257a;
            if (iVar != null) {
                int size = iVar.f7986f.size();
                for (int i = 0; i < size; i++) {
                    if (this.f8257a.getItem(i) == this.f8258b) {
                        return;
                    }
                }
            }
            k(this.f8258b);
        }
    }

    @Override // l.p
    public final boolean f(l.j jVar) {
        Toolbar toolbar = this.f8259c;
        toolbar.c();
        ViewParent parent = toolbar.f4398l.getParent();
        if (parent != toolbar) {
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(toolbar.f4398l);
            }
            toolbar.addView(toolbar.f4398l);
        }
        View view = jVar.f8024z;
        if (view == null) {
            view = null;
        }
        toolbar.f4399m = view;
        this.f8258b = jVar;
        ViewParent parent2 = view.getParent();
        if (parent2 != toolbar) {
            if (parent2 instanceof ViewGroup) {
                ((ViewGroup) parent2).removeView(toolbar.f4399m);
            }
            N0 n0G = Toolbar.g();
            n0G.f8263a = (toolbar.f4404r & 112) | 8388611;
            n0G.f8264b = 2;
            toolbar.f4399m.setLayoutParams(n0G);
            toolbar.addView(toolbar.f4399m);
        }
        for (int childCount = toolbar.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = toolbar.getChildAt(childCount);
            if (((N0) childAt.getLayoutParams()).f8264b != 2 && childAt != toolbar.f4392a) {
                toolbar.removeViewAt(childCount);
                toolbar.f4382I.add(childAt);
            }
        }
        toolbar.requestLayout();
        jVar.f8001B = true;
        jVar.f8013n.o(false);
        KeyEvent.Callback callback = toolbar.f4399m;
        if (callback instanceof InterfaceC0747a) {
            SearchView searchView = (SearchView) ((InterfaceC0747a) callback);
            if (!searchView.f4317d0) {
                searchView.f4317d0 = true;
                SearchView.SearchAutoComplete searchAutoComplete = searchView.f4324t;
                int imeOptions = searchAutoComplete.getImeOptions();
                searchView.f4318e0 = imeOptions;
                searchAutoComplete.setImeOptions(imeOptions | 33554432);
                searchAutoComplete.setText("");
                searchView.setIconified(false);
            }
        }
        toolbar.s();
        return true;
    }

    @Override // l.p
    public final void g(Context context, l.i iVar) {
        l.j jVar;
        l.i iVar2 = this.f8257a;
        if (iVar2 != null && (jVar = this.f8258b) != null) {
            iVar2.d(jVar);
        }
        this.f8257a = iVar;
    }

    @Override // l.p
    public final boolean h() {
        return false;
    }

    @Override // l.p
    public final boolean i(l.t tVar) {
        return false;
    }

    @Override // l.p
    public final boolean k(l.j jVar) {
        Toolbar toolbar = this.f8259c;
        KeyEvent.Callback callback = toolbar.f4399m;
        if (callback instanceof InterfaceC0747a) {
            SearchView searchView = (SearchView) ((InterfaceC0747a) callback);
            SearchView.SearchAutoComplete searchAutoComplete = searchView.f4324t;
            searchAutoComplete.setText("");
            searchAutoComplete.setSelection(searchAutoComplete.length());
            searchView.f4316c0 = "";
            searchView.clearFocus();
            searchView.u(true);
            searchAutoComplete.setImeOptions(searchView.f4318e0);
            searchView.f4317d0 = false;
        }
        toolbar.removeView(toolbar.f4399m);
        toolbar.removeView(toolbar.f4398l);
        toolbar.f4399m = null;
        ArrayList arrayList = toolbar.f4382I;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            toolbar.addView((View) arrayList.get(size));
        }
        arrayList.clear();
        this.f8258b = null;
        toolbar.requestLayout();
        jVar.f8001B = false;
        jVar.f8013n.o(false);
        toolbar.s();
        return true;
    }

    @Override // l.p
    public final void a(l.i iVar, boolean z6) {
    }
}
