package g2;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: renamed from: g2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class HandlerC1783a extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Looper f17981a;

    public HandlerC1783a(Looper looper) {
        super(looper);
        this.f17981a = Looper.getMainLooper();
    }
}
