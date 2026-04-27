package M2;

import K2.EnumC0368p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: M2.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0453x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f2664a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile EnumC0368p f2665b = EnumC0368p.IDLE;

    /* JADX INFO: renamed from: M2.x$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f2666a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f2667b;

        public a(Runnable runnable, Executor executor) {
            this.f2666a = runnable;
            this.f2667b = executor;
        }

        public void a() {
            this.f2667b.execute(this.f2666a);
        }
    }

    public EnumC0368p a() {
        EnumC0368p enumC0368p = this.f2665b;
        if (enumC0368p != null) {
            return enumC0368p;
        }
        throw new UnsupportedOperationException("Channel state API is not implemented");
    }

    public void b(EnumC0368p enumC0368p) {
        Z1.m.o(enumC0368p, "newState");
        if (this.f2665b == enumC0368p || this.f2665b == EnumC0368p.SHUTDOWN) {
            return;
        }
        this.f2665b = enumC0368p;
        if (this.f2664a.isEmpty()) {
            return;
        }
        ArrayList arrayList = this.f2664a;
        this.f2664a = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a();
        }
    }

    public void c(Runnable runnable, Executor executor, EnumC0368p enumC0368p) {
        Z1.m.o(runnable, "callback");
        Z1.m.o(executor, "executor");
        Z1.m.o(enumC0368p, "source");
        a aVar = new a(runnable, executor);
        if (this.f2665b != enumC0368p) {
            aVar.a();
        } else {
            this.f2664a.add(aVar);
        }
    }
}
