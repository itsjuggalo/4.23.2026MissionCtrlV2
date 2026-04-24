package G4;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;

/* JADX INFO: renamed from: G4.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C0557v extends AbstractC0518b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f f3228f = new a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final f f3229g = new b();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final f f3230h = new c();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final f f3231i = new d();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final g f3232j = new e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Deque f3233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Deque f3234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Queue f3236d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f3237e;

    /* JADX INFO: renamed from: G4.v$a */
    public class a implements f {
        @Override // G4.C0557v.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int a(y0 y0Var, int i8, Void r32, int i9) {
            return y0Var.readUnsignedByte();
        }
    }

    /* JADX INFO: renamed from: G4.v$b */
    public class b implements f {
        @Override // G4.C0557v.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int a(y0 y0Var, int i8, Void r32, int i9) {
            y0Var.skipBytes(i8);
            return 0;
        }
    }

    /* JADX INFO: renamed from: G4.v$c */
    public class c implements f {
        @Override // G4.C0557v.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int a(y0 y0Var, int i8, byte[] bArr, int i9) {
            y0Var.J(bArr, i9, i8);
            return i9 + i8;
        }
    }

    /* JADX INFO: renamed from: G4.v$d */
    public class d implements f {
        @Override // G4.C0557v.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int a(y0 y0Var, int i8, ByteBuffer byteBuffer, int i9) {
            int iLimit = byteBuffer.limit();
            byteBuffer.limit(byteBuffer.position() + i8);
            y0Var.p0(byteBuffer);
            byteBuffer.limit(iLimit);
            return 0;
        }
    }

    /* JADX INFO: renamed from: G4.v$e */
    public class e implements g {
        @Override // G4.C0557v.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int a(y0 y0Var, int i8, OutputStream outputStream, int i9) {
            y0Var.e0(outputStream, i8);
            return 0;
        }
    }

    /* JADX INFO: renamed from: G4.v$f */
    public interface f extends g {
    }

    /* JADX INFO: renamed from: G4.v$g */
    public interface g {
        int a(y0 y0Var, int i8, Object obj, int i9);
    }

    public C0557v() {
        this.f3236d = new ArrayDeque(2);
        this.f3233a = new ArrayDeque();
    }

    public final int B(f fVar, int i8, Object obj, int i9) {
        try {
            return r(fVar, i8, obj, i9);
        } catch (IOException e8) {
            throw new AssertionError(e8);
        }
    }

    @Override // G4.y0
    public void J(byte[] bArr, int i8, int i9) {
        B(f3230h, i9, bArr, i8);
    }

    @Override // G4.AbstractC0518b, G4.y0
    public void P() {
        if (this.f3234b == null) {
            this.f3234b = new ArrayDeque(Math.min(this.f3233a.size(), 16));
        }
        while (!this.f3234b.isEmpty()) {
            ((y0) this.f3234b.remove()).close();
        }
        this.f3237e = true;
        y0 y0Var = (y0) this.f3233a.peek();
        if (y0Var != null) {
            y0Var.P();
        }
    }

    public void c(y0 y0Var) {
        boolean z7 = this.f3237e && this.f3233a.isEmpty();
        n(y0Var);
        if (z7) {
            ((y0) this.f3233a.peek()).P();
        }
    }

    @Override // G4.AbstractC0518b, G4.y0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        while (!this.f3233a.isEmpty()) {
            ((y0) this.f3233a.remove()).close();
        }
        if (this.f3234b != null) {
            while (!this.f3234b.isEmpty()) {
                ((y0) this.f3234b.remove()).close();
            }
        }
    }

    @Override // G4.y0
    public int d() {
        return this.f3235c;
    }

    public final void e() {
        if (!this.f3237e) {
            ((y0) this.f3233a.remove()).close();
            return;
        }
        this.f3234b.add((y0) this.f3233a.remove());
        y0 y0Var = (y0) this.f3233a.peek();
        if (y0Var != null) {
            y0Var.P();
        }
    }

    @Override // G4.y0
    public void e0(OutputStream outputStream, int i8) {
        r(f3232j, i8, outputStream, 0);
    }

    public final void f() {
        if (((y0) this.f3233a.peek()).d() == 0) {
            e();
        }
    }

    @Override // G4.AbstractC0518b, G4.y0
    public boolean markSupported() {
        Iterator it = this.f3233a.iterator();
        while (it.hasNext()) {
            if (!((y0) it.next()).markSupported()) {
                return false;
            }
        }
        return true;
    }

    public final void n(y0 y0Var) {
        if (!(y0Var instanceof C0557v)) {
            this.f3233a.add(y0Var);
            this.f3235c += y0Var.d();
            return;
        }
        C0557v c0557v = (C0557v) y0Var;
        while (!c0557v.f3233a.isEmpty()) {
            this.f3233a.add((y0) c0557v.f3233a.remove());
        }
        this.f3235c += c0557v.f3235c;
        c0557v.f3235c = 0;
        c0557v.close();
    }

    @Override // G4.y0
    public void p0(ByteBuffer byteBuffer) {
        B(f3231i, byteBuffer.remaining(), byteBuffer, 0);
    }

    public final int r(g gVar, int i8, Object obj, int i9) {
        a(i8);
        if (this.f3233a.isEmpty()) {
            f();
            while (i8 > 0 && !this.f3233a.isEmpty()) {
                y0 y0Var = (y0) this.f3233a.peek();
                int iMin = Math.min(i8, y0Var.d());
                i9 = gVar.a(y0Var, iMin, obj, i9);
                i8 -= iMin;
                this.f3235c -= iMin;
            }
            if (i8 <= 0) {
                return i9;
            }
            throw new AssertionError("Failed executing read operation");
        }
        f();
    }

    @Override // G4.y0
    public int readUnsignedByte() {
        return B(f3228f, 1, null, 0);
    }

    @Override // G4.AbstractC0518b, G4.y0
    public void reset() {
        if (!this.f3237e) {
            throw new InvalidMarkException();
        }
        y0 y0Var = (y0) this.f3233a.peek();
        if (y0Var != null) {
            int iD = y0Var.d();
            y0Var.reset();
            this.f3235c += y0Var.d() - iD;
        }
        while (true) {
            y0 y0Var2 = (y0) this.f3234b.pollLast();
            if (y0Var2 == null) {
                return;
            }
            y0Var2.reset();
            this.f3233a.addFirst(y0Var2);
            this.f3235c += y0Var2.d();
        }
    }

    @Override // G4.y0
    public void skipBytes(int i8) {
        B(f3229g, i8, null, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [G4.y0] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [G4.y0] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [G4.v] */
    /* JADX WARN: Type inference failed for: r1v3, types: [G4.v] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    @Override // G4.y0
    public y0 t(int i8) {
        y0 y0VarT;
        int i9;
        y0 y0VarT2;
        ?? r12;
        ?? r02;
        if (i8 <= 0) {
            return z0.a();
        }
        a(i8);
        this.f3235c -= i8;
        ?? r03 = 0;
        ?? c0557v = 0;
        while (true) {
            y0 y0Var = (y0) this.f3233a.peek();
            int iD = y0Var.d();
            if (iD > i8) {
                y0VarT2 = y0Var.t(i8);
                i9 = 0;
            } else {
                if (this.f3237e) {
                    y0VarT = y0Var.t(iD);
                    e();
                } else {
                    y0VarT = (y0) this.f3233a.poll();
                }
                y0 y0Var2 = y0VarT;
                i9 = i8 - iD;
                y0VarT2 = y0Var2;
            }
            if (r03 == 0) {
                r02 = y0VarT2;
                r12 = c0557v;
            } else {
                if (c0557v == 0) {
                    c0557v = new C0557v(i9 != 0 ? Math.min(this.f3233a.size() + 2, 16) : 2);
                    c0557v.c(r03);
                    r03 = c0557v;
                }
                c0557v.c(y0VarT2);
                r02 = r03;
                r12 = c0557v;
            }
            if (i9 <= 0) {
                return r02;
            }
            i8 = i9;
            r03 = r02;
            c0557v = r12;
        }
    }

    public C0557v(int i8) {
        this.f3236d = new ArrayDeque(2);
        this.f3233a = new ArrayDeque(i8);
    }
}
