package K2;

import K2.AbstractC0359g;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: K2.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0362j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AbstractC0359g f1203a = new a();

    /* JADX INFO: renamed from: K2.j$b */
    public static class b extends AbstractC0356d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbstractC0356d f1204a;

        public /* synthetic */ b(AbstractC0356d abstractC0356d, InterfaceC0360h interfaceC0360h, AbstractC0361i abstractC0361i) {
            this(abstractC0356d, interfaceC0360h);
        }

        @Override // K2.AbstractC0356d
        public String a() {
            return this.f1204a.a();
        }

        @Override // K2.AbstractC0356d
        public AbstractC0359g g(a0 a0Var, C0355c c0355c) {
            throw null;
        }

        public b(AbstractC0356d abstractC0356d, InterfaceC0360h interfaceC0360h) {
            this.f1204a = abstractC0356d;
            android.support.v4.media.session.b.a(Z1.m.o(interfaceC0360h, "interceptor"));
        }
    }

    public static AbstractC0356d a(AbstractC0356d abstractC0356d, List list) {
        Z1.m.o(abstractC0356d, "channel");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            android.support.v4.media.session.b.a(it.next());
            AbstractC0361i abstractC0361i = null;
            abstractC0356d = new b(abstractC0356d, abstractC0361i, abstractC0361i);
        }
        return abstractC0356d;
    }

    /* JADX INFO: renamed from: K2.j$a */
    public class a extends AbstractC0359g {
        @Override // K2.AbstractC0359g
        public boolean isReady() {
            return false;
        }

        @Override // K2.AbstractC0359g
        public void halfClose() {
        }

        @Override // K2.AbstractC0359g
        public void request(int i4) {
        }

        @Override // K2.AbstractC0359g
        public void sendMessage(Object obj) {
        }

        @Override // K2.AbstractC0359g
        public void cancel(String str, Throwable th) {
        }

        @Override // K2.AbstractC0359g
        public void start(AbstractC0359g.a aVar, Z z4) {
        }
    }
}
