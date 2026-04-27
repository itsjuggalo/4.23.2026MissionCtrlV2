package t5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import r5.EnumC2600p;

/* JADX INFO: renamed from: t5.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2708x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f24215a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile EnumC2600p f24216b = EnumC2600p.IDLE;

    /* JADX INFO: renamed from: t5.x$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f24217a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f24218b;

        public a(Runnable runnable, Executor executor) {
            this.f24217a = runnable;
            this.f24218b = executor;
        }

        public void a() {
            this.f24218b.execute(this.f24217a);
        }
    }

    public EnumC2600p a() {
        EnumC2600p enumC2600p = this.f24216b;
        if (enumC2600p != null) {
            return enumC2600p;
        }
        throw new UnsupportedOperationException("Channel state API is not implemented");
    }

    public void b(EnumC2600p enumC2600p) {
        H2.m.o(enumC2600p, "newState");
        if (this.f24216b == enumC2600p || this.f24216b == EnumC2600p.SHUTDOWN) {
            return;
        }
        this.f24216b = enumC2600p;
        if (this.f24215a.isEmpty()) {
            return;
        }
        ArrayList arrayList = this.f24215a;
        this.f24215a = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a();
        }
    }

    public void c(Runnable runnable, Executor executor, EnumC2600p enumC2600p) {
        H2.m.o(runnable, "callback");
        H2.m.o(executor, "executor");
        H2.m.o(enumC2600p, "source");
        a aVar = new a(runnable, executor);
        if (this.f24216b != enumC2600p) {
            aVar.a();
        } else {
            this.f24215a.add(aVar);
        }
    }
}
