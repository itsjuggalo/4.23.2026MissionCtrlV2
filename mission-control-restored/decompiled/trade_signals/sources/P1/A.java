package P1;

import android.os.Bundle;
import android.util.Log;
import l2.C2329m;

/* JADX INFO: loaded from: classes.dex */
public abstract class A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2329m f6283b = new C2329m();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bundle f6285d;

    public A(int i8, int i9, Bundle bundle) {
        this.f6282a = i8;
        this.f6284c = i9;
        this.f6285d = bundle;
    }

    public abstract void a(Bundle bundle);

    public abstract boolean b();

    public final void c(B b8) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            Log.d("MessengerIpcClient", "Failing " + toString() + " with " + b8.toString());
        }
        this.f6283b.b(b8);
    }

    public final void d(Object obj) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            Log.d("MessengerIpcClient", "Finishing " + toString() + " with " + String.valueOf(obj));
        }
        this.f6283b.c(obj);
    }

    public final String toString() {
        return "Request { what=" + this.f6284c + " id=" + this.f6282a + " oneWay=" + b() + "}";
    }
}
