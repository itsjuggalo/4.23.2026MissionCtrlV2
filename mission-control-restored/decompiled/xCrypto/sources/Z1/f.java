package Z1;

import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5972a;

    public f(String str) {
        this.f5972a = (String) m.n(str);
    }

    public static f e(char c4) {
        return new f(String.valueOf(c4));
    }

    public Appendable a(Appendable appendable, Iterator it) throws IOException {
        m.n(appendable);
        if (it.hasNext()) {
            appendable.append(f(it.next()));
            while (it.hasNext()) {
                appendable.append(this.f5972a);
                appendable.append(f(it.next()));
            }
        }
        return appendable;
    }

    public final StringBuilder b(StringBuilder sb, Iterator it) {
        try {
            a(sb, it);
            return sb;
        } catch (IOException e4) {
            throw new AssertionError(e4);
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
