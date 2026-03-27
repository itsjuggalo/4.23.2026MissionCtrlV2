package O1;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public abstract class A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TaskCompletionSource f4049b = new TaskCompletionSource();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4050c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bundle f4051d;

    public A(int i7, int i8, Bundle bundle) {
        this.f4048a = i7;
        this.f4050c = i8;
        this.f4051d = bundle;
    }

    public abstract void a(Bundle bundle);

    public abstract boolean b();

    public final void c(B b7) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            Log.d("MessengerIpcClient", "Failing " + toString() + " with " + b7.toString());
        }
        this.f4049b.setException(b7);
    }

    public final void d(Object obj) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            Log.d("MessengerIpcClient", "Finishing " + toString() + " with " + String.valueOf(obj));
        }
        this.f4049b.setResult(obj);
    }

    public final String toString() {
        return "Request { what=" + this.f4050c + " id=" + this.f4048a + " oneWay=" + b() + "}";
    }
}
