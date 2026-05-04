package o1;

import android.content.Context;
import java.io.File;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import ng.n0;
import pd.k;
import wd.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements sd.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m1.b f17440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f17441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n0 f17442d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f17443e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile l1.i f17444f;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends v implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f17445a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f17446b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, c cVar) {
            super(0);
            this.f17445a = context;
            this.f17446b = cVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public final File invoke() {
            Context applicationContext = this.f17445a;
            t.e(applicationContext, "applicationContext");
            return b.a(applicationContext, this.f17446b.f17439a);
        }
    }

    public c(String name, m1.b bVar, k produceMigrations, n0 scope) {
        t.f(name, "name");
        t.f(produceMigrations, "produceMigrations");
        t.f(scope, "scope");
        this.f17439a = name;
        this.f17440b = bVar;
        this.f17441c = produceMigrations;
        this.f17442d = scope;
        this.f17443e = new Object();
    }

    @Override // sd.c
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public l1.i a(Context thisRef, m property) {
        l1.i iVar;
        t.f(thisRef, "thisRef");
        t.f(property, "property");
        l1.i iVar2 = this.f17444f;
        if (iVar2 != null) {
            return iVar2;
        }
        synchronized (this.f17443e) {
            try {
                if (this.f17444f == null) {
                    Context applicationContext = thisRef.getApplicationContext();
                    p1.e eVar = p1.e.f18183a;
                    m1.b bVar = this.f17440b;
                    k kVar = this.f17441c;
                    t.e(applicationContext, "applicationContext");
                    this.f17444f = eVar.b(bVar, (List) kVar.invoke(applicationContext), this.f17442d, new a(applicationContext, this));
                }
                iVar = this.f17444f;
                t.c(iVar);
            } catch (Throwable th) {
                throw th;
            }
        }
        return iVar;
    }
}
