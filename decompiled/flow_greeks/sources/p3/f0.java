package p3;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class f0 implements g3.j {
    @Override // g3.j
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public i3.v a(Bitmap bitmap, int i10, int i11, g3.h hVar) {
        return new a(bitmap);
    }

    @Override // g3.j
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(Bitmap bitmap, g3.h hVar) {
        return true;
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements i3.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bitmap f18230a;

        public a(Bitmap bitmap) {
            this.f18230a = bitmap;
        }

        @Override // i3.v
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bitmap get() {
            return this.f18230a;
        }

        @Override // i3.v
        public int c() {
            return c4.l.h(this.f18230a);
        }

        @Override // i3.v
        public Class d() {
            return Bitmap.class;
        }

        @Override // i3.v
        public void b() {
        }
    }
}
