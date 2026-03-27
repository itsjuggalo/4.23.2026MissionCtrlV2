package U;

import S.InterfaceC0523i;
import android.content.Context;
import i3.k;
import java.io.File;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import l3.InterfaceC1591a;
import t3.L;

/* JADX INFO: loaded from: classes.dex */
public final class c implements InterfaceC1591a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T.b f5227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f5228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final L f5229d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f5230e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile InterfaceC0523i f5231f;

    public static final class a extends s implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f5232a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f5233b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, c cVar) {
            super(0);
            this.f5232a = context;
            this.f5233b = cVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public final File invoke() {
            Context applicationContext = this.f5232a;
            r.e(applicationContext, "applicationContext");
            return b.a(applicationContext, this.f5233b.f5226a);
        }
    }

    public c(String name, T.b bVar, k produceMigrations, L scope) {
        r.f(name, "name");
        r.f(produceMigrations, "produceMigrations");
        r.f(scope, "scope");
        this.f5226a = name;
        this.f5227b = bVar;
        this.f5228c = produceMigrations;
        this.f5229d = scope;
        this.f5230e = new Object();
    }

    @Override // l3.InterfaceC1591a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC0523i a(Context thisRef, p3.h property) {
        InterfaceC0523i interfaceC0523i;
        r.f(thisRef, "thisRef");
        r.f(property, "property");
        InterfaceC0523i interfaceC0523i2 = this.f5231f;
        if (interfaceC0523i2 != null) {
            return interfaceC0523i2;
        }
        synchronized (this.f5230e) {
            try {
                if (this.f5231f == null) {
                    Context applicationContext = thisRef.getApplicationContext();
                    V.e eVar = V.e.f5282a;
                    T.b bVar = this.f5227b;
                    k kVar = this.f5228c;
                    r.e(applicationContext, "applicationContext");
                    this.f5231f = eVar.b(bVar, (List) kVar.invoke(applicationContext), this.f5229d, new a(applicationContext, this));
                }
                interfaceC0523i = this.f5231f;
                r.c(interfaceC0523i);
            } catch (Throwable th) {
                throw th;
            }
        }
        return interfaceC0523i;
    }
}
