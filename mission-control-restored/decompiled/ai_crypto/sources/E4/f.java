package E4;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f1642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f1643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f1644c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f1645d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1646e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1647f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f1648g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1649h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f1650i;

    public interface a {
        boolean a(f fVar);
    }

    public static class b implements a {
    }

    public f(a aVar) {
        this.f1650i = aVar;
    }

    public final float a(float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14) {
        return b((float) Math.toDegrees((float) Math.atan2(f8 - f10, f7 - f9)), (float) Math.toDegrees((float) Math.atan2(f12 - f14, f11 - f13)));
    }

    public final float b(float f7, float f8) {
        float f9 = (f8 % 360.0f) - (f7 % 360.0f);
        this.f1648g = f9;
        if (f9 < -180.0f) {
            this.f1648g = f9 + 360.0f;
        } else if (f9 > 180.0f) {
            this.f1648g = f9 - 360.0f;
        }
        return this.f1648g;
    }

    public float c() {
        return this.f1648g;
    }

    public boolean d(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1644c = motionEvent.getX();
            this.f1645d = motionEvent.getY();
            this.f1646e = motionEvent.findPointerIndex(motionEvent.getPointerId(0));
            this.f1648g = 0.0f;
            this.f1649h = true;
        } else if (actionMasked == 1) {
            this.f1646e = -1;
        } else if (actionMasked != 2) {
            if (actionMasked == 5) {
                this.f1642a = motionEvent.getX();
                this.f1643b = motionEvent.getY();
                this.f1647f = motionEvent.findPointerIndex(motionEvent.getPointerId(motionEvent.getActionIndex()));
                this.f1648g = 0.0f;
                this.f1649h = true;
            } else if (actionMasked == 6) {
                this.f1647f = -1;
            }
        } else if (this.f1646e != -1 && this.f1647f != -1 && motionEvent.getPointerCount() > this.f1647f) {
            float x7 = motionEvent.getX(this.f1646e);
            float y7 = motionEvent.getY(this.f1646e);
            float x8 = motionEvent.getX(this.f1647f);
            float y8 = motionEvent.getY(this.f1647f);
            if (this.f1649h) {
                this.f1648g = 0.0f;
                this.f1649h = false;
            } else {
                a(this.f1642a, this.f1643b, this.f1644c, this.f1645d, x8, y8, x7, y7);
            }
            a aVar = this.f1650i;
            if (aVar != null) {
                aVar.a(this);
            }
            this.f1642a = x8;
            this.f1643b = y8;
            this.f1644c = x7;
            this.f1645d = y7;
        }
        return true;
    }
}
