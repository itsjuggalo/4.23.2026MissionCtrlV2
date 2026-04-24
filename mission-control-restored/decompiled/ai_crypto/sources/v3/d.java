package v3;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f24754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f24755b;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f24756a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map f24757b = null;

        public b(String str) {
            this.f24756a = str;
        }

        public d a() {
            return new d(this.f24756a, this.f24757b == null ? Collections.emptyMap() : Collections.unmodifiableMap(new HashMap(this.f24757b)));
        }

        public b b(Annotation annotation) {
            if (this.f24757b == null) {
                this.f24757b = new HashMap();
            }
            this.f24757b.put(annotation.annotationType(), annotation);
            return this;
        }
    }

    public static b a(String str) {
        return new b(str);
    }

    public static d d(String str) {
        return new d(str, Collections.emptyMap());
    }

    public String b() {
        return this.f24754a;
    }

    public Annotation c(Class cls) {
        return (Annotation) this.f24755b.get(cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f24754a.equals(dVar.f24754a) && this.f24755b.equals(dVar.f24755b);
    }

    public int hashCode() {
        return (this.f24754a.hashCode() * 31) + this.f24755b.hashCode();
    }

    public String toString() {
        return "FieldDescriptor{name=" + this.f24754a + ", properties=" + this.f24755b.values() + "}";
    }

    public d(String str, Map map) {
        this.f24754a = str;
        this.f24755b = map;
    }
}
