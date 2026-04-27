package C2;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: loaded from: classes3.dex */
public class r implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HandlerThread f225c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Handler f226d;

    public r(String str, int i4) {
        this.f223a = str;
        this.f224b = i4;
    }

    @Override // C2.n
    public void c() {
        HandlerThread handlerThread = this.f225c;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f225c = null;
            this.f226d = null;
        }
    }

    @Override // C2.n
    public void d(k kVar) {
        this.f226d.post(kVar.f203b);
    }

    @Override // C2.n
    public void start() {
        HandlerThread handlerThread = new HandlerThread(this.f223a, this.f224b);
        this.f225c = handlerThread;
        handlerThread.start();
        this.f226d = new Handler(this.f225c.getLooper());
    }
}
