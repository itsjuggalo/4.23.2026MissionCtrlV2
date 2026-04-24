package P1;

import android.os.Looper;
import android.os.Message;
import d2.HandlerC1624f;

/* JADX INFO: loaded from: classes.dex */
public final class i extends HandlerC1624f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0759c f6318b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(C0759c c0759c, Looper looper) {
        super(looper);
        this.f6318b = c0759c;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        C0759c.g(this.f6318b, message);
    }
}
