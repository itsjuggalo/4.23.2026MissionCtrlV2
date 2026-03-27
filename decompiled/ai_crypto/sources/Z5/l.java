package Z5;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l {
    public static void a(Appendable appendable, Object obj, Q5.k kVar) {
        kotlin.jvm.internal.r.f(appendable, "<this>");
        if (kVar != null) {
            appendable.append((CharSequence) kVar.invoke(obj));
            return;
        }
        if (obj == null ? true : obj instanceof CharSequence) {
            appendable.append((CharSequence) obj);
        } else if (obj instanceof Character) {
            appendable.append(((Character) obj).charValue());
        } else {
            appendable.append(String.valueOf(obj));
        }
    }
}
