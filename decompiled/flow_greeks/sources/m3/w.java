package m3;

import com.bumptech.glide.load.data.d;
import m3.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class w implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f15839a = new w();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f15840a = new a();

        public static a a() {
            return f15840a;
        }

        @Override // m3.o
        public n d(r rVar) {
            return w.c();
        }
    }

    public static w c() {
        return f15839a;
    }

    @Override // m3.n
    public boolean a(Object obj) {
        return true;
    }

    @Override // m3.n
    public n.a b(Object obj, int i10, int i11, g3.h hVar) {
        return new n.a(new b4.b(obj), new b(obj));
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b implements com.bumptech.glide.load.data.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f15841a;

        public b(Object obj) {
            this.f15841a = obj;
        }

        @Override // com.bumptech.glide.load.data.d
        public Class a() {
            return this.f15841a.getClass();
        }

        @Override // com.bumptech.glide.load.data.d
        public g3.a d() {
            return g3.a.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.d
        public void e(com.bumptech.glide.g gVar, d.a aVar) {
            aVar.f(this.f15841a);
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }
    }
}
