package q7;

import kotlin.jvm.internal.AbstractC2304t;
import p7.AbstractC2609b;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c0 {
    public static final b0 a(AbstractC2609b json, String source) {
        AbstractC2304t.f(json, "json");
        AbstractC2304t.f(source, "source");
        return !json.f().a() ? new b0(source) : new d0(source);
    }
}
