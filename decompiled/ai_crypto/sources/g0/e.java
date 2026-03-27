package g0;

import F5.AbstractC0556n;
import b6.C1058a0;
import b6.L;
import b6.M;
import b6.S0;
import c0.C1120i;
import c0.InterfaceC1119h;
import c0.w;
import d0.C1389b;
import java.io.File;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import w6.AbstractC2798k;
import w6.Q;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f14249a = new e();

    public static final class a extends s implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f14250a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Function0 function0) {
            super(0);
            this.f14250a = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Q invoke() {
            File file = (File) this.f14250a.invoke();
            if (r.b(O5.j.g(file), "preferences_pb")) {
                Q.a aVar = Q.f25040b;
                File absoluteFile = file.getAbsoluteFile();
                r.e(absoluteFile, "file.absoluteFile");
                return Q.a.d(aVar, absoluteFile, false, 1, null);
            }
            throw new IllegalStateException(("File extension for file: " + file + " does not match required extension for Preferences file: preferences_pb").toString());
        }
    }

    public static /* synthetic */ InterfaceC1119h c(e eVar, C1389b c1389b, List list, L l7, Function0 function0, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            c1389b = null;
        }
        if ((i7 & 2) != 0) {
            list = AbstractC0556n.g();
        }
        if ((i7 & 4) != 0) {
            l7 = M.a(C1058a0.b().plus(S0.b(null, 1, null)));
        }
        return eVar.b(c1389b, list, l7, function0);
    }

    public final InterfaceC1119h a(w storage, C1389b c1389b, List migrations, L scope) {
        r.f(storage, "storage");
        r.f(migrations, "migrations");
        r.f(scope, "scope");
        return new C1632d(C1120i.f9135a.a(storage, c1389b, migrations, scope));
    }

    public final InterfaceC1119h b(C1389b c1389b, List migrations, L scope, Function0 produceFile) {
        r.f(migrations, "migrations");
        r.f(scope, "scope");
        r.f(produceFile, "produceFile");
        return new C1632d(a(new e0.d(AbstractC2798k.f25130b, j.f14255a, null, new a(produceFile), 4, null), c1389b, migrations, scope));
    }
}
