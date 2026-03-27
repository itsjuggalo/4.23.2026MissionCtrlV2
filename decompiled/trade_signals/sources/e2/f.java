package e2;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public class f extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Looper f17143a;

    public f(Looper looper) {
        super(looper);
        this.f17143a = Looper.getMainLooper();
    }

    public f(Looper looper, Handler.Callback callback) {
        super(looper, callback);
        this.f17143a = Looper.getMainLooper();
    }
}
