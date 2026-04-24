package K3;

import java.lang.ref.WeakReference;
import t2.u0;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f985a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f988d;
    public final float e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f989f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f990k;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f987c = System.currentTimeMillis();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f986b = 200;

    public b(c cVar, float f6, float f7, float f8, float f9) {
        this.f985a = new WeakReference(cVar);
        this.f988d = f6;
        this.e = f7;
        this.f989f = f8;
        this.f990k = f9;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c cVar = (c) this.f985a.get();
        if (cVar == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f987c;
        long j4 = this.f986b;
        float fMin = Math.min(j4, jCurrentTimeMillis);
        float f6 = j4;
        float fL = u0.l(fMin, this.e, f6);
        if (fMin >= f6) {
            cVar.setImageToWrapCropBounds(true);
        } else {
            cVar.g(this.f988d + fL, this.f989f, this.f990k);
            cVar.post(this);
        }
    }
}
