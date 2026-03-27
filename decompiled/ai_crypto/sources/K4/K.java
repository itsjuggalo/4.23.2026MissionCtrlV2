package K4;

import K4.G;
import K4.L;
import K4.M;
import V4.b;
import android.view.KeyEvent;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class K implements L.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V4.b f3538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f3539b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f3540c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final L.b f3541d = new L.b();

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3542a;

        static {
            int[] iArr = new int[G.b.values().length];
            f3542a = iArr;
            try {
                iArr[G.b.kDown.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3542a[G.b.kUp.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3542a[G.b.kRepeat.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public K(V4.b bVar) {
        this.f3538a = bVar;
        for (M.e eVar : M.a()) {
            this.f3540c.put(Long.valueOf(eVar.f3562c), eVar);
        }
    }

    public static G.b e(KeyEvent keyEvent) {
        boolean z7 = keyEvent.getRepeatCount() > 0;
        int action = keyEvent.getAction();
        if (action == 0) {
            return z7 ? G.b.kRepeat : G.b.kDown;
        }
        if (action == 1) {
            return G.b.kUp;
        }
        throw new AssertionError("Unexpected event type");
    }

    public static long j(long j7, long j8) {
        return (j7 & 4294967295L) | j8;
    }

    public static /* synthetic */ void k(L.d.a aVar, ByteBuffer byteBuffer) {
        Boolean boolValueOf = Boolean.FALSE;
        if (byteBuffer != null) {
            byteBuffer.rewind();
            if (byteBuffer.capacity() != 0) {
                boolValueOf = Boolean.valueOf(byteBuffer.get() != 0);
            }
        } else {
            J4.b.g("KeyEmbedderResponder", "A null reply was received when sending a key event to the framework.");
        }
        aVar.a(boolValueOf.booleanValue());
    }

    @Override // K4.L.d
    public void a(KeyEvent keyEvent, L.d.a aVar) {
        if (i(keyEvent, aVar)) {
            return;
        }
        q(true, 0L, 0L, 0L);
        aVar.a(true);
    }

    public final Long f(KeyEvent keyEvent) {
        Long l7 = (Long) M.f3554b.get(Long.valueOf(keyEvent.getKeyCode()));
        return l7 != null ? l7 : Long.valueOf(j(keyEvent.getKeyCode(), 73014444032L));
    }

    public final Long g(KeyEvent keyEvent) {
        long scanCode = keyEvent.getScanCode();
        if (scanCode == 0) {
            return Long.valueOf(j(keyEvent.getKeyCode(), 73014444032L));
        }
        Long l7 = (Long) M.f3553a.get(Long.valueOf(scanCode));
        return l7 != null ? l7 : Long.valueOf(j(keyEvent.getScanCode(), 73014444032L));
    }

    public Map h() {
        return Collections.unmodifiableMap(this.f3539b);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0148 A[LOOP:2: B:68:0x0142->B:70:0x0148, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean i(android.view.KeyEvent r18, K4.L.d.a r19) {
        /*
            Method dump skipped, instruction units count: 339
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: K4.K.i(android.view.KeyEvent, K4.L$d$a):boolean");
    }

    public final /* synthetic */ void l(M.c cVar, long j7, KeyEvent keyEvent) {
        q(false, Long.valueOf(cVar.f3557b), Long.valueOf(j7), keyEvent.getEventTime());
    }

    public final /* synthetic */ void m(M.c cVar, long j7, KeyEvent keyEvent) {
        q(false, Long.valueOf(cVar.f3557b), Long.valueOf(j7), keyEvent.getEventTime());
    }

    public final void n(G g7, final L.d.a aVar) {
        this.f3538a.d("flutter/keydata", g7.a(), aVar == null ? null : new b.InterfaceC0092b() { // from class: K4.H
            @Override // V4.b.InterfaceC0092b
            public final void a(ByteBuffer byteBuffer) {
                K.k(aVar, byteBuffer);
            }
        });
    }

    public void o(M.d dVar, boolean z7, long j7, final long j8, final KeyEvent keyEvent, ArrayList arrayList) {
        M.c[] cVarArr = dVar.f3559b;
        boolean[] zArr = new boolean[cVarArr.length];
        Boolean[] boolArr = new Boolean[cVarArr.length];
        int i7 = 0;
        boolean z8 = false;
        while (true) {
            M.c[] cVarArr2 = dVar.f3559b;
            boolean z9 = true;
            if (i7 >= cVarArr2.length) {
                break;
            }
            final M.c cVar = cVarArr2[i7];
            boolean zContainsKey = this.f3539b.containsKey(Long.valueOf(cVar.f3556a));
            zArr[i7] = zContainsKey;
            if (cVar.f3557b == j7) {
                int i8 = a.f3542a[e(keyEvent).ordinal()];
                if (i8 != 1) {
                    if (i8 == 2) {
                        boolArr[i7] = Boolean.valueOf(zArr[i7]);
                    } else if (i8 == 3) {
                        if (!z7) {
                            arrayList.add(new Runnable() { // from class: K4.J
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f3534a.m(cVar, j8, keyEvent);
                                }
                            });
                        }
                        boolArr[i7] = Boolean.valueOf(zArr[i7]);
                    }
                    i7++;
                } else {
                    boolArr[i7] = Boolean.FALSE;
                    if (!z7) {
                        arrayList.add(new Runnable() { // from class: K4.I
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f3530a.l(cVar, j8, keyEvent);
                            }
                        });
                    }
                }
            } else if (!z8 && !zContainsKey) {
                z9 = false;
            }
            z8 = z9;
            i7++;
        }
        if (z7) {
            for (int i9 = 0; i9 < dVar.f3559b.length; i9++) {
                if (boolArr[i9] == null) {
                    if (z8) {
                        boolArr[i9] = Boolean.valueOf(zArr[i9]);
                    } else {
                        boolArr[i9] = Boolean.TRUE;
                        z8 = true;
                    }
                }
            }
            if (!z8) {
                boolArr[0] = Boolean.TRUE;
            }
        } else {
            for (int i10 = 0; i10 < dVar.f3559b.length; i10++) {
                if (boolArr[i10] == null) {
                    boolArr[i10] = Boolean.FALSE;
                }
            }
        }
        for (int i11 = 0; i11 < dVar.f3559b.length; i11++) {
            if (zArr[i11] != boolArr[i11].booleanValue()) {
                M.c cVar2 = dVar.f3559b[i11];
                q(boolArr[i11].booleanValue(), Long.valueOf(cVar2.f3557b), Long.valueOf(cVar2.f3556a), keyEvent.getEventTime());
            }
        }
    }

    public void p(M.e eVar, boolean z7, long j7, KeyEvent keyEvent) {
        if (eVar.f3562c == j7 || eVar.f3563d == z7) {
            return;
        }
        boolean zContainsKey = this.f3539b.containsKey(Long.valueOf(eVar.f3561b));
        boolean z8 = !zContainsKey;
        if (!zContainsKey) {
            eVar.f3563d = !eVar.f3563d;
        }
        q(z8, Long.valueOf(eVar.f3562c), Long.valueOf(eVar.f3561b), keyEvent.getEventTime());
        if (zContainsKey) {
            eVar.f3563d = !eVar.f3563d;
        }
        q(zContainsKey, Long.valueOf(eVar.f3562c), Long.valueOf(eVar.f3561b), keyEvent.getEventTime());
    }

    public final void q(boolean z7, Long l7, Long l8, long j7) {
        G g7 = new G();
        g7.f3510a = j7;
        g7.f3511b = z7 ? G.b.kDown : G.b.kUp;
        g7.f3513d = l7.longValue();
        g7.f3512c = l8.longValue();
        g7.f3516g = null;
        g7.f3514e = true;
        g7.f3515f = G.a.kKeyboard;
        if (l8.longValue() != 0 && l7.longValue() != 0) {
            if (!z7) {
                l7 = null;
            }
            r(l8, l7);
        }
        n(g7, null);
    }

    public void r(Long l7, Long l8) {
        if (l8 != null) {
            if (((Long) this.f3539b.put(l7, l8)) != null) {
                throw new AssertionError("The key was not empty");
            }
        } else if (((Long) this.f3539b.remove(l7)) == null) {
            throw new AssertionError("The key was empty");
        }
    }
}
