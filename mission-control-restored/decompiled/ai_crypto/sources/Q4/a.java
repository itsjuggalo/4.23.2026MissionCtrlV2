package Q4;

import android.content.Context;
import io.flutter.plugin.platform.InterfaceC2016m;
import io.flutter.view.TextureRegistry;

/* JADX INFO: loaded from: classes2.dex */
public interface a {

    /* JADX INFO: renamed from: Q4.a$a, reason: collision with other inner class name */
    public interface InterfaceC0075a {
        String a(String str);
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f4557a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final io.flutter.embedding.engine.a f4558b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final V4.b f4559c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextureRegistry f4560d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final InterfaceC2016m f4561e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final InterfaceC0075a f4562f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final io.flutter.embedding.engine.b f4563g;

        public b(Context context, io.flutter.embedding.engine.a aVar, V4.b bVar, TextureRegistry textureRegistry, InterfaceC2016m interfaceC2016m, InterfaceC0075a interfaceC0075a, io.flutter.embedding.engine.b bVar2) {
            this.f4557a = context;
            this.f4558b = aVar;
            this.f4559c = bVar;
            this.f4560d = textureRegistry;
            this.f4561e = interfaceC2016m;
            this.f4562f = interfaceC0075a;
            this.f4563g = bVar2;
        }

        public Context a() {
            return this.f4557a;
        }

        public V4.b b() {
            return this.f4559c;
        }

        public InterfaceC0075a c() {
            return this.f4562f;
        }

        public InterfaceC2016m d() {
            return this.f4561e;
        }
    }

    void onAttachedToEngine(b bVar);

    void onDetachedFromEngine(b bVar);
}
