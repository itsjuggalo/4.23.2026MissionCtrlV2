package w0;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.InputEvent;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.AbstractC2306v;
import s5.InterfaceC2707e;
import t0.C2731b;
import t0.C2732c;

/* JADX INFO: renamed from: w0.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2884b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f23977a = new a(null);

    /* JADX INFO: renamed from: w0.b$a */
    public static final class a {

        /* JADX INFO: renamed from: w0.b$a$a, reason: collision with other inner class name */
        public static final class C0419a extends AbstractC2306v implements B5.k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Context f23978a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0419a(Context context) {
                super(1);
                this.f23978a = context;
            }

            @Override // B5.k
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final C2886d invoke(Context it) {
                AbstractC2304t.f(it, "it");
                return new C2886d(this.f23978a);
            }
        }

        public a() {
        }

        public final AbstractC2884b a(Context context) {
            AbstractC2304t.f(context, "context");
            StringBuilder sb = new StringBuilder();
            sb.append("AdServicesInfo.version=");
            C2731b c2731b = C2731b.f23287a;
            sb.append(c2731b.a());
            Log.d("MeasurementManager", sb.toString());
            if (c2731b.a() >= 5) {
                return new C2889g(context);
            }
            if (c2731b.b() >= 9) {
                return (AbstractC2884b) C2732c.f23290a.a(context, "MeasurementManager", new C0419a(context));
            }
            return null;
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public abstract Object a(AbstractC2883a abstractC2883a, InterfaceC2707e interfaceC2707e);

    public abstract Object b(InterfaceC2707e interfaceC2707e);

    public abstract Object c(Uri uri, InputEvent inputEvent, InterfaceC2707e interfaceC2707e);

    public abstract Object d(AbstractC2895m abstractC2895m, InterfaceC2707e interfaceC2707e);

    public abstract Object e(Uri uri, InterfaceC2707e interfaceC2707e);

    public abstract Object f(AbstractC2896n abstractC2896n, InterfaceC2707e interfaceC2707e);

    public abstract Object g(AbstractC2897o abstractC2897o, InterfaceC2707e interfaceC2707e);
}
