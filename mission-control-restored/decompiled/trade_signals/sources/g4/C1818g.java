package g4;

import V6.C0977c;
import android.util.Log;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import w1.AbstractC2901d;
import w1.C2900c;
import w1.InterfaceC2905h;
import w1.InterfaceC2907j;

/* JADX INFO: renamed from: g4.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1818g implements InterfaceC1819h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f18191b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S3.b f18192a;

    /* JADX INFO: renamed from: g4.g$a */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public C1818g(S3.b transportFactoryProvider) {
        AbstractC2304t.f(transportFactoryProvider, "transportFactoryProvider");
        this.f18192a = transportFactoryProvider;
    }

    @Override // g4.InterfaceC1819h
    public void a(C1794I sessionEvent) {
        AbstractC2304t.f(sessionEvent, "sessionEvent");
        ((InterfaceC2907j) this.f18192a.get()).b("FIREBASE_APPQUALITY_SESSION", C1794I.class, C2900c.b("json"), new InterfaceC2905h() { // from class: g4.f
            @Override // w1.InterfaceC2905h
            public final Object apply(Object obj) {
                return this.f18190a.c((C1794I) obj);
            }
        }).b(AbstractC2901d.f(sessionEvent));
    }

    public final byte[] c(C1794I c1794i) {
        String strB = C1795J.f18035a.c().b(c1794i);
        AbstractC2304t.e(strB, "encode(...)");
        Log.d("FirebaseSessions", "Session Event Type: " + c1794i.b().name());
        byte[] bytes = strB.getBytes(C0977c.f8956b);
        AbstractC2304t.e(bytes, "getBytes(...)");
        return bytes;
    }
}
