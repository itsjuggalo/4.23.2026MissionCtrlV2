package O;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import w4.C1327d1;

/* JADX INFO: loaded from: classes.dex */
public final class E0 extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f2093b;

    public /* synthetic */ E0(Object obj, int i) {
        this.f2092a = i;
        this.f2093b = obj;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        switch (this.f2092a) {
            case 0:
                break;
            case 1:
                ((u5.w) this.f2093b).close();
                break;
            default:
                super.close();
                break;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        switch (this.f2092a) {
            case 0:
                ((FileOutputStream) this.f2093b).flush();
                break;
            case 1:
                u5.w wVar = (u5.w) this.f2093b;
                if (!wVar.f10553c) {
                    wVar.flush();
                }
                break;
            default:
                super.flush();
                break;
        }
    }

    public String toString() {
        switch (this.f2092a) {
            case 1:
                return ((u5.w) this.f2093b) + ".outputStream()";
            default:
                return super.toString();
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] b3) throws IOException {
        switch (this.f2092a) {
            case 0:
                kotlin.jvm.internal.j.e(b3, "b");
                ((FileOutputStream) this.f2093b).write(b3);
                break;
            default:
                super.write(b3);
                break;
        }
    }

    public E0(FileOutputStream fileOutputStream) {
        this.f2092a = 0;
        this.f2093b = fileOutputStream;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bytes, int i, int i6) throws IOException {
        switch (this.f2092a) {
            case 0:
                kotlin.jvm.internal.j.e(bytes, "bytes");
                ((FileOutputStream) this.f2093b).write(bytes, i, i6);
                return;
            case 1:
                kotlin.jvm.internal.j.e(bytes, "data");
                u5.w wVar = (u5.w) this.f2093b;
                if (wVar.f10553c) {
                    throw new IOException("closed");
                }
                wVar.f10552b.z(bytes, i, i6);
                wVar.d();
                return;
            default:
                ((C1327d1) this.f2093b).h(bytes, i, i6);
                return;
        }
    }

    @Override // java.io.OutputStream
    public final void write(int i) throws IOException {
        Object obj = this.f2093b;
        switch (this.f2092a) {
            case 0:
                ((FileOutputStream) obj).write(i);
                return;
            case 1:
                u5.w wVar = (u5.w) obj;
                if (!wVar.f10553c) {
                    wVar.f10552b.B((byte) i);
                    wVar.d();
                    return;
                }
                throw new IOException("closed");
            default:
                write(new byte[]{(byte) i}, 0, 1);
                return;
        }
    }

    private final void d() {
    }
}
