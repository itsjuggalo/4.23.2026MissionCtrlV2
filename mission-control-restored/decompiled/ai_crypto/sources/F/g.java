package F;

import Q.AbstractC0678t;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.lifecycle.AbstractC0963i;
import androidx.lifecycle.C0968n;
import androidx.lifecycle.InterfaceC0967m;
import androidx.lifecycle.x;

/* JADX INFO: loaded from: classes.dex */
public abstract class g extends Activity implements InterfaceC0967m, AbstractC0678t.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u.g f1708a = new u.g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0968n f1709b = new C0968n(this);

    @Override // androidx.lifecycle.InterfaceC0967m
    public AbstractC0963i a() {
        return this.f1709b;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent event) {
        kotlin.jvm.internal.r.f(event, "event");
        View decorView = getWindow().getDecorView();
        kotlin.jvm.internal.r.e(decorView, "window.decorView");
        if (AbstractC0678t.d(decorView, event)) {
            return true;
        }
        return AbstractC0678t.e(this, decorView, this, event);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        kotlin.jvm.internal.r.f(event, "event");
        View decorView = getWindow().getDecorView();
        kotlin.jvm.internal.r.e(decorView, "window.decorView");
        if (AbstractC0678t.d(decorView, event)) {
            return true;
        }
        return super.dispatchKeyShortcutEvent(event);
    }

    @Override // Q.AbstractC0678t.a
    public boolean j(KeyEvent event) {
        kotlin.jvm.internal.r.f(event, "event");
        return super.dispatchKeyEvent(event);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.f7834b.c(this);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        kotlin.jvm.internal.r.f(outState, "outState");
        this.f1709b.m(AbstractC0963i.b.CREATED);
        super.onSaveInstanceState(outState);
    }

    public final boolean r(String[] strArr) {
        return !s(strArr);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final boolean s(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        String str = strArr[0];
        switch (str.hashCode()) {
            case -645125871:
                return str.equals("--translation") && Build.VERSION.SDK_INT >= 31;
            case 100470631:
                if (!str.equals("--dump-dumpable")) {
                    return false;
                }
                break;
            case 472614934:
                if (!str.equals("--list-dumpables")) {
                    return false;
                }
                break;
            case 1159329357:
                return str.equals("--contentcapture") && Build.VERSION.SDK_INT >= 29;
            case 1455016274:
                return str.equals("--autofill") && Build.VERSION.SDK_INT >= 26;
            default:
                return false;
        }
        return Build.VERSION.SDK_INT >= 33;
    }
}
