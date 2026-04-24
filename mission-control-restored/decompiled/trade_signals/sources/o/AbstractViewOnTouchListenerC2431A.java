package o;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;

/* JADX INFO: renamed from: o.A, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractViewOnTouchListenerC2431A implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f21678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f21680c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f21681d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Runnable f21682e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Runnable f21683f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f21684g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f21685h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int[] f21686i = new int[2];

    /* JADX INFO: renamed from: o.A$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = AbstractViewOnTouchListenerC2431A.this.f21681d.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* JADX INFO: renamed from: o.A$b */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractViewOnTouchListenerC2431A.this.e();
        }
    }

    public AbstractViewOnTouchListenerC2431A(View view) {
        this.f21681d = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f21678a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f21679b = tapTimeout;
        this.f21680c = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    public static boolean h(View view, float f8, float f9, float f10) {
        float f11 = -f10;
        return f8 >= f11 && f9 >= f11 && f8 < ((float) (view.getRight() - view.getLeft())) + f10 && f9 < ((float) (view.getBottom() - view.getTop())) + f10;
    }

    public final void a() {
        Runnable runnable = this.f21683f;
        if (runnable != null) {
            this.f21681d.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f21682e;
        if (runnable2 != null) {
            this.f21681d.removeCallbacks(runnable2);
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
        View view = this.f21681d;
        if (view.isEnabled() && !view.isLongClickable() && c()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
            this.f21684g = true;
        }
    }

    public final boolean f(MotionEvent motionEvent) {
        y yVar;
        View view = this.f21681d;
        n.c cVarB = b();
        if (cVarB == null || !cVarB.e() || (yVar = (y) cVarB.i()) == null || !yVar.isShown()) {
            return false;
        }
        MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        i(view, motionEventObtainNoHistory);
        j(yVar, motionEventObtainNoHistory);
        boolean zE = yVar.e(motionEventObtainNoHistory, this.f21685h);
        motionEventObtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        return zE && (actionMasked != 1 && actionMasked != 3);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.f21681d
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
            int r1 = r5.f21685h
            int r1 = r6.findPointerIndex(r1)
            if (r1 < 0) goto L6d
            float r4 = r6.getX(r1)
            float r6 = r6.getY(r1)
            float r1 = r5.f21678a
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
            r5.f21685h = r6
            java.lang.Runnable r6 = r5.f21682e
            if (r6 != 0) goto L52
            o.A$a r6 = new o.A$a
            r6.<init>()
            r5.f21682e = r6
        L52:
            java.lang.Runnable r6 = r5.f21682e
            int r1 = r5.f21679b
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
            java.lang.Runnable r6 = r5.f21683f
            if (r6 != 0) goto L65
            o.A$b r6 = new o.A$b
            r6.<init>()
            r5.f21683f = r6
        L65:
            java.lang.Runnable r6 = r5.f21683f
            int r1 = r5.f21680c
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: o.AbstractViewOnTouchListenerC2431A.g(android.view.MotionEvent):boolean");
    }

    public final boolean i(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f21686i);
        motionEvent.offsetLocation(r0[0], r0[1]);
        return true;
    }

    public final boolean j(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f21686i);
        motionEvent.offsetLocation(-r0[0], -r0[1]);
        return true;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z7;
        boolean z8 = this.f21684g;
        if (z8) {
            z7 = f(motionEvent) || !d();
        } else {
            z7 = g(motionEvent) && c();
            if (z7) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f21681d.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
            }
        }
        this.f21684g = z7;
        return z7 || z8;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.f21684g = false;
        this.f21685h = -1;
        Runnable runnable = this.f21682e;
        if (runnable != null) {
            this.f21681d.removeCallbacks(runnable);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }
}
