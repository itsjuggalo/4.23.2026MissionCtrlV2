package l5;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TaskCompletionSource f15432b = new TaskCompletionSource();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f15433c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bundle f15434d;

    public a0(int i10, int i11, Bundle bundle) {
        this.f15431a = i10;
        this.f15433c = i11;
        this.f15434d = bundle;
    }

    public abstract void a(Bundle bundle);

    public abstract boolean b();

    public final void c(b0 b0Var) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            Log.d("MessengerIpcClient", "Failing " + toString() + " with " + b0Var.toString());
        }
        this.f15432b.setException(b0Var);
    }

    public final void d(Object obj) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            Log.d("MessengerIpcClient", "Finishing " + toString() + " with " + String.valueOf(obj));
        }
        this.f15432b.setResult(obj);
    }

    public final String toString() {
        return "Request { what=" + this.f15433c + " id=" + this.f15431a + " oneWay=" + b() + "}";
    }
}
