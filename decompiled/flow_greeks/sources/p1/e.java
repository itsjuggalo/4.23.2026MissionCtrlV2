package p1;

import java.io.File;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import l1.j0;
import l1.o;
import ng.n0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f18183a = new e();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends v implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f18184a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Function0 function0) {
            super(0);
            this.f18184a = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public final File invoke() {
            File file = (File) this.f18184a.invoke();
            if (t.b(nd.j.g(file), "preferences_pb")) {
                File absoluteFile = file.getAbsoluteFile();
                t.e(absoluteFile, "file.absoluteFile");
                return absoluteFile;
            }
            throw new IllegalStateException(("File extension for file: " + file + " does not match required extension for Preferences file: preferences_pb").toString());
        }
    }

    public final l1.i a(j0 storage, m1.b bVar, List migrations, n0 scope) {
        t.f(storage, "storage");
        t.f(migrations, "migrations");
        t.f(scope, "scope");
        return new d(l1.j.f15057a.b(storage, bVar, migrations, scope));
    }

    public final l1.i b(m1.b bVar, List migrations, n0 scope, Function0 produceFile) {
        t.f(migrations, "migrations");
        t.f(scope, "scope");
        t.f(produceFile, "produceFile");
        return new d(a(new o(h.f18186a, null, new a(produceFile), 2, null), bVar, migrations, scope));
    }
}
