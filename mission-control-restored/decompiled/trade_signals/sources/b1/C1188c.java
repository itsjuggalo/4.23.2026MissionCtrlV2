package b1;

import U0.h;
import a1.n;
import a1.o;
import a1.r;
import android.content.Context;
import android.net.Uri;
import d1.G;
import p1.C2543b;

/* JADX INFO: renamed from: b1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1188c implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f12861a;

    /* JADX INFO: renamed from: b1.c$a */
    public static class a implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f12862a;

        public a(Context context) {
            this.f12862a = context;
        }

        @Override // a1.o
        public n d(r rVar) {
            return new C1188c(this.f12862a);
        }
    }

    public C1188c(Context context) {
        this.f12861a = context.getApplicationContext();
    }

    @Override // a1.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a a(Uri uri, int i8, int i9, h hVar) {
        if (V0.b.e(i8, i9) && e(hVar)) {
            return new n.a(new C2543b(uri), V0.c.g(this.f12861a, uri));
        }
        return null;
    }

    @Override // a1.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(Uri uri) {
        return V0.b.d(uri);
    }

    public final boolean e(h hVar) {
        Long l8 = (Long) hVar.c(G.f16761d);
        return l8 != null && l8.longValue() == -1;
    }
}
