package a4;

import M2.C0700c;
import M2.InterfaceC0701d;
import M2.q;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: renamed from: a4.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1070c implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C1071d f9960b;

    public C1070c(Set set, C1071d c1071d) {
        this.f9959a = e(set);
        this.f9960b = c1071d;
    }

    public static C0700c c() {
        return C0700c.e(i.class).b(q.o(AbstractC1073f.class)).f(new M2.g() { // from class: a4.b
            @Override // M2.g
            public final Object create(InterfaceC0701d interfaceC0701d) {
                return C1070c.d(interfaceC0701d);
            }
        }).d();
    }

    public static /* synthetic */ i d(InterfaceC0701d interfaceC0701d) {
        return new C1070c(interfaceC0701d.g(AbstractC1073f.class), C1071d.a());
    }

    public static String e(Set set) {
        StringBuilder sb = new StringBuilder();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            AbstractC1073f abstractC1073f = (AbstractC1073f) it.next();
            sb.append(abstractC1073f.b());
            sb.append('/');
            sb.append(abstractC1073f.c());
            if (it.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    @Override // a4.i
    public String a() {
        if (this.f9960b.b().isEmpty()) {
            return this.f9959a;
        }
        return this.f9959a + ' ' + e(this.f9960b.b());
    }
}
