package V;

import S.C0524j;
import S.E;
import S.InterfaceC0523i;
import S.o;
import X2.AbstractC0769p;
import java.io.File;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import t3.C1803a0;
import t3.L;
import t3.M;
import t3.S0;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f5282a = new e();

    public static final class a extends s implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f5283a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Function0 function0) {
            super(0);
            this.f5283a = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public final File invoke() {
            File file = (File) this.f5283a.invoke();
            if (r.b(g3.j.g(file), "preferences_pb")) {
                File absoluteFile = file.getAbsoluteFile();
                r.e(absoluteFile, "file.absoluteFile");
                return absoluteFile;
            }
            throw new IllegalStateException(("File extension for file: " + file + " does not match required extension for Preferences file: preferences_pb").toString());
        }
    }

    public static /* synthetic */ InterfaceC0523i c(e eVar, T.b bVar, List list, L l4, Function0 function0, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            bVar = null;
        }
        if ((i4 & 2) != 0) {
            list = AbstractC0769p.g();
        }
        if ((i4 & 4) != 0) {
            l4 = M.a(C1803a0.b().plus(S0.b(null, 1, null)));
        }
        return eVar.b(bVar, list, l4, function0);
    }

    public final InterfaceC0523i a(E storage, T.b bVar, List migrations, L scope) {
        r.f(storage, "storage");
        r.f(migrations, "migrations");
        r.f(scope, "scope");
        return new d(C0524j.f3626a.a(storage, bVar, migrations, scope));
    }

    public final InterfaceC0523i b(T.b bVar, List migrations, L scope, Function0 produceFile) {
        r.f(migrations, "migrations");
        r.f(scope, "scope");
        r.f(produceFile, "produceFile");
        return new d(a(new o(h.f5285a, null, new a(produceFile), 2, null), bVar, migrations, scope));
    }
}
