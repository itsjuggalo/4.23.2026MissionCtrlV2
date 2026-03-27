package C2;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f1004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f1005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f1006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f1007d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f1008e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f1009f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List f1010g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List f1011h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1012i;

    public class a extends g {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List f1013c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Matrix f1014d;

        public a(List list, Matrix matrix) {
            this.f1013c = list;
            this.f1014d = matrix;
        }

        @Override // C2.m.g
        public void b(Matrix matrix, B2.a aVar, int i7, Canvas canvas) {
            Iterator it = this.f1013c.iterator();
            while (it.hasNext()) {
                ((g) it.next()).b(this.f1014d, aVar, i7, canvas);
            }
        }
    }

    public static class b extends g {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final d f1016c;

        public b(d dVar) {
            this.f1016c = dVar;
        }

        @Override // C2.m.g
        public void b(Matrix matrix, B2.a aVar, int i7, Canvas canvas) {
            aVar.a(canvas, matrix, new RectF(this.f1016c.k(), this.f1016c.o(), this.f1016c.l(), this.f1016c.j()), i7, this.f1016c.m(), this.f1016c.n());
        }
    }

    public static class c extends g {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final e f1017c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f1018d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f1019e;

        public c(e eVar, float f7, float f8) {
            this.f1017c = eVar;
            this.f1018d = f7;
            this.f1019e = f8;
        }

        @Override // C2.m.g
        public void b(Matrix matrix, B2.a aVar, int i7, Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(this.f1017c.f1028c - this.f1019e, this.f1017c.f1027b - this.f1018d), 0.0f);
            this.f1031a.set(matrix);
            this.f1031a.preTranslate(this.f1018d, this.f1019e);
            this.f1031a.preRotate(c());
            aVar.b(canvas, this.f1031a, rectF, i7);
        }

        public float c() {
            return (float) Math.toDegrees(Math.atan((this.f1017c.f1028c - this.f1019e) / (this.f1017c.f1027b - this.f1018d)));
        }
    }

    public static class d extends f {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final RectF f1020h = new RectF();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f1021b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f1022c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f1023d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f1024e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f1025f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f1026g;

        public d(float f7, float f8, float f9, float f10) {
            q(f7);
            u(f8);
            r(f9);
            p(f10);
        }

        @Override // C2.m.f
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f1029a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF = f1020h;
            rectF.set(k(), o(), l(), j());
            path.arcTo(rectF, m(), n(), false);
            path.transform(matrix);
        }

        public final float j() {
            return this.f1024e;
        }

        public final float k() {
            return this.f1021b;
        }

        public final float l() {
            return this.f1023d;
        }

        public final float m() {
            return this.f1025f;
        }

        public final float n() {
            return this.f1026g;
        }

        public final float o() {
            return this.f1022c;
        }

        public final void p(float f7) {
            this.f1024e = f7;
        }

        public final void q(float f7) {
            this.f1021b = f7;
        }

        public final void r(float f7) {
            this.f1023d = f7;
        }

        public final void s(float f7) {
            this.f1025f = f7;
        }

        public final void t(float f7) {
            this.f1026g = f7;
        }

        public final void u(float f7) {
            this.f1022c = f7;
        }
    }

    public static class e extends f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f1027b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f1028c;

        @Override // C2.m.f
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f1029a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f1027b, this.f1028c);
            path.transform(matrix);
        }
    }

    public static abstract class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Matrix f1029a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    public static abstract class g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Matrix f1030b = new Matrix();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Matrix f1031a = new Matrix();

        public final void a(B2.a aVar, int i7, Canvas canvas) {
            b(f1030b, aVar, i7, canvas);
        }

        public abstract void b(Matrix matrix, B2.a aVar, int i7, Canvas canvas);
    }

    public m() {
        n(0.0f, 0.0f);
    }

    public void a(float f7, float f8, float f9, float f10, float f11, float f12) {
        d dVar = new d(f7, f8, f9, f10);
        dVar.s(f11);
        dVar.t(f12);
        this.f1010g.add(dVar);
        b bVar = new b(dVar);
        float f13 = f11 + f12;
        boolean z7 = f12 < 0.0f;
        if (z7) {
            f11 = (f11 + 180.0f) % 360.0f;
        }
        c(bVar, f11, z7 ? (180.0f + f13) % 360.0f : f13);
        double d7 = f13;
        r(((f7 + f9) * 0.5f) + (((f9 - f7) / 2.0f) * ((float) Math.cos(Math.toRadians(d7)))));
        s(((f8 + f10) * 0.5f) + (((f10 - f8) / 2.0f) * ((float) Math.sin(Math.toRadians(d7)))));
    }

    public final void b(float f7) {
        if (g() == f7) {
            return;
        }
        float fG = ((f7 - g()) + 360.0f) % 360.0f;
        if (fG > 180.0f) {
            return;
        }
        d dVar = new d(i(), j(), i(), j());
        dVar.s(g());
        dVar.t(fG);
        this.f1011h.add(new b(dVar));
        p(f7);
    }

    public final void c(g gVar, float f7, float f8) {
        b(f7);
        this.f1011h.add(gVar);
        p(f8);
    }

    public void d(Matrix matrix, Path path) {
        int size = this.f1010g.size();
        for (int i7 = 0; i7 < size; i7++) {
            ((f) this.f1010g.get(i7)).a(matrix, path);
        }
    }

    public boolean e() {
        return this.f1012i;
    }

    public g f(Matrix matrix) {
        b(h());
        return new a(new ArrayList(this.f1011h), new Matrix(matrix));
    }

    public final float g() {
        return this.f1008e;
    }

    public final float h() {
        return this.f1009f;
    }

    public float i() {
        return this.f1006c;
    }

    public float j() {
        return this.f1007d;
    }

    public float k() {
        return this.f1004a;
    }

    public float l() {
        return this.f1005b;
    }

    public void m(float f7, float f8) {
        e eVar = new e();
        eVar.f1027b = f7;
        eVar.f1028c = f8;
        this.f1010g.add(eVar);
        c cVar = new c(eVar, i(), j());
        c(cVar, cVar.c() + 270.0f, cVar.c() + 270.0f);
        r(f7);
        s(f8);
    }

    public void n(float f7, float f8) {
        o(f7, f8, 270.0f, 0.0f);
    }

    public void o(float f7, float f8, float f9, float f10) {
        t(f7);
        u(f8);
        r(f7);
        s(f8);
        p(f9);
        q((f9 + f10) % 360.0f);
        this.f1010g.clear();
        this.f1011h.clear();
        this.f1012i = false;
    }

    public final void p(float f7) {
        this.f1008e = f7;
    }

    public final void q(float f7) {
        this.f1009f = f7;
    }

    public final void r(float f7) {
        this.f1006c = f7;
    }

    public final void s(float f7) {
        this.f1007d = f7;
    }

    public final void t(float f7) {
        this.f1004a = f7;
    }

    public final void u(float f7) {
        this.f1005b = f7;
    }
}
