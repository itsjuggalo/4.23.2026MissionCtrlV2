package t1;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;
import e3.v;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TaskCompletionSource f9904b = new TaskCompletionSource();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bundle f9906d;
    public final /* synthetic */ int e;

    public m(int i, int i6, Bundle bundle, int i7) {
        this.e = i7;
        this.f9903a = i;
        this.f9905c = i6;
        this.f9906d = bundle;
    }

    public final boolean a() {
        switch (this.e) {
            case 0:
                return true;
            default:
                return false;
        }
    }

    public final void b(v vVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            Log.d("MessengerIpcClient", "Failing " + toString() + " with " + vVar.toString());
        }
        this.f9904b.setException(vVar);
    }

    public final void c(Bundle bundle) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            Log.d("MessengerIpcClient", "Finishing " + toString() + " with " + String.valueOf(bundle));
        }
        this.f9904b.setResult(bundle);
    }

    public final String toString() {
        return "Request { what=" + this.f9905c + " id=" + this.f9903a + " oneWay=" + a() + "}";
    }
}
