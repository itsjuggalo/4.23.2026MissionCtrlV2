package s6;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.jvm.internal.AbstractC2148j;
import t6.a0;

/* JADX INFO: loaded from: classes2.dex */
public final class u extends h implements Map<String, h>, R5.a {
    public static final a Companion = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f23068a;

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public final n6.b serializer() {
            return v.f23070a;
        }

        public a() {
        }
    }

    public static final class b extends kotlin.jvm.internal.s implements Q5.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f23069a = new b();

        public b() {
            super(1);
        }

        @Override // Q5.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(Map.Entry entry) {
            kotlin.jvm.internal.r.f(entry, "<name for destructuring parameter 0>");
            String str = (String) entry.getKey();
            h hVar = (h) entry.getValue();
            StringBuilder sb = new StringBuilder();
            a0.c(sb, str);
            sb.append(':');
            sb.append(hVar);
            String string = sb.toString();
            kotlin.jvm.internal.r.e(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(Map content) {
        super(null);
        kotlin.jvm.internal.r.f(content, "content");
        this.f23068a = content;
    }

    public boolean a(String key) {
        kotlin.jvm.internal.r.f(key, "key");
        return this.f23068a.containsKey(key);
    }

    public boolean c(h value) {
        kotlin.jvm.internal.r.f(value, "value");
        return this.f23068a.containsValue(value);
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ h compute(String str, BiFunction<? super String, ? super h, ? extends h> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ h computeIfAbsent(String str, Function<? super String, ? extends h> function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ h computeIfPresent(String str, BiFunction<? super String, ? super h, ? extends h> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof String) {
            return a((String) obj);
        }
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof h) {
            return c((h) obj);
        }
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<String, h>> entrySet() {
        return h();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return kotlin.jvm.internal.r.b(this.f23068a, obj);
    }

    public h g(String key) {
        kotlin.jvm.internal.r.f(key, "key");
        return (h) this.f23068a.get(key);
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ h get(Object obj) {
        if (obj instanceof String) {
            return g((String) obj);
        }
        return null;
    }

    public Set h() {
        return this.f23068a.entrySet();
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.f23068a.hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.f23068a.isEmpty();
    }

    public Set j() {
        return this.f23068a.keySet();
    }

    public int k() {
        return this.f23068a.size();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return j();
    }

    public Collection l() {
        return this.f23068a.values();
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public h remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ h merge(String str, h hVar, BiFunction<? super h, ? super h, ? extends h> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ h put(String str, h hVar) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends h> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ h putIfAbsent(String str, h hVar) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ h replace(String str, h hVar) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void replaceAll(BiFunction<? super String, ? super h, ? extends h> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return k();
    }

    public String toString() {
        return F5.v.R(this.f23068a.entrySet(), com.amazon.a.a.o.b.f.f9989a, "{", "}", 0, null, b.f23069a, 24, null);
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<h> values() {
        return l();
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ boolean replace(String str, h hVar, h hVar2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
