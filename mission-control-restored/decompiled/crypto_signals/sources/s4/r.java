package s4;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Z3.v f9748a = Z3.v.f4019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C1056c f9749b;

    public r(C1056c c1056c) {
        this.f9749b = c1056c;
    }

    public final io.flutter.plugin.platform.f a(Object obj) {
        if (((Integer) obj) == null) {
            throw new IllegalStateException("An identifier is required to retrieve a View instance.");
        }
        Object objE = this.f9749b.e(r0.intValue());
        if (objE instanceof io.flutter.plugin.platform.f) {
            return (io.flutter.plugin.platform.f) objE;
        }
        if (objE instanceof View) {
            return new C1070q((View) objE);
        }
        throw new IllegalStateException("Unable to find a PlatformView or View instance: " + obj + ", " + objE);
    }
}
