package X3;

import b3.C0986c;
import b3.InterfaceC0987d;
import b3.InterfaceC0990g;
import b3.q;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class c implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f5489b;

    public c(Set set, d dVar) {
        this.f5488a = e(set);
        this.f5489b = dVar;
    }

    public static C0986c c() {
        return C0986c.e(i.class).b(q.o(f.class)).f(new InterfaceC0990g() { // from class: X3.b
            @Override // b3.InterfaceC0990g
            public final Object a(InterfaceC0987d interfaceC0987d) {
                return c.d(interfaceC0987d);
            }
        }).d();
    }

    public static /* synthetic */ i d(InterfaceC0987d interfaceC0987d) {
        return new c(interfaceC0987d.f(f.class), d.a());
    }

    public static String e(Set set) {
        StringBuilder sb = new StringBuilder();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            sb.append(fVar.b());
            sb.append('/');
            sb.append(fVar.c());
            if (it.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    @Override // X3.i
    public String a() {
        if (this.f5489b.b().isEmpty()) {
            return this.f5488a;
        }
        return this.f5488a + ' ' + e(this.f5489b.b());
    }
}
