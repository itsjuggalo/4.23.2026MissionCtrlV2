package y4;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: loaded from: classes2.dex */
public class r implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f25744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f25745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HandlerThread f25746c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Handler f25747d;

    public r(String str, int i7) {
        this.f25744a = str;
        this.f25745b = i7;
    }

    @Override // y4.n
    public void a(k kVar) {
        this.f25747d.post(kVar.f25724b);
    }

    @Override // y4.n
    public void c() {
        HandlerThread handlerThread = this.f25746c;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f25746c = null;
            this.f25747d = null;
        }
    }

    @Override // y4.n
    public void start() {
        HandlerThread handlerThread = new HandlerThread(this.f25744a, this.f25745b);
        this.f25746c = handlerThread;
        handlerThread.start();
        this.f25747d = new Handler(this.f25746c.getLooper());
    }
}
