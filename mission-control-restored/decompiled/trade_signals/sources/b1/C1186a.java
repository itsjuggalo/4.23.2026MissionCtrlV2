package b1;

import U0.h;
import a1.C1048h;
import a1.C1053m;
import a1.n;
import a1.o;
import a1.r;
import com.bumptech.glide.load.data.j;

/* JADX INFO: renamed from: b1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1186a implements n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final U0.g f12856b = U0.g.f("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1053m f12857a;

    /* JADX INFO: renamed from: b1.a$a, reason: collision with other inner class name */
    public static class C0217a implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C1053m f12858a = new C1053m(500);

        @Override // a1.o
        public n d(r rVar) {
            return new C1186a(this.f12858a);
        }
    }

    public C1186a(C1053m c1053m) {
        this.f12857a = c1053m;
    }

    @Override // a1.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a a(C1048h c1048h, int i8, int i9, h hVar) {
        C1053m c1053m = this.f12857a;
        if (c1053m != null) {
            C1048h c1048h2 = (C1048h) c1053m.a(c1048h, 0, 0);
            if (c1048h2 == null) {
                this.f12857a.b(c1048h, 0, 0, c1048h);
            } else {
                c1048h = c1048h2;
            }
        }
        return new n.a(c1048h, new j(c1048h, ((Integer) hVar.c(f12856b)).intValue()));
    }

    @Override // a1.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(C1048h c1048h) {
        return true;
    }
}
