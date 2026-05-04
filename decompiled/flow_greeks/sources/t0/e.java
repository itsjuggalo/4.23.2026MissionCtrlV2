package t0;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.google.android.gms.common.api.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f20480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f20481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f20482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f20483d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public VelocityTracker f20484e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f20485f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f20486g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f20487h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f20488i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int[] f20489j;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface a {
        float a(VelocityTracker velocityTracker, MotionEvent motionEvent, int i10);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface b {
        void a(Context context, int[] iArr, MotionEvent motionEvent, int i10);
    }

    public e(Context context, f fVar) {
        this(context, fVar, new b() { // from class: t0.c
            @Override // t0.e.b
            public final void a(Context context2, int[] iArr, MotionEvent motionEvent, int i10) {
                e.c(context2, iArr, motionEvent, i10);
            }
        }, new a() { // from class: t0.d
            @Override // t0.e.a
            public final float a(VelocityTracker velocityTracker, MotionEvent motionEvent, int i10) {
                return e.f(velocityTracker, motionEvent, i10);
            }
        });
    }

    public static void c(Context context, int[] iArr, MotionEvent motionEvent, int i10) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        iArr[0] = f0.i(context, viewConfiguration, motionEvent.getDeviceId(), i10, motionEvent.getSource());
        iArr[1] = f0.h(context, viewConfiguration, motionEvent.getDeviceId(), i10, motionEvent.getSource());
    }

    public static float f(VelocityTracker velocityTracker, MotionEvent motionEvent, int i10) {
        z.a(velocityTracker, motionEvent);
        z.b(velocityTracker, 1000);
        return z.d(velocityTracker, i10);
    }

    public final boolean d(MotionEvent motionEvent, int i10) {
        int source = motionEvent.getSource();
        int deviceId = motionEvent.getDeviceId();
        if (this.f20487h == source && this.f20488i == deviceId && this.f20486g == i10) {
            return false;
        }
        this.f20482c.a(this.f20480a, this.f20489j, motionEvent, i10);
        this.f20487h = source;
        this.f20488i = deviceId;
        this.f20486g = i10;
        return true;
    }

    public final float e(MotionEvent motionEvent, int i10) {
        if (this.f20484e == null) {
            this.f20484e = VelocityTracker.obtain();
        }
        return this.f20483d.a(this.f20484e, motionEvent, i10);
    }

    public void g(MotionEvent motionEvent, int i10) {
        boolean zD = d(motionEvent, i10);
        if (this.f20489j[0] == Integer.MAX_VALUE) {
            VelocityTracker velocityTracker = this.f20484e;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f20484e = null;
                return;
            }
            return;
        }
        float fE = e(motionEvent, i10) * this.f20481b.b();
        float fSignum = Math.signum(fE);
        if (zD || (fSignum != Math.signum(this.f20485f) && fSignum != 0.0f)) {
            this.f20481b.c();
        }
        float fAbs = Math.abs(fE);
        int[] iArr = this.f20489j;
        if (fAbs < iArr[0]) {
            return;
        }
        float fMax = Math.max(-r6, Math.min(fE, iArr[1]));
        this.f20485f = this.f20481b.a(fMax) ? fMax : 0.0f;
    }

    public e(Context context, f fVar, b bVar, a aVar) {
        this.f20486g = -1;
        this.f20487h = -1;
        this.f20488i = -1;
        this.f20489j = new int[]{a.e.API_PRIORITY_OTHER, 0};
        this.f20480a = context;
        this.f20481b = fVar;
        this.f20482c = bVar;
        this.f20483d = aVar;
    }
}
