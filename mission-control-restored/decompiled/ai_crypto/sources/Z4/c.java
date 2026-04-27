package Z4;

import U4.v;
import android.app.Activity;
import android.os.Build;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class c implements v.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f6014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f6016c;

    public c(int i7, Activity activity, v vVar) {
        this.f6014a = activity;
        this.f6015b = i7;
        this.f6016c = vVar;
        vVar.f(this);
    }

    @Override // U4.v.b
    public boolean a() {
        return Build.VERSION.SDK_INT >= 35;
    }

    @Override // U4.v.b
    public int b() {
        if (!a()) {
            return 2;
        }
        View viewFindViewById = this.f6014a.findViewById(this.f6015b);
        if (viewFindViewById != null) {
            return viewFindViewById.getContentSensitivity();
        }
        throw new IllegalArgumentException(e());
    }

    @Override // U4.v.b
    public void c(int i7) {
        if (!a()) {
            throw new IllegalStateException(f());
        }
        View viewFindViewById = this.f6014a.findViewById(this.f6015b);
        if (viewFindViewById == null) {
            throw new IllegalArgumentException(e());
        }
        if (viewFindViewById.getContentSensitivity() == i7) {
            return;
        }
        viewFindViewById.setContentSensitivity(i7);
        viewFindViewById.invalidate();
    }

    public void d() {
        this.f6016c.f(null);
        this.f6014a = null;
    }

    public final String e() {
        return "FlutterView with ID " + this.f6015b + "not found";
    }

    public final String f() {
        return "isSupported() should be called before attempting to set content sensitivity as it is not supported on this device.";
    }
}
