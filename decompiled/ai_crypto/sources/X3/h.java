package X3;

import android.content.Context;
import b3.C0986c;
import b3.InterfaceC0987d;
import b3.InterfaceC0990g;
import b3.q;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    public interface a {
        String a(Object obj);
    }

    public static C0986c b(String str, String str2) {
        return C0986c.l(f.a(str, str2), f.class);
    }

    public static C0986c c(final String str, final a aVar) {
        return C0986c.m(f.class).b(q.l(Context.class)).f(new InterfaceC0990g() { // from class: X3.g
            @Override // b3.InterfaceC0990g
            public final Object a(InterfaceC0987d interfaceC0987d) {
                return h.d(str, aVar, interfaceC0987d);
            }
        }).d();
    }

    public static /* synthetic */ f d(String str, a aVar, InterfaceC0987d interfaceC0987d) {
        return f.a(str, aVar.a((Context) interfaceC0987d.a(Context.class)));
    }
}
