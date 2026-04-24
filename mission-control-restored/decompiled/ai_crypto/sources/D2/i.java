package D2;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class i extends C2.g {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final RectF f1124z;

    public i(C2.k kVar) {
        super(kVar == null ? new C2.k() : kVar);
        this.f1124z = new RectF();
    }

    public boolean f0() {
        return !this.f1124z.isEmpty();
    }

    public void g0() {
        h0(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public void h0(float f7, float f8, float f9, float f10) {
        RectF rectF = this.f1124z;
        if (f7 == rectF.left && f8 == rectF.top && f9 == rectF.right && f10 == rectF.bottom) {
            return;
        }
        rectF.set(f7, f8, f9, f10);
        invalidateSelf();
    }

    public void i0(RectF rectF) {
        h0(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    @Override // C2.g
    public void r(Canvas canvas) {
        if (this.f1124z.isEmpty()) {
            super.r(canvas);
            return;
        }
        canvas.save();
        if (Build.VERSION.SDK_INT >= 26) {
            canvas.clipOutRect(this.f1124z);
        } else {
            canvas.clipRect(this.f1124z, Region.Op.DIFFERENCE);
        }
        super.r(canvas);
        canvas.restore();
    }
}
