package xa;

import android.net.Uri;
import cd.h0;
import java.net.URL;
import java.util.Map;
import kotlin.jvm.internal.t;
import ng.n0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements xa.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f24731c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ua.b f24732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gd.i f24733b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends id.m implements pd.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f24734a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map f24736c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ pd.o f24737d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ pd.o f24738e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Map map, pd.o oVar, pd.o oVar2, gd.e eVar) {
            super(2, eVar);
            this.f24736c = map;
            this.f24737d = oVar;
            this.f24738e = oVar2;
        }

        @Override // id.a
        public final gd.e create(Object obj, gd.e eVar) {
            return e.this.new b(this.f24736c, this.f24737d, this.f24738e, eVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x00cb, code lost:
        
            if (r8.invoke(r1, r7) == r0) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00e0, code lost:
        
            if (r1.invoke(r3, r7) != r0) goto L37;
         */
        @Override // id.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 230
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: xa.e.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // pd.o
        public final Object invoke(n0 n0Var, gd.e eVar) {
            return ((b) create(n0Var, eVar)).invokeSuspend(h0.f3852a);
        }
    }

    public e(ua.b appInfo, gd.i blockingDispatcher) {
        t.f(appInfo, "appInfo");
        t.f(blockingDispatcher, "blockingDispatcher");
        this.f24732a = appInfo;
        this.f24733b = blockingDispatcher;
    }

    @Override // xa.a
    public Object a(Map map, pd.o oVar, pd.o oVar2, gd.e eVar) {
        Object objG = ng.i.g(this.f24733b, new b(map, oVar, oVar2, null), eVar);
        return objG == hd.c.f() ? objG : h0.f3852a;
    }

    public final URL c() {
        return new URL(new Uri.Builder().scheme("https").authority("firebase-settings.crashlytics.com").appendPath("spi").appendPath("v2").appendPath("platforms").appendPath("android").appendPath("gmp").appendPath(this.f24732a.b()).appendPath("settings").appendQueryParameter("build_version", this.f24732a.a().a()).appendQueryParameter("display_version", this.f24732a.a().f()).build().toString());
    }
}
