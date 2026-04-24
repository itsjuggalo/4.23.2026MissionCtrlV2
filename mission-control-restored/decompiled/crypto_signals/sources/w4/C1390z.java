package w4;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;
import java.util.ArrayDeque;
import java.util.Iterator;

/* JADX INFO: renamed from: w4.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1390z extends AbstractC1322c {
    public static final c2 e = new c2(2);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c2 f11427f = new c2(3);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final c2 f11428k = new c2(4);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final c2 f11429l = new c2(5);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final c2 f11430m = new c2(6);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayDeque f11431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayDeque f11432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11433c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f11434d;

    public C1390z() {
        new ArrayDeque(2);
        this.f11431a = new ArrayDeque();
    }

    @Override // w4.AbstractC1322c, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        while (true) {
            ArrayDeque arrayDeque = this.f11431a;
            if (arrayDeque.isEmpty()) {
                break;
            } else {
                ((AbstractC1322c) arrayDeque.remove()).close();
            }
        }
        if (this.f11432b != null) {
            while (!this.f11432b.isEmpty()) {
                ((AbstractC1322c) this.f11432b.remove()).close();
            }
        }
    }

    @Override // w4.AbstractC1322c
    public final void f() throws IOException {
        ArrayDeque arrayDeque = this.f11432b;
        ArrayDeque arrayDeque2 = this.f11431a;
        if (arrayDeque == null) {
            this.f11432b = new ArrayDeque(Math.min(arrayDeque2.size(), 16));
        }
        while (!this.f11432b.isEmpty()) {
            ((AbstractC1322c) this.f11432b.remove()).close();
        }
        this.f11434d = true;
        AbstractC1322c abstractC1322c = (AbstractC1322c) arrayDeque2.peek();
        if (abstractC1322c != null) {
            abstractC1322c.f();
        }
    }

    @Override // w4.AbstractC1322c
    public final boolean g() {
        Iterator it = this.f11431a.iterator();
        while (it.hasNext()) {
            if (!((AbstractC1322c) it.next()).g()) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [w4.c] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [w4.c] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [w4.z] */
    /* JADX WARN: Type inference failed for: r1v3, types: [w4.z] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    @Override // w4.AbstractC1322c
    public final AbstractC1322c h(int i) throws IOException {
        AbstractC1322c abstractC1322cH;
        int i6;
        AbstractC1322c abstractC1322cH2;
        ?? r12;
        ?? r02;
        if (i <= 0) {
            return AbstractC1380v1.f11412a;
        }
        d(i);
        this.f11433c -= i;
        ?? r03 = 0;
        ?? c1390z = 0;
        while (true) {
            ArrayDeque arrayDeque = this.f11431a;
            AbstractC1322c abstractC1322c = (AbstractC1322c) arrayDeque.peek();
            int iM = abstractC1322c.m();
            if (iM > i) {
                abstractC1322cH2 = abstractC1322c.h(i);
                i6 = 0;
            } else {
                if (this.f11434d) {
                    abstractC1322cH = abstractC1322c.h(iM);
                    q();
                } else {
                    abstractC1322cH = (AbstractC1322c) arrayDeque.poll();
                }
                AbstractC1322c abstractC1322c2 = abstractC1322cH;
                i6 = i - iM;
                abstractC1322cH2 = abstractC1322c2;
            }
            if (r03 == 0) {
                r02 = abstractC1322cH2;
                r12 = c1390z;
            } else {
                if (c1390z == 0) {
                    c1390z = new C1390z(i6 != 0 ? Math.min(arrayDeque.size() + 2, 16) : 2);
                    c1390z.p(r03);
                    r03 = c1390z;
                }
                c1390z.p(abstractC1322cH2);
                r02 = r03;
                r12 = c1390z;
            }
            if (i6 <= 0) {
                return r02;
            }
            i = i6;
            r03 = r02;
            c1390z = r12;
        }
    }

    @Override // w4.AbstractC1322c
    public final void i(OutputStream outputStream, int i) throws IOException {
        r(f11430m, i, outputStream, 0);
    }

    @Override // w4.AbstractC1322c
    public final void j(ByteBuffer byteBuffer) {
        s(f11429l, byteBuffer.remaining(), byteBuffer, 0);
    }

    @Override // w4.AbstractC1322c
    public final void k(byte[] bArr, int i, int i6) {
        s(f11428k, i6, bArr, i);
    }

    @Override // w4.AbstractC1322c
    public final int l() {
        return s(e, 1, null, 0);
    }

    @Override // w4.AbstractC1322c
    public final int m() {
        return this.f11433c;
    }

    @Override // w4.AbstractC1322c
    public final void n() {
        if (!this.f11434d) {
            throw new InvalidMarkException();
        }
        ArrayDeque arrayDeque = this.f11431a;
        AbstractC1322c abstractC1322c = (AbstractC1322c) arrayDeque.peek();
        if (abstractC1322c != null) {
            int iM = abstractC1322c.m();
            abstractC1322c.n();
            this.f11433c = (abstractC1322c.m() - iM) + this.f11433c;
        }
        while (true) {
            AbstractC1322c abstractC1322c2 = (AbstractC1322c) this.f11432b.pollLast();
            if (abstractC1322c2 == null) {
                return;
            }
            abstractC1322c2.n();
            arrayDeque.addFirst(abstractC1322c2);
            this.f11433c = abstractC1322c2.m() + this.f11433c;
        }
    }

    @Override // w4.AbstractC1322c
    public final void o(int i) {
        s(f11427f, i, null, 0);
    }

    public final void p(AbstractC1322c abstractC1322c) throws IOException {
        boolean z6 = this.f11434d;
        ArrayDeque arrayDeque = this.f11431a;
        boolean z7 = z6 && arrayDeque.isEmpty();
        if (abstractC1322c instanceof C1390z) {
            C1390z c1390z = (C1390z) abstractC1322c;
            while (!c1390z.f11431a.isEmpty()) {
                arrayDeque.add((AbstractC1322c) c1390z.f11431a.remove());
            }
            this.f11433c += c1390z.f11433c;
            c1390z.f11433c = 0;
            c1390z.close();
        } else {
            arrayDeque.add(abstractC1322c);
            this.f11433c = abstractC1322c.m() + this.f11433c;
        }
        if (z7) {
            ((AbstractC1322c) arrayDeque.peek()).f();
        }
    }

    public final void q() throws IOException {
        boolean z6 = this.f11434d;
        ArrayDeque arrayDeque = this.f11431a;
        if (!z6) {
            ((AbstractC1322c) arrayDeque.remove()).close();
            return;
        }
        this.f11432b.add((AbstractC1322c) arrayDeque.remove());
        AbstractC1322c abstractC1322c = (AbstractC1322c) arrayDeque.peek();
        if (abstractC1322c != null) {
            abstractC1322c.f();
        }
    }

    public final int r(InterfaceC1387y interfaceC1387y, int i, Object obj, int i6) throws IOException {
        d(i);
        ArrayDeque arrayDeque = this.f11431a;
        if (!arrayDeque.isEmpty() && ((AbstractC1322c) arrayDeque.peek()).m() == 0) {
            q();
        }
        while (i > 0 && !arrayDeque.isEmpty()) {
            AbstractC1322c abstractC1322c = (AbstractC1322c) arrayDeque.peek();
            int iMin = Math.min(i, abstractC1322c.m());
            i6 = interfaceC1387y.b(abstractC1322c, iMin, obj, i6);
            i -= iMin;
            this.f11433c -= iMin;
            if (((AbstractC1322c) arrayDeque.peek()).m() == 0) {
                q();
            }
        }
        if (i <= 0) {
            return i6;
        }
        throw new AssertionError("Failed executing read operation");
    }

    public final int s(c2 c2Var, int i, Object obj, int i6) {
        try {
            return r(c2Var, i, obj, i6);
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public C1390z(int i) {
        new ArrayDeque(2);
        this.f11431a = new ArrayDeque(i);
    }
}
