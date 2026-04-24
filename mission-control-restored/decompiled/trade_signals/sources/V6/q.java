package V6;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class q {
    public static void a(Appendable appendable, Object obj, B5.k kVar) {
        CharSequence string;
        AbstractC2304t.f(appendable, "<this>");
        if (kVar == null) {
            if (!(obj == null ? true : obj instanceof CharSequence)) {
                if (obj instanceof Character) {
                    appendable.append(((Character) obj).charValue());
                    return;
                }
                string = obj.toString();
            }
            appendable.append(string);
        }
        obj = kVar.invoke(obj);
        string = (CharSequence) obj;
        appendable.append(string);
    }
}
