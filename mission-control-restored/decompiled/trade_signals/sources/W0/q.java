package W0;

import android.util.Log;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class q extends Exception {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final StackTraceElement[] f9206g = new StackTraceElement[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f9207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public U0.f f9208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public U0.a f9209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Class f9210d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f9211e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Exception f9212f;

    public static final class a implements Appendable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Appendable f9213a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f9214b = true;

        public a(Appendable appendable) {
            this.f9213a = appendable;
        }

        public final CharSequence a(CharSequence charSequence) {
            return charSequence == null ? "" : charSequence;
        }

        @Override // java.lang.Appendable
        public Appendable append(char c8) throws IOException {
            if (this.f9214b) {
                this.f9214b = false;
                this.f9213a.append("  ");
            }
            this.f9214b = c8 == '\n';
            this.f9213a.append(c8);
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence) {
            CharSequence charSequenceA = a(charSequence);
            return append(charSequenceA, 0, charSequenceA.length());
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence, int i8, int i9) throws IOException {
            CharSequence charSequenceA = a(charSequence);
            boolean z7 = false;
            if (this.f9214b) {
                this.f9214b = false;
                this.f9213a.append("  ");
            }
            if (charSequenceA.length() > 0 && charSequenceA.charAt(i9 - 1) == '\n') {
                z7 = true;
            }
            this.f9214b = z7;
            this.f9213a.append(charSequenceA, i8, i9);
            return this;
        }
    }

    public q(String str) {
        this(str, Collections.emptyList());
    }

    public static void b(List list, Appendable appendable) {
        try {
            c(list, appendable);
        } catch (IOException e8) {
            throw new RuntimeException(e8);
        }
    }

    public static void c(List list, Appendable appendable) throws IOException {
        int size = list.size();
        int i8 = 0;
        while (i8 < size) {
            int i9 = i8 + 1;
            appendable.append("Cause (").append(String.valueOf(i9)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th = (Throwable) list.get(i8);
            if (th instanceof q) {
                ((q) th).h(appendable);
            } else {
                d(th, appendable);
            }
            i8 = i9;
        }
    }

    public static void d(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append('\n');
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    public final void a(Throwable th, List list) {
        if (!(th instanceof q)) {
            list.add(th);
            return;
        }
        Iterator it = ((q) th).e().iterator();
        while (it.hasNext()) {
            a((Throwable) it.next(), list);
        }
    }

    public List e() {
        return this.f9207a;
    }

    public List f() {
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        return arrayList;
    }

    public void g(String str) {
        List listF = f();
        int size = listF.size();
        int i8 = 0;
        while (i8 < size) {
            StringBuilder sb = new StringBuilder();
            sb.append("Root cause (");
            int i9 = i8 + 1;
            sb.append(i9);
            sb.append(" of ");
            sb.append(size);
            sb.append(")");
            Log.i(str, sb.toString(), (Throwable) listF.get(i8));
            i8 = i9;
        }
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String str;
        StringBuilder sb = new StringBuilder(71);
        sb.append(this.f9211e);
        sb.append(this.f9210d != null ? ", " + this.f9210d : "");
        sb.append(this.f9209c != null ? ", " + this.f9209c : "");
        sb.append(this.f9208b != null ? ", " + this.f9208b : "");
        List<Throwable> listF = f();
        if (listF.isEmpty()) {
            return sb.toString();
        }
        if (listF.size() == 1) {
            str = "\nThere was 1 root cause:";
        } else {
            sb.append("\nThere were ");
            sb.append(listF.size());
            str = " root causes:";
        }
        sb.append(str);
        for (Throwable th : listF) {
            sb.append('\n');
            sb.append(th.getClass().getName());
            sb.append('(');
            sb.append(th.getMessage());
            sb.append(')');
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    public final void h(Appendable appendable) {
        d(this, appendable);
        b(e(), new a(appendable));
    }

    public void i(U0.f fVar, U0.a aVar) {
        j(fVar, aVar, null);
    }

    public void j(U0.f fVar, U0.a aVar, Class cls) {
        this.f9208b = fVar;
        this.f9209c = aVar;
        this.f9210d = cls;
    }

    public void k(Exception exc) {
        this.f9212f = exc;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public q(String str, Throwable th) {
        this(str, Collections.singletonList(th));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        h(printStream);
    }

    public q(String str, List list) {
        this.f9211e = str;
        setStackTrace(f9206g);
        this.f9207a = list;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        h(printWriter);
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }
}
