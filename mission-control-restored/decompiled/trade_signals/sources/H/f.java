package H;

import T.AbstractC0928j;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.lifecycle.AbstractC1157i;
import androidx.lifecycle.C1162n;
import androidx.lifecycle.InterfaceC1161m;
import androidx.lifecycle.x;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public abstract class f extends Activity implements InterfaceC1161m, AbstractC0928j.a {
    private final w.i extraDataMap = new w.i();
    private final C1162n lifecycleRegistry = new C1162n(this);

    public static class a {
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final boolean a(String[] strArr) {
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

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent event) {
        AbstractC2304t.f(event, "event");
        View decorView = getWindow().getDecorView();
        AbstractC2304t.e(decorView, "window.decorView");
        if (AbstractC0928j.d(decorView, event)) {
            return true;
        }
        return AbstractC0928j.e(this, decorView, this, event);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        AbstractC2304t.f(event, "event");
        View decorView = getWindow().getDecorView();
        AbstractC2304t.e(decorView, "window.decorView");
        if (AbstractC0928j.d(decorView, event)) {
            return true;
        }
        return super.dispatchKeyShortcutEvent(event);
    }

    public <T extends a> T getExtraData(Class<T> extraDataClass) {
        AbstractC2304t.f(extraDataClass, "extraDataClass");
        android.support.v4.media.session.b.a(this.extraDataMap.get(extraDataClass));
        return null;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.f12021b.c(this);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        AbstractC2304t.f(outState, "outState");
        this.lifecycleRegistry.m(AbstractC1157i.b.CREATED);
        super.onSaveInstanceState(outState);
    }

    public void putExtraData(a extraData) {
        AbstractC2304t.f(extraData, "extraData");
        throw null;
    }

    public final boolean shouldDumpInternalState(String[] strArr) {
        return !a(strArr);
    }

    @Override // T.AbstractC0928j.a
    public boolean superDispatchKeyEvent(KeyEvent event) {
        AbstractC2304t.f(event, "event");
        return super.dispatchKeyEvent(event);
    }
}
