package n3;

import android.content.Context;
import android.net.Uri;
import g3.h;
import m3.n;
import m3.o;
import m3.r;
import p3.i0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f16614a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f16615a;

        public a(Context context) {
            this.f16615a = context;
        }

        @Override // m3.o
        public n d(r rVar) {
            return new c(this.f16615a);
        }
    }

    public c(Context context) {
        this.f16614a = context.getApplicationContext();
    }

    @Override // m3.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a b(Uri uri, int i10, int i11, h hVar) {
        if (h3.b.f(i10, i11) && e(hVar)) {
            return new n.a(new b4.b(uri), h3.c.g(this.f16614a, uri));
        }
        return null;
    }

    @Override // m3.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return h3.b.e(uri);
    }

    public final boolean e(h hVar) {
        Long l10 = (Long) hVar.c(i0.f18239d);
        return l10 != null && l10.longValue() == -1;
    }
}
