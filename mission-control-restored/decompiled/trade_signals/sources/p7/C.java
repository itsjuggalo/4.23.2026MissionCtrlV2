package p7;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import q7.e0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\u0007\n\u0002\u0010\u001e\n\u0002\b\u0005\b\u0007\u0018\u0000 *2\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002:\u0001\u001bB\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0003H\u0096\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0001H\u0096\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0011\u001a\u00020\u0003H\u0096\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b\u0019\u0010\u001aR \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR&\u0010!\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u001e0\u001d8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\u001d8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\"\u0010 R\u0014\u0010%\u001a\u00020\f8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b$\u0010\u000eR\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00010&8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lp7/C;", "Lp7/i;", "", "", FirebaseAnalytics.Param.CONTENT, "<init>", "(Ljava/util/Map;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "key", "d", "(Ljava/lang/String;)Z", "value", "e", "(Lp7/i;)Z", "f", "(Ljava/lang/String;)Lp7/i;", "isEmpty", "()Z", "a", "Ljava/util/Map;", "", "", "h", "()Ljava/util/Set;", "entries", "n", "keys", "C", "size", "", "F", "()Ljava/util/Collection;", "values", "Companion", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0})
public final class C extends i implements Map<String, i>, C5.a {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Map content;

    /* JADX INFO: renamed from: p7.C$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion() {
        }

        public final k7.b serializer() {
            return D.f22427a;
        }

        public /* synthetic */ Companion(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C(Map content) {
        super(null);
        AbstractC2304t.f(content, "content");
        this.content = content;
    }

    public static final CharSequence I(Map.Entry entry) {
        AbstractC2304t.f(entry, "<destruct>");
        String str = (String) entry.getKey();
        i iVar = (i) entry.getValue();
        StringBuilder sb = new StringBuilder();
        e0.c(sb, str);
        sb.append(':');
        sb.append(iVar);
        String string = sb.toString();
        AbstractC2304t.e(string, "toString(...)");
        return string;
    }

    public int C() {
        return this.content.size();
    }

    public Collection F() {
        return this.content.values();
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public i remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ i compute(String str, BiFunction<? super String, ? super i, ? extends i> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ i computeIfAbsent(String str, Function<? super String, ? extends i> function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ i computeIfPresent(String str, BiFunction<? super String, ? super i, ? extends i> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof String) {
            return d((String) obj);
        }
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof i) {
            return e((i) obj);
        }
        return false;
    }

    public boolean d(String key) {
        AbstractC2304t.f(key, "key");
        return this.content.containsKey(key);
    }

    public boolean e(i value) {
        AbstractC2304t.f(value, "value");
        return this.content.containsValue(value);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<String, i>> entrySet() {
        return h();
    }

    @Override // java.util.Map
    public boolean equals(Object other) {
        return AbstractC2304t.b(this.content, other);
    }

    public i f(String key) {
        AbstractC2304t.f(key, "key");
        return (i) this.content.get(key);
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ i get(Object obj) {
        if (obj instanceof String) {
            return f((String) obj);
        }
        return null;
    }

    public Set h() {
        return this.content.entrySet();
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.content.hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.content.isEmpty();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return n();
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ i merge(String str, i iVar, BiFunction<? super i, ? super i, ? extends i> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Set n() {
        return this.content.keySet();
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ i put(String str, i iVar) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends i> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ i putIfAbsent(String str, i iVar) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ i replace(String str, i iVar) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void replaceAll(BiFunction<? super String, ? super i, ? extends i> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return C();
    }

    public String toString() {
        return p5.z.h0(this.content.entrySet(), com.amazon.a.a.o.b.f.f14100a, "{", "}", 0, null, new B5.k() { // from class: p7.B
            @Override // B5.k
            public final Object invoke(Object obj) {
                return C.I((Map.Entry) obj);
            }
        }, 24, null);
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<i> values() {
        return F();
    }

    @Override // java.util.Map
    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ boolean replace(String str, i iVar, i iVar2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
