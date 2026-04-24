package w3;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f24063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f24064b;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f24065a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map f24066b = null;

        public b(String str) {
            this.f24065a = str;
        }

        public d a() {
            return new d(this.f24065a, this.f24066b == null ? Collections.emptyMap() : Collections.unmodifiableMap(new HashMap(this.f24066b)));
        }

        public b b(Annotation annotation) {
            if (this.f24066b == null) {
                this.f24066b = new HashMap();
            }
            this.f24066b.put(annotation.annotationType(), annotation);
            return this;
        }
    }

    public d(String str, Map map) {
        this.f24063a = str;
        this.f24064b = map;
    }

    public static b a(String str) {
        return new b(str);
    }

    public static d d(String str) {
        return new d(str, Collections.emptyMap());
    }

    public String b() {
        return this.f24063a;
    }

    public Annotation c(Class cls) {
        return (Annotation) this.f24064b.get(cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f24063a.equals(dVar.f24063a) && this.f24064b.equals(dVar.f24064b);
    }

    public int hashCode() {
        return (this.f24063a.hashCode() * 31) + this.f24064b.hashCode();
    }

    public String toString() {
        return "FieldDescriptor{name=" + this.f24063a + ", properties=" + this.f24064b.values() + "}";
    }
}
