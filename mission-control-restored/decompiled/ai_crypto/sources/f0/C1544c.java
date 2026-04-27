package f0;

import Q5.k;
import X5.j;
import android.content.Context;
import b6.L;
import c0.InterfaceC1119h;
import d0.C1389b;
import java.io.File;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: renamed from: f0.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1544c implements T5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C1389b f14027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f14028c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final L f14029d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f14030e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile InterfaceC1119h f14031f;

    /* JADX INFO: renamed from: f0.c$a */
    public static final class a extends s implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f14032a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ C1544c f14033b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, C1544c c1544c) {
            super(0);
            this.f14032a = context;
            this.f14033b = c1544c;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final File invoke() {
            Context applicationContext = this.f14032a;
            r.e(applicationContext, "applicationContext");
            return AbstractC1543b.a(applicationContext, this.f14033b.f14026a);
        }
    }

    public C1544c(String name, C1389b c1389b, k produceMigrations, L scope) {
        r.f(name, "name");
        r.f(produceMigrations, "produceMigrations");
        r.f(scope, "scope");
        this.f14026a = name;
        this.f14027b = c1389b;
        this.f14028c = produceMigrations;
        this.f14029d = scope;
        this.f14030e = new Object();
    }

    @Override // T5.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC1119h a(Context thisRef, j property) {
        InterfaceC1119h interfaceC1119h;
        r.f(thisRef, "thisRef");
        r.f(property, "property");
        InterfaceC1119h interfaceC1119h2 = this.f14031f;
        if (interfaceC1119h2 != null) {
            return interfaceC1119h2;
        }
        synchronized (this.f14030e) {
            try {
                if (this.f14031f == null) {
                    Context applicationContext = thisRef.getApplicationContext();
                    g0.e eVar = g0.e.f14249a;
                    C1389b c1389b = this.f14027b;
                    k kVar = this.f14028c;
                    r.e(applicationContext, "applicationContext");
                    this.f14031f = eVar.b(c1389b, (List) kVar.invoke(applicationContext), this.f14029d, new a(applicationContext, this));
                }
                interfaceC1119h = this.f14031f;
                r.c(interfaceC1119h);
            } catch (Throwable th) {
                throw th;
            }
        }
        return interfaceC1119h;
    }
}
