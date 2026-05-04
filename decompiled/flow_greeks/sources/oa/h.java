package oa;

import android.content.Context;
import o7.q;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface a {
        String a(Object obj);
    }

    public static o7.c b(String str, String str2) {
        return o7.c.l(f.a(str, str2), f.class);
    }

    public static o7.c c(final String str, final a aVar) {
        return o7.c.m(f.class).b(q.k(Context.class)).f(new o7.g() { // from class: oa.g
            @Override // o7.g
            public final Object create(o7.d dVar) {
                return f.a(str, aVar.a((Context) dVar.get(Context.class)));
            }
        }).d();
    }
}
