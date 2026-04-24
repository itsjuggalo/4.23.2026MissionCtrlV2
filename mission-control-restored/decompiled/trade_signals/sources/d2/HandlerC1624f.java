package d2;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: renamed from: d2.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class HandlerC1624f extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Looper f16842a;

    public HandlerC1624f(Looper looper) {
        super(looper);
        this.f16842a = Looper.getMainLooper();
    }

    public HandlerC1624f(Looper looper, Handler.Callback callback) {
        super(looper, callback);
        this.f16842a = Looper.getMainLooper();
    }
}
