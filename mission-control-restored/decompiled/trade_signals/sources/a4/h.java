package a4;

import M2.C0700c;
import M2.InterfaceC0701d;
import M2.q;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    public interface a {
        String a(Object obj);
    }

    public static C0700c b(String str, String str2) {
        return C0700c.l(AbstractC1073f.a(str, str2), AbstractC1073f.class);
    }

    public static C0700c c(final String str, final a aVar) {
        return C0700c.m(AbstractC1073f.class).b(q.l(Context.class)).f(new M2.g() { // from class: a4.g
            @Override // M2.g
            public final Object create(InterfaceC0701d interfaceC0701d) {
                return h.d(str, aVar, interfaceC0701d);
            }
        }).d();
    }

    public static /* synthetic */ AbstractC1073f d(String str, a aVar, InterfaceC0701d interfaceC0701d) {
        return AbstractC1073f.a(str, aVar.a((Context) interfaceC0701d.get(Context.class)));
    }
}
