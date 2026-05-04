package i3;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f11784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f11785b = new Handler(Looper.getMainLooper(), new a());

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
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

    public synchronized void a(v vVar, boolean z10) {
        try {
            if (this.f11784a || z10) {
                this.f11785b.obtainMessage(1, vVar).sendToTarget();
            } else {
                this.f11784a = true;
                vVar.b();
                this.f11784a = false;
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
