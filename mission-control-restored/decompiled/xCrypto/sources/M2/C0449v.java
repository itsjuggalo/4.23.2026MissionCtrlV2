package M2;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;

/* JADX INFO: renamed from: M2.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0449v extends AbstractC0410b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f f2650f = new a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final f f2651g = new b();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final f f2652h = new c();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final f f2653i = new d();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final g f2654j = new e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Deque f2655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Deque f2656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Queue f2658d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2659e;

    /* JADX INFO: renamed from: M2.v$a */
    public class a implements f {
        @Override // M2.C0449v.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int a(y0 y0Var, int i4, Void r32, int i5) {
            return y0Var.readUnsignedByte();
        }
    }

    /* JADX INFO: renamed from: M2.v$b */
    public class b implements f {
        @Override // M2.C0449v.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int a(y0 y0Var, int i4, Void r32, int i5) {
            y0Var.skipBytes(i4);
            return 0;
        }
    }

    /* JADX INFO: renamed from: M2.v$c */
    public class c implements f {
        @Override // M2.C0449v.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int a(y0 y0Var, int i4, byte[] bArr, int i5) {
            y0Var.z(bArr, i5, i4);
            return i5 + i4;
        }
    }

    /* JADX INFO: renamed from: M2.v$d */
    public class d implements f {
        @Override // M2.C0449v.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int a(y0 y0Var, int i4, ByteBuffer byteBuffer, int i5) {
            int iLimit = byteBuffer.limit();
            byteBuffer.limit(byteBuffer.position() + i4);
            y0Var.Z(byteBuffer);
            byteBuffer.limit(iLimit);
            return 0;
        }
    }

    /* JADX INFO: renamed from: M2.v$e */
    public class e implements g {
        @Override // M2.C0449v.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int a(y0 y0Var, int i4, OutputStream outputStream, int i5) {
            y0Var.Q(outputStream, i4);
            return 0;
        }
    }

    /* JADX INFO: renamed from: M2.v$f */
    public interface f extends g {
    }

    /* JADX INFO: renamed from: M2.v$g */
    public interface g {
        int a(y0 y0Var, int i4, Object obj, int i5);
    }

    public C0449v(int i4) {
        this.f2658d = new ArrayDeque(2);
        this.f2655a = new ArrayDeque(i4);
    }

    public final int A(g gVar, int i4, Object obj, int i5) {
        e(i4);
        if (!this.f2655a.isEmpty()) {
            p();
        }
        while (i4 > 0 && !this.f2655a.isEmpty()) {
            y0 y0Var = (y0) this.f2655a.peek();
            int iMin = Math.min(i4, y0Var.d());
            i5 = gVar.a(y0Var, iMin, obj, i5);
            i4 -= iMin;
            this.f2657c -= iMin;
            p();
        }
        if (i4 <= 0) {
            return i5;
        }
        throw new AssertionError("Failed executing read operation");
    }

    @Override // M2.AbstractC0410b, M2.y0
    public void C() {
        if (this.f2656b == null) {
            this.f2656b = new ArrayDeque(Math.min(this.f2655a.size(), 16));
        }
        while (!this.f2656b.isEmpty()) {
            ((y0) this.f2656b.remove()).close();
        }
        this.f2659e = true;
        y0 y0Var = (y0) this.f2655a.peek();
        if (y0Var != null) {
            y0Var.C();
        }
    }

    public final int E(f fVar, int i4, Object obj, int i5) {
        try {
            return A(fVar, i4, obj, i5);
        } catch (IOException e4) {
            throw new AssertionError(e4);
        }
    }

    @Override // M2.y0
    public void Q(OutputStream outputStream, int i4) {
        A(f2654j, i4, outputStream, 0);
    }

    @Override // M2.y0
    public void Z(ByteBuffer byteBuffer) {
        E(f2653i, byteBuffer.remaining(), byteBuffer, 0);
    }

    @Override // M2.AbstractC0410b, M2.y0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        while (!this.f2655a.isEmpty()) {
            ((y0) this.f2655a.remove()).close();
        }
        if (this.f2656b != null) {
            while (!this.f2656b.isEmpty()) {
                ((y0) this.f2656b.remove()).close();
            }
        }
    }

    @Override // M2.y0
    public int d() {
        return this.f2657c;
    }

    public void f(y0 y0Var) {
        boolean z4 = this.f2659e && this.f2655a.isEmpty();
        x(y0Var);
        if (z4) {
            ((y0) this.f2655a.peek()).C();
        }
    }

    public final void g() {
        if (!this.f2659e) {
            ((y0) this.f2655a.remove()).close();
            return;
        }
        this.f2656b.add((y0) this.f2655a.remove());
        y0 y0Var = (y0) this.f2655a.peek();
        if (y0Var != null) {
            y0Var.C();
        }
    }

    @Override // M2.AbstractC0410b, M2.y0
    public boolean markSupported() {
        Iterator it = this.f2655a.iterator();
        while (it.hasNext()) {
            if (!((y0) it.next()).markSupported()) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [M2.y0] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [M2.y0] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [M2.v] */
    /* JADX WARN: Type inference failed for: r1v3, types: [M2.v] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    @Override // M2.y0
    public y0 o(int i4) {
        y0 y0VarO;
        int i5;
        y0 y0VarO2;
        ?? r12;
        ?? r02;
        if (i4 <= 0) {
            return z0.a();
        }
        e(i4);
        this.f2657c -= i4;
        ?? r03 = 0;
        ?? c0449v = 0;
        while (true) {
            y0 y0Var = (y0) this.f2655a.peek();
            int iD = y0Var.d();
            if (iD > i4) {
                y0VarO2 = y0Var.o(i4);
                i5 = 0;
            } else {
                if (this.f2659e) {
                    y0VarO = y0Var.o(iD);
                    g();
                } else {
                    y0VarO = (y0) this.f2655a.poll();
                }
                y0 y0Var2 = y0VarO;
                i5 = i4 - iD;
                y0VarO2 = y0Var2;
            }
            if (r03 == 0) {
                r02 = y0VarO2;
                r12 = c0449v;
            } else {
                if (c0449v == 0) {
                    c0449v = new C0449v(i5 != 0 ? Math.min(this.f2655a.size() + 2, 16) : 2);
                    c0449v.f(r03);
                    r03 = c0449v;
                }
                c0449v.f(y0VarO2);
                r02 = r03;
                r12 = c0449v;
            }
            if (i5 <= 0) {
                return r02;
            }
            i4 = i5;
            r03 = r02;
            c0449v = r12;
        }
    }

    public final void p() {
        if (((y0) this.f2655a.peek()).d() == 0) {
            g();
        }
    }

    @Override // M2.y0
    public int readUnsignedByte() {
        return E(f2650f, 1, null, 0);
    }

    @Override // M2.AbstractC0410b, M2.y0
    public void reset() {
        if (!this.f2659e) {
            throw new InvalidMarkException();
        }
        y0 y0Var = (y0) this.f2655a.peek();
        if (y0Var != null) {
            int iD = y0Var.d();
            y0Var.reset();
            this.f2657c += y0Var.d() - iD;
        }
        while (true) {
            y0 y0Var2 = (y0) this.f2656b.pollLast();
            if (y0Var2 == null) {
                return;
            }
            y0Var2.reset();
            this.f2655a.addFirst(y0Var2);
            this.f2657c += y0Var2.d();
        }
    }

    @Override // M2.y0
    public void skipBytes(int i4) {
        E(f2651g, i4, null, 0);
    }

    public final void x(y0 y0Var) {
        if (!(y0Var instanceof C0449v)) {
            this.f2655a.add(y0Var);
            this.f2657c += y0Var.d();
            return;
        }
        C0449v c0449v = (C0449v) y0Var;
        while (!c0449v.f2655a.isEmpty()) {
            this.f2655a.add((y0) c0449v.f2655a.remove());
        }
        this.f2657c += c0449v.f2657c;
        c0449v.f2657c = 0;
        c0449v.close();
    }

    @Override // M2.y0
    public void z(byte[] bArr, int i4, int i5) {
        E(f2652h, i5, bArr, i4);
    }

    public C0449v() {
        this.f2658d = new ArrayDeque(2);
        this.f2655a = new ArrayDeque();
    }
}
