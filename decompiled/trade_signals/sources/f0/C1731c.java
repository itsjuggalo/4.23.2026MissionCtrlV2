package f0;

import B5.k;
import I5.m;
import Y6.L;
import android.content.Context;
import b0.InterfaceC1178i;
import c0.C1243b;
import g0.C1775e;
import java.io.File;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.AbstractC2306v;

/* JADX INFO: renamed from: f0.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1731c implements E5.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C1243b f17348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f17349c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final L f17350d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f17351e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile InterfaceC1178i f17352f;

    /* JADX INFO: renamed from: f0.c$a */
    public static final class a extends AbstractC2306v implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f17353a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ C1731c f17354b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, C1731c c1731c) {
            super(0);
            this.f17353a = context;
            this.f17354b = c1731c;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final File invoke() {
            Context applicationContext = this.f17353a;
            AbstractC2304t.e(applicationContext, "applicationContext");
            return AbstractC1730b.a(applicationContext, this.f17354b.f17347a);
        }
    }

    public C1731c(String name, C1243b c1243b, k produceMigrations, L scope) {
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(produceMigrations, "produceMigrations");
        AbstractC2304t.f(scope, "scope");
        this.f17347a = name;
        this.f17348b = c1243b;
        this.f17349c = produceMigrations;
        this.f17350d = scope;
        this.f17351e = new Object();
    }

    @Override // E5.c
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public InterfaceC1178i a(Context thisRef, m property) {
        InterfaceC1178i interfaceC1178i;
        AbstractC2304t.f(thisRef, "thisRef");
        AbstractC2304t.f(property, "property");
        InterfaceC1178i interfaceC1178i2 = this.f17352f;
        if (interfaceC1178i2 != null) {
            return interfaceC1178i2;
        }
        synchronized (this.f17351e) {
            try {
                if (this.f17352f == null) {
                    Context applicationContext = thisRef.getApplicationContext();
                    C1775e c1775e = C1775e.f17973a;
                    C1243b c1243b = this.f17348b;
                    k kVar = this.f17349c;
                    AbstractC2304t.e(applicationContext, "applicationContext");
                    this.f17352f = c1775e.b(c1243b, (List) kVar.invoke(applicationContext), this.f17350d, new a(applicationContext, this));
                }
                interfaceC1178i = this.f17352f;
                AbstractC2304t.c(interfaceC1178i);
            } catch (Throwable th) {
                throw th;
            }
        }
        return interfaceC1178i;
    }
}
