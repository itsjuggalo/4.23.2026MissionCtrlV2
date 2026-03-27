package y3;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import w3.InterfaceC2775a;
import w3.InterfaceC2776b;
import y3.h;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f25660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f25661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v3.e f25662c;

    public static final class a implements InterfaceC2776b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final v3.e f25663d = new v3.e() { // from class: y3.g
            @Override // v3.InterfaceC2766b
            public final void a(Object obj, Object obj2) {
                h.a.e(obj, (v3.f) obj2);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map f25664a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map f25665b = new HashMap();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public v3.e f25666c = f25663d;

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void e(Object obj, v3.f fVar) {
            throw new v3.c("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
        }

        public h c() {
            return new h(new HashMap(this.f25664a), new HashMap(this.f25665b), this.f25666c);
        }

        public a d(InterfaceC2775a interfaceC2775a) {
            interfaceC2775a.a(this);
            return this;
        }

        @Override // w3.InterfaceC2776b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public a a(Class cls, v3.e eVar) {
            this.f25664a.put(cls, eVar);
            this.f25665b.remove(cls);
            return this;
        }
    }

    public h(Map map, Map map2, v3.e eVar) {
        this.f25660a = map;
        this.f25661b = map2;
        this.f25662c = eVar;
    }

    public static a a() {
        return new a();
    }

    public void b(Object obj, OutputStream outputStream) {
        new f(outputStream, this.f25660a, this.f25661b, this.f25662c).t(obj);
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
