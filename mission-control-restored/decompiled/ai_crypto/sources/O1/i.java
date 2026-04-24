package O1;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.cloudmessaging.zzf;

/* JADX INFO: loaded from: classes.dex */
public final class i extends zzf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0641c f4084a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(C0641c c0641c, Looper looper) {
        super(looper);
        this.f4084a = c0641c;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        C0641c.g(this.f4084a, message);
    }
}
