package p3;

import android.graphics.Bitmap;
import java.io.IOException;
import java.io.InputStream;
import p3.p;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d0 implements g3.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f18218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j3.b f18219b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a implements p.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b0 f18220a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c4.d f18221b;

        public a(b0 b0Var, c4.d dVar) {
            this.f18220a = b0Var;
            this.f18221b = dVar;
        }

        @Override // p3.p.b
        public void a(j3.d dVar, Bitmap bitmap) throws IOException {
            IOException iOExceptionB = this.f18221b.b();
            if (iOExceptionB != null) {
                if (bitmap == null) {
                    throw iOExceptionB;
                }
                dVar.c(bitmap);
                throw iOExceptionB;
            }
        }

        @Override // p3.p.b
        public void b() {
            this.f18220a.c();
        }
    }

    public d0(p pVar, j3.b bVar) {
        this.f18218a = pVar;
        this.f18219b = bVar;
    }

    @Override // g3.j
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public i3.v a(InputStream inputStream, int i10, int i11, g3.h hVar) {
        boolean z10;
        b0 b0Var;
        if (inputStream instanceof b0) {
            b0Var = (b0) inputStream;
            z10 = false;
        } else {
            z10 = true;
            b0Var = new b0(inputStream, this.f18219b);
        }
        c4.d dVarC = c4.d.c(b0Var);
        try {
            i3.v vVarE = this.f18218a.e(new c4.i(dVarC), i10, i11, hVar, new a(b0Var, dVarC));
            dVarC.e();
            if (z10) {
                b0Var.e();
            }
            return vVarE;
        } finally {
        }
    }

    @Override // g3.j
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(InputStream inputStream, g3.h hVar) {
        return this.f18218a.p(inputStream);
    }
}
