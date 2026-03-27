package v4;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: loaded from: classes.dex */
public class t implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f23871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f23872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HandlerThread f23873c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Handler f23874d;

    public t(String str, int i8) {
        this.f23871a = str;
        this.f23872b = i8;
    }

    @Override // v4.p
    public void b(m mVar) {
        this.f23874d.post(mVar.f23851b);
    }

    @Override // v4.p
    public void c() {
        HandlerThread handlerThread = this.f23873c;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f23873c = null;
            this.f23874d = null;
        }
    }

    @Override // v4.p
    public void start() {
        HandlerThread handlerThread = new HandlerThread(this.f23871a, this.f23872b);
        this.f23873c = handlerThread;
        handlerThread.start();
        this.f23874d = new Handler(this.f23873c.getLooper());
    }
}
