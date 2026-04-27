package y1;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: renamed from: y1.A, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1937A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TaskCompletionSource f15851b = new TaskCompletionSource();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f15852c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bundle f15853d;

    public AbstractC1937A(int i4, int i5, Bundle bundle) {
        this.f15850a = i4;
        this.f15852c = i5;
        this.f15853d = bundle;
    }

    public abstract void a(Bundle bundle);

    public abstract boolean b();

    public final void c(B b4) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            Log.d("MessengerIpcClient", "Failing " + toString() + " with " + b4.toString());
        }
        this.f15851b.setException(b4);
    }

    public final void d(Object obj) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            Log.d("MessengerIpcClient", "Finishing " + toString() + " with " + String.valueOf(obj));
        }
        this.f15851b.setResult(obj);
    }

    public final String toString() {
        return "Request { what=" + this.f15852c + " id=" + this.f15850a + " oneWay=" + b() + "}";
    }
}
