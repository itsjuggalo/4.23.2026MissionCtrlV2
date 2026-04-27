package M4;

import V4.b;
import V4.q;
import android.content.res.AssetManager;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.FlutterCallbackInformation;
import java.nio.ByteBuffer;
import java.util.List;
import q5.C2566e;

/* JADX INFO: loaded from: classes2.dex */
public class a implements V4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FlutterJNI f3844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AssetManager f3845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f3846c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final M4.c f3847d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final V4.b f3848e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f3849f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f3850g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b.a f3851h;

    /* JADX INFO: renamed from: M4.a$a, reason: collision with other inner class name */
    public class C0050a implements b.a {
        public C0050a() {
        }

        @Override // V4.b.a
        public void a(ByteBuffer byteBuffer, b.InterfaceC0092b interfaceC0092b) {
            a.this.f3850g = q.f5350b.b(byteBuffer);
            a.h(a.this);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AssetManager f3853a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f3854b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final FlutterCallbackInformation f3855c;

        public b(AssetManager assetManager, String str, FlutterCallbackInformation flutterCallbackInformation) {
            this.f3853a = assetManager;
            this.f3854b = str;
            this.f3855c = flutterCallbackInformation;
        }

        public String toString() {
            return "DartCallback( bundle path: " + this.f3854b + ", library path: " + this.f3855c.callbackLibraryPath + ", function: " + this.f3855c.callbackName + " )";
        }
    }

    public static class d implements V4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final M4.c f3859a;

        public /* synthetic */ d(M4.c cVar, C0050a c0050a) {
            this(cVar);
        }

        @Override // V4.b
        public b.c a(b.d dVar) {
            return this.f3859a.a(dVar);
        }

        @Override // V4.b
        public void b(String str, b.a aVar) {
            this.f3859a.b(str, aVar);
        }

        @Override // V4.b
        public void d(String str, ByteBuffer byteBuffer, b.InterfaceC0092b interfaceC0092b) {
            this.f3859a.d(str, byteBuffer, interfaceC0092b);
        }

        @Override // V4.b
        public void e(String str, b.a aVar, b.c cVar) {
            this.f3859a.e(str, aVar, cVar);
        }

        @Override // V4.b
        public void f(String str, ByteBuffer byteBuffer) {
            this.f3859a.d(str, byteBuffer, null);
        }

        public d(M4.c cVar) {
            this.f3859a = cVar;
        }
    }

    public interface e {
    }

    public a(FlutterJNI flutterJNI, AssetManager assetManager, long j7) {
        this.f3849f = false;
        C0050a c0050a = new C0050a();
        this.f3851h = c0050a;
        this.f3844a = flutterJNI;
        this.f3845b = assetManager;
        this.f3846c = j7;
        M4.c cVar = new M4.c(flutterJNI);
        this.f3847d = cVar;
        cVar.b("flutter/isolate", c0050a);
        this.f3848e = new d(cVar, null);
        if (flutterJNI.isAttached()) {
            this.f3849f = true;
        }
    }

    public static /* synthetic */ e h(a aVar) {
        aVar.getClass();
        return null;
    }

    @Override // V4.b
    public b.c a(b.d dVar) {
        return this.f3848e.a(dVar);
    }

    @Override // V4.b
    public void b(String str, b.a aVar) {
        this.f3848e.b(str, aVar);
    }

    @Override // V4.b
    public void d(String str, ByteBuffer byteBuffer, b.InterfaceC0092b interfaceC0092b) {
        this.f3848e.d(str, byteBuffer, interfaceC0092b);
    }

    @Override // V4.b
    public void e(String str, b.a aVar, b.c cVar) {
        this.f3848e.e(str, aVar, cVar);
    }

    @Override // V4.b
    public void f(String str, ByteBuffer byteBuffer) {
        this.f3848e.f(str, byteBuffer);
    }

    public void i(b bVar) {
        if (this.f3849f) {
            J4.b.g("DartExecutor", "Attempted to run a DartExecutor that is already running.");
            return;
        }
        C2566e c2566eK = C2566e.K("DartExecutor#executeDartCallback");
        try {
            J4.b.f("DartExecutor", "Executing Dart callback: " + bVar);
            FlutterJNI flutterJNI = this.f3844a;
            String str = bVar.f3854b;
            FlutterCallbackInformation flutterCallbackInformation = bVar.f3855c;
            flutterJNI.runBundleAndSnapshotFromLibrary(str, flutterCallbackInformation.callbackName, flutterCallbackInformation.callbackLibraryPath, bVar.f3853a, null, this.f3846c);
            this.f3849f = true;
            if (c2566eK != null) {
                c2566eK.close();
            }
        } catch (Throwable th) {
            if (c2566eK != null) {
                try {
                    c2566eK.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void j(c cVar, List list) {
        if (this.f3849f) {
            J4.b.g("DartExecutor", "Attempted to run a DartExecutor that is already running.");
            return;
        }
        C2566e c2566eK = C2566e.K("DartExecutor#executeDartEntrypoint");
        try {
            J4.b.f("DartExecutor", "Executing Dart entrypoint: " + cVar);
            this.f3844a.runBundleAndSnapshotFromLibrary(cVar.f3856a, cVar.f3858c, cVar.f3857b, this.f3845b, list, this.f3846c);
            this.f3849f = true;
            if (c2566eK != null) {
                c2566eK.close();
            }
        } catch (Throwable th) {
            if (c2566eK != null) {
                try {
                    c2566eK.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public V4.b k() {
        return this.f3848e;
    }

    public boolean l() {
        return this.f3849f;
    }

    public void m() {
        if (this.f3844a.isAttached()) {
            this.f3844a.notifyLowMemoryWarning();
        }
    }

    public void n() {
        J4.b.f("DartExecutor", "Attached to JNI. Registering the platform message handler for this Dart execution context.");
        this.f3844a.setPlatformMessageHandler(this.f3847d);
    }

    public void o() {
        J4.b.f("DartExecutor", "Detached from JNI. De-registering the platform message handler for this Dart execution context.");
        this.f3844a.setPlatformMessageHandler(null);
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f3856a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f3857b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f3858c;

        public c(String str, String str2) {
            this.f3856a = str;
            this.f3857b = null;
            this.f3858c = str2;
        }

        public static c a() {
            O4.f fVarC = J4.a.e().c();
            if (fVarC.n()) {
                return new c(fVarC.j(), "main");
            }
            throw new AssertionError("DartEntrypoints can only be created once a FlutterEngine is created.");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            if (this.f3856a.equals(cVar.f3856a)) {
                return this.f3858c.equals(cVar.f3858c);
            }
            return false;
        }

        public int hashCode() {
            return (this.f3856a.hashCode() * 31) + this.f3858c.hashCode();
        }

        public String toString() {
            return "DartEntrypoint( bundle path: " + this.f3856a + ", function: " + this.f3858c + " )";
        }

        public c(String str, String str2, String str3) {
            this.f3856a = str;
            this.f3857b = str2;
            this.f3858c = str3;
        }
    }
}
