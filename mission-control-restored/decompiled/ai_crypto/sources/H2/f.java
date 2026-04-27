package H2;

import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2597a;

    public f(String str) {
        this.f2597a = (String) m.n(str);
    }

    public static f e(char c7) {
        return new f(String.valueOf(c7));
    }

    public Appendable a(Appendable appendable, Iterator it) throws IOException {
        m.n(appendable);
        if (it.hasNext()) {
            appendable.append(f(it.next()));
            while (it.hasNext()) {
                appendable.append(this.f2597a);
                appendable.append(f(it.next()));
            }
        }
        return appendable;
    }

    public final StringBuilder b(StringBuilder sb, Iterator it) {
        try {
            a(sb, it);
            return sb;
        } catch (IOException e7) {
            throw new AssertionError(e7);
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
