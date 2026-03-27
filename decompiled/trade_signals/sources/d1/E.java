package d1;

import android.graphics.Bitmap;
import q1.AbstractC2629l;

/* JADX INFO: loaded from: classes.dex */
public final class E implements U0.j {
    @Override // U0.j
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public W0.v a(Bitmap bitmap, int i8, int i9, U0.h hVar) {
        return new a(bitmap);
    }

    @Override // U0.j
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(Bitmap bitmap, U0.h hVar) {
        return true;
    }

    public static final class a implements W0.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bitmap f16760a;

        public a(Bitmap bitmap) {
            this.f16760a = bitmap;
        }

        @Override // W0.v
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bitmap get() {
            return this.f16760a;
        }

        @Override // W0.v
        public int c() {
            return AbstractC2629l.h(this.f16760a);
        }

        @Override // W0.v
        public Class d() {
            return Bitmap.class;
        }

        @Override // W0.v
        public void b() {
        }
    }
}
