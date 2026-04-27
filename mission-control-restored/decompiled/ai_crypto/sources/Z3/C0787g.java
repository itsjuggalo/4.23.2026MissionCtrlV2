package Z3;

import Z5.C0796c;
import android.util.Log;
import kotlin.jvm.internal.AbstractC2148j;
import o1.AbstractC2292d;
import o1.C2291c;
import o1.InterfaceC2296h;
import o1.InterfaceC2298j;

/* JADX INFO: renamed from: Z3.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0787g implements InterfaceC0788h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f5936b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final N3.b f5937a;

    /* JADX INFO: renamed from: Z3.g$a */
    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public a() {
        }
    }

    public C0787g(N3.b transportFactoryProvider) {
        kotlin.jvm.internal.r.f(transportFactoryProvider, "transportFactoryProvider");
        this.f5937a = transportFactoryProvider;
    }

    @Override // Z3.InterfaceC0788h
    public void a(y sessionEvent) {
        kotlin.jvm.internal.r.f(sessionEvent, "sessionEvent");
        ((InterfaceC2298j) this.f5937a.get()).a("FIREBASE_APPQUALITY_SESSION", y.class, C2291c.b("json"), new InterfaceC2296h() { // from class: Z3.f
            @Override // o1.InterfaceC2296h
            public final Object apply(Object obj) {
                return this.f5935a.c((y) obj);
            }
        }).a(AbstractC2292d.f(sessionEvent));
    }

    public final byte[] c(y yVar) {
        String strB = z.f6012a.c().b(yVar);
        kotlin.jvm.internal.r.e(strB, "SessionEvents.SESSION_EVENT_ENCODER.encode(value)");
        Log.d("EventGDTLogger", "Session Event Type: " + yVar.b().name());
        byte[] bytes = strB.getBytes(C0796c.f6018b);
        kotlin.jvm.internal.r.e(bytes, "getBytes(...)");
        return bytes;
    }
}
