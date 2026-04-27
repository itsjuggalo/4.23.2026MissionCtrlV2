package K3;

import L3.a0;
import j3.InterfaceC1564a;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes3.dex */
public final class u extends h implements Map<String, h>, InterfaceC1564a {
    public static final a Companion = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f1381a;

    public static final class a {
        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public final F3.b serializer() {
            return v.f1383a;
        }

        public a() {
        }
    }

    public static final class b extends kotlin.jvm.internal.s implements i3.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f1382a = new b();

        public b() {
            super(1);
        }

        @Override // i3.k
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
        this.f1381a = content;
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
            return f((String) obj);
        }
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof h) {
            return i((h) obj);
        }
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<String, h>> entrySet() {
        return l();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return kotlin.jvm.internal.r.b(this.f1381a, obj);
    }

    public boolean f(String key) {
        kotlin.jvm.internal.r.f(key, "key");
        return this.f1381a.containsKey(key);
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ h get(Object obj) {
        if (obj instanceof String) {
            return k((String) obj);
        }
        return null;
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.f1381a.hashCode();
    }

    public boolean i(h value) {
        kotlin.jvm.internal.r.f(value, "value");
        return this.f1381a.containsValue(value);
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.f1381a.isEmpty();
    }

    public h k(String key) {
        kotlin.jvm.internal.r.f(key, "key");
        return (h) this.f1381a.get(key);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return m();
    }

    public Set l() {
        return this.f1381a.entrySet();
    }

    public Set m() {
        return this.f1381a.keySet();
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ h merge(String str, h hVar, BiFunction<? super h, ? super h, ? extends h> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public int n() {
        return this.f1381a.size();
    }

    public Collection o() {
        return this.f1381a.values();
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public h remove(Object obj) {
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
        return n();
    }

    public String toString() {
        return X2.x.Q(this.f1381a.entrySet(), com.amazon.a.a.o.b.f.f8804a, "{", "}", 0, null, b.f1382a, 24, null);
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<h> values() {
        return o();
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ boolean replace(String str, h hVar, h hVar2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
