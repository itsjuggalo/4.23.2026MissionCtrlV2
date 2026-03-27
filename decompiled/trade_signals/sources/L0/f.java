package L0;

import N0.a;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.window.extensions.layout.WindowLayoutComponent;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.AbstractC2306v;
import kotlin.jvm.internal.O;
import o5.AbstractC2484l;
import o5.InterfaceC2483k;

/* JADX INFO: loaded from: classes.dex */
public interface f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f4975a = a.f4976a;

    public static final class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final boolean f4977b = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f4976a = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f4978c = O.b(f.class).r();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final InterfaceC2483k f4979d = AbstractC2484l.a(C0070a.f4981a);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static g f4980e = b.f4948a;

        /* JADX INFO: renamed from: L0.f$a$a, reason: collision with other inner class name */
        public static final class C0070a extends AbstractC2306v implements Function0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0070a f4981a = new C0070a();

            public C0070a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final M0.a invoke() {
                WindowLayoutComponent windowLayoutComponentK;
                try {
                    ClassLoader classLoader = f.class.getClassLoader();
                    e eVar = classLoader != null ? new e(classLoader, new I0.d(classLoader)) : null;
                    if (eVar == null || (windowLayoutComponentK = eVar.k()) == null) {
                        return null;
                    }
                    a.C0079a c0079a = N0.a.f5444a;
                    AbstractC2304t.c(classLoader);
                    return c0079a.a(windowLayoutComponentK, new I0.d(classLoader));
                } catch (Throwable unused) {
                    if (!a.f4977b) {
                        return null;
                    }
                    Log.d(a.f4978c, "Failed to load WindowExtensions");
                    return null;
                }
            }
        }

        public final M0.a c() {
            return (M0.a) f4979d.getValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final f d(Context context) {
            AbstractC2304t.f(context, "context");
            M0.a aVarC = c();
            if (aVarC == null) {
                aVarC = androidx.window.layout.adapter.sidecar.b.f12525c.a(context);
            }
            return f4980e.a(new i(new m(null, 1, 0 == true ? 1 : 0), aVarC, H0.c.f3565b.a()));
        }
    }

    b7.d a(Activity activity);
}
