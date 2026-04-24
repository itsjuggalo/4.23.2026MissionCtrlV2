package androidx.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.AbstractC0846i;
import androidx.lifecycle.C0851n;
import androidx.lifecycle.InterfaceC0850m;
import androidx.lifecycle.O;

/* JADX INFO: loaded from: classes.dex */
public class l extends Dialog implements InterfaceC0850m, s, o0.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C0851n f6280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o0.e f6281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q f6282c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(Context context, int i4) {
        super(context, i4);
        kotlin.jvm.internal.r.f(context, "context");
        this.f6281b = o0.e.f13909d.a(this);
        this.f6282c = new q(new Runnable() { // from class: androidx.activity.k
            @Override // java.lang.Runnable
            public final void run() {
                l.d(this.f6279a);
            }
        });
    }

    public static final void d(l this$0) {
        kotlin.jvm.internal.r.f(this$0, "this$0");
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        kotlin.jvm.internal.r.f(view, "view");
        c();
        super.addContentView(view, layoutParams);
    }

    public final C0851n b() {
        C0851n c0851n = this.f6280a;
        if (c0851n != null) {
            return c0851n;
        }
        C0851n c0851n2 = new C0851n(this);
        this.f6280a = c0851n2;
        return c0851n2;
    }

    public void c() {
        Window window = getWindow();
        kotlin.jvm.internal.r.c(window);
        View decorView = window.getDecorView();
        kotlin.jvm.internal.r.e(decorView, "window!!.decorView");
        O.a(decorView, this);
        Window window2 = getWindow();
        kotlin.jvm.internal.r.c(window2);
        View decorView2 = window2.getDecorView();
        kotlin.jvm.internal.r.e(decorView2, "window!!.decorView");
        v.a(decorView2, this);
        Window window3 = getWindow();
        kotlin.jvm.internal.r.c(window3);
        View decorView3 = window3.getDecorView();
        kotlin.jvm.internal.r.e(decorView3, "window!!.decorView");
        o0.g.a(decorView3, this);
    }

    @Override // androidx.lifecycle.InterfaceC0850m
    public AbstractC0846i getLifecycle() {
        return b();
    }

    @Override // androidx.activity.s
    public final q getOnBackPressedDispatcher() {
        return this.f6282c;
    }

    @Override // o0.f
    public o0.d getSavedStateRegistry() {
        return this.f6281b.b();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        this.f6282c.k();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            q qVar = this.f6282c;
            OnBackInvokedDispatcher onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            kotlin.jvm.internal.r.e(onBackInvokedDispatcher, "onBackInvokedDispatcher");
            qVar.n(onBackInvokedDispatcher);
        }
        this.f6281b.d(bundle);
        b().h(AbstractC0846i.a.ON_CREATE);
    }

    @Override // android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle bundleOnSaveInstanceState = super.onSaveInstanceState();
        kotlin.jvm.internal.r.e(bundleOnSaveInstanceState, "super.onSaveInstanceState()");
        this.f6281b.e(bundleOnSaveInstanceState);
        return bundleOnSaveInstanceState;
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        b().h(AbstractC0846i.a.ON_RESUME);
    }

    @Override // android.app.Dialog
    public void onStop() {
        b().h(AbstractC0846i.a.ON_DESTROY);
        this.f6280a = null;
        super.onStop();
    }

    @Override // android.app.Dialog
    public void setContentView(int i4) {
        c();
        super.setContentView(i4);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        kotlin.jvm.internal.r.f(view, "view");
        c();
        super.setContentView(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        kotlin.jvm.internal.r.f(view, "view");
        c();
        super.setContentView(view, layoutParams);
    }
}
