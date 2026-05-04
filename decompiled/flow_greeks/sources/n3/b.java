package n3;

import android.content.Context;
import android.net.Uri;
import g3.h;
import m3.n;
import m3.o;
import m3.r;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f16612a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f16613a;

        public a(Context context) {
            this.f16613a = context;
        }

        @Override // m3.o
        public n d(r rVar) {
            return new b(this.f16613a);
        }
    }

    public b(Context context) {
        this.f16612a = context.getApplicationContext();
    }

    @Override // m3.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a b(Uri uri, int i10, int i11, h hVar) {
        if (h3.b.f(i10, i11)) {
            return new n.a(new b4.b(uri), h3.c.f(this.f16612a, uri));
        }
        return null;
    }

    @Override // m3.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return h3.b.b(uri);
    }
}
