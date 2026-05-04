package androidx.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.i;
import androidx.lifecycle.n0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class k extends Dialog implements androidx.lifecycle.m, r, k2.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public androidx.lifecycle.n f908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k2.e f909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p f910c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(Context context, int i10) {
        super(context, i10);
        kotlin.jvm.internal.t.f(context, "context");
        this.f909b = k2.e.f14486d.a(this);
        this.f910c = new p(new Runnable() { // from class: androidx.activity.j
            @Override // java.lang.Runnable
            public final void run() {
                k.d(this.f907a);
            }
        });
    }

    public static final void d(k this$0) {
        kotlin.jvm.internal.t.f(this$0, "this$0");
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        kotlin.jvm.internal.t.f(view, "view");
        c();
        super.addContentView(view, layoutParams);
    }

    public final androidx.lifecycle.n b() {
        androidx.lifecycle.n nVar = this.f908a;
        if (nVar != null) {
            return nVar;
        }
        androidx.lifecycle.n nVar2 = new androidx.lifecycle.n(this);
        this.f908a = nVar2;
        return nVar2;
    }

    public void c() {
        Window window = getWindow();
        kotlin.jvm.internal.t.c(window);
        View decorView = window.getDecorView();
        kotlin.jvm.internal.t.e(decorView, "window!!.decorView");
        n0.a(decorView, this);
        Window window2 = getWindow();
        kotlin.jvm.internal.t.c(window2);
        View decorView2 = window2.getDecorView();
        kotlin.jvm.internal.t.e(decorView2, "window!!.decorView");
        u.a(decorView2, this);
        Window window3 = getWindow();
        kotlin.jvm.internal.t.c(window3);
        View decorView3 = window3.getDecorView();
        kotlin.jvm.internal.t.e(decorView3, "window!!.decorView");
        k2.g.a(decorView3, this);
    }

    @Override // androidx.lifecycle.m
    public androidx.lifecycle.i getLifecycle() {
        return b();
    }

    @Override // androidx.activity.r
    public final p getOnBackPressedDispatcher() {
        return this.f910c;
    }

    @Override // k2.f
    public k2.d getSavedStateRegistry() {
        return this.f909b.b();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        this.f910c.k();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            p pVar = this.f910c;
            OnBackInvokedDispatcher onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            kotlin.jvm.internal.t.e(onBackInvokedDispatcher, "onBackInvokedDispatcher");
            pVar.n(onBackInvokedDispatcher);
        }
        this.f909b.d(bundle);
        b().h(i.a.ON_CREATE);
    }

    @Override // android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle bundleOnSaveInstanceState = super.onSaveInstanceState();
        kotlin.jvm.internal.t.e(bundleOnSaveInstanceState, "super.onSaveInstanceState()");
        this.f909b.e(bundleOnSaveInstanceState);
        return bundleOnSaveInstanceState;
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        b().h(i.a.ON_RESUME);
    }

    @Override // android.app.Dialog
    public void onStop() {
        b().h(i.a.ON_DESTROY);
        this.f908a = null;
        super.onStop();
    }

    @Override // android.app.Dialog
    public void setContentView(int i10) {
        c();
        super.setContentView(i10);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        kotlin.jvm.internal.t.f(view, "view");
        c();
        super.setContentView(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        kotlin.jvm.internal.t.f(view, "view");
        c();
        super.setContentView(view, layoutParams);
    }
}
