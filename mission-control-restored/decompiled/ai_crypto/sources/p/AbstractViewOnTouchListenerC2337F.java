package p;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import o.InterfaceC2281c;

/* JADX INFO: renamed from: p.F, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractViewOnTouchListenerC2337F implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f21187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f21189c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f21190d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Runnable f21191e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Runnable f21192f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f21193g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f21194h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int[] f21195i = new int[2];

    /* JADX INFO: renamed from: p.F$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = AbstractViewOnTouchListenerC2337F.this.f21190d.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* JADX INFO: renamed from: p.F$b */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractViewOnTouchListenerC2337F.this.e();
        }
    }

    public AbstractViewOnTouchListenerC2337F(View view) {
        this.f21190d = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f21187a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f21188b = tapTimeout;
        this.f21189c = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    public static boolean h(View view, float f7, float f8, float f9) {
        float f10 = -f9;
        return f7 >= f10 && f8 >= f10 && f7 < ((float) (view.getRight() - view.getLeft())) + f9 && f8 < ((float) (view.getBottom() - view.getTop())) + f9;
    }

    public final void a() {
        Runnable runnable = this.f21192f;
        if (runnable != null) {
            this.f21190d.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f21191e;
        if (runnable2 != null) {
            this.f21190d.removeCallbacks(runnable2);
        }
    }

    public abstract InterfaceC2281c b();

    public abstract boolean c();

    public boolean d() {
        InterfaceC2281c interfaceC2281cB = b();
        if (interfaceC2281cB == null || !interfaceC2281cB.f()) {
            return true;
        }
        interfaceC2281cB.dismiss();
        return true;
    }

    public void e() {
        a();
        View view = this.f21190d;
        if (view.isEnabled() && !view.isLongClickable() && c()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
            this.f21193g = true;
        }
    }

    public final boolean f(MotionEvent motionEvent) {
        AbstractC2335D abstractC2335D;
        View view = this.f21190d;
        InterfaceC2281c interfaceC2281cB = b();
        if (interfaceC2281cB == null || !interfaceC2281cB.f() || (abstractC2335D = (AbstractC2335D) interfaceC2281cB.j()) == null || !abstractC2335D.isShown()) {
            return false;
        }
        MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        i(view, motionEventObtainNoHistory);
        j(abstractC2335D, motionEventObtainNoHistory);
        boolean zE = abstractC2335D.e(motionEventObtainNoHistory, this.f21194h);
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
            android.view.View r0 = r5.f21190d
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
            int r1 = r5.f21194h
            int r1 = r6.findPointerIndex(r1)
            if (r1 < 0) goto L6d
            float r4 = r6.getX(r1)
            float r6 = r6.getY(r1)
            float r1 = r5.f21187a
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
            r5.f21194h = r6
            java.lang.Runnable r6 = r5.f21191e
            if (r6 != 0) goto L52
            p.F$a r6 = new p.F$a
            r6.<init>()
            r5.f21191e = r6
        L52:
            java.lang.Runnable r6 = r5.f21191e
            int r1 = r5.f21188b
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
            java.lang.Runnable r6 = r5.f21192f
            if (r6 != 0) goto L65
            p.F$b r6 = new p.F$b
            r6.<init>()
            r5.f21192f = r6
        L65:
            java.lang.Runnable r6 = r5.f21192f
            int r1 = r5.f21189c
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p.AbstractViewOnTouchListenerC2337F.g(android.view.MotionEvent):boolean");
    }

    public final boolean i(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f21195i);
        motionEvent.offsetLocation(r0[0], r0[1]);
        return true;
    }

    public final boolean j(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f21195i);
        motionEvent.offsetLocation(-r0[0], -r0[1]);
        return true;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z7;
        boolean z8 = this.f21193g;
        if (z8) {
            z7 = f(motionEvent) || !d();
        } else {
            z7 = g(motionEvent) && c();
            if (z7) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f21190d.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
            }
        }
        this.f21193g = z7;
        return z7 || z8;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.f21193g = false;
        this.f21194h = -1;
        Runnable runnable = this.f21191e;
        if (runnable != null) {
            this.f21190d.removeCallbacks(runnable);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }
}
