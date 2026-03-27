package F4;

import F4.AbstractC0493g;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import v2.AbstractC2848n;

/* JADX INFO: renamed from: F4.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0496j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AbstractC0493g f1793a = new a();

    /* JADX INFO: renamed from: F4.j$b */
    public static class b extends AbstractC0490d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbstractC0490d f1794a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final InterfaceC0494h f1795b;

        public b(AbstractC0490d abstractC0490d, InterfaceC0494h interfaceC0494h) {
            this.f1794a = abstractC0490d;
            this.f1795b = (InterfaceC0494h) AbstractC2848n.o(interfaceC0494h, "interceptor");
        }

        @Override // F4.AbstractC0490d
        public String a() {
            return this.f1794a.a();
        }

        @Override // F4.AbstractC0490d
        public AbstractC0493g g(Y y7, C0489c c0489c) {
            return this.f1795b.a(y7, c0489c, this.f1794a);
        }

        public /* synthetic */ b(AbstractC0490d abstractC0490d, InterfaceC0494h interfaceC0494h, AbstractC0495i abstractC0495i) {
            this(abstractC0490d, interfaceC0494h);
        }
    }

    public static AbstractC0490d a(AbstractC0490d abstractC0490d, List list) {
        AbstractC2848n.o(abstractC0490d, "channel");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            abstractC0490d = new b(abstractC0490d, (InterfaceC0494h) it.next(), null);
        }
        return abstractC0490d;
    }

    public static AbstractC0490d b(AbstractC0490d abstractC0490d, InterfaceC0494h... interfaceC0494hArr) {
        return a(abstractC0490d, Arrays.asList(interfaceC0494hArr));
    }

    /* JADX INFO: renamed from: F4.j$a */
    public class a extends AbstractC0493g {
        @Override // F4.AbstractC0493g
        public void b() {
        }

        @Override // F4.AbstractC0493g
        public void c(int i8) {
        }

        @Override // F4.AbstractC0493g
        public void d(Object obj) {
        }

        @Override // F4.AbstractC0493g
        public void a(String str, Throwable th) {
        }

        @Override // F4.AbstractC0493g
        public void e(AbstractC0493g.a aVar, X x8) {
        }
    }
}
