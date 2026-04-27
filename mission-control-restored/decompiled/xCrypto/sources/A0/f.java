package A0;

import C0.a;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.window.extensions.layout.WindowLayoutComponent;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.G;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import x0.C1915d;

/* JADX INFO: loaded from: classes.dex */
public interface f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f27a = a.f28a;

    public static final class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final boolean f29b = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f28a = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f30c = G.b(f.class).b();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final W2.j f31d = W2.k.b(C0002a.f33a);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static g f32e = b.f3a;

        /* JADX INFO: renamed from: A0.f$a$a, reason: collision with other inner class name */
        public static final class C0002a extends s implements Function0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0002a f33a = new C0002a();

            public C0002a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final B0.a invoke() {
                WindowLayoutComponent windowLayoutComponentG;
                try {
                    ClassLoader loader = f.class.getClassLoader();
                    e eVar = loader != null ? new e(loader, new C1915d(loader)) : null;
                    if (eVar == null || (windowLayoutComponentG = eVar.g()) == null) {
                        return null;
                    }
                    a.C0007a c0007a = C0.a.f129a;
                    r.e(loader, "loader");
                    return c0007a.a(windowLayoutComponentG, new C1915d(loader));
                } catch (Throwable unused) {
                    if (a.f29b) {
                        Log.d(a.f30c, "Failed to load WindowExtensions");
                    }
                    return null;
                }
            }
        }

        public final B0.a c() {
            return (B0.a) f31d.getValue();
        }

        public final f d(Context context) {
            r.f(context, "context");
            B0.a aVarC = c();
            if (aVarC == null) {
                aVarC = androidx.window.layout.adapter.sidecar.b.f8225c.a(context);
            }
            return f32e.a(new i(o.f50b, aVarC));
        }
    }

    w3.d a(Activity activity);
}
