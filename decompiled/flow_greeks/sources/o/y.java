package o;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class y implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f17394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f17397d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Runnable f17398e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Runnable f17399f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f17400g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f17401h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int[] f17402i = new int[2];

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = y.this.f17397d.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            y.this.e();
        }
    }

    public y(View view) {
        this.f17397d = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f17394a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f17395b = tapTimeout;
        this.f17396c = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    public static boolean h(View view, float f10, float f11, float f12) {
        float f13 = -f12;
        return f10 >= f13 && f11 >= f13 && f10 < ((float) (view.getRight() - view.getLeft())) + f12 && f11 < ((float) (view.getBottom() - view.getTop())) + f12;
    }

    public final void a() {
        Runnable runnable = this.f17399f;
        if (runnable != null) {
            this.f17397d.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f17398e;
        if (runnable2 != null) {
            this.f17397d.removeCallbacks(runnable2);
        }
    }

    public abstract n.c b();

    public abstract boolean c();

    public boolean d() {
        n.c cVarB = b();
        if (cVarB == null || !cVarB.e()) {
            return true;
        }
        cVarB.dismiss();
        return true;
    }

    public void e() {
        a();
        View view = this.f17397d;
        if (view.isEnabled() && !view.isLongClickable() && c()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
            this.f17400g = true;
        }
    }

    public final boolean f(MotionEvent motionEvent) {
        w wVar;
        View view = this.f17397d;
        n.c cVarB = b();
        if (cVarB != null && cVarB.e() && (wVar = (w) cVarB.i()) != null && wVar.isShown()) {
            MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
            i(view, motionEventObtainNoHistory);
            j(wVar, motionEventObtainNoHistory);
            boolean zE = wVar.e(motionEventObtainNoHistory, this.f17401h);
            motionEventObtainNoHistory.recycle();
            int actionMasked = motionEvent.getActionMasked();
            boolean z10 = (actionMasked == 1 || actionMasked == 3) ? false : true;
            if (zE && z10) {
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
            android.view.View r0 = r5.f17397d
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
            int r1 = r5.f17401h
            int r1 = r6.findPointerIndex(r1)
            if (r1 < 0) goto L6d
            float r4 = r6.getX(r1)
            float r6 = r6.getY(r1)
            float r1 = r5.f17394a
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
            r5.f17401h = r6
            java.lang.Runnable r6 = r5.f17398e
            if (r6 != 0) goto L52
            o.y$a r6 = new o.y$a
            r6.<init>()
            r5.f17398e = r6
        L52:
            java.lang.Runnable r6 = r5.f17398e
            int r1 = r5.f17395b
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
            java.lang.Runnable r6 = r5.f17399f
            if (r6 != 0) goto L65
            o.y$b r6 = new o.y$b
            r6.<init>()
            r5.f17399f = r6
        L65:
            java.lang.Runnable r6 = r5.f17399f
            int r1 = r5.f17396c
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: o.y.g(android.view.MotionEvent):boolean");
    }

    public final boolean i(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f17402i);
        motionEvent.offsetLocation(r0[0], r0[1]);
        return true;
    }

    public final boolean j(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f17402i);
        motionEvent.offsetLocation(-r0[0], -r0[1]);
        return true;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z10;
        boolean z11 = this.f17400g;
        if (z11) {
            z10 = f(motionEvent) || !d();
        } else {
            z10 = g(motionEvent) && c();
            if (z10) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f17397d.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
            }
        }
        this.f17400g = z10;
        return z10 || z11;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.f17400g = false;
        this.f17401h = -1;
        Runnable runnable = this.f17398e;
        if (runnable != null) {
            this.f17397d.removeCallbacks(runnable);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }
}
