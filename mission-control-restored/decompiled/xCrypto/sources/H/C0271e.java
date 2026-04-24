package H;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* JADX INFO: renamed from: H.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0271e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0272f f550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f551c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f552d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public VelocityTracker f553e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f554f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f555g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f556h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f557i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int[] f558j;

    /* JADX INFO: renamed from: H.e$a */
    public interface a {
        float a(VelocityTracker velocityTracker, MotionEvent motionEvent, int i4);
    }

    /* JADX INFO: renamed from: H.e$b */
    public interface b {
        void a(Context context, int[] iArr, MotionEvent motionEvent, int i4);
    }

    public C0271e(Context context, InterfaceC0272f interfaceC0272f) {
        this(context, interfaceC0272f, new b() { // from class: H.c
            @Override // H.C0271e.b
            public final void a(Context context2, int[] iArr, MotionEvent motionEvent, int i4) {
                C0271e.c(context2, iArr, motionEvent, i4);
            }
        }, new a() { // from class: H.d
            @Override // H.C0271e.a
            public final float a(VelocityTracker velocityTracker, MotionEvent motionEvent, int i4) {
                return C0271e.f(velocityTracker, motionEvent, i4);
            }
        });
    }

    public static void c(Context context, int[] iArr, MotionEvent motionEvent, int i4) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        iArr[0] = I.i(context, viewConfiguration, motionEvent.getDeviceId(), i4, motionEvent.getSource());
        iArr[1] = I.h(context, viewConfiguration, motionEvent.getDeviceId(), i4, motionEvent.getSource());
    }

    public static float f(VelocityTracker velocityTracker, MotionEvent motionEvent, int i4) {
        B.a(velocityTracker, motionEvent);
        B.b(velocityTracker, 1000);
        return B.d(velocityTracker, i4);
    }

    public final boolean d(MotionEvent motionEvent, int i4) {
        int source = motionEvent.getSource();
        int deviceId = motionEvent.getDeviceId();
        if (this.f556h == source && this.f557i == deviceId && this.f555g == i4) {
            return false;
        }
        this.f551c.a(this.f549a, this.f558j, motionEvent, i4);
        this.f556h = source;
        this.f557i = deviceId;
        this.f555g = i4;
        return true;
    }

    public final float e(MotionEvent motionEvent, int i4) {
        if (this.f553e == null) {
            this.f553e = VelocityTracker.obtain();
        }
        return this.f552d.a(this.f553e, motionEvent, i4);
    }

    public void g(MotionEvent motionEvent, int i4) {
        boolean zD = d(motionEvent, i4);
        if (this.f558j[0] == Integer.MAX_VALUE) {
            VelocityTracker velocityTracker = this.f553e;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f553e = null;
                return;
            }
            return;
        }
        float fE = e(motionEvent, i4) * this.f550b.b();
        float fSignum = Math.signum(fE);
        if (zD || (fSignum != Math.signum(this.f554f) && fSignum != 0.0f)) {
            this.f550b.c();
        }
        float fAbs = Math.abs(fE);
        int[] iArr = this.f558j;
        if (fAbs < iArr[0]) {
            return;
        }
        float fMax = Math.max(-r6, Math.min(fE, iArr[1]));
        this.f554f = this.f550b.a(fMax) ? fMax : 0.0f;
    }

    public C0271e(Context context, InterfaceC0272f interfaceC0272f, b bVar, a aVar) {
        this.f555g = -1;
        this.f556h = -1;
        this.f557i = -1;
        this.f558j = new int[]{Integer.MAX_VALUE, 0};
        this.f549a = context;
        this.f550b = interfaceC0272f;
        this.f551c = bVar;
        this.f552d = aVar;
    }
}
