package S;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes.dex */
public final class o implements E {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f3786d = new b(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Set f3787e = new LinkedHashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f3788f = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f3789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i3.k f3790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0 f3791c;

    public static final class a extends kotlin.jvm.internal.s implements i3.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f3792a = new a();

        public a() {
            super(1);
        }

        @Override // i3.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final t invoke(File it) {
            kotlin.jvm.internal.r.f(it, "it");
            return v.a(it);
        }
    }

    public static final class b {
        public /* synthetic */ b(AbstractC1585j abstractC1585j) {
            this();
        }

        public final Set a() {
            return o.f3787e;
        }

        public final Object b() {
            return o.f3788f;
        }

        public b() {
        }
    }

    public static final class c extends kotlin.jvm.internal.s implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ File f3793a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(File file) {
            super(0);
            this.f3793a = file;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m1invoke();
            return W2.E.f5463a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m1invoke() {
            b bVar = o.f3786d;
            Object objB = bVar.b();
            File file = this.f3793a;
            synchronized (objB) {
                bVar.a().remove(file.getAbsolutePath());
                W2.E e4 = W2.E.f5463a;
            }
        }
    }

    public o(A serializer, i3.k coordinatorProducer, Function0 produceFile) {
        kotlin.jvm.internal.r.f(serializer, "serializer");
        kotlin.jvm.internal.r.f(coordinatorProducer, "coordinatorProducer");
        kotlin.jvm.internal.r.f(produceFile, "produceFile");
        this.f3789a = serializer;
        this.f3790b = coordinatorProducer;
        this.f3791c = produceFile;
    }

    @Override // S.E
    public F a() throws IOException {
        File file = ((File) this.f3791c.invoke()).getCanonicalFile();
        synchronized (f3788f) {
            String path = file.getAbsolutePath();
            Set set = f3787e;
            if (set.contains(path)) {
                throw new IllegalStateException(("There are multiple DataStores active for the same file: " + path + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
            }
            kotlin.jvm.internal.r.e(path, "path");
            set.add(path);
        }
        kotlin.jvm.internal.r.e(file, "file");
        return new p(file, this.f3789a, (t) this.f3790b.invoke(file), new c(file));
    }

    public /* synthetic */ o(A a4, i3.k kVar, Function0 function0, int i4, AbstractC1585j abstractC1585j) {
        this(a4, (i4 & 2) != 0 ? a.f3792a : kVar, function0);
    }
}
