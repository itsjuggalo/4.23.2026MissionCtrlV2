package U3;

import U3.k0;
import android.content.Intent;
import android.os.Binder;
import android.os.Process;
import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes.dex */
public class h0 extends Binder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f4916a;

    public interface a {
        Task a(Intent intent);
    }

    public h0(a aVar) {
        this.f4916a = aVar;
    }

    public void c(final k0.a aVar) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException("Binding only allowed within app");
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "service received new intent via bind strategy");
        }
        this.f4916a.a(aVar.f4930a).addOnCompleteListener(new B0.k(), new OnCompleteListener() { // from class: U3.g0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                aVar.d();
            }
        });
    }
}
