package y1;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.cloudmessaging.zzf;

/* JADX INFO: loaded from: classes.dex */
public final class i extends zzf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C1940c f15884a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(C1940c c1940c, Looper looper) {
        super(looper);
        this.f15884a = c1940c;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        C1940c.g(this.f15884a, message);
    }
}
