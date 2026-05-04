package p6;

import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18317a;

    public g(String str) {
        this.f18317a = (String) n.n(str);
    }

    public static g e(char c10) {
        return new g(String.valueOf(c10));
    }

    public Appendable a(Appendable appendable, Iterator it) throws IOException {
        n.n(appendable);
        if (it.hasNext()) {
            appendable.append(f(it.next()));
            while (it.hasNext()) {
                appendable.append(this.f18317a);
                appendable.append(f(it.next()));
            }
        }
        return appendable;
    }

    public final StringBuilder b(StringBuilder sb2, Iterator it) {
        try {
            a(sb2, it);
            return sb2;
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }

    public final String c(Iterable iterable) {
        return d(iterable.iterator());
    }

    public final String d(Iterator it) {
        return b(new StringBuilder(), it).toString();
    }

    public CharSequence f(Object obj) {
        Objects.requireNonNull(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }
}
