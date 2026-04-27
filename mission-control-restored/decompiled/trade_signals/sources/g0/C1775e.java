package g0;

import Y6.L;
import b0.C1179j;
import b0.InterfaceC1178i;
import b0.J;
import c0.C1243b;
import java.io.File;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.AbstractC2306v;
import u7.AbstractC2817j;
import u7.M;

/* JADX INFO: renamed from: g0.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1775e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1775e f17973a = new C1775e();

    /* JADX INFO: renamed from: g0.e$a */
    public static final class a extends AbstractC2306v implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f17974a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Function0 function0) {
            super(0);
            this.f17974a = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final M invoke() {
            File file = (File) this.f17974a.invoke();
            if (AbstractC2304t.b(z5.j.f(file), "preferences_pb")) {
                M.a aVar = M.f23583b;
                File absoluteFile = file.getAbsoluteFile();
                AbstractC2304t.e(absoluteFile, "file.absoluteFile");
                return M.a.d(aVar, absoluteFile, false, 1, null);
            }
            throw new IllegalStateException(("File extension for file: " + file + " does not match required extension for Preferences file: preferences_pb").toString());
        }
    }

    public final InterfaceC1178i a(J storage, C1243b c1243b, List migrations, L scope) {
        AbstractC2304t.f(storage, "storage");
        AbstractC2304t.f(migrations, "migrations");
        AbstractC2304t.f(scope, "scope");
        return new C1774d(C1179j.f12617a.b(storage, c1243b, migrations, scope));
    }

    public final InterfaceC1178i b(C1243b c1243b, List migrations, L scope, Function0 produceFile) {
        AbstractC2304t.f(migrations, "migrations");
        AbstractC2304t.f(scope, "scope");
        AbstractC2304t.f(produceFile, "produceFile");
        return new C1774d(a(new d0.d(AbstractC2817j.f23672b, C1780j.f17979a, null, new a(produceFile), 4, null), c1243b, migrations, scope));
    }
}
