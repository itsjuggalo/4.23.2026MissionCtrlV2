package h2;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.InputEvent;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10967a = new a(null);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: h2.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0202a extends v implements pd.k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Context f10968a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0202a(Context context) {
                super(1);
                this.f10968a = context;
            }

            @Override // pd.k
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final c invoke(Context it) {
                t.f(it, "it");
                return new c(this.f10968a);
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final b a(Context context) {
            t.f(context, "context");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("AdServicesInfo.version=");
            e2.a aVar = e2.a.f8330a;
            sb2.append(aVar.a());
            Log.d("MeasurementManager", sb2.toString());
            if (aVar.a() >= 5) {
                return new f(context);
            }
            if (aVar.b() >= 9) {
                return (b) e2.b.f8333a.a(context, "MeasurementManager", new C0202a(context));
            }
            return null;
        }

        public a() {
        }
    }

    public abstract Object a(h2.a aVar, gd.e eVar);

    public abstract Object b(gd.e eVar);

    public abstract Object c(Uri uri, InputEvent inputEvent, gd.e eVar);

    public abstract Object d(i iVar, gd.e eVar);

    public abstract Object e(Uri uri, gd.e eVar);

    public abstract Object f(j jVar, gd.e eVar);

    public abstract Object g(k kVar, gd.e eVar);
}
