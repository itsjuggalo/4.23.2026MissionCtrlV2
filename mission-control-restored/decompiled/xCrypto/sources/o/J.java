package o;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import n.InterfaceC1612c;

/* JADX INFO: loaded from: classes.dex */
public abstract class J implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f13678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13680c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f13681e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Runnable f13682f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Runnable f13683g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f13684h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f13685i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int[] f13686j = new int[2];

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = J.this.f13681e.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            J.this.e();
        }
    }

    public J(View view) {
        this.f13681e = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f13678a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f13679b = tapTimeout;
        this.f13680c = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    public static boolean h(View view, float f4, float f5, float f6) {
        float f7 = -f6;
        return f4 >= f7 && f5 >= f7 && f4 < ((float) (view.getRight() - view.getLeft())) + f6 && f5 < ((float) (view.getBottom() - view.getTop())) + f6;
    }

    public final void a() {
        Runnable runnable = this.f13683g;
        if (runnable != null) {
            this.f13681e.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f13682f;
        if (runnable2 != null) {
            this.f13681e.removeCallbacks(runnable2);
        }
    }

    public abstract InterfaceC1612c b();

    public abstract boolean c();

    public boolean d() {
        InterfaceC1612c interfaceC1612cB = b();
        if (interfaceC1612cB == null || !interfaceC1612cB.e()) {
            return true;
        }
        interfaceC1612cB.dismiss();
        return true;
    }

    public void e() {
        a();
        View view = this.f13681e;
        if (view.isEnabled() && !view.isLongClickable() && c()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
            this.f13684h = true;
        }
    }

    public final boolean f(MotionEvent motionEvent) {
        H h4;
        View view = this.f13681e;
        InterfaceC1612c interfaceC1612cB = b();
        if (interfaceC1612cB != null && interfaceC1612cB.e() && (h4 = (H) interfaceC1612cB.i()) != null && h4.isShown()) {
            MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
            i(view, motionEventObtainNoHistory);
            j(h4, motionEventObtainNoHistory);
            boolean zE = h4.e(motionEventObtainNoHistory, this.f13685i);
            motionEventObtainNoHistory.recycle();
            int actionMasked = motionEvent.getActionMasked();
            boolean z4 = (actionMasked == 1 || actionMasked == 3) ? false : true;
            if (zE && z4) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.f13681e
            boolean r1 = r0.isEnabled()
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            int r1 = r6.getActionMasked()
            if (r1 == 0) goto L41
            r3 = 1
            if (r1 == r3) goto L3d
            r4 = 2
            if (r1 == r4) goto L1a
            r6 = 3
            if (r1 == r6) goto L3d
            goto L6d
        L1a:
            int r1 = r5.f13685i
            int r1 = r6.findPointerIndex(r1)
            if (r1 < 0) goto L6d
            float r4 = r6.getX(r1)
            float r6 = r6.getY(r1)
            float r1 = r5.f13678a
            boolean r6 = h(r0, r4, r6, r1)
            if (r6 != 0) goto L6d
            r5.a()
            android.view.ViewParent r6 = r0.getParent()
            r6.requestDisallowInterceptTouchEvent(r3)
            return r3
        L3d:
            r5.a()
            goto L6d
        L41:
            int r6 = r6.getPointerId(r2)
            r5.f13685i = r6
            java.lang.Runnable r6 = r5.f13682f
            if (r6 != 0) goto L52
            o.J$a r6 = new o.J$a
            r6.<init>()
            r5.f13682f = r6
        L52:
            java.lang.Runnable r6 = r5.f13682f
            int r1 = r5.f13679b
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
            java.lang.Runnable r6 = r5.f13683g
            if (r6 != 0) goto L65
            o.J$b r6 = new o.J$b
            r6.<init>()
            r5.f13683g = r6
        L65:
            java.lang.Runnable r6 = r5.f13683g
            int r1 = r5.f13680c
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: o.J.g(android.view.MotionEvent):boolean");
    }

    public final boolean i(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f13686j);
        motionEvent.offsetLocation(r0[0], r0[1]);
        return true;
    }

    public final boolean j(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f13686j);
        motionEvent.offsetLocation(-r0[0], -r0[1]);
        return true;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z4;
        boolean z5 = this.f13684h;
        if (z5) {
            z4 = f(motionEvent) || !d();
        } else {
            z4 = g(motionEvent) && c();
            if (z4) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f13681e.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
            }
        }
        this.f13684h = z4;
        return z4 || z5;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.f13684h = false;
        this.f13685i = -1;
        Runnable runnable = this.f13682f;
        if (runnable != null) {
            this.f13681e.removeCallbacks(runnable);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }
}
