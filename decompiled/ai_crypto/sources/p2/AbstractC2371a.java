package p2;

import Q.N;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.gms.common.api.a;

/* JADX INFO: renamed from: p2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2371a extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Runnable f21472d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OverScroller f21473e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f21474f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f21475g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f21476h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f21477i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public VelocityTracker f21478j;

    /* JADX INFO: renamed from: p2.a$a, reason: collision with other inner class name */
    public class RunnableC0334a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CoordinatorLayout f21479a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f21480b;

        public RunnableC0334a(CoordinatorLayout coordinatorLayout, View view) {
            this.f21479a = coordinatorLayout;
            this.f21480b = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.f21480b == null || (overScroller = AbstractC2371a.this.f21473e) == null) {
                return;
            }
            if (!overScroller.computeScrollOffset()) {
                AbstractC2371a.this.M(this.f21479a, this.f21480b);
                return;
            }
            AbstractC2371a abstractC2371a = AbstractC2371a.this;
            abstractC2371a.O(this.f21479a, this.f21480b, abstractC2371a.f21473e.getCurrY());
            N.d0(this.f21480b, this);
        }
    }

    public AbstractC2371a() {
        this.f21475g = -1;
        this.f21477i = -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean D(androidx.coordinatorlayout.widget.CoordinatorLayout r12, android.view.View r13, android.view.MotionEvent r14) {
        /*
            r11 = this;
            int r0 = r14.getActionMasked()
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 == r2) goto L4e
            r4 = 2
            if (r0 == r4) goto L2d
            r12 = 3
            if (r0 == r12) goto L72
            r12 = 6
            if (r0 == r12) goto L13
            goto L4c
        L13:
            int r12 = r14.getActionIndex()
            if (r12 != 0) goto L1b
            r12 = r2
            goto L1c
        L1b:
            r12 = r3
        L1c:
            int r13 = r14.getPointerId(r12)
            r11.f21475g = r13
            float r12 = r14.getY(r12)
            r13 = 1056964608(0x3f000000, float:0.5)
            float r12 = r12 + r13
            int r12 = (int) r12
            r11.f21476h = r12
            goto L4c
        L2d:
            int r0 = r11.f21475g
            int r0 = r14.findPointerIndex(r0)
            if (r0 != r1) goto L36
            return r3
        L36:
            float r0 = r14.getY(r0)
            int r0 = (int) r0
            int r1 = r11.f21476h
            int r7 = r1 - r0
            r11.f21476h = r0
            int r8 = r11.J(r13)
            r9 = 0
            r4 = r11
            r5 = r12
            r6 = r13
            r4.N(r5, r6, r7, r8, r9)
        L4c:
            r12 = r3
            goto L81
        L4e:
            android.view.VelocityTracker r0 = r11.f21478j
            if (r0 == 0) goto L72
            r0.addMovement(r14)
            android.view.VelocityTracker r0 = r11.f21478j
            r4 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r4)
            android.view.VelocityTracker r0 = r11.f21478j
            int r4 = r11.f21475g
            float r10 = r0.getYVelocity(r4)
            int r0 = r11.K(r13)
            int r8 = -r0
            r9 = 0
            r5 = r11
            r6 = r12
            r7 = r13
            r5.I(r6, r7, r8, r9, r10)
            r12 = r2
            goto L73
        L72:
            r12 = r3
        L73:
            r11.f21474f = r3
            r11.f21475g = r1
            android.view.VelocityTracker r13 = r11.f21478j
            if (r13 == 0) goto L81
            r13.recycle()
            r13 = 0
            r11.f21478j = r13
        L81:
            android.view.VelocityTracker r13 = r11.f21478j
            if (r13 == 0) goto L88
            r13.addMovement(r14)
        L88:
            boolean r13 = r11.f21474f
            if (r13 != 0) goto L90
            if (r12 == 0) goto L8f
            goto L90
        L8f:
            r2 = r3
        L90:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p2.AbstractC2371a.D(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    public abstract boolean G(View view);

    public final void H() {
        if (this.f21478j == null) {
            this.f21478j = VelocityTracker.obtain();
        }
    }

    public final boolean I(CoordinatorLayout coordinatorLayout, View view, int i7, int i8, float f7) {
        Runnable runnable = this.f21472d;
        if (runnable != null) {
            view.removeCallbacks(runnable);
            this.f21472d = null;
        }
        if (this.f21473e == null) {
            this.f21473e = new OverScroller(view.getContext());
        }
        this.f21473e.fling(0, E(), 0, Math.round(f7), 0, 0, i7, i8);
        if (!this.f21473e.computeScrollOffset()) {
            M(coordinatorLayout, view);
            return false;
        }
        RunnableC0334a runnableC0334a = new RunnableC0334a(coordinatorLayout, view);
        this.f21472d = runnableC0334a;
        N.d0(view, runnableC0334a);
        return true;
    }

    public abstract int J(View view);

    public abstract int K(View view);

    public abstract int L();

    public abstract void M(CoordinatorLayout coordinatorLayout, View view);

    public final int N(CoordinatorLayout coordinatorLayout, View view, int i7, int i8, int i9) {
        return P(coordinatorLayout, view, L() - i7, i8, i9);
    }

    public int O(CoordinatorLayout coordinatorLayout, View view, int i7) {
        return P(coordinatorLayout, view, i7, Integer.MIN_VALUE, a.e.API_PRIORITY_OTHER);
    }

    public abstract int P(CoordinatorLayout coordinatorLayout, View view, int i7, int i8, int i9);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        int iFindPointerIndex;
        if (this.f21477i < 0) {
            this.f21477i = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f21474f) {
            int i7 = this.f21475g;
            if (i7 == -1 || (iFindPointerIndex = motionEvent.findPointerIndex(i7)) == -1) {
                return false;
            }
            int y7 = (int) motionEvent.getY(iFindPointerIndex);
            if (Math.abs(y7 - this.f21476h) > this.f21477i) {
                this.f21476h = y7;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f21475g = -1;
            int x7 = (int) motionEvent.getX();
            int y8 = (int) motionEvent.getY();
            boolean z7 = G(view) && coordinatorLayout.z(view, x7, y8);
            this.f21474f = z7;
            if (z7) {
                this.f21476h = y8;
                this.f21475g = motionEvent.getPointerId(0);
                H();
                OverScroller overScroller = this.f21473e;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f21473e.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f21478j;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    public AbstractC2371a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21475g = -1;
        this.f21477i = -1;
    }
}
