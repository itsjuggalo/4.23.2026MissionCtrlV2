package C2;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m[] f986a = new m[4];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Matrix[] f987b = new Matrix[4];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix[] f988c = new Matrix[4];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PointF f989d = new PointF();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Path f990e = new Path();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Path f991f = new Path();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final m f992g = new m();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float[] f993h = new float[2];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float[] f994i = new float[2];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Path f995j = new Path();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Path f996k = new Path();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f997l = true;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l f998a = new l();
    }

    public interface b {
        void a(m mVar, Matrix matrix, int i7);

        void b(m mVar, Matrix matrix, int i7);
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k f999a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Path f1000b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final RectF f1001c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final b f1002d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f1003e;

        public c(k kVar, float f7, RectF rectF, b bVar, Path path) {
            this.f1002d = bVar;
            this.f999a = kVar;
            this.f1003e = f7;
            this.f1001c = rectF;
            this.f1000b = path;
        }
    }

    public l() {
        for (int i7 = 0; i7 < 4; i7++) {
            this.f986a[i7] = new m();
            this.f987b[i7] = new Matrix();
            this.f988c[i7] = new Matrix();
        }
    }

    public static l k() {
        return a.f998a;
    }

    public final float a(int i7) {
        return (i7 + 1) * 90;
    }

    public final void b(c cVar, int i7) {
        this.f993h[0] = this.f986a[i7].k();
        this.f993h[1] = this.f986a[i7].l();
        this.f987b[i7].mapPoints(this.f993h);
        if (i7 == 0) {
            Path path = cVar.f1000b;
            float[] fArr = this.f993h;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            Path path2 = cVar.f1000b;
            float[] fArr2 = this.f993h;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.f986a[i7].d(this.f987b[i7], cVar.f1000b);
        b bVar = cVar.f1002d;
        if (bVar != null) {
            bVar.a(this.f986a[i7], this.f987b[i7], i7);
        }
    }

    public final void c(c cVar, int i7) {
        int i8 = (i7 + 1) % 4;
        this.f993h[0] = this.f986a[i7].i();
        this.f993h[1] = this.f986a[i7].j();
        this.f987b[i7].mapPoints(this.f993h);
        this.f994i[0] = this.f986a[i8].k();
        this.f994i[1] = this.f986a[i8].l();
        this.f987b[i8].mapPoints(this.f994i);
        float f7 = this.f993h[0];
        float[] fArr = this.f994i;
        float fMax = Math.max(((float) Math.hypot(f7 - fArr[0], r1[1] - fArr[1])) - 0.001f, 0.0f);
        float fI = i(cVar.f1001c, i7);
        this.f992g.n(0.0f, 0.0f);
        f fVarJ = j(i7, cVar.f999a);
        fVarJ.b(fMax, fI, cVar.f1003e, this.f992g);
        this.f995j.reset();
        this.f992g.d(this.f988c[i7], this.f995j);
        if (this.f997l && (fVarJ.a() || l(this.f995j, i7) || l(this.f995j, i8))) {
            Path path = this.f995j;
            path.op(path, this.f991f, Path.Op.DIFFERENCE);
            this.f993h[0] = this.f992g.k();
            this.f993h[1] = this.f992g.l();
            this.f988c[i7].mapPoints(this.f993h);
            Path path2 = this.f990e;
            float[] fArr2 = this.f993h;
            path2.moveTo(fArr2[0], fArr2[1]);
            this.f992g.d(this.f988c[i7], this.f990e);
        } else {
            this.f992g.d(this.f988c[i7], cVar.f1000b);
        }
        b bVar = cVar.f1002d;
        if (bVar != null) {
            bVar.b(this.f992g, this.f988c[i7], i7);
        }
    }

    public void d(k kVar, float f7, RectF rectF, b bVar, Path path) {
        path.rewind();
        this.f990e.rewind();
        this.f991f.rewind();
        this.f991f.addRect(rectF, Path.Direction.CW);
        c cVar = new c(kVar, f7, rectF, bVar, path);
        for (int i7 = 0; i7 < 4; i7++) {
            m(cVar, i7);
            n(i7);
        }
        for (int i8 = 0; i8 < 4; i8++) {
            b(cVar, i8);
            c(cVar, i8);
        }
        path.close();
        this.f990e.close();
        if (this.f990e.isEmpty()) {
            return;
        }
        path.op(this.f990e, Path.Op.UNION);
    }

    public void e(k kVar, float f7, RectF rectF, Path path) {
        d(kVar, f7, rectF, null, path);
    }

    public final void f(int i7, RectF rectF, PointF pointF) {
        if (i7 == 1) {
            pointF.set(rectF.right, rectF.bottom);
            return;
        }
        if (i7 == 2) {
            pointF.set(rectF.left, rectF.bottom);
        } else if (i7 != 3) {
            pointF.set(rectF.right, rectF.top);
        } else {
            pointF.set(rectF.left, rectF.top);
        }
    }

    public final C2.c g(int i7, k kVar) {
        return i7 != 1 ? i7 != 2 ? i7 != 3 ? kVar.t() : kVar.r() : kVar.j() : kVar.l();
    }

    public final d h(int i7, k kVar) {
        return i7 != 1 ? i7 != 2 ? i7 != 3 ? kVar.s() : kVar.q() : kVar.i() : kVar.k();
    }

    public final float i(RectF rectF, int i7) {
        float[] fArr = this.f993h;
        m mVar = this.f986a[i7];
        fArr[0] = mVar.f1006c;
        fArr[1] = mVar.f1007d;
        this.f987b[i7].mapPoints(fArr);
        return (i7 == 1 || i7 == 3) ? Math.abs(rectF.centerX() - this.f993h[0]) : Math.abs(rectF.centerY() - this.f993h[1]);
    }

    public final f j(int i7, k kVar) {
        return i7 != 1 ? i7 != 2 ? i7 != 3 ? kVar.o() : kVar.p() : kVar.n() : kVar.h();
    }

    public final boolean l(Path path, int i7) {
        this.f996k.reset();
        this.f986a[i7].d(this.f987b[i7], this.f996k);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.f996k.computeBounds(rectF, true);
        path.op(this.f996k, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (rectF.isEmpty()) {
            return rectF.width() > 1.0f && rectF.height() > 1.0f;
        }
        return true;
    }

    public final void m(c cVar, int i7) {
        h(i7, cVar.f999a).b(this.f986a[i7], 90.0f, cVar.f1003e, cVar.f1001c, g(i7, cVar.f999a));
        float fA = a(i7);
        this.f987b[i7].reset();
        f(i7, cVar.f1001c, this.f989d);
        Matrix matrix = this.f987b[i7];
        PointF pointF = this.f989d;
        matrix.setTranslate(pointF.x, pointF.y);
        this.f987b[i7].preRotate(fA);
    }

    public final void n(int i7) {
        this.f993h[0] = this.f986a[i7].i();
        this.f993h[1] = this.f986a[i7].j();
        this.f987b[i7].mapPoints(this.f993h);
        float fA = a(i7);
        this.f988c[i7].reset();
        Matrix matrix = this.f988c[i7];
        float[] fArr = this.f993h;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.f988c[i7].preRotate(fA);
    }
}
