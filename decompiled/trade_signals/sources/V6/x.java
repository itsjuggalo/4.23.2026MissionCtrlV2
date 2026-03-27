package V6;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class x extends w {
    public static StringBuilder j(StringBuilder sb, String... value) {
        AbstractC2304t.f(sb, "<this>");
        AbstractC2304t.f(value, "value");
        for (String str : value) {
            sb.append(str);
        }
        return sb;
    }
}
