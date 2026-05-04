package b9;

import b9.h;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f3052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f3053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y8.e f3054c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements z8.b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final y8.e f3055d = new y8.e() { // from class: b9.g
            @Override // y8.b
            public final void a(Object obj, Object obj2) {
                h.a.b(obj, (y8.f) obj2);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map f3056a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map f3057b = new HashMap();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public y8.e f3058c = f3055d;

        public static /* synthetic */ void b(Object obj, y8.f fVar) {
            throw new y8.c("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
        }

        public h c() {
            return new h(new HashMap(this.f3056a), new HashMap(this.f3057b), this.f3058c);
        }

        public a d(z8.a aVar) {
            aVar.a(this);
            return this;
        }

        @Override // z8.b
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public a a(Class cls, y8.e eVar) {
            this.f3056a.put(cls, eVar);
            this.f3057b.remove(cls);
            return this;
        }
    }

    public h(Map map, Map map2, y8.e eVar) {
        this.f3052a = map;
        this.f3053b = map2;
        this.f3054c = eVar;
    }

    public static a a() {
        return new a();
    }

    public void b(Object obj, OutputStream outputStream) {
        new f(outputStream, this.f3052a, this.f3053b, this.f3054c).t(obj);
    }

    public byte[] c(Object obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            b(obj, byteArrayOutputStream);
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }
}
