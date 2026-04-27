package b0;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.AbstractC2306v;
import o5.C2470H;

/* JADX INFO: renamed from: b0.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1184o implements J {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f12777d = new b(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Set f12778e = new LinkedHashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f12779f = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final E f12780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B5.k f12781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0 f12782c;

    /* JADX INFO: renamed from: b0.o$a */
    public static final class a extends AbstractC2306v implements B5.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f12783a = new a();

        public a() {
            super(1);
        }

        @Override // B5.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final t invoke(File it) {
            AbstractC2304t.f(it, "it");
            return v.a(it);
        }
    }

    /* JADX INFO: renamed from: b0.o$b */
    public static final class b {
        public b() {
        }

        public final Set a() {
            return C1184o.f12778e;
        }

        public final Object b() {
            return C1184o.f12779f;
        }

        public /* synthetic */ b(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    /* JADX INFO: renamed from: b0.o$c */
    public static final class c extends AbstractC2306v implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ File f12784a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(File file) {
            super(0);
            this.f12784a = file;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m8invoke();
            return C2470H.f21956a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m8invoke() {
            b bVar = C1184o.f12777d;
            Object objB = bVar.b();
            File file = this.f12784a;
            synchronized (objB) {
                bVar.a().remove(file.getAbsolutePath());
                C2470H c2470h = C2470H.f21956a;
            }
        }
    }

    public C1184o(E serializer, B5.k coordinatorProducer, Function0 produceFile) {
        AbstractC2304t.f(serializer, "serializer");
        AbstractC2304t.f(coordinatorProducer, "coordinatorProducer");
        AbstractC2304t.f(produceFile, "produceFile");
        this.f12780a = serializer;
        this.f12781b = coordinatorProducer;
        this.f12782c = produceFile;
    }

    @Override // b0.J
    public K a() throws IOException {
        File file = ((File) this.f12782c.invoke()).getCanonicalFile();
        synchronized (f12779f) {
            String path = file.getAbsolutePath();
            Set set = f12778e;
            if (!(!set.contains(path))) {
                throw new IllegalStateException(("There are multiple DataStores active for the same file: " + path + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
            }
            AbstractC2304t.e(path, "path");
            set.add(path);
        }
        AbstractC2304t.e(file, "file");
        return new C1185p(file, this.f12780a, (t) this.f12781b.invoke(file), new c(file));
    }

    public /* synthetic */ C1184o(E e8, B5.k kVar, Function0 function0, int i8, AbstractC2296k abstractC2296k) {
        this(e8, (i8 & 2) != 0 ? a.f12783a : kVar, function0);
    }
}
