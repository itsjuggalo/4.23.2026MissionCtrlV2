package t5;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;

/* JADX INFO: renamed from: t5.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C2704v extends AbstractC2665b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f f24201f = new a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final f f24202g = new b();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final f f24203h = new c();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final f f24204i = new d();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final g f24205j = new e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Deque f24206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Deque f24207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f24208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Queue f24209d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f24210e;

    /* JADX INFO: renamed from: t5.v$a */
    public class a implements f {
        @Override // t5.C2704v.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int a(y0 y0Var, int i7, Void r32, int i8) {
            return y0Var.readUnsignedByte();
        }
    }

    /* JADX INFO: renamed from: t5.v$b */
    public class b implements f {
        @Override // t5.C2704v.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int a(y0 y0Var, int i7, Void r32, int i8) {
            y0Var.skipBytes(i7);
            return 0;
        }
    }

    /* JADX INFO: renamed from: t5.v$c */
    public class c implements f {
        @Override // t5.C2704v.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int a(y0 y0Var, int i7, byte[] bArr, int i8) {
            y0Var.J(bArr, i8, i7);
            return i8 + i7;
        }
    }

    /* JADX INFO: renamed from: t5.v$d */
    public class d implements f {
        @Override // t5.C2704v.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int a(y0 y0Var, int i7, ByteBuffer byteBuffer, int i8) {
            int iLimit = byteBuffer.limit();
            byteBuffer.limit(byteBuffer.position() + i7);
            y0Var.p0(byteBuffer);
            byteBuffer.limit(iLimit);
            return 0;
        }
    }

    /* JADX INFO: renamed from: t5.v$e */
    public class e implements g {
        @Override // t5.C2704v.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int a(y0 y0Var, int i7, OutputStream outputStream, int i8) {
            y0Var.f0(outputStream, i7);
            return 0;
        }
    }

    /* JADX INFO: renamed from: t5.v$f */
    public interface f extends g {
    }

    /* JADX INFO: renamed from: t5.v$g */
    public interface g {
        int a(y0 y0Var, int i7, Object obj, int i8);
    }

    public C2704v(int i7) {
        this.f24209d = new ArrayDeque(2);
        this.f24206a = new ArrayDeque(i7);
    }

    public final void A() {
        if (!this.f24210e) {
            ((y0) this.f24206a.remove()).close();
            return;
        }
        this.f24207b.add((y0) this.f24206a.remove());
        y0 y0Var = (y0) this.f24206a.peek();
        if (y0Var != null) {
            y0Var.Q();
        }
    }

    public final void G() {
        if (((y0) this.f24206a.peek()).e() == 0) {
            A();
        }
    }

    public final void H(y0 y0Var) {
        if (!(y0Var instanceof C2704v)) {
            this.f24206a.add(y0Var);
            this.f24208c += y0Var.e();
            return;
        }
        C2704v c2704v = (C2704v) y0Var;
        while (!c2704v.f24206a.isEmpty()) {
            this.f24206a.add((y0) c2704v.f24206a.remove());
        }
        this.f24208c += c2704v.f24208c;
        c2704v.f24208c = 0;
        c2704v.close();
    }

    @Override // t5.y0
    public void J(byte[] bArr, int i7, int i8) {
        M(f24203h, i8, bArr, i7);
    }

    public final int K(g gVar, int i7, Object obj, int i8) {
        h(i7);
        if (!this.f24206a.isEmpty()) {
            G();
        }
        while (i7 > 0 && !this.f24206a.isEmpty()) {
            y0 y0Var = (y0) this.f24206a.peek();
            int iMin = Math.min(i7, y0Var.e());
            i8 = gVar.a(y0Var, iMin, obj, i8);
            i7 -= iMin;
            this.f24208c -= iMin;
            G();
        }
        if (i7 <= 0) {
            return i8;
        }
        throw new AssertionError("Failed executing read operation");
    }

    public final int M(f fVar, int i7, Object obj, int i8) {
        try {
            return K(fVar, i7, obj, i8);
        } catch (IOException e7) {
            throw new AssertionError(e7);
        }
    }

    @Override // t5.AbstractC2665b, t5.y0
    public void Q() {
        if (this.f24207b == null) {
            this.f24207b = new ArrayDeque(Math.min(this.f24206a.size(), 16));
        }
        while (!this.f24207b.isEmpty()) {
            ((y0) this.f24207b.remove()).close();
        }
        this.f24210e = true;
        y0 y0Var = (y0) this.f24206a.peek();
        if (y0Var != null) {
            y0Var.Q();
        }
    }

    @Override // t5.AbstractC2665b, t5.y0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        while (!this.f24206a.isEmpty()) {
            ((y0) this.f24206a.remove()).close();
        }
        if (this.f24207b != null) {
            while (!this.f24207b.isEmpty()) {
                ((y0) this.f24207b.remove()).close();
            }
        }
    }

    @Override // t5.y0
    public int e() {
        return this.f24208c;
    }

    @Override // t5.y0
    public void f0(OutputStream outputStream, int i7) {
        K(f24205j, i7, outputStream, 0);
    }

    public void i(y0 y0Var) {
        boolean z7 = this.f24210e && this.f24206a.isEmpty();
        H(y0Var);
        if (z7) {
            ((y0) this.f24206a.peek()).Q();
        }
    }

    @Override // t5.AbstractC2665b, t5.y0
    public boolean markSupported() {
        Iterator it = this.f24206a.iterator();
        while (it.hasNext()) {
            if (!((y0) it.next()).markSupported()) {
                return false;
            }
        }
        return true;
    }

    @Override // t5.y0
    public void p0(ByteBuffer byteBuffer) {
        M(f24204i, byteBuffer.remaining(), byteBuffer, 0);
    }

    @Override // t5.y0
    public int readUnsignedByte() {
        return M(f24201f, 1, null, 0);
    }

    @Override // t5.AbstractC2665b, t5.y0
    public void reset() {
        if (!this.f24210e) {
            throw new InvalidMarkException();
        }
        y0 y0Var = (y0) this.f24206a.peek();
        if (y0Var != null) {
            int iE = y0Var.e();
            y0Var.reset();
            this.f24208c += y0Var.e() - iE;
        }
        while (true) {
            y0 y0Var2 = (y0) this.f24207b.pollLast();
            if (y0Var2 == null) {
                return;
            }
            y0Var2.reset();
            this.f24206a.addFirst(y0Var2);
            this.f24208c += y0Var2.e();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [t5.y0] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [t5.y0] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [t5.v] */
    /* JADX WARN: Type inference failed for: r1v3, types: [t5.v] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    @Override // t5.y0
    public y0 s(int i7) {
        y0 y0VarS;
        int i8;
        y0 y0VarS2;
        ?? r12;
        ?? r02;
        if (i7 <= 0) {
            return z0.a();
        }
        h(i7);
        this.f24208c -= i7;
        ?? r03 = 0;
        ?? c2704v = 0;
        while (true) {
            y0 y0Var = (y0) this.f24206a.peek();
            int iE = y0Var.e();
            if (iE > i7) {
                y0VarS2 = y0Var.s(i7);
                i8 = 0;
            } else {
                if (this.f24210e) {
                    y0VarS = y0Var.s(iE);
                    A();
                } else {
                    y0VarS = (y0) this.f24206a.poll();
                }
                y0 y0Var2 = y0VarS;
                i8 = i7 - iE;
                y0VarS2 = y0Var2;
            }
            if (r03 == 0) {
                r02 = y0VarS2;
                r12 = c2704v;
            } else {
                if (c2704v == 0) {
                    c2704v = new C2704v(i8 != 0 ? Math.min(this.f24206a.size() + 2, 16) : 2);
                    c2704v.i(r03);
                    r03 = c2704v;
                }
                c2704v.i(y0VarS2);
                r02 = r03;
                r12 = c2704v;
            }
            if (i8 <= 0) {
                return r02;
            }
            i7 = i8;
            r03 = r02;
            c2704v = r12;
        }
    }

    @Override // t5.y0
    public void skipBytes(int i7) {
        M(f24202g, i7, null, 0);
    }

    public C2704v() {
        this.f24209d = new ArrayDeque(2);
        this.f24206a = new ArrayDeque();
    }
}
