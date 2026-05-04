package y8;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f25322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f25323b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f25324a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map f25325b = null;

        public b(String str) {
            this.f25324a = str;
        }

        public d a() {
            return new d(this.f25324a, this.f25325b == null ? Collections.EMPTY_MAP : Collections.unmodifiableMap(new HashMap(this.f25325b)));
        }

        public b b(Annotation annotation) {
            if (this.f25325b == null) {
                this.f25325b = new HashMap();
            }
            this.f25325b.put(annotation.annotationType(), annotation);
            return this;
        }
    }

    public static b a(String str) {
        return new b(str);
    }

    public static d d(String str) {
        return new d(str, Collections.EMPTY_MAP);
    }

    public String b() {
        return this.f25322a;
    }

    public Annotation c(Class cls) {
        return (Annotation) this.f25323b.get(cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f25322a.equals(dVar.f25322a) && this.f25323b.equals(dVar.f25323b);
    }

    public int hashCode() {
        return (this.f25322a.hashCode() * 31) + this.f25323b.hashCode();
    }

    public String toString() {
        return "FieldDescriptor{name=" + this.f25322a + ", properties=" + this.f25323b.values() + "}";
    }

    public d(String str, Map map) {
        this.f25322a = str;
        this.f25323b = map;
    }
}
