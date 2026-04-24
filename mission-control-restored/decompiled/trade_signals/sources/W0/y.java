package W0;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f9245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f9246b = new Handler(Looper.getMainLooper(), new a());

    public static final class a implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((v) message.obj).b();
            return true;
        }
    }

    public synchronized void a(v vVar, boolean z7) {
        try {
            if (this.f9245a || z7) {
                this.f9246b.obtainMessage(1, vVar).sendToTarget();
            } else {
                this.f9245a = true;
                vVar.b();
                this.f9245a = false;
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
