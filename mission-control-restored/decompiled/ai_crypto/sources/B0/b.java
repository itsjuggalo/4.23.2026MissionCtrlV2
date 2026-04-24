package B0;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.InputEvent;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import y0.C2832a;
import y0.C2833b;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f710a = new a(null);

    public static final class a {

        /* JADX INFO: renamed from: B0.b$a$a, reason: collision with other inner class name */
        public static final class C0008a extends s implements Q5.k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Context f711a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0008a(Context context) {
                super(1);
                this.f711a = context;
            }

            @Override // Q5.k
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final d invoke(Context it) {
                r.f(it, "it");
                return new d(this.f711a);
            }
        }

        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public final b a(Context context) {
            r.f(context, "context");
            StringBuilder sb = new StringBuilder();
            sb.append("AdServicesInfo.version=");
            C2832a c2832a = C2832a.f25453a;
            sb.append(c2832a.a());
            Log.d("MeasurementManager", sb.toString());
            if (c2832a.a() >= 5) {
                return new g(context);
            }
            if (c2832a.b() >= 9) {
                return (b) C2833b.f25456a.a(context, "MeasurementManager", new C0008a(context));
            }
            return null;
        }

        public a() {
        }
    }

    public abstract Object a(B0.a aVar, H5.d dVar);

    public abstract Object b(H5.d dVar);

    public abstract Object c(m mVar, H5.d dVar);

    public abstract Object d(Uri uri, InputEvent inputEvent, H5.d dVar);

    public abstract Object e(Uri uri, H5.d dVar);

    public abstract Object f(n nVar, H5.d dVar);

    public abstract Object g(o oVar, H5.d dVar);
}
