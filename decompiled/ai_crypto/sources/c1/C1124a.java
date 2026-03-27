package c1;

import Q4.a;
import V4.i;
import V4.j;
import android.content.Context;
import android.os.Build;
import d1.C1392c;
import d1.e;
import g1.C1633a;
import i1.C1740a;
import j1.C2043a;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: c1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1124a implements Q4.a, j.c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C0160a f9329e = new C0160a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f9330f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f9331c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j f9332d;

    /* JADX INFO: renamed from: c1.a$a, reason: collision with other inner class name */
    public static final class C0160a {
        public /* synthetic */ C0160a(AbstractC2148j abstractC2148j) {
            this();
        }

        public final boolean a() {
            return C1124a.f9330f;
        }

        public C0160a() {
        }
    }

    public C1124a() {
        C1633a c1633a = C1633a.f14257a;
        c1633a.b(new C1740a(0));
        c1633a.b(new C1740a(1));
        c1633a.b(new C2043a());
        c1633a.b(new C1740a(3));
    }

    public final int b(i iVar) {
        f9330f = r.b((Boolean) iVar.b(), Boolean.TRUE);
        return 1;
    }

    @Override // Q4.a
    public void onAttachedToEngine(a.b binding) {
        r.f(binding, "binding");
        this.f9331c = binding.a();
        j jVar = new j(binding.b(), "flutter_image_compress");
        this.f9332d = jVar;
        jVar.e(this);
    }

    @Override // Q4.a
    public void onDetachedFromEngine(a.b binding) {
        r.f(binding, "binding");
        j jVar = this.f9332d;
        if (jVar != null) {
            jVar.e(null);
        }
        this.f9332d = null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // V4.j.c
    public void onMethodCall(i call, j.d result) {
        r.f(call, "call");
        r.f(result, "result");
        String str = call.f5332a;
        if (str != null) {
            Context context = null;
            switch (str.hashCode()) {
                case -129880033:
                    if (str.equals("compressWithFileAndGetFile")) {
                        C1392c c1392c = new C1392c(call, result);
                        Context context2 = this.f9331c;
                        if (context2 == null) {
                            r.s("context");
                        } else {
                            context = context2;
                        }
                        c1392c.i(context);
                        return;
                    }
                    break;
                case 86054116:
                    if (str.equals("compressWithFile")) {
                        C1392c c1392c2 = new C1392c(call, result);
                        Context context3 = this.f9331c;
                        if (context3 == null) {
                            r.s("context");
                        } else {
                            context = context3;
                        }
                        c1392c2.g(context);
                        return;
                    }
                    break;
                case 86233094:
                    if (str.equals("compressWithList")) {
                        e eVar = new e(call, result);
                        Context context4 = this.f9331c;
                        if (context4 == null) {
                            r.s("context");
                        } else {
                            context = context4;
                        }
                        eVar.f(context);
                        return;
                    }
                    break;
                case 1262746611:
                    if (str.equals("getSystemVersion")) {
                        result.a(Integer.valueOf(Build.VERSION.SDK_INT));
                        return;
                    }
                    break;
                case 2067272455:
                    if (str.equals("showLog")) {
                        result.a(Integer.valueOf(b(call)));
                        return;
                    }
                    break;
            }
        }
        result.c();
    }
}
