package d1;

import android.graphics.Bitmap;
import d1.r;
import java.io.IOException;
import java.io.InputStream;
import q1.C2621d;
import q1.C2626i;

/* JADX INFO: loaded from: classes.dex */
public class C implements U0.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f16751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final X0.b f16752b;

    public static class a implements r.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C1611A f16753a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C2621d f16754b;

        public a(C1611A c1611a, C2621d c2621d) {
            this.f16753a = c1611a;
            this.f16754b = c2621d;
        }

        @Override // d1.r.b
        public void a(X0.d dVar, Bitmap bitmap) throws IOException {
            IOException iOExceptionA = this.f16754b.a();
            if (iOExceptionA != null) {
                if (bitmap == null) {
                    throw iOExceptionA;
                }
                dVar.c(bitmap);
                throw iOExceptionA;
            }
        }

        @Override // d1.r.b
        public void b() {
            this.f16753a.c();
        }
    }

    public C(r rVar, X0.b bVar) {
        this.f16751a = rVar;
        this.f16752b = bVar;
    }

    @Override // U0.j
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public W0.v a(InputStream inputStream, int i8, int i9, U0.h hVar) {
        boolean z7;
        C1611A c1611a;
        if (inputStream instanceof C1611A) {
            c1611a = (C1611A) inputStream;
            z7 = false;
        } else {
            z7 = true;
            c1611a = new C1611A(inputStream, this.f16752b);
        }
        C2621d c2621dC = C2621d.c(c1611a);
        try {
            return this.f16751a.f(new C2626i(c2621dC), i8, i9, hVar, new a(c1611a, c2621dC));
        } finally {
            c2621dC.e();
            if (z7) {
                c1611a.e();
            }
        }
    }

    @Override // U0.j
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(InputStream inputStream, U0.h hVar) {
        return this.f16751a.p(inputStream);
    }
}
