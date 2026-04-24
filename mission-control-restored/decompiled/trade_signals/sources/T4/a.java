package T4;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f7995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7996b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Throwable f7997c;

    /* JADX INFO: renamed from: T4.a$a, reason: collision with other inner class name */
    public static final class C0115a extends RuntimeException {
        @Override // java.lang.Throwable
        public String getMessage() {
            return "Chain of Causes for CompositeException In Order Received =>";
        }
    }

    public static abstract class b {
        public abstract void a(Object obj);
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PrintStream f7998a;

        public c(PrintStream printStream) {
            this.f7998a = printStream;
        }

        @Override // T4.a.b
        public void a(Object obj) {
            this.f7998a.println(obj);
        }
    }

    public static final class d extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PrintWriter f7999a;

        public d(PrintWriter printWriter) {
            this.f7999a = printWriter;
        }

        @Override // T4.a.b
        public void a(Object obj) {
            this.f7999a.println(obj);
        }
    }

    public a(Iterable iterable) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        if (iterable != null) {
            for (Object obj : iterable) {
                if (obj instanceof a) {
                    linkedHashSet.addAll(((a) obj).b());
                } else {
                    linkedHashSet.add(obj == null ? new NullPointerException("Throwable was null!") : obj);
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException("errors was null"));
        }
        if (linkedHashSet.isEmpty()) {
            throw new IllegalArgumentException("errors is empty");
        }
        arrayList.addAll(linkedHashSet);
        List listUnmodifiableList = Collections.unmodifiableList(arrayList);
        this.f7995a = listUnmodifiableList;
        this.f7996b = listUnmodifiableList.size() + " exceptions occurred. ";
    }

    public final void a(StringBuilder sb, Throwable th, String str) {
        sb.append(str);
        sb.append(th);
        sb.append('\n');
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            sb.append("\t\tat ");
            sb.append(stackTraceElement);
            sb.append('\n');
        }
        if (th.getCause() != null) {
            sb.append("\tCaused by: ");
            a(sb, th.getCause(), "");
        }
    }

    public List b() {
        return this.f7995a;
    }

    public final List c(Throwable th) {
        ArrayList arrayList = new ArrayList();
        Throwable cause = th.getCause();
        if (cause != null && cause != th) {
            while (true) {
                arrayList.add(cause);
                Throwable cause2 = cause.getCause();
                if (cause2 == null || cause2 == cause) {
                    break;
                }
                cause = cause2;
            }
        }
        return arrayList;
    }

    public Throwable d(Throwable th) {
        Throwable cause = th.getCause();
        if (cause == null || this.f7997c == cause) {
            return th;
        }
        while (true) {
            Throwable cause2 = cause.getCause();
            if (cause2 == null || cause2 == cause) {
                break;
            }
            cause = cause2;
        }
        return cause;
    }

    public final void e(b bVar) {
        StringBuilder sb = new StringBuilder(128);
        sb.append(this);
        sb.append('\n');
        for (StackTraceElement stackTraceElement : getStackTrace()) {
            sb.append("\tat ");
            sb.append(stackTraceElement);
            sb.append('\n');
        }
        int i8 = 1;
        for (Throwable th : this.f7995a) {
            sb.append("  ComposedException ");
            sb.append(i8);
            sb.append(" :\n");
            a(sb, th, "\t");
            i8++;
        }
        bVar.a(sb.toString());
    }

    @Override // java.lang.Throwable
    public synchronized Throwable getCause() {
        try {
            if (this.f7997c == null) {
                C0115a c0115a = new C0115a();
                HashSet hashSet = new HashSet();
                Throwable thD = c0115a;
                for (Throwable runtimeException : this.f7995a) {
                    if (!hashSet.contains(runtimeException)) {
                        hashSet.add(runtimeException);
                        for (Throwable th : c(runtimeException)) {
                            if (hashSet.contains(th)) {
                                runtimeException = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
                            } else {
                                hashSet.add(th);
                            }
                        }
                        try {
                            thD.initCause(runtimeException);
                        } catch (Throwable unused) {
                        }
                        thD = d(thD);
                    }
                }
                this.f7997c = c0115a;
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f7997c;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f7996b;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public a(Throwable... thArr) {
        this(thArr == null ? Collections.singletonList(new NullPointerException("exceptions was null")) : Arrays.asList(thArr));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        e(new c(printStream));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        e(new d(printWriter));
    }
}
