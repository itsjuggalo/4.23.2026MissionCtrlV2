package io.flutter.plugin.editing;

import U4.u;
import android.os.Build;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* JADX INFO: loaded from: classes2.dex */
public class q implements u.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final U4.u f16675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InputMethodManager f16676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f16677c;

    public q(View view, InputMethodManager inputMethodManager, U4.u uVar) {
        if (Build.VERSION.SDK_INT >= 33) {
            view.setAutoHandwritingEnabled(false);
        }
        this.f16677c = view;
        this.f16676b = inputMethodManager;
        this.f16675a = uVar;
        uVar.g(this);
    }

    @Override // U4.u.b
    public void a() {
        this.f16676b.startStylusHandwriting(this.f16677c);
    }

    @Override // U4.u.b
    public boolean b() {
        return this.f16676b.isStylusHandwritingAvailable();
    }

    @Override // U4.u.b
    public boolean c() {
        return Build.VERSION.SDK_INT >= 34 && b();
    }
}
