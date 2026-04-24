package q5;

import java.util.Map;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2585g;

/* JADX INFO: renamed from: q5.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2634a extends AbstractC2585g {
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            return d((Map.Entry) obj);
        }
        return false;
    }

    public final boolean d(Map.Entry element) {
        AbstractC2304t.f(element, "element");
        return e(element);
    }

    public abstract boolean e(Map.Entry entry);

    public abstract /* bridge */ boolean f(Map.Entry entry);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof Map.Entry) {
            return f((Map.Entry) obj);
        }
        return false;
    }
}
