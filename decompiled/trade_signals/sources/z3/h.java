package z3;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import x3.InterfaceC2956a;
import z3.h;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f24751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f24752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w3.e f24753c;

    public static final class a implements x3.b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final w3.e f24754d = new w3.e() { // from class: z3.g
            @Override // w3.InterfaceC2923b
            public final void a(Object obj, Object obj2) {
                h.a.e(obj, (w3.f) obj2);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map f24755a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map f24756b = new HashMap();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public w3.e f24757c = f24754d;

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void e(Object obj, w3.f fVar) {
            throw new w3.c("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
        }

        public h c() {
            return new h(new HashMap(this.f24755a), new HashMap(this.f24756b), this.f24757c);
        }

        public a d(InterfaceC2956a interfaceC2956a) {
            interfaceC2956a.a(this);
            return this;
        }

        @Override // x3.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public a a(Class cls, w3.e eVar) {
            this.f24755a.put(cls, eVar);
            this.f24756b.remove(cls);
            return this;
        }
    }

    public h(Map map, Map map2, w3.e eVar) {
        this.f24751a = map;
        this.f24752b = map2;
        this.f24753c = eVar;
    }

    public static a a() {
        return new a();
    }

    public void b(Object obj, OutputStream outputStream) {
        new f(outputStream, this.f24751a, this.f24752b, this.f24753c).t(obj);
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
