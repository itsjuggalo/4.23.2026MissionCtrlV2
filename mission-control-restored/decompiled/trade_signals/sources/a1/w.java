package a1;

import a1.n;
import com.bumptech.glide.load.data.d;
import p1.C2543b;

/* JADX INFO: loaded from: classes.dex */
public class w implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f9901a = new w();

    public static class a implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f9902a = new a();

        public static a a() {
            return f9902a;
        }

        @Override // a1.o
        public n d(r rVar) {
            return w.c();
        }
    }

    public static w c() {
        return f9901a;
    }

    @Override // a1.n
    public n.a a(Object obj, int i8, int i9, U0.h hVar) {
        return new n.a(new C2543b(obj), new b(obj));
    }

    @Override // a1.n
    public boolean b(Object obj) {
        return true;
    }

    public static class b implements com.bumptech.glide.load.data.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f9903a;

        public b(Object obj) {
            this.f9903a = obj;
        }

        @Override // com.bumptech.glide.load.data.d
        public Class a() {
            return this.f9903a.getClass();
        }

        @Override // com.bumptech.glide.load.data.d
        public U0.a d() {
            return U0.a.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.d
        public void e(com.bumptech.glide.g gVar, d.a aVar) {
            aVar.f(this.f9903a);
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }
    }
}
