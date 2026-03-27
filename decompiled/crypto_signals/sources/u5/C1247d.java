package u5;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: u5.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1247d implements E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f10516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f10517c;

    public /* synthetic */ C1247d(int i, Object obj, Object obj2) {
        this.f10515a = i;
        this.f10516b = obj;
        this.f10517c = obj2;
    }

    @Override // u5.E
    public final long a(long j4, C1250g sink) throws IOException {
        switch (this.f10515a) {
            case 0:
                kotlin.jvm.internal.j.e(sink, "sink");
                C1247d c1247d = (C1247d) this.f10517c;
                D d4 = (D) this.f10516b;
                d4.f();
                try {
                    long jA = c1247d.a(j4, sink);
                    if (d4.g()) {
                        throw d4.i(null);
                    }
                    return jA;
                } catch (IOException e) {
                    if (d4.g()) {
                        throw d4.i(e);
                    }
                    throw e;
                } finally {
                    d4.g();
                }
            default:
                kotlin.jvm.internal.j.e(sink, "sink");
                if (j4 == 0) {
                    return 0L;
                }
                if (j4 < 0) {
                    throw new IllegalArgumentException(k0.a.f("byteCount < 0: ", j4).toString());
                }
                try {
                    ((G) this.f10517c).e();
                    z zVarW = sink.w(1);
                    int i = ((InputStream) this.f10516b).read(zVarW.f10558a, zVarW.f10560c, (int) Math.min(j4, 8192 - zVarW.f10560c));
                    if (i == -1) {
                        if (zVarW.f10559b == zVarW.f10560c) {
                            sink.f10525a = zVarW.a();
                            A.a(zVarW);
                        }
                        return -1L;
                    }
                    zVarW.f10560c += i;
                    long j6 = i;
                    sink.f10526b += j6;
                    return j6;
                } catch (AssertionError e2) {
                    if (AbstractC1245b.f(e2)) {
                        throw new IOException(e2);
                    }
                    throw e2;
                }
        }
    }

    @Override // u5.E
    public final G b() {
        switch (this.f10515a) {
            case 0:
                return (D) this.f10516b;
            default:
                return (G) this.f10517c;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        switch (this.f10515a) {
            case 0:
                C1247d c1247d = (C1247d) this.f10517c;
                D d4 = (D) this.f10516b;
                d4.f();
                try {
                    c1247d.close();
                    if (d4.g()) {
                        throw d4.i(null);
                    }
                    return;
                } catch (IOException e) {
                    if (!d4.g()) {
                        throw e;
                    }
                    throw d4.i(e);
                } finally {
                    d4.g();
                }
            default:
                ((InputStream) this.f10516b).close();
                return;
        }
    }

    public final String toString() {
        switch (this.f10515a) {
            case 0:
                return "AsyncTimeout.source(" + ((C1247d) this.f10517c) + ')';
            default:
                return "source(" + ((InputStream) this.f10516b) + ')';
        }
    }
}
