package R0;

import T0.a;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.window.extensions.layout.WindowLayoutComponent;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public interface f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f4648a = a.f4649a;

    public static final class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final boolean f4650b = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f4649a = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f4651c = H.b(f.class).c();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final E5.j f4652d = E5.k.b(C0077a.f4654a);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static g f4653e = b.f4624a;

        /* JADX INFO: renamed from: R0.f$a$a, reason: collision with other inner class name */
        public static final class C0077a extends s implements Function0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0077a f4654a = new C0077a();

            public C0077a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final S0.a invoke() {
                WindowLayoutComponent windowLayoutComponentG;
                try {
                    ClassLoader loader = f.class.getClassLoader();
                    e eVar = loader != null ? new e(loader, new O0.d(loader)) : null;
                    if (eVar == null || (windowLayoutComponentG = eVar.g()) == null) {
                        return null;
                    }
                    a.C0081a c0081a = T0.a.f4699a;
                    r.e(loader, "loader");
                    return c0081a.a(windowLayoutComponentG, new O0.d(loader));
                } catch (Throwable unused) {
                    if (!a.f4650b) {
                        return null;
                    }
                    Log.d(a.f4651c, "Failed to load WindowExtensions");
                    return null;
                }
            }
        }

        public final S0.a c() {
            return (S0.a) f4652d.getValue();
        }

        public final f d(Context context) {
            r.f(context, "context");
            S0.a aVarC = c();
            if (aVarC == null) {
                aVarC = androidx.window.layout.adapter.sidecar.b.f8460c.a(context);
            }
            return f4653e.a(new i(o.f4671b, aVarC));
        }
    }

    e6.d a(Activity activity);
}
