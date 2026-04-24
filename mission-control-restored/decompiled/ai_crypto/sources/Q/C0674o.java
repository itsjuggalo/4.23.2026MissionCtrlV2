package Q;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.google.android.gms.common.api.a;

/* JADX INFO: renamed from: Q.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0674o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0675p f4455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f4456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f4457d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public VelocityTracker f4458e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f4459f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f4460g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f4461h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f4462i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int[] f4463j;

    /* JADX INFO: renamed from: Q.o$a */
    public interface a {
        float a(VelocityTracker velocityTracker, MotionEvent motionEvent, int i7);
    }

    /* JADX INFO: renamed from: Q.o$b */
    public interface b {
        void a(Context context, int[] iArr, MotionEvent motionEvent, int i7);
    }

    public C0674o(Context context, InterfaceC0675p interfaceC0675p) {
        this(context, interfaceC0675p, new b() { // from class: Q.m
            @Override // Q.C0674o.b
            public final void a(Context context2, int[] iArr, MotionEvent motionEvent, int i7) {
                C0674o.c(context2, iArr, motionEvent, i7);
            }
        }, new a() { // from class: Q.n
            @Override // Q.C0674o.a
            public final float a(VelocityTracker velocityTracker, MotionEvent motionEvent, int i7) {
                return C0674o.f(velocityTracker, motionEvent, i7);
            }
        });
    }

    public static void c(Context context, int[] iArr, MotionEvent motionEvent, int i7) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        iArr[0] = S.i(context, viewConfiguration, motionEvent.getDeviceId(), i7, motionEvent.getSource());
        iArr[1] = S.h(context, viewConfiguration, motionEvent.getDeviceId(), i7, motionEvent.getSource());
    }

    public static float f(VelocityTracker velocityTracker, MotionEvent motionEvent, int i7) {
        K.a(velocityTracker, motionEvent);
        K.b(velocityTracker, 1000);
        return K.d(velocityTracker, i7);
    }

    public final boolean d(MotionEvent motionEvent, int i7) {
        int source = motionEvent.getSource();
        int deviceId = motionEvent.getDeviceId();
        if (this.f4461h == source && this.f4462i == deviceId && this.f4460g == i7) {
            return false;
        }
        this.f4456c.a(this.f4454a, this.f4463j, motionEvent, i7);
        this.f4461h = source;
        this.f4462i = deviceId;
        this.f4460g = i7;
        return true;
    }

    public final float e(MotionEvent motionEvent, int i7) {
        if (this.f4458e == null) {
            this.f4458e = VelocityTracker.obtain();
        }
        return this.f4457d.a(this.f4458e, motionEvent, i7);
    }

    public void g(MotionEvent motionEvent, int i7) {
        boolean zD = d(motionEvent, i7);
        if (this.f4463j[0] == Integer.MAX_VALUE) {
            VelocityTracker velocityTracker = this.f4458e;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f4458e = null;
                return;
            }
            return;
        }
        float fE = e(motionEvent, i7) * this.f4455b.b();
        float fSignum = Math.signum(fE);
        if (zD || (fSignum != Math.signum(this.f4459f) && fSignum != 0.0f)) {
            this.f4455b.c();
        }
        float fAbs = Math.abs(fE);
        int[] iArr = this.f4463j;
        if (fAbs < iArr[0]) {
            return;
        }
        float fMax = Math.max(-r6, Math.min(fE, iArr[1]));
        this.f4459f = this.f4455b.a(fMax) ? fMax : 0.0f;
    }

    public C0674o(Context context, InterfaceC0675p interfaceC0675p, b bVar, a aVar) {
        this.f4460g = -1;
        this.f4461h = -1;
        this.f4462i = -1;
        this.f4463j = new int[]{a.e.API_PRIORITY_OTHER, 0};
        this.f4454a = context;
        this.f4455b = interfaceC0675p;
        this.f4456c = bVar;
        this.f4457d = aVar;
    }
}
