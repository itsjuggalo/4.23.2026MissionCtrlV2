package T;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* JADX INFO: renamed from: T.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0923e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0924f f7841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f7842c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f7843d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public VelocityTracker f7844e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f7845f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f7846g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f7847h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f7848i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int[] f7849j;

    /* JADX INFO: renamed from: T.e$a */
    public interface a {
        float a(VelocityTracker velocityTracker, MotionEvent motionEvent, int i8);
    }

    /* JADX INFO: renamed from: T.e$b */
    public interface b {
        void a(Context context, int[] iArr, MotionEvent motionEvent, int i8);
    }

    public C0923e(Context context, InterfaceC0924f interfaceC0924f) {
        this(context, interfaceC0924f, new b() { // from class: T.c
            @Override // T.C0923e.b
            public final void a(Context context2, int[] iArr, MotionEvent motionEvent, int i8) {
                C0923e.c(context2, iArr, motionEvent, i8);
            }
        }, new a() { // from class: T.d
            @Override // T.C0923e.a
            public final float a(VelocityTracker velocityTracker, MotionEvent motionEvent, int i8) {
                return C0923e.f(velocityTracker, motionEvent, i8);
            }
        });
    }

    public static void c(Context context, int[] iArr, MotionEvent motionEvent, int i8) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        iArr[0] = H.i(context, viewConfiguration, motionEvent.getDeviceId(), i8, motionEvent.getSource());
        iArr[1] = H.h(context, viewConfiguration, motionEvent.getDeviceId(), i8, motionEvent.getSource());
    }

    public static float f(VelocityTracker velocityTracker, MotionEvent motionEvent, int i8) {
        A.a(velocityTracker, motionEvent);
        A.b(velocityTracker, 1000);
        return A.d(velocityTracker, i8);
    }

    public final boolean d(MotionEvent motionEvent, int i8) {
        int source = motionEvent.getSource();
        int deviceId = motionEvent.getDeviceId();
        if (this.f7847h == source && this.f7848i == deviceId && this.f7846g == i8) {
            return false;
        }
        this.f7842c.a(this.f7840a, this.f7849j, motionEvent, i8);
        this.f7847h = source;
        this.f7848i = deviceId;
        this.f7846g = i8;
        return true;
    }

    public final float e(MotionEvent motionEvent, int i8) {
        if (this.f7844e == null) {
            this.f7844e = VelocityTracker.obtain();
        }
        return this.f7843d.a(this.f7844e, motionEvent, i8);
    }

    public void g(MotionEvent motionEvent, int i8) {
        boolean zD = d(motionEvent, i8);
        if (this.f7849j[0] == Integer.MAX_VALUE) {
            VelocityTracker velocityTracker = this.f7844e;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f7844e = null;
                return;
            }
            return;
        }
        float fE = e(motionEvent, i8) * this.f7841b.b();
        float fSignum = Math.signum(fE);
        if (zD || (fSignum != Math.signum(this.f7845f) && fSignum != 0.0f)) {
            this.f7841b.c();
        }
        float fAbs = Math.abs(fE);
        int[] iArr = this.f7849j;
        if (fAbs < iArr[0]) {
            return;
        }
        float fMax = Math.max(-r6, Math.min(fE, iArr[1]));
        this.f7845f = this.f7841b.a(fMax) ? fMax : 0.0f;
    }

    public C0923e(Context context, InterfaceC0924f interfaceC0924f, b bVar, a aVar) {
        this.f7846g = -1;
        this.f7847h = -1;
        this.f7848i = -1;
        this.f7849j = new int[]{Integer.MAX_VALUE, 0};
        this.f7840a = context;
        this.f7841b = interfaceC0924f;
        this.f7842c = bVar;
        this.f7843d = aVar;
    }
}
