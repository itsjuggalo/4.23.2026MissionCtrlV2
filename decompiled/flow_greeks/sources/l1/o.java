package l1;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class o implements j0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f15221d = new b(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Set f15222e = new LinkedHashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f15223f = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e0 f15224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pd.k f15225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0 f15226c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends kotlin.jvm.internal.v implements pd.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f15227a = new a();

        public a() {
            super(1);
        }

        @Override // pd.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final t invoke(File it) {
            kotlin.jvm.internal.t.f(it, "it");
            return v.a(it);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final Set a() {
            return o.f15222e;
        }

        public final Object b() {
            return o.f15223f;
        }

        public b() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends kotlin.jvm.internal.v implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ File f15228a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(File file) {
            super(0);
            this.f15228a = file;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m273invoke();
            return cd.h0.f3852a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m273invoke() {
            b bVar = o.f15221d;
            Object objB = bVar.b();
            File file = this.f15228a;
            synchronized (objB) {
                bVar.a().remove(file.getAbsolutePath());
                cd.h0 h0Var = cd.h0.f3852a;
            }
        }
    }

    public o(e0 serializer, pd.k coordinatorProducer, Function0 produceFile) {
        kotlin.jvm.internal.t.f(serializer, "serializer");
        kotlin.jvm.internal.t.f(coordinatorProducer, "coordinatorProducer");
        kotlin.jvm.internal.t.f(produceFile, "produceFile");
        this.f15224a = serializer;
        this.f15225b = coordinatorProducer;
        this.f15226c = produceFile;
    }

    @Override // l1.j0
    public k0 a() throws IOException {
        File file = ((File) this.f15226c.invoke()).getCanonicalFile();
        synchronized (f15223f) {
            String path = file.getAbsolutePath();
            Set set = f15222e;
            if (set.contains(path)) {
                throw new IllegalStateException(("There are multiple DataStores active for the same file: " + path + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
            }
            kotlin.jvm.internal.t.e(path, "path");
            set.add(path);
        }
        kotlin.jvm.internal.t.e(file, "file");
        return new p(file, this.f15224a, (t) this.f15225b.invoke(file), new c(file));
    }

    public /* synthetic */ o(e0 e0Var, pd.k kVar, Function0 function0, int i10, kotlin.jvm.internal.k kVar2) {
        this(e0Var, (i10 & 2) != 0 ? a.f15227a : kVar, function0);
    }
}
