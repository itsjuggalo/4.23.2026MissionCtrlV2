package v2;

import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: renamed from: v2.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2841g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f23757a;

    public C2841g(String str) {
        this.f23757a = (String) AbstractC2848n.n(str);
    }

    public static C2841g e(char c8) {
        return new C2841g(String.valueOf(c8));
    }

    public Appendable a(Appendable appendable, Iterator it) throws IOException {
        AbstractC2848n.n(appendable);
        if (it.hasNext()) {
            while (true) {
                appendable.append(f(it.next()));
                if (!it.hasNext()) {
                    break;
                }
                appendable.append(this.f23757a);
            }
        }
        return appendable;
    }

    public final StringBuilder b(StringBuilder sb, Iterator it) {
        try {
            a(sb, it);
            return sb;
        } catch (IOException e8) {
            throw new AssertionError(e8);
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
