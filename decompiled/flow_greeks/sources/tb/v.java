package tb;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class v extends tb.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f f21769f = new a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final f f21770g = new b();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final f f21771h = new c();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final f f21772i = new d();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final g f21773j = new e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Deque f21774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Deque f21775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f21776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Queue f21777d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f21778e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements f {
        @Override // tb.v.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int a(x1 x1Var, int i10, Void r32, int i11) {
            return x1Var.readUnsignedByte();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements f {
        @Override // tb.v.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int a(x1 x1Var, int i10, Void r32, int i11) {
            x1Var.skipBytes(i10);
            return 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c implements f {
        @Override // tb.v.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int a(x1 x1Var, int i10, byte[] bArr, int i11) {
            x1Var.z(bArr, i11, i10);
            return i11 + i10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class d implements f {
        @Override // tb.v.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int a(x1 x1Var, int i10, ByteBuffer byteBuffer, int i11) {
            int iLimit = byteBuffer.limit();
            byteBuffer.limit(byteBuffer.position() + i10);
            x1Var.W(byteBuffer);
            byteBuffer.limit(iLimit);
            return 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class e implements g {
        @Override // tb.v.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int a(x1 x1Var, int i10, OutputStream outputStream, int i11) {
            x1Var.P(outputStream, i10);
            return 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface f extends g {
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface g {
        int a(x1 x1Var, int i10, Object obj, int i11);
    }

    public v(int i10) {
        this.f21777d = new ArrayDeque(2);
        this.f21774a = new ArrayDeque(i10);
    }

    public final int C(g gVar, int i10, Object obj, int i11) {
        b(i10);
        if (!this.f21774a.isEmpty()) {
            o();
        }
        while (i10 > 0 && !this.f21774a.isEmpty()) {
            x1 x1Var = (x1) this.f21774a.peek();
            int iMin = Math.min(i10, x1Var.d());
            i11 = gVar.a(x1Var, iMin, obj, i11);
            i10 -= iMin;
            this.f21776c -= iMin;
            o();
        }
        if (i10 <= 0) {
            return i11;
        }
        throw new AssertionError("Failed executing read operation");
    }

    @Override // tb.b, tb.x1
    public void D() {
        if (this.f21775b == null) {
            this.f21775b = new ArrayDeque(Math.min(this.f21774a.size(), 16));
        }
        while (!this.f21775b.isEmpty()) {
            ((x1) this.f21775b.remove()).close();
        }
        this.f21778e = true;
        x1 x1Var = (x1) this.f21774a.peek();
        if (x1Var != null) {
            x1Var.D();
        }
    }

    public final int E(f fVar, int i10, Object obj, int i11) {
        try {
            return C(fVar, i10, obj, i11);
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }

    @Override // tb.x1
    public void P(OutputStream outputStream, int i10) {
        C(f21773j, i10, outputStream, 0);
    }

    @Override // tb.x1
    public void W(ByteBuffer byteBuffer) {
        E(f21772i, byteBuffer.remaining(), byteBuffer, 0);
    }

    public void c(x1 x1Var) {
        boolean z10 = this.f21778e && this.f21774a.isEmpty();
        u(x1Var);
        if (z10) {
            ((x1) this.f21774a.peek()).D();
        }
    }

    @Override // tb.b, tb.x1, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        while (!this.f21774a.isEmpty()) {
            ((x1) this.f21774a.remove()).close();
        }
        if (this.f21775b != null) {
            while (!this.f21775b.isEmpty()) {
                ((x1) this.f21775b.remove()).close();
            }
        }
    }

    @Override // tb.x1
    public int d() {
        return this.f21776c;
    }

    public final void e() {
        if (!this.f21778e) {
            ((x1) this.f21774a.remove()).close();
            return;
        }
        this.f21775b.add((x1) this.f21774a.remove());
        x1 x1Var = (x1) this.f21774a.peek();
        if (x1Var != null) {
            x1Var.D();
        }
    }

    @Override // tb.b, tb.x1
    public boolean markSupported() {
        Iterator it = this.f21774a.iterator();
        while (it.hasNext()) {
            if (!((x1) it.next()).markSupported()) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [tb.x1] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [tb.x1] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [tb.v] */
    /* JADX WARN: Type inference failed for: r1v3, types: [tb.v] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    @Override // tb.x1
    public x1 n(int i10) {
        x1 x1VarN;
        int i11;
        x1 x1VarN2;
        ?? r12;
        ?? r02;
        if (i10 <= 0) {
            return y1.a();
        }
        b(i10);
        this.f21776c -= i10;
        ?? r03 = 0;
        ?? vVar = 0;
        while (true) {
            x1 x1Var = (x1) this.f21774a.peek();
            int iD = x1Var.d();
            if (iD > i10) {
                x1VarN2 = x1Var.n(i10);
                i11 = 0;
            } else {
                if (this.f21778e) {
                    x1VarN = x1Var.n(iD);
                    e();
                } else {
                    x1VarN = (x1) this.f21774a.poll();
                }
                x1 x1Var2 = x1VarN;
                i11 = i10 - iD;
                x1VarN2 = x1Var2;
            }
            if (r03 == 0) {
                r02 = x1VarN2;
                r12 = vVar;
            } else {
                if (vVar == 0) {
                    vVar = new v(i11 != 0 ? Math.min(this.f21774a.size() + 2, 16) : 2);
                    vVar.c(r03);
                    r03 = vVar;
                }
                vVar.c(x1VarN2);
                r02 = r03;
                r12 = vVar;
            }
            if (i11 <= 0) {
                return r02;
            }
            i10 = i11;
            r03 = r02;
            vVar = r12;
        }
    }

    public final void o() {
        if (((x1) this.f21774a.peek()).d() == 0) {
            e();
        }
    }

    @Override // tb.x1
    public int readUnsignedByte() {
        return E(f21769f, 1, null, 0);
    }

    @Override // tb.b, tb.x1
    public void reset() {
        if (!this.f21778e) {
            throw new InvalidMarkException();
        }
        x1 x1Var = (x1) this.f21774a.peek();
        if (x1Var != null) {
            int iD = x1Var.d();
            x1Var.reset();
            this.f21776c += x1Var.d() - iD;
        }
        while (true) {
            x1 x1Var2 = (x1) this.f21775b.pollLast();
            if (x1Var2 == null) {
                return;
            }
            x1Var2.reset();
            this.f21774a.addFirst(x1Var2);
            this.f21776c += x1Var2.d();
        }
    }

    @Override // tb.x1
    public void skipBytes(int i10) {
        E(f21770g, i10, null, 0);
    }

    public final void u(x1 x1Var) {
        if (!(x1Var instanceof v)) {
            this.f21774a.add(x1Var);
            this.f21776c += x1Var.d();
            return;
        }
        v vVar = (v) x1Var;
        while (!vVar.f21774a.isEmpty()) {
            this.f21774a.add((x1) vVar.f21774a.remove());
        }
        this.f21776c += vVar.f21776c;
        vVar.f21776c = 0;
        vVar.close();
    }

    @Override // tb.x1
    public void z(byte[] bArr, int i10, int i11) {
        E(f21771h, i11, bArr, i10);
    }

    public v() {
        this.f21777d = new ArrayDeque(2);
        this.f21774a = new ArrayDeque();
    }
}
