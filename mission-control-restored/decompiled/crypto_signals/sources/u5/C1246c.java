package u5;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: renamed from: u5.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1246c implements C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f10513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f10514c;

    public /* synthetic */ C1246c(int i, Object obj, Object obj2) {
        this.f10512a = i;
        this.f10513b = obj;
        this.f10514c = obj2;
    }

    @Override // u5.C
    public final void c(long j4, C1250g c1250g) throws IOException {
        switch (this.f10512a) {
            case 0:
                AbstractC1245b.d(c1250g.f10526b, 0L, j4);
                long j6 = j4;
                while (true) {
                    long j7 = 0;
                    if (j6 <= 0) {
                        return;
                    }
                    z zVar = c1250g.f10525a;
                    kotlin.jvm.internal.j.b(zVar);
                    while (true) {
                        if (j7 < 65536) {
                            j7 += (long) (zVar.f10560c - zVar.f10559b);
                            if (j7 >= j6) {
                                j7 = j6;
                            } else {
                                zVar = zVar.f10562f;
                                kotlin.jvm.internal.j.b(zVar);
                            }
                        }
                    }
                    C1246c c1246c = (C1246c) this.f10514c;
                    D d4 = (D) this.f10513b;
                    d4.f();
                    try {
                        try {
                            c1246c.c(j7, c1250g);
                            if (d4.g()) {
                                throw d4.i(null);
                            }
                            j6 -= j7;
                        } catch (IOException e) {
                            if (!d4.g()) {
                                throw e;
                            }
                            throw d4.i(e);
                        }
                    } catch (Throwable th) {
                        d4.g();
                        throw th;
                    }
                }
                break;
            default:
                AbstractC1245b.d(c1250g.f10526b, 0L, j4);
                while (j4 > 0) {
                    ((G) this.f10514c).e();
                    z zVar2 = c1250g.f10525a;
                    kotlin.jvm.internal.j.b(zVar2);
                    int iMin = (int) Math.min(j4, zVar2.f10560c - zVar2.f10559b);
                    ((OutputStream) this.f10513b).write(zVar2.f10558a, zVar2.f10559b, iMin);
                    int i = zVar2.f10559b + iMin;
                    zVar2.f10559b = i;
                    long j8 = iMin;
                    j4 -= j8;
                    c1250g.f10526b -= j8;
                    if (i == zVar2.f10560c) {
                        c1250g.f10525a = zVar2.a();
                        A.a(zVar2);
                    }
                }
                return;
        }
    }

    @Override // u5.C, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        switch (this.f10512a) {
            case 0:
                C1246c c1246c = (C1246c) this.f10514c;
                D d4 = (D) this.f10513b;
                d4.f();
                try {
                    c1246c.close();
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
                ((OutputStream) this.f10513b).close();
                return;
        }
    }

    @Override // u5.C, java.io.Flushable
    public final void flush() throws IOException {
        switch (this.f10512a) {
            case 0:
                C1246c c1246c = (C1246c) this.f10514c;
                D d4 = (D) this.f10513b;
                d4.f();
                try {
                    c1246c.flush();
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
                ((OutputStream) this.f10513b).flush();
                return;
        }
    }

    public final String toString() {
        switch (this.f10512a) {
            case 0:
                return "AsyncTimeout.sink(" + ((C1246c) this.f10514c) + ')';
            default:
                return "sink(" + ((OutputStream) this.f10513b) + ')';
        }
    }
}
