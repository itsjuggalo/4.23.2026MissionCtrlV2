package l0;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.InputEvent;
import i0.C1286b;
import i0.C1287c;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13436a = new a(null);

    public static final class a {

        /* JADX INFO: renamed from: l0.b$a$a, reason: collision with other inner class name */
        public static final class C0209a extends s implements i3.k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Context f13437a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0209a(Context context) {
                super(1);
                this.f13437a = context;
            }

            @Override // i3.k
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final d invoke(Context it) {
                r.f(it, "it");
                return new d(this.f13437a);
            }
        }

        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public final b a(Context context) {
            r.f(context, "context");
            StringBuilder sb = new StringBuilder();
            sb.append("AdServicesInfo.version=");
            C1286b c1286b = C1286b.f12169a;
            sb.append(c1286b.a());
            Log.d("MeasurementManager", sb.toString());
            if (c1286b.a() >= 5) {
                return new g(context);
            }
            if (c1286b.b() >= 9) {
                return (b) C1287c.f12172a.a(context, "MeasurementManager", new C0209a(context));
            }
            return null;
        }

        public a() {
        }
    }

    public abstract Object a(AbstractC1588a abstractC1588a, Z2.e eVar);

    public abstract Object b(Z2.e eVar);

    public abstract Object c(Uri uri, InputEvent inputEvent, Z2.e eVar);

    public abstract Object d(m mVar, Z2.e eVar);

    public abstract Object e(Uri uri, Z2.e eVar);

    public abstract Object f(n nVar, Z2.e eVar);

    public abstract Object g(o oVar, Z2.e eVar);
}
