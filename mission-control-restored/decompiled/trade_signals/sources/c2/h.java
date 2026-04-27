package c2;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public class h extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Looper f13345a;

    public h(Looper looper) {
        super(looper);
        this.f13345a = Looper.getMainLooper();
    }

    public h(Looper looper, Handler.Callback callback) {
        super(looper, callback);
        this.f13345a = Looper.getMainLooper();
    }
}
