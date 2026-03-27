package m;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes.dex */
public final class B0 extends TouchDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f8205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f8206b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f8207c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f8208d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f8209f;

    public B0(Rect rect, Rect rect2, View view) {
        super(rect, view);
        int scaledTouchSlop = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.e = scaledTouchSlop;
        Rect rect3 = new Rect();
        this.f8206b = rect3;
        Rect rect4 = new Rect();
        this.f8208d = rect4;
        Rect rect5 = new Rect();
        this.f8207c = rect5;
        rect3.set(rect);
        rect4.set(rect);
        int i = -scaledTouchSlop;
        rect4.inset(i, i);
        rect5.set(rect2);
        this.f8205a = view;
    }

    @Override // android.view.TouchDelegate
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z6;
        boolean z7;
        int x6 = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        boolean z8 = true;
        if (action != 0) {
            if (action == 1 || action == 2) {
                z7 = this.f8209f;
                if (z7 && !this.f8208d.contains(x6, y)) {
                    z8 = z7;
                    z6 = false;
                }
            } else {
                if (action == 3) {
                    z7 = this.f8209f;
                    this.f8209f = false;
                }
                z6 = true;
                z8 = false;
            }
            z8 = z7;
            z6 = true;
        } else if (this.f8206b.contains(x6, y)) {
            this.f8209f = true;
            z6 = true;
        } else {
            z6 = true;
            z8 = false;
        }
        if (!z8) {
            return false;
        }
        Rect rect = this.f8207c;
        View view = this.f8205a;
        if (!z6 || rect.contains(x6, y)) {
            motionEvent.setLocation(x6 - rect.left, y - rect.top);
        } else {
            motionEvent.setLocation(view.getWidth() / 2, view.getHeight() / 2);
        }
        return view.dispatchTouchEvent(motionEvent);
    }
}
