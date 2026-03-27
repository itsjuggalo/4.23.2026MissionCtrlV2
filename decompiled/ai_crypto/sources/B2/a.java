package B2;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int[] f718i = new int[3];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final float[] f719j = {0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int[] f720k = new int[4];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final float[] f721l = {0.0f, 0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f724c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f725d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f726e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f727f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Path f728g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f729h;

    public a() {
        this(-16777216);
    }

    public void a(Canvas canvas, Matrix matrix, RectF rectF, int i7, float f7, float f8) {
        boolean z7 = f8 < 0.0f;
        Path path = this.f728g;
        if (z7) {
            int[] iArr = f720k;
            iArr[0] = 0;
            iArr[1] = this.f727f;
            iArr[2] = this.f726e;
            iArr[3] = this.f725d;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f7, f8);
            path.close();
            float f9 = -i7;
            rectF.inset(f9, f9);
            int[] iArr2 = f720k;
            iArr2[0] = 0;
            iArr2[1] = this.f725d;
            iArr2[2] = this.f726e;
            iArr2[3] = this.f727f;
        }
        float fWidth = rectF.width() / 2.0f;
        if (fWidth <= 0.0f) {
            return;
        }
        float f10 = 1.0f - (i7 / fWidth);
        float[] fArr = f721l;
        fArr[1] = f10;
        fArr[2] = ((1.0f - f10) / 2.0f) + f10;
        this.f723b.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), fWidth, f720k, fArr, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!z7) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, this.f729h);
        }
        canvas.drawArc(rectF, f7, f8, true, this.f723b);
        canvas.restore();
    }

    public void b(Canvas canvas, Matrix matrix, RectF rectF, int i7) {
        rectF.bottom += i7;
        rectF.offset(0.0f, -i7);
        int[] iArr = f718i;
        iArr[0] = this.f727f;
        iArr[1] = this.f726e;
        iArr[2] = this.f725d;
        Paint paint = this.f724c;
        float f7 = rectF.left;
        paint.setShader(new LinearGradient(f7, rectF.top, f7, rectF.bottom, iArr, f719j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.f724c);
        canvas.restore();
    }

    public Paint c() {
        return this.f722a;
    }

    public void d(int i7) {
        this.f725d = I.a.j(i7, 68);
        this.f726e = I.a.j(i7, 20);
        this.f727f = I.a.j(i7, 0);
        this.f722a.setColor(this.f725d);
    }

    public a(int i7) {
        this.f728g = new Path();
        Paint paint = new Paint();
        this.f729h = paint;
        this.f722a = new Paint();
        d(i7);
        paint.setColor(0);
        Paint paint2 = new Paint(4);
        this.f723b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f724c = new Paint(paint2);
    }
}
